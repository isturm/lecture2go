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

import de.uhh.l2g.plugins.model.Institution_Host;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the institution_ host service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Institution_HostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_HostPersistence
 * @generated
 */
@ProviderType
public class Institution_HostUtil {

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
	public static void clearCache(Institution_Host institution_Host) {
		getPersistence().clearCache(institution_Host);
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
	public static Map<Serializable, Institution_Host> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Institution_Host> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Institution_Host update(Institution_Host institution_Host) {
		return getPersistence().update(institution_Host);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Institution_Host update(
		Institution_Host institution_Host, ServiceContext serviceContext) {

		return getPersistence().update(institution_Host, serviceContext);
	}

	/**
	 * Returns all the institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByinstitutionId(
		long institutionId) {

		return getPersistence().findByinstitutionId(institutionId);
	}

	/**
	 * Returns a range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end) {

		return getPersistence().findByinstitutionId(institutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByinstitutionId(long, int, int, OrderByComparator)}
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinstitutionId(
			institutionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByinstitutionId(
			institutionId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByinstitutionId_First(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByinstitutionId_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByinstitutionId_First(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByinstitutionId_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByinstitutionId_Last(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByinstitutionId_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByinstitutionId_Last(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByinstitutionId_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByinstitutionId_PrevAndNext(
			long institutionHostId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByinstitutionId_PrevAndNext(
			institutionHostId, institutionId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public static void removeByinstitutionId(long institutionId) {
		getPersistence().removeByinstitutionId(institutionId);
	}

	/**
	 * Returns the number of institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByinstitutionId(long institutionId) {
		return getPersistence().countByinstitutionId(institutionId);
	}

	/**
	 * Returns all the institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByhostId(long hostId) {
		return getPersistence().findByhostId(hostId);
	}

	/**
	 * Returns a range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByhostId(
		long hostId, int start, int end) {

		return getPersistence().findByhostId(hostId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByhostId(long, int, int, OrderByComparator)}
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByhostId(
			hostId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByhostId(
			hostId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByhostId_First(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByhostId_First(hostId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByhostId_First(
		long hostId, OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByhostId_First(hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByhostId_Last(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByhostId_Last(hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByhostId_Last(
		long hostId, OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByhostId_Last(hostId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByhostId_PrevAndNext(
			long institutionHostId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByhostId_PrevAndNext(
			institutionHostId, hostId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	public static void removeByhostId(long hostId) {
		getPersistence().removeByhostId(hostId);
	}

	/**
	 * Returns the number of institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByhostId(long hostId) {
		return getPersistence().countByhostId(hostId);
	}

	/**
	 * Returns all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByG_H(long groupId, long hostId) {
		return getPersistence().findByG_H(groupId, hostId);
	}

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end) {

		return getPersistence().findByG_H(groupId, hostId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByG_H(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_H(
			groupId, hostId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByG_H(
			groupId, hostId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByG_H_First(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByG_H_First(
			groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByG_H_First(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByG_H_First(
			groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByG_H_Last(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByG_H_Last(
			groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByG_H_Last(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByG_H_Last(
			groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByG_H_PrevAndNext(
			long institutionHostId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByG_H_PrevAndNext(
			institutionHostId, groupId, hostId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	public static void removeByG_H(long groupId, long hostId) {
		getPersistence().removeByG_H(groupId, hostId);
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByG_H(long groupId, long hostId) {
		return getPersistence().countByG_H(groupId, hostId);
	}

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByG_I(long groupId, long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByG_I(groupId, institutionId);
	}

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByG_I(long,long)}
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Deprecated
	public static Institution_Host fetchByG_I(
		long groupId, long institutionId, boolean useFinderCache) {

		return getPersistence().fetchByG_I(
			groupId, institutionId, useFinderCache);
	}

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByG_I(
		long groupId, long institutionId) {

		return getPersistence().fetchByG_I(groupId, institutionId);
	}

	/**
	 * Removes the institution_ host where groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the institution_ host that was removed
	 */
	public static Institution_Host removeByG_I(long groupId, long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().removeByG_I(groupId, institutionId);
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and institutionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByG_I(long groupId, long institutionId) {
		return getPersistence().countByG_I(groupId, institutionId);
	}

	/**
	 * Returns all the institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByGroupId_First(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByGroupId_First(
		long groupId, OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByGroupId_Last(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByGroupId_Last(
		long groupId, OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByGroupId_PrevAndNext(
			long institutionHostId, long groupId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByGroupId_PrevAndNext(
			institutionHostId, groupId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId) {

		return getPersistence().findByC_G_H(companyId, groupId, hostId);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end) {

		return getPersistence().findByC_G_H(
			companyId, groupId, hostId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByC_G_H(long,long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_G_H(
			companyId, groupId, hostId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByC_G_H(
			companyId, groupId, hostId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByC_G_H_First(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_H_First(
			companyId, groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByC_G_H_First(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByC_G_H_First(
			companyId, groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByC_G_H_Last(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_H_Last(
			companyId, groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByC_G_H_Last(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByC_G_H_Last(
			companyId, groupId, hostId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByC_G_H_PrevAndNext(
			long institutionHostId, long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_H_PrevAndNext(
			institutionHostId, companyId, groupId, hostId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	public static void removeByC_G_H(
		long companyId, long groupId, long hostId) {

		getPersistence().removeByC_G_H(companyId, groupId, hostId);
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByC_G_H(long companyId, long groupId, long hostId) {
		return getPersistence().countByC_G_H(companyId, groupId, hostId);
	}

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId) {

		return getPersistence().findByC_G_I(companyId, groupId, institutionId);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end) {

		return getPersistence().findByC_G_I(
			companyId, groupId, institutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByC_G_I(long,long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_G_I(
			companyId, groupId, institutionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findByC_G_I(
			companyId, groupId, institutionId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByC_G_I_First(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_I_First(
			companyId, groupId, institutionId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByC_G_I_First(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByC_G_I_First(
			companyId, groupId, institutionId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findByC_G_I_Last(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_I_Last(
			companyId, groupId, institutionId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchByC_G_I_Last(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchByC_G_I_Last(
			companyId, groupId, institutionId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findByC_G_I_PrevAndNext(
			long institutionHostId, long companyId, long groupId,
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByC_G_I_PrevAndNext(
			institutionHostId, companyId, groupId, institutionId,
			orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 */
	public static void removeByC_G_I(
		long companyId, long groupId, long institutionId) {

		getPersistence().removeByC_G_I(companyId, groupId, institutionId);
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countByC_G_I(
		long companyId, long groupId, long institutionId) {

		return getPersistence().countByC_G_I(companyId, groupId, institutionId);
	}

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public static List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId) {

		return getPersistence().findBycompanyAndHost(companyId, hostId);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public static List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end) {

		return getPersistence().findBycompanyAndHost(
			companyId, hostId, start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBycompanyAndHost(long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycompanyAndHost(
			companyId, hostId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public static List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findBycompanyAndHost(
			companyId, hostId, start, end, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findBycompanyAndHost_First(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findBycompanyAndHost_First(
			companyId, hostId, orderByComparator);
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchBycompanyAndHost_First(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchBycompanyAndHost_First(
			companyId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public static Institution_Host findBycompanyAndHost_Last(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findBycompanyAndHost_Last(
			companyId, hostId, orderByComparator);
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public static Institution_Host fetchBycompanyAndHost_Last(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().fetchBycompanyAndHost_Last(
			companyId, hostId, orderByComparator);
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host[] findBycompanyAndHost_PrevAndNext(
			long institutionHostId, long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findBycompanyAndHost_PrevAndNext(
			institutionHostId, companyId, hostId, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 */
	public static void removeBycompanyAndHost(long companyId, long hostId) {
		getPersistence().removeBycompanyAndHost(companyId, hostId);
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public static int countBycompanyAndHost(long companyId, long hostId) {
		return getPersistence().countBycompanyAndHost(companyId, hostId);
	}

	/**
	 * Caches the institution_ host in the entity cache if it is enabled.
	 *
	 * @param institution_Host the institution_ host
	 */
	public static void cacheResult(Institution_Host institution_Host) {
		getPersistence().cacheResult(institution_Host);
	}

	/**
	 * Caches the institution_ hosts in the entity cache if it is enabled.
	 *
	 * @param institution_Hosts the institution_ hosts
	 */
	public static void cacheResult(List<Institution_Host> institution_Hosts) {
		getPersistence().cacheResult(institution_Hosts);
	}

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	public static Institution_Host create(long institutionHostId) {
		return getPersistence().create(institutionHostId);
	}

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host remove(long institutionHostId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().remove(institutionHostId);
	}

	public static Institution_Host updateImpl(
		Institution_Host institution_Host) {

		return getPersistence().updateImpl(institution_Host);
	}

	/**
	 * Returns the institution_ host with the primary key or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host findByPrimaryKey(long institutionHostId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException {

		return getPersistence().findByPrimaryKey(institutionHostId);
	}

	/**
	 * Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	 */
	public static Institution_Host fetchByPrimaryKey(long institutionHostId) {
		return getPersistence().fetchByPrimaryKey(institutionHostId);
	}

	/**
	 * Returns all the institution_ hosts.
	 *
	 * @return the institution_ hosts
	 */
	public static List<Institution_Host> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 */
	public static List<Institution_Host> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institution_ hosts
	 */
	@Deprecated
	public static List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institution_ hosts
	 */
	public static List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the institution_ hosts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Institution_HostPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Institution_HostPersistence, Institution_HostPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Institution_HostPersistence.class);

		ServiceTracker<Institution_HostPersistence, Institution_HostPersistence>
			serviceTracker =
				new ServiceTracker
					<Institution_HostPersistence, Institution_HostPersistence>(
						bundle.getBundleContext(),
						Institution_HostPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}