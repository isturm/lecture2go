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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchVideoStatisticException;
import de.uhh.l2g.plugins.model.VideoStatistic;

/**
 * The persistence interface for the video statistic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.persistence.impl.VideoStatisticPersistenceImpl
 * @see VideoStatisticUtil
 * @generated
 */
@ProviderType
public interface VideoStatisticPersistence extends BasePersistence<VideoStatistic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoStatisticUtil} to access the video statistic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId);

	/**
	* Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompanyIdAndGroupId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByCompanyIdAndGroupId_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByCompanyIdAndGroupId_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByCompanyIdAndGroupId_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByCompanyIdAndGroupId_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic[] findByCompanyIdAndGroupId_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	*/
	public void removeByCompanyIdAndGroupId(long groupId, long companyId);

	/**
	* Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public int countByCompanyIdAndGroupId(long groupId, long companyId);

	/**
	* Returns all the video statistics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroup(long groupId);

	/**
	* Returns a range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroup(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroup(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroup(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic[] findByGroup_PrevAndNext(long videoStatisticId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Removes all the video statistics where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroup(long groupId);

	/**
	* Returns the number of video statistics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching video statistics
	*/
	public int countByGroup(long groupId);

	/**
	* Returns all the video statistics where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompany(long companyId);

	/**
	* Returns a range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompany(long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompany(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns an ordered range of all the video statistics where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByCompany(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the first video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the last video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the last video statistic in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic[] findByCompany_PrevAndNext(long videoStatisticId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Removes all the video statistics where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompany(long companyId);

	/**
	* Returns the number of video statistics where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public int countByCompany(long companyId);

	/**
	* Returns all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId);

	/**
	* Returns a range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns an ordered range of all the video statistics where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching video statistics
	*/
	public java.util.List<VideoStatistic> findByGroupAndCompany(long groupId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByGroupAndCompany_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the first video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByGroupAndCompany_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic
	* @throws NoSuchVideoStatisticException if a matching video statistic could not be found
	*/
	public VideoStatistic findByGroupAndCompany_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the last video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video statistic, or <code>null</code> if a matching video statistic could not be found
	*/
	public VideoStatistic fetchByGroupAndCompany_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns the video statistics before and after the current video statistic in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param videoStatisticId the primary key of the current video statistic
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic[] findByGroupAndCompany_PrevAndNext(
		long videoStatisticId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator)
		throws NoSuchVideoStatisticException;

	/**
	* Removes all the video statistics where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	*/
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	* Returns the number of video statistics where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching video statistics
	*/
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	* Caches the video statistic in the entity cache if it is enabled.
	*
	* @param videoStatistic the video statistic
	*/
	public void cacheResult(VideoStatistic videoStatistic);

	/**
	* Caches the video statistics in the entity cache if it is enabled.
	*
	* @param videoStatistics the video statistics
	*/
	public void cacheResult(java.util.List<VideoStatistic> videoStatistics);

	/**
	* Creates a new video statistic with the primary key. Does not add the video statistic to the database.
	*
	* @param videoStatisticId the primary key for the new video statistic
	* @return the new video statistic
	*/
	public VideoStatistic create(long videoStatisticId);

	/**
	* Removes the video statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic that was removed
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic remove(long videoStatisticId)
		throws NoSuchVideoStatisticException;

	public VideoStatistic updateImpl(VideoStatistic videoStatistic);

	/**
	* Returns the video statistic with the primary key or throws a {@link NoSuchVideoStatisticException} if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic
	* @throws NoSuchVideoStatisticException if a video statistic with the primary key could not be found
	*/
	public VideoStatistic findByPrimaryKey(long videoStatisticId)
		throws NoSuchVideoStatisticException;

	/**
	* Returns the video statistic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoStatisticId the primary key of the video statistic
	* @return the video statistic, or <code>null</code> if a video statistic with the primary key could not be found
	*/
	public VideoStatistic fetchByPrimaryKey(long videoStatisticId);

	@Override
	public java.util.Map<java.io.Serializable, VideoStatistic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the video statistics.
	*
	* @return the video statistics
	*/
	public java.util.List<VideoStatistic> findAll();

	/**
	* Returns a range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @return the range of video statistics
	*/
	public java.util.List<VideoStatistic> findAll(int start, int end);

	/**
	* Returns an ordered range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video statistics
	*/
	public java.util.List<VideoStatistic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator);

	/**
	* Returns an ordered range of all the video statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VideoStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of video statistics
	* @param end the upper bound of the range of video statistics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of video statistics
	*/
	public java.util.List<VideoStatistic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoStatistic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the video statistics from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of video statistics.
	*
	* @return the number of video statistics
	*/
	public int countAll();
}