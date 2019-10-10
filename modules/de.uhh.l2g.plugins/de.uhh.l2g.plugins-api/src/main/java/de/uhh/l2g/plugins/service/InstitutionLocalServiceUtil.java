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
 * Provides the local service utility for Institution. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.InstitutionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see InstitutionLocalService
 * @generated
 */
@ProviderType
public class InstitutionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.InstitutionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the institution to the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was added
	 */
	public static de.uhh.l2g.plugins.model.Institution addInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return getService().addInstitution(institution);
	}

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	public static de.uhh.l2g.plugins.model.Institution createInstitution(
		long institutionId) {

		return getService().createInstitution(institutionId);
	}

	/**
	 * Deletes the institution from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was removed
	 */
	public static de.uhh.l2g.plugins.model.Institution deleteInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return getService().deleteInstitution(institution);
	}

	/**
	 * Deletes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws PortalException if a institution with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Institution deleteInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteInstitution(institutionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Institution fetchInstitution(
		long institutionId) {

		return getService().fetchInstitution(institutionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.Map<String, String> getAllSortedAsTree(
			int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllSortedAsTree(begin, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupId(groupId);
	}

	public static de.uhh.l2g.plugins.model.Institution getByGroupIdAndId(
			long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndId(groupId, institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByGroupIdAndParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndParent(groupId, parentId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByGroupIdAndParent(
				long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndParent(
			groupId, parentId, start, end);
	}

	public static int getByGroupIdAndParentCount(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndParentCount(groupId, parentId);
	}

	public static de.uhh.l2g.plugins.model.Institution getById(
			long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getById(institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByLectureseriesId(long lectureseriesId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByLectureseriesId(lectureseriesId, begin, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByLevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByLevel(level);
	}

	public static java.util.Map<String, String> getByParent(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByParent(parentId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByParentId(parentId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByParentId(long parentId, String type)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByParentId(parentId, type);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the institution with the primary key.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws PortalException if a institution with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Institution getInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInstitution(institutionId);
	}

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.InstitutionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
		getInstitutions(int start, int end) {

		return getService().getInstitutions(start, end);
	}

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
	 */
	public static int getInstitutionsCount() {
		return getService().getInstitutionsCount();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
		getInstitutionsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds) {

		return getService().getInstitutionsFromLectureseriesIdsAndVideoIds(
			lectureseriesIds, videoIds);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
		getInstitutionsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds, Long parentId) {

		return getService().getInstitutionsFromLectureseriesIdsAndVideoIds(
			lectureseriesIds, videoIds, parentId);
	}

	public static int getLockingElements(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getLockingElements(institutionId);
	}

	public static int getMaxSortByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getMaxSortByParentId(parentId);
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

	public static de.uhh.l2g.plugins.model.Institution getRoot(
			long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			   de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getService().getRoot(companyId, groupId);
	}

	public static de.uhh.l2g.plugins.model.Institution getRootByGroupId(
			long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getRootByGroupId(companyId, groupId);
	}

	public static de.uhh.l2g.plugins.model.Institution
			getRootByParentAndCompanyAndGroup(
				long parentId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			   de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getService().getRootByParentAndCompanyAndGroup(
			parentId, companyId, groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getRootInstitutionsByOpenAccessVideos()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getRootInstitutionsByOpenAccessVideos();
	}

	/**
	 * Updates the institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param institution the institution
	 * @return the institution that was updated
	 */
	public static de.uhh.l2g.plugins.model.Institution updateInstitution(
		de.uhh.l2g.plugins.model.Institution institution) {

		return getService().updateInstitution(institution);
	}

	public static de.uhh.l2g.plugins.model.Institution updateInstitution(
			long institutionId, String name, int sort,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateInstitution(
			institutionId, name, sort, serviceContext);
	}

	public static InstitutionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstitutionLocalService, InstitutionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InstitutionLocalService.class);

		ServiceTracker<InstitutionLocalService, InstitutionLocalService>
			serviceTracker =
				new ServiceTracker
					<InstitutionLocalService, InstitutionLocalService>(
						bundle.getBundleContext(),
						InstitutionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}