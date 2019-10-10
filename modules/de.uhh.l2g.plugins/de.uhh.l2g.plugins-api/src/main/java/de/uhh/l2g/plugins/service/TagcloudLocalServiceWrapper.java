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
 * Provides a wrapper for {@link TagcloudLocalService}.
 *
 * @author Iavor Sturm
 * @see TagcloudLocalService
 * @generated
 */
@ProviderType
public class TagcloudLocalServiceWrapper
	implements TagcloudLocalService, ServiceWrapper<TagcloudLocalService> {

	public TagcloudLocalServiceWrapper(
		TagcloudLocalService tagcloudLocalService) {

		_tagcloudLocalService = tagcloudLocalService;
	}

	@Override
	public void add(
			java.util.ArrayList<String> tagCloudArrayString, String className,
			Long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_tagcloudLocalService.add(tagCloudArrayString, className, objectId);
	}

	/**
	 * Adds the tagcloud to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloud the tagcloud
	 * @return the tagcloud that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud addTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {

		return _tagcloudLocalService.addTagcloud(tagcloud);
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud createTagcloud(long tagcloudId) {
		return _tagcloudLocalService.createTagcloud(tagcloudId);
	}

	@Override
	public void deleteByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_tagcloudLocalService.deleteByObjectId(objectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagcloudLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws PortalException if a tagcloud with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagcloudLocalService.deleteTagcloud(tagcloudId);
	}

	/**
	 * Deletes the tagcloud from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloud the tagcloud
	 * @return the tagcloud that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {

		return _tagcloudLocalService.deleteTagcloud(tagcloud);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tagcloudLocalService.dynamicQuery();
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

		return _tagcloudLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _tagcloudLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _tagcloudLocalService.dynamicQuery(
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

		return _tagcloudLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tagcloudLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud fetchTagcloud(long tagcloudId) {
		return _tagcloudLocalService.fetchTagcloud(tagcloudId);
	}

	@Override
	public void generateForAllLectureseries() {
		_tagcloudLocalService.generateForAllLectureseries();
	}

	@Override
	public void generateForAllVideos() {
		_tagcloudLocalService.generateForAllVideos();
	}

	@Override
	public void generateForLectureseries(Long lectureseriesId) {
		_tagcloudLocalService.generateForLectureseries(lectureseriesId);
	}

	@Override
	public void generateForVideo(Long videoId) {
		_tagcloudLocalService.generateForVideo(videoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tagcloudLocalService.getActionableDynamicQuery();
	}

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud getByObjectIdAndObjectClassType(
			long objectId, String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException,
			   de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return _tagcloudLocalService.getByObjectIdAndObjectClassType(
			objectId, objectClassType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tagcloudLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tagcloudLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagcloudLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tagcloud with the primary key.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws PortalException if a tagcloud with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud getTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tagcloudLocalService.getTagcloud(tagcloudId);
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Tagcloud> getTagclouds(
		int start, int end) {

		return _tagcloudLocalService.getTagclouds(start, end);
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
	 */
	@Override
	public int getTagcloudsCount() {
		return _tagcloudLocalService.getTagcloudsCount();
	}

	@Override
	public void updateByObjectIdAndObjectClassType(
			java.util.ArrayList<String> tagCloudArrayString, String className,
			long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_tagcloudLocalService.updateByObjectIdAndObjectClassType(
			tagCloudArrayString, className, objectId);
	}

	/**
	 * Updates the tagcloud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloud the tagcloud
	 * @return the tagcloud that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Tagcloud updateTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {

		return _tagcloudLocalService.updateTagcloud(tagcloud);
	}

	@Override
	public TagcloudLocalService getWrappedService() {
		return _tagcloudLocalService;
	}

	@Override
	public void setWrappedService(TagcloudLocalService tagcloudLocalService) {
		_tagcloudLocalService = tagcloudLocalService;
	}

	private TagcloudLocalService _tagcloudLocalService;

}