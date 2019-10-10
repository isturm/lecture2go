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

import de.uhh.l2g.plugins.exception.NoSuchCoordinatorException;
import de.uhh.l2g.plugins.model.Coordinator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the coordinator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CoordinatorUtil
 * @generated
 */
@ProviderType
public interface CoordinatorPersistence extends BasePersistence<Coordinator> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoordinatorUtil} to access the coordinator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the coordinator where institutionId = &#63; or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param institutionId the institution ID
	 * @return the matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByInstitution(long institutionId)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByInstitution(long)}
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	@Deprecated
	public Coordinator fetchByInstitution(
		long institutionId, boolean useFinderCache);

	/**
	 * Returns the coordinator where institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByInstitution(long institutionId);

	/**
	 * Removes the coordinator where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 * @return the coordinator that was removed
	 */
	public Coordinator removeByInstitution(long institutionId)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the number of coordinators where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching coordinators
	 */
	public int countByInstitution(long institutionId);

	/**
	 * Returns all the coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching coordinators
	 */
	public java.util.List<Coordinator> findByOffice(long officeId);

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
	public java.util.List<Coordinator> findByOffice(
		long officeId, int start, int end);

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
	public java.util.List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Coordinator> findByOffice(
		long officeId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByOffice_First(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the first coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByOffice_First(
		long officeId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByOffice_Last(
			long officeId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the last coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByOffice_Last(
		long officeId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where officeId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public Coordinator[] findByOffice_PrevAndNext(
			long coordinatorId, long officeId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Removes all the coordinators where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	public void removeByOffice(long officeId);

	/**
	 * Returns the number of coordinators where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching coordinators
	 */
	public int countByOffice(long officeId);

	/**
	 * Returns all the coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching coordinators
	 */
	public java.util.List<Coordinator> findByGroup(long groupId);

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
	public java.util.List<Coordinator> findByGroup(
		long groupId, int start, int end);

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
	public java.util.List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Coordinator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByGroup_First(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByGroup_First(
		long groupId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByGroup_Last(
			long groupId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByGroup_Last(
		long groupId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where groupId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public Coordinator[] findByGroup_PrevAndNext(
			long coordinatorId, long groupId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Removes all the coordinators where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of coordinators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching coordinators
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	public java.util.List<Coordinator> findByCompany(long companyId);

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
	public java.util.List<Coordinator> findByCompany(
		long companyId, int start, int end);

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
	public java.util.List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Coordinator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByCompany_First(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the first coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByCompany_First(
		long companyId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByCompany_Last(
			long companyId, OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the last coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByCompany_Last(
		long companyId, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the coordinators before and after the current coordinator in the ordered set where companyId = &#63;.
	 *
	 * @param coordinatorId the primary key of the current coordinator
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public Coordinator[] findByCompany_PrevAndNext(
			long coordinatorId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Removes all the coordinators where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of coordinators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching coordinators
	 */
	public java.util.List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId);

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
	public java.util.List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Coordinator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the first coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator
	 * @throws NoSuchCoordinatorException if a matching coordinator could not be found
	 */
	public Coordinator findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the last coordinator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinator, or <code>null</code> if a matching coordinator could not be found
	 */
	public Coordinator fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Coordinator> orderByComparator);

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
	public Coordinator[] findByGroupAndCompany_PrevAndNext(
			long coordinatorId, long groupId, long companyId,
			OrderByComparator<Coordinator> orderByComparator)
		throws NoSuchCoordinatorException;

	/**
	 * Removes all the coordinators where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of coordinators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching coordinators
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the coordinator in the entity cache if it is enabled.
	 *
	 * @param coordinator the coordinator
	 */
	public void cacheResult(Coordinator coordinator);

	/**
	 * Caches the coordinators in the entity cache if it is enabled.
	 *
	 * @param coordinators the coordinators
	 */
	public void cacheResult(java.util.List<Coordinator> coordinators);

	/**
	 * Creates a new coordinator with the primary key. Does not add the coordinator to the database.
	 *
	 * @param coordinatorId the primary key for the new coordinator
	 * @return the new coordinator
	 */
	public Coordinator create(long coordinatorId);

	/**
	 * Removes the coordinator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator that was removed
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public Coordinator remove(long coordinatorId)
		throws NoSuchCoordinatorException;

	public Coordinator updateImpl(Coordinator coordinator);

	/**
	 * Returns the coordinator with the primary key or throws a <code>NoSuchCoordinatorException</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator
	 * @throws NoSuchCoordinatorException if a coordinator with the primary key could not be found
	 */
	public Coordinator findByPrimaryKey(long coordinatorId)
		throws NoSuchCoordinatorException;

	/**
	 * Returns the coordinator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinatorId the primary key of the coordinator
	 * @return the coordinator, or <code>null</code> if a coordinator with the primary key could not be found
	 */
	public Coordinator fetchByPrimaryKey(long coordinatorId);

	/**
	 * Returns all the coordinators.
	 *
	 * @return the coordinators
	 */
	public java.util.List<Coordinator> findAll();

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
	public java.util.List<Coordinator> findAll(int start, int end);

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
	public java.util.List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Coordinator> findAll(
		int start, int end, OrderByComparator<Coordinator> orderByComparator);

	/**
	 * Removes all the coordinators from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of coordinators.
	 *
	 * @return the number of coordinators
	 */
	public int countAll();

}