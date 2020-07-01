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

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.service.LectureseriesLocalService;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl;
import de.uhh.l2g.plugins.util.EncodingUtil;

@Component(immediate = true, service = Indexer.class)
public class LectureSeriesIndexer extends BaseIndexer<Lectureseries> {
	private static final Log log = LogFactoryUtil.getLog(LectureSeriesIndexer.class);

	@Reference
	LectureseriesLocalService lectureseriesLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public LectureSeriesIndexer() {
		setDefaultSelectedFieldNames(Field.COMPANY_ID, "lectureSeriesId", "number", "eventType", "categoryId", "name",
				"shortDesc", "termId", "language", "facultyName", "approved", "longDesc", "latestOpenAccessVideoId",
				"latestVideoUploadDate", "latestVideoGenerationDate", "videoSort", "USID", "previewVideoId",
				"createDate", "modifiedDate", "institutionId", "institutionParentId");
	}

	@Override
	protected void doDelete(Lectureseries lectureseries) throws Exception {
		deleteDocument(lectureseries.getCompanyId(), lectureseries.getLectureseriesId());
	}

	@Override
	protected Document doGetDocument(Lectureseries lectureseries) throws Exception {
		Document document = getBaseModelDocument(Lectureseries.class.getName(), lectureseries);
		document.addKeyword(Field.COMPANY_ID, lectureseries.getCompanyId());
		document.addKeyword("lectureSeriesId", lectureseries.getLectureseriesId());
		try {
			String[] tagCloudStrings = getTagCloudStrings(lectureseries.getLectureseriesId());
			document.addText("tagCloud", tagCloudStrings);

			String[] encodedTagCloudStrings = EncodingUtil.encodeStrings(tagCloudStrings);
			document.addKeyword("encodedTagCloud", encodedTagCloudStrings);
		} catch (NoSuchTagcloudException e) {
			log.warn(String.format("No tag cloud for lectureseries with id %d found to create index!",
					lectureseries.getLectureseriesId()), e);
		}
		document.addKeywordSortable("name", lectureseries.getName());
		document.addText("shortDesc", lectureseries.getShortDesc());
		document.addKeyword("language", lectureseries.getLanguage());
		document.addKeyword("facultyName", lectureseries.getFacultyName());
		document.addKeyword("approved", lectureseries.getApproved());
		document.addText("longDesc", lectureseries.getLongDesc());
		document.addKeyword("latestOpenAccessVideoId", lectureseries.getLatestOpenAccessVideoId());
		document.addDate("latestVideoUploadDate", lectureseries.getLatestVideoUploadDate());
		document.addKeywordSortable("latestVideoGenerationDate", lectureseries.getLatestVideoGenerationDate());
		document.addKeyword("videoSort", lectureseries.getVideoSort());
		document.addKeyword("USID", lectureseries.getUSID());
		document.addKeyword("previewVideoId", lectureseries.getPreviewVideoId());
		document.addDate("createDate", lectureseries.getCreateDate());
		document.addDate("modifiedDate", lectureseries.getModifiedDate());
		int numberOfOpenAccessVideos = VideoLocalServiceUtil
				.countByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(), 1);
		document.addKeyword("numberOfOpenAccessVideos", numberOfOpenAccessVideos);
		if (numberOfOpenAccessVideos > 0) {
			document.addKeyword("openAccess", 1);
		}

		// ids for filtering
		document.addKeyword("termId", lectureseries.getTermId());
		document.addKeyword("categoryId", lectureseries.getCategoryId());
		setInstitutionIds(document, lectureseries.getLectureseriesId());
		setCreatorIds(document, lectureseries.getLectureseriesId());

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
		Lectureseries lectureseries = lectureseriesLocalService.getLectureseries(classPK);
		doReindex(lectureseries);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexLectureseries(companyId);
	}

	@Override
	protected void doReindex(Lectureseries lectureseries) throws Exception {
		Document document = getDocument(lectureseries);
		indexWriterHelper.updateDocument(getSearchEngineId(), lectureseries.getCompanyId(), document,
				isCommitImmediately());
	}

	@Override
	public String getClassName() {
		return Lectureseries.class.getName();
	}

	protected void reindexLectureseries(long companyId) throws PortalException {
		log.info("Attempting to reindex all lecture series for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = lectureseriesLocalService
				.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery
				.setPerformActionMethod((ActionableDynamicQuery.PerformActionMethod<Lectureseries>) lectureseries -> {
					try {
						Document document = getDocument(lectureseries);
						indexableActionableDynamicQuery.addDocuments(document);
					} catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all lecture series for companyId: " + companyId);
	}

	private String[] getTagCloudStrings(long lectureseriesId) throws NoSuchTagcloudException {
		Tagcloud tagcloud = TagcloudLocalServiceUtil.getByObjectIdAndObjectClassType(lectureseriesId,
				LectureseriesImpl.class.getName());
		return tagcloud.getTags().split(TagcloudLocalServiceImpl.TAG_SEPARATOR);
	}

	private void setInstitutionIds(Document document, long lectureseriesId) {
		List<Lectureseries_Institution> lectureseriesInstitutions = Lectureseries_InstitutionLocalServiceUtil
				.getByLectureseries(lectureseriesId);
		long[] institutionIds = new long[lectureseriesInstitutions.size()];
		long[] parentInstitutionIds = new long[lectureseriesInstitutions.size()];

		for (int i = 0; i < lectureseriesInstitutions.size(); i++) {
			institutionIds[i] = lectureseriesInstitutions.get(i).getInstitutionId();
			parentInstitutionIds[i] = lectureseriesInstitutions.get(i).getInstitutionParentId();
		}

		document.addKeyword("institutionId", institutionIds);
		document.addKeyword("institutionParentId", parentInstitutionIds);
	}

	private void setCreatorIds(Document document, long lectureseriesId) {
		List<Lectureseries_Creator> lectureseriesCreators = Lectureseries_CreatorLocalServiceUtil
				.getByLectureseriesId(lectureseriesId);
		long[] creatorIds = new long[lectureseriesCreators.size()];
		for (int i = 0; i < lectureseriesCreators.size(); i++) {
			creatorIds[i] = lectureseriesCreators.get(i).getCreatorId();
		}

		document.addKeyword("creatorId", creatorIds);
	}
}
