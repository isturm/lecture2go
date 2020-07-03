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

import de.uhh.l2g.plugins.model.Institution;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the institution service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.InstitutionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstitutionPersistence
 * @generated
 */
public class InstitutionUtil {

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
	public static void clearCache(Institution institution) {
		getPersistence().clearCache(institution);
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
	public static Map<Serializable, Institution> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Institution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Institution update(Institution institution) {
		return getPersistence().update(institution);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Institution update(
		Institution institution, ServiceContext serviceContext) {

		return getPersistence().update(institution, serviceContext);
	}

	/**
	 * Returns all the institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByParent(long parentId) {
		return getPersistence().findByParent(parentId);
	}

	/**
	 * Returns a range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByParent(
		long parentId, int start, int end) {

		return getPersistence().findByParent(parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByParent(
		long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByParent(
			parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByParent(
		long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParent(
			parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByParent_First(
			long parentId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByParent_First(parentId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByParent_First(
		long parentId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByParent_First(
			parentId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByParent_Last(
			long parentId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByParent_Last(parentId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByParent_Last(
		long parentId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByParent_Last(parentId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByParent_PrevAndNext(
			long institutionId, long parentId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByParent_PrevAndNext(
			institutionId, parentId, orderByComparator);
	}

	/**
	 * Removes all the institutions where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public static void removeByParent(long parentId) {
		getPersistence().removeByParent(parentId);
	}

	/**
	 * Returns the number of institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching institutions
	 */
	public static int countByParent(long parentId) {
		return getPersistence().countByParent(parentId);
	}

	/**
	 * Returns all the institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching institutions
	 */
	public static List<Institution> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByName(
		String name, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByName(
		String name, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByName_First(
			String name, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByName_First(
		String name, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByName_Last(
			String name, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByName_Last(
		String name, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByName_PrevAndNext(
			long institutionId, String name,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByName_PrevAndNext(
			institutionId, name, orderByComparator);
	}

	/**
	 * Removes all the institutions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching institutions
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching institutions
	 */
	public static List<Institution> findByTyp(String typ) {
		return getPersistence().findByTyp(typ);
	}

	/**
	 * Returns a range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByTyp(String typ, int start, int end) {
		return getPersistence().findByTyp(typ, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByTyp(
		String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByTyp(typ, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByTyp(
		String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTyp(
			typ, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByTyp_First(
			String typ, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByTyp_First(typ, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByTyp_First(
		String typ, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByTyp_First(typ, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByTyp_Last(
			String typ, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByTyp_Last(typ, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByTyp_Last(
		String typ, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByTyp_Last(typ, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByTyp_PrevAndNext(
			long institutionId, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByTyp_PrevAndNext(
			institutionId, typ, orderByComparator);
	}

	/**
	 * Removes all the institutions where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 */
	public static void removeByTyp(String typ) {
		getPersistence().removeByTyp(typ);
	}

	/**
	 * Returns the number of institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	public static int countByTyp(String typ) {
		return getPersistence().countByTyp(typ);
	}

	/**
	 * Returns all the institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the matching institutions
	 */
	public static List<Institution> findByWww(String www) {
		return getPersistence().findByWww(www);
	}

	/**
	 * Returns a range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByWww(String www, int start, int end) {
		return getPersistence().findByWww(www, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByWww(
		String www, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByWww(www, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByWww(
		String www, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWww(
			www, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByWww_First(
			String www, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByWww_First(www, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByWww_First(
		String www, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByWww_First(www, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByWww_Last(
			String www, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByWww_Last(www, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByWww_Last(
		String www, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByWww_Last(www, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByWww_PrevAndNext(
			long institutionId, String www,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByWww_PrevAndNext(
			institutionId, www, orderByComparator);
	}

	/**
	 * Removes all the institutions where www = &#63; from the database.
	 *
	 * @param www the www
	 */
	public static void removeByWww(String www) {
		getPersistence().removeByWww(www);
	}

	/**
	 * Returns the number of institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the number of matching institutions
	 */
	public static int countByWww(String www) {
		return getPersistence().countByWww(www);
	}

	/**
	 * Returns all the institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching institutions
	 */
	public static List<Institution> findByLevel(int level) {
		return getPersistence().findByLevel(level);
	}

	/**
	 * Returns a range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByLevel(int level, int start, int end) {
		return getPersistence().findByLevel(level, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByLevel(
		int level, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByLevel(
			level, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByLevel(
		int level, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLevel(
			level, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByLevel_First(
			int level, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevel_First(level, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByLevel_First(
		int level, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByLevel_First(level, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByLevel_Last(
			int level, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevel_Last(level, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByLevel_Last(
		int level, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByLevel_Last(level, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByLevel_PrevAndNext(
			long institutionId, int level,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevel_PrevAndNext(
			institutionId, level, orderByComparator);
	}

	/**
	 * Removes all the institutions where level = &#63; from the database.
	 *
	 * @param level the level
	 */
	public static void removeByLevel(int level) {
		getPersistence().removeByLevel(level);
	}

	/**
	 * Returns the number of institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching institutions
	 */
	public static int countByLevel(int level) {
		return getPersistence().countByLevel(level);
	}

	/**
	 * Returns all the institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the matching institutions
	 */
	public static List<Institution> findBySort(int sort) {
		return getPersistence().findBySort(sort);
	}

	/**
	 * Returns a range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findBySort(int sort, int start, int end) {
		return getPersistence().findBySort(sort, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findBySort(
		int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findBySort(sort, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findBySort(
		int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySort(
			sort, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findBySort_First(
			int sort, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findBySort_First(sort, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchBySort_First(
		int sort, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchBySort_First(sort, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findBySort_Last(
			int sort, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findBySort_Last(sort, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchBySort_Last(
		int sort, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchBySort_Last(sort, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findBySort_PrevAndNext(
			long institutionId, int sort,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findBySort_PrevAndNext(
			institutionId, sort, orderByComparator);
	}

	/**
	 * Removes all the institutions where sort = &#63; from the database.
	 *
	 * @param sort the sort
	 */
	public static void removeBySort(int sort) {
		getPersistence().removeBySort(sort);
	}

	/**
	 * Returns the number of institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the number of matching institutions
	 */
	public static int countBySort(int sort) {
		return getPersistence().countBySort(sort);
	}

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the matching institutions
	 */
	public static List<Institution> findByLevelAndType(int level, String typ) {
		return getPersistence().findByLevelAndType(level, typ);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByLevelAndType(
		int level, String typ, int start, int end) {

		return getPersistence().findByLevelAndType(level, typ, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByLevelAndType(
			level, typ, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLevelAndType(
			level, typ, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByLevelAndType_First(
			int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevelAndType_First(
			level, typ, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByLevelAndType_First(
		int level, String typ,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByLevelAndType_First(
			level, typ, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByLevelAndType_Last(
			int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevelAndType_Last(
			level, typ, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByLevelAndType_Last(
		int level, String typ,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByLevelAndType_Last(
			level, typ, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByLevelAndType_PrevAndNext(
			long institutionId, int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByLevelAndType_PrevAndNext(
			institutionId, level, typ, orderByComparator);
	}

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 */
	public static void removeByLevelAndType(int level, String typ) {
		getPersistence().removeByLevelAndType(level, typ);
	}

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	public static int countByLevelAndType(int level, String typ) {
		return getPersistence().countByLevelAndType(level, typ);
	}

	/**
	 * Returns all the institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroupId_First(
			long groupId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroupId_First(
		long groupId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroupId_Last(
			long groupId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroupId_Last(
		long groupId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByGroupId_PrevAndNext(
			long institutionId, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupId_PrevAndNext(
			institutionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_P(long groupId, long parentId) {
		return getPersistence().findByG_P(groupId, parentId);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_P(
		long groupId, long parentId, int start, int end) {

		return getPersistence().findByG_P(groupId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_P(
		long groupId, long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_P(
			groupId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_P(
		long groupId, long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_P(
			groupId, parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_P_First(
			long groupId, long parentId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_First(
			groupId, parentId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_P_First(
		long groupId, long parentId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_P_First(
			groupId, parentId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_P_Last(
			long groupId, long parentId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_Last(
			groupId, parentId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_P_Last(
		long groupId, long parentId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_P_Last(
			groupId, parentId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_P_PrevAndNext(
			long institutionId, long groupId, long parentId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_PrevAndNext(
			institutionId, groupId, parentId, orderByComparator);
	}

	/**
	 * Removes all the institutions where groupId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 */
	public static void removeByG_P(long groupId, long parentId) {
		getPersistence().removeByG_P(groupId, parentId);
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @return the number of matching institutions
	 */
	public static int countByG_P(long groupId, long parentId) {
		return getPersistence().countByG_P(groupId, parentId);
	}

	/**
	 * Returns all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_N(String name, long groupId) {
		return getPersistence().findByG_N(name, groupId);
	}

	/**
	 * Returns a range of all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_N(
		String name, long groupId, int start, int end) {

		return getPersistence().findByG_N(name, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_N(
		String name, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_N(
			name, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_N(
		String name, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_N(
			name, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_N_First(
			String name, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_N_First(
			name, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_N_First(
		String name, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_N_First(
			name, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_N_Last(
			String name, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_N_Last(
			name, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_N_Last(
		String name, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_N_Last(
			name, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_N_PrevAndNext(
			long institutionId, String name, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_N_PrevAndNext(
			institutionId, name, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where name = &#63; and groupId = &#63; from the database.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 */
	public static void removeByG_N(String name, long groupId) {
		getPersistence().removeByG_N(name, groupId);
	}

	/**
	 * Returns the number of institutions where name = &#63; and groupId = &#63;.
	 *
	 * @param name the name
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_N(String name, long groupId) {
		return getPersistence().countByG_N(name, groupId);
	}

	/**
	 * Returns all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_T(String typ, long groupId) {
		return getPersistence().findByG_T(typ, groupId);
	}

	/**
	 * Returns a range of all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_T(
		String typ, long groupId, int start, int end) {

		return getPersistence().findByG_T(typ, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_T(
		String typ, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_T(
			typ, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_T(
		String typ, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_T(
			typ, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_T_First(
			String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_T_First(
			typ, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_T_First(
		String typ, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_T_First(
			typ, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_T_Last(
			String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_T_Last(typ, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_T_Last(
		String typ, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_T_Last(
			typ, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_T_PrevAndNext(
			long institutionId, String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_T_PrevAndNext(
			institutionId, typ, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where typ = &#63; and groupId = &#63; from the database.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 */
	public static void removeByG_T(String typ, long groupId) {
		getPersistence().removeByG_T(typ, groupId);
	}

	/**
	 * Returns the number of institutions where typ = &#63; and groupId = &#63;.
	 *
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_T(String typ, long groupId) {
		return getPersistence().countByG_T(typ, groupId);
	}

	/**
	 * Returns all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_W(String www, long groupId) {
		return getPersistence().findByG_W(www, groupId);
	}

	/**
	 * Returns a range of all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_W(
		String www, long groupId, int start, int end) {

		return getPersistence().findByG_W(www, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_W(
		String www, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_W(
			www, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_W(
		String www, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_W(
			www, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_W_First(
			String www, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_W_First(
			www, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_W_First(
		String www, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_W_First(
			www, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_W_Last(
			String www, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_W_Last(www, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_W_Last(
		String www, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_W_Last(
			www, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_W_PrevAndNext(
			long institutionId, String www, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_W_PrevAndNext(
			institutionId, www, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where www = &#63; and groupId = &#63; from the database.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 */
	public static void removeByG_W(String www, long groupId) {
		getPersistence().removeByG_W(www, groupId);
	}

	/**
	 * Returns the number of institutions where www = &#63; and groupId = &#63;.
	 *
	 * @param www the www
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_W(String www, long groupId) {
		return getPersistence().countByG_W(www, groupId);
	}

	/**
	 * Returns all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_L(int level, long groupId) {
		return getPersistence().findByG_L(level, groupId);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_L(
		int level, long groupId, int start, int end) {

		return getPersistence().findByG_L(level, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_L(
		int level, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_L(
			level, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_L(
		int level, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			level, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_L_First(
			int level, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_First(
			level, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_L_First(
		int level, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			level, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_L_Last(
			int level, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_Last(
			level, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_L_Last(
		int level, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			level, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_L_PrevAndNext(
			long institutionId, int level, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_PrevAndNext(
			institutionId, level, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where level = &#63; and groupId = &#63; from the database.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 */
	public static void removeByG_L(int level, long groupId) {
		getPersistence().removeByG_L(level, groupId);
	}

	/**
	 * Returns the number of institutions where level = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_L(int level, long groupId) {
		return getPersistence().countByG_L(level, groupId);
	}

	/**
	 * Returns all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_S(int sort, long groupId) {
		return getPersistence().findByG_S(sort, groupId);
	}

	/**
	 * Returns a range of all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_S(
		int sort, long groupId, int start, int end) {

		return getPersistence().findByG_S(sort, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_S(
		int sort, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_S(
			sort, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_S(
		int sort, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			sort, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_S_First(
			int sort, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_S_First(
			sort, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_S_First(
		int sort, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			sort, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_S_Last(
			int sort, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_S_Last(
			sort, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_S_Last(
		int sort, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			sort, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_S_PrevAndNext(
			long institutionId, int sort, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_S_PrevAndNext(
			institutionId, sort, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where sort = &#63; and groupId = &#63; from the database.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 */
	public static void removeByG_S(int sort, long groupId) {
		getPersistence().removeByG_S(sort, groupId);
	}

	/**
	 * Returns the number of institutions where sort = &#63; and groupId = &#63;.
	 *
	 * @param sort the sort
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_S(int sort, long groupId) {
		return getPersistence().countByG_S(sort, groupId);
	}

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_L_T(
		int level, String typ, long groupId) {

		return getPersistence().findByG_L_T(level, typ, groupId);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_L_T(
		int level, String typ, long groupId, int start, int end) {

		return getPersistence().findByG_L_T(level, typ, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_L_T(
		int level, String typ, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_L_T(
			level, typ, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_L_T(
		int level, String typ, long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_T(
			level, typ, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_L_T_First(
			int level, String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_T_First(
			level, typ, groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_L_T_First(
		int level, String typ, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_L_T_First(
			level, typ, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_L_T_Last(
			int level, String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_T_Last(
			level, typ, groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_L_T_Last(
		int level, String typ, long groupId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_L_T_Last(
			level, typ, groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_L_T_PrevAndNext(
			long institutionId, int level, String typ, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_L_T_PrevAndNext(
			institutionId, level, typ, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; and groupId = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 */
	public static void removeByG_L_T(int level, String typ, long groupId) {
		getPersistence().removeByG_L_T(level, typ, groupId);
	}

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63; and groupId = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByG_L_T(int level, String typ, long groupId) {
		return getPersistence().countByG_L_T(level, typ, groupId);
	}

	/**
	 * Returns all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @return the matching institutions
	 */
	public static List<Institution> findByG_P_S(
		long groupId, long parentId, int sort) {

		return getPersistence().findByG_P_S(groupId, parentId, sort);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByG_P_S(
		long groupId, long parentId, int sort, int start, int end) {

		return getPersistence().findByG_P_S(
			groupId, parentId, sort, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_P_S(
		long groupId, long parentId, int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByG_P_S(
			groupId, parentId, sort, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByG_P_S(
		long groupId, long parentId, int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_P_S(
			groupId, parentId, sort, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_P_S_First(
			long groupId, long parentId, int sort,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_S_First(
			groupId, parentId, sort, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_P_S_First(
		long groupId, long parentId, int sort,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_P_S_First(
			groupId, parentId, sort, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_P_S_Last(
			long groupId, long parentId, int sort,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_S_Last(
			groupId, parentId, sort, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_P_S_Last(
		long groupId, long parentId, int sort,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByG_P_S_Last(
			groupId, parentId, sort, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByG_P_S_PrevAndNext(
			long institutionId, long groupId, long parentId, int sort,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_P_S_PrevAndNext(
			institutionId, groupId, parentId, sort, orderByComparator);
	}

	/**
	 * Removes all the institutions where groupId = &#63; and parentId = &#63; and sort = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 */
	public static void removeByG_P_S(long groupId, long parentId, int sort) {
		getPersistence().removeByG_P_S(groupId, parentId, sort);
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and parentId = &#63; and sort = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param sort the sort
	 * @return the number of matching institutions
	 */
	public static int countByG_P_S(long groupId, long parentId, int sort) {
		return getPersistence().countByG_P_S(groupId, parentId, sort);
	}

	/**
	 * Returns the institution where companyId = &#63; and groupId = &#63; or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByRoot(long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByRoot(companyId, groupId);
	}

	/**
	 * Returns the institution where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByRoot(long companyId, long groupId) {
		return getPersistence().fetchByRoot(companyId, groupId);
	}

	/**
	 * Returns the institution where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByRoot(
		long companyId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByRoot(companyId, groupId, useFinderCache);
	}

	/**
	 * Removes the institution where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the institution that was removed
	 */
	public static Institution removeByRoot(long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().removeByRoot(companyId, groupId);
	}

	/**
	 * Returns the number of institutions where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByRoot(long companyId, long groupId) {
		return getPersistence().countByRoot(companyId, groupId);
	}

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByG_I(long groupId, long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByG_I(groupId, institutionId);
	}

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_I(long groupId, long institutionId) {
		return getPersistence().fetchByG_I(groupId, institutionId);
	}

	/**
	 * Returns the institution where groupId = &#63; and institutionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByG_I(
		long groupId, long institutionId, boolean useFinderCache) {

		return getPersistence().fetchByG_I(
			groupId, institutionId, useFinderCache);
	}

	/**
	 * Removes the institution where groupId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the institution that was removed
	 */
	public static Institution removeByG_I(long groupId, long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().removeByG_I(groupId, institutionId);
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and institutionId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param institutionId the institution ID
	 * @return the number of matching institutions
	 */
	public static int countByG_I(long groupId, long institutionId) {
		return getPersistence().countByG_I(groupId, institutionId);
	}

	/**
	 * Returns all the institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroup_First(
			long groupId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroup_First(
		long groupId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroup_Last(
			long groupId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroup_Last(
		long groupId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByGroup_PrevAndNext(
			long institutionId, long groupId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroup_PrevAndNext(
			institutionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the institutions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of institutions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the institutions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the institutions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByCompany_First(
			long companyId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByCompany_First(
		long companyId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByCompany_Last(
			long companyId, OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByCompany_Last(
		long companyId, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where companyId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByCompany_PrevAndNext(
			long institutionId, long companyId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByCompany_PrevAndNext(
			institutionId, companyId, orderByComparator);
	}

	/**
	 * Removes all the institutions where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of institutions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching institutions
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the institutions where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching institutions
	 */
	public static List<Institution> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the institutions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public static List<Institution> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public static List<Institution> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first institution in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last institution in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Institution> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution[] findByGroupAndCompany_PrevAndNext(
			long institutionId, long groupId, long companyId,
			OrderByComparator<Institution> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			institutionId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the institutions where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of institutions where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching institutions
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the institution where parentId = &#63; and companyId = &#63; and groupId = &#63; or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public static Institution findByParentAndCompanyAndGroup(
			long parentId, long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByParentAndCompanyAndGroup(
			parentId, companyId, groupId);
	}

	/**
	 * Returns the institution where parentId = &#63; and companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByParentAndCompanyAndGroup(
		long parentId, long companyId, long groupId) {

		return getPersistence().fetchByParentAndCompanyAndGroup(
			parentId, companyId, groupId);
	}

	/**
	 * Returns the institution where parentId = &#63; and companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public static Institution fetchByParentAndCompanyAndGroup(
		long parentId, long companyId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByParentAndCompanyAndGroup(
			parentId, companyId, groupId, useFinderCache);
	}

	/**
	 * Removes the institution where parentId = &#63; and companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the institution that was removed
	 */
	public static Institution removeByParentAndCompanyAndGroup(
			long parentId, long companyId, long groupId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().removeByParentAndCompanyAndGroup(
			parentId, companyId, groupId);
	}

	/**
	 * Returns the number of institutions where parentId = &#63; and companyId = &#63; and groupId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching institutions
	 */
	public static int countByParentAndCompanyAndGroup(
		long parentId, long companyId, long groupId) {

		return getPersistence().countByParentAndCompanyAndGroup(
			parentId, companyId, groupId);
	}

	/**
	 * Caches the institution in the entity cache if it is enabled.
	 *
	 * @param institution the institution
	 */
	public static void cacheResult(Institution institution) {
		getPersistence().cacheResult(institution);
	}

	/**
	 * Caches the institutions in the entity cache if it is enabled.
	 *
	 * @param institutions the institutions
	 */
	public static void cacheResult(List<Institution> institutions) {
		getPersistence().cacheResult(institutions);
	}

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	public static Institution create(long institutionId) {
		return getPersistence().create(institutionId);
	}

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution remove(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().remove(institutionId);
	}

	public static Institution updateImpl(Institution institution) {
		return getPersistence().updateImpl(institution);
	}

	/**
	 * Returns the institution with the primary key or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public static Institution findByPrimaryKey(long institutionId)
		throws de.uhh.l2g.plugins.exception.NoSuchInstitutionException {

		return getPersistence().findByPrimaryKey(institutionId);
	}

	/**
	 * Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution, or <code>null</code> if a institution with the primary key could not be found
	 */
	public static Institution fetchByPrimaryKey(long institutionId) {
		return getPersistence().fetchByPrimaryKey(institutionId);
	}

	/**
	 * Returns all the institutions.
	 *
	 * @return the institutions
	 */
	public static List<Institution> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 */
	public static List<Institution> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institutions
	 */
	public static List<Institution> findAll(
		int start, int end, OrderByComparator<Institution> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institutions
	 */
	public static List<Institution> findAll(
		int start, int end, OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the institutions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InstitutionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InstitutionPersistence, InstitutionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InstitutionPersistence.class);

		ServiceTracker<InstitutionPersistence, InstitutionPersistence>
			serviceTracker =
				new ServiceTracker
					<InstitutionPersistence, InstitutionPersistence>(
						bundle.getBundleContext(), InstitutionPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}