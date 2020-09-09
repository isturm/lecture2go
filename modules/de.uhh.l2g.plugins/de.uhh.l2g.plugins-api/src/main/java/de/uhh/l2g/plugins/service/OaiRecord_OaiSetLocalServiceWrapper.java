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

/**
 * Provides a wrapper for {@link OaiRecord_OaiSetLocalService}.
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetLocalService
 * @generated
 */
public class OaiRecord_OaiSetLocalServiceWrapper
	implements OaiRecord_OaiSetLocalService,
			   ServiceWrapper<OaiRecord_OaiSetLocalService> {

	public OaiRecord_OaiSetLocalServiceWrapper(
		OaiRecord_OaiSetLocalService oaiRecord_OaiSetLocalService) {

		_oaiRecord_OaiSetLocalService = oaiRecord_OaiSetLocalService;
	}

	/**
	 * Adds the oai record_ oai set to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 * @return the oai record_ oai set that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet addOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet) {

		return _oaiRecord_OaiSetLocalService.addOaiRecord_OaiSet(
			oaiRecord_OaiSet);
	}

	/**
	 * Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	 *
	 * @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	 * @return the new oai record_ oai set
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet createOaiRecord_OaiSet(
		long oaiRecordOaiSetId) {

		return _oaiRecord_OaiSetLocalService.createOaiRecord_OaiSet(
			oaiRecordOaiSetId);
	}

	/**
	 * Deletes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws PortalException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet deleteOaiRecord_OaiSet(
			long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiRecord_OaiSetLocalService.deleteOaiRecord_OaiSet(
			oaiRecordOaiSetId);
	}

	/**
	 * Deletes the oai record_ oai set from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet deleteOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet) {

		return _oaiRecord_OaiSetLocalService.deleteOaiRecord_OaiSet(
			oaiRecord_OaiSet);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiRecord_OaiSetLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oaiRecord_OaiSetLocalService.dynamicQuery();
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

		return _oaiRecord_OaiSetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl</code>.
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

		return _oaiRecord_OaiSetLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl</code>.
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

		return _oaiRecord_OaiSetLocalService.dynamicQuery(
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

		return _oaiRecord_OaiSetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _oaiRecord_OaiSetLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet fetchOaiRecord_OaiSet(
		long oaiRecordOaiSetId) {

		return _oaiRecord_OaiSetLocalService.fetchOaiRecord_OaiSet(
			oaiRecordOaiSetId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _oaiRecord_OaiSetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _oaiRecord_OaiSetLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the oai record_ oai set with the primary key.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws PortalException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet getOaiRecord_OaiSet(
			long oaiRecordOaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiRecord_OaiSetLocalService.getOaiRecord_OaiSet(
			oaiRecordOaiSetId);
	}

	/**
	 * Returns a range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of oai record_ oai sets
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiRecord_OaiSet>
		getOaiRecord_OaiSets(int start, int end) {

		return _oaiRecord_OaiSetLocalService.getOaiRecord_OaiSets(start, end);
	}

	/**
	 * Returns the number of oai record_ oai sets.
	 *
	 * @return the number of oai record_ oai sets
	 */
	@Override
	public int getOaiRecord_OaiSetsCount() {
		return _oaiRecord_OaiSetLocalService.getOaiRecord_OaiSetsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _oaiRecord_OaiSetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiRecord_OaiSetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the oai record_ oai set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 * @return the oai record_ oai set that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiRecord_OaiSet updateOaiRecord_OaiSet(
		de.uhh.l2g.plugins.model.OaiRecord_OaiSet oaiRecord_OaiSet) {

		return _oaiRecord_OaiSetLocalService.updateOaiRecord_OaiSet(
			oaiRecord_OaiSet);
	}

	@Override
	public OaiRecord_OaiSetLocalService getWrappedService() {
		return _oaiRecord_OaiSetLocalService;
	}

	@Override
	public void setWrappedService(
		OaiRecord_OaiSetLocalService oaiRecord_OaiSetLocalService) {

		_oaiRecord_OaiSetLocalService = oaiRecord_OaiSetLocalService;
	}

	private OaiRecord_OaiSetLocalService _oaiRecord_OaiSetLocalService;

}