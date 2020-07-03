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

import de.uhh.l2g.plugins.exception.NoSuchLectureseries_InstitutionException;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lectureseries_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_InstitutionUtil
 * @generated
 */
@ProviderType
public interface Lectureseries_InstitutionPersistence
	extends BasePersistence<Lectureseries_Institution> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lectureseries_InstitutionUtil} to access the lectureseries_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId);

	/**
	 * Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByLectureseriesId_First(
			long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByLectureseriesId_Last(
			long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution[] findByLectureseriesId_PrevAndNext(
			long lectureseriesInstitutionId, long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Removes all the lectureseries_ institutions where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public void removeByLectureseriesId(long lectureseriesId);

	/**
	 * Returns the number of lectureseries_ institutions where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ institutions
	 */
	public int countByLectureseriesId(long lectureseriesId);

	/**
	 * Returns all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionId(
		long institutionId);

	/**
	 * Returns a range of all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionId(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByInstitutionId_First(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByInstitutionId_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByInstitutionId_Last(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByInstitutionId_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution[] findByInstitutionId_PrevAndNext(
			long lectureseriesInstitutionId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Removes all the lectureseries_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public void removeByInstitutionId(long institutionId);

	/**
	 * Returns the number of lectureseries_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching lectureseries_ institutions
	 */
	public int countByInstitutionId(long institutionId);

	/**
	 * Returns all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @return the matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution>
		findByLectureseriesIdAndInstitutionId(
			long lectureseriesId, long institutionId);

	/**
	 * Returns a range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution>
		findByLectureseriesIdAndInstitutionId(
			long lectureseriesId, long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution>
		findByLectureseriesIdAndInstitutionId(
			long lectureseriesId, long institutionId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution>
		findByLectureseriesIdAndInstitutionId(
			long lectureseriesId, long institutionId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution
			findByLectureseriesIdAndInstitutionId_First(
				long lectureseriesId, long institutionId,
				com.liferay.portal.kernel.util.OrderByComparator
					<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the first lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution
		fetchByLectureseriesIdAndInstitutionId_First(
			long lectureseriesId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByLectureseriesIdAndInstitutionId_Last(
			long lectureseriesId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the last lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution
		fetchByLectureseriesIdAndInstitutionId_Last(
			long lectureseriesId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution[]
			findByLectureseriesIdAndInstitutionId_PrevAndNext(
				long lectureseriesInstitutionId, long lectureseriesId,
				long institutionId,
				com.liferay.portal.kernel.util.OrderByComparator
					<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Removes all the lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 */
	public void removeByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId);

	/**
	 * Returns the number of lectureseries_ institutions where lectureseriesId = &#63; and institutionId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param institutionId the institution ID
	 * @return the number of matching lectureseries_ institutions
	 */
	public int countByLectureseriesIdAndInstitutionId(
		long lectureseriesId, long institutionId);

	/**
	 * Returns all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId);

	/**
	 * Returns a range of all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByInstitutionParentId_First(
			long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the first lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByInstitutionParentId_First(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution findByInstitutionParentId_Last(
			long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the last lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ institution, or <code>null</code> if a matching lectureseries_ institution could not be found
	 */
	public Lectureseries_Institution fetchByInstitutionParentId_Last(
		long institutionParentId,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns the lectureseries_ institutions before and after the current lectureseries_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param lectureseriesInstitutionId the primary key of the current lectureseries_ institution
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution[] findByInstitutionParentId_PrevAndNext(
			long lectureseriesInstitutionId, long institutionParentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Lectureseries_Institution> orderByComparator)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Removes all the lectureseries_ institutions where institutionParentId = &#63; from the database.
	 *
	 * @param institutionParentId the institution parent ID
	 */
	public void removeByInstitutionParentId(long institutionParentId);

	/**
	 * Returns the number of lectureseries_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the number of matching lectureseries_ institutions
	 */
	public int countByInstitutionParentId(long institutionParentId);

	/**
	 * Caches the lectureseries_ institution in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Institution the lectureseries_ institution
	 */
	public void cacheResult(
		Lectureseries_Institution lectureseries_Institution);

	/**
	 * Caches the lectureseries_ institutions in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Institutions the lectureseries_ institutions
	 */
	public void cacheResult(
		java.util.List<Lectureseries_Institution> lectureseries_Institutions);

	/**
	 * Creates a new lectureseries_ institution with the primary key. Does not add the lectureseries_ institution to the database.
	 *
	 * @param lectureseriesInstitutionId the primary key for the new lectureseries_ institution
	 * @return the new lectureseries_ institution
	 */
	public Lectureseries_Institution create(long lectureseriesInstitutionId);

	/**
	 * Removes the lectureseries_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution that was removed
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution remove(long lectureseriesInstitutionId)
		throws NoSuchLectureseries_InstitutionException;

	public Lectureseries_Institution updateImpl(
		Lectureseries_Institution lectureseries_Institution);

	/**
	 * Returns the lectureseries_ institution with the primary key or throws a <code>NoSuchLectureseries_InstitutionException</code> if it could not be found.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution
	 * @throws NoSuchLectureseries_InstitutionException if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution findByPrimaryKey(
			long lectureseriesInstitutionId)
		throws NoSuchLectureseries_InstitutionException;

	/**
	 * Returns the lectureseries_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesInstitutionId the primary key of the lectureseries_ institution
	 * @return the lectureseries_ institution, or <code>null</code> if a lectureseries_ institution with the primary key could not be found
	 */
	public Lectureseries_Institution fetchByPrimaryKey(
		long lectureseriesInstitutionId);

	/**
	 * Returns all the lectureseries_ institutions.
	 *
	 * @return the lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findAll();

	/**
	 * Returns a range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @return the range of lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator);

	/**
	 * Returns an ordered range of all the lectureseries_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ institutions
	 * @param end the upper bound of the range of lectureseries_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectureseries_ institutions
	 */
	public java.util.List<Lectureseries_Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Lectureseries_Institution> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lectureseries_ institutions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lectureseries_ institutions.
	 *
	 * @return the number of lectureseries_ institutions
	 */
	public int countAll();

}