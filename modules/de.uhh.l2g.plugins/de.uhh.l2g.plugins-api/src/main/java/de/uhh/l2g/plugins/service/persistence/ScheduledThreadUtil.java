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

import de.uhh.l2g.plugins.model.ScheduledThread;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the scheduled thread service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.ScheduledThreadPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThreadPersistence
 * @generated
 */
@ProviderType
public class ScheduledThreadUtil {

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
	public static void clearCache(ScheduledThread scheduledThread) {
		getPersistence().clearCache(scheduledThread);
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
	public static Map<Serializable, ScheduledThread> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScheduledThread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ScheduledThread update(ScheduledThread scheduledThread) {
		return getPersistence().update(scheduledThread);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ScheduledThread update(
		ScheduledThread scheduledThread, ServiceContext serviceContext) {

		return getPersistence().update(scheduledThread, serviceContext);
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findBySchedulerClassName(
			String schedulerClassName)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findBySchedulerClassName(schedulerClassName);
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBySchedulerClassName(String)}
	 * @param schedulerClassName the scheduler class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Deprecated
	public static ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName, boolean useFinderCache) {

		return getPersistence().fetchBySchedulerClassName(
			schedulerClassName, useFinderCache);
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName) {

		return getPersistence().fetchBySchedulerClassName(schedulerClassName);
	}

	/**
	 * Removes the scheduled thread where schedulerClassName = &#63; from the database.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the scheduled thread that was removed
	 */
	public static ScheduledThread removeBySchedulerClassName(
			String schedulerClassName)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().removeBySchedulerClassName(schedulerClassName);
	}

	/**
	 * Returns the number of scheduled threads where schedulerClassName = &#63;.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the number of matching scheduled threads
	 */
	public static int countBySchedulerClassName(String schedulerClassName) {
		return getPersistence().countBySchedulerClassName(schedulerClassName);
	}

	/**
	 * Returns all the scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public static List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByGroup_First(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByGroup_First(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByGroup_Last(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByGroup_Last(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread[] findByGroup_PrevAndNext(
			long scheduledThreadId, long groupId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroup_PrevAndNext(
			scheduledThreadId, groupId, orderByComparator);
	}

	/**
	 * Removes all the scheduled threads where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching scheduled threads
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	public static List<ScheduledThread> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public static List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByCompany_First(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByCompany_First(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByCompany_Last(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByCompany_Last(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread[] findByCompany_PrevAndNext(
			long scheduledThreadId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByCompany_PrevAndNext(
			scheduledThreadId, companyId, orderByComparator);
	}

	/**
	 * Removes all the scheduled threads where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public static List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public static List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public static ScheduledThread findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public static ScheduledThread fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread[] findByGroupAndCompany_PrevAndNext(
			long scheduledThreadId, long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			scheduledThreadId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the scheduled threads where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the scheduled thread in the entity cache if it is enabled.
	 *
	 * @param scheduledThread the scheduled thread
	 */
	public static void cacheResult(ScheduledThread scheduledThread) {
		getPersistence().cacheResult(scheduledThread);
	}

	/**
	 * Caches the scheduled threads in the entity cache if it is enabled.
	 *
	 * @param scheduledThreads the scheduled threads
	 */
	public static void cacheResult(List<ScheduledThread> scheduledThreads) {
		getPersistence().cacheResult(scheduledThreads);
	}

	/**
	 * Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	 *
	 * @param scheduledThreadId the primary key for the new scheduled thread
	 * @return the new scheduled thread
	 */
	public static ScheduledThread create(long scheduledThreadId) {
		return getPersistence().create(scheduledThreadId);
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread remove(long scheduledThreadId)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().remove(scheduledThreadId);
	}

	public static ScheduledThread updateImpl(ScheduledThread scheduledThread) {
		return getPersistence().updateImpl(scheduledThread);
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException {

		return getPersistence().findByPrimaryKey(scheduledThreadId);
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 */
	public static ScheduledThread fetchByPrimaryKey(long scheduledThreadId) {
		return getPersistence().fetchByPrimaryKey(scheduledThreadId);
	}

	/**
	 * Returns all the scheduled threads.
	 *
	 * @return the scheduled threads
	 */
	public static List<ScheduledThread> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of scheduled threads
	 */
	public static List<ScheduledThread> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of scheduled threads
	 */
	@Deprecated
	public static List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scheduled threads
	 */
	public static List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the scheduled threads from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of scheduled threads.
	 *
	 * @return the number of scheduled threads
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ScheduledThreadPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ScheduledThreadPersistence, ScheduledThreadPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ScheduledThreadPersistence.class);

		ServiceTracker<ScheduledThreadPersistence, ScheduledThreadPersistence>
			serviceTracker =
				new ServiceTracker
					<ScheduledThreadPersistence, ScheduledThreadPersistence>(
						bundle.getBundleContext(),
						ScheduledThreadPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}