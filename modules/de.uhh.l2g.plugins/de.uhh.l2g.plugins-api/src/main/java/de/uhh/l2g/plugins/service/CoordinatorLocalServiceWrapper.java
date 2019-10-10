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
 * Provides a wrapper for {@link CoordinatorLocalService}.
 *
 * @author Iavor Sturm
 * @see CoordinatorLocalService
 * @generated
 */
@ProviderType
public class CoordinatorLocalServiceWrapper
	implements CoordinatorLocalService,
			   ServiceWrapper<CoordinatorLocalService> {

	public CoordinatorLocalServiceWrapper(
		CoordinatorLocalService coordinatorLocalService) {

		_coordinatorLocalService = coordinatorLocalService;
	}

	/**
	 * Adds the coordinator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator addCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return _coordinatorLocalService.addCoordinator(coordinator);
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator createCoordinator(
		long coordinatorId) {

		return _coordinatorLocalService.createCoordinator(coordinatorId);
	}

	/**
	 * Deletes the coordinator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator deleteCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return _coordinatorLocalService.deleteCoordinator(coordinator);
	}

	/**
	 * Deletes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws PortalException if a coordinator with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator deleteCoordinator(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coordinatorLocalService.deleteCoordinator(coordinatorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coordinatorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coordinatorLocalService.dynamicQuery();
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

		return _coordinatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _coordinatorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _coordinatorLocalService.dynamicQuery(
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

		return _coordinatorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _coordinatorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Coordinator fetchCoordinator(
		long coordinatorId) {

		return _coordinatorLocalService.fetchCoordinator(coordinatorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _coordinatorLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator>
			getAllCoordinators(int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _coordinatorLocalService.getAllCoordinators(begin, end);
	}

	@Override
	public de.uhh.l2g.plugins.model.Coordinator getById(long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _coordinatorLocalService.getById(coordinatorId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Coordinator getByInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _coordinatorLocalService.getByInstitution(institutionId);
	}

	/**
	 * Returns the coordinator with the primary key.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws PortalException if a coordinator with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator getCoordinator(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coordinatorLocalService.getCoordinator(coordinatorId);
	}

	/**
	 * Returns a range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of coordinators
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Coordinator> getCoordinators(
		int start, int end) {

		return _coordinatorLocalService.getCoordinators(start, end);
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	@Override
	public int getCoordinatorsCount() {
		return _coordinatorLocalService.getCoordinatorsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _coordinatorLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution getInstitutionByCoordinator(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _coordinatorLocalService.getInstitutionByCoordinator(
			coordinatorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _coordinatorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coordinatorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the coordinator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Coordinator updateCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return _coordinatorLocalService.updateCoordinator(coordinator);
	}

	@Override
	public CoordinatorLocalService getWrappedService() {
		return _coordinatorLocalService;
	}

	@Override
	public void setWrappedService(
		CoordinatorLocalService coordinatorLocalService) {

		_coordinatorLocalService = coordinatorLocalService;
	}

	private CoordinatorLocalService _coordinatorLocalService;

}