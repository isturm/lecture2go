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

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.VideoStatistic;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the video statistic service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.VideoStatisticPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoStatisticPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.VideoStatisticPersistenceImpl
 * @generated
 */
@ProviderType
public class VideoStatisticUtil {
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
	public static void clearCache(VideoStatistic videoStatistic) {
		getPersistence().clearCache(videoStatistic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoStatistic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VideoStatistic update(VideoStatistic videoStatistic) {
		return getPersistence().update(videoStatistic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VideoStatistic update(VideoStatistic videoStatistic,
		ServiceContext serviceContext) {
		return getPersistence().update(videoStatistic, serviceContext);
	}

	/**
	* Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public static List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId) {
		return getPersistence().findByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByCompanyIdAndGroupId(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .findByCompanyIdAndGroupId(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyIdAndGroupId(groupId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByCompanyIdAndGroupId_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByCompanyIdAndGroupId_First(
		long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyIdAndGroupId_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByCompanyIdAndGroupId_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByCompanyIdAndGroupId_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyIdAndGroupId_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic[] findByCompanyIdAndGroupId_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompanyIdAndGroupId_PrevAndNext(videoStatisticId,
			groupId, companyId, orderByComparator);
	}

	/**
	* Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	*/
	public static void removeByCompanyIdAndGroupId(long groupId, long companyId) {
		getPersistence().removeByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public static int countByCompanyIdAndGroupId(long groupId, long companyId) {
		return getPersistence().countByCompanyIdAndGroupId(groupId, companyId);
	}

	/**
	* Returns all the video statistics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video statistics
	*/
	public static List<VideoStatistic> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroup(long groupId, int start,
		int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroup(long groupId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroup(long groupId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByGroup_First(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByGroup_First(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByGroup_Last(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByGroup_Last(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic[] findByGroup_PrevAndNext(
		long videoStatisticId, long groupId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByGroup_PrevAndNext(videoStatisticId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the video statistics where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of video statistics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video statistics
	*/
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns all the video statistics where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public static List<VideoStatistic> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompany(long companyId, int start,
		int end) {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompany(long companyId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByCompany(long companyId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByCompany_First(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByCompany_First(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByCompany_Last(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByCompany_Last(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic[] findByCompany_PrevAndNext(
		long videoStatisticId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByCompany_PrevAndNext(videoStatisticId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the video statistics where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of video statistics where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public static List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId) {
		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	* Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByGroupAndCompany(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .findByGroupAndCompany(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public static List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupAndCompany(groupId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByGroupAndCompany_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByGroupAndCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByGroupAndCompany_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .fetchByGroupAndCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public static VideoStatistic findByGroupAndCompany_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByGroupAndCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public static VideoStatistic fetchByGroupAndCompany_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence()
				   .fetchByGroupAndCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic[] findByGroupAndCompany_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence()
				   .findByGroupAndCompany_PrevAndNext(videoStatisticId,
			groupId, companyId, orderByComparator);
	}

	/**
	* Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	*/
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	* Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	* Caches the video statistic in the entity cache if it is enabled.
	*
	* @param videoStatistic the video statistic
	*/
	public static void cacheResult(VideoStatistic videoStatistic) {
		getPersistence().cacheResult(videoStatistic);
	}

	/**
	* Caches the video statistics in the entity cache if it is enabled.
	*
	* @param videoStatistics the video statistics
	*/
	public static void cacheResult(List<VideoStatistic> videoStatistics) {
		getPersistence().cacheResult(videoStatistics);
	}

	/**
	* Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	*
	* @param videoStatisticId the primary key for the new video statistic
	* @return the new video statistic
	*/
	public static VideoStatistic create(long videoStatisticId) {
		return getPersistence().create(videoStatisticId);
	}

	/**
	* Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic that was removed
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic remove(long videoStatisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().remove(videoStatisticId);
	}

	public static VideoStatistic updateImpl(VideoStatistic videoStatistic) {
		return getPersistence().updateImpl(videoStatistic);
	}

	/**
	* Returns the video statistic with the primary key or throws a {@link NoSuchVideoStatisticException} if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic findByPrimaryKey(long videoStatisticId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException {
		return getPersistence().findByPrimaryKey(videoStatisticId);
	}

	/**
	* Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	*/
	public static VideoStatistic fetchByPrimaryKey(long videoStatisticId) {
		return getPersistence().fetchByPrimaryKey(videoStatisticId);
	}

	public static java.util.Map<java.io.Serializable, VideoStatistic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the video statistics.
	*
	* @return the video statistics
	*/
	public static List<VideoStatistic> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of video statistics
	*/
	public static List<VideoStatistic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video statistics
	*/
	public static List<VideoStatistic> findAll(int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of video statistics
	*/
	public static List<VideoStatistic> findAll(int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the video statistics from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video statistics.
	*
	* @return the number of video statistics
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideoStatisticPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoStatisticPersistence, VideoStatisticPersistence> _serviceTracker =
		ServiceTrackerFactory.open(VideoStatisticPersistence.class);
}