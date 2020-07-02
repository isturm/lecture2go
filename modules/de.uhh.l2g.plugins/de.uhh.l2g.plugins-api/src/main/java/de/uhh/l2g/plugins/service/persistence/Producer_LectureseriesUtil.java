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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Producer_Lectureseries;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the producer_ lectureseries service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Producer_LectureseriesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_LectureseriesPersistence
 * @generated
 */
public class Producer_LectureseriesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		Producer_Lectureseries producer_Lectureseries) {

		getPersistence().clearCache(producer_Lectureseries);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Producer_Lectureseries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Producer_Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Producer_Lectureseries update(
		Producer_Lectureseries producer_Lectureseries) {

		return getPersistence().update(producer_Lectureseries);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Producer_Lectureseries update(
		Producer_Lectureseries producer_Lectureseries,
		ServiceContext serviceContext) {

		return getPersistence().update(producer_Lectureseries, serviceContext);
	}

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching producer_ lectureserieses
	 */
	public static List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId) {

		return getPersistence().findByLectureseriesId(lectureseriesId);
	}

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
	public static List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end) {

		return getPersistence().findByLectureseriesId(
			lectureseriesId, start, end);
	}

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
	public static List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().findByLectureseriesId(
			lectureseriesId, start, end, orderByComparator);
	}

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
	public static List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLectureseriesId(
			lectureseriesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries findByLectureseriesId_First(
			long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesId_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries fetchByLectureseriesId_First(
		long lectureseriesId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByLectureseriesId_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries findByLectureseriesId_Last(
			long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesId_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries fetchByLectureseriesId_Last(
		long lectureseriesId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByLectureseriesId_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public static Producer_Lectureseries[] findByLectureseriesId_PrevAndNext(
			long producerLectureseriesId, long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesId_PrevAndNext(
			producerLectureseriesId, lectureseriesId, orderByComparator);
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public static void removeByLectureseriesId(long lectureseriesId) {
		getPersistence().removeByLectureseriesId(lectureseriesId);
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public static int countByLectureseriesId(long lectureseriesId) {
		return getPersistence().countByLectureseriesId(lectureseriesId);
	}

	/**
	 * Returns all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	public static List<Producer_Lectureseries> findByProducerId(
		long producerId) {

		return getPersistence().findByProducerId(producerId);
	}

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
	public static List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end) {

		return getPersistence().findByProducerId(producerId, start, end);
	}

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
	public static List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().findByProducerId(
			producerId, start, end, orderByComparator);
	}

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
	public static List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProducerId(
			producerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries findByProducerId_First(
			long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByProducerId_First(
			producerId, orderByComparator);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries fetchByProducerId_First(
		long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByProducerId_First(
			producerId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries findByProducerId_Last(
			long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByProducerId_Last(
			producerId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries fetchByProducerId_Last(
		long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByProducerId_Last(
			producerId, orderByComparator);
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public static Producer_Lectureseries[] findByProducerId_PrevAndNext(
			long producerLectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByProducerId_PrevAndNext(
			producerLectureseriesId, producerId, orderByComparator);
	}

	/**
	 * Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	public static void removeByProducerId(long producerId) {
		getPersistence().removeByProducerId(producerId);
	}

	/**
	 * Returns the number of producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public static int countByProducerId(long producerId) {
		return getPersistence().countByProducerId(producerId);
	}

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	public static List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId) {

		return getPersistence().findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId);
	}

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
	public static List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end) {

		return getPersistence().findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, start, end);
	}

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
	public static List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end,
			OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, start, end, orderByComparator);
	}

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
	public static List<Producer_Lectureseries>
		findByLectureseriesIdAndProducerId(
			long lectureseriesId, long producerId, int start, int end,
			OrderByComparator<Producer_Lectureseries> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries
			findByLectureseriesIdAndProducerId_First(
				long lectureseriesId, long producerId,
				OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesIdAndProducerId_First(
			lectureseriesId, producerId, orderByComparator);
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries
		fetchByLectureseriesIdAndProducerId_First(
			long lectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByLectureseriesIdAndProducerId_First(
			lectureseriesId, producerId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries
			findByLectureseriesIdAndProducerId_Last(
				long lectureseriesId, long producerId,
				OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesIdAndProducerId_Last(
			lectureseriesId, producerId, orderByComparator);
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	public static Producer_Lectureseries
		fetchByLectureseriesIdAndProducerId_Last(
			long lectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().fetchByLectureseriesIdAndProducerId_Last(
			lectureseriesId, producerId, orderByComparator);
	}

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
	public static Producer_Lectureseries[]
			findByLectureseriesIdAndProducerId_PrevAndNext(
				long producerLectureseriesId, long lectureseriesId,
				long producerId,
				OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByLectureseriesIdAndProducerId_PrevAndNext(
			producerLectureseriesId, lectureseriesId, producerId,
			orderByComparator);
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 */
	public static void removeByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) {

		getPersistence().removeByLectureseriesIdAndProducerId(
			lectureseriesId, producerId);
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	public static int countByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) {

		return getPersistence().countByLectureseriesIdAndProducerId(
			lectureseriesId, producerId);
	}

	/**
	 * Caches the producer_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 */
	public static void cacheResult(
		Producer_Lectureseries producer_Lectureseries) {

		getPersistence().cacheResult(producer_Lectureseries);
	}

	/**
	 * Caches the producer_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureserieses the producer_ lectureserieses
	 */
	public static void cacheResult(
		List<Producer_Lectureseries> producer_Lectureserieses) {

		getPersistence().cacheResult(producer_Lectureserieses);
	}

	/**
	 * Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	 *
	 * @param producerLectureseriesId the primary key for the new producer_ lectureseries
	 * @return the new producer_ lectureseries
	 */
	public static Producer_Lectureseries create(long producerLectureseriesId) {
		return getPersistence().create(producerLectureseriesId);
	}

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public static Producer_Lectureseries remove(long producerLectureseriesId)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().remove(producerLectureseriesId);
	}

	public static Producer_Lectureseries updateImpl(
		Producer_Lectureseries producer_Lectureseries) {

		return getPersistence().updateImpl(producer_Lectureseries);
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a <code>NoSuchProducer_LectureseriesException</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	public static Producer_Lectureseries findByPrimaryKey(
			long producerLectureseriesId)
		throws de.uhh.l2g.plugins.exception.
			NoSuchProducer_LectureseriesException {

		return getPersistence().findByPrimaryKey(producerLectureseriesId);
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	 */
	public static Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId) {

		return getPersistence().fetchByPrimaryKey(producerLectureseriesId);
	}

	/**
	 * Returns all the producer_ lectureserieses.
	 *
	 * @return the producer_ lectureserieses
	 */
	public static List<Producer_Lectureseries> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Producer_Lectureseries> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Producer_Lectureseries> findAll(
		int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Producer_Lectureseries> findAll(
		int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the producer_ lectureserieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of producer_ lectureserieses.
	 *
	 * @return the number of producer_ lectureserieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Producer_LectureseriesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Producer_LectureseriesPersistence, Producer_LectureseriesPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Producer_LectureseriesPersistence.class);

		ServiceTracker
			<Producer_LectureseriesPersistence,
			 Producer_LectureseriesPersistence> serviceTracker =
				new ServiceTracker
					<Producer_LectureseriesPersistence,
					 Producer_LectureseriesPersistence>(
						 bundle.getBundleContext(),
						 Producer_LectureseriesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}