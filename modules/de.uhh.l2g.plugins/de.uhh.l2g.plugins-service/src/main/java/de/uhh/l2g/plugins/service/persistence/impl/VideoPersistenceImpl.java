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

import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.impl.VideoModelImpl;
import de.uhh.l2g.plugins.service.persistence.VideoPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class VideoPersistenceImpl
	extends BasePersistenceImpl<Video> implements VideoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VideoUtil</code> to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VideoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByProducer;
	private FinderPath _finderPathWithoutPaginationFindByProducer;
	private FinderPath _finderPathCountByProducer;

	/**
	 * Returns all the videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducer(long producerId) {
		return findByProducer(
			producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByProducer(long producerId, int start, int end) {
		return findByProducer(producerId, start, end, null);
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
	@Override
	public List<Video> findByProducer(
		long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByProducer(producerId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByProducer(
		long producerId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByProducer;
			finderArgs = new Object[] {producerId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByProducer;
			finderArgs = new Object[] {
				producerId, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((producerId != video.getProducerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducer_First(
			long producerId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducer_First(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducer_First(
		long producerId, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByProducer(producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducer_Last(
			long producerId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducer_Last(producerId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducer_Last(
		long producerId, OrderByComparator<Video> orderByComparator) {

		int count = countByProducer(producerId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducer(
			producerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByProducer_PrevAndNext(
			long videoId, long producerId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducer_PrevAndNext(
				session, video, producerId, orderByComparator, true);

			array[1] = video;

			array[2] = getByProducer_PrevAndNext(
				session, video, producerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByProducer_PrevAndNext(
		Session session, Video video, long producerId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	@Override
	public void removeByProducer(long producerId) {
		for (Video video :
				findByProducer(
					producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducer(long producerId) {
		FinderPath finderPath = _finderPathCountByProducer;

		Object[] finderArgs = new Object[] {producerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCER_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String _FINDER_COLUMN_PRODUCER_PRODUCERID_2 =
		"video.producerId = ?";

	private FinderPath _finderPathWithPaginationFindByLectureseries;
	private FinderPath _finderPathWithoutPaginationFindByLectureseries;
	private FinderPath _finderPathCountByLectureseries;

	/**
	 * Returns all the videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByLectureseries(long lectureseriesId) {
		return findByLectureseries(
			lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByLectureseries(
		long lectureseriesId, int start, int end) {

		return findByLectureseries(lectureseriesId, start, end, null);
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
	@Override
	public List<Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByLectureseries(
			lectureseriesId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLectureseries;
			finderArgs = new Object[] {lectureseriesId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLectureseries;
			finderArgs = new Object[] {
				lectureseriesId, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((lectureseriesId != video.getLectureseriesId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseries_First(
			long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLectureseries_First(
			lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseries_First(
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByLectureseries(
			lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseries_Last(
			long lectureseriesId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLectureseries_Last(
			lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseries_Last(
		long lectureseriesId, OrderByComparator<Video> orderByComparator) {

		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLectureseries(
			lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByLectureseries_PrevAndNext(
			long videoId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLectureseries_PrevAndNext(
				session, video, lectureseriesId, orderByComparator, true);

			array[1] = video;

			array[2] = getByLectureseries_PrevAndNext(
				session, video, lectureseriesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByLectureseries_PrevAndNext(
		Session session, Video video, long lectureseriesId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId) {
		for (Video video :
				findByLectureseries(
					lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByLectureseries(long lectureseriesId) {
		FinderPath finderPath = _finderPathCountByLectureseries;

		Object[] finderArgs = new Object[] {lectureseriesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 =
		"video.lectureseriesId = ?";

	private FinderPath _finderPathWithPaginationFindByProducerAndLectureseries;
	private FinderPath
		_finderPathWithoutPaginationFindByProducerAndLectureseries;
	private FinderPath _finderPathCountByProducerAndLectureseries;

	/**
	 * Returns all the videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		return findByProducerAndLectureseries(
			producerId, lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end) {

		return findByProducerAndLectureseries(
			producerId, lectureseriesId, start, end, null);
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
	@Override
	public List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByProducerAndLectureseries(
			producerId, lectureseriesId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByProducerAndLectureseries(
		long producerId, long lectureseriesId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByProducerAndLectureseries;
			finderArgs = new Object[] {producerId, lectureseriesId};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByProducerAndLectureseries;
			finderArgs = new Object[] {
				producerId, lectureseriesId, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((producerId != video.getProducerId()) ||
					(lectureseriesId != video.getLectureseriesId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(
				_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndLectureseries_First(
			long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducerAndLectureseries_First(
			producerId, lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndLectureseries_First(
		long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByProducerAndLectureseries(
			producerId, lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video findByProducerAndLectureseries_Last(
			long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducerAndLectureseries_Last(
			producerId, lectureseriesId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndLectureseries_Last(
		long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator) {

		int count = countByProducerAndLectureseries(
			producerId, lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducerAndLectureseries(
			producerId, lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByProducerAndLectureseries_PrevAndNext(
			long videoId, long producerId, long lectureseriesId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducerAndLectureseries_PrevAndNext(
				session, video, producerId, lectureseriesId, orderByComparator,
				true);

			array[1] = video;

			array[2] = getByProducerAndLectureseries_PrevAndNext(
				session, video, producerId, lectureseriesId, orderByComparator,
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

	protected Video getByProducerAndLectureseries_PrevAndNext(
		Session session, Video video, long producerId, long lectureseriesId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

		query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; and lectureseriesId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		for (Video video :
				findByProducerAndLectureseries(
					producerId, lectureseriesId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63; and lectureseriesId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducerAndLectureseries(
		long producerId, long lectureseriesId) {

		FinderPath finderPath = _finderPathCountByProducerAndLectureseries;

		Object[] finderArgs = new Object[] {producerId, lectureseriesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2);

			query.append(
				_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

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

	private static final String
		_FINDER_COLUMN_PRODUCERANDLECTURESERIES_PRODUCERID_2 =
			"video.producerId = ? AND ";

	private static final String
		_FINDER_COLUMN_PRODUCERANDLECTURESERIES_LECTURESERIESID_2 =
			"video.lectureseriesId = ?";

	private FinderPath _finderPathWithPaginationFindByProducerAndDownloadLink;
	private FinderPath
		_finderPathWithoutPaginationFindByProducerAndDownloadLink;
	private FinderPath _finderPathCountByProducerAndDownloadLink;

	/**
	 * Returns all the videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		return findByProducerAndDownloadLink(
			producerId, downloadLink, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end) {

		return findByProducerAndDownloadLink(
			producerId, downloadLink, start, end, null);
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
	@Override
	public List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByProducerAndDownloadLink(
			producerId, downloadLink, start, end, orderByComparator);
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
	@Override
	public List<Video> findByProducerAndDownloadLink(
		long producerId, int downloadLink, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByProducerAndDownloadLink;
			finderArgs = new Object[] {producerId, downloadLink};
		}
		else {
			finderPath = _finderPathWithPaginationFindByProducerAndDownloadLink;
			finderArgs = new Object[] {
				producerId, downloadLink, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((producerId != video.getProducerId()) ||
					(downloadLink != video.getDownloadLink())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(downloadLink);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByProducerAndDownloadLink_First(
			long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducerAndDownloadLink_First(
			producerId, downloadLink, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", downloadLink=");
		msg.append(downloadLink);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndDownloadLink_First(
		long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByProducerAndDownloadLink(
			producerId, downloadLink, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video findByProducerAndDownloadLink_Last(
			long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByProducerAndDownloadLink_Last(
			producerId, downloadLink, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append(", downloadLink=");
		msg.append(downloadLink);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByProducerAndDownloadLink_Last(
		long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator) {

		int count = countByProducerAndDownloadLink(producerId, downloadLink);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByProducerAndDownloadLink(
			producerId, downloadLink, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByProducerAndDownloadLink_PrevAndNext(
			long videoId, long producerId, int downloadLink,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByProducerAndDownloadLink_PrevAndNext(
				session, video, producerId, downloadLink, orderByComparator,
				true);

			array[1] = video;

			array[2] = getByProducerAndDownloadLink_PrevAndNext(
				session, video, producerId, downloadLink, orderByComparator,
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

	protected Video getByProducerAndDownloadLink_PrevAndNext(
		Session session, Video video, long producerId, int downloadLink,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

		query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		qPos.add(downloadLink);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where producerId = &#63; and downloadLink = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 */
	@Override
	public void removeByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		for (Video video :
				findByProducerAndDownloadLink(
					producerId, downloadLink, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where producerId = &#63; and downloadLink = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param downloadLink the download link
	 * @return the number of matching videos
	 */
	@Override
	public int countByProducerAndDownloadLink(
		long producerId, int downloadLink) {

		FinderPath finderPath = _finderPathCountByProducerAndDownloadLink;

		Object[] finderArgs = new Object[] {producerId, downloadLink};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2);

			query.append(_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				qPos.add(downloadLink);

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

	private static final String
		_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_PRODUCERID_2 =
			"video.producerId = ? AND ";

	private static final String
		_FINDER_COLUMN_PRODUCERANDDOWNLOADLINK_DOWNLOADLINK_2 =
			"video.downloadLink = ?";

	private FinderPath
		_finderPathWithPaginationFindByLectureseriesAndOpenaccess;
	private FinderPath
		_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess;
	private FinderPath _finderPathCountByLectureseriesAndOpenaccess;

	/**
	 * Returns all the videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		return findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end) {

		return findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, start, end, null);
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
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, start, end, orderByComparator);
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
	@Override
	public List<Video> findByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess;
			finderArgs = new Object[] {lectureseriesId, openAccess};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByLectureseriesAndOpenaccess;
			finderArgs = new Object[] {
				lectureseriesId, openAccess, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((lectureseriesId != video.getLectureseriesId()) ||
					(openAccess != video.getOpenAccess())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(
				_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(
				_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
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
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLectureseriesAndOpenaccess_First(
			long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLectureseriesAndOpenaccess_First(
			lectureseriesId, openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseriesAndOpenaccess_First(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video findByLectureseriesAndOpenaccess_Last(
			long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLectureseriesAndOpenaccess_Last(
			lectureseriesId, openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLectureseriesAndOpenaccess_Last(
		long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator) {

		int count = countByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByLectureseriesAndOpenaccess_PrevAndNext(
			long videoId, long lectureseriesId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLectureseriesAndOpenaccess_PrevAndNext(
				session, video, lectureseriesId, openAccess, orderByComparator,
				true);

			array[1] = video;

			array[2] = getByLectureseriesAndOpenaccess_PrevAndNext(
				session, video, lectureseriesId, openAccess, orderByComparator,
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

	protected Video getByLectureseriesAndOpenaccess_PrevAndNext(
		Session session, Video video, long lectureseriesId, int openAccess,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(
			_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where lectureseriesId = &#63; and openAccess = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 */
	@Override
	public void removeByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		for (Video video :
				findByLectureseriesAndOpenaccess(
					lectureseriesId, openAccess, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where lectureseriesId = &#63; and openAccess = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	@Override
	public int countByLectureseriesAndOpenaccess(
		long lectureseriesId, int openAccess) {

		FinderPath finderPath = _finderPathCountByLectureseriesAndOpenaccess;

		Object[] finderArgs = new Object[] {lectureseriesId, openAccess};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(
				_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2);

			query.append(
				_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2);

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

	private static final String
		_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_LECTURESERIESID_2 =
			"video.lectureseriesId = ? AND ";

	private static final String
		_FINDER_COLUMN_LECTURESERIESANDOPENACCESS_OPENACCESS_2 =
			"video.openAccess = ?";

	private FinderPath _finderPathWithPaginationFindByFilename;
	private FinderPath _finderPathWithoutPaginationFindByFilename;
	private FinderPath _finderPathCountByFilename;

	/**
	 * Returns all the videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByFilename(String filename) {
		return findByFilename(
			filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByFilename(String filename, int start, int end) {
		return findByFilename(filename, start, end, null);
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
	@Override
	public List<Video> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByFilename(filename, start, end, orderByComparator);
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
	@Override
	public List<Video> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		filename = Objects.toString(filename, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFilename;
			finderArgs = new Object[] {filename};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFilename;
			finderArgs = new Object[] {filename, start, end, orderByComparator};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if (!filename.equals(video.getFilename())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
				}

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByFilename_First(
			String filename, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByFilename_First(filename, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByFilename_First(
		String filename, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByFilename(filename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByFilename_Last(
			String filename, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByFilename_Last(filename, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByFilename_Last(
		String filename, OrderByComparator<Video> orderByComparator) {

		int count = countByFilename(filename);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByFilename(
			filename, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByFilename_PrevAndNext(
			long videoId, String filename,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		filename = Objects.toString(filename, "");

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByFilename_PrevAndNext(
				session, video, filename, orderByComparator, true);

			array[1] = video;

			array[2] = getByFilename_PrevAndNext(
				session, video, filename, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByFilename_PrevAndNext(
		Session session, Video video, String filename,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindFilename = false;

		if (filename.isEmpty()) {
			query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
		}
		else {
			bindFilename = true;

			query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFilename) {
			qPos.add(filename);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	@Override
	public void removeByFilename(String filename) {
		for (Video video :
				findByFilename(
					filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching videos
	 */
	@Override
	public int countByFilename(String filename) {
		filename = Objects.toString(filename, "");

		FinderPath finderPath = _finderPathCountByFilename;

		Object[] finderArgs = new Object[] {filename};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
				}

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

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_2 =
		"video.filename = ?";

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_3 =
		"(video.filename IS NULL OR video.filename = '')";

	private FinderPath _finderPathWithPaginationFindByUploadDate;
	private FinderPath _finderPathWithoutPaginationFindByUploadDate;
	private FinderPath _finderPathCountByUploadDate;

	/**
	 * Returns all the videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByUploadDate(Date uploadDate) {
		return findByUploadDate(
			uploadDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByUploadDate(Date uploadDate, int start, int end) {
		return findByUploadDate(uploadDate, start, end, null);
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
	@Override
	public List<Video> findByUploadDate(
		Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByUploadDate(uploadDate, start, end, orderByComparator);
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
	@Override
	public List<Video> findByUploadDate(
		Date uploadDate, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUploadDate;
			finderArgs = new Object[] {_getTime(uploadDate)};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUploadDate;
			finderArgs = new Object[] {
				_getTime(uploadDate), start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if (!Objects.equals(uploadDate, video.getUploadDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindUploadDate = false;

			if (uploadDate == null) {
				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
			}
			else {
				bindUploadDate = true;

				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadDate) {
					qPos.add(new Timestamp(uploadDate.getTime()));
				}

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByUploadDate_First(
			Date uploadDate, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByUploadDate_First(uploadDate, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadDate=");
		msg.append(uploadDate);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByUploadDate_First(
		Date uploadDate, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByUploadDate(
			uploadDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByUploadDate_Last(
			Date uploadDate, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByUploadDate_Last(uploadDate, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uploadDate=");
		msg.append(uploadDate);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByUploadDate_Last(
		Date uploadDate, OrderByComparator<Video> orderByComparator) {

		int count = countByUploadDate(uploadDate);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByUploadDate(
			uploadDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByUploadDate_PrevAndNext(
			long videoId, Date uploadDate,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByUploadDate_PrevAndNext(
				session, video, uploadDate, orderByComparator, true);

			array[1] = video;

			array[2] = getByUploadDate_PrevAndNext(
				session, video, uploadDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByUploadDate_PrevAndNext(
		Session session, Video video, Date uploadDate,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindUploadDate = false;

		if (uploadDate == null) {
			query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
		}
		else {
			bindUploadDate = true;

			query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUploadDate) {
			qPos.add(new Timestamp(uploadDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where uploadDate = &#63; from the database.
	 *
	 * @param uploadDate the upload date
	 */
	@Override
	public void removeByUploadDate(Date uploadDate) {
		for (Video video :
				findByUploadDate(
					uploadDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where uploadDate = &#63;.
	 *
	 * @param uploadDate the upload date
	 * @return the number of matching videos
	 */
	@Override
	public int countByUploadDate(Date uploadDate) {
		FinderPath finderPath = _finderPathCountByUploadDate;

		Object[] finderArgs = new Object[] {_getTime(uploadDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindUploadDate = false;

			if (uploadDate == null) {
				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1);
			}
			else {
				bindUploadDate = true;

				query.append(_FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadDate) {
					qPos.add(new Timestamp(uploadDate.getTime()));
				}

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

	private static final String _FINDER_COLUMN_UPLOADDATE_UPLOADDATE_1 =
		"video.uploadDate IS NULL";

	private static final String _FINDER_COLUMN_UPLOADDATE_UPLOADDATE_2 =
		"video.uploadDate = ?";

	private FinderPath _finderPathWithPaginationFindByRootInstitution;
	private FinderPath _finderPathWithoutPaginationFindByRootInstitution;
	private FinderPath _finderPathCountByRootInstitution;

	/**
	 * Returns all the videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByRootInstitution(long rootInstitutionId) {
		return findByRootInstitution(
			rootInstitutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end) {

		return findByRootInstitution(rootInstitutionId, start, end, null);
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
	@Override
	public List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByRootInstitution(
			rootInstitutionId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByRootInstitution(
		long rootInstitutionId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRootInstitution;
			finderArgs = new Object[] {rootInstitutionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRootInstitution;
			finderArgs = new Object[] {
				rootInstitutionId, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((rootInstitutionId != video.getRootInstitutionId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootInstitutionId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByRootInstitution_First(
			long rootInstitutionId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByRootInstitution_First(
			rootInstitutionId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rootInstitutionId=");
		msg.append(rootInstitutionId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByRootInstitution_First(
		long rootInstitutionId, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByRootInstitution(
			rootInstitutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByRootInstitution_Last(
			long rootInstitutionId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByRootInstitution_Last(
			rootInstitutionId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rootInstitutionId=");
		msg.append(rootInstitutionId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByRootInstitution_Last(
		long rootInstitutionId, OrderByComparator<Video> orderByComparator) {

		int count = countByRootInstitution(rootInstitutionId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByRootInstitution(
			rootInstitutionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByRootInstitution_PrevAndNext(
			long videoId, long rootInstitutionId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByRootInstitution_PrevAndNext(
				session, video, rootInstitutionId, orderByComparator, true);

			array[1] = video;

			array[2] = getByRootInstitution_PrevAndNext(
				session, video, rootInstitutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByRootInstitution_PrevAndNext(
		Session session, Video video, long rootInstitutionId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rootInstitutionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where rootInstitutionId = &#63; from the database.
	 *
	 * @param rootInstitutionId the root institution ID
	 */
	@Override
	public void removeByRootInstitution(long rootInstitutionId) {
		for (Video video :
				findByRootInstitution(
					rootInstitutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where rootInstitutionId = &#63;.
	 *
	 * @param rootInstitutionId the root institution ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByRootInstitution(long rootInstitutionId) {
		FinderPath finderPath = _finderPathCountByRootInstitution;

		Object[] finderArgs = new Object[] {rootInstitutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rootInstitutionId);

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

	private static final String
		_FINDER_COLUMN_ROOTINSTITUTION_ROOTINSTITUTIONID_2 =
			"video.rootInstitutionId = ?";

	private FinderPath _finderPathWithPaginationFindByPassword;
	private FinderPath _finderPathWithoutPaginationFindByPassword;
	private FinderPath _finderPathCountByPassword;

	/**
	 * Returns all the videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByPassword(String password) {
		return findByPassword(
			password, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByPassword(String password, int start, int end) {
		return findByPassword(password, start, end, null);
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
	@Override
	public List<Video> findByPassword(
		String password, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByPassword(password, start, end, orderByComparator);
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
	@Override
	public List<Video> findByPassword(
		String password, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		password = Objects.toString(password, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPassword;
			finderArgs = new Object[] {password};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPassword;
			finderArgs = new Object[] {password, start, end, orderByComparator};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if (!password.equals(video.getPassword())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassword) {
					qPos.add(password);
				}

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByPassword_First(
			String password, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByPassword_First(password, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByPassword_First(
		String password, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByPassword(password, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByPassword_Last(
			String password, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByPassword_Last(password, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("password=");
		msg.append(password);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByPassword_Last(
		String password, OrderByComparator<Video> orderByComparator) {

		int count = countByPassword(password);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByPassword(
			password, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByPassword_PrevAndNext(
			long videoId, String password,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		password = Objects.toString(password, "");

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByPassword_PrevAndNext(
				session, video, password, orderByComparator, true);

			array[1] = video;

			array[2] = getByPassword_PrevAndNext(
				session, video, password, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByPassword_PrevAndNext(
		Session session, Video video, String password,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindPassword = false;

		if (password.isEmpty()) {
			query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
		}
		else {
			bindPassword = true;

			query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPassword) {
			qPos.add(password);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	@Override
	public void removeByPassword(String password) {
		for (Video video :
				findByPassword(
					password, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching videos
	 */
	@Override
	public int countByPassword(String password) {
		password = Objects.toString(password, "");

		FinderPath finderPath = _finderPathCountByPassword;

		Object[] finderArgs = new Object[] {password};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindPassword = false;

			if (password.isEmpty()) {
				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_PASSWORD_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPassword) {
					qPos.add(password);
				}

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

	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_2 =
		"video.password = ?";

	private static final String _FINDER_COLUMN_PASSWORD_PASSWORD_3 =
		"(video.password IS NULL OR video.password = '')";

	private FinderPath _finderPathWithPaginationFindByOpenAccess;
	private FinderPath _finderPathWithoutPaginationFindByOpenAccess;
	private FinderPath _finderPathCountByOpenAccess;

	/**
	 * Returns all the videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByOpenAccess(int openAccess) {
		return findByOpenAccess(
			openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByOpenAccess(int openAccess, int start, int end) {
		return findByOpenAccess(openAccess, start, end, null);
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
	@Override
	public List<Video> findByOpenAccess(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByOpenAccess(openAccess, start, end, orderByComparator);
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
	@Override
	public List<Video> findByOpenAccess(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByOpenAccess;
			finderArgs = new Object[] {openAccess};
		}
		else {
			finderPath = _finderPathWithPaginationFindByOpenAccess;
			finderArgs = new Object[] {
				openAccess, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((openAccess != video.getOpenAccess())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccess_First(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByOpenAccess_First(openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccess_First(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByOpenAccess(
			openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccess_Last(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByOpenAccess_Last(openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccess_Last(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		int count = countByOpenAccess(openAccess);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByOpenAccess(
			openAccess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByOpenAccess_PrevAndNext(
			long videoId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByOpenAccess_PrevAndNext(
				session, video, openAccess, orderByComparator, true);

			array[1] = video;

			array[2] = getByOpenAccess_PrevAndNext(
				session, video, openAccess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByOpenAccess_PrevAndNext(
		Session session, Video video, int openAccess,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_OPENACCESS_OPENACCESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	@Override
	public void removeByOpenAccess(int openAccess) {
		for (Video video :
				findByOpenAccess(
					openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	@Override
	public int countByOpenAccess(int openAccess) {
		FinderPath finderPath = _finderPathCountByOpenAccess;

		Object[] finderArgs = new Object[] {openAccess};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

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

	private static final String _FINDER_COLUMN_OPENACCESS_OPENACCESS_2 =
		"video.openAccess = ?";

	private FinderPath _finderPathWithPaginationFindByTerm;
	private FinderPath _finderPathWithoutPaginationFindByTerm;
	private FinderPath _finderPathCountByTerm;

	/**
	 * Returns all the videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByTerm(long termId) {
		return findByTerm(termId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByTerm(long termId, int start, int end) {
		return findByTerm(termId, start, end, null);
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
	@Override
	public List<Video> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByTerm(termId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTerm;
			finderArgs = new Object[] {termId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTerm;
			finderArgs = new Object[] {termId, start, end, orderByComparator};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((termId != video.getTermId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_TERM_TERMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByTerm_First(
			long termId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByTerm_First(termId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByTerm_First(
		long termId, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByTerm(termId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByTerm_Last(
			long termId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByTerm_Last(termId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByTerm_Last(
		long termId, OrderByComparator<Video> orderByComparator) {

		int count = countByTerm(termId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByTerm(
			termId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByTerm_PrevAndNext(
			long videoId, long termId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByTerm_PrevAndNext(
				session, video, termId, orderByComparator, true);

			array[1] = video;

			array[2] = getByTerm_PrevAndNext(
				session, video, termId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByTerm_PrevAndNext(
		Session session, Video video, long termId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_TERM_TERMID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(termId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	@Override
	public void removeByTerm(long termId) {
		for (Video video :
				findByTerm(
					termId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByTerm(long termId) {
		FinderPath finderPath = _finderPathCountByTerm;

		Object[] finderArgs = new Object[] {termId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_TERM_TERMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

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

	private static final String _FINDER_COLUMN_TERM_TERMID_2 =
		"video.termId = ?";

	private FinderPath _finderPathWithPaginationFindByOpenAccessAndUploadedFile;
	private FinderPath
		_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile;
	private FinderPath _finderPathCountByOpenAccessAndUploadedFile;

	/**
	 * Returns all the videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByOpenAccessAndUploadedFile(int openAccess) {
		return findByOpenAccessAndUploadedFile(
			openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end) {

		return findByOpenAccessAndUploadedFile(openAccess, start, end, null);
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
	@Override
	public List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByOpenAccessAndUploadedFile(
			openAccess, start, end, orderByComparator);
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
	@Override
	public List<Video> findByOpenAccessAndUploadedFile(
		int openAccess, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile;
			finderArgs = new Object[] {openAccess};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByOpenAccessAndUploadedFile;
			finderArgs = new Object[] {
				openAccess, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((openAccess != video.getOpenAccess())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESSANDUPLOADEDFILE_OPENACCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(openAccess);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccessAndUploadedFile_First(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByOpenAccessAndUploadedFile_First(
			openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccessAndUploadedFile_First(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByOpenAccessAndUploadedFile(
			openAccess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByOpenAccessAndUploadedFile_Last(
			int openAccess, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByOpenAccessAndUploadedFile_Last(
			openAccess, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openAccess=");
		msg.append(openAccess);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByOpenAccessAndUploadedFile_Last(
		int openAccess, OrderByComparator<Video> orderByComparator) {

		int count = countByOpenAccessAndUploadedFile(openAccess);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByOpenAccessAndUploadedFile(
			openAccess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByOpenAccessAndUploadedFile_PrevAndNext(
			long videoId, int openAccess,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByOpenAccessAndUploadedFile_PrevAndNext(
				session, video, openAccess, orderByComparator, true);

			array[1] = video;

			array[2] = getByOpenAccessAndUploadedFile_PrevAndNext(
				session, video, openAccess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByOpenAccessAndUploadedFile_PrevAndNext(
		Session session, Video video, int openAccess,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_OPENACCESSANDUPLOADEDFILE_OPENACCESS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(openAccess);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where openAccess = &#63; from the database.
	 *
	 * @param openAccess the open access
	 */
	@Override
	public void removeByOpenAccessAndUploadedFile(int openAccess) {
		for (Video video :
				findByOpenAccessAndUploadedFile(
					openAccess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where openAccess = &#63;.
	 *
	 * @param openAccess the open access
	 * @return the number of matching videos
	 */
	@Override
	public int countByOpenAccessAndUploadedFile(int openAccess) {
		FinderPath finderPath = _finderPathCountByOpenAccessAndUploadedFile;

		Object[] finderArgs = new Object[] {openAccess};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_OPENACCESSANDUPLOADEDFILE_OPENACCESS_2);

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

	private static final String
		_FINDER_COLUMN_OPENACCESSANDUPLOADEDFILE_OPENACCESS_2 =
			"video.openAccess = ? AND video.filename > ''";

	private FinderPath _finderPathWithPaginationFindByLicense;
	private FinderPath _finderPathWithoutPaginationFindByLicense;
	private FinderPath _finderPathCountByLicense;

	/**
	 * Returns all the videos where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByLicense(long licenseId) {
		return findByLicense(
			licenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByLicense(long licenseId, int start, int end) {
		return findByLicense(licenseId, start, end, null);
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
	@Override
	public List<Video> findByLicense(
		long licenseId, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return findByLicense(licenseId, start, end, orderByComparator);
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
	@Override
	public List<Video> findByLicense(
		long licenseId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLicense;
			finderArgs = new Object[] {licenseId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLicense;
			finderArgs = new Object[] {
				licenseId, start, end, orderByComparator
			};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video video : list) {
				if ((licenseId != video.getLicenseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LICENSE_LICENSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(licenseId);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLicense_First(
			long licenseId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLicense_First(licenseId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("licenseId=");
		msg.append(licenseId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the first video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLicense_First(
		long licenseId, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByLicense(licenseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByLicense_Last(
			long licenseId, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByLicense_Last(licenseId, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("licenseId=");
		msg.append(licenseId);

		msg.append("}");

		throw new NoSuchVideoException(msg.toString());
	}

	/**
	 * Returns the last video in the ordered set where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByLicense_Last(
		long licenseId, OrderByComparator<Video> orderByComparator) {

		int count = countByLicense(licenseId);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByLicense(
			licenseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByLicense_PrevAndNext(
			long videoId, long licenseId,
			OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByLicense_PrevAndNext(
				session, video, licenseId, orderByComparator, true);

			array[1] = video;

			array[2] = getByLicense_PrevAndNext(
				session, video, licenseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByLicense_PrevAndNext(
		Session session, Video video, long licenseId,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_WHERE);

		query.append(_FINDER_COLUMN_LICENSE_LICENSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(licenseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where licenseId = &#63; from the database.
	 *
	 * @param licenseId the license ID
	 */
	@Override
	public void removeByLicense(long licenseId) {
		for (Video video :
				findByLicense(
					licenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where licenseId = &#63;.
	 *
	 * @param licenseId the license ID
	 * @return the number of matching videos
	 */
	@Override
	public int countByLicense(long licenseId) {
		FinderPath finderPath = _finderPathCountByLicense;

		Object[] finderArgs = new Object[] {licenseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_WHERE);

			query.append(_FINDER_COLUMN_LICENSE_LICENSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(licenseId);

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

	private static final String _FINDER_COLUMN_LICENSE_LICENSEID_2 =
		"video.licenseId = ?";

	public VideoPersistenceImpl() {
		setModelClass(Video.class);

		setModelImplClass(VideoImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(VideoModelImpl.ENTITY_CACHE_ENABLED);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	@Override
	public void cacheResult(Video video) {
		entityCache.putResult(
			VideoModelImpl.ENTITY_CACHE_ENABLED, VideoImpl.class,
			video.getPrimaryKey(), video);

		video.resetOriginalValues();
	}

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	@Override
	public void cacheResult(List<Video> videos) {
		for (Video video : videos) {
			if (entityCache.getResult(
					VideoModelImpl.ENTITY_CACHE_ENABLED, VideoImpl.class,
					video.getPrimaryKey()) == null) {

				cacheResult(video);
			}
			else {
				video.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video video) {
		entityCache.removeResult(
			VideoModelImpl.ENTITY_CACHE_ENABLED, VideoImpl.class,
			video.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video> videos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video video : videos) {
			entityCache.removeResult(
				VideoModelImpl.ENTITY_CACHE_ENABLED, VideoImpl.class,
				video.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	@Override
	public Video create(long videoId) {
		Video video = new VideoImpl();

		video.setNew(true);
		video.setPrimaryKey(videoId);

		video.setCompanyId(CompanyThreadLocal.getCompanyId());

		return video;
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(long videoId) throws NoSuchVideoException {
		return remove((Serializable)videoId);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(Serializable primaryKey) throws NoSuchVideoException {
		Session session = null;

		try {
			session = openSession();

			Video video = (Video)session.get(VideoImpl.class, primaryKey);

			if (video == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(video);
		}
		catch (NoSuchVideoException nsee) {
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
	protected Video removeImpl(Video video) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video)) {
				video = (Video)session.get(
					VideoImpl.class, video.getPrimaryKeyObj());
			}

			if (video != null) {
				session.delete(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video != null) {
			clearCache(video);
		}

		return video;
	}

	@Override
	public Video updateImpl(Video video) {
		boolean isNew = video.isNew();

		if (!(video instanceof VideoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(video.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(video);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in video proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Video implementation " +
					video.getClass());
		}

		VideoModelImpl videoModelImpl = (VideoModelImpl)video;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (video.getCreateDate() == null)) {
			if (serviceContext == null) {
				video.setCreateDate(now);
			}
			else {
				video.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!videoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				video.setModifiedDate(now);
			}
			else {
				video.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (video.isNew()) {
				session.save(video);

				video.setNew(false);
			}
			else {
				video = (Video)session.merge(video);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VideoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {videoModelImpl.getProducerId()};

			finderCache.removeResult(_finderPathCountByProducer, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProducer, args);

			args = new Object[] {videoModelImpl.getLectureseriesId()};

			finderCache.removeResult(_finderPathCountByLectureseries, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseries, args);

			args = new Object[] {
				videoModelImpl.getProducerId(),
				videoModelImpl.getLectureseriesId()
			};

			finderCache.removeResult(
				_finderPathCountByProducerAndLectureseries, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProducerAndLectureseries,
				args);

			args = new Object[] {
				videoModelImpl.getProducerId(), videoModelImpl.getDownloadLink()
			};

			finderCache.removeResult(
				_finderPathCountByProducerAndDownloadLink, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProducerAndDownloadLink,
				args);

			args = new Object[] {
				videoModelImpl.getLectureseriesId(),
				videoModelImpl.getOpenAccess()
			};

			finderCache.removeResult(
				_finderPathCountByLectureseriesAndOpenaccess, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess,
				args);

			args = new Object[] {videoModelImpl.getFilename()};

			finderCache.removeResult(_finderPathCountByFilename, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFilename, args);

			args = new Object[] {videoModelImpl.getUploadDate()};

			finderCache.removeResult(_finderPathCountByUploadDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUploadDate, args);

			args = new Object[] {videoModelImpl.getRootInstitutionId()};

			finderCache.removeResult(_finderPathCountByRootInstitution, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRootInstitution, args);

			args = new Object[] {videoModelImpl.getPassword()};

			finderCache.removeResult(_finderPathCountByPassword, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPassword, args);

			args = new Object[] {videoModelImpl.getOpenAccess()};

			finderCache.removeResult(_finderPathCountByOpenAccess, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOpenAccess, args);

			args = new Object[] {videoModelImpl.getTermId()};

			finderCache.removeResult(_finderPathCountByTerm, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTerm, args);

			args = new Object[] {videoModelImpl.getOpenAccess()};

			finderCache.removeResult(
				_finderPathCountByOpenAccessAndUploadedFile, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile,
				args);

			args = new Object[] {videoModelImpl.getLicenseId()};

			finderCache.removeResult(_finderPathCountByLicense, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLicense, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProducer.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalProducerId()
				};

				finderCache.removeResult(_finderPathCountByProducer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducer, args);

				args = new Object[] {videoModelImpl.getProducerId()};

				finderCache.removeResult(_finderPathCountByProducer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducer, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseries.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalLectureseriesId()
				};

				finderCache.removeResult(_finderPathCountByLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseries, args);

				args = new Object[] {videoModelImpl.getLectureseriesId()};

				finderCache.removeResult(_finderPathCountByLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseries, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProducerAndLectureseries.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalProducerId(),
					videoModelImpl.getOriginalLectureseriesId()
				};

				finderCache.removeResult(
					_finderPathCountByProducerAndLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerAndLectureseries,
					args);

				args = new Object[] {
					videoModelImpl.getProducerId(),
					videoModelImpl.getLectureseriesId()
				};

				finderCache.removeResult(
					_finderPathCountByProducerAndLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerAndLectureseries,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProducerAndDownloadLink.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalProducerId(),
					videoModelImpl.getOriginalDownloadLink()
				};

				finderCache.removeResult(
					_finderPathCountByProducerAndDownloadLink, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerAndDownloadLink,
					args);

				args = new Object[] {
					videoModelImpl.getProducerId(),
					videoModelImpl.getDownloadLink()
				};

				finderCache.removeResult(
					_finderPathCountByProducerAndDownloadLink, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerAndDownloadLink,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseriesAndOpenaccess.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalLectureseriesId(),
					videoModelImpl.getOriginalOpenAccess()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesAndOpenaccess, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess,
					args);

				args = new Object[] {
					videoModelImpl.getLectureseriesId(),
					videoModelImpl.getOpenAccess()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesAndOpenaccess, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFilename.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalFilename()
				};

				finderCache.removeResult(_finderPathCountByFilename, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFilename, args);

				args = new Object[] {videoModelImpl.getFilename()};

				finderCache.removeResult(_finderPathCountByFilename, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFilename, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUploadDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalUploadDate()
				};

				finderCache.removeResult(_finderPathCountByUploadDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadDate, args);

				args = new Object[] {videoModelImpl.getUploadDate()};

				finderCache.removeResult(_finderPathCountByUploadDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadDate, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRootInstitution.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalRootInstitutionId()
				};

				finderCache.removeResult(
					_finderPathCountByRootInstitution, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRootInstitution, args);

				args = new Object[] {videoModelImpl.getRootInstitutionId()};

				finderCache.removeResult(
					_finderPathCountByRootInstitution, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRootInstitution, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPassword.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalPassword()
				};

				finderCache.removeResult(_finderPathCountByPassword, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPassword, args);

				args = new Object[] {videoModelImpl.getPassword()};

				finderCache.removeResult(_finderPathCountByPassword, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPassword, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOpenAccess.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalOpenAccess()
				};

				finderCache.removeResult(_finderPathCountByOpenAccess, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOpenAccess, args);

				args = new Object[] {videoModelImpl.getOpenAccess()};

				finderCache.removeResult(_finderPathCountByOpenAccess, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOpenAccess, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTerm.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalTermId()
				};

				finderCache.removeResult(_finderPathCountByTerm, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTerm, args);

				args = new Object[] {videoModelImpl.getTermId()};

				finderCache.removeResult(_finderPathCountByTerm, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTerm, args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOpenAccessAndUploadedFile.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalOpenAccess()
				};

				finderCache.removeResult(
					_finderPathCountByOpenAccessAndUploadedFile, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile,
					args);

				args = new Object[] {videoModelImpl.getOpenAccess()};

				finderCache.removeResult(
					_finderPathCountByOpenAccessAndUploadedFile, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile,
					args);
			}

			if ((videoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLicense.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videoModelImpl.getOriginalLicenseId()
				};

				finderCache.removeResult(_finderPathCountByLicense, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLicense, args);

				args = new Object[] {videoModelImpl.getLicenseId()};

				finderCache.removeResult(_finderPathCountByLicense, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLicense, args);
			}
		}

		entityCache.putResult(
			VideoModelImpl.ENTITY_CACHE_ENABLED, VideoImpl.class,
			video.getPrimaryKey(), video, false);

		video.resetOriginalValues();

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoException {

		Video video = fetchByPrimaryKey(primaryKey);

		if (video == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a <code>NoSuchVideoException</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(long videoId) throws NoSuchVideoException {
		return findByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	@Override
	public Video fetchByPrimaryKey(long videoId) {
		return fetchByPrimaryKey((Serializable)videoId);
	}

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	@Override
	public List<Video> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Video> list = (List<Video>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO;

				if (pagination) {
					sql = sql.concat(VideoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Removes all the videos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video video : findAll()) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
		return "videoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VideoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByProducer = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProducer",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProducer = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProducer",
			new String[] {Long.class.getName()},
			VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByProducer = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProducer",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByLectureseries = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLectureseries = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] {Long.class.getName()},
			VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByLectureseries = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByProducerAndLectureseries =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProducerAndLectureseries",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByProducerAndLectureseries =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProducerAndLectureseries",
				new String[] {Long.class.getName(), Long.class.getName()},
				VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
				VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
				VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByProducerAndLectureseries = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProducerAndLectureseries",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByProducerAndDownloadLink = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProducerAndDownloadLink",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProducerAndDownloadLink =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProducerAndDownloadLink",
				new String[] {Long.class.getName(), Integer.class.getName()},
				VideoModelImpl.PRODUCERID_COLUMN_BITMASK |
				VideoModelImpl.DOWNLOADLINK_COLUMN_BITMASK |
				VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByProducerAndDownloadLink = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProducerAndDownloadLink",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByLectureseriesAndOpenaccess =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByLectureseriesAndOpenaccess",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByLectureseriesAndOpenaccess =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLectureseriesAndOpenaccess",
				new String[] {Long.class.getName(), Integer.class.getName()},
				VideoModelImpl.LECTURESERIESID_COLUMN_BITMASK |
				VideoModelImpl.OPENACCESS_COLUMN_BITMASK |
				VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByLectureseriesAndOpenaccess = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesAndOpenaccess",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByFilename = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilename",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFilename = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFilename",
			new String[] {String.class.getName()},
			VideoModelImpl.FILENAME_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByFilename = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFilename",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUploadDate = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploadDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUploadDate = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUploadDate",
			new String[] {Date.class.getName()},
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByUploadDate = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUploadDate",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByRootInstitution = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRootInstitution",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRootInstitution = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRootInstitution",
			new String[] {Long.class.getName()},
			VideoModelImpl.ROOTINSTITUTIONID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByRootInstitution = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRootInstitution",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByPassword = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPassword",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPassword = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPassword",
			new String[] {String.class.getName()},
			VideoModelImpl.PASSWORD_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByPassword = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPassword",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByOpenAccess = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOpenAccess",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOpenAccess = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOpenAccess",
			new String[] {Integer.class.getName()},
			VideoModelImpl.OPENACCESS_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByOpenAccess = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenAccess",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByTerm = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTerm",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTerm = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTerm",
			new String[] {Long.class.getName()},
			VideoModelImpl.TERMID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByTerm = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTerm",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByOpenAccessAndUploadedFile =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByOpenAccessAndUploadedFile",
				new String[] {
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByOpenAccessAndUploadedFile =
			new FinderPath(
				VideoModelImpl.ENTITY_CACHE_ENABLED,
				VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByOpenAccessAndUploadedFile",
				new String[] {Integer.class.getName()},
				VideoModelImpl.OPENACCESS_COLUMN_BITMASK |
				VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByOpenAccessAndUploadedFile = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOpenAccessAndUploadedFile",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByLicense = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLicense",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLicense = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, VideoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLicense",
			new String[] {Long.class.getName()},
			VideoModelImpl.LICENSEID_COLUMN_BITMASK |
			VideoModelImpl.UPLOADDATE_COLUMN_BITMASK);

		_finderPathCountByLicense = new FinderPath(
			VideoModelImpl.ENTITY_CACHE_ENABLED,
			VideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLicense",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(VideoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_VIDEO =
		"SELECT video FROM Video video";

	private static final String _SQL_SELECT_VIDEO_WHERE =
		"SELECT video FROM Video video WHERE ";

	private static final String _SQL_COUNT_VIDEO =
		"SELECT COUNT(video) FROM Video video";

	private static final String _SQL_COUNT_VIDEO_WHERE =
		"SELECT COUNT(video) FROM Video video WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "video.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Video exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Video exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VideoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

}