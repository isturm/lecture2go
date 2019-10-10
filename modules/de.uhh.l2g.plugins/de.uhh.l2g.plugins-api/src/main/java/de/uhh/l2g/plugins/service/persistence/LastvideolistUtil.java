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

import de.uhh.l2g.plugins.model.Lastvideolist;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the lastvideolist service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.LastvideolistPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistPersistence
 * @generated
 */
@ProviderType
public class LastvideolistUtil {

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
	public static void clearCache(Lastvideolist lastvideolist) {
		getPersistence().clearCache(lastvideolist);
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
	public static Map<Serializable, Lastvideolist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lastvideolist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lastvideolist update(Lastvideolist lastvideolist) {
		return getPersistence().update(lastvideolist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lastvideolist update(
		Lastvideolist lastvideolist, ServiceContext serviceContext) {

		return getPersistence().update(lastvideolist, serviceContext);
	}

	/**
	 * Returns all the lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching lastvideolists
	 */
	public static List<Lastvideolist> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Deprecated
	public static List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByVideo_First(
			long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByVideo_First(
		long videoId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByVideo_Last(
			long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByVideo_Last(
		long videoId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist[] findByVideo_PrevAndNext(
			int lastvideolistId, long videoId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByVideo_PrevAndNext(
			lastvideolistId, videoId, orderByComparator);
	}

	/**
	 * Removes all the lastvideolists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching lastvideolists
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Deprecated
	public static List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByGroup_First(
			long groupId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByGroup_First(
		long groupId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByGroup_Last(
			long groupId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByGroup_Last(
		long groupId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist[] findByGroup_PrevAndNext(
			int lastvideolistId, long groupId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroup_PrevAndNext(
			lastvideolistId, groupId, orderByComparator);
	}

	/**
	 * Removes all the lastvideolists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lastvideolists
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	public static List<Lastvideolist> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Deprecated
	public static List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByCompany_First(
			long companyId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByCompany_First(
		long companyId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByCompany_Last(
			long companyId, OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByCompany_Last(
		long companyId, OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist[] findByCompany_PrevAndNext(
			int lastvideolistId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByCompany_PrevAndNext(
			lastvideolistId, companyId, orderByComparator);
	}

	/**
	 * Removes all the lastvideolists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Deprecated
	public static List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public static List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public static Lastvideolist findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public static Lastvideolist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist[] findByGroupAndCompany_PrevAndNext(
			int lastvideolistId, long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			lastvideolistId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the lastvideolists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the lastvideolist in the entity cache if it is enabled.
	 *
	 * @param lastvideolist the lastvideolist
	 */
	public static void cacheResult(Lastvideolist lastvideolist) {
		getPersistence().cacheResult(lastvideolist);
	}

	/**
	 * Caches the lastvideolists in the entity cache if it is enabled.
	 *
	 * @param lastvideolists the lastvideolists
	 */
	public static void cacheResult(List<Lastvideolist> lastvideolists) {
		getPersistence().cacheResult(lastvideolists);
	}

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	public static Lastvideolist create(int lastvideolistId) {
		return getPersistence().create(lastvideolistId);
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist remove(int lastvideolistId)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().remove(lastvideolistId);
	}

	public static Lastvideolist updateImpl(Lastvideolist lastvideolist) {
		return getPersistence().updateImpl(lastvideolist);
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a <code>NoSuchLastvideolistException</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws de.uhh.l2g.plugins.exception.NoSuchLastvideolistException {

		return getPersistence().findByPrimaryKey(lastvideolistId);
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 */
	public static Lastvideolist fetchByPrimaryKey(int lastvideolistId) {
		return getPersistence().fetchByPrimaryKey(lastvideolistId);
	}

	/**
	 * Returns all the lastvideolists.
	 *
	 * @return the lastvideolists
	 */
	public static List<Lastvideolist> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 */
	public static List<Lastvideolist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lastvideolists
	 */
	@Deprecated
	public static List<Lastvideolist> findAll(
		int start, int end, OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lastvideolists
	 */
	public static List<Lastvideolist> findAll(
		int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the lastvideolists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LastvideolistPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LastvideolistPersistence, LastvideolistPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LastvideolistPersistence.class);

		ServiceTracker<LastvideolistPersistence, LastvideolistPersistence>
			serviceTracker =
				new ServiceTracker
					<LastvideolistPersistence, LastvideolistPersistence>(
						bundle.getBundleContext(),
						LastvideolistPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}