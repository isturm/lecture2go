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
 * Provides a wrapper for {@link SegmentLocalService}.
 *
 * @author Iavor Sturm
 * @see SegmentLocalService
 * @generated
 */
@ProviderType
public class SegmentLocalServiceWrapper
	implements SegmentLocalService, ServiceWrapper<SegmentLocalService> {

	public SegmentLocalServiceWrapper(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	/**
	 * Adds the segment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param segment the segment
	 * @return the segment that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment addSegment(
		de.uhh.l2g.plugins.model.Segment segment) {

		return _segmentLocalService.addSegment(segment);
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment createSegment(long segmentId) {
		return _segmentLocalService.createSegment(segmentId);
	}

	/**
	 * Adds the segment to the database and generates thumb nail. Also notifies the appropriate model listeners.
	 *
	 * @param segment the segment
	 * @return the segment that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment createSegment(
			de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.createSegment(segment);
	}

	@Override
	public void deleteByVideoId(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_segmentLocalService.deleteByVideoId(videoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws PortalException if a segment with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment deleteSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.deleteSegment(segmentId);
	}

	/**
	 * Deletes the segment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segment the segment
	 * @return the segment that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment deleteSegment(
		de.uhh.l2g.plugins.model.Segment segment) {

		return _segmentLocalService.deleteSegment(segment);
	}

	@Override
	public void deleteThumbhailsFromSegment(
			de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_segmentLocalService.deleteThumbhailsFromSegment(segment);
	}

	@Override
	public void deleteThumbhailsFromSegments(
			java.util.List<de.uhh.l2g.plugins.model.Segment> segmentList)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_segmentLocalService.deleteThumbhailsFromSegments(segmentList);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _segmentLocalService.dynamicQuery();
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

		return _segmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _segmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _segmentLocalService.dynamicQuery(
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

		return _segmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _segmentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment fetchSegment(long segmentId) {
		return _segmentLocalService.fetchSegment(segmentId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment fillWithProperties(
			de.uhh.l2g.plugins.model.Segment objectSegment)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.fillWithProperties(objectSegment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _segmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _segmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _segmentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment getPreviusSegment(
			de.uhh.l2g.plugins.model.Segment segment)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.getPreviusSegment(segment);
	}

	@Override
	public Long getPreviusSegmentId(Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.getPreviusSegmentId(segmentId);
	}

	/**
	 * Returns the segment with the primary key.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws PortalException if a segment with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment getSegment(long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentLocalService.getSegment(segmentId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment getSegmentById(Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.getSegmentById(segmentId);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Segment> getSegments(
		int start, int end) {

		return _segmentLocalService.getSegments(start, end);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Segment>
			getSegmentsByVideoId(Long videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.getSegmentsByVideoId(videoId);
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	@Override
	public int getSegmentsCount() {
		return _segmentLocalService.getSegmentsCount();
	}

	@Override
	public de.uhh.l2g.plugins.model.Segment removeSegment(Long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _segmentLocalService.removeSegment(segmentId);
	}

	/**
	 * Updates the segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param segment the segment
	 * @return the segment that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Segment updateSegment(
		de.uhh.l2g.plugins.model.Segment segment) {

		return _segmentLocalService.updateSegment(segment);
	}

	@Override
	public SegmentLocalService getWrappedService() {
		return _segmentLocalService;
	}

	@Override
	public void setWrappedService(SegmentLocalService segmentLocalService) {
		_segmentLocalService = segmentLocalService;
	}

	private SegmentLocalService _segmentLocalService;

}