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

import de.uhh.l2g.plugins.exception.NoSuchHostException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.impl.HostModelImpl;
import de.uhh.l2g.plugins.service.persistence.HostPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class HostPersistenceImpl
	extends BasePersistenceImpl<Host> implements HostPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HostUtil</code> to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HostImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	@Override
	public List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroup;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Host host : list) {
				if ((groupId != host.getGroupId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroup_First(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByGroup_First(groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroup_First(
		long groupId, OrderByComparator<Host> orderByComparator) {

		List<Host> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroup_Last(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByGroup_Last(groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroup_Last(
		long groupId, OrderByComparator<Host> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByGroup_PrevAndNext(
			long hostId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, host, groupId, orderByComparator, true);

			array[1] = host;

			array[2] = getByGroup_PrevAndNext(
				session, host, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByGroup_PrevAndNext(
		Session session, Host host, long groupId,
		OrderByComparator<Host> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(host)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Host host :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOST_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 =
		"host.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	@Override
	public List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompany;
			finderArgs = new Object[] {companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompany;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Host host : list) {
				if ((companyId != host.getCompanyId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompany_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompany_First(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompany_First(
		long companyId, OrderByComparator<Host> orderByComparator) {

		List<Host> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompany_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompany_Last(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompany_Last(
		long companyId, OrderByComparator<Host> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByCompany_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, host, companyId, orderByComparator, true);

			array[1] = host;

			array[2] = getByCompany_PrevAndNext(
				session, host, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByCompany_PrevAndNext(
		Session session, Host host, long companyId,
		OrderByComparator<Host> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(host)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Host host :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOST_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 =
		"host.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	@Override
	public List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {groupId, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Host host : list) {
				if ((groupId != host.getGroupId()) ||
					(companyId != host.getCompanyId())) {

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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
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
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator) {

		List<Host> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByGroupAndCompany_PrevAndNext(
			long hostId, long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, host, groupId, companyId, orderByComparator, true);

			array[1] = host;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, host, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByGroupAndCompany_PrevAndNext(
		Session session, Host host, long groupId, long companyId,
		OrderByComparator<Host> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(host)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Host host :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 =
		"host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"host.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyIdAndGroupId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyIdAndGroupId;
	private FinderPath _finderPathCountByCompanyIdAndGroupId;

	/**
	 * Returns all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(long companyId, long groupId) {
		return findByCompanyIdAndGroupId(
			companyId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end) {

		return findByCompanyIdAndGroupId(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyIdAndGroupId(long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	@Override
	public List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return findByCompanyIdAndGroupId(
			companyId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompanyIdAndGroupId;
			finderArgs = new Object[] {companyId, groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompanyIdAndGroupId;
			finderArgs = new Object[] {
				companyId, groupId, start, end, orderByComparator
			};
		}

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Host host : list) {
				if ((companyId != host.getCompanyId()) ||
					(groupId != host.getGroupId())) {

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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyIdAndGroupId_First(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompanyIdAndGroupId_First(
			companyId, groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyIdAndGroupId_First(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {

		List<Host> list = findByCompanyIdAndGroupId(
			companyId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyIdAndGroupId_Last(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompanyIdAndGroupId_Last(
			companyId, groupId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyIdAndGroupId_Last(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator) {

		int count = countByCompanyIdAndGroupId(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByCompanyIdAndGroupId(
			companyId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByCompanyIdAndGroupId_PrevAndNext(
			long hostId, long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByCompanyIdAndGroupId_PrevAndNext(
				session, host, companyId, groupId, orderByComparator, true);

			array[1] = host;

			array[2] = getByCompanyIdAndGroupId_PrevAndNext(
				session, host, companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByCompanyIdAndGroupId_PrevAndNext(
		Session session, Host host, long companyId, long groupId,
		OrderByComparator<Host> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(host)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCompanyIdAndGroupId(long companyId, long groupId) {
		for (Host host :
				findByCompanyIdAndGroupId(
					companyId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByCompanyIdAndGroupId(long companyId, long groupId) {
		FinderPath finderPath = _finderPathCountByCompanyIdAndGroupId;

		Object[] finderArgs = new Object[] {companyId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 =
		"host.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 =
		"host.groupId = ?";

	private FinderPath _finderPathFetchByG_H;
	private FinderPath _finderPathCountByG_H;

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByG_H(long groupId, long hostId)
		throws NoSuchHostException {

		Host host = fetchByG_H(groupId, hostId);

		if (host == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", hostId=");
			msg.append(hostId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchHostException(msg.toString());
		}

		return host;
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByG_H(long,long)}
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Deprecated
	@Override
	public Host fetchByG_H(long groupId, long hostId, boolean useFinderCache) {
		return fetchByG_H(groupId, hostId);
	}

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByG_H(long groupId, long hostId) {
		Object[] finderArgs = new Object[] {groupId, hostId};

		Object result = finderCache.getResult(
			_finderPathFetchByG_H, finderArgs, this);

		if (result instanceof Host) {
			Host host = (Host)result;

			if ((groupId != host.getGroupId()) ||
				(hostId != host.getHostId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_G_H_GROUPID_2);

			query.append(_FINDER_COLUMN_G_H_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(hostId);

				List<Host> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByG_H, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"HostPersistenceImpl.fetchByG_H(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByG_H, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Host)result;
		}
	}

	/**
	 * Removes the host where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the host that was removed
	 */
	@Override
	public Host removeByG_H(long groupId, long hostId)
		throws NoSuchHostException {

		Host host = findByG_H(groupId, hostId);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByG_H(long groupId, long hostId) {
		FinderPath finderPath = _finderPathCountByG_H;

		Object[] finderArgs = new Object[] {groupId, hostId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_G_H_GROUPID_2);

			query.append(_FINDER_COLUMN_G_H_HOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(hostId);

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

	private static final String _FINDER_COLUMN_G_H_GROUPID_2 =
		"host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_H_HOSTID_2 = "host.hostId = ?";

	private FinderPath _finderPathFetchByDefaultHost;
	private FinderPath _finderPathCountByDefaultHost;

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException {

		Host host = fetchByDefaultHost(companyId, groupId);

		if (host == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchHostException(msg.toString());
		}

		return host;
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByDefaultHost(long,long)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Deprecated
	@Override
	public Host fetchByDefaultHost(
		long companyId, long groupId, boolean useFinderCache) {

		return fetchByDefaultHost(companyId, groupId);
	}

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByDefaultHost(long companyId, long groupId) {
		Object[] finderArgs = new Object[] {companyId, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByDefaultHost, finderArgs, this);

		if (result instanceof Host) {
			Host host = (Host)result;

			if ((companyId != host.getCompanyId()) ||
				(groupId != host.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTHOST_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTHOST_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				List<Host> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByDefaultHost, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"HostPersistenceImpl.fetchByDefaultHost(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByDefaultHost, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Host)result;
		}
	}

	/**
	 * Removes the host where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the host that was removed
	 */
	@Override
	public Host removeByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException {

		Host host = findByDefaultHost(companyId, groupId);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByDefaultHost(long companyId, long groupId) {
		FinderPath finderPath = _finderPathCountByDefaultHost;

		Object[] finderArgs = new Object[] {companyId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTHOST_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTHOST_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_DEFAULTHOST_COMPANYID_2 =
		"host.companyId = ? AND ";

	private static final String _FINDER_COLUMN_DEFAULTHOST_GROUPID_2 =
		"host.groupId = ? AND host.defaultHost > 0";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompanyId(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hosts
	 */
	@Deprecated
	@Override
	public List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache) {

		return findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hosts
	 */
	@Override
	public List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompanyId;
			finderArgs = new Object[] {companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Host host : list) {
				if ((companyId != host.getCompanyId())) {
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

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyId_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompanyId_First(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyId_First(
		long companyId, OrderByComparator<Host> orderByComparator) {

		List<Host> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByCompanyId_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = fetchByCompanyId_Last(companyId, orderByComparator);

		if (host != null) {
			return host;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchHostException(msg.toString());
	}

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByCompanyId_Last(
		long companyId, OrderByComparator<Host> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Host> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host[] findByCompanyId_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException {

		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, host, companyId, orderByComparator, true);

			array[1] = host;

			array[2] = getByCompanyId_PrevAndNext(
				session, host, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByCompanyId_PrevAndNext(
		Session session, Host host, long companyId,
		OrderByComparator<Host> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(host)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (Host host :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(host);
		}
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"host.companyId = ?";

	public HostPersistenceImpl() {
		setModelClass(Host.class);

		setModelImplClass(HostImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(HostModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the host in the entity cache if it is enabled.
	 *
	 * @param host the host
	 */
	@Override
	public void cacheResult(Host host) {
		entityCache.putResult(
			HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class,
			host.getPrimaryKey(), host);

		finderCache.putResult(
			_finderPathFetchByG_H,
			new Object[] {host.getGroupId(), host.getHostId()}, host);

		finderCache.putResult(
			_finderPathFetchByDefaultHost,
			new Object[] {host.getCompanyId(), host.getGroupId()}, host);

		host.resetOriginalValues();
	}

	/**
	 * Caches the hosts in the entity cache if it is enabled.
	 *
	 * @param hosts the hosts
	 */
	@Override
	public void cacheResult(List<Host> hosts) {
		for (Host host : hosts) {
			if (entityCache.getResult(
					HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class,
					host.getPrimaryKey()) == null) {

				cacheResult(host);
			}
			else {
				host.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hosts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HostImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the host.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Host host) {
		entityCache.removeResult(
			HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class,
			host.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HostModelImpl)host, true);
	}

	@Override
	public void clearCache(List<Host> hosts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Host host : hosts) {
			entityCache.removeResult(
				HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class,
				host.getPrimaryKey());

			clearUniqueFindersCache((HostModelImpl)host, true);
		}
	}

	protected void cacheUniqueFindersCache(HostModelImpl hostModelImpl) {
		Object[] args = new Object[] {
			hostModelImpl.getGroupId(), hostModelImpl.getHostId()
		};

		finderCache.putResult(
			_finderPathCountByG_H, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_H, args, hostModelImpl, false);

		args = new Object[] {
			hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByDefaultHost, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDefaultHost, args, hostModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		HostModelImpl hostModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				hostModelImpl.getGroupId(), hostModelImpl.getHostId()
			};

			finderCache.removeResult(_finderPathCountByG_H, args);
			finderCache.removeResult(_finderPathFetchByG_H, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_H.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				hostModelImpl.getOriginalGroupId(),
				hostModelImpl.getOriginalHostId()
			};

			finderCache.removeResult(_finderPathCountByG_H, args);
			finderCache.removeResult(_finderPathFetchByG_H, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByDefaultHost, args);
			finderCache.removeResult(_finderPathFetchByDefaultHost, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchByDefaultHost.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				hostModelImpl.getOriginalCompanyId(),
				hostModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByDefaultHost, args);
			finderCache.removeResult(_finderPathFetchByDefaultHost, args);
		}
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	@Override
	public Host create(long hostId) {
		Host host = new HostImpl();

		host.setNew(true);
		host.setPrimaryKey(hostId);

		host.setCompanyId(CompanyThreadLocal.getCompanyId());

		return host;
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host remove(long hostId) throws NoSuchHostException {
		return remove((Serializable)hostId);
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host remove(Serializable primaryKey) throws NoSuchHostException {
		Session session = null;

		try {
			session = openSession();

			Host host = (Host)session.get(HostImpl.class, primaryKey);

			if (host == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHostException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(host);
		}
		catch (NoSuchHostException nsee) {
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
	protected Host removeImpl(Host host) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(host)) {
				host = (Host)session.get(
					HostImpl.class, host.getPrimaryKeyObj());
			}

			if (host != null) {
				session.delete(host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (host != null) {
			clearCache(host);
		}

		return host;
	}

	@Override
	public Host updateImpl(Host host) {
		boolean isNew = host.isNew();

		if (!(host instanceof HostModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(host.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(host);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in host proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Host implementation " +
					host.getClass());
		}

		HostModelImpl hostModelImpl = (HostModelImpl)host;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (host.getCreateDate() == null)) {
			if (serviceContext == null) {
				host.setCreateDate(now);
			}
			else {
				host.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!hostModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				host.setModifiedDate(now);
			}
			else {
				host.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (host.isNew()) {
				session.save(host);

				host.setNew(false);
			}
			else {
				host = (Host)session.merge(host);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HostModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {hostModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {hostModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				hostModelImpl.getGroupId(), hostModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			args = new Object[] {
				hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
			};

			finderCache.removeResult(
				_finderPathCountByCompanyIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyIdAndGroupId, args);

			args = new Object[] {hostModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((hostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					hostModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {hostModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((hostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					hostModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {hostModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((hostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					hostModelImpl.getOriginalGroupId(),
					hostModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					hostModelImpl.getGroupId(), hostModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}

			if ((hostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyIdAndGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					hostModelImpl.getOriginalCompanyId(),
					hostModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyIdAndGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyIdAndGroupId,
					args);

				args = new Object[] {
					hostModelImpl.getCompanyId(), hostModelImpl.getGroupId()
				};

				finderCache.removeResult(
					_finderPathCountByCompanyIdAndGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyIdAndGroupId,
					args);
			}

			if ((hostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					hostModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);

				args = new Object[] {hostModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);
			}
		}

		entityCache.putResult(
			HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class,
			host.getPrimaryKey(), host, false);

		clearUniqueFindersCache(hostModelImpl, false);
		cacheUniqueFindersCache(hostModelImpl);

		host.resetOriginalValues();

		return host;
	}

	/**
	 * Returns the host with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHostException {

		Host host = fetchByPrimaryKey(primaryKey);

		if (host == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHostException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return host;
	}

	/**
	 * Returns the host with the primary key or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	@Override
	public Host findByPrimaryKey(long hostId) throws NoSuchHostException {
		return findByPrimaryKey((Serializable)hostId);
	}

	/**
	 * Returns the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 */
	@Override
	public Host fetchByPrimaryKey(long hostId) {
		return fetchByPrimaryKey((Serializable)hostId);
	}

	/**
	 * Returns all the hosts.
	 *
	 * @return the hosts
	 */
	@Override
	public List<Host> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @return the range of hosts
	 */
	@Override
	public List<Host> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hosts
	 */
	@Deprecated
	@Override
	public List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hosts
	 */
	@Override
	public List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator) {

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

		List<Host> list = (List<Host>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HOST);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOST;

				if (pagination) {
					sql = sql.concat(HostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Host>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(
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
	 * Removes all the hosts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Host host : findAll()) {
			remove(host);
		}
	}

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOST);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "hostId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HOST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HostModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the host persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCompanyIdAndGroupId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyIdAndGroupId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);

		_finderPathCountByCompanyIdAndGroupId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByG_H = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_H",
			new String[] {Long.class.getName(), Long.class.getName()},
			HostModelImpl.GROUPID_COLUMN_BITMASK |
			HostModelImpl.HOSTID_COLUMN_BITMASK);

		_finderPathCountByG_H = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_H",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByDefaultHost = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDefaultHost",
			new String[] {Long.class.getName(), Long.class.getName()},
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByDefaultHost = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDefaultHost",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()},
			HostModelImpl.COMPANYID_COLUMN_BITMASK |
			HostModelImpl.SERVERROOT_COLUMN_BITMASK);

		_finderPathCountByCompanyId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(HostImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HOST = "SELECT host FROM Host host";

	private static final String _SQL_SELECT_HOST_WHERE =
		"SELECT host FROM Host host WHERE ";

	private static final String _SQL_COUNT_HOST =
		"SELECT COUNT(host) FROM Host host";

	private static final String _SQL_COUNT_HOST_WHERE =
		"SELECT COUNT(host) FROM Host host WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "host.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Host exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Host exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HostPersistenceImpl.class);

}