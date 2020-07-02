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

import de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException;
import de.uhh.l2g.plugins.model.Video_Creator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorUtil
 * @generated
 */
@ProviderType
public interface Video_CreatorPersistence
	extends BasePersistence<Video_Creator> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Video_CreatorUtil} to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideo(long videoId);

	/**
	 * Returns a range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByVideo_First(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByVideo_Last(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public Video_Creator[] findByVideo_PrevAndNext(
			long videoCreatorId, long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Removes all the video_ creators where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ creators
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	public java.util.List<Video_Creator> findByCreator(long creatorId);

	/**
	 * Returns a range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByCreator(
		long creatorId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByCreator_First(
			long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByCreator_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByCreator_Last(
			long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByCreator_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public Video_Creator[] findByCreator_PrevAndNext(
			long videoCreatorId, long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Removes all the video_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	public void removeByCreator(long creatorId);

	/**
	 * Returns the number of video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	public int countByCreator(long creatorId);

	/**
	 * Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId);

	/**
	 * Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	public java.util.List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByVideoCreator_First(
			long videoId, long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByVideoCreator_First(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	public Video_Creator findByVideoCreator_Last(
			long videoId, long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	public Video_Creator fetchByVideoCreator_Last(
		long videoId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public Video_Creator[] findByVideoCreator_PrevAndNext(
			long videoCreatorId, long videoId, long creatorId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
				orderByComparator)
		throws NoSuchVideo_CreatorException;

	/**
	 * Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 */
	public void removeByVideoCreator(long videoId, long creatorId);

	/**
	 * Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	public int countByVideoCreator(long videoId, long creatorId);

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	public void cacheResult(Video_Creator video_Creator);

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	public void cacheResult(java.util.List<Video_Creator> video_Creators);

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	public Video_Creator create(long videoCreatorId);

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public Video_Creator remove(long videoCreatorId)
		throws NoSuchVideo_CreatorException;

	public Video_Creator updateImpl(Video_Creator video_Creator);

	/**
	 * Returns the video_ creator with the primary key or throws a <code>NoSuchVideo_CreatorException</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	public Video_Creator findByPrimaryKey(long videoCreatorId)
		throws NoSuchVideo_CreatorException;

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 */
	public Video_Creator fetchByPrimaryKey(long videoCreatorId);

	/**
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 */
	public java.util.List<Video_Creator> findAll();

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 */
	public java.util.List<Video_Creator> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 */
	public java.util.List<Video_Creator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ creators
	 */
	public java.util.List<Video_Creator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Creator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video_ creators from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
	 */
	public int countAll();

}