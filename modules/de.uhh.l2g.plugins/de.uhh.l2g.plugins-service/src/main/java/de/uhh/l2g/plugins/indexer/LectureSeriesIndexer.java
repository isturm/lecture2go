package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.LectureseriesLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class LectureSeriesIndexer extends BaseIndexer<Lectureseries> {
	private static final Log log = LogFactoryUtil.getLog(LectureSeriesIndexer.class);

	@Reference
	LectureseriesLocalService lectureseriesLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public LectureSeriesIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID,
				"lectureSeriesId",
				"number",
				"eventType",
				"categoryId",
				"name",
				"shortDesc",
				"termId",
				"language",
				"facultyName",
				"approved",
				"longDesc",
				"latestOpenAccessVideoId",
				"latestVideoUploadDate",
				"latestVideoGenerationDate",
				"videoSort",
				"USID",
				"previewVideoId",
				"createDate",
				"modifiedDate"
		);
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
		document.addKeyword("number", lectureseries.getNumber());
		document.addKeyword("eventType", lectureseries.getEventType());
		document.addText("name", lectureseries.getName());
		document.addText("shortDesc", lectureseries.getShortDesc());
		document.addKeyword("termId", lectureseries.getTermId());
		document.addKeyword("language", lectureseries.getLanguage());
		document.addKeyword("facultyName", lectureseries.getFacultyName());
		document.addKeyword("approved", lectureseries.getApproved());
		document.addText("longDesc", lectureseries.getLongDesc());
		document.addKeyword("latestOpenAccessVideoId", lectureseries.getLatestOpenAccessVideoId());
		document.addDate("latestVideoUploadDate", lectureseries.getLatestVideoUploadDate());
		document.addKeyword("latestVideoGenerationDate", lectureseries.getLatestVideoGenerationDate());
		document.addKeyword("videoSort", lectureseries.getVideoSort());
		document.addKeyword("USID", lectureseries.getUSID());
		document.addKeyword("previewVideoId", lectureseries.getPreviewVideoId());
		document.addDate("createDate", lectureseries.getCreateDate());
		document.addDate("modifiedDate", lectureseries.getModifiedDate());

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
		indexWriterHelper.updateDocument(
				getSearchEngineId(),
				lectureseries.getCompanyId(),
				document,
				isCommitImmediately()
		);
	}

	@Override
	public String getClassName() {
		return Lectureseries.class.getName();
	}

	protected void reindexLectureseries(long companyId) throws PortalException {
		log.info("Attempting to reindex all lecture series for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				lectureseriesLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Lectureseries>) lectureseries -> {
					try {
						Document document = getDocument(lectureseries);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all lecture series for companyId: " + companyId);
	}
}
