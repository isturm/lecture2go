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

import de.uhh.l2g.plugins.exception.NoSuchScheduledThreadException;
import de.uhh.l2g.plugins.model.ScheduledThread;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the scheduled thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThreadUtil
 * @generated
 */
@ProviderType
public interface ScheduledThreadPersistence
	extends BasePersistence<ScheduledThread> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScheduledThreadUtil} to access the scheduled thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBySchedulerClassName(String)}
	 * @param schedulerClassName the scheduler class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	@Deprecated
	public ScheduledThread fetchBySchedulerClassName(
		String schedulerClassName, boolean useFinderCache);

	/**
	 * Returns the scheduled thread where schedulerClassName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchBySchedulerClassName(String schedulerClassName);

	/**
	 * Removes the scheduled thread where schedulerClassName = &#63; from the database.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the scheduled thread that was removed
	 */
	public ScheduledThread removeBySchedulerClassName(String schedulerClassName)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the number of scheduled threads where schedulerClassName = &#63;.
	 *
	 * @param schedulerClassName the scheduler class name
	 * @return the number of matching scheduled threads
	 */
	public int countBySchedulerClassName(String schedulerClassName);

	/**
	 * Returns all the scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroup(long groupId);

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public java.util.List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByGroup_First(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByGroup_First(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByGroup_Last(
			long groupId, OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByGroup_Last(
		long groupId, OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread[] findByGroup_PrevAndNext(
			long scheduledThreadId, long groupId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Removes all the scheduled threads where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of scheduled threads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching scheduled threads
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByCompany(long companyId);

	/**
	 * Returns a range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public java.util.List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the scheduled threads where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByCompany_First(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the first scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByCompany_First(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByCompany_Last(
			long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the last scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByCompany_Last(
		long companyId, OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread[] findByCompany_PrevAndNext(
			long scheduledThreadId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Removes all the scheduled threads where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of scheduled threads where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching scheduled threads
	 */
	@Deprecated
	public java.util.List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scheduled threads
	 */
	public java.util.List<ScheduledThread> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the first scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread
	 * @throws NoSuchScheduledThreadException if a matching scheduled thread could not be found
	 */
	public ScheduledThread findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the last scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching scheduled thread, or <code>null</code> if a matching scheduled thread could not be found
	 */
	public ScheduledThread fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Returns the scheduled threads before and after the current scheduled thread in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param scheduledThreadId the primary key of the current scheduled thread
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread[] findByGroupAndCompany_PrevAndNext(
			long scheduledThreadId, long groupId, long companyId,
			OrderByComparator<ScheduledThread> orderByComparator)
		throws NoSuchScheduledThreadException;

	/**
	 * Removes all the scheduled threads where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of scheduled threads where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching scheduled threads
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the scheduled thread in the entity cache if it is enabled.
	 *
	 * @param scheduledThread the scheduled thread
	 */
	public void cacheResult(ScheduledThread scheduledThread);

	/**
	 * Caches the scheduled threads in the entity cache if it is enabled.
	 *
	 * @param scheduledThreads the scheduled threads
	 */
	public void cacheResult(java.util.List<ScheduledThread> scheduledThreads);

	/**
	 * Creates a new scheduled thread with the primary key. Does not add the scheduled thread to the database.
	 *
	 * @param scheduledThreadId the primary key for the new scheduled thread
	 * @return the new scheduled thread
	 */
	public ScheduledThread create(long scheduledThreadId);

	/**
	 * Removes the scheduled thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread that was removed
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread remove(long scheduledThreadId)
		throws NoSuchScheduledThreadException;

	public ScheduledThread updateImpl(ScheduledThread scheduledThread);

	/**
	 * Returns the scheduled thread with the primary key or throws a <code>NoSuchScheduledThreadException</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread
	 * @throws NoSuchScheduledThreadException if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread findByPrimaryKey(long scheduledThreadId)
		throws NoSuchScheduledThreadException;

	/**
	 * Returns the scheduled thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduledThreadId the primary key of the scheduled thread
	 * @return the scheduled thread, or <code>null</code> if a scheduled thread with the primary key could not be found
	 */
	public ScheduledThread fetchByPrimaryKey(long scheduledThreadId);

	/**
	 * Returns all the scheduled threads.
	 *
	 * @return the scheduled threads
	 */
	public java.util.List<ScheduledThread> findAll();

	/**
	 * Returns a range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @return the range of scheduled threads
	 */
	public java.util.List<ScheduledThread> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of scheduled threads
	 */
	@Deprecated
	public java.util.List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the scheduled threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ScheduledThreadModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scheduled threads
	 * @param end the upper bound of the range of scheduled threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scheduled threads
	 */
	public java.util.List<ScheduledThread> findAll(
		int start, int end,
		OrderByComparator<ScheduledThread> orderByComparator);

	/**
	 * Removes all the scheduled threads from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of scheduled threads.
	 *
	 * @return the number of scheduled threads
	 */
	public int countAll();

}