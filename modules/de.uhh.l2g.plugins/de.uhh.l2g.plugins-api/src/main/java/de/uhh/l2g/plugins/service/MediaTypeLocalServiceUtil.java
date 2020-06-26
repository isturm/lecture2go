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
 * Provides the local service utility for MediaType. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.MediaTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see MediaTypeLocalService
 * @generated
 */
@ProviderType
public class MediaTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.MediaTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the media type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was added
	 */
	public static de.uhh.l2g.plugins.model.MediaType addMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return getService().addMediaType(mediaType);
	}

	/**
	 * Creates a new media type with the primary key. Does not add the media type to the database.
	 *
	 * @param mediaTypeId the primary key for the new media type
	 * @return the new media type
	 */
	public static de.uhh.l2g.plugins.model.MediaType createMediaType(
		long mediaTypeId) {

		return getService().createMediaType(mediaTypeId);
	}

	/**
	 * Deletes the media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type that was removed
	 * @throws PortalException if a media type with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.MediaType deleteMediaType(
			long mediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMediaType(mediaTypeId);
	}

	/**
	 * Deletes the media type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was removed
	 */
	public static de.uhh.l2g.plugins.model.MediaType deleteMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return getService().deleteMediaType(mediaType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.MediaType fetchMediaType(
		long mediaTypeId) {

		return getService().fetchMediaType(mediaTypeId);
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
	 * Returns the media type with the primary key.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type
	 * @throws PortalException if a media type with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.MediaType getMediaType(
			long mediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMediaType(mediaTypeId);
	}

	/**
	 * Returns a range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of media types
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.MediaType>
		getMediaTypes(int start, int end) {

		return getService().getMediaTypes(start, end);
	}

	/**
	 * Returns the number of media types.
	 *
	 * @return the number of media types
	 */
	public static int getMediaTypesCount() {
		return getService().getMediaTypesCount();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.MediaType>
		getMediaTypesFromVideoIds(java.util.ArrayList<Long> videoIds) {

		return getService().getMediaTypesFromVideoIds(videoIds);
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
	 * Updates the media type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was updated
	 */
	public static de.uhh.l2g.plugins.model.MediaType updateMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return getService().updateMediaType(mediaType);
	}

	public static MediaTypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MediaTypeLocalService, MediaTypeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MediaTypeLocalService.class);

		ServiceTracker<MediaTypeLocalService, MediaTypeLocalService>
			serviceTracker =
				new ServiceTracker
					<MediaTypeLocalService, MediaTypeLocalService>(
						bundle.getBundleContext(), MediaTypeLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}