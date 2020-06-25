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

import de.uhh.l2g.plugins.model.MediaType;
import org.osgi.annotation.versioning.ProviderType;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a wrapper for {@link MediaTypeLocalService}.
 *
 * @author Iavor Sturm
 * @see MediaTypeLocalService
 * @generated
 */
@ProviderType
public class MediaTypeLocalServiceWrapper
	implements MediaTypeLocalService, ServiceWrapper<MediaTypeLocalService> {

	public MediaTypeLocalServiceWrapper(
		MediaTypeLocalService mediaTypeLocalService) {

		_mediaTypeLocalService = mediaTypeLocalService;
	}

	/**
	 * Adds the media type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType addMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return _mediaTypeLocalService.addMediaType(mediaType);
	}

	/**
	 * Creates a new media type with the primary key. Does not add the media type to the database.
	 *
	 * @param mediaTypeId the primary key for the new media type
	 * @return the new media type
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType createMediaType(
		long mediaTypeId) {

		return _mediaTypeLocalService.createMediaType(mediaTypeId);
	}

	/**
	 * Deletes the media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type that was removed
	 * @throws PortalException if a media type with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType deleteMediaType(long mediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaTypeLocalService.deleteMediaType(mediaTypeId);
	}

	/**
	 * Deletes the media type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType deleteMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return _mediaTypeLocalService.deleteMediaType(mediaType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mediaTypeLocalService.dynamicQuery();
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

		return _mediaTypeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mediaTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mediaTypeLocalService.dynamicQuery(
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

		return _mediaTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mediaTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.MediaType fetchMediaType(long mediaTypeId) {
		return _mediaTypeLocalService.fetchMediaType(mediaTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mediaTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mediaTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the media type with the primary key.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type
	 * @throws PortalException if a media type with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType getMediaType(long mediaTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaTypeLocalService.getMediaType(mediaTypeId);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.MediaType> getMediaTypes(
		int start, int end) {

		return _mediaTypeLocalService.getMediaTypes(start, end);
	}

	/**
	 * Returns the number of media types.
	 *
	 * @return the number of media types
	 */
	@Override
	public int getMediaTypesCount() {
		return _mediaTypeLocalService.getMediaTypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mediaTypeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public List<MediaType> getMediaTypesFromVideoIds(ArrayList<Long> videoIds) {
		return _mediaTypeLocalService.getMediaTypesFromVideoIds(videoIds);
	}

	/**
	 * Updates the media type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mediaType the media type
	 * @return the media type that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.MediaType updateMediaType(
		de.uhh.l2g.plugins.model.MediaType mediaType) {

		return _mediaTypeLocalService.updateMediaType(mediaType);
	}

	@Override
	public MediaTypeLocalService getWrappedService() {
		return _mediaTypeLocalService;
	}

	@Override
	public void setWrappedService(MediaTypeLocalService mediaTypeLocalService) {
		_mediaTypeLocalService = mediaTypeLocalService;
	}

	private MediaTypeLocalService _mediaTypeLocalService;

}