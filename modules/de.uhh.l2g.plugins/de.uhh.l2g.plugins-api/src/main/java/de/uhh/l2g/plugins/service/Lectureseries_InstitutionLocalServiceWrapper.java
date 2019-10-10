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
 * Provides a wrapper for {@link Lectureseries_InstitutionLocalService}.
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionLocalService
 * @generated
 */
@ProviderType
public class Lectureseries_InstitutionLocalServiceWrapper
	implements Lectureseries_InstitutionLocalService,
			   ServiceWrapper<Lectureseries_InstitutionLocalService> {

	public Lectureseries_InstitutionLocalServiceWrapper(
		Lectureseries_InstitutionLocalService
			lectureseries_InstitutionLocalService) {

		_lectureseries_InstitutionLocalService =
			lectureseries_InstitutionLocalService;
	}

	/**
	 * Adds the lectureseries_ institution to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
		addLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return _lectureseries_InstitutionLocalService.
			addLectureseries_Institution(lectureseries_Institution);
	}

	/**
	 * Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	 *
	 * @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	 * @return the new lectureseries_ institution
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
		createLectureseries_Institution(long lectureseriesInstitutionId) {

		return _lectureseries_InstitutionLocalService.
			createLectureseries_Institution(lectureseriesInstitutionId);
	}

	/**
	 * Deletes the lectureseries_ institution from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
		deleteLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return _lectureseries_InstitutionLocalService.
			deleteLectureseries_Institution(lectureseries_Institution);
	}

	/**
	 * Deletes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 * @throws PortalException if a lectureseries_ institution with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
			deleteLectureseries_Institution(long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_InstitutionLocalService.
			deleteLectureseries_Institution(lectureseriesInstitutionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_InstitutionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lectureseries_InstitutionLocalService.dynamicQuery();
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

		return _lectureseries_InstitutionLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lectureseries_InstitutionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lectureseries_InstitutionLocalService.dynamicQuery(
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

		return _lectureseries_InstitutionLocalService.dynamicQueryCount(
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

		return _lectureseries_InstitutionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
		fetchLectureseries_Institution(long lectureseriesInstitutionId) {

		return _lectureseries_InstitutionLocalService.
			fetchLectureseries_Institution(lectureseriesInstitutionId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
			findFirstByLectureseriesIdAndInstitutionId(
				long lectureseriesId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseries_InstitutionLocalService.
			findFirstByLectureseriesIdAndInstitutionId(
				lectureseriesId, institutionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lectureseries_InstitutionLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution>
			getByLectureseries(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseries_InstitutionLocalService.getByLectureseries(
			lectureseriesId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lectureseries_InstitutionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lectureseries_ institution with the primary key.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution
	 * @throws PortalException if a lectureseries_ institution with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
			getLectureseries_Institution(long lectureseriesInstitutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_InstitutionLocalService.
			getLectureseries_Institution(lectureseriesInstitutionId);
	}

	/**
	 * Returns a range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Lectureseries_InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of lectureseries_ institutions
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries_Institution>
		getLectureseries_Institutions(int start, int end) {

		return _lectureseries_InstitutionLocalService.
			getLectureseries_Institutions(start, end);
	}

	/**
	 * Returns the number of lectureseries_ institutions.
	 *
	 * @return the number of lectureseries_ institutions
	 */
	@Override
	public int getLectureseries_InstitutionsCount() {
		return _lectureseries_InstitutionLocalService.
			getLectureseries_InstitutionsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lectureseries_InstitutionLocalService.
			getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseries_InstitutionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean institutionAssignedToLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries_Institution lf) {

		return _lectureseries_InstitutionLocalService.
			institutionAssignedToLectureseries(lf);
	}

	@Override
	public boolean removeByacilityId(Long institutionId) {
		return _lectureseries_InstitutionLocalService.removeByacilityId(
			institutionId);
	}

	@Override
	public boolean removeByLectureseriesId(Long lectureseriesId) {
		return _lectureseries_InstitutionLocalService.removeByLectureseriesId(
			lectureseriesId);
	}

	/**
	 * Updates the lectureseries_ institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 * @return the lectureseries_ institution that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries_Institution
		updateLectureseries_Institution(
			de.uhh.l2g.plugins.model.Lectureseries_Institution
				lectureseries_Institution) {

		return _lectureseries_InstitutionLocalService.
			updateLectureseries_Institution(lectureseries_Institution);
	}

	@Override
	public Lectureseries_InstitutionLocalService getWrappedService() {
		return _lectureseries_InstitutionLocalService;
	}

	@Override
	public void setWrappedService(
		Lectureseries_InstitutionLocalService
			lectureseries_InstitutionLocalService) {

		_lectureseries_InstitutionLocalService =
			lectureseries_InstitutionLocalService;
	}

	private Lectureseries_InstitutionLocalService
		_lectureseries_InstitutionLocalService;

}