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
 * Provides a wrapper for {@link Producer_LectureseriesLocalService}.
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesLocalService
 * @generated
 */
@ProviderType
public class Producer_LectureseriesLocalServiceWrapper
	implements Producer_LectureseriesLocalService,
			   ServiceWrapper<Producer_LectureseriesLocalService> {

	public Producer_LectureseriesLocalServiceWrapper(
		Producer_LectureseriesLocalService producer_LectureseriesLocalService) {

		_producer_LectureseriesLocalService =
			producer_LectureseriesLocalService;
	}

	/**
	 * Adds the producer_ lectureseries to the database. Also notifies the appropriate model listeners.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 * @return the producer_ lectureseries that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
		addProducer_Lectureseries(
			de.uhh.l2g.plugins.model.Producer_Lectureseries
				producer_Lectureseries) {

		return _producer_LectureseriesLocalService.addProducer_Lectureseries(
			producer_Lectureseries);
	}

	/**
	 * Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	 *
	 * @param producerLectureseriesId the primary key for the new producer_ lectureseries
	 * @return the new producer_ lectureseries
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
		createProducer_Lectureseries(long producerLectureseriesId) {

		return _producer_LectureseriesLocalService.createProducer_Lectureseries(
			producerLectureseriesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _producer_LectureseriesLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws PortalException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
			deleteProducer_Lectureseries(long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _producer_LectureseriesLocalService.deleteProducer_Lectureseries(
			producerLectureseriesId);
	}

	/**
	 * Deletes the producer_ lectureseries from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
		deleteProducer_Lectureseries(
			de.uhh.l2g.plugins.model.Producer_Lectureseries
				producer_Lectureseries) {

		return _producer_LectureseriesLocalService.deleteProducer_Lectureseries(
			producer_Lectureseries);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _producer_LectureseriesLocalService.dynamicQuery();
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

		return _producer_LectureseriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _producer_LectureseriesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _producer_LectureseriesLocalService.dynamicQuery(
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

		return _producer_LectureseriesLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _producer_LectureseriesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
		fetchProducer_Lectureseries(long producerLectureseriesId) {

		return _producer_LectureseriesLocalService.fetchProducer_Lectureseries(
			producerLectureseriesId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _producer_LectureseriesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _producer_LectureseriesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _producer_LectureseriesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _producer_LectureseriesLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the producer_ lectureseries with the primary key.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws PortalException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
			getProducer_Lectureseries(long producerLectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _producer_LectureseriesLocalService.getProducer_Lectureseries(
			producerLectureseriesId);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of producer_ lectureserieses
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Producer_Lectureseries>
		getProducer_Lectureserieses(int start, int end) {

		return _producer_LectureseriesLocalService.getProducer_Lectureserieses(
			start, end);
	}

	/**
	 * Returns the number of producer_ lectureserieses.
	 *
	 * @return the number of producer_ lectureserieses
	 */
	@Override
	public int getProducer_LectureseriesesCount() {
		return _producer_LectureseriesLocalService.
			getProducer_LectureseriesesCount();
	}

	@Override
	public boolean producerAssignedToLectureseries(
		de.uhh.l2g.plugins.model.Producer_Lectureseries pl) {

		return _producer_LectureseriesLocalService.
			producerAssignedToLectureseries(pl);
	}

	@Override
	public boolean removeByLectureseriesId(Long lectureseriesId) {
		return _producer_LectureseriesLocalService.removeByLectureseriesId(
			lectureseriesId);
	}

	/**
	 * Updates the producer_ lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 * @return the producer_ lectureseries that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Producer_Lectureseries
		updateProducer_Lectureseries(
			de.uhh.l2g.plugins.model.Producer_Lectureseries
				producer_Lectureseries) {

		return _producer_LectureseriesLocalService.updateProducer_Lectureseries(
			producer_Lectureseries);
	}

	@Override
	public Producer_LectureseriesLocalService getWrappedService() {
		return _producer_LectureseriesLocalService;
	}

	@Override
	public void setWrappedService(
		Producer_LectureseriesLocalService producer_LectureseriesLocalService) {

		_producer_LectureseriesLocalService =
			producer_LectureseriesLocalService;
	}

	private Producer_LectureseriesLocalService
		_producer_LectureseriesLocalService;

}