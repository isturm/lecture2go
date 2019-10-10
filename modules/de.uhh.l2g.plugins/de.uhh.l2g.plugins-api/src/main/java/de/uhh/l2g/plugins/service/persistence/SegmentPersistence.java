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
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.exception.NoSuchSegmentException;
import de.uhh.l2g.plugins.model.Segment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SegmentUtil
 * @generated
 */
@ProviderType
public interface SegmentPersistence extends BasePersistence<Segment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SegmentUtil} to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByVideo(long videoId);

	/**
	 * Returns a range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	public java.util.List<Segment> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Deprecated
	public java.util.List<Segment> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	public java.util.List<Segment> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByVideo_First(
			long videoId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByVideo_First(
		long videoId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByVideo_Last(
			long videoId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByVideo_Last(
		long videoId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where videoId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByVideo_PrevAndNext(
			long segmentId, long videoId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching segments
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByUser(long userId);

	/**
	 * Returns a range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	public java.util.List<Segment> findByUser(long userId, int start, int end);

	/**
	 * Returns an ordered range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUser(long, int, int, OrderByComparator)}
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Deprecated
	public java.util.List<Segment> findByUser(
		long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	public java.util.List<Segment> findByUser(
		long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByUser_First(
			long userId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByUser_First(
		long userId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByUser_Last(
			long userId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByUser_Last(
		long userId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where userId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByUser_PrevAndNext(
			long segmentId, long userId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching segments
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByGroup(long groupId);

	/**
	 * Returns a range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	public java.util.List<Segment> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Deprecated
	public java.util.List<Segment> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	public java.util.List<Segment> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the first segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByGroup_First(
			long groupId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByGroup_First(
		long groupId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the last segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByGroup_Last(
			long groupId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByGroup_Last(
		long groupId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where groupId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByGroup_PrevAndNext(
			long segmentId, long groupId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching segments
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the segments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByCompany(long companyId);

	/**
	 * Returns a range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	public java.util.List<Segment> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Deprecated
	public java.util.List<Segment> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	public java.util.List<Segment> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the first segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByCompany_First(
			long companyId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByCompany_First(
		long companyId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the last segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByCompany_Last(
			long companyId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByCompany_Last(
		long companyId, OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where companyId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByCompany_PrevAndNext(
			long segmentId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of segments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching segments
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching segments
	 */
	public java.util.List<Segment> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	public java.util.List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Deprecated
	public java.util.List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	public java.util.List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the first segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the first segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the last segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	public Segment findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Returns the last segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	public Segment fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Segment> orderByComparator);

	/**
	 * Returns the segments before and after the current segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment[] findByGroupAndCompany_PrevAndNext(
			long segmentId, long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException;

	/**
	 * Removes all the segments where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of segments where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching segments
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	public void cacheResult(Segment segment);

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	public void cacheResult(java.util.List<Segment> segments);

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	public Segment create(long segmentId);

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment remove(long segmentId) throws NoSuchSegmentException;

	public Segment updateImpl(Segment segment);

	/**
	 * Returns the segment with the primary key or throws a <code>NoSuchSegmentException</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	public Segment findByPrimaryKey(long segmentId)
		throws NoSuchSegmentException;

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 */
	public Segment fetchByPrimaryKey(long segmentId);

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 */
	public java.util.List<Segment> findAll();

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 */
	public java.util.List<Segment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of segments
	 */
	@Deprecated
	public java.util.List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segments
	 */
	public java.util.List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator);

	/**
	 * Removes all the segments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	public int countAll();

}