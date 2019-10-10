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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Coordinator. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.CoordinatorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see CoordinatorLocalService
 * @generated
 */
@ProviderType
public class CoordinatorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.CoordinatorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the coordinator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was added
	 */
	public static de.uhh.l2g.plugins.model.Coordinator addCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return getService().addCoordinator(coordinator);
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	public static de.uhh.l2g.plugins.model.Coordinator createCoordinator(
		long coordinatorId) {

		return getService().createCoordinator(coordinatorId);
	}

	/**
	 * Deletes the coordinator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was removed
	 */
	public static de.uhh.l2g.plugins.model.Coordinator deleteCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return getService().deleteCoordinator(coordinator);
	}

	/**
	 * Deletes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws PortalException if a coordinator with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Coordinator deleteCoordinator(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCoordinator(coordinatorId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.Coordinator fetchCoordinator(
		long coordinatorId) {

		return getService().fetchCoordinator(coordinatorId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator>
			getAllCoordinators(int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllCoordinators(begin, end);
	}

	public static de.uhh.l2g.plugins.model.Coordinator getById(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getById(coordinatorId);
	}

	public static de.uhh.l2g.plugins.model.Coordinator getByInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByInstitution(institutionId);
	}

	/**
	 * Returns the coordinator with the primary key.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws PortalException if a coordinator with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Coordinator getCoordinator(
			long coordinatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCoordinator(coordinatorId);
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
	public static java.util.List<de.uhh.l2g.plugins.model.Coordinator>
		getCoordinators(int start, int end) {

		return getService().getCoordinators(start, end);
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	public static int getCoordinatorsCount() {
		return getService().getCoordinatorsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static de.uhh.l2g.plugins.model.Institution
			getInstitutionByCoordinator(long coordinatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getInstitutionByCoordinator(coordinatorId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the coordinator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param coordinator the coordinator
	 * @return the coordinator that was updated
	 */
	public static de.uhh.l2g.plugins.model.Coordinator updateCoordinator(
		de.uhh.l2g.plugins.model.Coordinator coordinator) {

		return getService().updateCoordinator(coordinator);
	}

	public static CoordinatorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CoordinatorLocalService, CoordinatorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CoordinatorLocalService.class);

		ServiceTracker<CoordinatorLocalService, CoordinatorLocalService>
			serviceTracker =
				new ServiceTracker
					<CoordinatorLocalService, CoordinatorLocalService>(
						bundle.getBundleContext(),
						CoordinatorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}