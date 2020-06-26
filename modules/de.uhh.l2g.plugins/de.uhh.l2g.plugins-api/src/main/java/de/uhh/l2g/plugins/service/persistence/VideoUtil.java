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

import de.uhh.l2g.plugins.model.Video;

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
 * The persistence utility for the video service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.VideoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoPersistence
 * @generated
 */
@ProviderType
public class VideoUtil {

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
	public static void clearCache(Video video) {
		getPersistence().clearCache(video);
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
	public static Map<Serializable, Video> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video update(Video video) {
		return getPersistence().update(video);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video update(Video video, ServiceContext serviceContext) {
		return getPersistence().update(video, serviceContext);
	}

	/**
	 * Returns all the videos where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching videos
	 */
	public static List<Video> findByVideoIds(long videoId) {
		return getPersistence().findByVideoIds(videoId);
	}

	/**
	 * Returns a range of all the videos where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByVideoIds(long videoId, int start, int end) {
		return getPersistence().findByVideoIds(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideoIds(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByVideoIds(
		long videoId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByVideoIds(
			videoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByVideoIds(
		long videoId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByVideoIds(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByVideoIds_First(
			long videoId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByVideoIds_First(
			videoId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByVideoIds_First(
		long videoId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByVideoIds_First(
			videoId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByVideoIds_Last(
			long videoId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByVideoIds_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByVideoIds_Last(
		long videoId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByVideoIds_Last(
			videoId, orderByComparator);
	}

	/**
	 * Returns all the videos where videoId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoIds the video IDs
	 * @return the matching videos
	 */
	public static List<Video> findByVideoIds(long[] videoIds) {
		return getPersistence().findByVideoIds(videoIds);
	}

	/**
	 * Returns a range of all the videos where videoId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoIds the video IDs
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByVideoIds(
		long[] videoIds, int start, int end) {

		return getPersistence().findByVideoIds(videoIds, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where videoId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideoIds(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByVideoIds(
		long[] videoIds, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByVideoIds(
			videoIds, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where videoId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoIds the video IDs
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByVideoIds(
		long[] videoIds, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByVideoIds(
			videoIds, start, end, orderByComparator);
	}

	/**
	 * Removes all the videos where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideoIds(long videoId) {
		getPersistence().removeByVideoIds(videoId);
	}

	/**
	 * Returns the number of videos where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching videos
	 */
	public static int countByVideoIds(long videoId) {
		return getPersistence().countByVideoIds(videoId);
	}

	/**
	 * Returns the number of videos where videoId = any &#63;.
	 *
	 * @param videoIds the video IDs
	 * @return the number of matching videos
	 */
	public static int countByVideoIds(long[] videoIds) {
		return getPersistence().countByVideoIds(videoIds);
	}

	/**
	 * Returns all the videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching videos
	 */
	public static List<Video> findByProducer(long producerId) {
		return getPersistence().findByProducer(producerId);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByProducer(
		long producerId, int start, int end) {

		return getPersistence().findByProducer(producerId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByProducer(long, int, int, OrderByComparator)}
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByProducer(
		long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProducer(
			producerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByProducer(
		long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByProducer(
			producerId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducer_First(
			long producerId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducer_First(
			producerId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducer_First(
		long producerId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducer_First(
			producerId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducer_Last(
			long producerId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducer_Last(
			producerId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducer_Last(
		long producerId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducer_Last(
			producerId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByProducer_PrevAndNext(
			long videoId, long producerId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducer_PrevAndNext(
			videoId, producerId, orderByComparator);
	}

	/**
	 * Removes all the videos where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	public static void removeByProducer(long producerId) {
		getPersistence().removeByProducer(producerId);
	}

	/**
	 * Returns the number of videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching videos
	 */
	public static int countByProducer(long producerId) {
		return getPersistence().countByProducer(producerId);
	}

	/**
	 * Returns all the videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	public static List<Video> findByLectureseries(long lectureseriesId) {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	 * Returns a range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByLectureseries(
		long lectureseriesId, int start, int end) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseries(long, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLectureseries_First(
			long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseries_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLectureseries_First(
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLectureseries_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLectureseries_Last(
			long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseries_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLectureseries_Last(
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLectureseries_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByLectureseries_PrevAndNext(
			long videoId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseries_PrevAndNext(
			videoId, lectureseriesId, orderByComparator);
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public static void removeByLectureseries(long lectureseriesId) {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	public static int countByLectureseries(long lectureseriesId) {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	 * Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	public static List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		return getPersistence().findByProducerAndLectureseries(
			producerId, lectureseriesId);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end) {

		return getPersistence().findByProducerAndLectureseries(
			producerId, lectureseriesId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByProducerAndLectureseries(long,long, int, int, OrderByComparator)}
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProducerAndLectureseries(
			producerId, lectureseriesId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByProducerAndLectureseries(
			producerId, lectureseriesId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducerAndLectureseries_First(
			long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndLectureseries_First(
			producerId, lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducerAndLectureseries_First(
			producerId, lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducerAndLectureseries_Last(
			long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndLectureseries_Last(
			producerId, lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducerAndLectureseries_Last(
			producerId, lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByProducerAndLectureseries_PrevAndNext(
			long videoId, long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndLectureseries_PrevAndNext(
			videoId, producerId, lectureseriesId, orderByComparator);
	}

	/**
	 * Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 */
	public static void removeByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		getPersistence().removeByProducerAndLectureseries(
			producerId, lectureseriesId);
	}

	/**
	 * Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	public static int countByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		return getPersistence().countByProducerAndLectureseries(
			producerId, lectureseriesId);
	}

	/**
	 * Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the matching videos
	 */
	public static List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		return getPersistence().findByProducerAndDownloadLink(
			producerId, downloadLink);
	}

	/**
	 * Returns a range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end) {

		return getPersistence().findByProducerAndDownloadLink(
			producerId, downloadLink, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByProducerAndDownloadLink(long,int, int, int, OrderByComparator)}
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProducerAndDownloadLink(
			producerId, downloadLink, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByProducerAndDownloadLink(
			producerId, downloadLink, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducerAndDownloadLink_First(
			long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndDownloadLink_First(
			producerId, downloadLink, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducerAndDownloadLink_First(
			producerId, downloadLink, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByProducerAndDownloadLink_Last(
			long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndDownloadLink_Last(
			producerId, downloadLink, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByProducerAndDownloadLink_Last(
			producerId, downloadLink, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByProducerAndDownloadLink_PrevAndNext(
			long videoId, long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByProducerAndDownloadLink_PrevAndNext(
			videoId, producerId, downloadLink, orderByComparator);
	}

	/**
	 * Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 */
	public static void removeByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		getPersistence().removeByProducerAndDownloadLink(
			producerId, downloadLink);
	}

	/**
	 * Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the number of matching videos
	 */
	public static int countByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		return getPersistence().countByProducerAndDownloadLink(
			producerId, downloadLink);
	}

	/**
	 * Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	public static List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		return getPersistence().findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);
	}

	/**
	 * Returns a range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end) {

		return getPersistence().findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseriesAndOpenaccess(long,int, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLectureseriesAndOpenaccess_First(
			long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseriesAndOpenaccess_First(
			lectureseriesId, openAccess, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLectureseriesAndOpenaccess_First(
			lectureseriesId, openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLectureseriesAndOpenaccess_Last(
			long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseriesAndOpenaccess_Last(
			lectureseriesId, openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLectureseriesAndOpenaccess_Last(
			lectureseriesId, openAccess, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByLectureseriesAndOpenaccess_PrevAndNext(
			long videoId, long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLectureseriesAndOpenaccess_PrevAndNext(
			videoId, lectureseriesId, openAccess, orderByComparator);
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 */
	public static void removeByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		getPersistence().removeByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	public static int countByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		return getPersistence().countByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);
	}

	/**
	 * Returns all the videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching videos
	 */
	public static List<Video> findByFilename(String filename) {
		return getPersistence().findByFilename(filename);
	}

	/**
	 * Returns a range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByFilename(
		String filename, int start, int end) {

		return getPersistence().findByFilename(filename, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFilename(String, int, int, OrderByComparator)}
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFilename(
			filename, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByFilename(
			filename, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByFilename_First(
			String filename, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByFilename_First(
			filename, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByFilename_First(
		String filename, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByFilename_First(
			filename, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByFilename_Last(
			String filename, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByFilename_Last(
			filename, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByFilename_Last(
		String filename, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByFilename_Last(
			filename, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where filename = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByFilename_PrevAndNext(
			long videoId, String filename,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByFilename_PrevAndNext(
			videoId, filename, orderByComparator);
	}

	/**
	 * Removes all the videos where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	public static void removeByFilename(String filename) {
		getPersistence().removeByFilename(filename);
	}

	/**
	 * Returns the number of videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching videos
	 */
	public static int countByFilename(String filename) {
		return getPersistence().countByFilename(filename);
	}

	/**
	 * Returns all the videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the matching videos
	 */
	public static List<Video> findByUploadDate(Date uploadDate) {
		return getPersistence().findByUploadDate(uploadDate);
	}

	/**
	 * Returns a range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByUploadDate(
		Date uploadDate, int start, int end) {

		return getPersistence().findByUploadDate(uploadDate, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUploadDate(Date, int, int, OrderByComparator)}
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByUploadDate(
		Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUploadDate(
			uploadDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where uploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uploadDate the upload date
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByUploadDate(
		Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByUploadDate(
			uploadDate, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByUploadDate_First(
			Date uploadDate, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByUploadDate_First(
			uploadDate, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByUploadDate_First(
		Date uploadDate, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByUploadDate_First(
			uploadDate, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByUploadDate_Last(
			Date uploadDate, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByUploadDate_Last(
			uploadDate, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByUploadDate_Last(
		Date uploadDate, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByUploadDate_Last(
			uploadDate, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where uploadDate = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByUploadDate_PrevAndNext(
			long videoId, Date uploadDate,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByUploadDate_PrevAndNext(
			videoId, uploadDate, orderByComparator);
	}

	/**
	 * Removes all the videos where uploadDate = &#63; from the database.
	 *
	 * @param uploadDate the upload date
	 */
	public static void removeByUploadDate(Date uploadDate) {
		getPersistence().removeByUploadDate(uploadDate);
	}

	/**
	 * Returns the number of videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the number of matching videos
	 */
	public static int countByUploadDate(Date uploadDate) {
		return getPersistence().countByUploadDate(uploadDate);
	}

	/**
	 * Returns all the videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the matching videos
	 */
	public static List<Video> findByRootInstitution(long rootInstitutionId) {
		return getPersistence().findByRootInstitution(rootInstitutionId);
	}

	/**
	 * Returns a range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end) {

		return getPersistence().findByRootInstitution(
			rootInstitutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByRootInstitution(long, int, int, OrderByComparator)}
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRootInstitution(
			rootInstitutionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where rootInstitutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByRootInstitution(
			rootInstitutionId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByRootInstitution_First(
			long rootInstitutionId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByRootInstitution_First(
			rootInstitutionId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByRootInstitution_First(
		long rootInstitutionId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByRootInstitution_First(
			rootInstitutionId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByRootInstitution_Last(
			long rootInstitutionId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByRootInstitution_Last(
			rootInstitutionId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByRootInstitution_Last(
		long rootInstitutionId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByRootInstitution_Last(
			rootInstitutionId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByRootInstitution_PrevAndNext(
			long videoId, long rootInstitutionId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByRootInstitution_PrevAndNext(
			videoId, rootInstitutionId, orderByComparator);
	}

	/**
	 * Removes all the videos where rootInstitutionId = &#63; from the database.
	 *
	 * @param rootInstitutionId the root institution ID
	 */
	public static void removeByRootInstitution(long rootInstitutionId) {
		getPersistence().removeByRootInstitution(rootInstitutionId);
	}

	/**
	 * Returns the number of videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the number of matching videos
	 */
	public static int countByRootInstitution(long rootInstitutionId) {
		return getPersistence().countByRootInstitution(rootInstitutionId);
	}

	/**
	 * Returns all the videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching videos
	 */
	public static List<Video> findByPassword(String password) {
		return getPersistence().findByPassword(password);
	}

	/**
	 * Returns a range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByPassword(
		String password, int start, int end) {

		return getPersistence().findByPassword(password, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByPassword(String, int, int, OrderByComparator)}
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByPassword(
		String password, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPassword(
			password, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByPassword(
		String password, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByPassword(
			password, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByPassword_First(
			String password, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByPassword_First(
			password, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByPassword_First(
		String password, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByPassword_First(
			password, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByPassword_Last(
			String password, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByPassword_Last(
			password, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByPassword_Last(
		String password, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByPassword_Last(
			password, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where password = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByPassword_PrevAndNext(
			long videoId, String password,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByPassword_PrevAndNext(
			videoId, password, orderByComparator);
	}

	/**
	 * Removes all the videos where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	public static void removeByPassword(String password) {
		getPersistence().removeByPassword(password);
	}

	/**
	 * Returns the number of videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching videos
	 */
	public static int countByPassword(String password) {
		return getPersistence().countByPassword(password);
	}

	/**
	 * Returns all the videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	public static List<Video> findByOpenAccess(int openAccess) {
		return getPersistence().findByOpenAccess(openAccess);
	}

	/**
	 * Returns a range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByOpenAccess(
		int openAccess, int start, int end) {

		return getPersistence().findByOpenAccess(openAccess, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByOpenAccess(int, int, int, OrderByComparator)}
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByOpenAccess(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOpenAccess(
			openAccess, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByOpenAccess(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByOpenAccess(
			openAccess, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByOpenAccess_First(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccess_First(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByOpenAccess_First(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByOpenAccess_First(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByOpenAccess_Last(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccess_Last(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByOpenAccess_Last(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByOpenAccess_Last(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByOpenAccess_PrevAndNext(
			long videoId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccess_PrevAndNext(
			videoId, openAccess, orderByComparator);
	}

	/**
	 * Removes all the videos where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	public static void removeByOpenAccess(int openAccess) {
		getPersistence().removeByOpenAccess(openAccess);
	}

	/**
	 * Returns the number of videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	public static int countByOpenAccess(int openAccess) {
		return getPersistence().countByOpenAccess(openAccess);
	}

	/**
	 * Returns all the videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching videos
	 */
	public static List<Video> findByTerm(long termId) {
		return getPersistence().findByTerm(termId);
	}

	/**
	 * Returns a range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByTerm(long termId, int start, int end) {
		return getPersistence().findByTerm(termId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByTerm(long, int, int, OrderByComparator)}
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTerm(
			termId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByTerm(
			termId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByTerm_First(
			long termId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByTerm_First(termId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByTerm_First(
		long termId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByTerm_First(termId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByTerm_Last(
			long termId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByTerm_Last(termId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByTerm_Last(
		long termId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByTerm_Last(termId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where termId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByTerm_PrevAndNext(
			long videoId, long termId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByTerm_PrevAndNext(
			videoId, termId, orderByComparator);
	}

	/**
	 * Removes all the videos where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	public static void removeByTerm(long termId) {
		getPersistence().removeByTerm(termId);
	}

	/**
	 * Returns the number of videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching videos
	 */
	public static int countByTerm(long termId) {
		return getPersistence().countByTerm(termId);
	}

	/**
	 * Returns all the videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	public static List<Video> findByOpenAccessAndUploadedFile(int openAccess) {
		return getPersistence().findByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	 * Returns a range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end) {

		return getPersistence().findByOpenAccessAndUploadedFile(
			openAccess, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByOpenAccessAndUploadedFile(int, int, int, OrderByComparator)}
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOpenAccessAndUploadedFile(
			openAccess, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByOpenAccessAndUploadedFile(
			openAccess, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByOpenAccessAndUploadedFile_First(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccessAndUploadedFile_First(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByOpenAccessAndUploadedFile_First(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByOpenAccessAndUploadedFile_First(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByOpenAccessAndUploadedFile_Last(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccessAndUploadedFile_Last(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByOpenAccessAndUploadedFile_Last(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByOpenAccessAndUploadedFile_Last(
			openAccess, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where openAccess = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByOpenAccessAndUploadedFile_PrevAndNext(
			long videoId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByOpenAccessAndUploadedFile_PrevAndNext(
			videoId, openAccess, orderByComparator);
	}

	/**
	 * Removes all the videos where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	public static void removeByOpenAccessAndUploadedFile(int openAccess) {
		getPersistence().removeByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	 * Returns the number of videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	public static int countByOpenAccessAndUploadedFile(int openAccess) {
		return getPersistence().countByOpenAccessAndUploadedFile(openAccess);
	}

	/**
	 * Returns all the videos where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the matching videos
	 */
	public static List<Video> findByLicense(long licenseId) {
		return getPersistence().findByLicense(licenseId);
	}

	/**
	 * Returns a range of all the videos where licenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param licenseId the license ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByLicense(
		long licenseId, int start, int end) {

		return getPersistence().findByLicense(licenseId, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where licenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLicense(long, int, int, OrderByComparator)}
	 * @param licenseId the license ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	@Deprecated
	public static List<Video> findByLicense(
		long licenseId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLicense(
			licenseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos where licenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param licenseId the license ID
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByLicense(
		long licenseId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByLicense(
			licenseId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLicense_First(
			long licenseId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLicense_First(
			licenseId, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLicense_First(
		long licenseId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLicense_First(
			licenseId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByLicense_Last(
			long licenseId, OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLicense_Last(
			licenseId, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByLicense_Last(
		long licenseId, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByLicense_Last(
			licenseId, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where licenseId = &#63;.
	 *
	 * @param videoId the primary key of the current video
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByLicense_PrevAndNext(
			long videoId, long licenseId,
			OrderByComparator<Video> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByLicense_PrevAndNext(
			videoId, licenseId, orderByComparator);
	}

	/**
	 * Removes all the videos where licenseId = &#63; from the database.
	 *
	 * @param licenseId the license ID
	 */
	public static void removeByLicense(long licenseId) {
		getPersistence().removeByLicense(licenseId);
	}

	/**
	 * Returns the number of videos where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the number of matching videos
	 */
	public static int countByLicense(long licenseId) {
		return getPersistence().countByLicense(licenseId);
	}

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	public static void cacheResult(Video video) {
		getPersistence().cacheResult(video);
	}

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	public static void cacheResult(List<Video> videos) {
		getPersistence().cacheResult(videos);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	public static Video create(long videoId) {
		return getPersistence().create(videoId);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video remove(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().remove(videoId);
	}

	public static Video updateImpl(Video video) {
		return getPersistence().updateImpl(video);
	}

	/**
	 * Returns the video with the primary key or throws a <code>NoSuchVideoException</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video findByPrimaryKey(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getPersistence().findByPrimaryKey(videoId);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	public static Video fetchByPrimaryKey(long videoId) {
		return getPersistence().fetchByPrimaryKey(videoId);
	}

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	public static List<Video> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	public static List<Video> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of videos
	 */
	@Deprecated
	public static List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videos
	 */
	public static List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the videos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoPersistence, VideoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoPersistence.class);

		ServiceTracker<VideoPersistence, VideoPersistence> serviceTracker =
			new ServiceTracker<VideoPersistence, VideoPersistence>(
				bundle.getBundleContext(), VideoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}