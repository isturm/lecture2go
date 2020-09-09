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

import de.uhh.l2g.plugins.model.OaiSet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the oai set service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.OaiSetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSetPersistence
 * @generated
 */
public class OaiSetUtil {

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
	public static void clearCache(OaiSet oaiSet) {
		getPersistence().clearCache(oaiSet);
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
	public static Map<Serializable, OaiSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OaiSet> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OaiSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OaiSet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OaiSet update(OaiSet oaiSet) {
		return getPersistence().update(oaiSet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OaiSet update(OaiSet oaiSet, ServiceContext serviceContext) {
		return getPersistence().update(oaiSet, serviceContext);
	}

	/**
	 * Caches the oai set in the entity cache if it is enabled.
	 *
	 * @param oaiSet the oai set
	 */
	public static void cacheResult(OaiSet oaiSet) {
		getPersistence().cacheResult(oaiSet);
	}

	/**
	 * Caches the oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiSets the oai sets
	 */
	public static void cacheResult(List<OaiSet> oaiSets) {
		getPersistence().cacheResult(oaiSets);
	}

	/**
	 * Creates a new oai set with the primary key. Does not add the oai set to the database.
	 *
	 * @param oaiSetId the primary key for the new oai set
	 * @return the new oai set
	 */
	public static OaiSet create(long oaiSetId) {
		return getPersistence().create(oaiSetId);
	}

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	public static OaiSet remove(long oaiSetId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiSetException {

		return getPersistence().remove(oaiSetId);
	}

	public static OaiSet updateImpl(OaiSet oaiSet) {
		return getPersistence().updateImpl(oaiSet);
	}

	/**
	 * Returns the oai set with the primary key or throws a <code>NoSuchOaiSetException</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	public static OaiSet findByPrimaryKey(long oaiSetId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiSetException {

		return getPersistence().findByPrimaryKey(oaiSetId);
	}

	/**
	 * Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	 */
	public static OaiSet fetchByPrimaryKey(long oaiSetId) {
		return getPersistence().fetchByPrimaryKey(oaiSetId);
	}

	/**
	 * Returns all the oai sets.
	 *
	 * @return the oai sets
	 */
	public static List<OaiSet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @return the range of oai sets
	 */
	public static List<OaiSet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai sets
	 */
	public static List<OaiSet> findAll(
		int start, int end, OrderByComparator<OaiSet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai sets
	 */
	public static List<OaiSet> findAll(
		int start, int end, OrderByComparator<OaiSet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the oai sets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of oai sets.
	 *
	 * @return the number of oai sets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OaiSetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OaiSetPersistence, OaiSetPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OaiSetPersistence.class);

		ServiceTracker<OaiSetPersistence, OaiSetPersistence> serviceTracker =
			new ServiceTracker<OaiSetPersistence, OaiSetPersistence>(
				bundle.getBundleContext(), OaiSetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}