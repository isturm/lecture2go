package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import de.uhh.l2g.plugins.model.*;
import de.uhh.l2g.plugins.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl;

@Component(immediate = true, service = Indexer.class)
public class VideoIndexer extends BaseIndexer<Video> {
	private static final Log log = LogFactoryUtil.getLog(VideoIndexer.class);

	@Reference
	VideoLocalService videoLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public VideoIndexer() {
		setDefaultSelectedFieldNames(Field.COMPANY_ID, "videoId", "tagCloud", "lectureSeriesId", "producerId",
				"containerFormat", "resolution", "duration", "hostId", "generationDate", "openAccess", "metaDataId",
				"hits", "uploadDate", "permittedToSegment", "rootInstitutionId", "citation2Go", "termId", "licenseId",
				"createDate", "modifiedDate", "categoryId", "institutionId", "institutionParentId", "mediaTypeId");
	}

	@Override
	protected void doDelete(Video video) throws Exception {
		deleteDocument(video.getCompanyId(), video.getVideoId());
	}

	@Override
	protected Document doGetDocument(Video video) {
		Document document = getBaseModelDocument(Video.class.getName(), video);
		document.addKeyword(Field.COMPANY_ID, video.getCompanyId());
		document.addKeyword("videoId", video.getVideoId());
		try {
			document.addText("tagCloud", getTagCloudStrings(video.getVideoId()));
		} catch (NoSuchTagcloudException e) {
			log.warn(String.format("No tag cloud for video with id %d found to create index!", video.getVideoId()), e);
		}
		document.addKeyword("name", video.getTitle());
		document.addKeyword("lectureSeriesId", video.getLectureseriesId());
		document.addKeyword("producerId", video.getProducerId());
		document.addKeyword("containerFormat", video.getContainerFormat());
		document.addKeyword("resolution", video.getResolution());
		document.addKeyword("duration", video.getDuration());
		document.addKeyword("hostId", video.getHostId());
		document.addKeyword("generationDate", video.getGenerationDate());
		document.addKeyword("openAccess", video.getOpenAccess());
		document.addKeyword("metaDataId", video.getMetadataId());
		document.addNumber("hits", video.getHits());
		document.addDate("uploadDate", video.getUploadDate());
		document.addKeyword("permittedToSegment", video.getPermittedToSegment());
		document.addKeyword("rootInstitution", video.getRootInstitutionId());
		document.addKeyword("citation2Go", video.getCitation2go());
		document.addKeyword("licenseId", video.getLicenseId());
		document.addDate("createDate", video.getCreateDate());
		document.addDate("modifiedDate", video.getModifiedDate());

		// ids for filtering
		document.addKeyword("termId", video.getTermId());
		setCategoryIds(document, video.getVideoId());
		setInstitutionIds(document, video.getVideoId());
		setCreatorIds(document, video.getVideoId());
		setMediaTypeIds(document, video.getVideoId());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Video video = videoLocalService.getVideo(classPK);
		doReindex(video);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexVideos(companyId);
	}

	@Override
	protected void doReindex(Video video) throws Exception {
		Document document = getDocument(video);
		indexWriterHelper.updateDocument(getSearchEngineId(), video.getCompanyId(), document, isCommitImmediately());
	}

	@Override
	public String getClassName() {
		return Video.class.getName();
	}

	protected void reindexVideos(long companyId) throws PortalException {
		log.info("Attempting to reindex all videos for companyId: " + companyId);

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = videoLocalService
				.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery
				.setPerformActionMethod((ActionableDynamicQuery.PerformActionMethod<Video>) video -> {
					try {
						Document document = getDocument(video);
						indexableActionableDynamicQuery.addDocuments(document);
					} catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all videos for companyId: " + companyId);
	}

	private String[] getTagCloudStrings(long videoId) throws NoSuchTagcloudException {
		Tagcloud tagcloud = TagcloudLocalServiceUtil.getByObjectIdAndObjectClassType(videoId,
				VideoImpl.class.getName());
		return tagcloud.getTags().split(TagcloudLocalServiceImpl.TAG_SEPARATOR);
	}

	private void setCategoryIds(Document document, long videoId) {
		List<Video_Category> videoCategories = Video_CategoryLocalServiceUtil.getByVideo(videoId);
		if (videoCategories != null && !videoCategories.isEmpty()) {
			long[] categoryIds = new long[videoCategories.size()];
			for (int i = 0; i < videoCategories.size(); i++) {
				categoryIds[i] = videoCategories.get(i).getCategoryId();
			}
			document.addKeyword("categoryId", categoryIds);
		}
	}

	private void setInstitutionIds(Document document, long videoId) {
		List<Video_Institution> videoInstitutions = Video_InstitutionLocalServiceUtil.getByVideo(videoId);
		long[] institutionIds = new long[videoInstitutions.size()];
		long[] parentInstitutionIds = new long[videoInstitutions.size()];

		for (int i = 0; i < videoInstitutions.size(); i++) {
			institutionIds[i] = videoInstitutions.get(i).getInstitutionId();
			parentInstitutionIds[i] = videoInstitutions.get(i).getInstitutionParentId();
		}

		document.addKeyword("institutionId", institutionIds);
		document.addKeyword("institutionParentId", parentInstitutionIds);
	}

	private void setCreatorIds(Document document, long videoId) {
		List<Video_Creator> videoCreators = Video_CreatorLocalServiceUtil.getByVideo(videoId);
		long[] creatorIds = new long[videoCreators.size()];
		for (int i = 0; i < videoCreators.size(); i++) {
			creatorIds[i] = videoCreators.get(i).getCreatorId();
		}

		document.addKeyword("creatorId", creatorIds);
	}

	private void setMediaTypeIds(Document document, long videoId) {
		List<Video_MediaType> video_mediaTypes = Video_MediaTypeLocalServiceUtil.getByVideo(videoId);
		long[] mediaTypeIds = new long[video_mediaTypes.size()];
		for (int i = 0; i < video_mediaTypes.size(); i++) {
			mediaTypeIds[i] = video_mediaTypes.get(i).getMediaTypeId();
		}

		document.addKeyword("mediaTypeId", mediaTypeIds);
	}
}
