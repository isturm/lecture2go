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

package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchSegmentException;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.impl.SegmentImpl;
import de.uhh.l2g.plugins.model.impl.SegmentModelImpl;
import de.uhh.l2g.plugins.service.persistence.SegmentPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class SegmentPersistenceImpl
	extends BasePersistenceImpl<Segment> implements SegmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SegmentUtil</code> to access the segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SegmentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByVideo;
	private FinderPath _finderPathWithoutPaginationFindByVideo;
	private FinderPath _finderPathCountByVideo;

	/**
	 * Returns all the segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVideo;
				finderArgs = new Object[] {videoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVideo;
			finderArgs = new Object[] {videoId, start, end, orderByComparator};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (videoId != segment.getVideoId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByVideo_First(
			long videoId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByVideo_First(videoId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByVideo_First(
		long videoId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByVideo_Last(
			long videoId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByVideo_Last(videoId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByVideo_Last(
		long videoId, OrderByComparator<Segment> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where videoId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByVideo_PrevAndNext(
			long segmentId, long videoId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, segment, videoId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByVideo_PrevAndNext(
				session, segment, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByVideo_PrevAndNext(
		Session session, Segment segment, long videoId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(videoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Segment segment :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 =
		"segment.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByUser;
	private FinderPath _finderPathWithoutPaginationFindByUser;
	private FinderPath _finderPathCountByUser;

	/**
	 * Returns all the segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByUser(
		long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByUser(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByUser(
		long userId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUser;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUser;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (userId != segment.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByUser_First(
			long userId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByUser_First(userId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByUser_First(
		long userId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByUser_Last(
			long userId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByUser_Last(userId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByUser_Last(
		long userId, OrderByComparator<Segment> orderByComparator) {

		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByUser(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where userId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByUser_PrevAndNext(
			long segmentId, long userId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByUser_PrevAndNext(
				session, segment, userId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByUser_PrevAndNext(
				session, segment, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByUser_PrevAndNext(
		Session session, Segment segment, long userId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_USER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (Segment segment :
				findByUser(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 =
		"segment.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (groupId != segment.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByGroup_First(
			long groupId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByGroup_First(groupId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByGroup_First(
		long groupId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByGroup_Last(
			long groupId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByGroup_Last(groupId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByGroup_Last(
		long groupId, OrderByComparator<Segment> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where groupId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByGroup_PrevAndNext(
			long segmentId, long groupId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, segment, groupId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByGroup_PrevAndNext(
				session, segment, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByGroup_PrevAndNext(
		Session session, Segment segment, long groupId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Segment segment :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 =
		"segment.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the segments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompany;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompany;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if (companyId != segment.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByCompany_First(
			long companyId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByCompany_First(companyId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByCompany_First(
		long companyId, OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByCompany_Last(
			long companyId, OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByCompany_Last(companyId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByCompany_Last(
		long companyId, OrderByComparator<Segment> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the segments before and after the current segment in the ordered set where companyId = &#63;.
	 *
	 * @param segmentId the primary key of the current segment
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment[] findByCompany_PrevAndNext(
			long segmentId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, segment, companyId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByCompany_PrevAndNext(
				session, segment, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByCompany_PrevAndNext(
		Session session, Segment segment, long companyId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Segment segment :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 =
		"segment.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching segments
	 */
	@Override
	public List<Segment> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of matching segments
	 */
	@Override
	public List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching segments
	 */
	@Override
	public List<Segment> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Segment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupAndCompany;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Segment segment : list) {
					if ((groupId != segment.getGroupId()) ||
						(companyId != segment.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the first segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Segment> orderByComparator) {

		List<Segment> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment
	 * @throws NoSuchSegmentException if a matching segment could not be found
	 */
	@Override
	public Segment findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (segment != null) {
			return segment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSegmentException(sb.toString());
	}

	/**
	 * Returns the last segment in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching segment, or <code>null</code> if a matching segment could not be found
	 */
	@Override
	public Segment fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Segment> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Segment> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Segment[] findByGroupAndCompany_PrevAndNext(
			long segmentId, long groupId, long companyId,
			OrderByComparator<Segment> orderByComparator)
		throws NoSuchSegmentException {

		Segment segment = findByPrimaryKey(segmentId);

		Session session = null;

		try {
			session = openSession();

			Segment[] array = new SegmentImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, segment, groupId, companyId, orderByComparator, true);

			array[1] = segment;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, segment, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Segment getByGroupAndCompany_PrevAndNext(
		Session session, Segment segment, long groupId, long companyId,
		OrderByComparator<Segment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SEGMENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(segment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Segment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the segments where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Segment segment :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(segment);
		}
	}

	/**
	 * Returns the number of segments where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching segments
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SEGMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 =
		"segment.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"segment.companyId = ?";

	public SegmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("start", "start_");
		dbColumnNames.put("end", "end_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Segment.class);

		setModelImplClass(SegmentImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(SegmentModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the segment in the entity cache if it is enabled.
	 *
	 * @param segment the segment
	 */
	@Override
	public void cacheResult(Segment segment) {
		entityCache.putResult(
			SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
			segment.getPrimaryKey(), segment);

		segment.resetOriginalValues();
	}

	/**
	 * Caches the segments in the entity cache if it is enabled.
	 *
	 * @param segments the segments
	 */
	@Override
	public void cacheResult(List<Segment> segments) {
		for (Segment segment : segments) {
			if (entityCache.getResult(
					SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
					segment.getPrimaryKey()) == null) {

				cacheResult(segment);
			}
			else {
				segment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SegmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segment segment) {
		entityCache.removeResult(
			SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
			segment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segment> segments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segment segment : segments) {
			entityCache.removeResult(
				SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
				segment.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new segment with the primary key. Does not add the segment to the database.
	 *
	 * @param segmentId the primary key for the new segment
	 * @return the new segment
	 */
	@Override
	public Segment create(long segmentId) {
		Segment segment = new SegmentImpl();

		segment.setNew(true);
		segment.setPrimaryKey(segmentId);

		segment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return segment;
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment remove(long segmentId) throws NoSuchSegmentException {
		return remove((Serializable)segmentId);
	}

	/**
	 * Removes the segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment that was removed
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment remove(Serializable primaryKey)
		throws NoSuchSegmentException {

		Session session = null;

		try {
			session = openSession();

			Segment segment = (Segment)session.get(
				SegmentImpl.class, primaryKey);

			if (segment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(segment);
		}
		catch (NoSuchSegmentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Segment removeImpl(Segment segment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segment)) {
				segment = (Segment)session.get(
					SegmentImpl.class, segment.getPrimaryKeyObj());
			}

			if (segment != null) {
				session.delete(segment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (segment != null) {
			clearCache(segment);
		}

		return segment;
	}

	@Override
	public Segment updateImpl(Segment segment) {
		boolean isNew = segment.isNew();

		if (!(segment instanceof SegmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(segment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(segment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in segment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Segment implementation " +
					segment.getClass());
		}

		SegmentModelImpl segmentModelImpl = (SegmentModelImpl)segment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (segment.getCreateDate() == null)) {
			if (serviceContext == null) {
				segment.setCreateDate(now);
			}
			else {
				segment.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!segmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				segment.setModifiedDate(now);
			}
			else {
				segment.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (segment.isNew()) {
				session.save(segment);

				segment.setNew(false);
			}
			else {
				segment = (Segment)session.merge(segment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SegmentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {segmentModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {segmentModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUser, args);

			args = new Object[] {segmentModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {segmentModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				segmentModelImpl.getGroupId(), segmentModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((segmentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					segmentModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {segmentModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((segmentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUser.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					segmentModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);

				args = new Object[] {segmentModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);
			}

			if ((segmentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					segmentModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {segmentModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((segmentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					segmentModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {segmentModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((segmentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					segmentModelImpl.getOriginalGroupId(),
					segmentModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					segmentModelImpl.getGroupId(),
					segmentModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			SegmentModelImpl.ENTITY_CACHE_ENABLED, SegmentImpl.class,
			segment.getPrimaryKey(), segment, false);

		segment.resetOriginalValues();

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegmentException {

		Segment segment = fetchByPrimaryKey(primaryKey);

		if (segment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return segment;
	}

	/**
	 * Returns the segment with the primary key or throws a <code>NoSuchSegmentException</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment
	 * @throws NoSuchSegmentException if a segment with the primary key could not be found
	 */
	@Override
	public Segment findByPrimaryKey(long segmentId)
		throws NoSuchSegmentException {

		return findByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns the segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the segment
	 * @return the segment, or <code>null</code> if a segment with the primary key could not be found
	 */
	@Override
	public Segment fetchByPrimaryKey(long segmentId) {
		return fetchByPrimaryKey((Serializable)segmentId);
	}

	/**
	 * Returns all the segments.
	 *
	 * @return the segments
	 */
	@Override
	public List<Segment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @return the range of segments
	 */
	@Override
	public List<Segment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segments
	 */
	@Override
	public List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SegmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of segments
	 * @param end the upper bound of the range of segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of segments
	 */
	@Override
	public List<Segment> findAll(
		int start, int end, OrderByComparator<Segment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Segment> list = null;

		if (useFinderCache) {
			list = (List<Segment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SEGMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SEGMENT;

				sql = sql.concat(SegmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Segment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the segments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Segment segment : findAll()) {
			remove(segment);
		}
	}

	/**
	 * Returns the number of segments.
	 *
	 * @return the number of segments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SEGMENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "segmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SEGMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SegmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segment persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] {Long.class.getName()},
			SegmentModelImpl.VIDEOID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUser = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUser = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {Long.class.getName()},
			SegmentModelImpl.USERID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			SegmentModelImpl.GROUPID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			SegmentModelImpl.COMPANYID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, SegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			SegmentModelImpl.GROUPID_COLUMN_BITMASK |
			SegmentModelImpl.COMPANYID_COLUMN_BITMASK |
			SegmentModelImpl.START_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			SegmentModelImpl.ENTITY_CACHE_ENABLED,
			SegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(SegmentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SEGMENT =
		"SELECT segment FROM Segment segment";

	private static final String _SQL_SELECT_SEGMENT_WHERE =
		"SELECT segment FROM Segment segment WHERE ";

	private static final String _SQL_COUNT_SEGMENT =
		"SELECT COUNT(segment) FROM Segment segment";

	private static final String _SQL_COUNT_SEGMENT_WHERE =
		"SELECT COUNT(segment) FROM Segment segment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "segment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Segment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Segment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SegmentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"start", "end"});

}