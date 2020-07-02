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

import de.uhh.l2g.plugins.model.Creator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the creator service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.CreatorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see CreatorPersistence
 * @generated
 */
public class CreatorUtil {

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
	public static void clearCache(Creator creator) {
		getPersistence().clearCache(creator);
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
	public static Map<Serializable, Creator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Creator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Creator update(Creator creator) {
		return getPersistence().update(creator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Creator update(
		Creator creator, ServiceContext serviceContext) {

		return getPersistence().update(creator, serviceContext);
	}

	/**
	 * Returns all the creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching creators
	 */
	public static List<Creator> findByFirstName(String firstName) {
		return getPersistence().findByFirstName(firstName);
	}

	/**
	 * Returns a range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByFirstName(
		String firstName, int start, int end) {

		return getPersistence().findByFirstName(firstName, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByFirstName(
			firstName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFirstName(
			firstName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByFirstName_First(
			String firstName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByFirstName_First(
		String firstName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByFirstName_First(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByFirstName_Last(
			String firstName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByFirstName_Last(
		String firstName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByFirstName_Last(
			firstName, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where firstName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByFirstName_PrevAndNext(
			long creatorId, String firstName,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFirstName_PrevAndNext(
			creatorId, firstName, orderByComparator);
	}

	/**
	 * Removes all the creators where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	public static void removeByFirstName(String firstName) {
		getPersistence().removeByFirstName(firstName);
	}

	/**
	 * Returns the number of creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching creators
	 */
	public static int countByFirstName(String firstName) {
		return getPersistence().countByFirstName(firstName);
	}

	/**
	 * Returns all the creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching creators
	 */
	public static List<Creator> findByLastName(String lastName) {
		return getPersistence().findByLastName(lastName);
	}

	/**
	 * Returns a range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByLastName(
		String lastName, int start, int end) {

		return getPersistence().findByLastName(lastName, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByLastName_First(
			String lastName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByLastName_First(
		String lastName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByLastName_Last(
			String lastName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByLastName_Last(
		String lastName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where lastName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByLastName_PrevAndNext(
			long creatorId, String lastName,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByLastName_PrevAndNext(
			creatorId, lastName, orderByComparator);
	}

	/**
	 * Removes all the creators where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public static void removeByLastName(String lastName) {
		getPersistence().removeByLastName(lastName);
	}

	/**
	 * Returns the number of creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching creators
	 */
	public static int countByLastName(String lastName) {
		return getPersistence().countByLastName(lastName);
	}

	/**
	 * Returns all the creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching creators
	 */
	public static List<Creator> findByMiddleName(String middleName) {
		return getPersistence().findByMiddleName(middleName);
	}

	/**
	 * Returns a range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByMiddleName(
		String middleName, int start, int end) {

		return getPersistence().findByMiddleName(middleName, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByMiddleName(
		String middleName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByMiddleName(
			middleName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByMiddleName(
		String middleName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMiddleName(
			middleName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByMiddleName_First(
			String middleName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByMiddleName_First(
			middleName, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByMiddleName_First(
		String middleName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByMiddleName_First(
			middleName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByMiddleName_Last(
			String middleName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByMiddleName_Last(
			middleName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByMiddleName_Last(
		String middleName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByMiddleName_Last(
			middleName, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where middleName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByMiddleName_PrevAndNext(
			long creatorId, String middleName,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByMiddleName_PrevAndNext(
			creatorId, middleName, orderByComparator);
	}

	/**
	 * Removes all the creators where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	public static void removeByMiddleName(String middleName) {
		getPersistence().removeByMiddleName(middleName);
	}

	/**
	 * Returns the number of creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching creators
	 */
	public static int countByMiddleName(String middleName) {
		return getPersistence().countByMiddleName(middleName);
	}

	/**
	 * Returns all the creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching creators
	 */
	public static List<Creator> findByFullName(String fullName) {
		return getPersistence().findByFullName(fullName);
	}

	/**
	 * Returns a range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByFullName(
		String fullName, int start, int end) {

		return getPersistence().findByFullName(fullName, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByFullName(
		String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByFullName(
			fullName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByFullName(
		String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFullName(
			fullName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByFullName_First(
			String fullName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByFullName_First(
		String fullName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByFullName_First(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByFullName_Last(
			String fullName, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByFullName_Last(
		String fullName, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByFullName_Last(
			fullName, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where fullName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByFullName_PrevAndNext(
			long creatorId, String fullName,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByFullName_PrevAndNext(
			creatorId, fullName, orderByComparator);
	}

	/**
	 * Removes all the creators where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	public static void removeByFullName(String fullName) {
		getPersistence().removeByFullName(fullName);
	}

	/**
	 * Returns the number of creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching creators
	 */
	public static int countByFullName(String fullName) {
		return getPersistence().countByFullName(fullName);
	}

	/**
	 * Returns all the creators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching creators
	 */
	public static List<Creator> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByGroup_First(
			long groupId, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByGroup_First(
		long groupId, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByGroup_Last(
			long groupId, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByGroup_Last(
		long groupId, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where groupId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByGroup_PrevAndNext(
			long creatorId, long groupId,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroup_PrevAndNext(
			creatorId, groupId, orderByComparator);
	}

	/**
	 * Removes all the creators where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of creators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching creators
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the creators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching creators
	 */
	public static List<Creator> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByCompany_First(
			long companyId, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByCompany_First(
		long companyId, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByCompany_Last(
			long companyId, OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByCompany_Last(
		long companyId, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where companyId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByCompany_PrevAndNext(
			long creatorId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByCompany_PrevAndNext(
			creatorId, companyId, orderByComparator);
	}

	/**
	 * Removes all the creators where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of creators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching creators
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching creators
	 */
	public static List<Creator> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	public static List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	public static List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	public static Creator findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	public static Creator fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Creator> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator[] findByGroupAndCompany_PrevAndNext(
			long creatorId, long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			creatorId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the creators where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of creators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching creators
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the creator in the entity cache if it is enabled.
	 *
	 * @param creator the creator
	 */
	public static void cacheResult(Creator creator) {
		getPersistence().cacheResult(creator);
	}

	/**
	 * Caches the creators in the entity cache if it is enabled.
	 *
	 * @param creators the creators
	 */
	public static void cacheResult(List<Creator> creators) {
		getPersistence().cacheResult(creators);
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	public static Creator create(long creatorId) {
		return getPersistence().create(creatorId);
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator remove(long creatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().remove(creatorId);
	}

	public static Creator updateImpl(Creator creator) {
		return getPersistence().updateImpl(creator);
	}

	/**
	 * Returns the creator with the primary key or throws a <code>NoSuchCreatorException</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	public static Creator findByPrimaryKey(long creatorId)
		throws de.uhh.l2g.plugins.exception.NoSuchCreatorException {

		return getPersistence().findByPrimaryKey(creatorId);
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 */
	public static Creator fetchByPrimaryKey(long creatorId) {
		return getPersistence().fetchByPrimaryKey(creatorId);
	}

	/**
	 * Returns all the creators.
	 *
	 * @return the creators
	 */
	public static List<Creator> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of creators
	 */
	public static List<Creator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of creators
	 */
	public static List<Creator> findAll(
		int start, int end, OrderByComparator<Creator> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of creators
	 */
	public static List<Creator> findAll(
		int start, int end, OrderByComparator<Creator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the creators from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CreatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CreatorPersistence, CreatorPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CreatorPersistence.class);

		ServiceTracker<CreatorPersistence, CreatorPersistence> serviceTracker =
			new ServiceTracker<CreatorPersistence, CreatorPersistence>(
				bundle.getBundleContext(), CreatorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}