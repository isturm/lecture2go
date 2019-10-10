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

import de.uhh.l2g.plugins.exception.NoSuchCoordinatorException;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.impl.CoordinatorImpl;
import de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.CoordinatorPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class CoordinatorPersistenceImpl
	extends BasePersistenceImpl<Coordinator> implements CoordinatorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CoordinatorUtil</code> to access the coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CoordinatorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByInstitution;
	private FinderPath _finderPathCountByInstitution;

	/**
	 * Returns the coordinator where institutionId = &#63; or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByInstitution(long institutionId)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByInstitution(institutionId);

		if (coordinator == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("institutionId=");
			msg.append(institutionId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCoordinatorException(msg.toString());
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByInstitution(long)}
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Deprecated
	@Override
	public Coordinator fetchByInstitution(
		long institutionId, boolean useFinderCache) {

		return fetchByInstitution(institutionId);
	}

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByInstitution(long institutionId) {
		Object[] finderArgs = new Object[] {institutionId};

		Object result = finderCache.getResult(
			_finderPathFetchByInstitution, finderArgs, this);

		if (result instanceof Coordinator) {
			Coordinator coordinator = (Coordinator)result;

			if ((institutionId != coordinator.getInstitutionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				List<Coordinator> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByInstitution, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CoordinatorPersistenceImpl.fetchByInstitution(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Coordinator coordinator = list.get(0);

					result = coordinator;

					cacheResult(coordinator);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByInstitution, finderArgs);

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
			return (Coordinator)result;
		}
	}

	/**
	 * Removes the coordinator where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the coordinator that was removed
	 */
	@Override
	public Coordinator removeByInstitution(long institutionId)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = findByInstitution(institutionId);

		return remove(coordinator);
	}

	/**
	 * Returns the number of coordinators where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByInstitution(long institutionId) {
		FinderPath finderPath = _finderPathCountByInstitution;

		Object[] finderArgs = new Object[] {institutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

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

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 =
		"coordinator.institutionId = ?";

	private FinderPath _finderPathWithPaginationFindByOffice;
	private FinderPath _finderPathWithoutPaginationFindByOffice;
	private FinderPath _finderPathCountByOffice;

	/**
	 * Returns all the coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId) {
		return findByOffice(
			officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(long officeId, int start, int end) {
		return findByOffice(officeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByOffice(long, int, int, OrderByComparator)}
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	@Deprecated
	@Override
	public List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return findByOffice(officeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByOffice;
			finderArgs = new Object[] {officeId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByOffice;
			finderArgs = new Object[] {officeId, start, end, orderByComparator};
		}

		List<Coordinator> list = (List<Coordinator>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinator coordinator : list) {
				if ((officeId != coordinator.getOfficeId())) {
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

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(
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
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByOffice_First(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByOffice_First(
			officeId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByOffice_First(
		long officeId, OrderByComparator<Coordinator> orderByComparator) {

		List<Coordinator> list = findByOffice(
			officeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByOffice_Last(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByOffice_Last(
			officeId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeId=");
		msg.append(officeId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByOffice_Last(
		long officeId, OrderByComparator<Coordinator> orderByComparator) {

		int count = countByOffice(officeId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByOffice(
			officeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator[] findByOffice_PrevAndNext(
			long coordinatorId, long officeId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByOffice_PrevAndNext(
				session, coordinator, officeId, orderByComparator, true);

			array[1] = coordinator;

			array[2] = getByOffice_PrevAndNext(
				session, coordinator, officeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coordinator getByOffice_PrevAndNext(
		Session session, Coordinator coordinator, long officeId,
		OrderByComparator<Coordinator> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

		query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(officeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(coordinator)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	@Override
	public void removeByOffice(long officeId) {
		for (Coordinator coordinator :
				findByOffice(
					officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByOffice(long officeId) {
		FinderPath finderPath = _finderPathCountByOffice;

		Object[] finderArgs = new Object[] {officeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_OFFICE_OFFICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeId);

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

	private static final String _FINDER_COLUMN_OFFICE_OFFICEID_2 =
		"coordinator.officeId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	@Deprecated
	@Override
	public List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

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

		List<Coordinator> list = (List<Coordinator>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinator coordinator : list) {
				if ((groupId != coordinator.getGroupId())) {
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

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(
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
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByGroup_First(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByGroup_First(
			groupId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByGroup_First(
		long groupId, OrderByComparator<Coordinator> orderByComparator) {

		List<Coordinator> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByGroup_Last(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByGroup_Last(groupId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByGroup_Last(
		long groupId, OrderByComparator<Coordinator> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator[] findByGroup_PrevAndNext(
			long coordinatorId, long groupId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, coordinator, groupId, orderByComparator, true);

			array[1] = coordinator;

			array[2] = getByGroup_PrevAndNext(
				session, coordinator, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coordinator getByGroup_PrevAndNext(
		Session session, Coordinator coordinator, long groupId,
		OrderByComparator<Coordinator> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(coordinator)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Coordinator coordinator :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

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
		"coordinator.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	@Override
	public List<Coordinator> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	@Deprecated
	@Override
	public List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

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

		List<Coordinator> list = (List<Coordinator>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinator coordinator : list) {
				if ((companyId != coordinator.getCompanyId())) {
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

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(
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
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByCompany_First(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByCompany_First(
			companyId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByCompany_First(
		long companyId, OrderByComparator<Coordinator> orderByComparator) {

		List<Coordinator> list = findByCompany(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByCompany_Last(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByCompany_Last(
			companyId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByCompany_Last(
		long companyId, OrderByComparator<Coordinator> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator[] findByCompany_PrevAndNext(
			long coordinatorId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, coordinator, companyId, orderByComparator, true);

			array[1] = coordinator;

			array[2] = getByCompany_PrevAndNext(
				session, coordinator, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coordinator getByCompany_PrevAndNext(
		Session session, Coordinator coordinator, long companyId,
		OrderByComparator<Coordinator> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(coordinator)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Coordinator coordinator :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

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
		"coordinator.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId) {

		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coordinators
	 */
	@Deprecated
	@Override
	public List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinators
	 */
	@Override
	public List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator) {

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

		List<Coordinator> list = (List<Coordinator>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinator coordinator : list) {
				if ((groupId != coordinator.getGroupId()) ||
					(companyId != coordinator.getCompanyId())) {

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

			query.append(_SQL_SELECT_COORDINATOR_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
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
					list = (List<Coordinator>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(
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
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator) {

		List<Coordinator> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	@Override
	public Coordinator findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (coordinator != null) {
			return coordinator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchCoordinatorException(msg.toString());
	}

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Override
	public Coordinator fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Coordinator> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator[] findByGroupAndCompany_PrevAndNext(
			long coordinatorId, long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = findByPrimaryKey(coordinatorId);

		Session session = null;

		try {
			session = openSession();

			Coordinator[] array = new CoordinatorImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, coordinator, groupId, companyId, orderByComparator,
				true);

			array[1] = coordinator;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, coordinator, groupId, companyId, orderByComparator,
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

	protected Coordinator getByGroupAndCompany_PrevAndNext(
		Session session, Coordinator coordinator, long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COORDINATOR_WHERE);

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
			query.append(CoordinatorModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(coordinator)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Coordinator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinators where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Coordinator coordinator :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COORDINATOR_WHERE);

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
		"coordinator.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"coordinator.companyId = ?";

	public CoordinatorPersistenceImpl() {
		setModelClass(Coordinator.class);

		setModelImplClass(CoordinatorImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(CoordinatorModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the coordinator in the entity cache if it is enabled.
	 *
	 * @param coordinator the coordinator
	 */
	@Override
	public void cacheResult(Coordinator coordinator) {
		entityCache.putResult(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED, CoordinatorImpl.class,
			coordinator.getPrimaryKey(), coordinator);

		finderCache.putResult(
			_finderPathFetchByInstitution,
			new Object[] {coordinator.getInstitutionId()}, coordinator);

		coordinator.resetOriginalValues();
	}

	/**
	 * Caches the coordinators in the entity cache if it is enabled.
	 *
	 * @param coordinators the coordinators
	 */
	@Override
	public void cacheResult(List<Coordinator> coordinators) {
		for (Coordinator coordinator : coordinators) {
			if (entityCache.getResult(
					CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
					CoordinatorImpl.class, coordinator.getPrimaryKey()) ==
						null) {

				cacheResult(coordinator);
			}
			else {
				coordinator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coordinators.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CoordinatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coordinator.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coordinator coordinator) {
		entityCache.removeResult(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED, CoordinatorImpl.class,
			coordinator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CoordinatorModelImpl)coordinator, true);
	}

	@Override
	public void clearCache(List<Coordinator> coordinators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coordinator coordinator : coordinators) {
			entityCache.removeResult(
				CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
				CoordinatorImpl.class, coordinator.getPrimaryKey());

			clearUniqueFindersCache((CoordinatorModelImpl)coordinator, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CoordinatorModelImpl coordinatorModelImpl) {

		Object[] args = new Object[] {coordinatorModelImpl.getInstitutionId()};

		finderCache.putResult(
			_finderPathCountByInstitution, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByInstitution, args, coordinatorModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CoordinatorModelImpl coordinatorModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				coordinatorModelImpl.getInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByInstitution, args);
			finderCache.removeResult(_finderPathFetchByInstitution, args);
		}

		if ((coordinatorModelImpl.getColumnBitmask() &
			 _finderPathFetchByInstitution.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				coordinatorModelImpl.getOriginalInstitutionId()
			};

			finderCache.removeResult(_finderPathCountByInstitution, args);
			finderCache.removeResult(_finderPathFetchByInstitution, args);
		}
	}

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	@Override
	public Coordinator create(long coordinatorId) {
		Coordinator coordinator = new CoordinatorImpl();

		coordinator.setNew(true);
		coordinator.setPrimaryKey(coordinatorId);

		coordinator.setCompanyId(CompanyThreadLocal.getCompanyId());

		return coordinator;
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator remove(long coordinatorId)
		throws NoSuchCoordinatorException {

		return remove((Serializable)coordinatorId);
	}

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator remove(Serializable primaryKey)
		throws NoSuchCoordinatorException {

		Session session = null;

		try {
			session = openSession();

			Coordinator coordinator = (Coordinator)session.get(
				CoordinatorImpl.class, primaryKey);

			if (coordinator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoordinatorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(coordinator);
		}
		catch (NoSuchCoordinatorException nsee) {
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
	protected Coordinator removeImpl(Coordinator coordinator) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coordinator)) {
				coordinator = (Coordinator)session.get(
					CoordinatorImpl.class, coordinator.getPrimaryKeyObj());
			}

			if (coordinator != null) {
				session.delete(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coordinator != null) {
			clearCache(coordinator);
		}

		return coordinator;
	}

	@Override
	public Coordinator updateImpl(Coordinator coordinator) {
		boolean isNew = coordinator.isNew();

		if (!(coordinator instanceof CoordinatorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(coordinator.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(coordinator);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in coordinator proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Coordinator implementation " +
					coordinator.getClass());
		}

		CoordinatorModelImpl coordinatorModelImpl =
			(CoordinatorModelImpl)coordinator;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (coordinator.getCreateDate() == null)) {
			if (serviceContext == null) {
				coordinator.setCreateDate(now);
			}
			else {
				coordinator.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!coordinatorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				coordinator.setModifiedDate(now);
			}
			else {
				coordinator.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (coordinator.isNew()) {
				session.save(coordinator);

				coordinator.setNew(false);
			}
			else {
				coordinator = (Coordinator)session.merge(coordinator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CoordinatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {coordinatorModelImpl.getOfficeId()};

			finderCache.removeResult(_finderPathCountByOffice, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOffice, args);

			args = new Object[] {coordinatorModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {coordinatorModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				coordinatorModelImpl.getGroupId(),
				coordinatorModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((coordinatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOffice.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					coordinatorModelImpl.getOriginalOfficeId()
				};

				finderCache.removeResult(_finderPathCountByOffice, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOffice, args);

				args = new Object[] {coordinatorModelImpl.getOfficeId()};

				finderCache.removeResult(_finderPathCountByOffice, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOffice, args);
			}

			if ((coordinatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					coordinatorModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {coordinatorModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((coordinatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					coordinatorModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {coordinatorModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((coordinatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					coordinatorModelImpl.getOriginalGroupId(),
					coordinatorModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					coordinatorModelImpl.getGroupId(),
					coordinatorModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED, CoordinatorImpl.class,
			coordinator.getPrimaryKey(), coordinator, false);

		clearUniqueFindersCache(coordinatorModelImpl, false);
		cacheUniqueFindersCache(coordinatorModelImpl);

		coordinator.resetOriginalValues();

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoordinatorException {

		Coordinator coordinator = fetchByPrimaryKey(primaryKey);

		if (coordinator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoordinatorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return coordinator;
	}

	/**
	 * Returns the coordinator with the primary key or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator findByPrimaryKey(long coordinatorId)
		throws NoSuchCoordinatorException {

		return findByPrimaryKey((Serializable)coordinatorId);
	}

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 */
	@Override
	public Coordinator fetchByPrimaryKey(long coordinatorId) {
		return fetchByPrimaryKey((Serializable)coordinatorId);
	}

	/**
	 * Returns all the coordinators.
	 *
	 * @return the coordinators
	 */
	@Override
	public List<Coordinator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @return the range of coordinators
	 */
	@Override
	public List<Coordinator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coordinators
	 */
	@Deprecated
	@Override
	public List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coordinators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CoordinatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinators
	 * @param end the upper bound of the range of coordinators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coordinators
	 */
	@Override
	public List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator) {

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

		List<Coordinator> list = (List<Coordinator>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COORDINATOR);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COORDINATOR;

				if (pagination) {
					sql = sql.concat(CoordinatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coordinator>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Coordinator>)QueryUtil.list(
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
	 * Removes all the coordinators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Coordinator coordinator : findAll()) {
			remove(coordinator);
		}
	}

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COORDINATOR);

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
		return "coordinatorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COORDINATOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CoordinatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the coordinator persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByInstitution = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByInstitution",
			new String[] {Long.class.getName()},
			CoordinatorModelImpl.INSTITUTIONID_COLUMN_BITMASK);

		_finderPathCountByInstitution = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByOffice = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOffice",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOffice = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOffice",
			new String[] {Long.class.getName()},
			CoordinatorModelImpl.OFFICEID_COLUMN_BITMASK);

		_finderPathCountByOffice = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOffice",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			CoordinatorModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			CoordinatorModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, CoordinatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			CoordinatorModelImpl.GROUPID_COLUMN_BITMASK |
			CoordinatorModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			CoordinatorModelImpl.ENTITY_CACHE_ENABLED,
			CoordinatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CoordinatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COORDINATOR =
		"SELECT coordinator FROM Coordinator coordinator";

	private static final String _SQL_SELECT_COORDINATOR_WHERE =
		"SELECT coordinator FROM Coordinator coordinator WHERE ";

	private static final String _SQL_COUNT_COORDINATOR =
		"SELECT COUNT(coordinator) FROM Coordinator coordinator";

	private static final String _SQL_COUNT_COORDINATOR_WHERE =
		"SELECT COUNT(coordinator) FROM Coordinator coordinator WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "coordinator.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Coordinator exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Coordinator exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CoordinatorPersistenceImpl.class);

}