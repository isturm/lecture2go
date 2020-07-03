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

import de.uhh.l2g.plugins.model.Lectureseries_Creator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the lectureseries_ creator service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.Lectureseries_CreatorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorPersistence
 * @generated
 */
public class Lectureseries_CreatorUtil {

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
	public static void clearCache(Lectureseries_Creator lectureseries_Creator) {
		getPersistence().clearCache(lectureseries_Creator);
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
	public static Map<Serializable, Lectureseries_Creator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries_Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lectureseries_Creator update(
		Lectureseries_Creator lectureseries_Creator) {

		return getPersistence().update(lectureseries_Creator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries_Creator update(
		Lectureseries_Creator lectureseries_Creator,
		ServiceContext serviceContext) {

		return getPersistence().update(lectureseries_Creator, serviceContext);
	}

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId) {

		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLectureseries(
			lectureseriesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByLectureseries_First(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseries_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByLectureseries_First(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByLectureseries_Last(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseries_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByLectureseries_Last(
			lectureseriesId, orderByComparator);
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator[] findByLectureseries_PrevAndNext(
			long lectureseriesCreatorId, long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseries_PrevAndNext(
			lectureseriesCreatorId, lectureseriesId, orderByComparator);
	}

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public static void removeByLectureseries(long lectureseriesId) {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ creators
	 */
	public static int countByLectureseries(long lectureseriesId) {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	 * Returns all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByCreator(long creatorId) {
		return getPersistence().findByCreator(creatorId);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end) {

		return getPersistence().findByCreator(creatorId, start, end);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().findByCreator(
			creatorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCreator(
			creatorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByCreator_First(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByCreator_First(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByCreator_First(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByCreator_First(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByCreator_Last(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByCreator_Last(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByCreator_Last(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByCreator_Last(
			creatorId, orderByComparator);
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator[] findByCreator_PrevAndNext(
			long lectureseriesCreatorId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByCreator_PrevAndNext(
			lectureseriesCreatorId, creatorId, orderByComparator);
	}

	/**
	 * Removes all the lectureseries_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	public static void removeByCreator(long creatorId) {
		getPersistence().removeByCreator(creatorId);
	}

	/**
	 * Returns the number of lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	public static int countByCreator(long creatorId) {
		return getPersistence().countByCreator(creatorId);
	}

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		return getPersistence().findByLectureseriesCreator(
			lectureseriesId, creatorId);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end) {

		return getPersistence().findByLectureseriesCreator(
			lectureseriesId, creatorId, start, end);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().findByLectureseriesCreator(
			lectureseriesId, creatorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLectureseriesCreator(
			lectureseriesId, creatorId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByLectureseriesCreator_First(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseriesCreator_First(
			lectureseriesId, creatorId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByLectureseriesCreator_First(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByLectureseriesCreator_First(
			lectureseriesId, creatorId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator findByLectureseriesCreator_Last(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseriesCreator_Last(
			lectureseriesId, creatorId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public static Lectureseries_Creator fetchByLectureseriesCreator_Last(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().fetchByLectureseriesCreator_Last(
			lectureseriesId, creatorId, orderByComparator);
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator[]
			findByLectureseriesCreator_PrevAndNext(
				long lectureseriesCreatorId, long lectureseriesId,
				long creatorId,
				OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByLectureseriesCreator_PrevAndNext(
			lectureseriesCreatorId, lectureseriesId, creatorId,
			orderByComparator);
	}

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 */
	public static void removeByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		getPersistence().removeByLectureseriesCreator(
			lectureseriesId, creatorId);
	}

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	public static int countByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		return getPersistence().countByLectureseriesCreator(
			lectureseriesId, creatorId);
	}

	/**
	 * Caches the lectureseries_ creator in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creator the lectureseries_ creator
	 */
	public static void cacheResult(
		Lectureseries_Creator lectureseries_Creator) {

		getPersistence().cacheResult(lectureseries_Creator);
	}

	/**
	 * Caches the lectureseries_ creators in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creators the lectureseries_ creators
	 */
	public static void cacheResult(
		List<Lectureseries_Creator> lectureseries_Creators) {

		getPersistence().cacheResult(lectureseries_Creators);
	}

	/**
	 * Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	 *
	 * @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	 * @return the new lectureseries_ creator
	 */
	public static Lectureseries_Creator create(long lectureseriesCreatorId) {
		return getPersistence().create(lectureseriesCreatorId);
	}

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator remove(long lectureseriesCreatorId)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().remove(lectureseriesCreatorId);
	}

	public static Lectureseries_Creator updateImpl(
		Lectureseries_Creator lectureseries_Creator) {

		return getPersistence().updateImpl(lectureseries_Creator);
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a <code>NoSuchLectureseries_CreatorException</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator findByPrimaryKey(
			long lectureseriesCreatorId)
		throws de.uhh.l2g.plugins.exception.
			NoSuchLectureseries_CreatorException {

		return getPersistence().findByPrimaryKey(lectureseriesCreatorId);
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	 */
	public static Lectureseries_Creator fetchByPrimaryKey(
		long lectureseriesCreatorId) {

		return getPersistence().fetchByPrimaryKey(lectureseriesCreatorId);
	}

	/**
	 * Returns all the lectureseries_ creators.
	 *
	 * @return the lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectureseries_ creators
	 */
	public static List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lectureseries_ creators from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lectureseries_ creators.
	 *
	 * @return the number of lectureseries_ creators
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Lectureseries_CreatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Lectureseries_CreatorPersistence, Lectureseries_CreatorPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Lectureseries_CreatorPersistence.class);

		ServiceTracker
			<Lectureseries_CreatorPersistence, Lectureseries_CreatorPersistence>
				serviceTracker =
					new ServiceTracker
						<Lectureseries_CreatorPersistence,
						 Lectureseries_CreatorPersistence>(
							 bundle.getBundleContext(),
							 Lectureseries_CreatorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}