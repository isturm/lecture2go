package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class VideoIndexer extends BaseIndexer<Video> {
	private static final Log log = LogFactoryUtil.getLog(VideoIndexer.class);

	@Reference
	VideoLocalService videoLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public VideoIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID,
				"videoId",
				"videoTitle",
				"tags",
				"lectureSeriesId",
				"producerId",
				"containerFormat",
				"resolution",
				"duration",
				"hostId",
				"generationDate",
				"openAccess",
				"metaDataId",
				"hits",
				"uploadDate",
				"permittedToSegment",
				"rootInstitutionId",
				"citation2Go",
				"termId",
				"licenseId",
				"userId",
				"userUuid",
				"userName",
				"createDate",
				"modifiedDate"
		);
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
		document.addText("videoTitle", video.getTitle());
		document.addKeyword("tags", video.getTags());
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
		document.addKeyword("termId", video.getTermId());
		document.addKeyword("licenseId", video.getLicenseId());
		document.addKeyword("userId", video.getUserId());
		document.addKeyword("userUuid", video.getUserUuid());
		document.addDate("createDate", video.getCreateDate());
		document.addDate("modifiedDate", video.getModifiedDate());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
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
		indexWriterHelper.updateDocument(
				getSearchEngineId(),
				video.getCompanyId(),
				document,
				isCommitImmediately()
		);
	}

	@Override
	public String getClassName() {
		return Video.class.getName();
	}

	protected void reindexVideos(long companyId) throws PortalException {
		log.info("Attempting to reindex all videos for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				videoLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Video>) video -> {
					try {
						Document document = getDocument(video);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all videos for companyId: " + companyId);
	}
}
