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

import de.uhh.l2g.plugins.exception.NoSuchStatisticException;
import de.uhh.l2g.plugins.model.Statistic;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticUtil
 * @generated
 */
@ProviderType
public interface StatisticPersistence extends BasePersistence<Statistic> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatisticUtil} to access the statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the statistic where statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByStatisticId(long statisticId)
		throws NoSuchStatisticException;

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByStatisticId(long statisticId);

	/**
	 * Returns the statistic where statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByStatisticId(
		long statisticId, boolean useFinderCache);

	/**
	 * Removes the statistic where statisticId = &#63; from the database.
	 *
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	public Statistic removeByStatisticId(long statisticId)
		throws NoSuchStatisticException;

	/**
	 * Returns the number of statistics where statisticId = &#63;.
	 *
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	public int countByStatisticId(long statisticId);

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByC_G_S(long companyId, long groupId, long statisticId)
		throws NoSuchStatisticException;

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId);

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByC_G_S(
		long companyId, long groupId, long statisticId, boolean useFinderCache);

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and statisticId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the statistic that was removed
	 */
	public Statistic removeByC_G_S(
			long companyId, long groupId, long statisticId)
		throws NoSuchStatisticException;

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and statisticId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param statisticId the statistic ID
	 * @return the number of matching statistics
	 */
	public int countByC_G_S(long companyId, long groupId, long statisticId);

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByC_G_D(long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException;

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate);

	/**
	 * Returns the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByC_G_D(
		long companyId, long groupId, Date createDate, boolean useFinderCache);

	/**
	 * Removes the statistic where companyId = &#63; and groupId = &#63; and createDate = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the statistic that was removed
	 */
	public Statistic removeByC_G_D(
			long companyId, long groupId, Date createDate)
		throws NoSuchStatisticException;

	/**
	 * Returns the number of statistics where companyId = &#63; and groupId = &#63; and createDate = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param createDate the create date
	 * @return the number of matching statistics
	 */
	public int countByC_G_D(long companyId, long groupId, Date createDate);

	/**
	 * Returns all the statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching statistics
	 */
	public java.util.List<Statistic> findByGroup(long groupId);

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
	public java.util.List<Statistic> findByGroup(
		long groupId, int start, int end);

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
	public java.util.List<Statistic> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

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
	public java.util.List<Statistic> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where groupId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public Statistic[] findByGroup_PrevAndNext(
			long statisticId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Removes all the statistics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of statistics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching statistics
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	public java.util.List<Statistic> findByCompany(long companyId);

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
	public java.util.List<Statistic> findByCompany(
		long companyId, int start, int end);

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
	public java.util.List<Statistic> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

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
	public java.util.List<Statistic> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the first statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the last statistic in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

	/**
	 * Returns the statistics before and after the current statistic in the ordered set where companyId = &#63;.
	 *
	 * @param statisticId the primary key of the current statistic
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public Statistic[] findByCompany_PrevAndNext(
			long statisticId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Removes all the statistics where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of statistics where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching statistics
	 */
	public java.util.List<Statistic> findByGroupAndCompany(
		long groupId, long companyId);

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
	public java.util.List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

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
	public java.util.List<Statistic> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the first statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic
	 * @throws NoSuchStatisticException if a matching statistic could not be found
	 */
	public Statistic findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Returns the last statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching statistic, or <code>null</code> if a matching statistic could not be found
	 */
	public Statistic fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

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
	public Statistic[] findByGroupAndCompany_PrevAndNext(
			long statisticId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Statistic>
				orderByComparator)
		throws NoSuchStatisticException;

	/**
	 * Removes all the statistics where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of statistics where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching statistics
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the statistic in the entity cache if it is enabled.
	 *
	 * @param statistic the statistic
	 */
	public void cacheResult(Statistic statistic);

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	public void cacheResult(java.util.List<Statistic> statistics);

	/**
	 * Creates a new statistic with the primary key. Does not add the statistic to the database.
	 *
	 * @param statisticId the primary key for the new statistic
	 * @return the new statistic
	 */
	public Statistic create(long statisticId);

	/**
	 * Removes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public Statistic remove(long statisticId) throws NoSuchStatisticException;

	public Statistic updateImpl(Statistic statistic);

	/**
	 * Returns the statistic with the primary key or throws a <code>NoSuchStatisticException</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic
	 * @throws NoSuchStatisticException if a statistic with the primary key could not be found
	 */
	public Statistic findByPrimaryKey(long statisticId)
		throws NoSuchStatisticException;

	/**
	 * Returns the statistic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic, or <code>null</code> if a statistic with the primary key could not be found
	 */
	public Statistic fetchByPrimaryKey(long statisticId);

	/**
	 * Returns all the statistics.
	 *
	 * @return the statistics
	 */
	public java.util.List<Statistic> findAll();

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
	public java.util.List<Statistic> findAll(int start, int end);

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
	public java.util.List<Statistic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator);

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
	public java.util.List<Statistic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Statistic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the statistics from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of statistics.
	 *
	 * @return the number of statistics
	 */
	public int countAll();

}