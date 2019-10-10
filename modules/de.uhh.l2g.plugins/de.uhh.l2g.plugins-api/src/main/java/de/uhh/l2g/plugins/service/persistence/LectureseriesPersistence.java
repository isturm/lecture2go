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

import de.uhh.l2g.plugins.exception.NoSuchLectureseriesException;
import de.uhh.l2g.plugins.model.Lectureseries;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesUtil
 * @generated
 */
@ProviderType
public interface LectureseriesPersistence
	extends BasePersistence<Lectureseries> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LectureseriesUtil} to access the lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByTerm(long termId);

	/**
	 * Returns a range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByTerm(
		long termId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByTerm(long, int, int, OrderByComparator)}
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByTerm_First(
			long termId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByTerm_First(
		long termId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByTerm_Last(
			long termId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByTerm_Last(
		long termId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByTerm_PrevAndNext(
			long lectureseriesId, long termId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	public void removeByTerm(long termId);

	/**
	 * Returns the number of lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching lectureserieses
	 */
	public int countByTerm(long termId);

	/**
	 * Returns all the lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLanguage(String language);

	/**
	 * Returns a range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLanguage(
		String language, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLanguage(String, int, int, OrderByComparator)}
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByLanguage(
		String language, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLanguage(
		String language, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLanguage_First(
			String language, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLanguage_First(
		String language, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLanguage_Last(
			String language, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLanguage_Last(
		String language, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where language = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByLanguage_PrevAndNext(
			long lectureseriesId, String language,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where language = &#63; from the database.
	 *
	 * @param language the language
	 */
	public void removeByLanguage(String language);

	/**
	 * Returns the number of lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the number of matching lectureserieses
	 */
	public int countByLanguage(String language);

	/**
	 * Returns all the lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByNumber(String number);

	/**
	 * Returns a range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByNumber(
		String number, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByNumber(String, int, int, OrderByComparator)}
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByNumber(
		String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where number = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param number the number
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByNumber(
		String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByNumber_First(
			String number, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByNumber_First(
		String number, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByNumber_Last(
			String number, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByNumber_Last(
		String number, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where number = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByNumber_PrevAndNext(
			long lectureseriesId, String number,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where number = &#63; from the database.
	 *
	 * @param number the number
	 */
	public void removeByNumber(String number);

	/**
	 * Returns the number of lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the number of matching lectureserieses
	 */
	public int countByNumber(String number);

	/**
	 * Returns all the lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByType(String eventType);

	/**
	 * Returns a range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByType(
		String eventType, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByType(String, int, int, OrderByComparator)}
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByType(
		String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByType(
		String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByType_First(
			String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByType_First(
		String eventType, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByType_Last(
			String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByType_Last(
		String eventType, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByType_PrevAndNext(
			long lectureseriesId, String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public void removeByType(String eventType);

	/**
	 * Returns the number of lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching lectureserieses
	 */
	public int countByType(String eventType);

	/**
	 * Returns all the lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCategory(long categoryId);

	/**
	 * Returns a range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCategory(
		long categoryId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCategory(long, int, int, OrderByComparator)}
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByCategory_First(
			long categoryId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByCategory_First(
		long categoryId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByCategory_Last(
			long categoryId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByCategory_Last(
		long categoryId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByCategory_PrevAndNext(
			long lectureseriesId, long categoryId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategory(long categoryId);

	/**
	 * Returns the number of lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching lectureserieses
	 */
	public int countByCategory(long categoryId);

	/**
	 * Returns all the lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByName(String name);

	/**
	 * Returns a range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByName(String, int, int, OrderByComparator)}
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByName(
		String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByName(
		String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByName_First(
			String name, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByName_First(
		String name, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByName_Last(
			String name, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByName_Last(
		String name, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where name = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByName_PrevAndNext(
			long lectureseriesId, String name,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching lectureserieses
	 */
	public int countByName(String name);

	/**
	 * Returns all the lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByFaculty(String facultyName);

	/**
	 * Returns a range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByFaculty(
		String facultyName, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFaculty(String, int, int, OrderByComparator)}
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByFaculty(
		String facultyName, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where facultyName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyName the faculty name
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByFaculty(
		String facultyName, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByFaculty_First(
			String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByFaculty_First(
		String facultyName, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByFaculty_Last(
			String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByFaculty_Last(
		String facultyName, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByFaculty_PrevAndNext(
			long lectureseriesId, String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where facultyName = &#63; from the database.
	 *
	 * @param facultyName the faculty name
	 */
	public void removeByFaculty(String facultyName);

	/**
	 * Returns the number of lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the number of matching lectureserieses
	 */
	public int countByFaculty(String facultyName);

	/**
	 * Returns all the lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByApproved(int approved);

	/**
	 * Returns a range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByApproved(
		int approved, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByApproved(int, int, int, OrderByComparator)}
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByApproved(
		int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByApproved(
		int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByApproved_First(
			int approved, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByApproved_First(
		int approved, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByApproved_Last(
			int approved, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByApproved_Last(
		int approved, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByApproved_PrevAndNext(
			long lectureseriesId, int approved,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	public void removeByApproved(int approved);

	/**
	 * Returns the number of lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching lectureserieses
	 */
	public int countByApproved(int approved);

	/**
	 * Returns all the lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByPassword(String password);

	/**
	 * Returns a range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByPassword(
		String password, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByPassword(String, int, int, OrderByComparator)}
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByPassword(
		String password, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where password = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param password the password
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByPassword(
		String password, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByPassword_First(
			String password, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByPassword_First(
		String password, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByPassword_Last(
			String password, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByPassword_Last(
		String password, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where password = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByPassword_PrevAndNext(
			long lectureseriesId, String password,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	public void removeByPassword(String password);

	/**
	 * Returns the number of lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching lectureserieses
	 */
	public int countByPassword(String password);

	/**
	 * Returns all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId);

	/**
	 * Returns a range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLatestOpenAccessVideo(long, int, int, OrderByComparator)}
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestOpenAccessVideo_First(
			long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestOpenAccessVideo_Last(
			long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByLatestOpenAccessVideo_PrevAndNext(
			long lectureseriesId, long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where latestOpenAccessVideoId = &#63; from the database.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 */
	public void removeByLatestOpenAccessVideo(long latestOpenAccessVideoId);

	/**
	 * Returns the number of lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the number of matching lectureserieses
	 */
	public int countByLatestOpenAccessVideo(long latestOpenAccessVideoId);

	/**
	 * Returns all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate);

	/**
	 * Returns a range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLatestVideoUploadDate(Date, int, int, OrderByComparator)}
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestVideoUploadDate_First(
			Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestVideoUploadDate_First(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestVideoUploadDate_Last(
			Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestVideoUploadDate_Last(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByLatestVideoUploadDate_PrevAndNext(
			long lectureseriesId, Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where latestVideoUploadDate = &#63; from the database.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 */
	public void removeByLatestVideoUploadDate(Date latestVideoUploadDate);

	/**
	 * Returns the number of lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the number of matching lectureserieses
	 */
	public int countByLatestVideoUploadDate(Date latestVideoUploadDate);

	/**
	 * Returns all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate);

	/**
	 * Returns a range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLatestVideoGenerationDate(String, int, int, OrderByComparator)}
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestVideoGenerationDate_First(
			String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestVideoGenerationDate_First(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByLatestVideoGenerationDate_Last(
			String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByLatestVideoGenerationDate_Last(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByLatestVideoGenerationDate_PrevAndNext(
			long lectureseriesId, String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where latestVideoGenerationDate = &#63; from the database.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 */
	public void removeByLatestVideoGenerationDate(
		String latestVideoGenerationDate);

	/**
	 * Returns the number of lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the number of matching lectureserieses
	 */
	public int countByLatestVideoGenerationDate(
		String latestVideoGenerationDate);

	/**
	 * Returns all the lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByUSID(String USID);

	/**
	 * Returns a range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByUSID(
		String USID, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUSID(String, int, int, OrderByComparator)}
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByUSID(
		String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where USID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USID the usid
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByUSID(
		String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByUSID_First(
			String USID, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByUSID_First(
		String USID, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByUSID_Last(
			String USID, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByUSID_Last(
		String USID, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByUSID_PrevAndNext(
			long lectureseriesId, String USID,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where USID = &#63; from the database.
	 *
	 * @param USID the usid
	 */
	public void removeByUSID(String USID);

	/**
	 * Returns the number of lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the number of matching lectureserieses
	 */
	public int countByUSID(String USID);

	/**
	 * Returns all the lectureserieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroup(long groupId);

	/**
	 * Returns a range of all the lectureserieses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByGroup_First(
			long groupId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByGroup_First(
		long groupId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByGroup_Last(
			long groupId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByGroup_Last(
		long groupId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByGroup_PrevAndNext(
			long lectureseriesId, long groupId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of lectureserieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lectureserieses
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the lectureserieses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCompany(long companyId);

	/**
	 * Returns a range of all the lectureserieses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByCompany_First(
			long companyId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByCompany_First(
		long companyId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByCompany_Last(
			long companyId, OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByCompany_Last(
		long companyId, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByCompany_PrevAndNext(
			long lectureseriesId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of lectureserieses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lectureserieses
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureserieses
	 */
	public java.util.List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public Lectureseries findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public Lectureseries fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries[] findByGroupAndCompany_PrevAndNext(
			long lectureseriesId, long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws NoSuchLectureseriesException;

	/**
	 * Removes all the lectureserieses where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching lectureserieses
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the lectureseries in the entity cache if it is enabled.
	 *
	 * @param lectureseries the lectureseries
	 */
	public void cacheResult(Lectureseries lectureseries);

	/**
	 * Caches the lectureserieses in the entity cache if it is enabled.
	 *
	 * @param lectureserieses the lectureserieses
	 */
	public void cacheResult(java.util.List<Lectureseries> lectureserieses);

	/**
	 * Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	 *
	 * @param lectureseriesId the primary key for the new lectureseries
	 * @return the new lectureseries
	 */
	public Lectureseries create(long lectureseriesId);

	/**
	 * Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries remove(long lectureseriesId)
		throws NoSuchLectureseriesException;

	public Lectureseries updateImpl(Lectureseries lectureseries);

	/**
	 * Returns the lectureseries with the primary key or throws a <code>NoSuchLectureseriesException</code> if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public Lectureseries findByPrimaryKey(long lectureseriesId)
		throws NoSuchLectureseriesException;

	/**
	 * Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	 */
	public Lectureseries fetchByPrimaryKey(long lectureseriesId);

	/**
	 * Returns all the lectureserieses.
	 *
	 * @return the lectureserieses
	 */
	public java.util.List<Lectureseries> findAll();

	/**
	 * Returns a range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of lectureserieses
	 */
	public java.util.List<Lectureseries> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectureserieses
	 */
	@Deprecated
	public java.util.List<Lectureseries> findAll(
		int start, int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureserieses
	 */
	public java.util.List<Lectureseries> findAll(
		int start, int end, OrderByComparator<Lectureseries> orderByComparator);

	/**
	 * Removes all the lectureserieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lectureserieses.
	 *
	 * @return the number of lectureserieses
	 */
	public int countAll();

}