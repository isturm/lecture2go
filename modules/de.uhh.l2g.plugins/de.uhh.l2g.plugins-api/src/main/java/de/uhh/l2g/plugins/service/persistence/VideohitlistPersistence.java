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

import de.uhh.l2g.plugins.exception.NoSuchVideohitlistException;
import de.uhh.l2g.plugins.model.Videohitlist;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the videohitlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see VideohitlistUtil
 * @generated
 */
@ProviderType
public interface VideohitlistPersistence extends BasePersistence<Videohitlist> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideohitlistUtil} to access the videohitlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching videohitlists
	 */
	public java.util.List<Videohitlist> findByVideo(long videoId);

	/**
	 * Returns a range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Deprecated
	public java.util.List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the videohitlists where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByVideo_First(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the first videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByVideo_First(
		long videoId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByVideo_Last(
			long videoId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the last videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByVideo_Last(
		long videoId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where videoId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist[] findByVideo_PrevAndNext(
			long videohitlistId, long videoId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Removes all the videohitlists where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of videohitlists where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching videohitlists
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroup(long groupId);

	/**
	 * Returns a range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Deprecated
	public java.util.List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByGroup_First(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByGroup_First(
		long groupId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByGroup_Last(
			long groupId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByGroup_Last(
		long groupId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist[] findByGroup_PrevAndNext(
			long videohitlistId, long groupId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Removes all the videohitlists where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of videohitlists where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching videohitlists
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	public java.util.List<Videohitlist> findByCompany(long companyId);

	/**
	 * Returns a range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Deprecated
	public java.util.List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the videohitlists where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByCompany_First(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the first videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByCompany_First(
		long companyId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByCompany_Last(
			long companyId, OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the last videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByCompany_Last(
		long companyId, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist[] findByCompany_PrevAndNext(
			long videohitlistId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Removes all the videohitlists where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of videohitlists where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videohitlists
	 */
	@Deprecated
	public java.util.List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videohitlists
	 */
	public java.util.List<Videohitlist> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the first videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist
	 * @throws NoSuchVideohitlistException if a matching videohitlist could not be found
	 */
	public Videohitlist findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the last videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching videohitlist, or <code>null</code> if a matching videohitlist could not be found
	 */
	public Videohitlist fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Returns the videohitlists before and after the current videohitlist in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param videohitlistId the primary key of the current videohitlist
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist[] findByGroupAndCompany_PrevAndNext(
			long videohitlistId, long groupId, long companyId,
			OrderByComparator<Videohitlist> orderByComparator)
		throws NoSuchVideohitlistException;

	/**
	 * Removes all the videohitlists where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of videohitlists where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching videohitlists
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the videohitlist in the entity cache if it is enabled.
	 *
	 * @param videohitlist the videohitlist
	 */
	public void cacheResult(Videohitlist videohitlist);

	/**
	 * Caches the videohitlists in the entity cache if it is enabled.
	 *
	 * @param videohitlists the videohitlists
	 */
	public void cacheResult(java.util.List<Videohitlist> videohitlists);

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	public Videohitlist create(long videohitlistId);

	/**
	 * Removes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist remove(long videohitlistId)
		throws NoSuchVideohitlistException;

	public Videohitlist updateImpl(Videohitlist videohitlist);

	/**
	 * Returns the videohitlist with the primary key or throws a <code>NoSuchVideohitlistException</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws NoSuchVideohitlistException if a videohitlist with the primary key could not be found
	 */
	public Videohitlist findByPrimaryKey(long videohitlistId)
		throws NoSuchVideohitlistException;

	/**
	 * Returns the videohitlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist, or <code>null</code> if a videohitlist with the primary key could not be found
	 */
	public Videohitlist fetchByPrimaryKey(long videohitlistId);

	/**
	 * Returns all the videohitlists.
	 *
	 * @return the videohitlists
	 */
	public java.util.List<Videohitlist> findAll();

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 */
	public java.util.List<Videohitlist> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of videohitlists
	 */
	@Deprecated
	public java.util.List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videohitlists
	 */
	public java.util.List<Videohitlist> findAll(
		int start, int end, OrderByComparator<Videohitlist> orderByComparator);

	/**
	 * Removes all the videohitlists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
	 */
	public int countAll();

}