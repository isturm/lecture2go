package de.uhh.l2g.plugins.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.service.MetadataLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class MetadataIndexer extends BaseIndexer<Metadata> {
	private static final Log log = LogFactoryUtil.getLog(CategoryIndexer.class);

	@Reference
	MetadataLocalService metadataLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	public MetadataIndexer() {
		setDefaultSelectedFieldNames(
				Field.COMPANY_ID,
				"metadataId",
				"type",
				"language",
				"title",
				"subject",
				"description",
				"publisher",
				"createDate",
				"modifiedDate"
		);
	}

	@Override
	protected void doDelete(Metadata metadata) throws Exception {
		deleteDocument(metadata.getCompanyId(), metadata.getMetadataId());
	}

	@Override
	protected Document doGetDocument(Metadata metadata) throws Exception {
		Document document = getBaseModelDocument(Metadata.class.getName(), metadata);
		document.addKeyword(Field.COMPANY_ID, metadata.getCompanyId());
		document.addKeyword("metadataId", metadata.getMetadataId());
		document.addKeyword("type", metadata.getType());
		document.addKeyword("language", metadata.getLanguage());
		document.addText("title", metadata.getTitle());
		document.addText("subject", metadata.getSubject());
		document.addText("description", metadata.getDescription());
		document.addKeyword("publisher", metadata.getPublisher());
		document.addDate("createDate", metadata.getCreateDate());
		document.addDate("modifiedDate", metadata.getModifiedDate());

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
		Metadata metadata = metadataLocalService.getMetadata(classPK);
		doReindex(metadata);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexMetadata(companyId);
	}

	@Override
	protected void doReindex(Metadata metadata) throws Exception {
		Document document = getDocument(metadata);
		indexWriterHelper.updateDocument(
				getSearchEngineId(),
				metadata.getCompanyId(),
				document,
				isCommitImmediately()
		);
	}

	@Override
	public String getClassName() {
		return Metadata.class.getName();
	}

	protected void reindexMetadata(long companyId) throws PortalException {
		log.info("Attempting to reindex all metadata for companyId: " + companyId);
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				metadataLocalService.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Metadata>) metadata -> {
					try {
						Document document = getDocument(metadata);
						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						pe.printStackTrace();
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
		log.info("Successfully reindexed all metadata for companyId: " + companyId);
	}
}
