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

import de.uhh.l2g.plugins.model.Videohitlist;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the videohitlist service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.VideohitlistPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistPersistence
 * @generated
 */
public class VideohitlistUtil {

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
	public static void clearCache(Videohitlist videohitlist) {
		getPersistence().clearCache(videohitlist);
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
	public static Map<Serializable, Videohitlist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Videohitlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Videohitlist update(Videohitlist videohitlist) {
		return getPersistence().update(videohitlist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Videohitlist update(
		Videohitlist videohitlist, ServiceContext serviceContext) {

		return getPersistence().update(videohitlist, serviceContext);
	}

	/**
	 * Returns all the videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching videohitlists
	 */
	public static List<Videohitlist> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public static List<Videohitlist> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByVideo_First(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByVideo_First(
		long videoId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByVideo_Last(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByVideo_Last(
		long videoId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist[] findByVideo_PrevAndNext(
			long videohitlistId, long videoId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByVideo_PrevAndNext(
			videohitlistId, videoId, orderByComparator);
	}

	/**
	 * Removes all the videohitlists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching videohitlists
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching videohitlists
	 */
	public static List<Videohitlist> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByGroup_First(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByGroup_First(
		long groupId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByGroup_Last(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByGroup_Last(
		long groupId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist[] findByGroup_PrevAndNext(
			long videohitlistId, long groupId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroup_PrevAndNext(
			videohitlistId, groupId, orderByComparator);
	}

	/**
	 * Removes all the videohitlists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching videohitlists
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	public static List<Videohitlist> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public static List<Videohitlist> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByCompany_First(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByCompany_First(
		long companyId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByCompany_Last(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByCompany_Last(
		long companyId, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist[] findByCompany_PrevAndNext(
			long videohitlistId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByCompany_PrevAndNext(
			videohitlistId, companyId, orderByComparator);
	}

	/**
	 * Removes all the videohitlists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	public static List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	public static List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public static Videohitlist findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public static Videohitlist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist[] findByGroupAndCompany_PrevAndNext(
			long videohitlistId, long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			videohitlistId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the videohitlists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the videohitlist in the entity cache if it is enabled.
	 *
	 * @param videohitlist the videohitlist
	 */
	public static void cacheResult(Videohitlist videohitlist) {
		getPersistence().cacheResult(videohitlist);
	}

	/**
	 * Caches the videohitlists in the entity cache if it is enabled.
	 *
	 * @param videohitlists the videohitlists
	 */
	public static void cacheResult(List<Videohitlist> videohitlists) {
		getPersistence().cacheResult(videohitlists);
	}

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	public static Videohitlist create(long videohitlistId) {
		return getPersistence().create(videohitlistId);
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist remove(long videohitlistId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().remove(videohitlistId);
	}

	public static Videohitlist updateImpl(Videohitlist videohitlist) {
		return getPersistence().updateImpl(videohitlist);
	}

	/**
	 * Returns the videohitlist with the primary key or throws a <code>NoSuchVideohitlistException</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist findByPrimaryKey(long videohitlistId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideohitlistException {

		return getPersistence().findByPrimaryKey(videohitlistId);
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 */
	public static Videohitlist fetchByPrimaryKey(long videohitlistId) {
		return getPersistence().fetchByPrimaryKey(videohitlistId);
	}

	/**
	 * Returns all the videohitlists.
	 *
	 * @return the videohitlists
	 */
	public static List<Videohitlist> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 */
	public static List<Videohitlist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videohitlists
	 */
	public static List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of videohitlists
	 */
	public static List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the videohitlists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideohitlistPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VideohitlistPersistence, VideohitlistPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideohitlistPersistence.class);

		ServiceTracker<VideohitlistPersistence, VideohitlistPersistence>
			serviceTracker =
				new ServiceTracker
					<VideohitlistPersistence, VideohitlistPersistence>(
						bundle.getBundleContext(),
						VideohitlistPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}