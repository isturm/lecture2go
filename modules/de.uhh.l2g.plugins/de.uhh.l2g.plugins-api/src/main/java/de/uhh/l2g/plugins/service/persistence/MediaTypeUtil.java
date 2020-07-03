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

import de.uhh.l2g.plugins.model.MediaType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the media type service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.MediaTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MediaTypePersistence
 * @generated
 */
public class MediaTypeUtil {

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
	public static void clearCache(MediaType mediaType) {
		getPersistence().clearCache(mediaType);
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
	public static Map<Serializable, MediaType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MediaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MediaType update(MediaType mediaType) {
		return getPersistence().update(mediaType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MediaType update(
		MediaType mediaType, ServiceContext serviceContext) {

		return getPersistence().update(mediaType, serviceContext);
	}

	/**
	 * Returns all the media types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching media types
	 */
	public static List<MediaType> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public static List<MediaType> findByGroup(
		long groupId, int start, int end) {

		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByGroup_First(
			long groupId, OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByGroup_First(
		long groupId, OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByGroup_Last(
			long groupId, OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByGroup_Last(
		long groupId, OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the media types before and after the current media type in the ordered set where groupId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public static MediaType[] findByGroup_PrevAndNext(
			long mediaTypeId, long groupId,
			OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroup_PrevAndNext(
			mediaTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the media types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of media types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching media types
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the media types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching media types
	 */
	public static List<MediaType> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public static List<MediaType> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByCompany_First(
			long companyId, OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByCompany_First(
		long companyId, OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByCompany_Last(
			long companyId, OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByCompany_Last(
		long companyId, OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the media types before and after the current media type in the ordered set where companyId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public static MediaType[] findByCompany_PrevAndNext(
			long mediaTypeId, long companyId,
			OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByCompany_PrevAndNext(
			mediaTypeId, companyId, orderByComparator);
	}

	/**
	 * Removes all the media types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of media types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching media types
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching media types
	 */
	public static List<MediaType> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public static List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public static List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public static MediaType findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public static MediaType fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the media types before and after the current media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public static MediaType[] findByGroupAndCompany_PrevAndNext(
			long mediaTypeId, long groupId, long companyId,
			OrderByComparator<MediaType> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			mediaTypeId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the media types where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of media types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching media types
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the media type in the entity cache if it is enabled.
	 *
	 * @param mediaType the media type
	 */
	public static void cacheResult(MediaType mediaType) {
		getPersistence().cacheResult(mediaType);
	}

	/**
	 * Caches the media types in the entity cache if it is enabled.
	 *
	 * @param mediaTypes the media types
	 */
	public static void cacheResult(List<MediaType> mediaTypes) {
		getPersistence().cacheResult(mediaTypes);
	}

	/**
	 * Creates a new media type with the primary key. Does not add the media type to the database.
	 *
	 * @param mediaTypeId the primary key for the new media type
	 * @return the new media type
	 */
	public static MediaType create(long mediaTypeId) {
		return getPersistence().create(mediaTypeId);
	}

	/**
	 * Removes the media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type that was removed
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public static MediaType remove(long mediaTypeId)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().remove(mediaTypeId);
	}

	public static MediaType updateImpl(MediaType mediaType) {
		return getPersistence().updateImpl(mediaType);
	}

	/**
	 * Returns the media type with the primary key or throws a <code>NoSuchMediaTypeException</code> if it could not be found.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public static MediaType findByPrimaryKey(long mediaTypeId)
		throws de.uhh.l2g.plugins.exception.NoSuchMediaTypeException {

		return getPersistence().findByPrimaryKey(mediaTypeId);
	}

	/**
	 * Returns the media type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type, or <code>null</code> if a media type with the primary key could not be found
	 */
	public static MediaType fetchByPrimaryKey(long mediaTypeId) {
		return getPersistence().fetchByPrimaryKey(mediaTypeId);
	}

	/**
	 * Returns all the media types.
	 *
	 * @return the media types
	 */
	public static List<MediaType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of media types
	 */
	public static List<MediaType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of media types
	 */
	public static List<MediaType> findAll(
		int start, int end, OrderByComparator<MediaType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of media types
	 */
	public static List<MediaType> findAll(
		int start, int end, OrderByComparator<MediaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the media types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of media types.
	 *
	 * @return the number of media types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MediaTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MediaTypePersistence, MediaTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MediaTypePersistence.class);

		ServiceTracker<MediaTypePersistence, MediaTypePersistence>
			serviceTracker =
				new ServiceTracker<MediaTypePersistence, MediaTypePersistence>(
					bundle.getBundleContext(), MediaTypePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}