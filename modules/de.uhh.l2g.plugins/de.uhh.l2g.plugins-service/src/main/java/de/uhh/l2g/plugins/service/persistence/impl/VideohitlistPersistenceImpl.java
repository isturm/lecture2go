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

import de.uhh.l2g.plugins.exception.NoSuchVideohitlistException;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.model.impl.VideohitlistImpl;
import de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl;
import de.uhh.l2g.plugins.service.persistence.VideohitlistPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the videohitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class VideohitlistPersistenceImpl
	extends BasePersistenceImpl<Videohitlist>
	implements VideohitlistPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VideohitlistUtil</code> to access the videohitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VideohitlistImpl.class.getName();

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
	 * Returns all the videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (useFinderCache) {
			list = (List<Videohitlist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Videohitlist videohitlist : list) {
					if (videoId != videohitlist.getVideoId()) {
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

			sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				list = (List<Videohitlist>)QueryUtil.list(
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
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByVideo_First(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByVideo_First(
			videoId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByVideo_First(
		long videoId, OrderByComparator<Videohitlist> orderByComparator) {

		List<Videohitlist> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByVideo_Last(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByVideo_Last(
			videoId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByVideo_Last(
		long videoId, OrderByComparator<Videohitlist> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Videohitlist> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist[] findByVideo_PrevAndNext(
			long videohitlistId, long videoId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = findByPrimaryKey(videohitlistId);

		Session session = null;

		try {
			session = openSession();

			Videohitlist[] array = new VideohitlistImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, videohitlist, videoId, orderByComparator, true);

			array[1] = videohitlist;

			array[2] = getByVideo_PrevAndNext(
				session, videohitlist, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Videohitlist getByVideo_PrevAndNext(
		Session session, Videohitlist videohitlist, long videoId,
		OrderByComparator<Videohitlist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

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
			sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(videoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(videohitlist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Videohitlist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videohitlists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Videohitlist videohitlist :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching videohitlists
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEOHITLIST_WHERE);

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
		"videohitlist.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (useFinderCache) {
			list = (List<Videohitlist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Videohitlist videohitlist : list) {
					if (groupId != videohitlist.getGroupId()) {
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

			sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Videohitlist>)QueryUtil.list(
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
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByGroup_First(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByGroup_First(
			groupId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByGroup_First(
		long groupId, OrderByComparator<Videohitlist> orderByComparator) {

		List<Videohitlist> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByGroup_Last(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByGroup_Last(
			groupId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByGroup_Last(
		long groupId, OrderByComparator<Videohitlist> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Videohitlist> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist[] findByGroup_PrevAndNext(
			long videohitlistId, long groupId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = findByPrimaryKey(videohitlistId);

		Session session = null;

		try {
			session = openSession();

			Videohitlist[] array = new VideohitlistImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, videohitlist, groupId, orderByComparator, true);

			array[1] = videohitlist;

			array[2] = getByGroup_PrevAndNext(
				session, videohitlist, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Videohitlist getByGroup_PrevAndNext(
		Session session, Videohitlist videohitlist, long groupId,
		OrderByComparator<Videohitlist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

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
			sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(videohitlist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Videohitlist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videohitlists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Videohitlist videohitlist :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching videohitlists
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEOHITLIST_WHERE);

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
		"videohitlist.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByCompany(
		long companyId, int start, int end) {

		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (useFinderCache) {
			list = (List<Videohitlist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Videohitlist videohitlist : list) {
					if (companyId != videohitlist.getCompanyId()) {
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

			sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Videohitlist>)QueryUtil.list(
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
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByCompany_First(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByCompany_First(
			companyId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByCompany_First(
		long companyId, OrderByComparator<Videohitlist> orderByComparator) {

		List<Videohitlist> list = findByCompany(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByCompany_Last(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByCompany_Last(
			companyId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByCompany_Last(
		long companyId, OrderByComparator<Videohitlist> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Videohitlist> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist[] findByCompany_PrevAndNext(
			long videohitlistId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = findByPrimaryKey(videohitlistId);

		Session session = null;

		try {
			session = openSession();

			Videohitlist[] array = new VideohitlistImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, videohitlist, companyId, orderByComparator, true);

			array[1] = videohitlist;

			array[2] = getByCompany_PrevAndNext(
				session, videohitlist, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Videohitlist getByCompany_PrevAndNext(
		Session session, Videohitlist videohitlist, long companyId,
		OrderByComparator<Videohitlist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

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
			sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(videohitlist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Videohitlist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videohitlists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Videohitlist videohitlist :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEOHITLIST_WHERE);

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
		"videohitlist.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId) {

		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Override
	public List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (useFinderCache) {
			list = (List<Videohitlist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Videohitlist videohitlist : list) {
					if ((groupId != videohitlist.getGroupId()) ||
						(companyId != videohitlist.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Videohitlist>)QueryUtil.list(
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
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator) {

		List<Videohitlist> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (videohitlist != null) {
			return videohitlist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVideohitlistException(sb.toString());
	}

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	@Override
	public Videohitlist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Videohitlist> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist[] findByGroupAndCompany_PrevAndNext(
			long videohitlistId, long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = findByPrimaryKey(videohitlistId);

		Session session = null;

		try {
			session = openSession();

			Videohitlist[] array = new VideohitlistImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, videohitlist, groupId, companyId, orderByComparator,
				true);

			array[1] = videohitlist;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, videohitlist, groupId, companyId, orderByComparator,
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

	protected Videohitlist getByGroupAndCompany_PrevAndNext(
		Session session, Videohitlist videohitlist, long groupId,
		long companyId, OrderByComparator<Videohitlist> orderByComparator,
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

		sb.append(_SQL_SELECT_VIDEOHITLIST_WHERE);

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
			sb.append(VideohitlistModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(videohitlist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Videohitlist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videohitlists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Videohitlist videohitlist :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIDEOHITLIST_WHERE);

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
		"videohitlist.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"videohitlist.companyId = ?";

	public VideohitlistPersistenceImpl() {
		setModelClass(Videohitlist.class);

		setModelImplClass(VideohitlistImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(VideohitlistModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the videohitlist in the entity cache if it is enabled.
	 *
	 * @param videohitlist the videohitlist
	 */
	@Override
	public void cacheResult(Videohitlist videohitlist) {
		entityCache.putResult(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED, VideohitlistImpl.class,
			videohitlist.getPrimaryKey(), videohitlist);

		videohitlist.resetOriginalValues();
	}

	/**
	 * Caches the videohitlists in the entity cache if it is enabled.
	 *
	 * @param videohitlists the videohitlists
	 */
	@Override
	public void cacheResult(List<Videohitlist> videohitlists) {
		for (Videohitlist videohitlist : videohitlists) {
			if (entityCache.getResult(
					VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
					VideohitlistImpl.class, videohitlist.getPrimaryKey()) ==
						null) {

				cacheResult(videohitlist);
			}
			else {
				videohitlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all videohitlists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideohitlistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the videohitlist.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Videohitlist videohitlist) {
		entityCache.removeResult(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED, VideohitlistImpl.class,
			videohitlist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Videohitlist> videohitlists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Videohitlist videohitlist : videohitlists) {
			entityCache.removeResult(
				VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, videohitlist.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
				VideohitlistImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	@Override
	public Videohitlist create(long videohitlistId) {
		Videohitlist videohitlist = new VideohitlistImpl();

		videohitlist.setNew(true);
		videohitlist.setPrimaryKey(videohitlistId);

		videohitlist.setCompanyId(CompanyThreadLocal.getCompanyId());

		return videohitlist;
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist remove(long videohitlistId)
		throws NoSuchVideohitlistException {

		return remove((Serializable)videohitlistId);
	}

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist remove(Serializable primaryKey)
		throws NoSuchVideohitlistException {

		Session session = null;

		try {
			session = openSession();

			Videohitlist videohitlist = (Videohitlist)session.get(
				VideohitlistImpl.class, primaryKey);

			if (videohitlist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideohitlistException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(videohitlist);
		}
		catch (NoSuchVideohitlistException noSuchEntityException) {
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
	protected Videohitlist removeImpl(Videohitlist videohitlist) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(videohitlist)) {
				videohitlist = (Videohitlist)session.get(
					VideohitlistImpl.class, videohitlist.getPrimaryKeyObj());
			}

			if (videohitlist != null) {
				session.delete(videohitlist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (videohitlist != null) {
			clearCache(videohitlist);
		}

		return videohitlist;
	}

	@Override
	public Videohitlist updateImpl(Videohitlist videohitlist) {
		boolean isNew = videohitlist.isNew();

		if (!(videohitlist instanceof VideohitlistModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(videohitlist.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					videohitlist);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in videohitlist proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Videohitlist implementation " +
					videohitlist.getClass());
		}

		VideohitlistModelImpl videohitlistModelImpl =
			(VideohitlistModelImpl)videohitlist;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (videohitlist.getCreateDate() == null)) {
			if (serviceContext == null) {
				videohitlist.setCreateDate(now);
			}
			else {
				videohitlist.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!videohitlistModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				videohitlist.setModifiedDate(now);
			}
			else {
				videohitlist.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (videohitlist.isNew()) {
				session.save(videohitlist);

				videohitlist.setNew(false);
			}
			else {
				videohitlist = (Videohitlist)session.merge(videohitlist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VideohitlistModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {videohitlistModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {videohitlistModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {videohitlistModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				videohitlistModelImpl.getGroupId(),
				videohitlistModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((videohitlistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					videohitlistModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {videohitlistModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((videohitlistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					videohitlistModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {videohitlistModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((videohitlistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videohitlistModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {videohitlistModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((videohitlistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					videohitlistModelImpl.getOriginalGroupId(),
					videohitlistModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					videohitlistModelImpl.getGroupId(),
					videohitlistModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED, VideohitlistImpl.class,
			videohitlist.getPrimaryKey(), videohitlist, false);

		videohitlist.resetOriginalValues();

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideohitlistException {

		Videohitlist videohitlist = fetchByPrimaryKey(primaryKey);

		if (videohitlist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideohitlistException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return videohitlist;
	}

	/**
	 * Returns the videohitlist with the primary key or throws a <code>NoSuchVideohitlistException</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist findByPrimaryKey(long videohitlistId)
		throws NoSuchVideohitlistException {

		return findByPrimaryKey((Serializable)videohitlistId);
	}

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 */
	@Override
	public Videohitlist fetchByPrimaryKey(long videohitlistId) {
		return fetchByPrimaryKey((Serializable)videohitlistId);
	}

	/**
	 * Returns all the videohitlists.
	 *
	 * @return the videohitlists
	 */
	@Override
	public List<Videohitlist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of videohitlists
	 */
	@Override
	public List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator,
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

		List<Videohitlist> list = null;

		if (useFinderCache) {
			list = (List<Videohitlist>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VIDEOHITLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOHITLIST;

				sql = sql.concat(VideohitlistModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Videohitlist>)QueryUtil.list(
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
	 * Removes all the videohitlists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Videohitlist videohitlist : findAll()) {
			remove(videohitlist);
		}
	}

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VIDEOHITLIST);

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
		return "videohitlistId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEOHITLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VideohitlistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the videohitlist persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] {Long.class.getName()},
			VideohitlistModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			VideohitlistModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			VideohitlistModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, VideohitlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			VideohitlistModelImpl.GROUPID_COLUMN_BITMASK |
			VideohitlistModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			VideohitlistModelImpl.ENTITY_CACHE_ENABLED,
			VideohitlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(VideohitlistImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIDEOHITLIST =
		"SELECT videohitlist FROM Videohitlist videohitlist";

	private static final String _SQL_SELECT_VIDEOHITLIST_WHERE =
		"SELECT videohitlist FROM Videohitlist videohitlist WHERE ";

	private static final String _SQL_COUNT_VIDEOHITLIST =
		"SELECT COUNT(videohitlist) FROM Videohitlist videohitlist";

	private static final String _SQL_COUNT_VIDEOHITLIST_WHERE =
		"SELECT COUNT(videohitlist) FROM Videohitlist videohitlist WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "videohitlist.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Videohitlist exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Videohitlist exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VideohitlistPersistenceImpl.class);

}