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
 * Provides a wrapper for {@link Lectureseries_CategoryLocalService}.
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryLocalService
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryLocalServiceWrapper
	implements Lectureseries_CategoryLocalService,
			   ServiceWrapper<Lectureseries_CategoryLocalService> {

	public Lectureseries_CategoryLocalServiceWrapper(
		Lectureseries_CategoryLocalService lectureseries_CategoryLocalService) {

		_lectureseries_CategoryLocalService =
			lectureseries_CategoryLocalService;
	}

	/**
	 * Adds the lectureseries_ category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
		addLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return _lectureseries_CategoryLocalService.addLectureseries_Category(
			lectureseries_Category);
	}

	/**
	 * Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	 *
	 * @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	 * @return the new lectureseries_ category
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
		createLectureseries_Category(long lectureseriesCategoryId) {

		return _lectureseries_CategoryLocalService.createLectureseries_Category(
			lectureseriesCategoryId);
	}

	/**
	 * Deletes the lectureseries_ category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
		deleteLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return _lectureseries_CategoryLocalService.deleteLectureseries_Category(
			lectureseries_Category);
	}

	/**
	 * Deletes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category that was removed
	 * @throws PortalException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
			deleteLectureseries_Category(long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_CategoryLocalService.deleteLectureseries_Category(
			lectureseriesCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_CategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lectureseries_CategoryLocalService.dynamicQuery();
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

		return _lectureseries_CategoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _lectureseries_CategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _lectureseries_CategoryLocalService.dynamicQuery(
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

		return _lectureseries_CategoryLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _lectureseries_CategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
		fetchLectureseries_Category(long lectureseriesCategoryId) {

		return _lectureseries_CategoryLocalService.fetchLectureseries_Category(
			lectureseriesCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lectureseries_CategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lectureseries_CategoryLocalService.
			getIndexableActionableDynamicQuery();
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Category>
		getLectureseries_Categories(int start, int end) {

		return _lectureseries_CategoryLocalService.getLectureseries_Categories(
			start, end);
	}

	/**
	 * Returns the number of lectureseries_ categories.
	 *
	 * @return the number of lectureseries_ categories
	 */
	@Override
	public int getLectureseries_CategoriesCount() {
		return _lectureseries_CategoryLocalService.
			getLectureseries_CategoriesCount();
	}

	/**
	 * Returns the lectureseries_ category with the primary key.
	 *
	 * @param lectureseriesCategoryId the primary key of the lectureseries_ category
	 * @return the lectureseries_ category
	 * @throws PortalException if a lectureseries_ category with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
			getLectureseries_Category(long lectureseriesCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_CategoryLocalService.getLectureseries_Category(
			lectureseriesCategoryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lectureseries_CategoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_CategoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void updateCategoryByLectureseriesAndCategory(
		Long lectureseriesId, Long categoryId, Long newCategoryId) {

		_lectureseries_CategoryLocalService.
			updateCategoryByLectureseriesAndCategory(
				lectureseriesId, categoryId, newCategoryId);
	}

	/**
	 * Updates the lectureseries_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Category the lectureseries_ category
	 * @return the lectureseries_ category that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Category
		updateLectureseries_Category(
			de.uhh.l2g.plugins.model.Lectureseries_Category
				lectureseries_Category) {

		return _lectureseries_CategoryLocalService.updateLectureseries_Category(
			lectureseries_Category);
	}

	@Override
	public Lectureseries_CategoryLocalService getWrappedService() {
		return _lectureseries_CategoryLocalService;
	}

	@Override
	public void setWrappedService(
		Lectureseries_CategoryLocalService lectureseries_CategoryLocalService) {

		_lectureseries_CategoryLocalService =
			lectureseries_CategoryLocalService;
	}

	private Lectureseries_CategoryLocalService
		_lectureseries_CategoryLocalService;

}