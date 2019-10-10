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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VideoStatisticLocalService}.
 *
 * @author Iavor Sturm
 * @see VideoStatisticLocalService
 * @generated
 */
@ProviderType
public class VideoStatisticLocalServiceWrapper
	implements VideoStatisticLocalService,
		ServiceWrapper<VideoStatisticLocalService> {
	public VideoStatisticLocalServiceWrapper(
		VideoStatisticLocalService videoStatisticLocalService) {
		_videoStatisticLocalService = videoStatisticLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _videoStatisticLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoStatisticLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _videoStatisticLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _videoStatisticLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _videoStatisticLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the video statistic to the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was added
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic addVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic) {
		return _videoStatisticLocalService.addVideoStatistic(videoStatistic);
	}

	/**
	* Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	*
	* @param videoStatisticId the primary key for the new video statistic
	* @return the new video statistic
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic createVideoStatistic(
		long videoStatisticId) {
		return _videoStatisticLocalService.createVideoStatistic(videoStatisticId);
	}

	/**
	* Deletes the video statistic from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was removed
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic deleteVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic) {
		return _videoStatisticLocalService.deleteVideoStatistic(videoStatistic);
	}

	/**
	* Deletes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic that was removed
	* @throws PortalException if a video statistic with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic deleteVideoStatistic(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _videoStatisticLocalService.deleteVideoStatistic(videoStatisticId);
	}

	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic fetchVideoStatistic(
		long videoStatisticId) {
		return _videoStatisticLocalService.fetchVideoStatistic(videoStatisticId);
	}

	/**
	* Returns the video statistic with the primary key.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic
	* @throws PortalException if a video statistic with the primary key could not be found
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic getVideoStatistic(
		long videoStatisticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _videoStatisticLocalService.getVideoStatistic(videoStatisticId);
	}

	/**
	* Updates the video statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoStatistic the video statistic
	* @return the video statistic that was updated
	*/
	@Override
	public de.uhh.l2g.plugins.model.VideoStatistic updateVideoStatistic(
		de.uhh.l2g.plugins.model.VideoStatistic videoStatistic) {
		return _videoStatisticLocalService.updateVideoStatistic(videoStatistic);
	}

	/**
	* Returns the number of video statistics.
	*
	* @return the number of video statistics
	*/
	@Override
	public int getVideoStatisticsCount() {
		return _videoStatisticLocalService.getVideoStatisticsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _videoStatisticLocalService.getOSGiServiceIdentifier();
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _videoStatisticLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getAllStatistics()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getAllStatistics();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getByCompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoStatisticLocalService.getByCompanyIdAndGroupId(companyId,
			groupId);
	}

	/**
	* Returns a range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of video statistics
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.VideoStatistic> getVideoStatistics(
		int start, int end) {
		return _videoStatisticLocalService.getVideoStatistics(start, end);
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
		return _videoStatisticLocalService.dynamicQueryCount(dynamicQuery);
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
		return _videoStatisticLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public VideoStatisticLocalService getWrappedService() {
		return _videoStatisticLocalService;
	}

	@Override
	public void setWrappedService(
		VideoStatisticLocalService videoStatisticLocalService) {
		_videoStatisticLocalService = videoStatisticLocalService;
	}

	private VideoStatisticLocalService _videoStatisticLocalService;
}