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

import org.osgi.annotation.versioning.ProviderType;
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
@ProviderType
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
	 * Returns all the hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	public static List<Host> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	public static List<Host> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	public static List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	public static List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByGroup_First(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByGroup_First(
		long groupId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByGroup_Last(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByGroup_Last(
		long groupId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host[] findByGroup_PrevAndNext(
			long hostId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroup_PrevAndNext(
			hostId, groupId, orderByComparator);
	}

	/**
	 * Removes all the hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public static List<Host> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	public static List<Host> findByCompany(long companyId, int start, int end) {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	public static List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	public static List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompany_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompany_First(
		long companyId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompany_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompany_Last(
		long companyId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host[] findByCompany_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompany_PrevAndNext(
			hostId, companyId, orderByComparator);
	}

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public static List<Host> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	public static List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	public static List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	public static List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host[] findByGroupAndCompany_PrevAndNext(
			long hostId, long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			hostId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the hosts where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	public static List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId) {

		return getPersistence().findByCompanyIdAndGroupId(companyId, groupId);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	public static List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end) {

		return getPersistence().findByCompanyIdAndGroupId(
			companyId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyIdAndGroupId(long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	public static List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyIdAndGroupId(
			companyId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	public static List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findByCompanyIdAndGroupId(
			companyId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompanyIdAndGroupId_First(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyIdAndGroupId_First(
			companyId, groupId, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompanyIdAndGroupId_First(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndGroupId_First(
			companyId, groupId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompanyIdAndGroupId_Last(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyIdAndGroupId_Last(
			companyId, groupId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompanyIdAndGroupId_Last(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndGroupId_Last(
			companyId, groupId, orderByComparator);
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host[] findByCompanyIdAndGroupId_PrevAndNext(
			long hostId, long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyIdAndGroupId_PrevAndNext(
			hostId, companyId, groupId, orderByComparator);
	}

	/**
	 * Removes all the hosts where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	public static void removeByCompanyIdAndGroupId(
		long companyId, long groupId) {

		getPersistence().removeByCompanyIdAndGroupId(companyId, groupId);
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public static int countByCompanyIdAndGroupId(long companyId, long groupId) {
		return getPersistence().countByCompanyIdAndGroupId(companyId, groupId);
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByG_H(long groupId, long hostId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByG_H(groupId, hostId);
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByG_H(long,long)}
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Deprecated
	public static Host fetchByG_H(
		long groupId, long hostId, boolean useFinderCache) {

		return getPersistence().fetchByG_H(groupId, hostId, useFinderCache);
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByG_H(long groupId, long hostId) {
		return getPersistence().fetchByG_H(groupId, hostId);
	}

	/**
	 * Removes the host where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the host that was removed
	 */
	public static Host removeByG_H(long groupId, long hostId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeByG_H(groupId, hostId);
	}

	/**
	 * Returns the number of hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching hosts
	 */
	public static int countByG_H(long groupId, long hostId) {
		return getPersistence().countByG_H(groupId, hostId);
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByDefaultHost(long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByDefaultHost(companyId, groupId);
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByDefaultHost(long,long)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Deprecated
	public static Host fetchByDefaultHost(
		long companyId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByDefaultHost(
			companyId, groupId, useFinderCache);
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByDefaultHost(long companyId, long groupId) {
		return getPersistence().fetchByDefaultHost(companyId, groupId);
	}

	/**
	 * Removes the host where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the host that was removed
	 */
	public static Host removeByDefaultHost(long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().removeByDefaultHost(companyId, groupId);
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public static int countByDefaultHost(long companyId, long groupId) {
		return getPersistence().countByDefaultHost(companyId, groupId);
	}

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public static List<Host> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	public static List<Host> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	public static List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	public static List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompanyId_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompanyId_First(
		long companyId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public static Host findByCompanyId_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public static Host fetchByCompanyId_Last(
		long companyId, OrderByComparator<Host> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public static Host[] findByCompanyId_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchHostException {

		return getPersistence().findByCompanyId_PrevAndNext(
			hostId, companyId, orderByComparator);
	}

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hosts
	 */
	@Deprecated
	public static List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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