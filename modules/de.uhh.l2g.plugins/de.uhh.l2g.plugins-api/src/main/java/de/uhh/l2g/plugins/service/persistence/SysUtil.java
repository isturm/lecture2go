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

import de.uhh.l2g.plugins.model.Sys;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sys service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.SysPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SysPersistence
 * @generated
 */
public class SysUtil {

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
	public static void clearCache(Sys sys) {
		getPersistence().clearCache(sys);
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
	public static Map<Serializable, Sys> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Sys> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Sys> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sys update(Sys sys) {
		return getPersistence().update(sys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sys update(Sys sys, ServiceContext serviceContext) {
		return getPersistence().update(sys, serviceContext);
	}

	/**
	 * Caches the sys in the entity cache if it is enabled.
	 *
	 * @param sys the sys
	 */
	public static void cacheResult(Sys sys) {
		getPersistence().cacheResult(sys);
	}

	/**
	 * Caches the syses in the entity cache if it is enabled.
	 *
	 * @param syses the syses
	 */
	public static void cacheResult(List<Sys> syses) {
		getPersistence().cacheResult(syses);
	}

	/**
	 * Creates a new sys with the primary key. Does not add the sys to the database.
	 *
	 * @param sysId the primary key for the new sys
	 * @return the new sys
	 */
	public static Sys create(int sysId) {
		return getPersistence().create(sysId);
	}

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys that was removed
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	public static Sys remove(int sysId)
		throws de.uhh.l2g.plugins.exception.NoSuchSysException {

		return getPersistence().remove(sysId);
	}

	public static Sys updateImpl(Sys sys) {
		return getPersistence().updateImpl(sys);
	}

	/**
	 * Returns the sys with the primary key or throws a <code>NoSuchSysException</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	public static Sys findByPrimaryKey(int sysId)
		throws de.uhh.l2g.plugins.exception.NoSuchSysException {

		return getPersistence().findByPrimaryKey(sysId);
	}

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 */
	public static Sys fetchByPrimaryKey(int sysId) {
		return getPersistence().fetchByPrimaryKey(sysId);
	}

	/**
	 * Returns all the syses.
	 *
	 * @return the syses
	 */
	public static List<Sys> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @return the range of syses
	 */
	public static List<Sys> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of syses
	 */
	public static List<Sys> findAll(
		int start, int end, OrderByComparator<Sys> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of syses
	 */
	public static List<Sys> findAll(
		int start, int end, OrderByComparator<Sys> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the syses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of syses.
	 *
	 * @return the number of syses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SysPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SysPersistence, SysPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SysPersistence.class);

		ServiceTracker<SysPersistence, SysPersistence> serviceTracker =
			new ServiceTracker<SysPersistence, SysPersistence>(
				bundle.getBundleContext(), SysPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}