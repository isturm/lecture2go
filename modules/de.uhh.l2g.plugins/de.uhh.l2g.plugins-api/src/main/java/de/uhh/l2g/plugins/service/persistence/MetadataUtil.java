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

import de.uhh.l2g.plugins.model.Metadata;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the metadata service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.MetadataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MetadataPersistence
 * @generated
 */
public class MetadataUtil {

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
	public static void clearCache(Metadata metadata) {
		getPersistence().clearCache(metadata);
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
	public static Map<Serializable, Metadata> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Metadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Metadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Metadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Metadata update(Metadata metadata) {
		return getPersistence().update(metadata);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Metadata update(
		Metadata metadata, ServiceContext serviceContext) {

		return getPersistence().update(metadata, serviceContext);
	}

	/**
	 * Returns all the metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching metadatas
	 */
	public static List<Metadata> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public static List<Metadata> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByGroup_First(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByGroup_First(
		long groupId, OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByGroup_Last(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByGroup_Last(
		long groupId, OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public static Metadata[] findByGroup_PrevAndNext(
			long metadataId, long groupId,
			OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroup_PrevAndNext(
			metadataId, groupId, orderByComparator);
	}

	/**
	 * Removes all the metadatas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching metadatas
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	public static List<Metadata> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public static List<Metadata> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByCompany_First(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByCompany_First(
		long companyId, OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByCompany_Last(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByCompany_Last(
		long companyId, OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public static Metadata[] findByCompany_PrevAndNext(
			long metadataId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByCompany_PrevAndNext(
			metadataId, companyId, orderByComparator);
	}

	/**
	 * Removes all the metadatas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	public static List<Metadata> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public static List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	public static List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public static Metadata findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public static Metadata fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public static Metadata[] findByGroupAndCompany_PrevAndNext(
			long metadataId, long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			metadataId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the metadatas where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the metadata in the entity cache if it is enabled.
	 *
	 * @param metadata the metadata
	 */
	public static void cacheResult(Metadata metadata) {
		getPersistence().cacheResult(metadata);
	}

	/**
	 * Caches the metadatas in the entity cache if it is enabled.
	 *
	 * @param metadatas the metadatas
	 */
	public static void cacheResult(List<Metadata> metadatas) {
		getPersistence().cacheResult(metadatas);
	}

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	public static Metadata create(long metadataId) {
		return getPersistence().create(metadataId);
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public static Metadata remove(long metadataId)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().remove(metadataId);
	}

	public static Metadata updateImpl(Metadata metadata) {
		return getPersistence().updateImpl(metadata);
	}

	/**
	 * Returns the metadata with the primary key or throws a <code>NoSuchMetadataException</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public static Metadata findByPrimaryKey(long metadataId)
		throws de.uhh.l2g.plugins.exception.NoSuchMetadataException {

		return getPersistence().findByPrimaryKey(metadataId);
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 */
	public static Metadata fetchByPrimaryKey(long metadataId) {
		return getPersistence().fetchByPrimaryKey(metadataId);
	}

	/**
	 * Returns all the metadatas.
	 *
	 * @return the metadatas
	 */
	public static List<Metadata> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 */
	public static List<Metadata> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadatas
	 */
	public static List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of metadatas
	 */
	public static List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the metadatas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MetadataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MetadataPersistence, MetadataPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MetadataPersistence.class);

		ServiceTracker<MetadataPersistence, MetadataPersistence>
			serviceTracker =
				new ServiceTracker<MetadataPersistence, MetadataPersistence>(
					bundle.getBundleContext(), MetadataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}