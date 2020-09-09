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
import java.util.Objects;
import java.util.Set;

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
	private FinderPath _finderPathFetchBydefaultHost;
	private FinderPath _finderPathCountBydefaultHost;

	/**
	 * Returns the host where defaultHost = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param defaultHost the default host
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findBydefaultHost(int defaultHost) throws NoSuchHostException {
		Host host = fetchBydefaultHost(defaultHost);

		if (host == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("defaultHost=");
			sb.append(defaultHost);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHostException(sb.toString());
		}

		return host;
	}

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param defaultHost the default host
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchBydefaultHost(int defaultHost) {
		return fetchBydefaultHost(defaultHost, true);
	}

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param defaultHost the default host
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchBydefaultHost(int defaultHost, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {defaultHost};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydefaultHost, finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if (defaultHost != host.getDefaultHost()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HOST_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTHOST_DEFAULTHOST_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(defaultHost);

				List<Host> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydefaultHost, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {defaultHost};
							}

							_log.warn(
								"HostPersistenceImpl.fetchBydefaultHost(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBydefaultHost, finderArgs);
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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where defaultHost = &#63; from the database.
	 *
	 * @param defaultHost the default host
	 * @return the host that was removed
	 */
	@Override
	public Host removeBydefaultHost(int defaultHost)
		throws NoSuchHostException {

		Host host = findBydefaultHost(defaultHost);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where defaultHost = &#63;.
	 *
	 * @param defaultHost the default host
	 * @return the number of matching hosts
	 */
	@Override
	public int countBydefaultHost(int defaultHost) {
		FinderPath finderPath = _finderPathCountBydefaultHost;

		Object[] finderArgs = new Object[] {defaultHost};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOST_WHERE);

			sb.append(_FINDER_COLUMN_DEFAULTHOST_DEFAULTHOST_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(defaultHost);

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

	private static final String _FINDER_COLUMN_DEFAULTHOST_DEFAULTHOST_2 =
		"host.defaultHost = ?";

	private FinderPath _finderPathFetchByhostId;
	private FinderPath _finderPathCountByhostId;

	/**
	 * Returns the host where companyId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByhostId(long companyId) throws NoSuchHostException {
		Host host = fetchByhostId(companyId);

		if (host == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHostException(sb.toString());
		}

		return host;
	}

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByhostId(long companyId) {
		return fetchByhostId(companyId, true);
	}

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByhostId(long companyId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByhostId, finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if (companyId != host.getCompanyId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HOST_WHERE);

			sb.append(_FINDER_COLUMN_HOSTID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				List<Host> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByhostId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {companyId};
							}

							_log.warn(
								"HostPersistenceImpl.fetchByhostId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByhostId, finderArgs);
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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @return the host that was removed
	 */
	@Override
	public Host removeByhostId(long companyId) throws NoSuchHostException {
		Host host = findByhostId(companyId);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	@Override
	public int countByhostId(long companyId) {
		FinderPath finderPath = _finderPathCountByhostId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOST_WHERE);

			sb.append(_FINDER_COLUMN_HOSTID_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_HOSTID_COMPANYID_2 =
		"host.companyId = ?";

	private FinderPath _finderPathFetchByname;
	private FinderPath _finderPathCountByname;

	/**
	 * Returns the host where name = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findByname(String name) throws NoSuchHostException {
		Host host = fetchByname(name);

		if (host == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHostException(sb.toString());
		}

		return host;
	}

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByname(String name) {
		return fetchByname(name, true);
	}

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchByname(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByname, finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if (!Objects.equals(name, host.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HOST_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<Host> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByname, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"HostPersistenceImpl.fetchByname(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByname, finderArgs);
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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the host that was removed
	 */
	@Override
	public Host removeByname(String name) throws NoSuchHostException {
		Host host = findByname(name);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching hosts
	 */
	@Override
	public int countByname(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByname;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOST_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "host.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(host.name IS NULL OR host.name = '')";

	private FinderPath _finderPathFetchBydirectory;
	private FinderPath _finderPathCountBydirectory;

	/**
	 * Returns the host where directory = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param directory the directory
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	@Override
	public Host findBydirectory(String directory) throws NoSuchHostException {
		Host host = fetchBydirectory(directory);

		if (host == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("directory=");
			sb.append(directory);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHostException(sb.toString());
		}

		return host;
	}

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param directory the directory
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchBydirectory(String directory) {
		return fetchBydirectory(directory, true);
	}

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param directory the directory
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	@Override
	public Host fetchBydirectory(String directory, boolean useFinderCache) {
		directory = Objects.toString(directory, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {directory};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydirectory, finderArgs, this);
		}

		if (result instanceof Host) {
			Host host = (Host)result;

			if (!Objects.equals(directory, host.getDirectory())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HOST_WHERE);

			boolean bindDirectory = false;

			if (directory.isEmpty()) {
				sb.append(_FINDER_COLUMN_DIRECTORY_DIRECTORY_3);
			}
			else {
				bindDirectory = true;

				sb.append(_FINDER_COLUMN_DIRECTORY_DIRECTORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDirectory) {
					queryPos.add(directory);
				}

				List<Host> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydirectory, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {directory};
							}

							_log.warn(
								"HostPersistenceImpl.fetchBydirectory(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Host host = list.get(0);

					result = host;

					cacheResult(host);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBydirectory, finderArgs);
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
			return (Host)result;
		}
	}

	/**
	 * Removes the host where directory = &#63; from the database.
	 *
	 * @param directory the directory
	 * @return the host that was removed
	 */
	@Override
	public Host removeBydirectory(String directory) throws NoSuchHostException {
		Host host = findBydirectory(directory);

		return remove(host);
	}

	/**
	 * Returns the number of hosts where directory = &#63;.
	 *
	 * @param directory the directory
	 * @return the number of matching hosts
	 */
	@Override
	public int countBydirectory(String directory) {
		directory = Objects.toString(directory, "");

		FinderPath finderPath = _finderPathCountBydirectory;

		Object[] finderArgs = new Object[] {directory};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HOST_WHERE);

			boolean bindDirectory = false;

			if (directory.isEmpty()) {
				sb.append(_FINDER_COLUMN_DIRECTORY_DIRECTORY_3);
			}
			else {
				bindDirectory = true;

				sb.append(_FINDER_COLUMN_DIRECTORY_DIRECTORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDirectory) {
					queryPos.add(directory);
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

	private static final String _FINDER_COLUMN_DIRECTORY_DIRECTORY_2 =
		"host.directory = ?";

	private static final String _FINDER_COLUMN_DIRECTORY_DIRECTORY_3 =
		"(host.directory IS NULL OR host.directory = '')";

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
			_finderPathFetchBydefaultHost, new Object[] {host.getDefaultHost()},
			host);

		finderCache.putResult(
			_finderPathFetchByhostId, new Object[] {host.getCompanyId()}, host);

		finderCache.putResult(
			_finderPathFetchByname, new Object[] {host.getName()}, host);

		finderCache.putResult(
			_finderPathFetchBydirectory, new Object[] {host.getDirectory()},
			host);

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

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				HostModelImpl.ENTITY_CACHE_ENABLED, HostImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(HostModelImpl hostModelImpl) {
		Object[] args = new Object[] {hostModelImpl.getDefaultHost()};

		finderCache.putResult(
			_finderPathCountBydefaultHost, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydefaultHost, args, hostModelImpl, false);

		args = new Object[] {hostModelImpl.getCompanyId()};

		finderCache.putResult(
			_finderPathCountByhostId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByhostId, args, hostModelImpl, false);

		args = new Object[] {hostModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByname, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByname, args, hostModelImpl, false);

		args = new Object[] {hostModelImpl.getDirectory()};

		finderCache.putResult(
			_finderPathCountBydirectory, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydirectory, args, hostModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		HostModelImpl hostModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {hostModelImpl.getDefaultHost()};

			finderCache.removeResult(_finderPathCountBydefaultHost, args);
			finderCache.removeResult(_finderPathFetchBydefaultHost, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchBydefaultHost.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				hostModelImpl.getOriginalDefaultHost()
			};

			finderCache.removeResult(_finderPathCountBydefaultHost, args);
			finderCache.removeResult(_finderPathFetchBydefaultHost, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {hostModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByhostId, args);
			finderCache.removeResult(_finderPathFetchByhostId, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchByhostId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {hostModelImpl.getOriginalCompanyId()};

			finderCache.removeResult(_finderPathCountByhostId, args);
			finderCache.removeResult(_finderPathFetchByhostId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {hostModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByname, args);
			finderCache.removeResult(_finderPathFetchByname, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchByname.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {hostModelImpl.getOriginalName()};

			finderCache.removeResult(_finderPathCountByname, args);
			finderCache.removeResult(_finderPathFetchByname, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {hostModelImpl.getDirectory()};

			finderCache.removeResult(_finderPathCountBydirectory, args);
			finderCache.removeResult(_finderPathFetchBydirectory, args);
		}

		if ((hostModelImpl.getColumnBitmask() &
			 _finderPathFetchBydirectory.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {hostModelImpl.getOriginalDirectory()};

			finderCache.removeResult(_finderPathCountBydirectory, args);
			finderCache.removeResult(_finderPathFetchBydirectory, args);
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
		catch (NoSuchHostException noSuchEntityException) {
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
		catch (Exception exception) {
			throw processException(exception);
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
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HostModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
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

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hosts
	 * @param end the upper bound of the range of hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hosts
	 */
	@Override
	public List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator,
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

		List<Host> list = null;

		if (useFinderCache) {
			list = (List<Host>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HOST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HOST;

				sql = sql.concat(HostModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Host>)QueryUtil.list(
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

				Query query = session.createQuery(_SQL_COUNT_HOST);

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

		_finderPathFetchBydefaultHost = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBydefaultHost",
			new String[] {Integer.class.getName()},
			HostModelImpl.DEFAULTHOST_COLUMN_BITMASK);

		_finderPathCountBydefaultHost = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydefaultHost",
			new String[] {Integer.class.getName()});

		_finderPathFetchByhostId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByhostId",
			new String[] {Long.class.getName()},
			HostModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByhostId = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhostId",
			new String[] {Long.class.getName()});

		_finderPathFetchByname = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] {String.class.getName()},
			HostModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByname = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] {String.class.getName()});

		_finderPathFetchBydirectory = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, HostImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBydirectory",
			new String[] {String.class.getName()},
			HostModelImpl.DIRECTORY_COLUMN_BITMASK);

		_finderPathCountBydirectory = new FinderPath(
			HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydirectory",
			new String[] {String.class.getName()});
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