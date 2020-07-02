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

import de.uhh.l2g.plugins.model.Coordinator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the coordinator service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.CoordinatorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorPersistence
 * @generated
 */
public class CoordinatorUtil {

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
	public static void clearCache(Coordinator coordinator) {
		getPersistence().clearCache(coordinator);
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
	public static Map<Serializable, Coordinator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coordinator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Coordinator update(Coordinator coordinator) {
		return getPersistence().update(coordinator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Coordinator update(
		Coordinator coordinator, ServiceContext serviceContext) {

		return getPersistence().update(coordinator, serviceContext);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByInstitution(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByInstitution(institutionId);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByInstitution(long institutionId) {
		return getPersistence().fetchByInstitution(institutionId);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByInstitution(
		long institutionId, boolean useFinderCache) {

		return getPersistence().fetchByInstitution(
			institutionId, useFinderCache);
	}

	/**
	 * Removes the coordinator where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the coordinator that was removed
	 */
	public static Coordinator removeByInstitution(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().removeByInstitution(institutionId);
	}

	/**
	 * Returns the number of coordinators where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching coordinators
	 */
	public static int countByInstitution(long institutionId) {
		return getPersistence().countByInstitution(institutionId);
	}

	/**
	 * Returns all the coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching coordinators
	 */
	public static List<Coordinator> findByOffice(long officeId) {
		return getPersistence().findByOffice(officeId);
	}

	/**
	 * Returns a range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	public static List<Coordinator> findByOffice(
		long officeId, int start, int end) {

		return getPersistence().findByOffice(officeId, start, end);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findByOffice(
			officeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOffice(
			officeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByOffice_First(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByOffice_First(officeId, orderByComparator);
	}

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByOffice_First(
		long officeId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByOffice_First(
			officeId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByOffice_Last(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByOffice_Last(officeId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByOffice_Last(
		long officeId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByOffice_Last(officeId, orderByComparator);
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator[] findByOffice_PrevAndNext(
			long coordinatorId, long officeId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByOffice_PrevAndNext(
			coordinatorId, officeId, orderByComparator);
	}

	/**
	 * Removes all the coordinators where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	public static void removeByOffice(long officeId) {
		getPersistence().removeByOffice(officeId);
	}

	/**
	 * Returns the number of coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching coordinators
	 */
	public static int countByOffice(long officeId) {
		return getPersistence().countByOffice(officeId);
	}

	/**
	 * Returns all the coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching coordinators
	 */
	public static List<Coordinator> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	public static List<Coordinator> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByGroup_First(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByGroup_First(
		long groupId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByGroup_Last(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByGroup_Last(
		long groupId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator[] findByGroup_PrevAndNext(
			long coordinatorId, long groupId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroup_PrevAndNext(
			coordinatorId, groupId, orderByComparator);
	}

	/**
	 * Removes all the coordinators where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching coordinators
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	public static List<Coordinator> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	public static List<Coordinator> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByCompany_First(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByCompany_First(
		long companyId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByCompany_Last(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByCompany_Last(
		long companyId, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator[] findByCompany_PrevAndNext(
			long coordinatorId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByCompany_PrevAndNext(
			coordinatorId, companyId, orderByComparator);
	}

	/**
	 * Removes all the coordinators where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	public static List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	public static List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	public static List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public static Coordinator findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public static Coordinator fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator[] findByGroupAndCompany_PrevAndNext(
			long coordinatorId, long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			coordinatorId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the coordinators where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the coordinator in the entity cache if it is enabled.
	 *
	 * @param coordinator the coordinator
	 */
	public static void cacheResult(Coordinator coordinator) {
		getPersistence().cacheResult(coordinator);
	}

	/**
	 * Caches the coordinators in the entity cache if it is enabled.
	 *
	 * @param coordinators the coordinators
	 */
	public static void cacheResult(List<Coordinator> coordinators) {
		getPersistence().cacheResult(coordinators);
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	public static Coordinator create(long coordinatorId) {
		return getPersistence().create(coordinatorId);
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator remove(long coordinatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().remove(coordinatorId);
	}

	public static Coordinator updateImpl(Coordinator coordinator) {
		return getPersistence().updateImpl(coordinator);
	}

	/**
	 * Returns the coordinator with the primary key or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public static Coordinator findByPrimaryKey(long coordinatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCoordinatorException {

		return getPersistence().findByPrimaryKey(coordinatorId);
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 */
	public static Coordinator fetchByPrimaryKey(long coordinatorId) {
		return getPersistence().fetchByPrimaryKey(coordinatorId);
	}

	/**
	 * Returns all the coordinators.
	 *
	 * @return the coordinators
	 */
	public static List<Coordinator> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of coordinators
	 */
	public static List<Coordinator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coordinators
	 */
	public static List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coordinators
	 */
	public static List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the coordinators from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoordinatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CoordinatorPersistence, CoordinatorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CoordinatorPersistence.class);

		ServiceTracker<CoordinatorPersistence, CoordinatorPersistence>
			serviceTracker =
				new ServiceTracker
					<CoordinatorPersistence, CoordinatorPersistence>(
						bundle.getBundleContext(), CoordinatorPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}