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

import de.uhh.l2g.plugins.exception.NoSuchOfficeException;
import de.uhh.l2g.plugins.model.Office;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OfficeUtil
 * @generated
 */
@ProviderType
public interface OfficePersistence extends BasePersistence<Office> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeUtil} to access the office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the office where institutionId = &#63; or throws a <code>NoSuchOfficeException</code> if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByInstitution(long institutionId)
		throws NoSuchOfficeException;

	/**
	 * Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @return the matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByInstitution(long institutionId);

	/**
	 * Returns the office where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByInstitution(
		long institutionId, boolean useFinderCache);

	/**
	 * Removes the office where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the office that was removed
	 */
	public Office removeByInstitution(long institutionId)
		throws NoSuchOfficeException;

	/**
	 * Returns the number of offices where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching offices
	 */
	public int countByInstitution(long institutionId);

	/**
	 * Returns all the offices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching offices
	 */
	public java.util.List<Office> findByGroup(long groupId);

	/**
	 * Returns a range of all the offices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @return the range of matching offices
	 */
	public java.util.List<Office> findByGroup(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the offices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offices where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first office in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the first office in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the last office in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the last office in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the offices before and after the current office in the ordered set where groupId = &#63;.
	 *
	 * @param officeId the primary key of the current office
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office
	 * @throws NoSuchOfficeException if a office with the primary key could not be found
	 */
	public Office[] findByGroup_PrevAndNext(
			long officeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Removes all the offices where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of offices where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching offices
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the offices where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching offices
	 */
	public java.util.List<Office> findByCompany(long companyId);

	/**
	 * Returns a range of all the offices where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @return the range of matching offices
	 */
	public java.util.List<Office> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the offices where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offices where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first office in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the first office in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the last office in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the last office in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the offices before and after the current office in the ordered set where companyId = &#63;.
	 *
	 * @param officeId the primary key of the current office
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office
	 * @throws NoSuchOfficeException if a office with the primary key could not be found
	 */
	public Office[] findByCompany_PrevAndNext(
			long officeId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Removes all the offices where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of offices where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching offices
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the offices where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching offices
	 */
	public java.util.List<Office> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the offices where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @return the range of matching offices
	 */
	public java.util.List<Office> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the offices where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offices where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offices
	 */
	public java.util.List<Office> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first office in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the first office in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the last office in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office
	 * @throws NoSuchOfficeException if a matching office could not be found
	 */
	public Office findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Returns the last office in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office, or <code>null</code> if a matching office could not be found
	 */
	public Office fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns the offices before and after the current office in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param officeId the primary key of the current office
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office
	 * @throws NoSuchOfficeException if a office with the primary key could not be found
	 */
	public Office[] findByGroupAndCompany_PrevAndNext(
			long officeId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Office>
				orderByComparator)
		throws NoSuchOfficeException;

	/**
	 * Removes all the offices where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of offices where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching offices
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the office in the entity cache if it is enabled.
	 *
	 * @param office the office
	 */
	public void cacheResult(Office office);

	/**
	 * Caches the offices in the entity cache if it is enabled.
	 *
	 * @param offices the offices
	 */
	public void cacheResult(java.util.List<Office> offices);

	/**
	 * Creates a new office with the primary key. Does not add the office to the database.
	 *
	 * @param officeId the primary key for the new office
	 * @return the new office
	 */
	public Office create(long officeId);

	/**
	 * Removes the office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeId the primary key of the office
	 * @return the office that was removed
	 * @throws NoSuchOfficeException if a office with the primary key could not be found
	 */
	public Office remove(long officeId) throws NoSuchOfficeException;

	public Office updateImpl(Office office);

	/**
	 * Returns the office with the primary key or throws a <code>NoSuchOfficeException</code> if it could not be found.
	 *
	 * @param officeId the primary key of the office
	 * @return the office
	 * @throws NoSuchOfficeException if a office with the primary key could not be found
	 */
	public Office findByPrimaryKey(long officeId) throws NoSuchOfficeException;

	/**
	 * Returns the office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeId the primary key of the office
	 * @return the office, or <code>null</code> if a office with the primary key could not be found
	 */
	public Office fetchByPrimaryKey(long officeId);

	/**
	 * Returns all the offices.
	 *
	 * @return the offices
	 */
	public java.util.List<Office> findAll();

	/**
	 * Returns a range of all the offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @return the range of offices
	 */
	public java.util.List<Office> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offices
	 */
	public java.util.List<Office> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator);

	/**
	 * Returns an ordered range of all the offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offices
	 * @param end the upper bound of the range of offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of offices
	 */
	public java.util.List<Office> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Office>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the offices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of offices.
	 *
	 * @return the number of offices
	 */
	public int countAll();

}