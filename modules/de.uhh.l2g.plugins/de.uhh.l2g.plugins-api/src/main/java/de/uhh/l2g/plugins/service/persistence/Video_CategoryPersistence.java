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

import de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException;
import de.uhh.l2g.plugins.model.Video_Category;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CategoryUtil
 * @generated
 */
@ProviderType
public interface Video_CategoryPersistence
	extends BasePersistence<Video_Category> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Video_CategoryUtil} to access the video_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ categories
	 */
	public java.util.List<Video_Category> findByVideo(long videoId);

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
	public java.util.List<Video_Category> findByVideo(
		long videoId, int start, int end);

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
	public java.util.List<Video_Category> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

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
	public java.util.List<Video_Category> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByVideo_First(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByVideo_Last(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public Video_Category[] findByVideo_PrevAndNext(
			long videoCategoryId, long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Removes all the video_ categories where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ categories
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	public java.util.List<Video_Category> findByCategory(long categoryId);

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
	public java.util.List<Video_Category> findByCategory(
		long categoryId, int start, int end);

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
	public java.util.List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

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
	public java.util.List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByCategory_First(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByCategory_Last(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public Video_Category[] findByCategory_PrevAndNext(
			long videoCategoryId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Removes all the video_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategory(long categoryId);

	/**
	 * Returns the number of video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	public int countByCategory(long categoryId);

	/**
	 * Returns all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	public java.util.List<Video_Category> findByVideoCategory(
		long videoId, long categoryId);

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
	public java.util.List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end);

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
	public java.util.List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

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
	public java.util.List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByVideoCategory_First(
			long videoId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByVideoCategory_First(
		long videoId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	public Video_Category findByVideoCategory_Last(
			long videoId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	public Video_Category fetchByVideoCategory_Last(
		long videoId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

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
	public Video_Category[] findByVideoCategory_PrevAndNext(
			long videoCategoryId, long videoId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
				orderByComparator)
		throws NoSuchVideo_CategoryException;

	/**
	 * Removes all the video_ categories where videoId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 */
	public void removeByVideoCategory(long videoId, long categoryId);

	/**
	 * Returns the number of video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	public int countByVideoCategory(long videoId, long categoryId);

	/**
	 * Caches the video_ category in the entity cache if it is enabled.
	 *
	 * @param video_Category the video_ category
	 */
	public void cacheResult(Video_Category video_Category);

	/**
	 * Caches the video_ categories in the entity cache if it is enabled.
	 *
	 * @param video_Categories the video_ categories
	 */
	public void cacheResult(java.util.List<Video_Category> video_Categories);

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	public Video_Category create(long videoCategoryId);

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public Video_Category remove(long videoCategoryId)
		throws NoSuchVideo_CategoryException;

	public Video_Category updateImpl(Video_Category video_Category);

	/**
	 * Returns the video_ category with the primary key or throws a <code>NoSuchVideo_CategoryException</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	public Video_Category findByPrimaryKey(long videoCategoryId)
		throws NoSuchVideo_CategoryException;

	/**
	 * Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	 */
	public Video_Category fetchByPrimaryKey(long videoCategoryId);

	/**
	 * Returns all the video_ categories.
	 *
	 * @return the video_ categories
	 */
	public java.util.List<Video_Category> findAll();

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
	public java.util.List<Video_Category> findAll(int start, int end);

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
	public java.util.List<Video_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator);

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
	public java.util.List<Video_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video_ categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
	 */
	public int countAll();

}