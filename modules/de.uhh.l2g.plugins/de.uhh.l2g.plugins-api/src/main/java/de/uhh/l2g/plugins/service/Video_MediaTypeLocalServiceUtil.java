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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Video_MediaType. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.Video_MediaTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Video_MediaTypeLocalService
 * @generated
 */
public class Video_MediaTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Video_MediaTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType addMediaType(
		de.uhh.l2g.plugins.model.Video_MediaType object) {

		return getService().addMediaType(object);
	}

	/**
	 * Adds the video_ media type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was added
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType addVideo_MediaType(
		de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return getService().addVideo_MediaType(video_MediaType);
	}

	/**
	 * Creates a new video_ media type with the primary key. Does not add the video_ media type to the database.
	 *
	 * @param videoMediaTypeId the primary key for the new video_ media type
	 * @return the new video_ media type
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType
		createVideo_MediaType(long videoMediaTypeId) {

		return getService().createVideo_MediaType(videoMediaTypeId);
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
	 * Deletes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws PortalException if a video_ media type with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType
			deleteVideo_MediaType(long videoMediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideo_MediaType(videoMediaTypeId);
	}

	/**
	 * Deletes the video_ media type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was removed
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType
		deleteVideo_MediaType(
			de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return getService().deleteVideo_MediaType(video_MediaType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>.
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

	public static de.uhh.l2g.plugins.model.Video_MediaType fetchVideo_MediaType(
		long videoMediaTypeId) {

		return getService().fetchVideo_MediaType(videoMediaTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video_MediaType>
		getByVideo(Long videoId) {

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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the video_ media type with the primary key.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws PortalException if a video_ media type with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType getVideo_MediaType(
			long videoMediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideo_MediaType(videoMediaTypeId);
	}

	/**
	 * Returns a range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of video_ media types
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Video_MediaType>
		getVideo_MediaTypes(int start, int end) {

		return getService().getVideo_MediaTypes(start, end);
	}

	/**
	 * Returns the number of video_ media types.
	 *
	 * @return the number of video_ media types
	 */
	public static int getVideo_MediaTypesCount() {
		return getService().getVideo_MediaTypesCount();
	}

	/**
	 * Updates the video_ media type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video_MediaType the video_ media type
	 * @return the video_ media type that was updated
	 */
	public static de.uhh.l2g.plugins.model.Video_MediaType
		updateVideo_MediaType(
			de.uhh.l2g.plugins.model.Video_MediaType video_MediaType) {

		return getService().updateVideo_MediaType(video_MediaType);
	}

	public static Video_MediaTypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_MediaTypeLocalService, Video_MediaTypeLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Video_MediaTypeLocalService.class);

		ServiceTracker<Video_MediaTypeLocalService, Video_MediaTypeLocalService>
			serviceTracker =
				new ServiceTracker
					<Video_MediaTypeLocalService, Video_MediaTypeLocalService>(
						bundle.getBundleContext(),
						Video_MediaTypeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}