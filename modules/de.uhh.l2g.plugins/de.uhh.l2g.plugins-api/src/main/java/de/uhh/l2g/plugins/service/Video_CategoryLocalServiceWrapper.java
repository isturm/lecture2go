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
 * Provides a wrapper for {@link Video_CategoryLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_CategoryLocalService
 * @generated
 */
@ProviderType
public class Video_CategoryLocalServiceWrapper
	implements Video_CategoryLocalService,
			   ServiceWrapper<Video_CategoryLocalService> {

	public Video_CategoryLocalServiceWrapper(
		Video_CategoryLocalService video_CategoryLocalService) {

		_video_CategoryLocalService = video_CategoryLocalService;
	}

	/**
	 * Adds the video_ category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category addVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return _video_CategoryLocalService.addVideo_Category(video_Category);
	}

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category createVideo_Category(
		long videoCategoryId) {

		return _video_CategoryLocalService.createVideo_Category(
			videoCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CategoryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws PortalException if a video_ category with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category deleteVideo_Category(
			long videoCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CategoryLocalService.deleteVideo_Category(
			videoCategoryId);
	}

	/**
	 * Deletes the video_ category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category deleteVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return _video_CategoryLocalService.deleteVideo_Category(video_Category);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_CategoryLocalService.dynamicQuery();
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

		return _video_CategoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _video_CategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _video_CategoryLocalService.dynamicQuery(
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

		return _video_CategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _video_CategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Category fetchVideo_Category(
		long videoCategoryId) {

		return _video_CategoryLocalService.fetchVideo_Category(videoCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _video_CategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Category>
			getByCategory(Long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _video_CategoryLocalService.getByCategory(categoryId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Category> getByVideo(
			Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _video_CategoryLocalService.getByVideo(videoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _video_CategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _video_CategoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CategoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Category>
		getVideo_Categories(int start, int end) {

		return _video_CategoryLocalService.getVideo_Categories(start, end);
	}

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
	 */
	@Override
	public int getVideo_CategoriesCount() {
		return _video_CategoryLocalService.getVideo_CategoriesCount();
	}

	/**
	 * Returns the video_ category with the primary key.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws PortalException if a video_ category with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category getVideo_Category(
			long videoCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CategoryLocalService.getVideo_Category(videoCategoryId);
	}

	@Override
	public void removeByVideo(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_video_CategoryLocalService.removeByVideo(videoId);
	}

	@Override
	public void updateCategoryByVideoAndCategory(
		Long videoId, Long categoryId, Long newCategoryId) {

		_video_CategoryLocalService.updateCategoryByVideoAndCategory(
			videoId, categoryId, newCategoryId);
	}

	/**
	 * Updates the video_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video_Category the video_ category
	 * @return the video_ category that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Category updateVideo_Category(
		de.uhh.l2g.plugins.model.Video_Category video_Category) {

		return _video_CategoryLocalService.updateVideo_Category(video_Category);
	}

	@Override
	public Video_CategoryLocalService getWrappedService() {
		return _video_CategoryLocalService;
	}

	@Override
	public void setWrappedService(
		Video_CategoryLocalService video_CategoryLocalService) {

		_video_CategoryLocalService = video_CategoryLocalService;
	}

	private Video_CategoryLocalService _video_CategoryLocalService;

}