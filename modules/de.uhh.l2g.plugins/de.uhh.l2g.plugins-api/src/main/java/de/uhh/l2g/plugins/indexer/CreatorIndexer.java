package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.CreatorLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class CreatorIndexer extends BaseIndexer<Creator> {
	private static final Log log = LogFactoryUtil.getLog(CategoryIndexer.class);

	@Reference
	CreatorLocalService creatorLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public CreatorIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID,
				"creatorId",
				"firstName",
				"lastName",
				"middleName",
				"jobTitle",
				"gender",
				"fullName",
				"createDate",
				"modifiedDate"
		);
	}

	@Override
	protected void doDelete(Creator creator) throws Exception {
		deleteDocument(creator.getCompanyId(), creator.getCreatorId());
	}

	@Override
	protected Document doGetDocument(Creator creator) throws Exception {
		Document document = getBaseModelDocument(Creator.class.getName(), creator);
		document.addKeyword(Field.COMPANY_ID, creator.getCompanyId());
		document.addKeyword("creatorId", creator.getCreatorId());
		document.addKeyword("firstName", creator.getFirstName());
		document.addKeyword("lastName", creator.getLastName());
		document.addKeyword("middleName", creator.getMiddleName());
		document.addKeyword("jobTitle", creator.getJobTitle());
		document.addKeyword("gender", creator.getGender());
		document.addKeyword("fullName", creator.getFullName());
		document.addDate("createDate", creator.getCreateDate());
		document.addDate("modifiedDate", creator.getModifiedDate());

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
		Creator creator = creatorLocalService.getCreator(classPK);
		doReindex(creator);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexCreators(companyId);
	}

	@Override
	protected void doReindex(Creator creator) throws Exception {
		Document document = getDocument(creator);
		indexWriterHelper.updateDocument(
				getSearchEngineId(),
				creator.getCompanyId(),
				document,
				isCommitImmediately()
		);
	}

	@Override
	public String getClassName() {
		return Creator.class.getName();
	}

	protected void reindexCreators(long companyId) throws PortalException {
		log.info("Attempting to reindex all creators for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				creatorLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Creator>) creator -> {
					try {
						Document document = getDocument(creator);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all creators for companyId: " + companyId);
	}
}
