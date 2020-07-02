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

import de.uhh.l2g.plugins.exception.NoSuchProducer_LectureseriesException;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the producer_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesUtil
 * @generated
 */
@ProviderType
public interface Producer_LectureseriesPersistence
	extends BasePersistence<Producer_Lectureseries> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Producer_LectureseriesUtil} to access the producer_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId);

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByLectureseriesId_First(
			long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByLectureseriesId_First(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByLectureseriesId_Last(
			long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByLectureseriesId_Last(
		long lectureseriesId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries[] findByLectureseriesId_PrevAndNext(
			long producerLectureseriesId, long lectureseriesId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public void removeByLectureseriesId(long lectureseriesId);

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public int countByLectureseriesId(long lectureseriesId);

	/**
	 * Returns all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByProducerId(
		long producerId);

	/**
	 * Returns a range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByProducerId_First(
			long producerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByProducerId_First(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByProducerId_Last(
			long producerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByProducerId_Last(
		long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries[] findByProducerId_PrevAndNext(
			long producerLectureseriesId, long producerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	public void removeByProducerId(long producerId);

	/**
	 * Returns the number of producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public int countByProducerId(long producerId);

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId);

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_First(
			long lectureseriesId, long producerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_Last(
			long lectureseriesId, long producerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries[]
			findByLectureseriesIdAndProducerId_PrevAndNext(
				long producerLectureseriesId, long lectureseriesId,
				long producerId,
				com.liferay.portal.kernel.util.OrderByComparator
					<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 */
	public void removeByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId);

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public int countByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId);

	/**
	 * Caches the producer_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 */
	public void cacheResult(Producer_Lectureseries producer_Lectureseries);

	/**
	 * Caches the producer_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureserieses the producer_ lectureserieses
	 */
	public void cacheResult(
		java.util.List<Producer_Lectureseries> producer_Lectureserieses);

	/**
	 * Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	 *
	 * @param producerLectureseriesId the primary key for the new producer_ lectureseries
	 * @return the new producer_ lectureseries
	 */
	public Producer_Lectureseries create(long producerLectureseriesId);

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries remove(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException;

	public Producer_Lectureseries updateImpl(
		Producer_Lectureseries producer_Lectureseries);

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a <code>NoSuchProducer_LectureseriesException</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries findByPrimaryKey(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException;

	/**
	 * Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	 */
	public Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId);

	/**
	 * Returns all the producer_ lectureserieses.
	 *
	 * @return the producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findAll();

	/**
	 * Returns a range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producer_ lectureserieses
	 */
	public java.util.List<Producer_Lectureseries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer_Lectureseries>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the producer_ lectureserieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of producer_ lectureserieses.
	 *
	 * @return the number of producer_ lectureserieses
	 */
	public int countAll();

}