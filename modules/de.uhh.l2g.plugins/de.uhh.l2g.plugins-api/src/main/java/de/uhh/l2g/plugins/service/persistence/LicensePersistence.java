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

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see LicenseUtil
 * @generated
 */
@ProviderType
public interface LicensePersistence extends BasePersistence<License> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LicenseUtil} to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the matching licenses
	 */
	public java.util.List<License> findBySelectable(boolean selectable);

	/**
	 * Returns a range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of matching licenses
	 */
	public java.util.List<License> findBySelectable(
		boolean selectable, int start, int end);

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licenses
	 */
	public java.util.List<License> findBySelectable(
		boolean selectable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator);

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching licenses
	 */
	public java.util.List<License> findBySelectable(
		boolean selectable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	public License findBySelectable_First(
			boolean selectable,
			com.liferay.portal.kernel.util.OrderByComparator<License>
				orderByComparator)
		throws NoSuchLicenseException;

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license, or <code>null</code> if a matching license could not be found
	 */
	public License fetchBySelectable_First(
		boolean selectable,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator);

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	public License findBySelectable_Last(
			boolean selectable,
			com.liferay.portal.kernel.util.OrderByComparator<License>
				orderByComparator)
		throws NoSuchLicenseException;

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license, or <code>null</code> if a matching license could not be found
	 */
	public License fetchBySelectable_Last(
		boolean selectable,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator);

	/**
	 * Returns the licenses before and after the current license in the ordered set where selectable = &#63;.
	 *
	 * @param licenseId the primary key of the current license
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public License[] findBySelectable_PrevAndNext(
			long licenseId, boolean selectable,
			com.liferay.portal.kernel.util.OrderByComparator<License>
				orderByComparator)
		throws NoSuchLicenseException;

	/**
	 * Removes all the licenses where selectable = &#63; from the database.
	 *
	 * @param selectable the selectable
	 */
	public void removeBySelectable(boolean selectable);

	/**
	 * Returns the number of licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the number of matching licenses
	 */
	public int countBySelectable(boolean selectable);

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	public void cacheResult(License license);

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	public void cacheResult(java.util.List<License> licenses);

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	public License create(long licenseId);

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public License remove(long licenseId) throws NoSuchLicenseException;

	public License updateImpl(License license);

	/**
	 * Returns the license with the primary key or throws a <code>NoSuchLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	public License findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException;

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 */
	public License fetchByPrimaryKey(long licenseId);

	/**
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 */
	public java.util.List<License> findAll();

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 */
	public java.util.List<License> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 */
	public java.util.List<License> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator);

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licenses
	 */
	public java.util.List<License> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<License>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the licenses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
	 */
	public int countAll();

}