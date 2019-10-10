/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link MetadataLocalService}.
 *
 * @author Iavor Sturm
 * @see MetadataLocalService
 * @generated
 */
@ProviderType
public class MetadataLocalServiceWrapper
	implements MetadataLocalService, ServiceWrapper<MetadataLocalService> {

	public MetadataLocalServiceWrapper(
		MetadataLocalService metadataLocalService) {

		_metadataLocalService = metadataLocalService;
	}

	/**
	 * Adds the metadata to the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadata the metadata
	 * @return the metadata that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata addMetadata(
		de.uhh.l2g.plugins.model.Metadata metadata) {

		return _metadataLocalService.addMetadata(metadata);
	}

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata createMetadata(long metadataId) {
		return _metadataLocalService.createMetadata(metadataId);
	}

	/**
	 * Deletes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws PortalException if a metadata with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata deleteMetadata(long metadataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metadataLocalService.deleteMetadata(metadataId);
	}

	/**
	 * Deletes the metadata from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadata the metadata
	 * @return the metadata that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata deleteMetadata(
		de.uhh.l2g.plugins.model.Metadata metadata) {

		return _metadataLocalService.deleteMetadata(metadata);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metadataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _metadataLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _metadataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _metadataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _metadataLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _metadataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _metadataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Metadata fetchMetadata(long metadataId) {
		return _metadataLocalService.fetchMetadata(metadataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _metadataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _metadataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the metadata with the primary key.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws PortalException if a metadata with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata getMetadata(long metadataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metadataLocalService.getMetadata(metadataId);
	}

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Metadata> getMetadatas(
		int start, int end) {

		return _metadataLocalService.getMetadatas(start, end);
	}

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
	 */
	@Override
	public int getMetadatasCount() {
		return _metadataLocalService.getMetadatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _metadataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _metadataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the metadata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param metadata the metadata
	 * @return the metadata that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Metadata updateMetadata(
		de.uhh.l2g.plugins.model.Metadata metadata) {

		return _metadataLocalService.updateMetadata(metadata);
	}

	@Override
	public MetadataLocalService getWrappedService() {
		return _metadataLocalService;
	}

	@Override
	public void setWrappedService(MetadataLocalService metadataLocalService) {
		_metadataLocalService = metadataLocalService;
	}

	private MetadataLocalService _metadataLocalService;

}