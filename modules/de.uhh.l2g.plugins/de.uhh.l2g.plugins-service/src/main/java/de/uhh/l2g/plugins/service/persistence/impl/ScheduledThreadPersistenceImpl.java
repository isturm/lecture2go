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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException;
import de.uhh.l2g.plugins.model.ScheduledThread;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadImpl;
import de.uhh.l2g.plugins.model.impl.ScheduledThreadModelImpl;
import de.uhh.l2g.plugins.service.persistence.ScheduledThreadPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the scheduled thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class ScheduledThreadPersistenceImpl
	extends BasePersistenceImpl<ScheduledThread>
	implements ScheduledThreadPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ScheduledThreadUtil</code> to access the scheduled thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ScheduledThreadImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySchedulerClassName;
	private FinderPath _finderPathCountBySchedulerClassName;

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchBySchedulerClassName(
			schedulerClassName);

		if (scheduledThread == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("schedulerClassName=");
			sb.append(schedulerClassName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchScheduledThreadException(sb.toString());
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName) {

		return fetchBySchedulerClassName(schedulerClassName, true);
	}

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName, boolean useFinderCache) {

		schedulerClassName = Objects.toString(schedulerClassName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {schedulerClassName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySchedulerClassName, finderArgs, this);
		}

		if (result instanceof ScheduledThread) {
			ScheduledThread scheduledThread = (ScheduledThread)result;

			if (!Objects.equals(
					schedulerClassName,
					scheduledThread.getSchedulerClassName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

			boolean bindSchedulerClassName = false;

			if (schedulerClassName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3);
			}
			else {
				bindSchedulerClassName = true;

				sb.append(
					_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSchedulerClassName) {
					queryPos.add(schedulerClassName);
				}

				List<ScheduledThread> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySchedulerClassName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {schedulerClassName};
							}

							_log.warn(
								"ScheduledThreadPersistenceImpl.fetchBySchedulerClassName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ScheduledThread scheduledThread = list.get(0);

					result = scheduledThread;

					cacheResult(scheduledThread);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySchedulerClassName, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ScheduledThread)result;
		}
	}

	/**
	 * Removes the scheduled thread where schedulerClassName = &#63; from the database.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the scheduled thread that was removed
	 */
	@Override
	public ScheduledThread removeBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = findBySchedulerClassName(
			schedulerClassName);

		return remove(scheduledThread);
	}

	/**
	 * Returns the number of scheduled threads where schedulerClassName = &#63;.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the number of matching scheduled threads
	 */
	@Override
	public int countBySchedulerClassName(String schedulerClassName) {
		schedulerClassName = Objects.toString(schedulerClassName, "");

		FinderPath finderPath = _finderPathCountBySchedulerClassName;

		Object[] finderArgs = new Object[] {schedulerClassName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEDTHREAD_WHERE);

			boolean bindSchedulerClassName = false;

			if (schedulerClassName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3);
			}
			else {
				bindSchedulerClassName = true;

				sb.append(
					_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSchedulerClassName) {
					queryPos.add(schedulerClassName);
				}

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

	private static final String
		_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_2 =
			"scheduledThread.schedulerClassName = ?";

	private static final String
		_FINDER_COLUMN_SCHEDULERCLASSNAME_SCHEDULERCLASSNAME_3 =
			"(scheduledThread.schedulerClassName IS NULL OR scheduledThread.schedulerClassName = '')";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
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

		List<ScheduledThread> list = null;

		if (useFinderCache) {
			list = (List<ScheduledThread>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduledThread scheduledThread : list) {
					if (groupId != scheduledThread.getGroupId()) {
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

			sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ScheduledThread>)QueryUtil.list(
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
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByGroup_First(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByGroup_First(
			groupId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByGroup_First(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator) {

		List<ScheduledThread> list = findByGroup(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByGroup_Last(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByGroup_Last(
			groupId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByGroup_Last(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<ScheduledThread> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread[] findByGroup_PrevAndNext(
			long scheduledThreadId, long groupId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = findByPrimaryKey(scheduledThreadId);

		Session session = null;

		try {
			session = openSession();

			ScheduledThread[] array = new ScheduledThreadImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, scheduledThread, groupId, orderByComparator, true);

			array[1] = scheduledThread;

			array[2] = getByGroup_PrevAndNext(
				session, scheduledThread, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScheduledThread getByGroup_PrevAndNext(
		Session session, ScheduledThread scheduledThread, long groupId,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

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
			sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
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
						scheduledThread)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduledThread> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scheduled threads where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (ScheduledThread scheduledThread :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching scheduled threads
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEDTHREAD_WHERE);

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
		"scheduledThread.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByCompany(
		long companyId, int start, int end) {

		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
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

		List<ScheduledThread> list = null;

		if (useFinderCache) {
			list = (List<ScheduledThread>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduledThread scheduledThread : list) {
					if (companyId != scheduledThread.getCompanyId()) {
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

			sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<ScheduledThread>)QueryUtil.list(
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
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByCompany_First(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByCompany_First(
			companyId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByCompany_First(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator) {

		List<ScheduledThread> list = findByCompany(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByCompany_Last(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByCompany_Last(
			companyId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByCompany_Last(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<ScheduledThread> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread[] findByCompany_PrevAndNext(
			long scheduledThreadId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = findByPrimaryKey(scheduledThreadId);

		Session session = null;

		try {
			session = openSession();

			ScheduledThread[] array = new ScheduledThreadImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, scheduledThread, companyId, orderByComparator, true);

			array[1] = scheduledThread;

			array[2] = getByCompany_PrevAndNext(
				session, scheduledThread, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScheduledThread getByCompany_PrevAndNext(
		Session session, ScheduledThread scheduledThread, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

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
			sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
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
						scheduledThread)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduledThread> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scheduled threads where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (ScheduledThread scheduledThread :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEDTHREAD_WHERE);

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
		"scheduledThread.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId) {

		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Override
	public List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
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

		List<ScheduledThread> list = null;

		if (useFinderCache) {
			list = (List<ScheduledThread>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduledThread scheduledThread : list) {
					if ((groupId != scheduledThread.getGroupId()) ||
						(companyId != scheduledThread.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<ScheduledThread>)QueryUtil.list(
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
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator) {

		List<ScheduledThread> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (scheduledThread != null) {
			return scheduledThread;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchScheduledThreadException(sb.toString());
	}

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Override
	public ScheduledThread fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<ScheduledThread> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread[] findByGroupAndCompany_PrevAndNext(
			long scheduledThreadId, long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = findByPrimaryKey(scheduledThreadId);

		Session session = null;

		try {
			session = openSession();

			ScheduledThread[] array = new ScheduledThreadImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, scheduledThread, groupId, companyId, orderByComparator,
				true);

			array[1] = scheduledThread;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, scheduledThread, groupId, companyId, orderByComparator,
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

	protected ScheduledThread getByGroupAndCompany_PrevAndNext(
		Session session, ScheduledThread scheduledThread, long groupId,
		long companyId, OrderByComparator<ScheduledThread> orderByComparator,
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

		sb.append(_SQL_SELECT_SCHEDULEDTHREAD_WHERE);

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
			sb.append(ScheduledThreadModelImpl.ORDER_BY_JPQL);
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
						scheduledThread)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduledThread> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scheduled threads where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (ScheduledThread scheduledThread :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SCHEDULEDTHREAD_WHERE);

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
		"scheduledThread.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"scheduledThread.companyId = ?";

	public ScheduledThreadPersistenceImpl() {
		setModelClass(ScheduledThread.class);

		setModelImplClass(ScheduledThreadImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the scheduled thread in the entity cache if it is enabled.
	 *
	 * @param scheduledThread the scheduled thread
	 */
	@Override
	public void cacheResult(ScheduledThread scheduledThread) {
		entityCache.putResult(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread);

		finderCache.putResult(
			_finderPathFetchBySchedulerClassName,
			new Object[] {scheduledThread.getSchedulerClassName()},
			scheduledThread);

		scheduledThread.resetOriginalValues();
	}

	/**
	 * Caches the scheduled threads in the entity cache if it is enabled.
	 *
	 * @param scheduledThreads the scheduled threads
	 */
	@Override
	public void cacheResult(List<ScheduledThread> scheduledThreads) {
		for (ScheduledThread scheduledThread : scheduledThreads) {
			if (entityCache.getResult(
					ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
					ScheduledThreadImpl.class,
					scheduledThread.getPrimaryKey()) == null) {

				cacheResult(scheduledThread);
			}
			else {
				scheduledThread.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all scheduled threads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ScheduledThreadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the scheduled thread.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScheduledThread scheduledThread) {
		entityCache.removeResult(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ScheduledThreadModelImpl)scheduledThread, true);
	}

	@Override
	public void clearCache(List<ScheduledThread> scheduledThreads) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScheduledThread scheduledThread : scheduledThreads) {
			entityCache.removeResult(
				ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, scheduledThread.getPrimaryKey());

			clearUniqueFindersCache(
				(ScheduledThreadModelImpl)scheduledThread, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
				ScheduledThreadImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ScheduledThreadModelImpl scheduledThreadModelImpl) {

		Object[] args = new Object[] {
			scheduledThreadModelImpl.getSchedulerClassName()
		};

		finderCache.putResult(
			_finderPathCountBySchedulerClassName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySchedulerClassName, args,
			scheduledThreadModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ScheduledThreadModelImpl scheduledThreadModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				scheduledThreadModelImpl.getSchedulerClassName()
			};

			finderCache.removeResult(
				_finderPathCountBySchedulerClassName, args);
			finderCache.removeResult(
				_finderPathFetchBySchedulerClassName, args);
		}

		if ((scheduledThreadModelImpl.getColumnBitmask() &
			 _finderPathFetchBySchedulerClassName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				scheduledThreadModelImpl.getOriginalSchedulerClassName()
			};

			finderCache.removeResult(
				_finderPathCountBySchedulerClassName, args);
			finderCache.removeResult(
				_finderPathFetchBySchedulerClassName, args);
		}
	}

	/**
	 * Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	 *
	 * @param scheduledThreadId the primary key for the new scheduled thread
	 * @return the new scheduled thread
	 */
	@Override
	public ScheduledThread create(long scheduledThreadId) {
		ScheduledThread scheduledThread = new ScheduledThreadImpl();

		scheduledThread.setNew(true);
		scheduledThread.setPrimaryKey(scheduledThreadId);

		scheduledThread.setCompanyId(CompanyThreadLocal.getCompanyId());

		return scheduledThread;
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread remove(long scheduledThreadId)
		throws NoSuchScheduledThreadException {

		return remove((Serializable)scheduledThreadId);
	}

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread remove(Serializable primaryKey)
		throws NoSuchScheduledThreadException {

		Session session = null;

		try {
			session = openSession();

			ScheduledThread scheduledThread = (ScheduledThread)session.get(
				ScheduledThreadImpl.class, primaryKey);

			if (scheduledThread == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduledThreadException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(scheduledThread);
		}
		catch (NoSuchScheduledThreadException noSuchEntityException) {
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
	protected ScheduledThread removeImpl(ScheduledThread scheduledThread) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scheduledThread)) {
				scheduledThread = (ScheduledThread)session.get(
					ScheduledThreadImpl.class,
					scheduledThread.getPrimaryKeyObj());
			}

			if (scheduledThread != null) {
				session.delete(scheduledThread);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (scheduledThread != null) {
			clearCache(scheduledThread);
		}

		return scheduledThread;
	}

	@Override
	public ScheduledThread updateImpl(ScheduledThread scheduledThread) {
		boolean isNew = scheduledThread.isNew();

		if (!(scheduledThread instanceof ScheduledThreadModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(scheduledThread.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					scheduledThread);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in scheduledThread proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ScheduledThread implementation " +
					scheduledThread.getClass());
		}

		ScheduledThreadModelImpl scheduledThreadModelImpl =
			(ScheduledThreadModelImpl)scheduledThread;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (scheduledThread.getCreateDate() == null)) {
			if (serviceContext == null) {
				scheduledThread.setCreateDate(now);
			}
			else {
				scheduledThread.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!scheduledThreadModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				scheduledThread.setModifiedDate(now);
			}
			else {
				scheduledThread.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (scheduledThread.isNew()) {
				session.save(scheduledThread);

				scheduledThread.setNew(false);
			}
			else {
				scheduledThread = (ScheduledThread)session.merge(
					scheduledThread);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ScheduledThreadModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				scheduledThreadModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {scheduledThreadModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				scheduledThreadModelImpl.getGroupId(),
				scheduledThreadModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((scheduledThreadModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					scheduledThreadModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {scheduledThreadModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((scheduledThreadModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					scheduledThreadModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {scheduledThreadModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((scheduledThreadModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					scheduledThreadModelImpl.getOriginalGroupId(),
					scheduledThreadModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					scheduledThreadModelImpl.getGroupId(),
					scheduledThreadModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadImpl.class, scheduledThread.getPrimaryKey(),
			scheduledThread, false);

		clearUniqueFindersCache(scheduledThreadModelImpl, false);
		cacheUniqueFindersCache(scheduledThreadModelImpl);

		scheduledThread.resetOriginalValues();

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScheduledThreadException {

		ScheduledThread scheduledThread = fetchByPrimaryKey(primaryKey);

		if (scheduledThread == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScheduledThreadException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return scheduledThread;
	}

	/**
	 * Returns the scheduled thread with the primary key or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws NoSuchScheduledThreadException {

		return findByPrimaryKey((Serializable)scheduledThreadId);
	}

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 */
	@Override
	public ScheduledThread fetchByPrimaryKey(long scheduledThreadId) {
		return fetchByPrimaryKey((Serializable)scheduledThreadId);
	}

	/**
	 * Returns all the scheduled threads.
	 *
	 * @return the scheduled threads
	 */
	@Override
	public List<ScheduledThread> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of scheduled threads
	 */
	@Override
	public List<ScheduledThread> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scheduled threads
	 */
	@Override
	public List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of scheduled threads
	 */
	@Override
	public List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
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

		List<ScheduledThread> list = null;

		if (useFinderCache) {
			list = (List<ScheduledThread>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SCHEDULEDTHREAD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULEDTHREAD;

				sql = sql.concat(ScheduledThreadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ScheduledThread>)QueryUtil.list(
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
	 * Removes all the scheduled threads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ScheduledThread scheduledThread : findAll()) {
			remove(scheduledThread);
		}
	}

	/**
	 * Returns the number of scheduled threads.
	 *
	 * @return the number of scheduled threads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SCHEDULEDTHREAD);

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
		return "scheduledThreadId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SCHEDULEDTHREAD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ScheduledThreadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the scheduled thread persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBySchedulerClassName = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySchedulerClassName", new String[] {String.class.getName()},
			ScheduledThreadModelImpl.SCHEDULERCLASSNAME_COLUMN_BITMASK);

		_finderPathCountBySchedulerClassName = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySchedulerClassName", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			ScheduledThreadModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			ScheduledThreadModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED,
			ScheduledThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			ScheduledThreadModelImpl.GROUPID_COLUMN_BITMASK |
			ScheduledThreadModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			ScheduledThreadModelImpl.ENTITY_CACHE_ENABLED,
			ScheduledThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ScheduledThreadImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SCHEDULEDTHREAD =
		"SELECT scheduledThread FROM ScheduledThread scheduledThread";

	private static final String _SQL_SELECT_SCHEDULEDTHREAD_WHERE =
		"SELECT scheduledThread FROM ScheduledThread scheduledThread WHERE ";

	private static final String _SQL_COUNT_SCHEDULEDTHREAD =
		"SELECT COUNT(scheduledThread) FROM ScheduledThread scheduledThread";

	private static final String _SQL_COUNT_SCHEDULEDTHREAD_WHERE =
		"SELECT COUNT(scheduledThread) FROM ScheduledThread scheduledThread WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "scheduledThread.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ScheduledThread exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ScheduledThread exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ScheduledThreadPersistenceImpl.class);

}