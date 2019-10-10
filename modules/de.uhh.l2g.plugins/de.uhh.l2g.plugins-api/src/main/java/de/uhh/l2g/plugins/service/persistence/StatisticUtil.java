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

import de.uhh.l2g.plugins.model.Statistic;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the statistic service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.StatisticPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticPersistence
 * @generated
 */
@ProviderType
public class StatisticUtil {

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
	public static void clearCache(Statistic statistic) {
		getPersistence().clearCache(statistic);
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
	public static Map<Serializable, Statistic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Statistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Statistic update(Statistic statistic) {
		return getPersistence().update(statistic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Statistic update(
		Statistic statistic, ServiceContext serviceContext) {

		return getPersistence().update(statistic, serviceContext);
	}

	/**
	 * Returns the statistic where statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByStatisticId(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByStatisticId(statisticId);
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByStatisticId(long)}
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Deprecated
	public static Statistic fetchByStatisticId(
		long statisticId, boolean useFinderCache) {

		return getPersistence().fetchByStatisticId(statisticId, useFinderCache);
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByStatisticId(long statisticId) {
		return getPersistence().fetchByStatisticId(statisticId);
	}

	/**
	 * Removes the statistic where statisticId = &#63; from the database.
	 *
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	public static Statistic removeByStatisticId(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().removeByStatisticId(statisticId);
	}

	/**
	 * Returns the number of statistics where statisticId = &#63;.
	 *
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	public static int countByStatisticId(long statisticId) {
		return getPersistence().countByStatisticId(statisticId);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByC_G_S(
			long companyId, long groupId, long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByC_G_S(companyId, groupId, statisticId);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByC_G_S(long,long,long)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Deprecated
	public static Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_G_S(
			companyId, groupId, statisticId, useFinderCache);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId) {

		return getPersistence().fetchByC_G_S(companyId, groupId, statisticId);
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	public static Statistic removeByC_G_S(
			long companyId, long groupId, long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().removeByC_G_S(companyId, groupId, statisticId);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	public static int countByC_G_S(
		long companyId, long groupId, long statisticId) {

		return getPersistence().countByC_G_S(companyId, groupId, statisticId);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByC_G_D(
			long companyId, long groupId, Date createDate)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByC_G_D(companyId, groupId, createDate);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByC_G_D(long,long,Date)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Deprecated
	public static Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate, boolean useFinderCache) {

		return getPersistence().fetchByC_G_D(
			companyId, groupId, createDate, useFinderCache);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate) {

		return getPersistence().fetchByC_G_D(companyId, groupId, createDate);
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the statistic that was removed
	 */
	public static Statistic removeByC_G_D(
			long companyId, long groupId, Date createDate)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().removeByC_G_D(companyId, groupId, createDate);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the number of matching statistics
	 */
	public static int countByC_G_D(
		long companyId, long groupId, Date createDate) {

		return getPersistence().countByC_G_D(companyId, groupId, createDate);
	}

	/**
	 * Returns all the statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching statistics
	 */
	public static List<Statistic> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	public static List<Statistic> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Deprecated
	public static List<Statistic> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	public static List<Statistic> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByGroup_First(
			long groupId, OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByGroup_First(
		long groupId, OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByGroup_Last(
			long groupId, OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByGroup_Last(
		long groupId, OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where groupId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public static Statistic[] findByGroup_PrevAndNext(
			long statisticId, long groupId,
			OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroup_PrevAndNext(
			statisticId, groupId, orderByComparator);
	}

	/**
	 * Removes all the statistics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching statistics
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	public static List<Statistic> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	public static List<Statistic> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Deprecated
	public static List<Statistic> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	public static List<Statistic> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByCompany_First(
			long companyId, OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByCompany_First(
		long companyId, OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByCompany_Last(
			long companyId, OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByCompany_Last(
		long companyId, OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where companyId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public static Statistic[] findByCompany_PrevAndNext(
			long statisticId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByCompany_PrevAndNext(
			statisticId, companyId, orderByComparator);
	}

	/**
	 * Removes all the statistics where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	public static List<Statistic> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	public static List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Deprecated
	public static List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	public static List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public static Statistic findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public static Statistic fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public static Statistic[] findByGroupAndCompany_PrevAndNext(
			long statisticId, long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			statisticId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the statistics where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the statistic in the entity cache if it is enabled.
	 *
	 * @param statistic the statistic
	 */
	public static void cacheResult(Statistic statistic) {
		getPersistence().cacheResult(statistic);
	}

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	public static void cacheResult(List<Statistic> statistics) {
		getPersistence().cacheResult(statistics);
	}

	/**
	 * Creates a new statistic with the primary key. Does not add the statistic to the database.
	 *
	 * @param statisticId the primary key for the new statistic
	 * @return the new statistic
	 */
	public static Statistic create(long statisticId) {
		return getPersistence().create(statisticId);
	}

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public static Statistic remove(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().remove(statisticId);
	}

	public static Statistic updateImpl(Statistic statistic) {
		return getPersistence().updateImpl(statistic);
	}

	/**
	 * Returns the statistic with the primary key or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public static Statistic findByPrimaryKey(long statisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchStatisticException {

		return getPersistence().findByPrimaryKey(statisticId);
	}

	/**
	 * Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	 */
	public static Statistic fetchByPrimaryKey(long statisticId) {
		return getPersistence().fetchByPrimaryKey(statisticId);
	}

	/**
	 * Returns all the statistics.
	 *
	 * @return the statistics
	 */
	public static List<Statistic> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of statistics
	 */
	public static List<Statistic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of statistics
	 */
	@Deprecated
	public static List<Statistic> findAll(
		int start, int end, OrderByComparator<Statistic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of statistics
	 */
	public static List<Statistic> findAll(
		int start, int end, OrderByComparator<Statistic> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the statistics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of statistics.
	 *
	 * @return the number of statistics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatisticPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatisticPersistence, StatisticPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StatisticPersistence.class);

		ServiceTracker<StatisticPersistence, StatisticPersistence>
			serviceTracker =
				new ServiceTracker<StatisticPersistence, StatisticPersistence>(
					bundle.getBundleContext(), StatisticPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}