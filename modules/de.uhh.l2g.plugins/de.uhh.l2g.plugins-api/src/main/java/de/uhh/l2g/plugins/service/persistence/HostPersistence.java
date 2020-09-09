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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchHostException;
import de.uhh.l2g.plugins.model.Host;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see HostUtil
 * @generated
 */
@ProviderType
public interface HostPersistence extends BasePersistence<Host> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HostUtil} to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the host where defaultHost = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param defaultHost the default host
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findBydefaultHost(int defaultHost) throws NoSuchHostException;

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param defaultHost the default host
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchBydefaultHost(int defaultHost);

	/**
	 * Returns the host where defaultHost = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param defaultHost the default host
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchBydefaultHost(int defaultHost, boolean useFinderCache);

	/**
	 * Removes the host where defaultHost = &#63; from the database.
	 *
	 * @param defaultHost the default host
	 * @return the host that was removed
	 */
	public Host removeBydefaultHost(int defaultHost) throws NoSuchHostException;

	/**
	 * Returns the number of hosts where defaultHost = &#63;.
	 *
	 * @param defaultHost the default host
	 * @return the number of matching hosts
	 */
	public int countBydefaultHost(int defaultHost);

	/**
	 * Returns the host where companyId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByhostId(long companyId) throws NoSuchHostException;

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByhostId(long companyId);

	/**
	 * Returns the host where companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByhostId(long companyId, boolean useFinderCache);

	/**
	 * Removes the host where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @return the host that was removed
	 */
	public Host removeByhostId(long companyId) throws NoSuchHostException;

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public int countByhostId(long companyId);

	/**
	 * Returns the host where name = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByname(String name) throws NoSuchHostException;

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByname(String name);

	/**
	 * Returns the host where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByname(String name, boolean useFinderCache);

	/**
	 * Removes the host where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the host that was removed
	 */
	public Host removeByname(String name) throws NoSuchHostException;

	/**
	 * Returns the number of hosts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching hosts
	 */
	public int countByname(String name);

	/**
	 * Returns the host where directory = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param directory the directory
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findBydirectory(String directory) throws NoSuchHostException;

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param directory the directory
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchBydirectory(String directory);

	/**
	 * Returns the host where directory = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param directory the directory
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchBydirectory(String directory, boolean useFinderCache);

	/**
	 * Removes the host where directory = &#63; from the database.
	 *
	 * @param directory the directory
	 * @return the host that was removed
	 */
	public Host removeBydirectory(String directory) throws NoSuchHostException;

	/**
	 * Returns the number of hosts where directory = &#63;.
	 *
	 * @param directory the directory
	 * @return the number of matching hosts
	 */
	public int countBydirectory(String directory);

	/**
	 * Caches the host in the entity cache if it is enabled.
	 *
	 * @param host the host
	 */
	public void cacheResult(Host host);

	/**
	 * Caches the hosts in the entity cache if it is enabled.
	 *
	 * @param hosts the hosts
	 */
	public void cacheResult(java.util.List<Host> hosts);

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	public Host create(long hostId);

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host
	 * @return the host that was removed
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public Host remove(long hostId) throws NoSuchHostException;

	public Host updateImpl(Host host);

	/**
	 * Returns the host with the primary key or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public Host findByPrimaryKey(long hostId) throws NoSuchHostException;

	/**
	 * Returns the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 */
	public Host fetchByPrimaryKey(long hostId);

	/**
	 * Returns all the hosts.
	 *
	 * @return the hosts
	 */
	public java.util.List<Host> findAll();

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
	public java.util.List<Host> findAll(int start, int end);

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
	public java.util.List<Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Host>
			orderByComparator);

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
	public java.util.List<Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Host>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the hosts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hosts.
	 *
	 * @return the number of hosts
	 */
	public int countAll();

}