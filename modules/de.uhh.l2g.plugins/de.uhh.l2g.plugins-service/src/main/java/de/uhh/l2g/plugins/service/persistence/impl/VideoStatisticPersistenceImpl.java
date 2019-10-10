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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException;
import de.uhh.l2g.plugins.model.VideoStatistic;
import de.uhh.l2g.plugins.model.impl.VideoStatisticImpl;
import de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl;
import de.uhh.l2g.plugins.service.persistence.VideoStatisticPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the video statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideoStatisticPersistence
 * @see de.uhh.l2g.plugins.service.persistence.VideoStatisticUtil
 * @generated
 */
@ProviderType
public class VideoStatisticPersistenceImpl extends BasePersistenceImpl<VideoStatistic>
	implements VideoStatisticPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoStatisticUtil} to access the video statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoStatisticImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoStatisticModelImpl.GROUPID_COLUMN_BITMASK |
			VideoStatisticModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId) {
		return findByCompanyIdAndGroupId(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end) {
		return findByCompanyIdAndGroupId(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return findByCompanyIdAndGroupId(groupId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompanyIdAndGroupId(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VideoStatistic> list = null;

		if (retrieveFromCache) {
			list = (List<VideoStatistic>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VideoStatistic videoStatistic : list) {
					if ((groupId != videoStatistic.getGroupId()) ||
							(companyId != videoStatistic.getCompanyId())) {
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

			query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByCompanyIdAndGroupId_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByCompanyIdAndGroupId_First(groupId,
				companyId, orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByCompanyIdAndGroupId_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		List<VideoStatistic> list = findByCompanyIdAndGroupId(groupId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByCompanyIdAndGroupId_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByCompanyIdAndGroupId_Last(groupId,
				companyId, orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByCompanyIdAndGroupId_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		int count = countByCompanyIdAndGroupId(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<VideoStatistic> list = findByCompanyIdAndGroupId(groupId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videoStatisticId the primary key of the current video statistic
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic[] findByCompanyIdAndGroupId_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = findByPrimaryKey(videoStatisticId);

		Session session = null;

		try {
			session = openSession();

			VideoStatistic[] array = new VideoStatisticImpl[3];

			array[0] = getByCompanyIdAndGroupId_PrevAndNext(session,
					videoStatistic, groupId, companyId, orderByComparator, true);

			array[1] = videoStatistic;

			array[2] = getByCompanyIdAndGroupId_PrevAndNext(session,
					videoStatistic, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoStatistic getByCompanyIdAndGroupId_PrevAndNext(
		Session session, VideoStatistic videoStatistic, long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

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
			query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoStatistic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoStatistic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyIdAndGroupId(long groupId, long companyId) {
		for (VideoStatistic videoStatistic : findByCompanyIdAndGroupId(
				groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching video statistics
	 */
	@Override
	public int countByCompanyIdAndGroupId(long groupId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "videoStatistic.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "videoStatistic.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			VideoStatisticModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroup(long groupId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroup(long groupId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<VideoStatistic> list = null;

		if (retrieveFromCache) {
			list = (List<VideoStatistic>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VideoStatistic videoStatistic : list) {
					if ((groupId != videoStatistic.getGroupId())) {
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

			query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Returns the first video statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByGroup_First(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByGroup_First(groupId,
				orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the first video statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByGroup_First(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		List<VideoStatistic> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByGroup_Last(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByGroup_Last(groupId,
				orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByGroup_Last(long groupId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<VideoStatistic> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63;.
	 *
	 * @param videoStatisticId the primary key of the current video statistic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic[] findByGroup_PrevAndNext(long videoStatisticId,
		long groupId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = findByPrimaryKey(videoStatisticId);

		Session session = null;

		try {
			session = openSession();

			VideoStatistic[] array = new VideoStatisticImpl[3];

			array[0] = getByGroup_PrevAndNext(session, videoStatistic, groupId,
					orderByComparator, true);

			array[1] = videoStatistic;

			array[2] = getByGroup_PrevAndNext(session, videoStatistic, groupId,
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

	protected VideoStatistic getByGroup_PrevAndNext(Session session,
		VideoStatistic videoStatistic, long groupId,
		OrderByComparator<VideoStatistic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoStatistic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoStatistic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video statistics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (VideoStatistic videoStatistic : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching video statistics
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "videoStatistic.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VideoStatisticModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompany(long companyId) {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompany(long companyId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator) {
		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByCompany(long companyId, int start,
		int end, OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<VideoStatistic> list = null;

		if (retrieveFromCache) {
			list = (List<VideoStatistic>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VideoStatistic videoStatistic : list) {
					if ((companyId != videoStatistic.getCompanyId())) {
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

			query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Returns the first video statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByCompany_First(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByCompany_First(companyId,
				orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the first video statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByCompany_First(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		List<VideoStatistic> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByCompany_Last(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByCompany_Last(companyId,
				orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the last video statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByCompany_Last(long companyId,
		OrderByComparator<VideoStatistic> orderByComparator) {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<VideoStatistic> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video statistics before and after the current video statistic in the ordered set where companyId = &#63;.
	 *
	 * @param videoStatisticId the primary key of the current video statistic
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic[] findByCompany_PrevAndNext(long videoStatisticId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = findByPrimaryKey(videoStatisticId);

		Session session = null;

		try {
			session = openSession();

			VideoStatistic[] array = new VideoStatisticImpl[3];

			array[0] = getByCompany_PrevAndNext(session, videoStatistic,
					companyId, orderByComparator, true);

			array[1] = videoStatistic;

			array[2] = getByCompany_PrevAndNext(session, videoStatistic,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoStatistic getByCompany_PrevAndNext(Session session,
		VideoStatistic videoStatistic, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoStatistic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoStatistic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video statistics where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (VideoStatistic videoStatistic : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching video statistics
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "videoStatistic.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCOMPANY =
		new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY =
		new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED,
			VideoStatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoStatisticModelImpl.GROUPID_COLUMN_BITMASK |
			VideoStatisticModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDCOMPANY = new FinderPath(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupAndCompany",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId) {
		return findByGroupAndCompany(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end) {
		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return findByGroupAndCompany(groupId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video statistics
	 */
	@Override
	public List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDCOMPANY;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<VideoStatistic> list = null;

		if (retrieveFromCache) {
			list = (List<VideoStatistic>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VideoStatistic videoStatistic : list) {
					if ((groupId != videoStatistic.getGroupId()) ||
							(companyId != videoStatistic.getCompanyId())) {
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

			query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByGroupAndCompany_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByGroupAndCompany_First(groupId,
				companyId, orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByGroupAndCompany_First(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		List<VideoStatistic> list = findByGroupAndCompany(groupId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic
	 * @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic findByGroupAndCompany_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByGroupAndCompany_Last(groupId,
				companyId, orderByComparator);

		if (videoStatistic != null) {
			return videoStatistic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideoStatisticException(msg.toString());
	}

	/**
	 * Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	 */
	@Override
	public VideoStatistic fetchByGroupAndCompany_Last(long groupId,
		long companyId, OrderByComparator<VideoStatistic> orderByComparator) {
		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<VideoStatistic> list = findByGroupAndCompany(groupId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videoStatisticId the primary key of the current video statistic
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic[] findByGroupAndCompany_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = findByPrimaryKey(videoStatisticId);

		Session session = null;

		try {
			session = openSession();

			VideoStatistic[] array = new VideoStatisticImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(session,
					videoStatistic, groupId, companyId, orderByComparator, true);

			array[1] = videoStatistic;

			array[2] = getByGroupAndCompany_PrevAndNext(session,
					videoStatistic, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoStatistic getByGroupAndCompany_PrevAndNext(Session session,
		VideoStatistic videoStatistic, long groupId, long companyId,
		OrderByComparator<VideoStatistic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

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
			query.append(VideoStatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoStatistic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoStatistic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (VideoStatistic videoStatistic : findByGroupAndCompany(groupId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching video statistics
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDCOMPANY;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOSTATISTIC_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 = "videoStatistic.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 = "videoStatistic.companyId = ?";

	public VideoStatisticPersistenceImpl() {
		setModelClass(VideoStatistic.class);
	}

	/**
	 * Caches the video statistic in the entity cache if it is enabled.
	 *
	 * @param videoStatistic the video statistic
	 */
	@Override
	public void cacheResult(VideoStatistic videoStatistic) {
		entityCache.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey(),
			videoStatistic);

		videoStatistic.resetOriginalValues();
	}

	/**
	 * Caches the video statistics in the entity cache if it is enabled.
	 *
	 * @param videoStatistics the video statistics
	 */
	@Override
	public void cacheResult(List<VideoStatistic> videoStatistics) {
		for (VideoStatistic videoStatistic : videoStatistics) {
			if (entityCache.getResult(
						VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
						VideoStatisticImpl.class, videoStatistic.getPrimaryKey()) == null) {
				cacheResult(videoStatistic);
			}
			else {
				videoStatistic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video statistics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideoStatisticImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video statistic.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoStatistic videoStatistic) {
		entityCache.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoStatistic> videoStatistics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoStatistic videoStatistic : videoStatistics) {
			entityCache.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
				VideoStatisticImpl.class, videoStatistic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	 *
	 * @param videoStatisticId the primary key for the new video statistic
	 * @return the new video statistic
	 */
	@Override
	public VideoStatistic create(long videoStatisticId) {
		VideoStatistic videoStatistic = new VideoStatisticImpl();

		videoStatistic.setNew(true);
		videoStatistic.setPrimaryKey(videoStatisticId);

		videoStatistic.setCompanyId(companyProvider.getCompanyId());

		return videoStatistic;
	}

	/**
	 * Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic that was removed
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic remove(long videoStatisticId)
		throws NoSuchVideoStatisticException {
		return remove((Serializable)videoStatisticId);
	}

	/**
	 * Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic that was removed
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic remove(Serializable primaryKey)
		throws NoSuchVideoStatisticException {
		Session session = null;

		try {
			session = openSession();

			VideoStatistic videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
					primaryKey);

			if (videoStatistic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoStatistic);
		}
		catch (NoSuchVideoStatisticException nsee) {
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
	protected VideoStatistic removeImpl(VideoStatistic videoStatistic) {
		videoStatistic = toUnwrappedModel(videoStatistic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videoStatistic)) {
				videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
						videoStatistic.getPrimaryKeyObj());
			}

			if (videoStatistic != null) {
				session.delete(videoStatistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (videoStatistic != null) {
			clearCache(videoStatistic);
		}

		return videoStatistic;
	}

	@Override
	public VideoStatistic updateImpl(VideoStatistic videoStatistic) {
		videoStatistic = toUnwrappedModel(videoStatistic);

		boolean isNew = videoStatistic.isNew();

		VideoStatisticModelImpl videoStatisticModelImpl = (VideoStatisticModelImpl)videoStatistic;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (videoStatistic.getCreateDate() == null)) {
			if (serviceContext == null) {
				videoStatistic.setCreateDate(now);
			}
			else {
				videoStatistic.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!videoStatisticModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				videoStatistic.setModifiedDate(now);
			}
			else {
				videoStatistic.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (videoStatistic.isNew()) {
				session.save(videoStatistic);

				videoStatistic.setNew(false);
			}
			else {
				videoStatistic = (VideoStatistic)session.merge(videoStatistic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VideoStatisticModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					videoStatisticModelImpl.getGroupId(),
					videoStatisticModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
				args);

			args = new Object[] { videoStatisticModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
				args);

			args = new Object[] { videoStatisticModelImpl.getCompanyId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
				args);

			args = new Object[] {
					videoStatisticModelImpl.getGroupId(),
					videoStatisticModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((videoStatisticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoStatisticModelImpl.getOriginalGroupId(),
						videoStatisticModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);

				args = new Object[] {
						videoStatisticModelImpl.getGroupId(),
						videoStatisticModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);
			}

			if ((videoStatisticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoStatisticModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { videoStatisticModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((videoStatisticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoStatisticModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { videoStatisticModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((videoStatisticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoStatisticModelImpl.getOriginalGroupId(),
						videoStatisticModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
					args);

				args = new Object[] {
						videoStatisticModelImpl.getGroupId(),
						videoStatisticModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPANDCOMPANY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDCOMPANY,
					args);
			}
		}

		entityCache.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
			VideoStatisticImpl.class, videoStatistic.getPrimaryKey(),
			videoStatistic, false);

		videoStatistic.resetOriginalValues();

		return videoStatistic;
	}

	protected VideoStatistic toUnwrappedModel(VideoStatistic videoStatistic) {
		if (videoStatistic instanceof VideoStatisticImpl) {
			return videoStatistic;
		}

		VideoStatisticImpl videoStatisticImpl = new VideoStatisticImpl();

		videoStatisticImpl.setNew(videoStatistic.isNew());
		videoStatisticImpl.setPrimaryKey(videoStatistic.getPrimaryKey());

		videoStatisticImpl.setVideoStatisticId(videoStatistic.getVideoStatisticId());
		videoStatisticImpl.setGroupId(videoStatistic.getGroupId());
		videoStatisticImpl.setCompanyId(videoStatistic.getCompanyId());
		videoStatisticImpl.setCreateDate(videoStatistic.getCreateDate());
		videoStatisticImpl.setModifiedDate(videoStatistic.getModifiedDate());
		videoStatisticImpl.setCompareDate(videoStatistic.getCompareDate());
		videoStatisticImpl.setTotalVideos(videoStatistic.getTotalVideos());
		videoStatisticImpl.setPublicVideos(videoStatistic.getPublicVideos());
		videoStatisticImpl.setPrivateVideos(videoStatistic.getPrivateVideos());
		videoStatisticImpl.setCurrentTotal(videoStatistic.getCurrentTotal());
		videoStatisticImpl.setCurrentPublic(videoStatistic.getCurrentPublic());
		videoStatisticImpl.setCurrentPrivate(videoStatistic.getCurrentPrivate());
		videoStatisticImpl.setPubPercent(videoStatistic.getPubPercent());
		videoStatisticImpl.setPrivPercent(videoStatistic.getPrivPercent());
		videoStatisticImpl.setCurrentPubPercent(videoStatistic.getCurrentPubPercent());
		videoStatisticImpl.setCurrentPrivPercent(videoStatistic.getCurrentPrivPercent());
		videoStatisticImpl.setIntervalName(videoStatistic.getIntervalName());
		videoStatisticImpl.setPublicDiff(videoStatistic.getPublicDiff());
		videoStatisticImpl.setPrivateDiff(videoStatistic.getPrivateDiff());
		videoStatisticImpl.setTotalDiff(videoStatistic.getTotalDiff());
		videoStatisticImpl.setDateDiff(videoStatistic.getDateDiff());

		return videoStatisticImpl;
	}

	/**
	 * Returns the video statistic with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoStatisticException {
		VideoStatistic videoStatistic = fetchByPrimaryKey(primaryKey);

		if (videoStatistic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoStatisticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return videoStatistic;
	}

	/**
	 * Returns the video statistic with the primary key or throws a {@link NoSuchVideoStatisticException} if it could not be found.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic
	 * @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic findByPrimaryKey(long videoStatisticId)
		throws NoSuchVideoStatisticException {
		return findByPrimaryKey((Serializable)videoStatisticId);
	}

	/**
	 * Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video statistic
	 * @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
				VideoStatisticImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VideoStatistic videoStatistic = (VideoStatistic)serializable;

		if (videoStatistic == null) {
			Session session = null;

			try {
				session = openSession();

				videoStatistic = (VideoStatistic)session.get(VideoStatisticImpl.class,
						primaryKey);

				if (videoStatistic != null) {
					cacheResult(videoStatistic);
				}
				else {
					entityCache.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
						VideoStatisticImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
					VideoStatisticImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return videoStatistic;
	}

	/**
	 * Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoStatisticId the primary key of the video statistic
	 * @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	 */
	@Override
	public VideoStatistic fetchByPrimaryKey(long videoStatisticId) {
		return fetchByPrimaryKey((Serializable)videoStatisticId);
	}

	@Override
	public Map<Serializable, VideoStatistic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VideoStatistic> map = new HashMap<Serializable, VideoStatistic>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VideoStatistic videoStatistic = fetchByPrimaryKey(primaryKey);

			if (videoStatistic != null) {
				map.put(primaryKey, videoStatistic);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
					VideoStatisticImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VideoStatistic)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEOSTATISTIC_WHERE_PKS_IN);

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

			for (VideoStatistic videoStatistic : (List<VideoStatistic>)q.list()) {
				map.put(videoStatistic.getPrimaryKeyObj(), videoStatistic);

				cacheResult(videoStatistic);

				uncachedPrimaryKeys.remove(videoStatistic.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VideoStatisticModelImpl.ENTITY_CACHE_ENABLED,
					VideoStatisticImpl.class, primaryKey, nullModel);
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
	 * Returns all the video statistics.
	 *
	 * @return the video statistics
	 */
	@Override
	public List<VideoStatistic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @return the range of video statistics
	 */
	@Override
	public List<VideoStatistic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video statistics
	 */
	@Override
	public List<VideoStatistic> findAll(int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video statistics
	 * @param end the upper bound of the range of video statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video statistics
	 */
	@Override
	public List<VideoStatistic> findAll(int start, int end,
		OrderByComparator<VideoStatistic> orderByComparator,
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

		List<VideoStatistic> list = null;

		if (retrieveFromCache) {
			list = (List<VideoStatistic>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEOSTATISTIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOSTATISTIC;

				if (pagination) {
					sql = sql.concat(VideoStatisticModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VideoStatistic>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VideoStatistic>)QueryUtil.list(q,
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
	 * Removes all the video statistics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VideoStatistic videoStatistic : findAll()) {
			remove(videoStatistic);
		}
	}

	/**
	 * Returns the number of video statistics.
	 *
	 * @return the number of video statistics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOSTATISTIC);

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
		return VideoStatisticModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video statistic persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VideoStatisticImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VIDEOSTATISTIC = "SELECT videoStatistic FROM VideoStatistic videoStatistic";
	private static final String _SQL_SELECT_VIDEOSTATISTIC_WHERE_PKS_IN = "SELECT videoStatistic FROM VideoStatistic videoStatistic WHERE videoStatisticId IN (";
	private static final String _SQL_SELECT_VIDEOSTATISTIC_WHERE = "SELECT videoStatistic FROM VideoStatistic videoStatistic WHERE ";
	private static final String _SQL_COUNT_VIDEOSTATISTIC = "SELECT COUNT(videoStatistic) FROM VideoStatistic videoStatistic";
	private static final String _SQL_COUNT_VIDEOSTATISTIC_WHERE = "SELECT COUNT(videoStatistic) FROM VideoStatistic videoStatistic WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoStatistic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoStatistic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoStatistic exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VideoStatisticPersistenceImpl.class);
}