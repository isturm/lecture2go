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

import de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException;
import de.uhh.l2g.plugins.model.Video_Institution;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_InstitutionUtil
 * @generated
 */
@ProviderType
public interface Video_InstitutionPersistence
	extends BasePersistence<Video_Institution> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Video_InstitutionUtil} to access the video_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideo(long videoId);

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideo(
		long videoId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideo(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByVideo_First(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByVideo_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByVideo_Last(
			long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByVideo_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution[] findByVideo_PrevAndNext(
			long videoInstitutionId, long videoId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Removes all the video_ institutions where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	public void removeByVideo(long videoId);

	/**
	 * Returns the number of video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ institutions
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns all the video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitution(
		long institutionId);

	/**
	 * Returns a range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitution(
		long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByInstitution_First(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByInstitution_Last(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution[] findByInstitution_PrevAndNext(
			long videoInstitutionId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Removes all the video_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public void removeByInstitution(long institutionId);

	/**
	 * Returns the number of video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	public int countByInstitution(long institutionId);

	/**
	 * Returns all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId);

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByVideoInstitution(
		long videoId, long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByVideoInstitution_First(
			long videoId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByVideoInstitution_First(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByVideoInstitution_Last(
			long videoId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByVideoInstitution_Last(
		long videoId, long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution[] findByVideoInstitution_PrevAndNext(
			long videoInstitutionId, long videoId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Removes all the video_ institutions where videoId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 */
	public void removeByVideoInstitution(long videoId, long institutionId);

	/**
	 * Returns the number of video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	public int countByVideoInstitution(long videoId, long institutionId);

	/**
	 * Returns all the video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitutionParentId(
		long institutionParentId);

	/**
	 * Returns a range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end);

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	public java.util.List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByInstitutionParentId_First(
			long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByInstitutionParentId_First(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	public Video_Institution findByInstitutionParentId_Last(
			long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	public Video_Institution fetchByInstitutionParentId_Last(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution[] findByInstitutionParentId_PrevAndNext(
			long videoInstitutionId, long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
				orderByComparator)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Removes all the video_ institutions where institutionParentId = &#63; from the database.
	 *
	 * @param institutionParentId the institution parent ID
	 */
	public void removeByInstitutionParentId(long institutionParentId);

	/**
	 * Returns the number of video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the number of matching video_ institutions
	 */
	public int countByInstitutionParentId(long institutionParentId);

	/**
	 * Caches the video_ institution in the entity cache if it is enabled.
	 *
	 * @param video_Institution the video_ institution
	 */
	public void cacheResult(Video_Institution video_Institution);

	/**
	 * Caches the video_ institutions in the entity cache if it is enabled.
	 *
	 * @param video_Institutions the video_ institutions
	 */
	public void cacheResult(
		java.util.List<Video_Institution> video_Institutions);

	/**
	 * Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	 *
	 * @param videoInstitutionId the primary key for the new video_ institution
	 * @return the new video_ institution
	 */
	public Video_Institution create(long videoInstitutionId);

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution remove(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException;

	public Video_Institution updateImpl(Video_Institution video_Institution);

	/**
	 * Returns the video_ institution with the primary key or throws a <code>NoSuchVideo_InstitutionException</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	public Video_Institution findByPrimaryKey(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException;

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 */
	public Video_Institution fetchByPrimaryKey(long videoInstitutionId);

	/**
	 * Returns all the video_ institutions.
	 *
	 * @return the video_ institutions
	 */
	public java.util.List<Video_Institution> findAll();

	/**
	 * Returns a range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of video_ institutions
	 */
	public java.util.List<Video_Institution> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ institutions
	 */
	public java.util.List<Video_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ institutions
	 */
	public java.util.List<Video_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video_Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video_ institutions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video_ institutions.
	 *
	 * @return the number of video_ institutions
	 */
	public int countAll();

}