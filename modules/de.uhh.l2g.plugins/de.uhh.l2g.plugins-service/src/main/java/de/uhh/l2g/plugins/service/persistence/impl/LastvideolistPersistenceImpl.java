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
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchLastvideolistException;
import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.impl.LastvideolistImpl;
import de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl;
import de.uhh.l2g.plugins.service.persistence.LastvideolistPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lastvideolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class LastvideolistPersistenceImpl
	extends BasePersistenceImpl<Lastvideolist>
	implements LastvideolistPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LastvideolistUtil</code> to access the lastvideolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LastvideolistImpl.class.getName();

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
	 * Returns all the lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

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

		List<Lastvideolist> list = null;

		if (useFinderCache) {
			list = (List<Lastvideolist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lastvideolist lastvideolist : list) {
					if (videoId != lastvideolist.getVideoId()) {
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

			sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				list = (List<Lastvideolist>)QueryUtil.list(
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
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByVideo_First(
			long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByVideo_First(
			videoId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByVideo_First(
		long videoId, OrderByComparator<Lastvideolist> orderByComparator) {

		List<Lastvideolist> list = findByVideo(
			videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByVideo_Last(
			long videoId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByVideo_Last(
			videoId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByVideo_Last(
		long videoId, OrderByComparator<Lastvideolist> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Lastvideolist> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist[] findByVideo_PrevAndNext(
			int lastvideolistId, long videoId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = findByPrimaryKey(lastvideolistId);

		Session session = null;

		try {
			session = openSession();

			Lastvideolist[] array = new LastvideolistImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, lastvideolist, videoId, orderByComparator, true);

			array[1] = lastvideolist;

			array[2] = getByVideo_PrevAndNext(
				session, lastvideolist, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lastvideolist getByVideo_PrevAndNext(
		Session session, Lastvideolist lastvideolist, long videoId,
		OrderByComparator<Lastvideolist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

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
			sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(videoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lastvideolist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lastvideolist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lastvideolists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Lastvideolist lastvideolist :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching lastvideolists
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LASTVIDEOLIST_WHERE);

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
		"lastvideolist.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

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

		List<Lastvideolist> list = null;

		if (useFinderCache) {
			list = (List<Lastvideolist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lastvideolist lastvideolist : list) {
					if (groupId != lastvideolist.getGroupId()) {
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

			sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Lastvideolist>)QueryUtil.list(
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
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByGroup_First(
			long groupId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByGroup_First(
			groupId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByGroup_First(
		long groupId, OrderByComparator<Lastvideolist> orderByComparator) {

		List<Lastvideolist> list = findByGroup(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByGroup_Last(
			long groupId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByGroup_Last(
			groupId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByGroup_Last(
		long groupId, OrderByComparator<Lastvideolist> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Lastvideolist> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist[] findByGroup_PrevAndNext(
			int lastvideolistId, long groupId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = findByPrimaryKey(lastvideolistId);

		Session session = null;

		try {
			session = openSession();

			Lastvideolist[] array = new LastvideolistImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, lastvideolist, groupId, orderByComparator, true);

			array[1] = lastvideolist;

			array[2] = getByGroup_PrevAndNext(
				session, lastvideolist, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lastvideolist getByGroup_PrevAndNext(
		Session session, Lastvideolist lastvideolist, long groupId,
		OrderByComparator<Lastvideolist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

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
			sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lastvideolist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lastvideolist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lastvideolists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Lastvideolist lastvideolist :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lastvideolists
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LASTVIDEOLIST_WHERE);

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
		"lastvideolist.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByCompany(
		long companyId, int start, int end) {

		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

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

		List<Lastvideolist> list = null;

		if (useFinderCache) {
			list = (List<Lastvideolist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lastvideolist lastvideolist : list) {
					if (companyId != lastvideolist.getCompanyId()) {
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

			sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Lastvideolist>)QueryUtil.list(
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
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByCompany_First(
			long companyId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByCompany_First(
			companyId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByCompany_First(
		long companyId, OrderByComparator<Lastvideolist> orderByComparator) {

		List<Lastvideolist> list = findByCompany(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByCompany_Last(
			long companyId, OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByCompany_Last(
			companyId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByCompany_Last(
		long companyId, OrderByComparator<Lastvideolist> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Lastvideolist> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist[] findByCompany_PrevAndNext(
			int lastvideolistId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = findByPrimaryKey(lastvideolistId);

		Session session = null;

		try {
			session = openSession();

			Lastvideolist[] array = new LastvideolistImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, lastvideolist, companyId, orderByComparator, true);

			array[1] = lastvideolist;

			array[2] = getByCompany_PrevAndNext(
				session, lastvideolist, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lastvideolist getByCompany_PrevAndNext(
		Session session, Lastvideolist lastvideolist, long companyId,
		OrderByComparator<Lastvideolist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

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
			sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lastvideolist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lastvideolist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lastvideolists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Lastvideolist lastvideolist :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LASTVIDEOLIST_WHERE);

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
		"lastvideolist.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId) {

		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	@Override
	public List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator,
		boolean useFinderCache) {

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

		List<Lastvideolist> list = null;

		if (useFinderCache) {
			list = (List<Lastvideolist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lastvideolist lastvideolist : list) {
					if ((groupId != lastvideolist.getGroupId()) ||
						(companyId != lastvideolist.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Lastvideolist>)QueryUtil.list(
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
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Lastvideolist> orderByComparator) {

		List<Lastvideolist> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (lastvideolist != null) {
			return lastvideolist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLastvideolistException(sb.toString());
	}

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	@Override
	public Lastvideolist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Lastvideolist> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Lastvideolist> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist[] findByGroupAndCompany_PrevAndNext(
			int lastvideolistId, long groupId, long companyId,
			OrderByComparator<Lastvideolist> orderByComparator)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = findByPrimaryKey(lastvideolistId);

		Session session = null;

		try {
			session = openSession();

			Lastvideolist[] array = new LastvideolistImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, lastvideolist, groupId, companyId, orderByComparator,
				true);

			array[1] = lastvideolist;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, lastvideolist, groupId, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lastvideolist getByGroupAndCompany_PrevAndNext(
		Session session, Lastvideolist lastvideolist, long groupId,
		long companyId, OrderByComparator<Lastvideolist> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LASTVIDEOLIST_WHERE);

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
			sb.append(LastvideolistModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						lastvideolist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lastvideolist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lastvideolists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Lastvideolist lastvideolist :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LASTVIDEOLIST_WHERE);

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
		"lastvideolist.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"lastvideolist.companyId = ?";

	public LastvideolistPersistenceImpl() {
		setModelClass(Lastvideolist.class);

		setModelImplClass(LastvideolistImpl.class);
		setModelPKClass(int.class);
		setEntityCacheEnabled(LastvideolistModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the lastvideolist in the entity cache if it is enabled.
	 *
	 * @param lastvideolist the lastvideolist
	 */
	@Override
	public void cacheResult(Lastvideolist lastvideolist) {
		entityCache.putResult(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist);

		lastvideolist.resetOriginalValues();
	}

	/**
	 * Caches the lastvideolists in the entity cache if it is enabled.
	 *
	 * @param lastvideolists the lastvideolists
	 */
	@Override
	public void cacheResult(List<Lastvideolist> lastvideolists) {
		for (Lastvideolist lastvideolist : lastvideolists) {
			if (entityCache.getResult(
					LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
					LastvideolistImpl.class, lastvideolist.getPrimaryKey()) ==
						null) {

				cacheResult(lastvideolist);
			}
			else {
				lastvideolist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lastvideolists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LastvideolistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lastvideolist.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lastvideolist lastvideolist) {
		entityCache.removeResult(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lastvideolist> lastvideolists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lastvideolist lastvideolist : lastvideolists) {
			entityCache.removeResult(
				LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, lastvideolist.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
				LastvideolistImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	@Override
	public Lastvideolist create(int lastvideolistId) {
		Lastvideolist lastvideolist = new LastvideolistImpl();

		lastvideolist.setNew(true);
		lastvideolist.setPrimaryKey(lastvideolistId);

		lastvideolist.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lastvideolist;
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist remove(int lastvideolistId)
		throws NoSuchLastvideolistException {

		return remove((Serializable)lastvideolistId);
	}

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist remove(Serializable primaryKey)
		throws NoSuchLastvideolistException {

		Session session = null;

		try {
			session = openSession();

			Lastvideolist lastvideolist = (Lastvideolist)session.get(
				LastvideolistImpl.class, primaryKey);

			if (lastvideolist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLastvideolistException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lastvideolist);
		}
		catch (NoSuchLastvideolistException noSuchEntityException) {
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
	protected Lastvideolist removeImpl(Lastvideolist lastvideolist) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lastvideolist)) {
				lastvideolist = (Lastvideolist)session.get(
					LastvideolistImpl.class, lastvideolist.getPrimaryKeyObj());
			}

			if (lastvideolist != null) {
				session.delete(lastvideolist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lastvideolist != null) {
			clearCache(lastvideolist);
		}

		return lastvideolist;
	}

	@Override
	public Lastvideolist updateImpl(Lastvideolist lastvideolist) {
		boolean isNew = lastvideolist.isNew();

		if (!(lastvideolist instanceof LastvideolistModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lastvideolist.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lastvideolist);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lastvideolist proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Lastvideolist implementation " +
					lastvideolist.getClass());
		}

		LastvideolistModelImpl lastvideolistModelImpl =
			(LastvideolistModelImpl)lastvideolist;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lastvideolist.getCreateDate() == null)) {
			if (serviceContext == null) {
				lastvideolist.setCreateDate(now);
			}
			else {
				lastvideolist.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!lastvideolistModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lastvideolist.setModifiedDate(now);
			}
			else {
				lastvideolist.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lastvideolist.isNew()) {
				session.save(lastvideolist);

				lastvideolist.setNew(false);
			}
			else {
				lastvideolist = (Lastvideolist)session.merge(lastvideolist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LastvideolistModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {lastvideolistModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {lastvideolistModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {lastvideolistModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				lastvideolistModelImpl.getGroupId(),
				lastvideolistModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lastvideolistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					lastvideolistModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {lastvideolistModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((lastvideolistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					lastvideolistModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {lastvideolistModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((lastvideolistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lastvideolistModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {lastvideolistModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((lastvideolistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lastvideolistModelImpl.getOriginalGroupId(),
					lastvideolistModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					lastvideolistModelImpl.getGroupId(),
					lastvideolistModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistImpl.class, lastvideolist.getPrimaryKey(),
			lastvideolist, false);

		lastvideolist.resetOriginalValues();

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLastvideolistException {

		Lastvideolist lastvideolist = fetchByPrimaryKey(primaryKey);

		if (lastvideolist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLastvideolistException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lastvideolist;
	}

	/**
	 * Returns the lastvideolist with the primary key or throws a <code>NoSuchLastvideolistException</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws NoSuchLastvideolistException {

		return findByPrimaryKey((Serializable)lastvideolistId);
	}

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 */
	@Override
	public Lastvideolist fetchByPrimaryKey(int lastvideolistId) {
		return fetchByPrimaryKey((Serializable)lastvideolistId);
	}

	/**
	 * Returns all the lastvideolists.
	 *
	 * @return the lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(
		int start, int end,
		OrderByComparator<Lastvideolist> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lastvideolists
	 */
	@Override
	public List<Lastvideolist> findAll(
		int start, int end, OrderByComparator<Lastvideolist> orderByComparator,
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

		List<Lastvideolist> list = null;

		if (useFinderCache) {
			list = (List<Lastvideolist>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LASTVIDEOLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LASTVIDEOLIST;

				sql = sql.concat(LastvideolistModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Lastvideolist>)QueryUtil.list(
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
	 * Removes all the lastvideolists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lastvideolist lastvideolist : findAll()) {
			remove(lastvideolist);
		}
	}

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LASTVIDEOLIST);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "lastvideolistId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LASTVIDEOLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LastvideolistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lastvideolist persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] {Long.class.getName()},
			LastvideolistModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup", new String[] {Long.class.getName()},
			LastvideolistModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompany", new String[] {Long.class.getName()},
			LastvideolistModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED,
			LastvideolistImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			LastvideolistModelImpl.GROUPID_COLUMN_BITMASK |
			LastvideolistModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			LastvideolistModelImpl.ENTITY_CACHE_ENABLED,
			LastvideolistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LastvideolistImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LASTVIDEOLIST =
		"SELECT lastvideolist FROM Lastvideolist lastvideolist";

	private static final String _SQL_SELECT_LASTVIDEOLIST_WHERE =
		"SELECT lastvideolist FROM Lastvideolist lastvideolist WHERE ";

	private static final String _SQL_COUNT_LASTVIDEOLIST =
		"SELECT COUNT(lastvideolist) FROM Lastvideolist lastvideolist";

	private static final String _SQL_COUNT_LASTVIDEOLIST_WHERE =
		"SELECT COUNT(lastvideolist) FROM Lastvideolist lastvideolist WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lastvideolist.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Lastvideolist exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Lastvideolist exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LastvideolistPersistenceImpl.class);

}