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

import de.uhh.l2g.plugins.exception.NoSuchLastvideolistException;
import de.uhh.l2g.plugins.model.Lastvideolist;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lastvideolist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistUtil
 * @generated
 */
@ProviderType
public interface LastvideolistPersistence
	extends BasePersistence<Lastvideolist> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LastvideolistUtil} to access the lastvideolist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByVideo(long videoId);

	/**
	 * Returns a range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lastvideolists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByVideo_First(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the first lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByVideo_Last(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the last lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where videoId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist[] findByVideo_PrevAndNext(
			int lastvideolistId, long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Removes all the lastvideolists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of lastvideolists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching lastvideolists
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroup(long groupId);

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist[] findByGroup_PrevAndNext(
			int lastvideolistId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Removes all the lastvideolists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of lastvideolists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lastvideolists
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByCompany(long companyId);

	/**
	 * Returns a range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lastvideolists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the first lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the last lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist[] findByCompany_PrevAndNext(
			int lastvideolistId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Removes all the lastvideolists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of lastvideolists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lastvideolists
	 */
	public java.util.List<Lastvideolist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the first lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist
	 * @throws NoSuchLastvideolistException if a matching lastvideolist could not be found
	 */
	public Lastvideolist findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the last lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lastvideolist, or <code>null</code> if a matching lastvideolist could not be found
	 */
	public Lastvideolist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns the lastvideolists before and after the current lastvideolist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param lastvideolistId the primary key of the current lastvideolist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist[] findByGroupAndCompany_PrevAndNext(
			int lastvideolistId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
				orderByComparator)
		throws NoSuchLastvideolistException;

	/**
	 * Removes all the lastvideolists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of lastvideolists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching lastvideolists
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the lastvideolist in the entity cache if it is enabled.
	 *
	 * @param lastvideolist the lastvideolist
	 */
	public void cacheResult(Lastvideolist lastvideolist);

	/**
	 * Caches the lastvideolists in the entity cache if it is enabled.
	 *
	 * @param lastvideolists the lastvideolists
	 */
	public void cacheResult(java.util.List<Lastvideolist> lastvideolists);

	/**
	 * Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	 *
	 * @param lastvideolistId the primary key for the new lastvideolist
	 * @return the new lastvideolist
	 */
	public Lastvideolist create(int lastvideolistId);

	/**
	 * Removes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist that was removed
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist remove(int lastvideolistId)
		throws NoSuchLastvideolistException;

	public Lastvideolist updateImpl(Lastvideolist lastvideolist);

	/**
	 * Returns the lastvideolist with the primary key or throws a <code>NoSuchLastvideolistException</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist
	 * @throws NoSuchLastvideolistException if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist findByPrimaryKey(int lastvideolistId)
		throws NoSuchLastvideolistException;

	/**
	 * Returns the lastvideolist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lastvideolistId the primary key of the lastvideolist
	 * @return the lastvideolist, or <code>null</code> if a lastvideolist with the primary key could not be found
	 */
	public Lastvideolist fetchByPrimaryKey(int lastvideolistId);

	/**
	 * Returns all the lastvideolists.
	 *
	 * @return the lastvideolists
	 */
	public java.util.List<Lastvideolist> findAll();

	/**
	 * Returns a range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @return the range of lastvideolists
	 */
	public java.util.List<Lastvideolist> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lastvideolists
	 */
	public java.util.List<Lastvideolist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lastvideolists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LastvideolistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lastvideolists
	 * @param end the upper bound of the range of lastvideolists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lastvideolists
	 */
	public java.util.List<Lastvideolist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lastvideolist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lastvideolists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lastvideolists.
	 *
	 * @return the number of lastvideolists
	 */
	public int countAll();

}