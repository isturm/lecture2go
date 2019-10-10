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

import de.uhh.l2g.plugins.exception.NoSuchInstitution_HostException;
import de.uhh.l2g.plugins.model.Institution_Host;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the institution_ host service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_HostUtil
 * @generated
 */
@ProviderType
public interface Institution_HostPersistence
	extends BasePersistence<Institution_Host> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Institution_HostUtil} to access the institution_ host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByinstitutionId(
		long institutionId);

	/**
	 * Returns a range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByinstitutionId(long, int, int, OrderByComparator)}
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByinstitutionId(
		long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByinstitutionId_First(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByinstitutionId_First(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByinstitutionId_Last(
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByinstitutionId_Last(
		long institutionId,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public Institution_Host[] findByinstitutionId_PrevAndNext(
			long institutionHostId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public void removeByinstitutionId(long institutionId);

	/**
	 * Returns the number of institution_ hosts where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByinstitutionId(long institutionId);

	/**
	 * Returns all the institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByhostId(long hostId);

	/**
	 * Returns a range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByhostId(
		long hostId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByhostId(long, int, int, OrderByComparator)}
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByhostId(
		long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByhostId_First(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByhostId_First(
		long hostId, OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByhostId_Last(
			long hostId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByhostId_Last(
		long hostId, OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where hostId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public Institution_Host[] findByhostId_PrevAndNext(
			long institutionHostId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	public void removeByhostId(long hostId);

	/**
	 * Returns the number of institution_ hosts where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByhostId(long hostId);

	/**
	 * Returns all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByG_H(
		long groupId, long hostId);

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByG_H(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByG_H(
		long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByG_H_First(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByG_H_First(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByG_H_Last(
			long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByG_H_Last(
		long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host[] findByG_H_PrevAndNext(
			long institutionHostId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	public void removeByG_H(long groupId, long hostId);

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and hostId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByG_H(long groupId, long hostId);

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByG_I(long groupId, long institutionId)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByG_I(long,long)}
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	@Deprecated
	public Institution_Host fetchByG_I(
		long groupId, long institutionId, boolean useFinderCache);

	/**
	 * Returns the institution_ host where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByG_I(long groupId, long institutionId);

	/**
	 * Removes the institution_ host where groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the institution_ host that was removed
	 */
	public Institution_Host removeByG_I(long groupId, long institutionId)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the number of institution_ hosts where groupId = &#63; and institutionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByG_I(long groupId, long institutionId);

	/**
	 * Returns all the institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByGroupId(long groupId);

	/**
	 * Returns a range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByGroupId_First(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByGroupId_First(
		long groupId, OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findByGroupId_Last(
			long groupId, OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByGroupId_Last(
		long groupId, OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the institution_ hosts before and after the current institution_ host in the ordered set where groupId = &#63;.
	 *
	 * @param institutionHostId the primary key of the current institution_ host
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public Institution_Host[] findByGroupId_PrevAndNext(
			long institutionHostId, long groupId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of institution_ hosts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId);

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByC_G_H(long,long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<Institution_Host> findByC_G_H(
		long companyId, long groupId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host findByC_G_H_First(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByC_G_H_First(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host findByC_G_H_Last(
			long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByC_G_H_Last(
		long companyId, long groupId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host[] findByC_G_H_PrevAndNext(
			long institutionHostId, long companyId, long groupId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 */
	public void removeByC_G_H(long companyId, long groupId, long hostId);

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByC_G_H(long companyId, long groupId, long hostId);

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId);

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByC_G_I(long,long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<Institution_Host> findByC_G_I(
		long companyId, long groupId, long institutionId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host findByC_G_I_First(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByC_G_I_First(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host findByC_G_I_Last(
			long companyId, long groupId, long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchByC_G_I_Last(
		long companyId, long groupId, long institutionId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host[] findByC_G_I_PrevAndNext(
			long institutionHostId, long companyId, long groupId,
			long institutionId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 */
	public void removeByC_G_I(long companyId, long groupId, long institutionId);

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and groupId = &#63; and institutionId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institution_ hosts
	 */
	public int countByC_G_I(long companyId, long groupId, long institutionId);

	/**
	 * Returns all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId);

	/**
	 * Returns a range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBycompanyAndHost(long,long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institution_ hosts
	 */
	public java.util.List<Institution_Host> findBycompanyAndHost(
		long companyId, long hostId, int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findBycompanyAndHost_First(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the first institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchBycompanyAndHost_First(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host
	 * @throws NoSuchInstitution_HostException if a matching institution_ host could not be found
	 */
	public Institution_Host findBycompanyAndHost_Last(
			long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the last institution_ host in the ordered set where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution_ host, or <code>null</code> if a matching institution_ host could not be found
	 */
	public Institution_Host fetchBycompanyAndHost_Last(
		long companyId, long hostId,
		OrderByComparator<Institution_Host> orderByComparator);

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
	public Institution_Host[] findBycompanyAndHost_PrevAndNext(
			long institutionHostId, long companyId, long hostId,
			OrderByComparator<Institution_Host> orderByComparator)
		throws NoSuchInstitution_HostException;

	/**
	 * Removes all the institution_ hosts where companyId = &#63; and hostId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 */
	public void removeBycompanyAndHost(long companyId, long hostId);

	/**
	 * Returns the number of institution_ hosts where companyId = &#63; and hostId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param hostId the host ID
	 * @return the number of matching institution_ hosts
	 */
	public int countBycompanyAndHost(long companyId, long hostId);

	/**
	 * Caches the institution_ host in the entity cache if it is enabled.
	 *
	 * @param institution_Host the institution_ host
	 */
	public void cacheResult(Institution_Host institution_Host);

	/**
	 * Caches the institution_ hosts in the entity cache if it is enabled.
	 *
	 * @param institution_Hosts the institution_ hosts
	 */
	public void cacheResult(java.util.List<Institution_Host> institution_Hosts);

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	public Institution_Host create(long institutionHostId);

	/**
	 * Removes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public Institution_Host remove(long institutionHostId)
		throws NoSuchInstitution_HostException;

	public Institution_Host updateImpl(Institution_Host institution_Host);

	/**
	 * Returns the institution_ host with the primary key or throws a <code>NoSuchInstitution_HostException</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws NoSuchInstitution_HostException if a institution_ host with the primary key could not be found
	 */
	public Institution_Host findByPrimaryKey(long institutionHostId)
		throws NoSuchInstitution_HostException;

	/**
	 * Returns the institution_ host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host, or <code>null</code> if a institution_ host with the primary key could not be found
	 */
	public Institution_Host fetchByPrimaryKey(long institutionHostId);

	/**
	 * Returns all the institution_ hosts.
	 *
	 * @return the institution_ hosts
	 */
	public java.util.List<Institution_Host> findAll();

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 */
	public java.util.List<Institution_Host> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institution_ hosts
	 */
	@Deprecated
	public java.util.List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institution_ hosts
	 */
	public java.util.List<Institution_Host> findAll(
		int start, int end,
		OrderByComparator<Institution_Host> orderByComparator);

	/**
	 * Removes all the institution_ hosts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
	 */
	public int countAll();

}