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

import de.uhh.l2g.plugins.model.Video_MediaType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the video_ media type service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Video_MediaTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_MediaTypePersistence
 * @generated
 */
@ProviderType
public class Video_MediaTypeUtil {

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
	public static void clearCache(Video_MediaType video_MediaType) {
		getPersistence().clearCache(video_MediaType);
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
	public static Map<Serializable, Video_MediaType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video_MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video_MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video_MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video_MediaType update(Video_MediaType video_MediaType) {
		return getPersistence().update(video_MediaType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video_MediaType update(
		Video_MediaType video_MediaType, ServiceContext serviceContext) {

		return getPersistence().update(video_MediaType, serviceContext);
	}

	/**
	 * Returns all the video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ media types
	 */
	public static List<Video_MediaType> findByVideo(long videoId) {
		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns a range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public static List<Video_MediaType> findByVideo(
		long videoId, int start, int end) {

		return getPersistence().findByVideo(videoId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	public static List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public static List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().findByVideo(
			videoId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByVideo_First(
			long videoId, OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByVideo_First(
		long videoId, OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByVideo_First(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByVideo_Last(
			long videoId, OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByVideo_Last(
		long videoId, OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByVideo_Last(videoId, orderByComparator);
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType[] findByVideo_PrevAndNext(
			long videoMediaTypeId, long videoId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideo_PrevAndNext(
			videoMediaTypeId, videoId, orderByComparator);
	}

	/**
	 * Removes all the video_ media types where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public static void removeByVideo(long videoId) {
		getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ media types
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns all the video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	public static List<Video_MediaType> findByMediaType(long MediaTypeId) {
		return getPersistence().findByMediaType(MediaTypeId);
	}

	/**
	 * Returns a range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public static List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end) {

		return getPersistence().findByMediaType(MediaTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByMediaType(long, int, int, OrderByComparator)}
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	public static List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMediaType(
			MediaTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public static List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().findByMediaType(
			MediaTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByMediaType_First(
			long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByMediaType_First(
			MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByMediaType_First(
		long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByMediaType_First(
			MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByMediaType_Last(
			long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByMediaType_Last(
			MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByMediaType_Last(
		long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByMediaType_Last(
			MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType[] findByMediaType_PrevAndNext(
			long videoMediaTypeId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByMediaType_PrevAndNext(
			videoMediaTypeId, MediaTypeId, orderByComparator);
	}

	/**
	 * Removes all the video_ media types where MediaTypeId = &#63; from the database.
	 *
	 * @param MediaTypeId the media type ID
	 */
	public static void removeByMediaType(long MediaTypeId) {
		getPersistence().removeByMediaType(MediaTypeId);
	}

	/**
	 * Returns the number of video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	public static int countByMediaType(long MediaTypeId) {
		return getPersistence().countByMediaType(MediaTypeId);
	}

	/**
	 * Returns all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	public static List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId) {

		return getPersistence().findByVideoMediaType(videoId, MediaTypeId);
	}

	/**
	 * Returns a range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public static List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end) {

		return getPersistence().findByVideoMediaType(
			videoId, MediaTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideoMediaType(long,long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	public static List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVideoMediaType(
			videoId, MediaTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public static List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().findByVideoMediaType(
			videoId, MediaTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByVideoMediaType_First(
			long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideoMediaType_First(
			videoId, MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByVideoMediaType_First(
		long videoId, long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByVideoMediaType_First(
			videoId, MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public static Video_MediaType findByVideoMediaType_Last(
			long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideoMediaType_Last(
			videoId, MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public static Video_MediaType fetchByVideoMediaType_Last(
		long videoId, long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().fetchByVideoMediaType_Last(
			videoId, MediaTypeId, orderByComparator);
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType[] findByVideoMediaType_PrevAndNext(
			long videoMediaTypeId, long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByVideoMediaType_PrevAndNext(
			videoMediaTypeId, videoId, MediaTypeId, orderByComparator);
	}

	/**
	 * Removes all the video_ media types where videoId = &#63; and MediaTypeId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 */
	public static void removeByVideoMediaType(long videoId, long MediaTypeId) {
		getPersistence().removeByVideoMediaType(videoId, MediaTypeId);
	}

	/**
	 * Returns the number of video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	public static int countByVideoMediaType(long videoId, long MediaTypeId) {
		return getPersistence().countByVideoMediaType(videoId, MediaTypeId);
	}

	/**
	 * Caches the video_ media type in the entity cache if it is enabled.
	 *
	 * @param video_MediaType the video_ media type
	 */
	public static void cacheResult(Video_MediaType video_MediaType) {
		getPersistence().cacheResult(video_MediaType);
	}

	/**
	 * Caches the video_ media types in the entity cache if it is enabled.
	 *
	 * @param video_MediaTypes the video_ media types
	 */
	public static void cacheResult(List<Video_MediaType> video_MediaTypes) {
		getPersistence().cacheResult(video_MediaTypes);
	}

	/**
	 * Creates a new video_ media type with the primary key. Does not add the video_ media type to the database.
	 *
	 * @param videoMediaTypeId the primary key for the new video_ media type
	 * @return the new video_ media type
	 */
	public static Video_MediaType create(long videoMediaTypeId) {
		return getPersistence().create(videoMediaTypeId);
	}

	/**
	 * Removes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType remove(long videoMediaTypeId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().remove(videoMediaTypeId);
	}

	public static Video_MediaType updateImpl(Video_MediaType video_MediaType) {
		return getPersistence().updateImpl(video_MediaType);
	}

	/**
	 * Returns the video_ media type with the primary key or throws a <code>NoSuchVideo_MediaTypeException</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType findByPrimaryKey(long videoMediaTypeId)
		throws de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException {

		return getPersistence().findByPrimaryKey(videoMediaTypeId);
	}

	/**
	 * Returns the video_ media type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type, or <code>null</code> if a video_ media type with the primary key could not be found
	 */
	public static Video_MediaType fetchByPrimaryKey(long videoMediaTypeId) {
		return getPersistence().fetchByPrimaryKey(videoMediaTypeId);
	}

	/**
	 * Returns all the video_ media types.
	 *
	 * @return the video_ media types
	 */
	public static List<Video_MediaType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of video_ media types
	 */
	public static List<Video_MediaType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ media types
	 */
	@Deprecated
	public static List<Video_MediaType> findAll(
		int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ media types
	 */
	public static List<Video_MediaType> findAll(
		int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the video_ media types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of video_ media types.
	 *
	 * @return the number of video_ media types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Video_MediaTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Video_MediaTypePersistence, Video_MediaTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Video_MediaTypePersistence.class);

		ServiceTracker<Video_MediaTypePersistence, Video_MediaTypePersistence>
			serviceTracker =
				new ServiceTracker
					<Video_MediaTypePersistence, Video_MediaTypePersistence>(
						bundle.getBundleContext(),
						Video_MediaTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}