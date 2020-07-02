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

import de.uhh.l2g.plugins.exception.NoSuchStatisticException;
import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.model.impl.StatisticImpl;
import de.uhh.l2g.plugins.model.impl.StatisticModelImpl;
import de.uhh.l2g.plugins.service.persistence.StatisticPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class StatisticPersistenceImpl
	extends BasePersistenceImpl<Statistic> implements StatisticPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StatisticUtil</code> to access the statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StatisticImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByStatisticId;
	private FinderPath _finderPathCountByStatisticId;

	/**
	 * Returns the statistic where statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByStatisticId(long statisticId)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByStatisticId(statisticId);

		if (statistic == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("statisticId=");
			sb.append(statisticId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStatisticException(sb.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByStatisticId(long statisticId) {
		return fetchByStatisticId(statisticId, true);
	}

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByStatisticId(
		long statisticId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {statisticId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByStatisticId, finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if (statisticId != statistic.getStatisticId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_STATISTICID_STATISTICID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(statisticId);

				List<Statistic> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByStatisticId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {statisticId};
							}

							_log.warn(
								"StatisticPersistenceImpl.fetchByStatisticId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByStatisticId, finderArgs);
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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where statisticId = &#63; from the database.
	 *
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByStatisticId(long statisticId)
		throws NoSuchStatisticException {

		Statistic statistic = findByStatisticId(statisticId);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where statisticId = &#63;.
	 *
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByStatisticId(long statisticId) {
		FinderPath finderPath = _finderPathCountByStatisticId;

		Object[] finderArgs = new Object[] {statisticId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_STATISTICID_STATISTICID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(statisticId);

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

	private static final String _FINDER_COLUMN_STATISTICID_STATISTICID_2 =
		"statistic.statisticId = ?";

	private FinderPath _finderPathFetchByC_G_S;
	private FinderPath _finderPathCountByC_G_S;

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByC_G_S(long companyId, long groupId, long statisticId)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByC_G_S(companyId, groupId, statisticId);

		if (statistic == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append(", statisticId=");
			sb.append(statisticId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStatisticException(sb.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId) {

		return fetchByC_G_S(companyId, groupId, statisticId, true);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, groupId, statisticId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_G_S, finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if ((companyId != statistic.getCompanyId()) ||
				(groupId != statistic.getGroupId()) ||
				(statisticId != statistic.getStatisticId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_S_STATISTICID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(statisticId);

				List<Statistic> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_G_S, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, groupId, statisticId
								};
							}

							_log.warn(
								"StatisticPersistenceImpl.fetchByC_G_S(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_G_S, finderArgs);
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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByC_G_S(
			long companyId, long groupId, long statisticId)
		throws NoSuchStatisticException {

		Statistic statistic = findByC_G_S(companyId, groupId, statisticId);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByC_G_S(long companyId, long groupId, long statisticId) {
		FinderPath finderPath = _finderPathCountByC_G_S;

		Object[] finderArgs = new Object[] {companyId, groupId, statisticId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_C_G_S_STATISTICID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				queryPos.add(statisticId);

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

	private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 =
		"statistic.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 =
		"statistic.groupId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_S_STATISTICID_2 =
		"statistic.statisticId = ?";

	private FinderPath _finderPathFetchByC_G_D;
	private FinderPath _finderPathCountByC_G_D;

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByC_G_D(long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByC_G_D(companyId, groupId, createDate);

		if (statistic == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append(", createDate=");
			sb.append(createDate);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStatisticException(sb.toString());
		}

		return statistic;
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate) {

		return fetchByC_G_D(companyId, groupId, createDate, true);
	}

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, groupId, _getTime(createDate)
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_G_D, finderArgs, this);
		}

		if (result instanceof Statistic) {
			Statistic statistic = (Statistic)result;

			if ((companyId != statistic.getCompanyId()) ||
				(groupId != statistic.getGroupId()) ||
				!Objects.equals(createDate, statistic.getCreateDate())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				sb.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				sb.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				if (bindCreateDate) {
					queryPos.add(new Timestamp(createDate.getTime()));
				}

				List<Statistic> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_G_D, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, groupId, _getTime(createDate)
								};
							}

							_log.warn(
								"StatisticPersistenceImpl.fetchByC_G_D(long, long, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Statistic statistic = list.get(0);

					result = statistic;

					cacheResult(statistic);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_G_D, finderArgs);
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
			return (Statistic)result;
		}
	}

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the statistic that was removed
	 */
	@Override
	public Statistic removeByC_G_D(
			long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException {

		Statistic statistic = findByC_G_D(companyId, groupId, createDate);

		return remove(statistic);
	}

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the number of matching statistics
	 */
	@Override
	public int countByC_G_D(long companyId, long groupId, Date createDate) {
		FinderPath finderPath = _finderPathCountByC_G_D;

		Object[] finderArgs = new Object[] {
			companyId, groupId, _getTime(createDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_C_G_D_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_G_D_GROUPID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				sb.append(_FINDER_COLUMN_C_G_D_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				sb.append(_FINDER_COLUMN_C_G_D_CREATEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(groupId);

				if (bindCreateDate) {
					queryPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_G_D_COMPANYID_2 =
		"statistic.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_D_GROUPID_2 =
		"statistic.groupId = ? AND ";

	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_1 =
		"statistic.createDate IS NULL";

	private static final String _FINDER_COLUMN_C_G_D_CREATEDATE_2 =
		"statistic.createDate = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching statistics
	 */
	@Override
	public List<Statistic> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
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

		List<Statistic> list = null;

		if (useFinderCache) {
			list = (List<Statistic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Statistic statistic : list) {
					if (groupId != statistic.getGroupId()) {
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

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Statistic>)QueryUtil.list(
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
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByGroup_First(
			long groupId, OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByGroup_First(groupId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByGroup_First(
		long groupId, OrderByComparator<Statistic> orderByComparator) {

		List<Statistic> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByGroup_Last(
			long groupId, OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByGroup_Last(groupId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByGroup_Last(
		long groupId, OrderByComparator<Statistic> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Statistic> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where groupId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic[] findByGroup_PrevAndNext(
			long statisticId, long groupId,
			OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = findByPrimaryKey(statisticId);

		Session session = null;

		try {
			session = openSession();

			Statistic[] array = new StatisticImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, statistic, groupId, orderByComparator, true);

			array[1] = statistic;

			array[2] = getByGroup_PrevAndNext(
				session, statistic, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Statistic getByGroup_PrevAndNext(
		Session session, Statistic statistic, long groupId,
		OrderByComparator<Statistic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATISTIC_WHERE);

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
			sb.append(StatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statistic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Statistic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the statistics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Statistic statistic :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

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
		"statistic.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	@Override
	public List<Statistic> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	@Override
	public List<Statistic> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the statistics where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
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

		List<Statistic> list = null;

		if (useFinderCache) {
			list = (List<Statistic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Statistic statistic : list) {
					if (companyId != statistic.getCompanyId()) {
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

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Statistic>)QueryUtil.list(
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
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByCompany_First(
			long companyId, OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByCompany_First(
			companyId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByCompany_First(
		long companyId, OrderByComparator<Statistic> orderByComparator) {

		List<Statistic> list = findByCompany(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByCompany_Last(
			long companyId, OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByCompany_Last(companyId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByCompany_Last(
		long companyId, OrderByComparator<Statistic> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Statistic> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where companyId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic[] findByCompany_PrevAndNext(
			long statisticId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = findByPrimaryKey(statisticId);

		Session session = null;

		try {
			session = openSession();

			Statistic[] array = new StatisticImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, statistic, companyId, orderByComparator, true);

			array[1] = statistic;

			array[2] = getByCompany_PrevAndNext(
				session, statistic, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Statistic getByCompany_PrevAndNext(
		Session session, Statistic statistic, long companyId,
		OrderByComparator<Statistic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATISTIC_WHERE);

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
			sb.append(StatisticModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statistic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Statistic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the statistics where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Statistic statistic :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

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
		"statistic.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	@Override
	public List<Statistic> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching statistics
	 */
	@Override
	public List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Statistic> orderByComparator,
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

		List<Statistic> list = null;

		if (useFinderCache) {
			list = (List<Statistic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Statistic statistic : list) {
					if ((groupId != statistic.getGroupId()) ||
						(companyId != statistic.getCompanyId())) {

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

			sb.append(_SQL_SELECT_STATISTIC_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatisticModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Statistic>)QueryUtil.list(
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
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Statistic> orderByComparator) {

		List<Statistic> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	@Override
	public Statistic findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (statistic != null) {
			return statistic;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStatisticException(sb.toString());
	}

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	@Override
	public Statistic fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Statistic> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Statistic> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic[] findByGroupAndCompany_PrevAndNext(
			long statisticId, long groupId, long companyId,
			OrderByComparator<Statistic> orderByComparator)
		throws NoSuchStatisticException {

		Statistic statistic = findByPrimaryKey(statisticId);

		Session session = null;

		try {
			session = openSession();

			Statistic[] array = new StatisticImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, statistic, groupId, companyId, orderByComparator,
				true);

			array[1] = statistic;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, statistic, groupId, companyId, orderByComparator,
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

	protected Statistic getByGroupAndCompany_PrevAndNext(
		Session session, Statistic statistic, long groupId, long companyId,
		OrderByComparator<Statistic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STATISTIC_WHERE);

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
			sb.append(StatisticModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(statistic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Statistic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the statistics where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Statistic statistic :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STATISTIC_WHERE);

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
		"statistic.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"statistic.companyId = ?";

	public StatisticPersistenceImpl() {
		setModelClass(Statistic.class);

		setModelImplClass(StatisticImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(StatisticModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the statistic in the entity cache if it is enabled.
	 *
	 * @param statistic the statistic
	 */
	@Override
	public void cacheResult(Statistic statistic) {
		entityCache.putResult(
			StatisticModelImpl.ENTITY_CACHE_ENABLED, StatisticImpl.class,
			statistic.getPrimaryKey(), statistic);

		finderCache.putResult(
			_finderPathFetchByStatisticId,
			new Object[] {statistic.getStatisticId()}, statistic);

		finderCache.putResult(
			_finderPathFetchByC_G_S,
			new Object[] {
				statistic.getCompanyId(), statistic.getGroupId(),
				statistic.getStatisticId()
			},
			statistic);

		finderCache.putResult(
			_finderPathFetchByC_G_D,
			new Object[] {
				statistic.getCompanyId(), statistic.getGroupId(),
				statistic.getCreateDate()
			},
			statistic);

		statistic.resetOriginalValues();
	}

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	@Override
	public void cacheResult(List<Statistic> statistics) {
		for (Statistic statistic : statistics) {
			if (entityCache.getResult(
					StatisticModelImpl.ENTITY_CACHE_ENABLED,
					StatisticImpl.class, statistic.getPrimaryKey()) == null) {

				cacheResult(statistic);
			}
			else {
				statistic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statistics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatisticImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the statistic.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Statistic statistic) {
		entityCache.removeResult(
			StatisticModelImpl.ENTITY_CACHE_ENABLED, StatisticImpl.class,
			statistic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StatisticModelImpl)statistic, true);
	}

	@Override
	public void clearCache(List<Statistic> statistics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Statistic statistic : statistics) {
			entityCache.removeResult(
				StatisticModelImpl.ENTITY_CACHE_ENABLED, StatisticImpl.class,
				statistic.getPrimaryKey());

			clearUniqueFindersCache((StatisticModelImpl)statistic, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				StatisticModelImpl.ENTITY_CACHE_ENABLED, StatisticImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StatisticModelImpl statisticModelImpl) {

		Object[] args = new Object[] {statisticModelImpl.getStatisticId()};

		finderCache.putResult(
			_finderPathCountByStatisticId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByStatisticId, args, statisticModelImpl, false);

		args = new Object[] {
			statisticModelImpl.getCompanyId(), statisticModelImpl.getGroupId(),
			statisticModelImpl.getStatisticId()
		};

		finderCache.putResult(
			_finderPathCountByC_G_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_G_S, args, statisticModelImpl, false);

		args = new Object[] {
			statisticModelImpl.getCompanyId(), statisticModelImpl.getGroupId(),
			_getTime(statisticModelImpl.getCreateDate())
		};

		finderCache.putResult(
			_finderPathCountByC_G_D, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_G_D, args, statisticModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StatisticModelImpl statisticModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {statisticModelImpl.getStatisticId()};

			finderCache.removeResult(_finderPathCountByStatisticId, args);
			finderCache.removeResult(_finderPathFetchByStatisticId, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
			 _finderPathFetchByStatisticId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				statisticModelImpl.getOriginalStatisticId()
			};

			finderCache.removeResult(_finderPathCountByStatisticId, args);
			finderCache.removeResult(_finderPathFetchByStatisticId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				statisticModelImpl.getCompanyId(),
				statisticModelImpl.getGroupId(),
				statisticModelImpl.getStatisticId()
			};

			finderCache.removeResult(_finderPathCountByC_G_S, args);
			finderCache.removeResult(_finderPathFetchByC_G_S, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_G_S.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				statisticModelImpl.getOriginalCompanyId(),
				statisticModelImpl.getOriginalGroupId(),
				statisticModelImpl.getOriginalStatisticId()
			};

			finderCache.removeResult(_finderPathCountByC_G_S, args);
			finderCache.removeResult(_finderPathFetchByC_G_S, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				statisticModelImpl.getCompanyId(),
				statisticModelImpl.getGroupId(),
				_getTime(statisticModelImpl.getCreateDate())
			};

			finderCache.removeResult(_finderPathCountByC_G_D, args);
			finderCache.removeResult(_finderPathFetchByC_G_D, args);
		}

		if ((statisticModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_G_D.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				statisticModelImpl.getOriginalCompanyId(),
				statisticModelImpl.getOriginalGroupId(),
				_getTime(statisticModelImpl.getOriginalCreateDate())
			};

			finderCache.removeResult(_finderPathCountByC_G_D, args);
			finderCache.removeResult(_finderPathFetchByC_G_D, args);
		}
	}

	/**
	 * Creates a new statistic with the primary key. Does not add the statistic to the database.
	 *
	 * @param statisticId the primary key for the new statistic
	 * @return the new statistic
	 */
	@Override
	public Statistic create(long statisticId) {
		Statistic statistic = new StatisticImpl();

		statistic.setNew(true);
		statistic.setPrimaryKey(statisticId);

		statistic.setCompanyId(CompanyThreadLocal.getCompanyId());

		return statistic;
	}

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic remove(long statisticId) throws NoSuchStatisticException {
		return remove((Serializable)statisticId);
	}

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic remove(Serializable primaryKey)
		throws NoSuchStatisticException {

		Session session = null;

		try {
			session = openSession();

			Statistic statistic = (Statistic)session.get(
				StatisticImpl.class, primaryKey);

			if (statistic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatisticException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(statistic);
		}
		catch (NoSuchStatisticException noSuchEntityException) {
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
	protected Statistic removeImpl(Statistic statistic) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statistic)) {
				statistic = (Statistic)session.get(
					StatisticImpl.class, statistic.getPrimaryKeyObj());
			}

			if (statistic != null) {
				session.delete(statistic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (statistic != null) {
			clearCache(statistic);
		}

		return statistic;
	}

	@Override
	public Statistic updateImpl(Statistic statistic) {
		boolean isNew = statistic.isNew();

		if (!(statistic instanceof StatisticModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(statistic.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(statistic);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in statistic proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Statistic implementation " +
					statistic.getClass());
		}

		StatisticModelImpl statisticModelImpl = (StatisticModelImpl)statistic;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (statistic.getCreateDate() == null)) {
			if (serviceContext == null) {
				statistic.setCreateDate(now);
			}
			else {
				statistic.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!statisticModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				statistic.setModifiedDate(now);
			}
			else {
				statistic.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (statistic.isNew()) {
				session.save(statistic);

				statistic.setNew(false);
			}
			else {
				statistic = (Statistic)session.merge(statistic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StatisticModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {statisticModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {statisticModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				statisticModelImpl.getGroupId(),
				statisticModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((statisticModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					statisticModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {statisticModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((statisticModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					statisticModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {statisticModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((statisticModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					statisticModelImpl.getOriginalGroupId(),
					statisticModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					statisticModelImpl.getGroupId(),
					statisticModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			StatisticModelImpl.ENTITY_CACHE_ENABLED, StatisticImpl.class,
			statistic.getPrimaryKey(), statistic, false);

		clearUniqueFindersCache(statisticModelImpl, false);
		cacheUniqueFindersCache(statisticModelImpl);

		statistic.resetOriginalValues();

		return statistic;
	}

	/**
	 * Returns the statistic with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatisticException {

		Statistic statistic = fetchByPrimaryKey(primaryKey);

		if (statistic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatisticException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return statistic;
	}

	/**
	 * Returns the statistic with the primary key or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic findByPrimaryKey(long statisticId)
		throws NoSuchStatisticException {

		return findByPrimaryKey((Serializable)statisticId);
	}

	/**
	 * Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	 */
	@Override
	public Statistic fetchByPrimaryKey(long statisticId) {
		return fetchByPrimaryKey((Serializable)statisticId);
	}

	/**
	 * Returns all the statistics.
	 *
	 * @return the statistics
	 */
	@Override
	public List<Statistic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of statistics
	 */
	@Override
	public List<Statistic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of statistics
	 */
	@Override
	public List<Statistic> findAll(
		int start, int end, OrderByComparator<Statistic> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatisticModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of statistics
	 */
	@Override
	public List<Statistic> findAll(
		int start, int end, OrderByComparator<Statistic> orderByComparator,
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

		List<Statistic> list = null;

		if (useFinderCache) {
			list = (List<Statistic>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATISTIC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATISTIC;

				sql = sql.concat(StatisticModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Statistic>)QueryUtil.list(
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
	 * Removes all the statistics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Statistic statistic : findAll()) {
			remove(statistic);
		}
	}

	/**
	 * Returns the number of statistics.
	 *
	 * @return the number of statistics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATISTIC);

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
		return "statisticId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATISTIC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StatisticModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the statistic persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByStatisticId = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatisticId",
			new String[] {Long.class.getName()},
			StatisticModelImpl.STATISTICID_COLUMN_BITMASK);

		_finderPathCountByStatisticId = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatisticId",
			new String[] {Long.class.getName()});

		_finderPathFetchByC_G_S = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticModelImpl.STATISTICID_COLUMN_BITMASK);

		_finderPathCountByC_G_S = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathFetchByC_G_D = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK |
			StatisticModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByC_G_D = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			StatisticModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, StatisticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			StatisticModelImpl.GROUPID_COLUMN_BITMASK |
			StatisticModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			StatisticModelImpl.ENTITY_CACHE_ENABLED,
			StatisticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StatisticImpl.class.getName());
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

	private static final String _SQL_SELECT_STATISTIC =
		"SELECT statistic FROM Statistic statistic";

	private static final String _SQL_SELECT_STATISTIC_WHERE =
		"SELECT statistic FROM Statistic statistic WHERE ";

	private static final String _SQL_COUNT_STATISTIC =
		"SELECT COUNT(statistic) FROM Statistic statistic";

	private static final String _SQL_COUNT_STATISTIC_WHERE =
		"SELECT COUNT(statistic) FROM Statistic statistic WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "statistic.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Statistic exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Statistic exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatisticPersistenceImpl.class);

}