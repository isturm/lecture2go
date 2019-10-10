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
 * Provides a wrapper for {@link HostLocalService}.
 *
 * @author Iavor Sturm
 * @see HostLocalService
 * @generated
 */
@ProviderType
public class HostLocalServiceWrapper
	implements HostLocalService, ServiceWrapper<HostLocalService> {

	public HostLocalServiceWrapper(HostLocalService hostLocalService) {
		_hostLocalService = hostLocalService;
	}

	/**
	 * Special handling for default entries (no update)
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host addDefaultHost(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.addDefaultHost(serviceContext);
	}

	/**
	 * Adds the host to the database. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host addHost(
		de.uhh.l2g.plugins.model.Host host) {

		return _hostLocalService.addHost(host);
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host createHost(long hostId) {
		return _hostLocalService.createHost(hostId);
	}

	/**
	 * Deletes the host from the database. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host deleteHost(
		de.uhh.l2g.plugins.model.Host host) {

		return _hostLocalService.deleteHost(host);
	}

	/**
	 * Deletes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws PortalException if a host with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host deleteHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hostLocalService.deleteHost(hostId);
	}

	/**
	 * Removes database record of Host
	 *
	 * This will not remove Folder on Filesystem, Folder will not be reused
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host deleteHost(
			long hostId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.deleteHost(hostId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hostLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hostLocalService.dynamicQuery();
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

		return _hostLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _hostLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _hostLocalService.dynamicQuery(
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

		return _hostLocalService.dynamicQueryCount(dynamicQuery);
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

		return _hostLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host fetchHost(long hostId) {
		return _hostLocalService.fetchHost(hostId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hostLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host> getAll() {
		return _hostLocalService.getAll();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host> getByCompanyId(
			long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByCompanyId(companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host>
			getByCompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByCompanyIdAndGroupId(companyId, groupId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByDefault(
			long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByDefault(companyId, groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host> getByGroupId(
			long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByGroupId(groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host> getByGroupId(
			long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByGroupId(groupId, start, end);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByGroupIdAndHostId(
			long groupId, long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByGroupIdAndHostId(groupId, hostId);
	}

	@Override
	public int getByGroupIdCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByGroupIdCount(groupId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByHostId(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByHostId(hostId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByInstitution(long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getByInstitution(institutionId);
	}

	@Override
	public long getDefaultHostId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getDefaultHostId(companyId, groupId);
	}

	/**
	 * Returns the host with the primary key.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws PortalException if a host with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host getHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hostLocalService.getHost(hostId);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Host> getHosts(
		int start, int end) {

		return _hostLocalService.getHosts(start, end);
	}

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	@Override
	public int getHostsCount() {
		return _hostLocalService.getHostsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hostLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Host is locked if it is linked to an institution
	 */
	@Override
	public int getLockingElements(long companyId, long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _hostLocalService.getLockingElements(companyId, hostId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hostLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param host the host
	 * @return the host that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Host updateHost(
		de.uhh.l2g.plugins.model.Host host) {

		return _hostLocalService.updateHost(host);
	}

	@Override
	public HostLocalService getWrappedService() {
		return _hostLocalService;
	}

	@Override
	public void setWrappedService(HostLocalService hostLocalService) {
		_hostLocalService = hostLocalService;
	}

	private HostLocalService _hostLocalService;

}