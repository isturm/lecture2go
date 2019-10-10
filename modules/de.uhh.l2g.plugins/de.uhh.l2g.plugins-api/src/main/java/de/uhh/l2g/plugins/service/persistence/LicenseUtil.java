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

import de.uhh.l2g.plugins.model.License;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the license service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.LicensePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicensePersistence
 * @generated
 */
@ProviderType
public class LicenseUtil {

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
	public static void clearCache(License license) {
		getPersistence().clearCache(license);
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
	public static Map<Serializable, License> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<License> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<License> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<License> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<License> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static License update(License license) {
		return getPersistence().update(license);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static License update(
		License license, ServiceContext serviceContext) {

		return getPersistence().update(license, serviceContext);
	}

	/**
	 * Returns all the licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the matching licenses
	 */
	public static List<License> findBySelectable(boolean selectable) {
		return getPersistence().findBySelectable(selectable);
	}

	/**
	 * Returns a range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of matching licenses
	 */
	public static List<License> findBySelectable(
		boolean selectable, int start, int end) {

		return getPersistence().findBySelectable(selectable, start, end);
	}

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBySelectable(boolean, int, int, OrderByComparator)}
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching licenses
	 */
	@Deprecated
	public static List<License> findBySelectable(
		boolean selectable, int start, int end,
		OrderByComparator<License> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySelectable(
			selectable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licenses
	 */
	public static List<License> findBySelectable(
		boolean selectable, int start, int end,
		OrderByComparator<License> orderByComparator) {

		return getPersistence().findBySelectable(
			selectable, start, end, orderByComparator);
	}

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	public static License findBySelectable_First(
			boolean selectable, OrderByComparator<License> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {

		return getPersistence().findBySelectable_First(
			selectable, orderByComparator);
	}

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license, or <code>null</code> if a matching license could not be found
	 */
	public static License fetchBySelectable_First(
		boolean selectable, OrderByComparator<License> orderByComparator) {

		return getPersistence().fetchBySelectable_First(
			selectable, orderByComparator);
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	public static License findBySelectable_Last(
			boolean selectable, OrderByComparator<License> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {

		return getPersistence().findBySelectable_Last(
			selectable, orderByComparator);
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license, or <code>null</code> if a matching license could not be found
	 */
	public static License fetchBySelectable_Last(
		boolean selectable, OrderByComparator<License> orderByComparator) {

		return getPersistence().fetchBySelectable_Last(
			selectable, orderByComparator);
	}

	/**
	 * Returns the licenses before and after the current license in the ordered set where selectable = &#63;.
	 *
	 * @param licenseId the primary key of the current license
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public static License[] findBySelectable_PrevAndNext(
			long licenseId, boolean selectable,
			OrderByComparator<License> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {

		return getPersistence().findBySelectable_PrevAndNext(
			licenseId, selectable, orderByComparator);
	}

	/**
	 * Removes all the licenses where selectable = &#63; from the database.
	 *
	 * @param selectable the selectable
	 */
	public static void removeBySelectable(boolean selectable) {
		getPersistence().removeBySelectable(selectable);
	}

	/**
	 * Returns the number of licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the number of matching licenses
	 */
	public static int countBySelectable(boolean selectable) {
		return getPersistence().countBySelectable(selectable);
	}

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	public static void cacheResult(License license) {
		getPersistence().cacheResult(license);
	}

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	public static void cacheResult(List<License> licenses) {
		getPersistence().cacheResult(licenses);
	}

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	public static License create(long licenseId) {
		return getPersistence().create(licenseId);
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public static License remove(long licenseId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {

		return getPersistence().remove(licenseId);
	}

	public static License updateImpl(License license) {
		return getPersistence().updateImpl(license);
	}

	/**
	 * Returns the license with the primary key or throws a <code>NoSuchLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public static License findByPrimaryKey(long licenseId)
		throws de.uhh.l2g.plugins.exception.NoSuchLicenseException {

		return getPersistence().findByPrimaryKey(licenseId);
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 */
	public static License fetchByPrimaryKey(long licenseId) {
		return getPersistence().fetchByPrimaryKey(licenseId);
	}

	/**
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 */
	public static List<License> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 */
	public static List<License> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licenses
	 */
	@Deprecated
	public static List<License> findAll(
		int start, int end, OrderByComparator<License> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 */
	public static List<License> findAll(
		int start, int end, OrderByComparator<License> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the licenses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LicensePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LicensePersistence, LicensePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LicensePersistence.class);

		ServiceTracker<LicensePersistence, LicensePersistence> serviceTracker =
			new ServiceTracker<LicensePersistence, LicensePersistence>(
				bundle.getBundleContext(), LicensePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}