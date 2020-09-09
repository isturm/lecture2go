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

/**
 * Provides a wrapper for {@link InstitutionLocalService}.
 *
 * @author Iavor Sturm
 * @see InstitutionLocalService
 * @generated
 */
public class InstitutionLocalServiceWrapper
	implements InstitutionLocalService,
			   ServiceWrapper<InstitutionLocalService> {

	public InstitutionLocalServiceWrapper(
		InstitutionLocalService institutionLocalService) {

		_institutionLocalService = institutionLocalService;
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution addDefaultInstitution(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.addDefaultInstitution(serviceContext);
	}

	/**
	 * Adds the institution to the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution addInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return _institutionLocalService.addInstitution(institution);
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution addInstitution(
			String name, long hostId, long parentId, int sort)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.addInstitution(
			name, hostId, parentId, sort);
	}

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution createInstitution(
		long institutionId) {

		return _institutionLocalService.createInstitution(institutionId);
	}

	/**
	 * Deletes the institution from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution deleteInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return _institutionLocalService.deleteInstitution(institution);
	}

	/**
	 * Deletes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws PortalException if a institution with the primary key could not be found
	 * @throws SystemException
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution deleteInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.deleteInstitution(institutionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _institutionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _institutionLocalService.dynamicQuery();
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

		return _institutionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>.
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

		return _institutionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>.
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

		return _institutionLocalService.dynamicQuery(
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

		return _institutionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _institutionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution fetchInstitution(
		long institutionId) {

		return _institutionLocalService.fetchInstitution(institutionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _institutionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.Map<String, String> getAllSortedAsTree(int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getAllSortedAsTree(begin, end);
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution getById(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getById(institutionId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByLectureseriesId(long lectureseriesId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByLectureseriesId(
			lectureseriesId, begin, end);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution> getByLevel(
			int level)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByLevel(level);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution> getByParentId(
			long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByParentId(parentId);
	}

	@Override
	public int getByParentIdCount(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByParentIdCount(parentId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByParentIdList(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByParentIdList(parentId);
	}

	@Override
	public java.util.Map<String, String> getByParentIdMap(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getByParentIdMap(parentId);
	}

	@Override
	public long getDefaultInstitutionId()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getDefaultInstitutionId();
	}

	/**
	 * Prepares the list of institutions for pending producers selection
	 * (institutions which should not be selected can be defined via properties file)
	 *
	 * @return the list of institutions for the producer to select
	 * @throws SystemException
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
			getForProducerPending()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getForProducerPending();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _institutionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the institution with the primary key.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws PortalException if a institution with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution getInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _institutionLocalService.getInstitution(institutionId);
	}

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution> getInstitutions(
		int start, int end) {

		return _institutionLocalService.getInstitutions(start, end);
	}

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
	 */
	@Override
	public int getInstitutionsCount() {
		return _institutionLocalService.getInstitutionsCount();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		getInstitutionsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds) {

		return _institutionLocalService.
			getInstitutionsFromLectureseriesIdsAndVideoIds(
				lectureseriesIds, videoIds);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		getInstitutionsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds, Long parentId) {

		return _institutionLocalService.
			getInstitutionsFromLectureseriesIdsAndVideoIds(
				lectureseriesIds, videoIds, parentId);
	}

	@Override
	public int getLockingElements(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getLockingElements(institutionId);
	}

	@Override
	public int getMaxSortByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getMaxSortByParentId(parentId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _institutionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _institutionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution getRoot()
		throws com.liferay.portal.kernel.exception.SystemException,
			   de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return _institutionLocalService.getRoot();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Institution>
			getRootInstitutionsByOpenAccessVideos()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.getRootInstitutionsByOpenAccessVideos();
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution removeByInstitutionId(
		Long institutionId) {

		return _institutionLocalService.removeByInstitutionId(institutionId);
	}

	/**
	 * Updates the institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Institution updateInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return _institutionLocalService.updateInstitution(institution);
	}

	@Override
	public de.uhh.l2g.plugins.model.Institution updateInstitution(
			long institutionId, String name, int sort)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _institutionLocalService.updateInstitution(
			institutionId, name, sort);
	}

	@Override
	public InstitutionLocalService getWrappedService() {
		return _institutionLocalService;
	}

	@Override
	public void setWrappedService(
		InstitutionLocalService institutionLocalService) {

		_institutionLocalService = institutionLocalService;
	}

	private InstitutionLocalService _institutionLocalService;

}