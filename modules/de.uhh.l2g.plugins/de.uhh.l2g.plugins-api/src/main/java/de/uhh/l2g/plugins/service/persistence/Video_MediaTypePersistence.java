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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException;
import de.uhh.l2g.plugins.model.Video_MediaType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video_ media type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_MediaTypeUtil
 * @generated
 */
@ProviderType
public interface Video_MediaTypePersistence
	extends BasePersistence<Video_MediaType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Video_MediaTypeUtil} to access the video_ media type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideo(long videoId);

	/**
	 * Returns a range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByVideo_First(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByVideo_Last(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public Video_MediaType[] findByVideo_PrevAndNext(
			long videoMediaTypeId, long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Removes all the video_ media types where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ media types
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByMediaType(long MediaTypeId);

	/**
	 * Returns a range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByMediaType_First(
			long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByMediaType_First(
		long MediaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByMediaType_Last(
			long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByMediaType_Last(
		long MediaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public Video_MediaType[] findByMediaType_PrevAndNext(
			long videoMediaTypeId, long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Removes all the video_ media types where MediaTypeId = &#63; from the database.
	 *
	 * @param MediaTypeId the media type ID
	 */
	public void removeByMediaType(long MediaTypeId);

	/**
	 * Returns the number of video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	public int countByMediaType(long MediaTypeId);

	/**
	 * Returns all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId);

	/**
	 * Returns a range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	public java.util.List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByVideoMediaType_First(
			long videoId, long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByVideoMediaType_First(
		long videoId, long MediaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	public Video_MediaType findByVideoMediaType_Last(
			long videoId, long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	public Video_MediaType fetchByVideoMediaType_Last(
		long videoId, long MediaTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

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
	public Video_MediaType[] findByVideoMediaType_PrevAndNext(
			long videoMediaTypeId, long videoId, long MediaTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
				orderByComparator)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Removes all the video_ media types where videoId = &#63; and MediaTypeId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 */
	public void removeByVideoMediaType(long videoId, long MediaTypeId);

	/**
	 * Returns the number of video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	public int countByVideoMediaType(long videoId, long MediaTypeId);

	/**
	 * Caches the video_ media type in the entity cache if it is enabled.
	 *
	 * @param video_MediaType the video_ media type
	 */
	public void cacheResult(Video_MediaType video_MediaType);

	/**
	 * Caches the video_ media types in the entity cache if it is enabled.
	 *
	 * @param video_MediaTypes the video_ media types
	 */
	public void cacheResult(java.util.List<Video_MediaType> video_MediaTypes);

	/**
	 * Creates a new video_ media type with the primary key. Does not add the video_ media type to the database.
	 *
	 * @param videoMediaTypeId the primary key for the new video_ media type
	 * @return the new video_ media type
	 */
	public Video_MediaType create(long videoMediaTypeId);

	/**
	 * Removes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public Video_MediaType remove(long videoMediaTypeId)
		throws NoSuchVideo_MediaTypeException;

	public Video_MediaType updateImpl(Video_MediaType video_MediaType);

	/**
	 * Returns the video_ media type with the primary key or throws a <code>NoSuchVideo_MediaTypeException</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	public Video_MediaType findByPrimaryKey(long videoMediaTypeId)
		throws NoSuchVideo_MediaTypeException;

	/**
	 * Returns the video_ media type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type, or <code>null</code> if a video_ media type with the primary key could not be found
	 */
	public Video_MediaType fetchByPrimaryKey(long videoMediaTypeId);

	/**
	 * Returns all the video_ media types.
	 *
	 * @return the video_ media types
	 */
	public java.util.List<Video_MediaType> findAll();

	/**
	 * Returns a range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of video_ media types
	 */
	public java.util.List<Video_MediaType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ media types
	 */
	public java.util.List<Video_MediaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ media types
	 */
	public java.util.List<Video_MediaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video_ media types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video_ media types.
	 *
	 * @return the number of video_ media types
	 */
	public int countAll();

}