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
 * Provides a wrapper for {@link LastvideolistLocalService}.
 *
 * @author Iavor Sturm
 * @see LastvideolistLocalService
 * @generated
 */
@ProviderType
public class LastvideolistLocalServiceWrapper
	implements LastvideolistLocalService,
			   ServiceWrapper<LastvideolistLocalService> {

	public LastvideolistLocalServiceWrapper(
		LastvideolistLocalService lastvideolistLocalService) {

		_lastvideolistLocalService = lastvideolistLocalService;
	}

	/**
	 * Adds the lastvideolist to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolist the lastvideolist
	 * @return the lastvideolist that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist addLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {

		return _lastvideolistLocalService.addLastvideolist(lastvideolist);
	}

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist createLastvideolist(
		int lastvideolistId) {

		return _lastvideolistLocalService.createLastvideolist(lastvideolistId);
	}

	@Override
	public void deleteByVideoId(Long videoId) {
		_lastvideolistLocalService.deleteByVideoId(videoId);
	}

	/**
	 * Deletes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws PortalException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist deleteLastvideolist(
			int lastvideolistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lastvideolistLocalService.deleteLastvideolist(lastvideolistId);
	}

	/**
	 * Deletes the lastvideolist from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolist the lastvideolist
	 * @return the lastvideolist that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist deleteLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {

		return _lastvideolistLocalService.deleteLastvideolist(lastvideolist);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lastvideolistLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lastvideolistLocalService.dynamicQuery();
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

		return _lastvideolistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lastvideolistLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lastvideolistLocalService.dynamicQuery(
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

		return _lastvideolistLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lastvideolistLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist fetchLastvideolist(
		int lastvideolistId) {

		return _lastvideolistLocalService.fetchLastvideolist(lastvideolistId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lastvideolistLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lastvideolistLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lastvideolist with the primary key.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws PortalException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist getLastvideolist(
			int lastvideolistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lastvideolistLocalService.getLastvideolist(lastvideolistId);
	}

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lastvideolist>
		getLastvideolists(int start, int end) {

		return _lastvideolistLocalService.getLastvideolists(start, end);
	}

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
	 */
	@Override
	public int getLastvideolistsCount() {
		return _lastvideolistLocalService.getLastvideolistsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lastvideolistLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lastvideolistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lastvideolist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolist the lastvideolist
	 * @return the lastvideolist that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lastvideolist updateLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {

		return _lastvideolistLocalService.updateLastvideolist(lastvideolist);
	}

	@Override
	public LastvideolistLocalService getWrappedService() {
		return _lastvideolistLocalService;
	}

	@Override
	public void setWrappedService(
		LastvideolistLocalService lastvideolistLocalService) {

		_lastvideolistLocalService = lastvideolistLocalService;
	}

	private LastvideolistLocalService _lastvideolistLocalService;

}