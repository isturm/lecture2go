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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.impl.Institution_HostImpl;
import de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl;
import de.uhh.l2g.plugins.service.persistence.Institution_HostPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the institution_ host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class Institution_HostPersistenceImpl
	extends BasePersistenceImpl<Institution_Host>
	implements Institution_HostPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Institution_HostUtil</code> to access the institution_ host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Institution_HostImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByinstitutionId;
	private FinderPath _finderPathWithoutPaginationFindByinstitutionId;
	private FinderPath _finderPathCountByinstitutionId;

	/**
	 * Returns all the institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(long institutionId) {
		return findByinstitutionId(
			institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end) {

		return findByinstitutionId(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByinstitutionId(
			institutionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinstitutionId;
				finderArgs = new Object[] {institutionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinstitutionId;
			finderArgs = new Object[] {
				institutionId, start, end, orderByComparator
			};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if (institutionId != institution_Host.getInstitutionId()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(institutionId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByinstitutionId_First(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByinstitutionId_First(
			institutionId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("institutionId=");
		sb.append(institutionId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByinstitutionId_First(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByinstitutionId(
			institutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByinstitutionId_Last(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByinstitutionId_Last(
			institutionId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("institutionId=");
		sb.append(institutionId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByinstitutionId_Last(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByinstitutionId(institutionId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByinstitutionId(
			institutionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByinstitutionId_PrevAndNext(
			long institutionHostId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByinstitutionId_PrevAndNext(
				session, institution_Host, institutionId, orderByComparator,
				true);

			array[1] = institution_Host;

			array[2] = getByinstitutionId_PrevAndNext(
				session, institution_Host, institutionId, orderByComparator,
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

	protected Institution_Host getByinstitutionId_PrevAndNext(
		Session session, Institution_Host institution_Host, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator,
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

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(institutionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	@Override
	public void removeByinstitutionId(long institutionId) {
		for (Institution_Host institution_Host :
				findByinstitutionId(
					institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByinstitutionId(long institutionId) {
		FinderPath finderPath = _finderPathCountByinstitutionId;

		Object[] finderArgs = new Object[] {institutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2 =
		"institution_Host.institutionId = ?";

	private FinderPath _finderPathWithPaginationFindByhostId;
	private FinderPath _finderPathWithoutPaginationFindByhostId;
	private FinderPath _finderPathCountByhostId;

	/**
	 * Returns all the institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByhostId(long hostId) {
		return findByhostId(hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByhostId(
		long hostId, int start, int end) {

		return findByhostId(hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByhostId(hostId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByhostId;
				finderArgs = new Object[] {hostId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByhostId;
			finderArgs = new Object[] {hostId, start, end, orderByComparator};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if (hostId != institution_Host.getHostId()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hostId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByhostId_First(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByhostId_First(
			hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByhostId_First(
		long hostId, OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByhostId(
			hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByhostId_Last(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByhostId_Last(
			hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByhostId_Last(
		long hostId, OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByhostId(hostId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByhostId(
			hostId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByhostId_PrevAndNext(
			long institutionHostId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByhostId_PrevAndNext(
				session, institution_Host, hostId, orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByhostId_PrevAndNext(
				session, institution_Host, hostId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByhostId_PrevAndNext(
		Session session, Institution_Host institution_Host, long hostId,
		OrderByComparator<Institution_Host> orderByComparator,
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

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(hostId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	@Override
	public void removeByhostId(long hostId) {
		for (Institution_Host institution_Host :
				findByhostId(
					hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByhostId(long hostId) {
		FinderPath finderPath = _finderPathCountByhostId;

		Object[] finderArgs = new Object[] {hostId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_HOSTID_HOSTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hostId);

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

	private static final String _FINDER_COLUMN_HOSTID_HOSTID_2 =
		"institution_Host.hostId = ?";

	private FinderPath _finderPathWithPaginationFindByG_H;
	private FinderPath _finderPathWithoutPaginationFindByG_H;
	private FinderPath _finderPathCountByG_H;

	/**
	 * Returns all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByG_H(long groupId, long hostId) {
		return findByG_H(
			groupId, hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end) {

		return findByG_H(groupId, hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByG_H(groupId, hostId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_H;
				finderArgs = new Object[] {groupId, hostId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_H;
			finderArgs = new Object[] {
				groupId, hostId, start, end, orderByComparator
			};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if ((groupId != institution_Host.getGroupId()) ||
						(hostId != institution_Host.getHostId())) {

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

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_G_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_H_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(hostId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByG_H_First(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByG_H_First(
			groupId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByG_H_First(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByG_H(
			groupId, hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByG_H_Last(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByG_H_Last(
			groupId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByG_H_Last(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByG_H(groupId, hostId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByG_H(
			groupId, hostId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByG_H_PrevAndNext(
			long institutionHostId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByG_H_PrevAndNext(
				session, institution_Host, groupId, hostId, orderByComparator,
				true);

			array[1] = institution_Host;

			array[2] = getByG_H_PrevAndNext(
				session, institution_Host, groupId, hostId, orderByComparator,
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

	protected Institution_Host getByG_H_PrevAndNext(
		Session session, Institution_Host institution_Host, long groupId,
		long hostId, OrderByComparator<Institution_Host> orderByComparator,
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

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_G_H_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_H_HOSTID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(hostId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	@Override
	public void removeByG_H(long groupId, long hostId) {
		for (Institution_Host institution_Host :
				findByG_H(
					groupId, hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByG_H(long groupId, long hostId) {
		FinderPath finderPath = _finderPathCountByG_H;

		Object[] finderArgs = new Object[] {groupId, hostId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_G_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_H_HOSTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(hostId);

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

	private static final String _FINDER_COLUMN_G_H_GROUPID_2 =
		"institution_Host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_H_HOSTID_2 =
		"institution_Host.hostId = ?";

	private FinderPath _finderPathFetchByG_I;
	private FinderPath _finderPathCountByG_I;

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByG_I(long groupId, long institutionId)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByG_I(groupId, institutionId);

		if (institution_Host == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", institutionId=");
			sb.append(institutionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInstitution_HostException(sb.toString());
		}

		return institution_Host;
	}

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByG_I(long groupId, long institutionId) {
		return fetchByG_I(groupId, institutionId, true);
	}

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByG_I(
		long groupId, long institutionId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, institutionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_I, finderArgs, this);
		}

		if (result instanceof Institution_Host) {
			Institution_Host institution_Host = (Institution_Host)result;

			if ((groupId != institution_Host.getGroupId()) ||
				(institutionId != institution_Host.getInstitutionId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_I_INSTITUTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(institutionId);

				List<Institution_Host> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_I, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, institutionId
								};
							}

							_log.warn(
								"Institution_HostPersistenceImpl.fetchByG_I(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Institution_Host institution_Host = list.get(0);

					result = institution_Host;

					cacheResult(institution_Host);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_I, finderArgs);
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
			return (Institution_Host)result;
		}
	}

	/**
	 * Removes the institution_ host where groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the institution_ host that was removed
	 */
	@Override
	public Institution_Host removeByG_I(long groupId, long institutionId)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByG_I(groupId, institutionId);

		return remove(institution_Host);
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and institutionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByG_I(long groupId, long institutionId) {
		FinderPath finderPath = _finderPathCountByG_I;

		Object[] finderArgs = new Object[] {groupId, institutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_I_INSTITUTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_G_I_GROUPID_2 =
		"institution_Host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_I_INSTITUTIONID_2 =
		"institution_Host.institutionId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if (groupId != institution_Host.getGroupId()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByGroupId_First(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByGroupId_First(
			groupId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByGroupId_First(
		long groupId, OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByGroupId_Last(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByGroupId_Last(
		long groupId, OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByGroupId_PrevAndNext(
			long institutionHostId, long groupId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, institution_Host, groupId, orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByGroupId_PrevAndNext(
				session, institution_Host, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByGroupId_PrevAndNext(
		Session session, Institution_Host institution_Host, long groupId,
		OrderByComparator<Institution_Host> orderByComparator,
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

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
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
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Institution_Host institution_Host :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"institution_Host.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByC_G_H;
	private FinderPath _finderPathWithoutPaginationFindByC_G_H;
	private FinderPath _finderPathCountByC_G_H;

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId) {

		return findByC_G_H(
			companyId, groupId, hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end) {

		return findByC_G_H(companyId, groupId, hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByC_G_H(
			companyId, groupId, hostId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_G_H;
				finderArgs = new Object[] {companyId, groupId, hostId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_G_H;
			finderArgs = new Object[] {
				companyId, groupId, hostId, start, end, orderByComparator
			};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if ((companyId != institution_Host.getCompanyId()) ||
						(groupId != institution_Host.getGroupId()) ||
						(hostId != institution_Host.getHostId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_H_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(hostId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByC_G_H_First(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByC_G_H_First(
			companyId, groupId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByC_G_H_First(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByC_G_H(
			companyId, groupId, hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByC_G_H_Last(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByC_G_H_Last(
			companyId, groupId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByC_G_H_Last(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByC_G_H(companyId, groupId, hostId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByC_G_H(
			companyId, groupId, hostId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByC_G_H_PrevAndNext(
			long institutionHostId, long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByC_G_H_PrevAndNext(
				session, institution_Host, companyId, groupId, hostId,
				orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByC_G_H_PrevAndNext(
				session, institution_Host, companyId, groupId, hostId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByC_G_H_PrevAndNext(
		Session session, Institution_Host institution_Host, long companyId,
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

		sb.append(_FINDER_COLUMN_C_G_H_HOSTID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(groupId);

		queryPos.add(hostId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	@Override
	public void removeByC_G_H(long companyId, long groupId, long hostId) {
		for (Institution_Host institution_Host :
				findByC_G_H(
					companyId, groupId, hostId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByC_G_H(long companyId, long groupId, long hostId) {
		FinderPath finderPath = _finderPathCountByC_G_H;

		Object[] finderArgs = new Object[] {companyId, groupId, hostId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_H_HOSTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(hostId);

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

	private static final String _FINDER_COLUMN_C_G_H_COMPANYID_2 =
		"institution_Host.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_H_GROUPID_2 =
		"institution_Host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_H_HOSTID_2 =
		"institution_Host.hostId = ?";

	private FinderPath _finderPathWithPaginationFindByC_G_I;
	private FinderPath _finderPathWithoutPaginationFindByC_G_I;
	private FinderPath _finderPathCountByC_G_I;

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId) {

		return findByC_G_I(
			companyId, groupId, institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end) {

		return findByC_G_I(companyId, groupId, institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findByC_G_I(
			companyId, groupId, institutionId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_G_I;
				finderArgs = new Object[] {companyId, groupId, institutionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_G_I;
			finderArgs = new Object[] {
				companyId, groupId, institutionId, start, end, orderByComparator
			};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if ((companyId != institution_Host.getCompanyId()) ||
						(groupId != institution_Host.getGroupId()) ||
						(institutionId !=
							institution_Host.getInstitutionId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_C_G_I_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_I_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(institutionId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByC_G_I_First(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByC_G_I_First(
			companyId, groupId, institutionId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", institutionId=");
		sb.append(institutionId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByC_G_I_First(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findByC_G_I(
			companyId, groupId, institutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findByC_G_I_Last(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByC_G_I_Last(
			companyId, groupId, institutionId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", institutionId=");
		sb.append(institutionId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchByC_G_I_Last(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator) {

		int count = countByC_G_I(companyId, groupId, institutionId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findByC_G_I(
			companyId, groupId, institutionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findByC_G_I_PrevAndNext(
			long institutionHostId, long companyId, long groupId,
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getByC_G_I_PrevAndNext(
				session, institution_Host, companyId, groupId, institutionId,
				orderByComparator, true);

			array[1] = institution_Host;

			array[2] = getByC_G_I_PrevAndNext(
				session, institution_Host, companyId, groupId, institutionId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution_Host getByC_G_I_PrevAndNext(
		Session session, Institution_Host institution_Host, long companyId,
		long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_C_G_I_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_G_I_GROUPID_2);

		sb.append(_FINDER_COLUMN_C_G_I_INSTITUTIONID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(groupId);

		queryPos.add(institutionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 */
	@Override
	public void removeByC_G_I(
		long companyId, long groupId, long institutionId) {

		for (Institution_Host institution_Host :
				findByC_G_I(
					companyId, groupId, institutionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countByC_G_I(long companyId, long groupId, long institutionId) {
		FinderPath finderPath = _finderPathCountByC_G_I;

		Object[] finderArgs = new Object[] {companyId, groupId, institutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_C_G_I_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_I_INSTITUTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_C_G_I_COMPANYID_2 =
		"institution_Host.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_I_GROUPID_2 =
		"institution_Host.groupId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_I_INSTITUTIONID_2 =
		"institution_Host.institutionId = ?";

	private FinderPath _finderPathWithPaginationFindBycompanyAndHost;
	private FinderPath _finderPathWithoutPaginationFindBycompanyAndHost;
	private FinderPath _finderPathCountBycompanyAndHost;

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId) {

		return findBycompanyAndHost(
			companyId, hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end) {

		return findBycompanyAndHost(companyId, hostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findBycompanyAndHost(
			companyId, hostId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Override
	public List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycompanyAndHost;
				finderArgs = new Object[] {companyId, hostId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycompanyAndHost;
			finderArgs = new Object[] {
				companyId, hostId, start, end, orderByComparator
			};
		}

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution_Host institution_Host : list) {
					if ((companyId != institution_Host.getCompanyId()) ||
						(hostId != institution_Host.getHostId())) {

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

			sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYANDHOST_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYANDHOST_HOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(hostId);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findBycompanyAndHost_First(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchBycompanyAndHost_First(
			companyId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchBycompanyAndHost_First(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		List<Institution_Host> list = findBycompanyAndHost(
			companyId, hostId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host findBycompanyAndHost_Last(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchBycompanyAndHost_Last(
			companyId, hostId, orderByComparator);

		if (institution_Host != null) {
			return institution_Host;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", hostId=");
		sb.append(hostId);

		sb.append("}");

		throw new NoSuchInstitution_HostException(sb.toString());
	}

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Override
	public Institution_Host fetchBycompanyAndHost_Last(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator) {

		int count = countBycompanyAndHost(companyId, hostId);

		if (count == 0) {
			return null;
		}

		List<Institution_Host> list = findBycompanyAndHost(
			companyId, hostId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host[] findBycompanyAndHost_PrevAndNext(
			long institutionHostId, long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = findByPrimaryKey(institutionHostId);

		Session session = null;

		try {
			session = openSession();

			Institution_Host[] array = new Institution_HostImpl[3];

			array[0] = getBycompanyAndHost_PrevAndNext(
				session, institution_Host, companyId, hostId, orderByComparator,
				true);

			array[1] = institution_Host;

			array[2] = getBycompanyAndHost_PrevAndNext(
				session, institution_Host, companyId, hostId, orderByComparator,
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

	protected Institution_Host getBycompanyAndHost_PrevAndNext(
		Session session, Institution_Host institution_Host, long companyId,
		long hostId, OrderByComparator<Institution_Host> orderByComparator,
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

		sb.append(_SQL_SELECT_INSTITUTION_HOST_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYANDHOST_COMPANYID_2);

		sb.append(_FINDER_COLUMN_COMPANYANDHOST_HOSTID_2);

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
			sb.append(Institution_HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(hostId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						institution_Host)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution_Host> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 */
	@Override
	public void removeBycompanyAndHost(long companyId, long hostId) {
		for (Institution_Host institution_Host :
				findBycompanyAndHost(
					companyId, hostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	@Override
	public int countBycompanyAndHost(long companyId, long hostId) {
		FinderPath finderPath = _finderPathCountBycompanyAndHost;

		Object[] finderArgs = new Object[] {companyId, hostId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INSTITUTION_HOST_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYANDHOST_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYANDHOST_HOSTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(hostId);

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

	private static final String _FINDER_COLUMN_COMPANYANDHOST_COMPANYID_2 =
		"institution_Host.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYANDHOST_HOSTID_2 =
		"institution_Host.hostId = ?";

	public Institution_HostPersistenceImpl() {
		setModelClass(Institution_Host.class);

		setModelImplClass(Institution_HostImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(Institution_HostModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the institution_ host in the entity cache if it is enabled.
	 *
	 * @param institution_Host the institution_ host
	 */
	@Override
	public void cacheResult(Institution_Host institution_Host) {
		entityCache.putResult(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey(),
			institution_Host);

		finderCache.putResult(
			_finderPathFetchByG_I,
			new Object[] {
				institution_Host.getGroupId(),
				institution_Host.getInstitutionId()
			},
			institution_Host);

		institution_Host.resetOriginalValues();
	}

	/**
	 * Caches the institution_ hosts in the entity cache if it is enabled.
	 *
	 * @param institution_Hosts the institution_ hosts
	 */
	@Override
	public void cacheResult(List<Institution_Host> institution_Hosts) {
		for (Institution_Host institution_Host : institution_Hosts) {
			if (entityCache.getResult(
					Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
					Institution_HostImpl.class,
					institution_Host.getPrimaryKey()) == null) {

				cacheResult(institution_Host);
			}
			else {
				institution_Host.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all institution_ hosts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Institution_HostImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the institution_ host.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Institution_Host institution_Host) {
		entityCache.removeResult(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(Institution_HostModelImpl)institution_Host, true);
	}

	@Override
	public void clearCache(List<Institution_Host> institution_Hosts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Institution_Host institution_Host : institution_Hosts) {
			entityCache.removeResult(
				Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
				Institution_HostImpl.class, institution_Host.getPrimaryKey());

			clearUniqueFindersCache(
				(Institution_HostModelImpl)institution_Host, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
				Institution_HostImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		Institution_HostModelImpl institution_HostModelImpl) {

		Object[] args = new Object[] {
			institution_HostModelImpl.getGroupId(),
			institution_HostModelImpl.getInstitutionId()
		};

		finderCache.putResult(
			_finderPathCountByG_I, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_I, args, institution_HostModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		Institution_HostModelImpl institution_HostModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				institution_HostModelImpl.getGroupId(),
				institution_HostModelImpl.getInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByG_I, args);
			finderCache.removeResult(_finderPathFetchByG_I, args);
		}

		if ((institution_HostModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_I.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				institution_HostModelImpl.getOriginalGroupId(),
				institution_HostModelImpl.getOriginalInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByG_I, args);
			finderCache.removeResult(_finderPathFetchByG_I, args);
		}
	}

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	@Override
	public Institution_Host create(long institutionHostId) {
		Institution_Host institution_Host = new Institution_HostImpl();

		institution_Host.setNew(true);
		institution_Host.setPrimaryKey(institutionHostId);

		institution_Host.setCompanyId(CompanyThreadLocal.getCompanyId());

		return institution_Host;
	}

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host remove(long institutionHostId)
		throws NoSuchInstitution_HostException {

		return remove((Serializable)institutionHostId);
	}

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host remove(Serializable primaryKey)
		throws NoSuchInstitution_HostException {

		Session session = null;

		try {
			session = openSession();

			Institution_Host institution_Host = (Institution_Host)session.get(
				Institution_HostImpl.class, primaryKey);

			if (institution_Host == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstitution_HostException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(institution_Host);
		}
		catch (NoSuchInstitution_HostException noSuchEntityException) {
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
	protected Institution_Host removeImpl(Institution_Host institution_Host) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(institution_Host)) {
				institution_Host = (Institution_Host)session.get(
					Institution_HostImpl.class,
					institution_Host.getPrimaryKeyObj());
			}

			if (institution_Host != null) {
				session.delete(institution_Host);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (institution_Host != null) {
			clearCache(institution_Host);
		}

		return institution_Host;
	}

	@Override
	public Institution_Host updateImpl(Institution_Host institution_Host) {
		boolean isNew = institution_Host.isNew();

		if (!(institution_Host instanceof Institution_HostModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(institution_Host.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					institution_Host);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in institution_Host proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Institution_Host implementation " +
					institution_Host.getClass());
		}

		Institution_HostModelImpl institution_HostModelImpl =
			(Institution_HostModelImpl)institution_Host;

		Session session = null;

		try {
			session = openSession();

			if (institution_Host.isNew()) {
				session.save(institution_Host);

				institution_Host.setNew(false);
			}
			else {
				institution_Host = (Institution_Host)session.merge(
					institution_Host);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Institution_HostModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				institution_HostModelImpl.getInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByinstitutionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByinstitutionId, args);

			args = new Object[] {institution_HostModelImpl.getHostId()};

			finderCache.removeResult(_finderPathCountByhostId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByhostId, args);

			args = new Object[] {
				institution_HostModelImpl.getGroupId(),
				institution_HostModelImpl.getHostId()
			};

			finderCache.removeResult(_finderPathCountByG_H, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_H, args);

			args = new Object[] {institution_HostModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				institution_HostModelImpl.getCompanyId(),
				institution_HostModelImpl.getGroupId(),
				institution_HostModelImpl.getHostId()
			};

			finderCache.removeResult(_finderPathCountByC_G_H, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_G_H, args);

			args = new Object[] {
				institution_HostModelImpl.getCompanyId(),
				institution_HostModelImpl.getGroupId(),
				institution_HostModelImpl.getInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByC_G_I, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_G_I, args);

			args = new Object[] {
				institution_HostModelImpl.getCompanyId(),
				institution_HostModelImpl.getHostId()
			};

			finderCache.removeResult(_finderPathCountBycompanyAndHost, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBycompanyAndHost, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByinstitutionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalInstitutionId()
				};

				finderCache.removeResult(_finderPathCountByinstitutionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByinstitutionId, args);

				args = new Object[] {
					institution_HostModelImpl.getInstitutionId()
				};

				finderCache.removeResult(_finderPathCountByinstitutionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByinstitutionId, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByhostId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalHostId()
				};

				finderCache.removeResult(_finderPathCountByhostId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByhostId, args);

				args = new Object[] {institution_HostModelImpl.getHostId()};

				finderCache.removeResult(_finderPathCountByhostId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByhostId, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_H.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalGroupId(),
					institution_HostModelImpl.getOriginalHostId()
				};

				finderCache.removeResult(_finderPathCountByG_H, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_H, args);

				args = new Object[] {
					institution_HostModelImpl.getGroupId(),
					institution_HostModelImpl.getHostId()
				};

				finderCache.removeResult(_finderPathCountByG_H, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_H, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {institution_HostModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_G_H.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalCompanyId(),
					institution_HostModelImpl.getOriginalGroupId(),
					institution_HostModelImpl.getOriginalHostId()
				};

				finderCache.removeResult(_finderPathCountByC_G_H, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_G_H, args);

				args = new Object[] {
					institution_HostModelImpl.getCompanyId(),
					institution_HostModelImpl.getGroupId(),
					institution_HostModelImpl.getHostId()
				};

				finderCache.removeResult(_finderPathCountByC_G_H, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_G_H, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_G_I.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalCompanyId(),
					institution_HostModelImpl.getOriginalGroupId(),
					institution_HostModelImpl.getOriginalInstitutionId()
				};

				finderCache.removeResult(_finderPathCountByC_G_I, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_G_I, args);

				args = new Object[] {
					institution_HostModelImpl.getCompanyId(),
					institution_HostModelImpl.getGroupId(),
					institution_HostModelImpl.getInstitutionId()
				};

				finderCache.removeResult(_finderPathCountByC_G_I, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_G_I, args);
			}

			if ((institution_HostModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBycompanyAndHost.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					institution_HostModelImpl.getOriginalCompanyId(),
					institution_HostModelImpl.getOriginalHostId()
				};

				finderCache.removeResult(
					_finderPathCountBycompanyAndHost, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBycompanyAndHost, args);

				args = new Object[] {
					institution_HostModelImpl.getCompanyId(),
					institution_HostModelImpl.getHostId()
				};

				finderCache.removeResult(
					_finderPathCountBycompanyAndHost, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBycompanyAndHost, args);
			}
		}

		entityCache.putResult(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostImpl.class, institution_Host.getPrimaryKey(),
			institution_Host, false);

		clearUniqueFindersCache(institution_HostModelImpl, false);
		cacheUniqueFindersCache(institution_HostModelImpl);

		institution_Host.resetOriginalValues();

		return institution_Host;
	}

	/**
	 * Returns the institution_ host with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstitution_HostException {

		Institution_Host institution_Host = fetchByPrimaryKey(primaryKey);

		if (institution_Host == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstitution_HostException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return institution_Host;
	}

	/**
	 * Returns the institution_ host with the primary key or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host findByPrimaryKey(long institutionHostId)
		throws NoSuchInstitution_HostException {

		return findByPrimaryKey((Serializable)institutionHostId);
	}

	/**
	 * Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	 */
	@Override
	public Institution_Host fetchByPrimaryKey(long institutionHostId) {
		return fetchByPrimaryKey((Serializable)institutionHostId);
	}

	/**
	 * Returns all the institution_ hosts.
	 *
	 * @return the institution_ hosts
	 */
	@Override
	public List<Institution_Host> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 */
	@Override
	public List<Institution_Host> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institution_ hosts
	 */
	@Override
	public List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institution_ hosts
	 */
	@Override
	public List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
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

		List<Institution_Host> list = null;

		if (useFinderCache) {
			list = (List<Institution_Host>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INSTITUTION_HOST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INSTITUTION_HOST;

				sql = sql.concat(Institution_HostModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Institution_Host>)QueryUtil.list(
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
	 * Removes all the institution_ hosts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Institution_Host institution_Host : findAll()) {
			remove(institution_Host);
		}
	}

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INSTITUTION_HOST);

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
		return "institutionHostId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INSTITUTION_HOST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Institution_HostModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the institution_ host persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByinstitutionId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByinstitutionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByinstitutionId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinstitutionId",
			new String[] {Long.class.getName()},
			Institution_HostModelImpl.INSTITUTIONID_COLUMN_BITMASK);

		_finderPathCountByinstitutionId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinstitutionId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByhostId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByhostId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByhostId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByhostId",
			new String[] {Long.class.getName()},
			Institution_HostModelImpl.HOSTID_COLUMN_BITMASK);

		_finderPathCountByhostId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhostId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_H",
			new String[] {Long.class.getName(), Long.class.getName()},
			Institution_HostModelImpl.GROUPID_COLUMN_BITMASK |
			Institution_HostModelImpl.HOSTID_COLUMN_BITMASK);

		_finderPathCountByG_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_H",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByG_I = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_I",
			new String[] {Long.class.getName(), Long.class.getName()},
			Institution_HostModelImpl.GROUPID_COLUMN_BITMASK |
			Institution_HostModelImpl.INSTITUTIONID_COLUMN_BITMASK);

		_finderPathCountByG_I = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_I",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			Institution_HostModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByC_G_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_G_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			Institution_HostModelImpl.COMPANYID_COLUMN_BITMASK |
			Institution_HostModelImpl.GROUPID_COLUMN_BITMASK |
			Institution_HostModelImpl.HOSTID_COLUMN_BITMASK);

		_finderPathCountByC_G_H = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByC_G_I = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_G_I = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			Institution_HostModelImpl.COMPANYID_COLUMN_BITMASK |
			Institution_HostModelImpl.GROUPID_COLUMN_BITMASK |
			Institution_HostModelImpl.INSTITUTIONID_COLUMN_BITMASK);

		_finderPathCountByC_G_I = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindBycompanyAndHost = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycompanyAndHost",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBycompanyAndHost = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED,
			Institution_HostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycompanyAndHost",
			new String[] {Long.class.getName(), Long.class.getName()},
			Institution_HostModelImpl.COMPANYID_COLUMN_BITMASK |
			Institution_HostModelImpl.HOSTID_COLUMN_BITMASK);

		_finderPathCountBycompanyAndHost = new FinderPath(
			Institution_HostModelImpl.ENTITY_CACHE_ENABLED,
			Institution_HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycompanyAndHost",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Institution_HostImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INSTITUTION_HOST =
		"SELECT institution_Host FROM Institution_Host institution_Host";

	private static final String _SQL_SELECT_INSTITUTION_HOST_WHERE =
		"SELECT institution_Host FROM Institution_Host institution_Host WHERE ";

	private static final String _SQL_COUNT_INSTITUTION_HOST =
		"SELECT COUNT(institution_Host) FROM Institution_Host institution_Host";

	private static final String _SQL_COUNT_INSTITUTION_HOST_WHERE =
		"SELECT COUNT(institution_Host) FROM Institution_Host institution_Host WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "institution_Host.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Institution_Host exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Institution_Host exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Institution_HostPersistenceImpl.class);

}