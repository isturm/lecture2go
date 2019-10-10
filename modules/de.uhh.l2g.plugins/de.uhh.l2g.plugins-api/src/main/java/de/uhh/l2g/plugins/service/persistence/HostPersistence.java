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
import com.liferay.portal.kernel.util.OrderByComparator;

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
	 * Returns all the hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	public java.util.List<Host> findByGroup(long groupId);

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
	public java.util.List<Host> findByGroup(long groupId, int start, int end);

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
	public java.util.List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Host> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByGroup_First(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the first host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByGroup_First(
		long groupId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByGroup_Last(
			long groupId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the last host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByGroup_Last(
		long groupId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the hosts before and after the current host in the ordered set where groupId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public Host[] findByGroup_PrevAndNext(
			long hostId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Removes all the hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public java.util.List<Host> findByCompany(long companyId);

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
	public java.util.List<Host> findByCompany(
		long companyId, int start, int end);

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
	public java.util.List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Host> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompany_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompany_First(
		long companyId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompany_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompany_Last(
		long companyId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public Host[] findByCompany_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public java.util.List<Host> findByGroupAndCompany(
		long groupId, long companyId);

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
	public java.util.List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Host> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the first host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the last host in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Host> orderByComparator);

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
	public Host[] findByGroupAndCompany_PrevAndNext(
			long hostId, long groupId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Removes all the hosts where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of hosts where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns all the hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching hosts
	 */
	public java.util.List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId);

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
	public java.util.List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end);

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
	public java.util.List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Host> findByCompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompanyIdAndGroupId_First(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the first host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompanyIdAndGroupId_First(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompanyIdAndGroupId_Last(
			long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the last host in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompanyIdAndGroupId_Last(
		long companyId, long groupId,
		OrderByComparator<Host> orderByComparator);

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
	public Host[] findByCompanyIdAndGroupId_PrevAndNext(
			long hostId, long companyId, long groupId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Removes all the hosts where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	public void removeByCompanyIdAndGroupId(long companyId, long groupId);

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public int countByCompanyIdAndGroupId(long companyId, long groupId);

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByG_H(long groupId, long hostId) throws NoSuchHostException;

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
	public Host fetchByG_H(long groupId, long hostId, boolean useFinderCache);

	/**
	 * Returns the host where groupId = &#63; and hostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByG_H(long groupId, long hostId);

	/**
	 * Removes the host where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the host that was removed
	 */
	public Host removeByG_H(long groupId, long hostId)
		throws NoSuchHostException;

	/**
	 * Returns the number of hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching hosts
	 */
	public int countByG_H(long groupId, long hostId);

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or throws a <code>NoSuchHostException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException;

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
	public Host fetchByDefaultHost(
		long companyId, long groupId, boolean useFinderCache);

	/**
	 * Returns the host where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByDefaultHost(long companyId, long groupId);

	/**
	 * Removes the host where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the host that was removed
	 */
	public Host removeByDefaultHost(long companyId, long groupId)
		throws NoSuchHostException;

	/**
	 * Returns the number of hosts where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching hosts
	 */
	public int countByDefaultHost(long companyId, long groupId);

	/**
	 * Returns all the hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching hosts
	 */
	public java.util.List<Host> findByCompanyId(long companyId);

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
	public java.util.List<Host> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Host> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompanyId_First(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the first host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompanyId_First(
		long companyId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host
	 * @throws NoSuchHostException if a matching host could not be found
	 */
	public Host findByCompanyId_Last(
			long companyId, OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Returns the last host in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching host, or <code>null</code> if a matching host could not be found
	 */
	public Host fetchByCompanyId_Last(
		long companyId, OrderByComparator<Host> orderByComparator);

	/**
	 * Returns the hosts before and after the current host in the ordered set where companyId = &#63;.
	 *
	 * @param hostId the primary key of the current host
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next host
	 * @throws NoSuchHostException if a host with the primary key could not be found
	 */
	public Host[] findByCompanyId_PrevAndNext(
			long hostId, long companyId,
			OrderByComparator<Host> orderByComparator)
		throws NoSuchHostException;

	/**
	 * Removes all the hosts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of hosts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching hosts
	 */
	public int countByCompanyId(long companyId);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Host> findAll(
		int start, int end, OrderByComparator<Host> orderByComparator);

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