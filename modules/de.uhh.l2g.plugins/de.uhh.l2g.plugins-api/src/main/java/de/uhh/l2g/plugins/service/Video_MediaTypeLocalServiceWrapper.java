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
 * Provides a wrapper for {@link Video_MediaTypeLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_MediaTypeLocalService
 * @generated
 */
@ProviderType
public class Video_MediaTypeLocalServiceWrapper
	implements Video_MediaTypeLocalService,
			   ServiceWrapper<Video_MediaTypeLocalService> {

	public Video_MediaTypeLocalServiceWrapper(
		Video_MediaTypeLocalService video_MediaTypeLocalService) {

		_video_MediaTypeLocalService = video_MediaTypeLocalService;
	}

	/**
	 * Adds the video_ media type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType addVideo_MediaType(
		de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return _video_MediaTypeLocalService.addVideo_MediaType(video_MediaType);
	}

	/**
	 * Creates a new video_ media type with the primary key. Does not add the video_ media type to the database.
	 *
	 * @param videoMediaTypeId the primary key for the new video_ media type
	 * @return the new video_ media type
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType createVideo_MediaType(
		long videoMediaTypeId) {

		return _video_MediaTypeLocalService.createVideo_MediaType(
			videoMediaTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_MediaTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws PortalException if a video_ media type with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType deleteVideo_MediaType(
			long videoMediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_MediaTypeLocalService.deleteVideo_MediaType(
			videoMediaTypeId);
	}

	/**
	 * Deletes the video_ media type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType deleteVideo_MediaType(
		de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return _video_MediaTypeLocalService.deleteVideo_MediaType(
			video_MediaType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_MediaTypeLocalService.dynamicQuery();
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

		return _video_MediaTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _video_MediaTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _video_MediaTypeLocalService.dynamicQuery(
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

		return _video_MediaTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _video_MediaTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType fetchVideo_MediaType(
		long videoMediaTypeId) {

		return _video_MediaTypeLocalService.fetchVideo_MediaType(
			videoMediaTypeId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_MediaType>
	getByVideo(Long videoId) {

		return _video_MediaTypeLocalService.getByVideo(videoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _video_MediaTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _video_MediaTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _video_MediaTypeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_MediaTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the video_ media type with the primary key.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws PortalException if a video_ media type with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType getVideo_MediaType(
			long videoMediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_MediaTypeLocalService.getVideo_MediaType(
			videoMediaTypeId);
	}

	/**
	 * Returns a range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of video_ media types
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_MediaType>
		getVideo_MediaTypes(int start, int end) {

		return _video_MediaTypeLocalService.getVideo_MediaTypes(start, end);
	}

	/**
	 * Returns the number of video_ media types.
	 *
	 * @return the number of video_ media types
	 */
	@Override
	public int getVideo_MediaTypesCount() {
		return _video_MediaTypeLocalService.getVideo_MediaTypesCount();
	}

	/**
	 * Updates the video_ media type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_MediaType updateVideo_MediaType(
		de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return _video_MediaTypeLocalService.updateVideo_MediaType(
			video_MediaType);
	}

	@Override
	public Video_MediaTypeLocalService getWrappedService() {
		return _video_MediaTypeLocalService;
	}

	@Override
	public void setWrappedService(
		Video_MediaTypeLocalService video_MediaTypeLocalService) {

		_video_MediaTypeLocalService = video_MediaTypeLocalService;
	}

	private Video_MediaTypeLocalService _video_MediaTypeLocalService;

}