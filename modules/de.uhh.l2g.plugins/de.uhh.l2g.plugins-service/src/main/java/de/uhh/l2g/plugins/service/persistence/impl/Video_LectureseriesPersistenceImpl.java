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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchVideo_LectureseriesException;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Video_LectureseriesModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_LectureseriesPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the video_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesPersistence
 * @see de.uhh.l2g.plugins.service.persistence.Video_LectureseriesUtil
 * @generated
 */
@ProviderType
public class Video_LectureseriesPersistenceImpl extends BasePersistenceImpl<Video_Lectureseries>
	implements Video_LectureseriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_LectureseriesUtil} to access the video_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_LectureseriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_LectureseriesModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ lectureserieses where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @return the range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId, int start,
		int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId, int start,
		int end, OrderByComparator<Video_Lectureseries> orderByComparator) {
		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByVideo(long videoId, int start,
		int end, OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<Video_Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Lectureseries video_Lectureseries : list) {
					if ((videoId != video_Lectureseries.getVideoId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByVideo_First(long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByVideo_First(long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		List<Video_Lectureseries> list = findByVideo(videoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByVideo_Last(long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByVideo_Last(long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where videoId = &#63;.
	 *
	 * @param videoLectureseriesId the primary key of the current video_ lectureseries
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries[] findByVideo_PrevAndNext(
		long videoLectureseriesId, long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Lectureseries,
					videoId, orderByComparator, true);

			array[1] = video_Lectureseries;

			array[2] = getByVideo_PrevAndNext(session, video_Lectureseries,
					videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByVideo_PrevAndNext(Session session,
		Video_Lectureseries video_Lectureseries, long videoId,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_Lectureseries video_Lectureseries : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ lectureserieses
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Lectureseries.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] { Long.class.getName() },
			Video_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIES = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId) {
		return findByLectureseries(lectureseriesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @return the range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId,
		int start, int end) {
		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId,
		int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		return findByLectureseries(lectureseriesId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseries(long lectureseriesId,
		int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] { lectureseriesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIES;
			finderArgs = new Object[] {
					lectureseriesId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Lectureseries video_Lectureseries : list) {
					if ((lectureseriesId != video_Lectureseries.getLectureseriesId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByLectureseries_First(long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseries_First(lectureseriesId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		List<Video_Lectureseries> list = findByLectureseries(lectureseriesId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByLectureseries_Last(long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseries_Last(lectureseriesId,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByLectureseries_Last(long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByLectureseries(lectureseriesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param videoLectureseriesId the primary key of the current video_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries[] findByLectureseries_PrevAndNext(
		long videoLectureseriesId, long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByLectureseries_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, orderByComparator,
					true);

			array[1] = video_Lectureseries;

			array[2] = getByLectureseries_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByLectureseries_PrevAndNext(
		Session session, Video_Lectureseries video_Lectureseries,
		long lectureseriesId,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId) {
		for (Video_Lectureseries video_Lectureseries : findByLectureseries(
				lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching video_ lectureserieses
	 */
	@Override
	public int countByLectureseries(long lectureseriesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIES;

		Object[] finderArgs = new Object[] { lectureseriesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 = "video_Lectureseries.lectureseriesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENACCESS =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOpenaccess",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOpenaccess",
			new String[] { Integer.class.getName() },
			Video_LectureseriesModelImpl.OPENACCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENACCESS = new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenaccess",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByOpenaccess(int openAccess) {
		return findByOpenaccess(openAccess, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ lectureserieses where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @return the range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByOpenaccess(int openAccess,
		int start, int end) {
		return findByOpenaccess(openAccess, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByOpenaccess(int openAccess,
		int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		return findByOpenaccess(openAccess, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByOpenaccess(int openAccess,
		int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS;
			finderArgs = new Object[] { openAccess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENACCESS;
			finderArgs = new Object[] { openAccess, start, end, orderByComparator };
		}

		List<Video_Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Lectureseries video_Lectureseries : list) {
					if ((openAccess != video_Lectureseries.getOpenAccess())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByOpenaccess_First(int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByOpenaccess_First(openAccess,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByOpenaccess_First(int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		List<Video_Lectureseries> list = findByOpenaccess(openAccess, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByOpenaccess_Last(int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByOpenaccess_Last(openAccess,
				orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByOpenaccess_Last(int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		int count = countByOpenaccess(openAccess);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByOpenaccess(openAccess,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where openAccess = &#63;.
	 *
	 * @param videoLectureseriesId the primary key of the current video_ lectureseries
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries[] findByOpenaccess_PrevAndNext(
		long videoLectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByOpenaccess_PrevAndNext(session,
					video_Lectureseries, openAccess, orderByComparator, true);

			array[1] = video_Lectureseries;

			array[2] = getByOpenaccess_PrevAndNext(session,
					video_Lectureseries, openAccess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByOpenaccess_PrevAndNext(Session session,
		Video_Lectureseries video_Lectureseries, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	@Override
	public void removeByOpenaccess(int openAccess) {
		for (Video_Lectureseries video_Lectureseries : findByOpenaccess(
				openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching video_ lectureserieses
	 */
	@Override
	public int countByOpenaccess(int openAccess) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENACCESS;

		Object[] finderArgs = new Object[] { openAccess };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OPENACCESS_OPENACCESS_2 = "video_Lectureseries.openAccess = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesAndOpenAccess",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Video_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesAndOpenAccess",
			new String[] { Long.class.getName(), Integer.class.getName() },
			Video_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			Video_LectureseriesModelImpl.OPENACCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS =
		new FinderPath(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesAndOpenAccess",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseriesAndOpenAccess(
		long lectureseriesId, int openAccess) {
		return findByLectureseriesAndOpenAccess(lectureseriesId, openAccess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @return the range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseriesAndOpenAccess(
		long lectureseriesId, int openAccess, int start, int end) {
		return findByLectureseriesAndOpenAccess(lectureseriesId, openAccess,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseriesAndOpenAccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		return findByLectureseriesAndOpenAccess(lectureseriesId, openAccess,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findByLectureseriesAndOpenAccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS;
			finderArgs = new Object[] { lectureseriesId, openAccess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS;
			finderArgs = new Object[] {
					lectureseriesId, openAccess,
					
					start, end, orderByComparator
				};
		}

		List<Video_Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Lectureseries video_Lectureseries : list) {
					if ((lectureseriesId != video_Lectureseries.getLectureseriesId()) ||
							(openAccess != video_Lectureseries.getOpenAccess())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByLectureseriesAndOpenAccess_First(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseriesAndOpenAccess_First(lectureseriesId,
				openAccess, orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first video_ lectureseries in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByLectureseriesAndOpenAccess_First(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		List<Video_Lectureseries> list = findByLectureseriesAndOpenAccess(lectureseriesId,
				openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries findByLectureseriesAndOpenAccess_Last(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByLectureseriesAndOpenAccess_Last(lectureseriesId,
				openAccess, orderByComparator);

		if (video_Lectureseries != null) {
			return video_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last video_ lectureseries in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ lectureseries, or <code>null</code> if a matching video_ lectureseries could not be found
	 */
	@Override
	public Video_Lectureseries fetchByLectureseriesAndOpenAccess_Last(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		int count = countByLectureseriesAndOpenAccess(lectureseriesId,
				openAccess);

		if (count == 0) {
			return null;
		}

		List<Video_Lectureseries> list = findByLectureseriesAndOpenAccess(lectureseriesId,
				openAccess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ lectureserieses before and after the current video_ lectureseries in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param videoLectureseriesId the primary key of the current video_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries[] findByLectureseriesAndOpenAccess_PrevAndNext(
		long videoLectureseriesId, long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = findByPrimaryKey(videoLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries[] array = new Video_LectureseriesImpl[3];

			array[0] = getByLectureseriesAndOpenAccess_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, openAccess,
					orderByComparator, true);

			array[1] = video_Lectureseries;

			array[2] = getByLectureseriesAndOpenAccess_PrevAndNext(session,
					video_Lectureseries, lectureseriesId, openAccess,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Lectureseries getByLectureseriesAndOpenAccess_PrevAndNext(
		Session session, Video_Lectureseries video_Lectureseries,
		long lectureseriesId, int openAccess,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Lectureseries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 */
	@Override
	public void removeByLectureseriesAndOpenAccess(long lectureseriesId,
		int openAccess) {
		for (Video_Lectureseries video_Lectureseries : findByLectureseriesAndOpenAccess(
				lectureseriesId, openAccess, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the number of matching video_ lectureserieses
	 */
	@Override
	public int countByLectureseriesAndOpenAccess(long lectureseriesId,
		int openAccess) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS;

		Object[] finderArgs = new Object[] { lectureseriesId, openAccess };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(openAccess);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2 =
		"video_Lectureseries.lectureseriesId = ? AND ";
	private static final String _FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2 =
		"video_Lectureseries.openAccess = ?";

	public Video_LectureseriesPersistenceImpl() {
		setModelClass(Video_Lectureseries.class);
	}

	/**
	 * Caches the video_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param video_Lectureseries the video_ lectureseries
	 */
	@Override
	public void cacheResult(Video_Lectureseries video_Lectureseries) {
		entityCache.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey(),
			video_Lectureseries);

		video_Lectureseries.resetOriginalValues();
	}

	/**
	 * Caches the video_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param video_Lectureserieses the video_ lectureserieses
	 */
	@Override
	public void cacheResult(List<Video_Lectureseries> video_Lectureserieses) {
		for (Video_Lectureseries video_Lectureseries : video_Lectureserieses) {
			if (entityCache.getResult(
						Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Video_LectureseriesImpl.class,
						video_Lectureseries.getPrimaryKey()) == null) {
				cacheResult(video_Lectureseries);
			}
			else {
				video_Lectureseries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ lectureserieses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_LectureseriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ lectureseries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Lectureseries video_Lectureseries) {
		entityCache.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Lectureseries> video_Lectureserieses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Lectureseries video_Lectureseries : video_Lectureserieses) {
			entityCache.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Video_LectureseriesImpl.class,
				video_Lectureseries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ lectureseries with the primary key. Does not add the video_ lectureseries to the database.
	 *
	 * @param videoLectureseriesId the primary key for the new video_ lectureseries
	 * @return the new video_ lectureseries
	 */
	@Override
	public Video_Lectureseries create(long videoLectureseriesId) {
		Video_Lectureseries video_Lectureseries = new Video_LectureseriesImpl();

		video_Lectureseries.setNew(true);
		video_Lectureseries.setPrimaryKey(videoLectureseriesId);

		return video_Lectureseries;
	}

	/**
	 * Removes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries that was removed
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries remove(long videoLectureseriesId)
		throws NoSuchVideo_LectureseriesException {
		return remove((Serializable)videoLectureseriesId);
	}

	/**
	 * Removes the video_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries that was removed
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries remove(Serializable primaryKey)
		throws NoSuchVideo_LectureseriesException {
		Session session = null;

		try {
			session = openSession();

			Video_Lectureseries video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
					primaryKey);

			if (video_Lectureseries == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Lectureseries);
		}
		catch (NoSuchVideo_LectureseriesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Video_Lectureseries removeImpl(
		Video_Lectureseries video_Lectureseries) {
		video_Lectureseries = toUnwrappedModel(video_Lectureseries);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Lectureseries)) {
				video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
						video_Lectureseries.getPrimaryKeyObj());
			}

			if (video_Lectureseries != null) {
				session.delete(video_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Lectureseries != null) {
			clearCache(video_Lectureseries);
		}

		return video_Lectureseries;
	}

	@Override
	public Video_Lectureseries updateImpl(
		Video_Lectureseries video_Lectureseries) {
		video_Lectureseries = toUnwrappedModel(video_Lectureseries);

		boolean isNew = video_Lectureseries.isNew();

		Video_LectureseriesModelImpl video_LectureseriesModelImpl = (Video_LectureseriesModelImpl)video_Lectureseries;

		Session session = null;

		try {
			session = openSession();

			if (video_Lectureseries.isNew()) {
				session.save(video_Lectureseries);

				video_Lectureseries.setNew(false);
			}
			else {
				video_Lectureseries = (Video_Lectureseries)session.merge(video_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_LectureseriesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					video_LectureseriesModelImpl.getVideoId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
				args);

			args = new Object[] {
					video_LectureseriesModelImpl.getLectureseriesId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
				args);

			args = new Object[] { video_LectureseriesModelImpl.getOpenAccess() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
				args);

			args = new Object[] {
					video_LectureseriesModelImpl.getLectureseriesId(),
					video_LectureseriesModelImpl.getOpenAccess()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_LectureseriesModelImpl.getVideoId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);

				args = new Object[] {
						video_LectureseriesModelImpl.getLectureseriesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIES,
					args);
			}

			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
					args);

				args = new Object[] { video_LectureseriesModelImpl.getOpenAccess() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENACCESS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENACCESS,
					args);
			}

			if ((video_LectureseriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_LectureseriesModelImpl.getOriginalLectureseriesId(),
						video_LectureseriesModelImpl.getOriginalOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
					args);

				args = new Object[] {
						video_LectureseriesModelImpl.getLectureseriesId(),
						video_LectureseriesModelImpl.getOpenAccess()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURESERIESANDOPENACCESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LECTURESERIESANDOPENACCESS,
					args);
			}
		}

		entityCache.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Video_LectureseriesImpl.class, video_Lectureseries.getPrimaryKey(),
			video_Lectureseries, false);

		video_Lectureseries.resetOriginalValues();

		return video_Lectureseries;
	}

	protected Video_Lectureseries toUnwrappedModel(
		Video_Lectureseries video_Lectureseries) {
		if (video_Lectureseries instanceof Video_LectureseriesImpl) {
			return video_Lectureseries;
		}

		Video_LectureseriesImpl video_LectureseriesImpl = new Video_LectureseriesImpl();

		video_LectureseriesImpl.setNew(video_Lectureseries.isNew());
		video_LectureseriesImpl.setPrimaryKey(video_Lectureseries.getPrimaryKey());

		video_LectureseriesImpl.setVideoLectureseriesId(video_Lectureseries.getVideoLectureseriesId());
		video_LectureseriesImpl.setVideoId(video_Lectureseries.getVideoId());
		video_LectureseriesImpl.setLectureseriesId(video_Lectureseries.getLectureseriesId());
		video_LectureseriesImpl.setOpenAccess(video_Lectureseries.getOpenAccess());

		return video_LectureseriesImpl;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_LectureseriesException {
		Video_Lectureseries video_Lectureseries = fetchByPrimaryKey(primaryKey);

		if (video_Lectureseries == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_LectureseriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Lectureseries;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or throws a {@link NoSuchVideo_LectureseriesException} if it could not be found.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries
	 * @throws NoSuchVideo_LectureseriesException if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries findByPrimaryKey(long videoLectureseriesId)
		throws NoSuchVideo_LectureseriesException {
		return findByPrimaryKey((Serializable)videoLectureseriesId);
	}

	/**
	 * Returns the video_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ lectureseries
	 * @return the video_ lectureseries, or <code>null</code> if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Video_LectureseriesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Video_Lectureseries video_Lectureseries = (Video_Lectureseries)serializable;

		if (video_Lectureseries == null) {
			Session session = null;

			try {
				session = openSession();

				video_Lectureseries = (Video_Lectureseries)session.get(Video_LectureseriesImpl.class,
						primaryKey);

				if (video_Lectureseries != null) {
					cacheResult(video_Lectureseries);
				}
				else {
					entityCache.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
						Video_LectureseriesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Video_LectureseriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Lectureseries;
	}

	/**
	 * Returns the video_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoLectureseriesId the primary key of the video_ lectureseries
	 * @return the video_ lectureseries, or <code>null</code> if a video_ lectureseries with the primary key could not be found
	 */
	@Override
	public Video_Lectureseries fetchByPrimaryKey(long videoLectureseriesId) {
		return fetchByPrimaryKey((Serializable)videoLectureseriesId);
	}

	@Override
	public Map<Serializable, Video_Lectureseries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Video_Lectureseries> map = new HashMap<Serializable, Video_Lectureseries>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Video_Lectureseries video_Lectureseries = fetchByPrimaryKey(primaryKey);

			if (video_Lectureseries != null) {
				map.put(primaryKey, video_Lectureseries);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Video_LectureseriesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Video_Lectureseries)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEO_LECTURESERIES_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Video_Lectureseries video_Lectureseries : (List<Video_Lectureseries>)q.list()) {
				map.put(video_Lectureseries.getPrimaryKeyObj(),
					video_Lectureseries);

				cacheResult(video_Lectureseries);

				uncachedPrimaryKeys.remove(video_Lectureseries.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Video_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Video_LectureseriesImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the video_ lectureserieses.
	 *
	 * @return the video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @return the range of video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findAll(int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_LectureseriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ lectureserieses
	 * @param end the upper bound of the range of video_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video_ lectureserieses
	 */
	@Override
	public List<Video_Lectureseries> findAll(int start, int end,
		OrderByComparator<Video_Lectureseries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Video_Lectureseries> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Lectureseries>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO_LECTURESERIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_LECTURESERIES;

				if (pagination) {
					sql = sql.concat(Video_LectureseriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Lectureseries>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the video_ lectureserieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_Lectureseries video_Lectureseries : findAll()) {
			remove(video_Lectureseries);
		}
	}

	/**
	 * Returns the number of video_ lectureserieses.
	 *
	 * @return the number of video_ lectureserieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_LECTURESERIES);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Video_LectureseriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ lectureseries persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Video_LectureseriesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VIDEO_LECTURESERIES = "SELECT video_Lectureseries FROM Video_Lectureseries video_Lectureseries";
	private static final String _SQL_SELECT_VIDEO_LECTURESERIES_WHERE_PKS_IN = "SELECT video_Lectureseries FROM Video_Lectureseries video_Lectureseries WHERE videoLectureseriesId IN (";
	private static final String _SQL_SELECT_VIDEO_LECTURESERIES_WHERE = "SELECT video_Lectureseries FROM Video_Lectureseries video_Lectureseries WHERE ";
	private static final String _SQL_COUNT_VIDEO_LECTURESERIES = "SELECT COUNT(video_Lectureseries) FROM Video_Lectureseries video_Lectureseries";
	private static final String _SQL_COUNT_VIDEO_LECTURESERIES_WHERE = "SELECT COUNT(video_Lectureseries) FROM Video_Lectureseries video_Lectureseries WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Lectureseries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Lectureseries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Lectureseries exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Video_LectureseriesPersistenceImpl.class);
}