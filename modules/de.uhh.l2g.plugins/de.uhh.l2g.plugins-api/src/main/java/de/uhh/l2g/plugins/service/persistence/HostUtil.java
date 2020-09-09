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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Host;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the host service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.HostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see HostPersistence
 * @generated
 */
public class HostUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Host host) {
		getPersistence().clearCache(host);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Host> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Host> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Host update(Host host) {
		return getPersistence().update(host);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Host update(Host host, ServiceContext serviceContext) {
		return getPersistence().update(host, serviceContext);
	}

	/**
	 * Returns the host where defaultHost = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param defaultHost the default host
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findBydefaultHost(int defaultHost)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findBydefaultHost(defaultHost);
	}

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param defaultHost the default host
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchBydefaultHost(int defaultHost) {
		return getPersistence().fetchBydefaultHost(defaultHost);
	}

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param defaultHost the default host
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchBydefaultHost(
		int defaultHost, boolean useFinderCache) {

		return getPersistence().fetchBydefaultHost(defaultHost, useFinderCache);
	}

	/**
	 * Removes the host where defaultHost = &#63; from the database.
	 *
	 * @param defaultHost the default host
	 * @return the host that was removed
	 */
	public static Host removeBydefaultHost(int defaultHost)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeBydefaultHost(defaultHost);
	}

	/**
	 * Returns the number of hosts where defaultHost = &#63;.
	 *
	 * @param defaultHost the default host
	 * @return the number of matching hosts
	 */
	public static int countBydefaultHost(int defaultHost) {
		return getPersistence().countBydefaultHost(defaultHost);
	}

	/**
	 * Returns the host where companyId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByhostId(long companyId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByhostId(companyId);
	}

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByhostId(long companyId) {
		return getPersistence().fetchByhostId(companyId);
	}

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByhostId(long companyId, boolean useFinderCache) {
		return getPersistence().fetchByhostId(companyId, useFinderCache);
	}

	/**
	 * Removes the host where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @return the host that was removed
	 */
	public static Host removeByhostId(long companyId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeByhostId(companyId);
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public static int countByhostId(long companyId) {
		return getPersistence().countByhostId(companyId);
	}

	/**
	 * Returns the host where name = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByname(String name)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByname(name);
	}

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByname(String name) {
		return getPersistence().fetchByname(name);
	}

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByname(String name, boolean useFinderCache) {
		return getPersistence().fetchByname(name, useFinderCache);
	}

	/**
	 * Removes the host where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the host that was removed
	 */
	public static Host removeByname(String name)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeByname(name);
	}

	/**
	 * Returns the number of hosts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching hosts
	 */
	public static int countByname(String name) {
		return getPersistence().countByname(name);
	}

	/**
	 * Returns the host where directory = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param directory the directory
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findBydirectory(String directory)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findBydirectory(directory);
	}

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param directory the directory
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchBydirectory(String directory) {
		return getPersistence().fetchBydirectory(directory);
	}

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param directory the directory
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchBydirectory(
		String directory, boolean useFinderCache) {

		return getPersistence().fetchBydirectory(directory, useFinderCache);
	}

	/**
	 * Removes the host where directory = &#63; from the database.
	 *
	 * @param directory the directory
	 * @return the host that was removed
	 */
	public static Host removeBydirectory(String directory)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeBydirectory(directory);
	}

	/**
	 * Returns the number of hosts where directory = &#63;.
	 *
	 * @param directory the directory
	 * @return the number of matching hosts
	 */
	public static int countBydirectory(String directory) {
		return getPersistence().countBydirectory(directory);
	}

	/**
	 * Caches the host in the entity cache if it is enabled.
	 *
	 * @param host the host
	 */
	public static void cacheResult(Host host) {
		getPersistence().cacheResult(host);
	}

	/**
	 * Caches the hosts in the entity cache if it is enabled.
	 *
	 * @param hosts the hosts
	 */
	public static void cacheResult(List<Host> hosts) {
		getPersistence().cacheResult(hosts);
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	public static Host create(long hostId) {
		return getPersistence().create(hostId);
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host remove(long hostId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().remove(hostId);
	}

	public static Host updateImpl(Host host) {
		return getPersistence().updateImpl(host);
	}

	/**
	 * Returns the host with the primary key or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host findByPrimaryKey(long hostId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByPrimaryKey(hostId);
	}

	/**
	 * Returns the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 */
	public static Host fetchByPrimaryKey(long hostId) {
		return getPersistence().fetchByPrimaryKey(hostId);
	}

	/**
	 * Returns all the hosts.
	 *
	 * @return the hosts
	 */
	public static List<Host> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of hosts
	 */
	public static List<Host> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hosts
	 */
	public static List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hosts
	 */
	public static List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the hosts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HostPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HostPersistence, HostPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HostPersistence.class);

		ServiceTracker<HostPersistence, HostPersistence> serviceTracker =
			new ServiceTracker<HostPersistence, HostPersistence>(
				bundle.getBundleContext(), HostPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}