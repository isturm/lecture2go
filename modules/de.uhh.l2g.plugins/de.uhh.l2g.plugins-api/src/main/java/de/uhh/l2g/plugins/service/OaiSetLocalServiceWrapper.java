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
 * Provides a wrapper for {@link OaiSetLocalService}.
 *
 * @author Iavor Sturm
 * @see OaiSetLocalService
 * @generated
 */
public class OaiSetLocalServiceWrapper
	implements OaiSetLocalService, ServiceWrapper<OaiSetLocalService> {

	public OaiSetLocalServiceWrapper(OaiSetLocalService oaiSetLocalService) {
		_oaiSetLocalService = oaiSetLocalService;
	}

	/**
	 * Adds the oai set to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSet the oai set
	 * @return the oai set that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet addOaiSet(
		de.uhh.l2g.plugins.model.OaiSet oaiSet) {

		return _oaiSetLocalService.addOaiSet(oaiSet);
	}

	/**
	 * Creates a new oai set with the primary key. Does not add the oai set to the database.
	 *
	 * @param oaiSetId the primary key for the new oai set
	 * @return the new oai set
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet createOaiSet(long oaiSetId) {
		return _oaiSetLocalService.createOaiSet(oaiSetId);
	}

	/**
	 * Deletes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws PortalException if a oai set with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet deleteOaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiSetLocalService.deleteOaiSet(oaiSetId);
	}

	/**
	 * Deletes the oai set from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSet the oai set
	 * @return the oai set that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet deleteOaiSet(
		de.uhh.l2g.plugins.model.OaiSet oaiSet) {

		return _oaiSetLocalService.deleteOaiSet(oaiSet);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiSetLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oaiSetLocalService.dynamicQuery();
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

		return _oaiSetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiSetModelImpl</code>.
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

		return _oaiSetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiSetModelImpl</code>.
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

		return _oaiSetLocalService.dynamicQuery(
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

		return _oaiSetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _oaiSetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.OaiSet fetchOaiSet(long oaiSetId) {
		return _oaiSetLocalService.fetchOaiSet(oaiSetId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _oaiSetLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _oaiSetLocalService.getAll();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> getByOaiRecordId(
		long oaiRecordId) {

		return _oaiSetLocalService.getByOaiRecordId(oaiRecordId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _oaiSetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the oai set with the primary key.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set
	 * @throws PortalException if a oai set with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet getOaiSet(long oaiSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiSetLocalService.getOaiSet(oaiSetId);
	}

	/**
	 * Returns a range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @return the range of oai sets
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.OaiSet> getOaiSets(
		int start, int end) {

		return _oaiSetLocalService.getOaiSets(start, end);
	}

	/**
	 * Returns the number of oai sets.
	 *
	 * @return the number of oai sets
	 */
	@Override
	public int getOaiSetsCount() {
		return _oaiSetLocalService.getOaiSetsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _oaiSetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oaiSetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the oai set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSet the oai set
	 * @return the oai set that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.OaiSet updateOaiSet(
		de.uhh.l2g.plugins.model.OaiSet oaiSet) {

		return _oaiSetLocalService.updateOaiSet(oaiSet);
	}

	@Override
	public OaiSetLocalService getWrappedService() {
		return _oaiSetLocalService;
	}

	@Override
	public void setWrappedService(OaiSetLocalService oaiSetLocalService) {
		_oaiSetLocalService = oaiSetLocalService;
	}

	private OaiSetLocalService _oaiSetLocalService;

}