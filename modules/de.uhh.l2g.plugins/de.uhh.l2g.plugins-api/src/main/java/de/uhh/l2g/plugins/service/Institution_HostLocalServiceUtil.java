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
 * Provides the local service utility for Institution_Host. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.Institution_HostLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see Institution_HostLocalService
 * @generated
 */
@ProviderType
public class Institution_HostLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Institution_HostLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * if not added with Institution
	 *
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static long addDefaultInstitutionHost(
			long defaultInstitutionId, long defaultHostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addDefaultInstitutionHost(
			defaultInstitutionId, defaultHostId, serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Institution_Host addEntry(
			long institutionId, long hostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addEntry(institutionId, hostId, serviceContext);
	}

	/**
	 * Adds the institution_ host to the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was added
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host addInstitution_Host(
		de.uhh.l2g.plugins.model.Institution_Host institution_Host) {

		return getService().addInstitution_Host(institution_Host);
	}

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host
		createInstitution_Host(long institutionHostId) {

		return getService().createInstitution_Host(institutionHostId);
	}

	/**
	 * Deletes the institution_ host from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was removed
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host
		deleteInstitution_Host(
			de.uhh.l2g.plugins.model.Institution_Host institution_Host) {

		return getService().deleteInstitution_Host(institution_Host);
	}

	/**
	 * Deletes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws PortalException if a institution_ host with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host
			deleteInstitution_Host(long institutionHostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteInstitution_Host(institutionHostId);
	}

	public static de.uhh.l2g.plugins.model.Institution_Host deleteLinkById(
			long institutionHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteLinkById(institutionHostId);
	}

	public static de.uhh.l2g.plugins.model.Institution_Host deleteLinkById(
			long institutionHostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteLinkById(institutionHostId, serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Institution_Host
			deleteLinkByInstitution(
				de.uhh.l2g.plugins.model.Institution institution, long groupId,
				long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteLinkByInstitution(
			institution, groupId, companyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Institution_Host
		fetchInstitution_Host(long institutionHostId) {

		return getService().fetchInstitution_Host(institutionHostId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int getByCompanyIdAndHostIdCount(long companyId, long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCompanyIdAndHostIdCount(companyId, hostId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host>
			getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupId(groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution>
			getByGroupIdAndHostId(long groupId, long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndHostId(groupId, hostId);
	}

	public static int getByGroupIdAndHostIdCount(long groupId, long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndHostIdCount(groupId, hostId);
	}

	public static de.uhh.l2g.plugins.model.Host getByGroupIdAndInstitutionId(
			long companyId, long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndInstitutionId(
			companyId, groupId, institutionId);
	}

	public static de.uhh.l2g.plugins.model.Host getByInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByInstitution(institutionId);
	}

	public static de.uhh.l2g.plugins.model.Host getByInstitutionId(
			long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByInstitutionId(institutionId);
	}

	/**
	 * Assume one Institution has at most one Host that remains constant
	 */
	public static long getDefaultInstitutionHostId(
		long companyId, long groupId) {

		return getService().getDefaultInstitutionHostId(companyId, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the institution_ host with the primary key.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws PortalException if a institution_ host with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host getInstitution_Host(
			long institutionHostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInstitution_Host(institutionHostId);
	}

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host>
		getInstitution_Hosts(int start, int end) {

		return getService().getInstitution_Hosts(start, end);
	}

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
	 */
	public static int getInstitution_HostsCount() {
		return getService().getInstitution_HostsCount();
	}

	public static de.uhh.l2g.plugins.model.Institution_Host
			getLinkByGroupIdAndInstitutionId(long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getLinkByGroupIdAndInstitutionId(
			groupId, institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host>
			getListByGroupIdAndHostId(long groupId, long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getListByGroupIdAndHostId(groupId, hostId);
	}

	/**
	 * Actually this should never give a list because, there can be only one host per isntitution
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host>
			getListByGroupIdAndInstitutionId(
				long companyId, long groupId, long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getListByGroupIdAndInstitutionId(
			companyId, groupId, institutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Institution_Host>
			getListByInstitutionId(long institutionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getListByInstitutionId(institutionId);
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

	public static de.uhh.l2g.plugins.model.Institution_Host updateEntry(
			long institutionId, long hostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateEntry(institutionId, hostId, serviceContext);
	}

	/**
	 * Updates the institution_ host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was updated
	 */
	public static de.uhh.l2g.plugins.model.Institution_Host
		updateInstitution_Host(
			de.uhh.l2g.plugins.model.Institution_Host institution_Host) {

		return getService().updateInstitution_Host(institution_Host);
	}

	public static Institution_HostLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Institution_HostLocalService, Institution_HostLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Institution_HostLocalService.class);

		ServiceTracker
			<Institution_HostLocalService, Institution_HostLocalService>
				serviceTracker =
					new ServiceTracker
						<Institution_HostLocalService,
						 Institution_HostLocalService>(
							 bundle.getBundleContext(),
							 Institution_HostLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}