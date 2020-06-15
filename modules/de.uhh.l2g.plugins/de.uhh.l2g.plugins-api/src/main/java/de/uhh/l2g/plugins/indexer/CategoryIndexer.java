package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class CategoryIndexer extends BaseIndexer<Category> {
	private static final Log log = LogFactoryUtil.getLog(CategoryIndexer.class);

	@Reference
	CategoryLocalService categoryLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public CategoryIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID,
				"categoryId",
				"parentId",
				"languageId",
				"name",
				"translation",
				"groupId",
				"userId",
				"userUuid",
				"userName",
				"createDate",
				"modifiedDate"
		);
	}

	@Override
	protected void doDelete(Category category) throws Exception {
		deleteDocument(category.getCompanyId(), category.getCategoryId());
	}

	@Override
	protected Document doGetDocument(Category category) throws Exception {
		Document document = getBaseModelDocument(Category.class.getName(), category);
		document.addKeyword(Field.COMPANY_ID, category.getCompanyId());
		document.addKeyword("categoryId", category.getCategoryId());
		document.addKeyword("parentId", category.getParentId());
		document.addKeyword("languageId", category.getLanguageId());
		document.addKeyword("name", category.getName());
		document.addKeyword("translation", category.getTranslation());
		document.addKeyword("groupId", category.getGroupId());
		document.addKeyword("userId", category.getUserId());
		document.addKeyword("userUuid", category.getUserUuid());
		document.addKeyword("userName", category.getUserName());
		document.addDate("createDate", category.getCreateDate());
		document.addDate("modifiedDate", category.getModifiedDate());

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
		Category category = categoryLocalService.getCategory(classPK);
		doReindex(category);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexCategories(companyId);
	}

	@Override
	protected void doReindex(Category category) throws Exception {
		Document document = getDocument(category);
		indexWriterHelper.updateDocument(
				getSearchEngineId(),
				category.getCompanyId(),
				document,
				isCommitImmediately()
		);
	}

	@Override
	public String getClassName() {
		return Category.class.getName();
	}

	protected void reindexCategories(long companyId) throws PortalException {
		log.info("Attempting to reindex all categories for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				categoryLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Category>) category -> {
					try {
						Document document = getDocument(category);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all categories for companyId: " + companyId);
	}
}
