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

import de.uhh.l2g.plugins.model.Lectureseries;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the lectureseries service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.LectureseriesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesPersistence
 * @generated
 */
@ProviderType
public class LectureseriesUtil {

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
	public static void clearCache(Lectureseries lectureseries) {
		getPersistence().clearCache(lectureseries);
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
	public static Map<Serializable, Lectureseries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lectureseries update(Lectureseries lectureseries) {
		return getPersistence().update(lectureseries);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries update(
		Lectureseries lectureseries, ServiceContext serviceContext) {

		return getPersistence().update(lectureseries, serviceContext);
	}

	/**
	 * Returns all the lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByTerm(long termId) {
		return getPersistence().findByTerm(termId);
	}

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
	public static List<Lectureseries> findByTerm(
		long termId, int start, int end) {

		return getPersistence().findByTerm(termId, start, end);
	}

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
	public static List<Lectureseries> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTerm(
			termId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByTerm(
		long termId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByTerm(
			termId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByTerm_First(
			long termId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByTerm_First(termId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByTerm_First(
		long termId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByTerm_First(termId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByTerm_Last(
			long termId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByTerm_Last(termId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByTerm_Last(
		long termId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByTerm_Last(termId, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where termId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByTerm_PrevAndNext(
			long lectureseriesId, long termId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByTerm_PrevAndNext(
			lectureseriesId, termId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 */
	public static void removeByTerm(long termId) {
		getPersistence().removeByTerm(termId);
	}

	/**
	 * Returns the number of lectureserieses where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByTerm(long termId) {
		return getPersistence().countByTerm(termId);
	}

	/**
	 * Returns all the lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByLanguage(String language) {
		return getPersistence().findByLanguage(language);
	}

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
	public static List<Lectureseries> findByLanguage(
		String language, int start, int end) {

		return getPersistence().findByLanguage(language, start, end);
	}

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
	public static List<Lectureseries> findByLanguage(
		String language, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLanguage(
			language, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByLanguage(
		String language, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByLanguage(
			language, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLanguage_First(
			String language, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLanguage_First(
			language, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLanguage_First(
		String language, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLanguage_First(
			language, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLanguage_Last(
			String language, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLanguage_Last(
			language, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where language = &#63;.
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLanguage_Last(
		String language, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLanguage_Last(
			language, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where language = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByLanguage_PrevAndNext(
			long lectureseriesId, String language,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLanguage_PrevAndNext(
			lectureseriesId, language, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where language = &#63; from the database.
	 *
	 * @param language the language
	 */
	public static void removeByLanguage(String language) {
		getPersistence().removeByLanguage(language);
	}

	/**
	 * Returns the number of lectureserieses where language = &#63;.
	 *
	 * @param language the language
	 * @return the number of matching lectureserieses
	 */
	public static int countByLanguage(String language) {
		return getPersistence().countByLanguage(language);
	}

	/**
	 * Returns all the lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByNumber(String number) {
		return getPersistence().findByNumber(number);
	}

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
	public static List<Lectureseries> findByNumber(
		String number, int start, int end) {

		return getPersistence().findByNumber(number, start, end);
	}

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
	public static List<Lectureseries> findByNumber(
		String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNumber(
			number, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByNumber(
		String number, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByNumber(
			number, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByNumber_First(
			String number, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByNumber_First(number, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByNumber_First(
		String number, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByNumber_First(number, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByNumber_Last(
			String number, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByNumber_Last(number, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where number = &#63;.
	 *
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByNumber_Last(
		String number, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByNumber_Last(number, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where number = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param number the number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByNumber_PrevAndNext(
			long lectureseriesId, String number,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByNumber_PrevAndNext(
			lectureseriesId, number, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where number = &#63; from the database.
	 *
	 * @param number the number
	 */
	public static void removeByNumber(String number) {
		getPersistence().removeByNumber(number);
	}

	/**
	 * Returns the number of lectureserieses where number = &#63;.
	 *
	 * @param number the number
	 * @return the number of matching lectureserieses
	 */
	public static int countByNumber(String number) {
		return getPersistence().countByNumber(number);
	}

	/**
	 * Returns all the lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByType(String eventType) {
		return getPersistence().findByType(eventType);
	}

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
	public static List<Lectureseries> findByType(
		String eventType, int start, int end) {

		return getPersistence().findByType(eventType, start, end);
	}

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
	public static List<Lectureseries> findByType(
		String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			eventType, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByType(
		String eventType, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByType(
			eventType, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByType_First(
			String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByType_First(eventType, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByType_First(
		String eventType, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByType_First(eventType, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByType_Last(
			String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByType_Last(eventType, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByType_Last(
		String eventType, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByType_Last(eventType, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where eventType = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByType_PrevAndNext(
			long lectureseriesId, String eventType,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByType_PrevAndNext(
			lectureseriesId, eventType, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public static void removeByType(String eventType) {
		getPersistence().removeByType(eventType);
	}

	/**
	 * Returns the number of lectureserieses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching lectureserieses
	 */
	public static int countByType(String eventType) {
		return getPersistence().countByType(eventType);
	}

	/**
	 * Returns all the lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

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
	public static List<Lectureseries> findByCategory(
		long categoryId, int start, int end) {

		return getPersistence().findByCategory(categoryId, start, end);
	}

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
	public static List<Lectureseries> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByCategory_First(
			long categoryId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByCategory_First(
		long categoryId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByCategory_Last(
			long categoryId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByCategory_Last(
		long categoryId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where categoryId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByCategory_PrevAndNext(
			long lectureseriesId, long categoryId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCategory_PrevAndNext(
			lectureseriesId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	 * Returns the number of lectureserieses where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	 * Returns all the lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByName(String name) {
		return getPersistence().findByName(name);
	}

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
	public static List<Lectureseries> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

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
	public static List<Lectureseries> findByName(
		String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByName(
		String name, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByName_First(
			String name, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByName_First(
		String name, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByName_Last(
			String name, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByName_Last(
		String name, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where name = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByName_PrevAndNext(
			long lectureseriesId, String name,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByName_PrevAndNext(
			lectureseriesId, name, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of lectureserieses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching lectureserieses
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByFaculty(String facultyName) {
		return getPersistence().findByFaculty(facultyName);
	}

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
	public static List<Lectureseries> findByFaculty(
		String facultyName, int start, int end) {

		return getPersistence().findByFaculty(facultyName, start, end);
	}

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
	public static List<Lectureseries> findByFaculty(
		String facultyName, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFaculty(
			facultyName, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByFaculty(
		String facultyName, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByFaculty(
			facultyName, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByFaculty_First(
			String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByFaculty_First(
			facultyName, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByFaculty_First(
		String facultyName,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByFaculty_First(
			facultyName, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByFaculty_Last(
			String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByFaculty_Last(
			facultyName, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByFaculty_Last(
		String facultyName,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByFaculty_Last(
			facultyName, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where facultyName = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param facultyName the faculty name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByFaculty_PrevAndNext(
			long lectureseriesId, String facultyName,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByFaculty_PrevAndNext(
			lectureseriesId, facultyName, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where facultyName = &#63; from the database.
	 *
	 * @param facultyName the faculty name
	 */
	public static void removeByFaculty(String facultyName) {
		getPersistence().removeByFaculty(facultyName);
	}

	/**
	 * Returns the number of lectureserieses where facultyName = &#63;.
	 *
	 * @param facultyName the faculty name
	 * @return the number of matching lectureserieses
	 */
	public static int countByFaculty(String facultyName) {
		return getPersistence().countByFaculty(facultyName);
	}

	/**
	 * Returns all the lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByApproved(int approved) {
		return getPersistence().findByApproved(approved);
	}

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
	public static List<Lectureseries> findByApproved(
		int approved, int start, int end) {

		return getPersistence().findByApproved(approved, start, end);
	}

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
	public static List<Lectureseries> findByApproved(
		int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApproved(
			approved, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByApproved(
		int approved, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByApproved(
			approved, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByApproved_First(
			int approved, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByApproved_First(
			approved, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByApproved_First(
		int approved, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByApproved_First(
			approved, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByApproved_Last(
			int approved, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByApproved_Last(
			approved, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByApproved_Last(
		int approved, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByApproved_Last(
			approved, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where approved = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByApproved_PrevAndNext(
			long lectureseriesId, int approved,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByApproved_PrevAndNext(
			lectureseriesId, approved, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	public static void removeByApproved(int approved) {
		getPersistence().removeByApproved(approved);
	}

	/**
	 * Returns the number of lectureserieses where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching lectureserieses
	 */
	public static int countByApproved(int approved) {
		return getPersistence().countByApproved(approved);
	}

	/**
	 * Returns all the lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByPassword(String password) {
		return getPersistence().findByPassword(password);
	}

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
	public static List<Lectureseries> findByPassword(
		String password, int start, int end) {

		return getPersistence().findByPassword(password, start, end);
	}

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
	public static List<Lectureseries> findByPassword(
		String password, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPassword(
			password, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByPassword(
		String password, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByPassword(
			password, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByPassword_First(
			String password, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByPassword_First(
			password, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByPassword_First(
		String password, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByPassword_First(
			password, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByPassword_Last(
			String password, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByPassword_Last(
			password, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where password = &#63;.
	 *
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByPassword_Last(
		String password, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByPassword_Last(
			password, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where password = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param password the password
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByPassword_PrevAndNext(
			long lectureseriesId, String password,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByPassword_PrevAndNext(
			lectureseriesId, password, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where password = &#63; from the database.
	 *
	 * @param password the password
	 */
	public static void removeByPassword(String password) {
		getPersistence().removeByPassword(password);
	}

	/**
	 * Returns the number of lectureserieses where password = &#63;.
	 *
	 * @param password the password
	 * @return the number of matching lectureserieses
	 */
	public static int countByPassword(String password) {
		return getPersistence().countByPassword(password);
	}

	/**
	 * Returns all the lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId) {

		return getPersistence().findByLatestOpenAccessVideo(
			latestOpenAccessVideoId);
	}

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
	public static List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end) {

		return getPersistence().findByLatestOpenAccessVideo(
			latestOpenAccessVideoId, start, end);
	}

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
	public static List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLatestOpenAccessVideo(
			latestOpenAccessVideoId, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static List<Lectureseries> findByLatestOpenAccessVideo(
		long latestOpenAccessVideoId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByLatestOpenAccessVideo(
			latestOpenAccessVideoId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestOpenAccessVideo_First(
			long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestOpenAccessVideo_First(
			latestOpenAccessVideoId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestOpenAccessVideo_First(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestOpenAccessVideo_First(
			latestOpenAccessVideoId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestOpenAccessVideo_Last(
			long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestOpenAccessVideo_Last(
			latestOpenAccessVideoId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestOpenAccessVideo_Last(
		long latestOpenAccessVideoId,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestOpenAccessVideo_Last(
			latestOpenAccessVideoId, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestOpenAccessVideoId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByLatestOpenAccessVideo_PrevAndNext(
			long lectureseriesId, long latestOpenAccessVideoId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestOpenAccessVideo_PrevAndNext(
			lectureseriesId, latestOpenAccessVideoId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where latestOpenAccessVideoId = &#63; from the database.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 */
	public static void removeByLatestOpenAccessVideo(
		long latestOpenAccessVideoId) {

		getPersistence().removeByLatestOpenAccessVideo(latestOpenAccessVideoId);
	}

	/**
	 * Returns the number of lectureserieses where latestOpenAccessVideoId = &#63;.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByLatestOpenAccessVideo(
		long latestOpenAccessVideoId) {

		return getPersistence().countByLatestOpenAccessVideo(
			latestOpenAccessVideoId);
	}

	/**
	 * Returns all the lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate) {

		return getPersistence().findByLatestVideoUploadDate(
			latestVideoUploadDate);
	}

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
	public static List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end) {

		return getPersistence().findByLatestVideoUploadDate(
			latestVideoUploadDate, start, end);
	}

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
	public static List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLatestVideoUploadDate(
			latestVideoUploadDate, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static List<Lectureseries> findByLatestVideoUploadDate(
		Date latestVideoUploadDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByLatestVideoUploadDate(
			latestVideoUploadDate, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestVideoUploadDate_First(
			Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoUploadDate_First(
			latestVideoUploadDate, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestVideoUploadDate_First(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestVideoUploadDate_First(
			latestVideoUploadDate, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestVideoUploadDate_Last(
			Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoUploadDate_Last(
			latestVideoUploadDate, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestVideoUploadDate_Last(
		Date latestVideoUploadDate,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestVideoUploadDate_Last(
			latestVideoUploadDate, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoUploadDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoUploadDate the latest video upload date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByLatestVideoUploadDate_PrevAndNext(
			long lectureseriesId, Date latestVideoUploadDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoUploadDate_PrevAndNext(
			lectureseriesId, latestVideoUploadDate, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where latestVideoUploadDate = &#63; from the database.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 */
	public static void removeByLatestVideoUploadDate(
		Date latestVideoUploadDate) {

		getPersistence().removeByLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	 * Returns the number of lectureserieses where latestVideoUploadDate = &#63;.
	 *
	 * @param latestVideoUploadDate the latest video upload date
	 * @return the number of matching lectureserieses
	 */
	public static int countByLatestVideoUploadDate(Date latestVideoUploadDate) {
		return getPersistence().countByLatestVideoUploadDate(
			latestVideoUploadDate);
	}

	/**
	 * Returns all the lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {

		return getPersistence().findByLatestVideoGenerationDate(
			latestVideoGenerationDate);
	}

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
	public static List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end) {

		return getPersistence().findByLatestVideoGenerationDate(
			latestVideoGenerationDate, start, end);
	}

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
	public static List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLatestVideoGenerationDate(
			latestVideoGenerationDate, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static List<Lectureseries> findByLatestVideoGenerationDate(
		String latestVideoGenerationDate, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByLatestVideoGenerationDate(
			latestVideoGenerationDate, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestVideoGenerationDate_First(
			String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoGenerationDate_First(
			latestVideoGenerationDate, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestVideoGenerationDate_First(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestVideoGenerationDate_First(
			latestVideoGenerationDate, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByLatestVideoGenerationDate_Last(
			String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoGenerationDate_Last(
			latestVideoGenerationDate, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByLatestVideoGenerationDate_Last(
		String latestVideoGenerationDate,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByLatestVideoGenerationDate_Last(
			latestVideoGenerationDate, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where latestVideoGenerationDate = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param latestVideoGenerationDate the latest video generation date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByLatestVideoGenerationDate_PrevAndNext(
			long lectureseriesId, String latestVideoGenerationDate,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByLatestVideoGenerationDate_PrevAndNext(
			lectureseriesId, latestVideoGenerationDate, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where latestVideoGenerationDate = &#63; from the database.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 */
	public static void removeByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {

		getPersistence().removeByLatestVideoGenerationDate(
			latestVideoGenerationDate);
	}

	/**
	 * Returns the number of lectureserieses where latestVideoGenerationDate = &#63;.
	 *
	 * @param latestVideoGenerationDate the latest video generation date
	 * @return the number of matching lectureserieses
	 */
	public static int countByLatestVideoGenerationDate(
		String latestVideoGenerationDate) {

		return getPersistence().countByLatestVideoGenerationDate(
			latestVideoGenerationDate);
	}

	/**
	 * Returns all the lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByUSID(String USID) {
		return getPersistence().findByUSID(USID);
	}

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
	public static List<Lectureseries> findByUSID(
		String USID, int start, int end) {

		return getPersistence().findByUSID(USID, start, end);
	}

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
	public static List<Lectureseries> findByUSID(
		String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUSID(
			USID, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByUSID(
		String USID, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByUSID(USID, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByUSID_First(
			String USID, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByUSID_First(USID, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByUSID_First(
		String USID, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByUSID_First(USID, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByUSID_Last(
			String USID, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByUSID_Last(USID, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByUSID_Last(
		String USID, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByUSID_Last(USID, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where USID = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param USID the usid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByUSID_PrevAndNext(
			long lectureseriesId, String USID,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByUSID_PrevAndNext(
			lectureseriesId, USID, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where USID = &#63; from the database.
	 *
	 * @param USID the usid
	 */
	public static void removeByUSID(String USID) {
		getPersistence().removeByUSID(USID);
	}

	/**
	 * Returns the number of lectureserieses where USID = &#63;.
	 *
	 * @param USID the usid
	 * @return the number of matching lectureserieses
	 */
	public static int countByUSID(String USID) {
		return getPersistence().countByUSID(USID);
	}

	/**
	 * Returns all the lectureserieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

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
	public static List<Lectureseries> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static List<Lectureseries> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByGroup_First(
			long groupId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByGroup_First(
		long groupId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByGroup_Last(
			long groupId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByGroup_Last(
		long groupId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where groupId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByGroup_PrevAndNext(
			long lectureseriesId, long groupId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroup_PrevAndNext(
			lectureseriesId, groupId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of lectureserieses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the lectureserieses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

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
	public static List<Lectureseries> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static List<Lectureseries> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByCompany_First(
			long companyId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByCompany_First(
		long companyId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByCompany_Last(
			long companyId, OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByCompany_Last(
		long companyId, OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the lectureserieses before and after the current lectureseries in the ordered set where companyId = &#63;.
	 *
	 * @param lectureseriesId the primary key of the current lectureseries
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries[] findByCompany_PrevAndNext(
			long lectureseriesId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByCompany_PrevAndNext(
			lectureseriesId, companyId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of lectureserieses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching lectureserieses
	 */
	public static List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

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
	public static List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

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
	public static List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries
	 * @throws NoSuchLectureseriesException if a matching lectureseries could not be found
	 */
	public static Lectureseries findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last lectureseries in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries, or <code>null</code> if a matching lectureseries could not be found
	 */
	public static Lectureseries fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

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
	public static Lectureseries[] findByGroupAndCompany_PrevAndNext(
			long lectureseriesId, long groupId, long companyId,
			OrderByComparator<Lectureseries> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			lectureseriesId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of lectureserieses where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching lectureserieses
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the lectureseries in the entity cache if it is enabled.
	 *
	 * @param lectureseries the lectureseries
	 */
	public static void cacheResult(Lectureseries lectureseries) {
		getPersistence().cacheResult(lectureseries);
	}

	/**
	 * Caches the lectureserieses in the entity cache if it is enabled.
	 *
	 * @param lectureserieses the lectureserieses
	 */
	public static void cacheResult(List<Lectureseries> lectureserieses) {
		getPersistence().cacheResult(lectureserieses);
	}

	/**
	 * Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	 *
	 * @param lectureseriesId the primary key for the new lectureseries
	 * @return the new lectureseries
	 */
	public static Lectureseries create(long lectureseriesId) {
		return getPersistence().create(lectureseriesId);
	}

	/**
	 * Removes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries remove(long lectureseriesId)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().remove(lectureseriesId);
	}

	public static Lectureseries updateImpl(Lectureseries lectureseries) {
		return getPersistence().updateImpl(lectureseries);
	}

	/**
	 * Returns the lectureseries with the primary key or throws a <code>NoSuchLectureseriesException</code> if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws NoSuchLectureseriesException if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries findByPrimaryKey(long lectureseriesId)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseriesException {

		return getPersistence().findByPrimaryKey(lectureseriesId);
	}

	/**
	 * Returns the lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries, or <code>null</code> if a lectureseries with the primary key could not be found
	 */
	public static Lectureseries fetchByPrimaryKey(long lectureseriesId) {
		return getPersistence().fetchByPrimaryKey(lectureseriesId);
	}

	/**
	 * Returns all the lectureserieses.
	 *
	 * @return the lectureserieses
	 */
	public static List<Lectureseries> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Lectureseries> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Lectureseries> findAll(
		int start, int end, OrderByComparator<Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<Lectureseries> findAll(
		int start, int end,
		OrderByComparator<Lectureseries> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the lectureserieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lectureserieses.
	 *
	 * @return the number of lectureserieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LectureseriesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LectureseriesPersistence, LectureseriesPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LectureseriesPersistence.class);

		ServiceTracker<LectureseriesPersistence, LectureseriesPersistence>
			serviceTracker =
				new ServiceTracker
					<LectureseriesPersistence, LectureseriesPersistence>(
						bundle.getBundleContext(),
						LectureseriesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}