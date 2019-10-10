package de.uhh.l2g.docs.category.search;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalService;

@Component(immediate = true, service = Indexer.class)
public class CategoryIndexer extends BaseIndexer<Category> {
	public static final String CLASS_NAME = Category.class.getName();

	public CategoryIndexer() {
		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE,
				Field.UID);
		setPermissionAware(true);
		setFilterSearch(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {
		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {
//		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
		addSearchTerm(searchQuery, searchContext, Field.TITLE, true);
	}

	@Override
	protected void doDelete(Category category) throws Exception {
		deleteDocument(category.getCompanyId(), category.getCategoryId());
	}

	@Override
	protected Document doGetDocument(Category category) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, category);
		document.addDate(Field.MODIFIED_DATE, category.getModifiedDate());
		
		//Locale defaultLocale = PortalUtil.getSiteDefaultLocale(category.getGroupId());
		//String localizedFieldTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());
		document.addText(Field.TITLE, category.getName());
		//
//		String localizedFieldCreateDate = LocalizationUtil.getLocalizedName(Field.CREATE_DATE, defaultLocale.toString());
		document.addText(Field.CREATE_DATE, category.getCreateDate().toString());
		document.addNumber(Field.GROUP_ID, category.getGroupId());
		document.addNumber(Field.UID, category.getUserId());
		document.addText(Field.USER_NAME, category.getUserName());
		document.addNumber(Field.UID, category.getUserId());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Category category = _categoryLocalService.getCategory(classPK);
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
		indexWriterHelper.updateDocument(getSearchEngineId(), category.getCompanyId(), document, isCommitImmediately());
	}

	protected void reindexCategories(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _categoryLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				new ActionableDynamicQuery.PerformActionMethod<Category>() {
					@Override
					public void performAction(Category category) {
						try {
							Document document = getDocument(category);
							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
							if (_log.isWarnEnabled()) {
								_log.warn("Unable to index category " + category.getCategoryId(), pe);
							}
						}
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log = LogFactoryUtil.getLog(CategoryIndexer.class);

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	@Reference
	private CategoryLocalService _categoryLocalService;

}
