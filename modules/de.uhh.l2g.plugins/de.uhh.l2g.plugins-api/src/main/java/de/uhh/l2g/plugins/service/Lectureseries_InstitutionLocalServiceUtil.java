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
 * Provides the local service utility for Lectureseries_Institution. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.Lectureseries_InstitutionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionLocalService
 * @generated
 */
@ProviderType
public class Lectureseries_InstitutionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Lectureseries_InstitutionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lectureseries_ institution to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was added
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
		addLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return getService().addLectureseries_Institution(
			lectureseries_Institution);
	}

	/**
	 * Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	 *
	 * @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	 * @return the new lectureseries_ institution
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
		createLectureseries_Institution(long lectureseriesInstitutionId) {

		return getService().createLectureseries_Institution(
			lectureseriesInstitutionId);
	}

	/**
	 * Deletes the lectureseries_ institution from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
		deleteLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return getService().deleteLectureseries_Institution(
			lectureseries_Institution);
	}

	/**
	 * Deletes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 * @throws PortalException if a lectureseries_ institution with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
			deleteLectureseries_Institution(long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLectureseries_Institution(
			lectureseriesInstitutionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
		fetchLectureseries_Institution(long lectureseriesInstitutionId) {

		return getService().fetchLectureseries_Institution(
			lectureseriesInstitutionId);
	}

	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
			findFirstByLectureseriesIdAndInstitutionId(
				long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findFirstByLectureseriesIdAndInstitutionId(
			lectureseriesId, institutionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<de.uhh.l2g.plugins.model.Lectureseries_Institution> getByLectureseries(
				long lectureseriesId)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByLectureseries(lectureseriesId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lectureseries_ institution with the primary key.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution
	 * @throws PortalException if a lectureseries_ institution with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
			getLectureseries_Institution(long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLectureseries_Institution(
			lectureseriesInstitutionId);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of lectureseries_ institutions
	 */
	public static java.util.List
		<de.uhh.l2g.plugins.model.Lectureseries_Institution>
			getLectureseries_Institutions(int start, int end) {

		return getService().getLectureseries_Institutions(start, end);
	}

	/**
	 * Returns the number of lectureseries_ institutions.
	 *
	 * @return the number of lectureseries_ institutions
	 */
	public static int getLectureseries_InstitutionsCount() {
		return getService().getLectureseries_InstitutionsCount();
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

	public static boolean institutionAssignedToLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lf) {

		return getService().institutionAssignedToLectureseries(lf);
	}

	public static boolean removeByacilityId(Long institutionId) {
		return getService().removeByacilityId(institutionId);
	}

	public static boolean removeByLectureseriesId(Long lectureseriesId) {
		return getService().removeByLectureseriesId(lectureseriesId);
	}

	/**
	 * Updates the lectureseries_ institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was updated
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Institution
		updateLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return getService().updateLectureseries_Institution(
			lectureseries_Institution);
	}

	public static Lectureseries_InstitutionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Lectureseries_InstitutionLocalService,
		 Lectureseries_InstitutionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Lectureseries_InstitutionLocalService.class);

		ServiceTracker
			<Lectureseries_InstitutionLocalService,
			 Lectureseries_InstitutionLocalService> serviceTracker =
				new ServiceTracker
					<Lectureseries_InstitutionLocalService,
					 Lectureseries_InstitutionLocalService>(
						 bundle.getBundleContext(),
						 Lectureseries_InstitutionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}