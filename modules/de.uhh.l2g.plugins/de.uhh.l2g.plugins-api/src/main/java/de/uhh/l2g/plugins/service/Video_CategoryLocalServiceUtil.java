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
 * Provides the local service utility for Video_Category. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.Video_CategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Video_CategoryLocalService
 * @generated
 */
@ProviderType
public class Video_CategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Video_CategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the video_ category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was added
	 */
	public static de.uhh.l2g.plugins.model.Video_Category addVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return getService().addVideo_Category(video_Category);
	}

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	public static de.uhh.l2g.plugins.model.Video_Category createVideo_Category(
		long videoCategoryId) {

		return getService().createVideo_Category(videoCategoryId);
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

	/**
	 * Deletes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws PortalException if a video_ category with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video_Category deleteVideo_Category(
			long videoCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideo_Category(videoCategoryId);
	}

	/**
	 * Deletes the video_ category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was removed
	 */
	public static de.uhh.l2g.plugins.model.Video_Category deleteVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return getService().deleteVideo_Category(video_Category);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Video_Category fetchVideo_Category(
		long videoCategoryId) {

		return getService().fetchVideo_Category(videoCategoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category>
			getByCategory(Long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCategory(categoryId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category>
			getByVideo(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByVideo(videoId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Returns a range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of video_ categories
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Video_Category>
		getVideo_Categories(int start, int end) {

		return getService().getVideo_Categories(start, end);
	}

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
	 */
	public static int getVideo_CategoriesCount() {
		return getService().getVideo_CategoriesCount();
	}

	/**
	 * Returns the video_ category with the primary key.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws PortalException if a video_ category with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video_Category getVideo_Category(
			long videoCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideo_Category(videoCategoryId);
	}

	public static void removeByVideo(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().removeByVideo(videoId);
	}

	public static void updateCategoryByVideoAndCategory(
		Long videoId, Long categoryId, Long newCategoryId) {

		getService().updateCategoryByVideoAndCategory(
			videoId, categoryId, newCategoryId);
	}

	/**
	 * Updates the video_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was updated
	 */
	public static de.uhh.l2g.plugins.model.Video_Category updateVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return getService().updateVideo_Category(video_Category);
	}

	public static Video_CategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_CategoryLocalService, Video_CategoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Video_CategoryLocalService.class);

		ServiceTracker<Video_CategoryLocalService, Video_CategoryLocalService>
			serviceTracker =
				new ServiceTracker
					<Video_CategoryLocalService, Video_CategoryLocalService>(
						bundle.getBundleContext(),
						Video_CategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}