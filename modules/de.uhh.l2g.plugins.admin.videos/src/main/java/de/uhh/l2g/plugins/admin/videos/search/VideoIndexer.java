package de.uhh.l2g.plugins.admin.videos.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.LinkedHashMap;
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
		document.addNumber("videoId", video.getVideoId());
		document.addKeyword("videoTitle", video.getTitle());
		document.addKeyword("tags", video.getTags());
		document.addNumber("lectureSeriesId", video.getLectureseriesId());
		document.addNumber("producerId", video.getProducerId());
		document.addKeyword("containerFormat", video.getContainerFormat());
		document.addKeyword("resolution", video.getResolution());
		document.addKeyword("duration", video.getDuration());
		document.addNumber("hostId", video.getHostId());
		document.addKeyword("generationDate", video.getGenerationDate());
		document.addNumber("openAccess", video.getOpenAccess());
		document.addNumber("metaDataId", video.getMetadataId());
		document.addNumber("hits", video.getHits());
		document.addDate("uploadDate", video.getUploadDate());
		document.addNumber("permittedToSegment", video.getPermittedToSegment());
		document.addNumber("rootInstitution", video.getRootInstitutionId());
		document.addNumber("citation2Go", video.getCitation2go());
		document.addNumber("termId", video.getTermId());
		document.addNumber("licenseId", video.getLicenseId());
		document.addNumber("userId", video.getUserId());
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
				getSearchEngineId(), video.getCompanyId(), document,
				isCommitImmediately());
	}

	@Override
	public String getClassName() {
		return Video.class.getName();
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
																		 SearchContext searchContext) throws Exception {
		addSearchTerm(searchQuery, searchContext, "videoId", false);
		addSearchTerm(searchQuery, searchContext, "videoTitle", false);
		addSearchTerm(searchQuery, searchContext, "tags", false);
		addSearchTerm(searchQuery, searchContext, "lectureSeriesId", false);
		addSearchTerm(searchQuery, searchContext, "producerId", false);
		addSearchTerm(searchQuery, searchContext, "containerFormat", false);
		addSearchTerm(searchQuery, searchContext, "resolution", false);
		addSearchTerm(searchQuery, searchContext, "duration", false);
		addSearchTerm(searchQuery, searchContext, "hostId", false);
		addSearchTerm(searchQuery, searchContext, "generationDate", false);
		addSearchTerm(searchQuery, searchContext, "openAccess", false);
		addSearchTerm(searchQuery, searchContext, "metaDataId", false);
		addSearchTerm(searchQuery, searchContext, "hits", false);
		addSearchTerm(searchQuery, searchContext, "uploadDate", false);
		addSearchTerm(searchQuery, searchContext, "permittedToSegment", false);
		addSearchTerm(searchQuery, searchContext, "rootInstitutionId", false);
		addSearchTerm(searchQuery, searchContext, "citation2Go", false);
		addSearchTerm(searchQuery, searchContext, "termId", false);
		addSearchTerm(searchQuery, searchContext, "licenseId", false);
		addSearchTerm(searchQuery, searchContext, "userId", false);
		addSearchTerm(searchQuery, searchContext, "userUuid", false);
		addSearchTerm(searchQuery, searchContext, "userName", false);
		addSearchTerm(searchQuery, searchContext, "createDate", false);
		addSearchTerm(searchQuery, searchContext, "modifiedDate", false);

		LinkedHashMap<String, Object> params =
				(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			String expandoAttributes = (String)params.get("expandoAttributes");

			if (Validator.isNotNull(expandoAttributes)) {
				addSearchExpando(searchQuery, searchContext, expandoAttributes);
			}
		}
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
		log.info("Successfully reindexed all videos for compandyId: " + companyId);
	}
}
