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

import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the oai record_ oai set service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.OaiRecord_OaiSetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetPersistence
 * @generated
 */
public class OaiRecord_OaiSetUtil {

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
	public static void clearCache(OaiRecord_OaiSet oaiRecord_OaiSet) {
		getPersistence().clearCache(oaiRecord_OaiSet);
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
	public static Map<Serializable, OaiRecord_OaiSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OaiRecord_OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OaiRecord_OaiSet update(OaiRecord_OaiSet oaiRecord_OaiSet) {
		return getPersistence().update(oaiRecord_OaiSet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OaiRecord_OaiSet update(
		OaiRecord_OaiSet oaiRecord_OaiSet, ServiceContext serviceContext) {

		return getPersistence().update(oaiRecord_OaiSet, serviceContext);
	}

	/**
	 * Returns all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId) {
		return getPersistence().findByoaiSet(oaiSetId);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end) {

		return getPersistence().findByoaiSet(oaiSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().findByoaiSet(
			oaiSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByoaiSet(
			oaiSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet findByoaiSet_First(
			long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiSet_First(oaiSetId, orderByComparator);
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet fetchByoaiSet_First(
		long oaiSetId, OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().fetchByoaiSet_First(
			oaiSetId, orderByComparator);
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet findByoaiSet_Last(
			long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiSet_Last(oaiSetId, orderByComparator);
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet fetchByoaiSet_Last(
		long oaiSetId, OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().fetchByoaiSet_Last(oaiSetId, orderByComparator);
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public static OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(
			long oaiRecordOaiSetId, long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiSet_PrevAndNext(
			oaiRecordOaiSetId, oaiSetId, orderByComparator);
	}

	/**
	 * Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	 *
	 * @param oaiSetId the oai set ID
	 */
	public static void removeByoaiSet(long oaiSetId) {
		getPersistence().removeByoaiSet(oaiSetId);
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the number of matching oai record_ oai sets
	 */
	public static int countByoaiSet(long oaiSetId) {
		return getPersistence().countByoaiSet(oaiSetId);
	}

	/**
	 * Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId) {
		return getPersistence().findByoaiRecord(oaiRecordId);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end) {

		return getPersistence().findByoaiRecord(oaiRecordId, start, end);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().findByoaiRecord(
			oaiRecordId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByoaiRecord(
			oaiRecordId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet findByoaiRecord_First(
			long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiRecord_First(
			oaiRecordId, orderByComparator);
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet fetchByoaiRecord_First(
		long oaiRecordId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().fetchByoaiRecord_First(
			oaiRecordId, orderByComparator);
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet findByoaiRecord_Last(
			long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiRecord_Last(
			oaiRecordId, orderByComparator);
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public static OaiRecord_OaiSet fetchByoaiRecord_Last(
		long oaiRecordId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().fetchByoaiRecord_Last(
			oaiRecordId, orderByComparator);
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public static OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
			long oaiRecordOaiSetId, long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByoaiRecord_PrevAndNext(
			oaiRecordOaiSetId, oaiRecordId, orderByComparator);
	}

	/**
	 * Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	 *
	 * @param oaiRecordId the oai record ID
	 */
	public static void removeByoaiRecord(long oaiRecordId) {
		getPersistence().removeByoaiRecord(oaiRecordId);
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the number of matching oai record_ oai sets
	 */
	public static int countByoaiRecord(long oaiRecordId) {
		return getPersistence().countByoaiRecord(oaiRecordId);
	}

	/**
	 * Caches the oai record_ oai set in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 */
	public static void cacheResult(OaiRecord_OaiSet oaiRecord_OaiSet) {
		getPersistence().cacheResult(oaiRecord_OaiSet);
	}

	/**
	 * Caches the oai record_ oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSets the oai record_ oai sets
	 */
	public static void cacheResult(List<OaiRecord_OaiSet> oaiRecord_OaiSets) {
		getPersistence().cacheResult(oaiRecord_OaiSets);
	}

	/**
	 * Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	 *
	 * @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	 * @return the new oai record_ oai set
	 */
	public static OaiRecord_OaiSet create(long oaiRecordOaiSetId) {
		return getPersistence().create(oaiRecordOaiSetId);
	}

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public static OaiRecord_OaiSet remove(long oaiRecordOaiSetId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().remove(oaiRecordOaiSetId);
	}

	public static OaiRecord_OaiSet updateImpl(
		OaiRecord_OaiSet oaiRecord_OaiSet) {

		return getPersistence().updateImpl(oaiRecord_OaiSet);
	}

	/**
	 * Returns the oai record_ oai set with the primary key or throws a <code>NoSuchOaiRecord_OaiSetException</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public static OaiRecord_OaiSet findByPrimaryKey(long oaiRecordOaiSetId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException {

		return getPersistence().findByPrimaryKey(oaiRecordOaiSetId);
	}

	/**
	 * Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	 */
	public static OaiRecord_OaiSet fetchByPrimaryKey(long oaiRecordOaiSetId) {
		return getPersistence().fetchByPrimaryKey(oaiRecordOaiSetId);
	}

	/**
	 * Returns all the oai record_ oai sets.
	 *
	 * @return the oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findAll(
		int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai record_ oai sets
	 */
	public static List<OaiRecord_OaiSet> findAll(
		int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the oai record_ oai sets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of oai record_ oai sets.
	 *
	 * @return the number of oai record_ oai sets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OaiRecord_OaiSetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OaiRecord_OaiSetPersistence, OaiRecord_OaiSetPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OaiRecord_OaiSetPersistence.class);

		ServiceTracker<OaiRecord_OaiSetPersistence, OaiRecord_OaiSetPersistence>
			serviceTracker =
				new ServiceTracker
					<OaiRecord_OaiSetPersistence, OaiRecord_OaiSetPersistence>(
						bundle.getBundleContext(),
						OaiRecord_OaiSetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}