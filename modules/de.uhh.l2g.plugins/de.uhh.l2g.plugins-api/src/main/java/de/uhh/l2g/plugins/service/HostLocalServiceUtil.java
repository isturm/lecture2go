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
 * Provides the local service utility for Host. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.HostLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see HostLocalService
 * @generated
 */
@ProviderType
public class HostLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.HostLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Special handling for default entries (no update)
	 */
	public static de.uhh.l2g.plugins.model.Host addDefaultHost(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addDefaultHost(serviceContext);
	}

	/**
	 * Adds the host to the database. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was added
	 */
	public static de.uhh.l2g.plugins.model.Host addHost(
		de.uhh.l2g.plugins.model.Host host) {

		return getService().addHost(host);
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	public static de.uhh.l2g.plugins.model.Host createHost(long hostId) {
		return getService().createHost(hostId);
	}

	/**
	 * Deletes the host from the database. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was removed
	 */
	public static de.uhh.l2g.plugins.model.Host deleteHost(
		de.uhh.l2g.plugins.model.Host host) {

		return getService().deleteHost(host);
	}

	/**
	 * Deletes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws PortalException if a host with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Host deleteHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteHost(hostId);
	}

	/**
	 * Removes database record of Host
	 *
	 * This will not remove Folder on Filesystem, Folder will not be reused
	 */
	public static de.uhh.l2g.plugins.model.Host deleteHost(
			long hostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteHost(hostId, serviceContext);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Host fetchHost(long hostId) {
		return getService().fetchHost(hostId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Host> getAll() {
		return getService().getAll();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Host> getByCompanyId(
			long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCompanyId(companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Host>
			getByCompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCompanyIdAndGroupId(companyId, groupId);
	}

	public static de.uhh.l2g.plugins.model.Host getByDefault(
			long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByDefault(companyId, groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Host> getByGroupId(
			long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupId(groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Host> getByGroupId(
			long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupId(groupId, start, end);
	}

	public static de.uhh.l2g.plugins.model.Host getByGroupIdAndHostId(
			long groupId, long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdAndHostId(groupId, hostId);
	}

	public static int getByGroupIdCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByGroupIdCount(groupId);
	}

	public static de.uhh.l2g.plugins.model.Host getByHostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByHostId(hostId);
	}

	public static de.uhh.l2g.plugins.model.Host getByInstitution(
			long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByInstitution(institutionId);
	}

	public static long getDefaultHostId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDefaultHostId(companyId, groupId);
	}

	/**
	 * Returns the host with the primary key.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws PortalException if a host with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Host getHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getHost(hostId);
	}

	/**
	 * Returns a range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of hosts
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Host> getHosts(
		int start, int end) {

		return getService().getHosts(start, end);
	}

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	public static int getHostsCount() {
		return getService().getHostsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Host is locked if it is linked to an institution
	 */
	public static int getLockingElements(long companyId, long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getLockingElements(companyId, hostId);
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
	 * Updates the host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was updated
	 */
	public static de.uhh.l2g.plugins.model.Host updateHost(
		de.uhh.l2g.plugins.model.Host host) {

		return getService().updateHost(host);
	}

	public static HostLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HostLocalService, HostLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HostLocalService.class);

		ServiceTracker<HostLocalService, HostLocalService> serviceTracker =
			new ServiceTracker<HostLocalService, HostLocalService>(
				bundle.getBundleContext(), HostLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}