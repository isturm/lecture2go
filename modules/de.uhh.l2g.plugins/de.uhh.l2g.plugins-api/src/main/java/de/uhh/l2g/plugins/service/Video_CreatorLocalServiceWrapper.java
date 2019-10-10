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
 * Provides a wrapper for {@link Video_CreatorLocalService}.
 *
 * @author Iavor Sturm
 * @see Video_CreatorLocalService
 * @generated
 */
@ProviderType
public class Video_CreatorLocalServiceWrapper
	implements Video_CreatorLocalService,
			   ServiceWrapper<Video_CreatorLocalService> {

	public Video_CreatorLocalServiceWrapper(
		Video_CreatorLocalService video_CreatorLocalService) {

		_video_CreatorLocalService = video_CreatorLocalService;
	}

	/**
	 * Adds the video_ creator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Creator the video_ creator
	 * @return the video_ creator that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator addVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {

		return _video_CreatorLocalService.addVideo_Creator(video_Creator);
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator createVideo_Creator(
		long videoCreatorId) {

		return _video_CreatorLocalService.createVideo_Creator(videoCreatorId);
	}

	@Override
	public void deleteByCreatorId(Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_video_CreatorLocalService.deleteByCreatorId(creatorId);
	}

	@Override
	public void deleteByVideoId(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_video_CreatorLocalService.deleteByVideoId(videoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CreatorLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws PortalException if a video_ creator with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
			long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CreatorLocalService.deleteVideo_Creator(videoCreatorId);
	}

	/**
	 * Deletes the video_ creator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_Creator the video_ creator
	 * @return the video_ creator that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator deleteVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {

		return _video_CreatorLocalService.deleteVideo_Creator(video_Creator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _video_CreatorLocalService.dynamicQuery();
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

		return _video_CreatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _video_CreatorLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _video_CreatorLocalService.dynamicQuery(
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

		return _video_CreatorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _video_CreatorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Creator fetchVideo_Creator(
		long videoCreatorId) {

		return _video_CreatorLocalService.fetchVideo_Creator(videoCreatorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _video_CreatorLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByCreator(
			Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _video_CreatorLocalService.getByCreator(creatorId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator> getByVideo(
			Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _video_CreatorLocalService.getByVideo(videoId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator>
			getByVideoCreator(Long videoId, Long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _video_CreatorLocalService.getByVideoCreator(videoId, creatorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _video_CreatorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _video_CreatorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CreatorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the video_ creator with the primary key.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws PortalException if a video_ creator with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator getVideo_Creator(
			long videoCreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video_CreatorLocalService.getVideo_Creator(videoCreatorId);
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Video_Creator>
		getVideo_Creators(int start, int end) {

		return _video_CreatorLocalService.getVideo_Creators(start, end);
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
	 */
	@Override
	public int getVideo_CreatorsCount() {
		return _video_CreatorLocalService.getVideo_CreatorsCount();
	}

	/**
	 * Updates the video_ creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video_Creator the video_ creator
	 * @return the video_ creator that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Video_Creator updateVideo_Creator(
		de.uhh.l2g.plugins.model.Video_Creator video_Creator) {

		return _video_CreatorLocalService.updateVideo_Creator(video_Creator);
	}

	@Override
	public Video_CreatorLocalService getWrappedService() {
		return _video_CreatorLocalService;
	}

	@Override
	public void setWrappedService(
		Video_CreatorLocalService video_CreatorLocalService) {

		_video_CreatorLocalService = video_CreatorLocalService;
	}

	private Video_CreatorLocalService _video_CreatorLocalService;

}