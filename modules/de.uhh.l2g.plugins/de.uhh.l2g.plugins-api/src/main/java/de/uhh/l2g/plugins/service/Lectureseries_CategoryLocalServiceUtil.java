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
 * Provides the local service utility for Lectureseries_Category. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.Lectureseries_CategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryLocalService
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Lectureseries_CategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lectureseries_ category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was added
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
		addLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return getService().addLectureseries_Category(lectureseries_Category);
	}

	/**
	 * Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	 *
	 * @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	 * @return the new lectureseries_ category
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
		createLectureseries_Category(long lectureseriesCategoryId) {

		return getService().createLectureseries_Category(
			lectureseriesCategoryId);
	}

	/**
	 * Deletes the lectureseries_ category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
		deleteLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return getService().deleteLectureseries_Category(
			lectureseries_Category);
	}

	/**
	 * Deletes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws PortalException if a lectureseries_ category with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
			deleteLectureseries_Category(long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLectureseries_Category(
			lectureseriesCategoryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Lectureseries_Category
		fetchLectureseries_Category(long lectureseriesCategoryId) {

		return getService().fetchLectureseries_Category(
			lectureseriesCategoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the lectureseries_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ categories
	 * @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	 * @return the range of lectureseries_ categories
	 */
	public static java.util.List
		<de.uhh.l2g.plugins.model.Lectureseries_Category>
			getLectureseries_Categories(int start, int end) {

		return getService().getLectureseries_Categories(start, end);
	}

	/**
	 * Returns the number of lectureseries_ categories.
	 *
	 * @return the number of lectureseries_ categories
	 */
	public static int getLectureseries_CategoriesCount() {
		return getService().getLectureseries_CategoriesCount();
	}

	/**
	 * Returns the lectureseries_ category with the primary key.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws PortalException if a lectureseries_ category with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
			getLectureseries_Category(long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLectureseries_Category(lectureseriesCategoryId);
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

	public static void updateCategoryByLectureseriesAndCategory(
		Long lectureseriesId, Long categoryId, Long newCategoryId) {

		getService().updateCategoryByLectureseriesAndCategory(
			lectureseriesId, categoryId, newCategoryId);
	}

	/**
	 * Updates the lectureseries_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was updated
	 */
	public static de.uhh.l2g.plugins.model.Lectureseries_Category
		updateLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return getService().updateLectureseries_Category(
			lectureseries_Category);
	}

	public static Lectureseries_CategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Lectureseries_CategoryLocalService, Lectureseries_CategoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Lectureseries_CategoryLocalService.class);

		ServiceTracker
			<Lectureseries_CategoryLocalService,
			 Lectureseries_CategoryLocalService> serviceTracker =
				new ServiceTracker
					<Lectureseries_CategoryLocalService,
					 Lectureseries_CategoryLocalService>(
						 bundle.getBundleContext(),
						 Lectureseries_CategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}