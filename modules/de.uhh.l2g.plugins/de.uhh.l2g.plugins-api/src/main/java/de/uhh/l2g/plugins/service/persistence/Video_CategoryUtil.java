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

import de.uhh.l2g.plugins.model.Video_Category;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the video_ category service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Video_CategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CategoryPersistence
 * @generated
 */
public class Video_CategoryUtil {

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
	public static void clearCache(Video_Category video_Category) {
		getPersistence().clearCache(video_Category);
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
	public static Map<Serializable, Video_Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video_Category update(Video_Category video_Category) {
		return getPersistence().update(video_Category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video_Category update(
		Video_Category video_Category, ServiceContext serviceContext) {

		return getPersistence().update(video_Category, serviceContext);
	}

	/**
	 * Returns all the video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ categories
	 */
	public static List<Video_Category> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	public static List<Video_Category> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByVideo_First(
			long videoId, OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByVideo_First(
		long videoId, OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByVideo_Last(
			long videoId, OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByVideo_Last(
		long videoId, OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public static Video_Category[] findByVideo_PrevAndNext(
			long videoCategoryId, long videoId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideo_PrevAndNext(
			videoCategoryId, videoId, orderByComparator);
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ categories
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	public static List<Video_Category> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	 * Returns a range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	public static List<Video_Category> findByCategory(
		long categoryId, int start, int end) {

		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByCategory_First(
			long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByCategory_First(
		long categoryId, OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByCategory_Last(
			long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByCategory_Last(
		long categoryId, OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public static Video_Category[] findByCategory_PrevAndNext(
			long videoCategoryId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByCategory_PrevAndNext(
			videoCategoryId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the video_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	 * Returns the number of video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	 * Returns all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	public static List<Video_Category> findByVideoCategory(
		long videoId, long categoryId) {

		return getPersistence().findByVideoCategory(videoId, categoryId);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	public static List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end) {

		return getPersistence().findByVideoCategory(
			videoId, categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().findByVideoCategory(
			videoId, categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	public static List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideoCategory(
			videoId, categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByVideoCategory_First(
			long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideoCategory_First(
			videoId, categoryId, orderByComparator);
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByVideoCategory_First(
		long videoId, long categoryId,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByVideoCategory_First(
			videoId, categoryId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public static Video_Category findByVideoCategory_Last(
			long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideoCategory_Last(
			videoId, categoryId, orderByComparator);
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public static Video_Category fetchByVideoCategory_Last(
		long videoId, long categoryId,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().fetchByVideoCategory_Last(
			videoId, categoryId, orderByComparator);
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public static Video_Category[] findByVideoCategory_PrevAndNext(
			long videoCategoryId, long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByVideoCategory_PrevAndNext(
			videoCategoryId, videoId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 */
	public static void removeByVideoCategory(long videoId, long categoryId) {
		getPersistence().removeByVideoCategory(videoId, categoryId);
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	public static int countByVideoCategory(long videoId, long categoryId) {
		return getPersistence().countByVideoCategory(videoId, categoryId);
	}

	/**
	 * Caches the video_ category in the entity cache if it is enabled.
	 *
	 * @param video_Category the video_ category
	 */
	public static void cacheResult(Video_Category video_Category) {
		getPersistence().cacheResult(video_Category);
	}

	/**
	 * Caches the video_ categories in the entity cache if it is enabled.
	 *
	 * @param video_Categories the video_ categories
	 */
	public static void cacheResult(List<Video_Category> video_Categories) {
		getPersistence().cacheResult(video_Categories);
	}

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	public static Video_Category create(long videoCategoryId) {
		return getPersistence().create(videoCategoryId);
	}

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public static Video_Category remove(long videoCategoryId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().remove(videoCategoryId);
	}

	public static Video_Category updateImpl(Video_Category video_Category) {
		return getPersistence().updateImpl(video_Category);
	}

	/**
	 * Returns the video_ category with the primary key or throws a <code>NoSuchVideo_CategoryException</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public static Video_Category findByPrimaryKey(long videoCategoryId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException {

		return getPersistence().findByPrimaryKey(videoCategoryId);
	}

	/**
	 * Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	 */
	public static Video_Category fetchByPrimaryKey(long videoCategoryId) {
		return getPersistence().fetchByPrimaryKey(videoCategoryId);
	}

	/**
	 * Returns all the video_ categories.
	 *
	 * @return the video_ categories
	 */
	public static List<Video_Category> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of video_ categories
	 */
	public static List<Video_Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ categories
	 */
	public static List<Video_Category> findAll(
		int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ categories
	 */
	public static List<Video_Category> findAll(
		int start, int end, OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the video_ categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Video_CategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_CategoryPersistence, Video_CategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Video_CategoryPersistence.class);

		ServiceTracker<Video_CategoryPersistence, Video_CategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<Video_CategoryPersistence, Video_CategoryPersistence>(
						bundle.getBundleContext(),
						Video_CategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}