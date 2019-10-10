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

import de.uhh.l2g.plugins.model.Tagcloud;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the tagcloud service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.TagcloudPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TagcloudPersistence
 * @generated
 */
@ProviderType
public class TagcloudUtil {

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
	public static void clearCache(Tagcloud tagcloud) {
		getPersistence().clearCache(tagcloud);
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
	public static Map<Serializable, Tagcloud> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Tagcloud> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tagcloud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tagcloud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tagcloud update(Tagcloud tagcloud) {
		return getPersistence().update(tagcloud);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tagcloud update(
		Tagcloud tagcloud, ServiceContext serviceContext) {

		return getPersistence().update(tagcloud, serviceContext);
	}

	/**
	 * Returns all the tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the matching tagclouds
	 */
	public static List<Tagcloud> findByObjectClassType(String objectClassType) {
		return getPersistence().findByObjectClassType(objectClassType);
	}

	/**
	 * Returns a range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	public static List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end) {

		return getPersistence().findByObjectClassType(
			objectClassType, start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByObjectClassType(String, int, int, OrderByComparator)}
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByObjectClassType(
			objectClassType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	public static List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findByObjectClassType(
			objectClassType, start, end, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByObjectClassType_First(
			String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectClassType_First(
			objectClassType, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByObjectClassType_First(
		String objectClassType, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByObjectClassType_First(
			objectClassType, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByObjectClassType_Last(
			String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectClassType_Last(
			objectClassType, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByObjectClassType_Last(
		String objectClassType, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByObjectClassType_Last(
			objectClassType, orderByComparator);
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud[] findByObjectClassType_PrevAndNext(
			long tagcloudId, String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectClassType_PrevAndNext(
			tagcloudId, objectClassType, orderByComparator);
	}

	/**
	 * Removes all the tagclouds where objectClassType = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 */
	public static void removeByObjectClassType(String objectClassType) {
		getPersistence().removeByObjectClassType(objectClassType);
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the number of matching tagclouds
	 */
	public static int countByObjectClassType(String objectClassType) {
		return getPersistence().countByObjectClassType(objectClassType);
	}

	/**
	 * Returns all the tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the matching tagclouds
	 */
	public static List<Tagcloud> findByObjectId(long objectId) {
		return getPersistence().findByObjectId(objectId);
	}

	/**
	 * Returns a range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	public static List<Tagcloud> findByObjectId(
		long objectId, int start, int end) {

		return getPersistence().findByObjectId(objectId, start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByObjectId(long, int, int, OrderByComparator)}
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findByObjectId(
		long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByObjectId(
			objectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	public static List<Tagcloud> findByObjectId(
		long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findByObjectId(
			objectId, start, end, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByObjectId_First(
			long objectId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectId_First(
			objectId, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByObjectId_First(
		long objectId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByObjectId_First(
			objectId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByObjectId_Last(
			long objectId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectId_Last(
			objectId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByObjectId_Last(
		long objectId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByObjectId_Last(
			objectId, orderByComparator);
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud[] findByObjectId_PrevAndNext(
			long tagcloudId, long objectId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectId_PrevAndNext(
			tagcloudId, objectId, orderByComparator);
	}

	/**
	 * Removes all the tagclouds where objectId = &#63; from the database.
	 *
	 * @param objectId the object ID
	 */
	public static void removeByObjectId(long objectId) {
		getPersistence().removeByObjectId(objectId);
	}

	/**
	 * Returns the number of tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	public static int countByObjectId(long objectId) {
		return getPersistence().countByObjectId(objectId);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a <code>NoSuchTagcloudException</code> if it could not be found.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByObjectClassTypeAndObjectId(
			String objectClassType, long objectId)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByObjectClassTypeAndObjectId(
			objectClassType, objectId);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByObjectClassTypeAndObjectId(String,long)}
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Deprecated
	public static Tagcloud fetchByObjectClassTypeAndObjectId(
		String objectClassType, long objectId, boolean useFinderCache) {

		return getPersistence().fetchByObjectClassTypeAndObjectId(
			objectClassType, objectId, useFinderCache);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByObjectClassTypeAndObjectId(
		String objectClassType, long objectId) {

		return getPersistence().fetchByObjectClassTypeAndObjectId(
			objectClassType, objectId);
	}

	/**
	 * Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the tagcloud that was removed
	 */
	public static Tagcloud removeByObjectClassTypeAndObjectId(
			String objectClassType, long objectId)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().removeByObjectClassTypeAndObjectId(
			objectClassType, objectId);
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	public static int countByObjectClassTypeAndObjectId(
		String objectClassType, long objectId) {

		return getPersistence().countByObjectClassTypeAndObjectId(
			objectClassType, objectId);
	}

	/**
	 * Returns all the tagclouds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tagclouds
	 */
	public static List<Tagcloud> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	public static List<Tagcloud> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	public static List<Tagcloud> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByGroup_First(
			long groupId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByGroup_First(
		long groupId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByGroup_Last(
			long groupId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByGroup_Last(
		long groupId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud[] findByGroup_PrevAndNext(
			long tagcloudId, long groupId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroup_PrevAndNext(
			tagcloudId, groupId, orderByComparator);
	}

	/**
	 * Removes all the tagclouds where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of tagclouds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tagclouds
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the tagclouds where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching tagclouds
	 */
	public static List<Tagcloud> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	public static List<Tagcloud> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	public static List<Tagcloud> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByCompany_First(
			long companyId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByCompany_First(
		long companyId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByCompany_Last(
			long companyId, OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByCompany_Last(
		long companyId, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud[] findByCompany_PrevAndNext(
			long tagcloudId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByCompany_PrevAndNext(
			tagcloudId, companyId, orderByComparator);
	}

	/**
	 * Removes all the tagclouds where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of tagclouds where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching tagclouds
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching tagclouds
	 */
	public static List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	public static List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	public static List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	public static Tagcloud findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	public static Tagcloud fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud[] findByGroupAndCompany_PrevAndNext(
			long tagcloudId, long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			tagcloudId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the tagclouds where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching tagclouds
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the tagcloud in the entity cache if it is enabled.
	 *
	 * @param tagcloud the tagcloud
	 */
	public static void cacheResult(Tagcloud tagcloud) {
		getPersistence().cacheResult(tagcloud);
	}

	/**
	 * Caches the tagclouds in the entity cache if it is enabled.
	 *
	 * @param tagclouds the tagclouds
	 */
	public static void cacheResult(List<Tagcloud> tagclouds) {
		getPersistence().cacheResult(tagclouds);
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	public static Tagcloud create(long tagcloudId) {
		return getPersistence().create(tagcloudId);
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud remove(long tagcloudId)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().remove(tagcloudId);
	}

	public static Tagcloud updateImpl(Tagcloud tagcloud) {
		return getPersistence().updateImpl(tagcloud);
	}

	/**
	 * Returns the tagcloud with the primary key or throws a <code>NoSuchTagcloudException</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud findByPrimaryKey(long tagcloudId)
		throws de.uhh.l2g.plugins.exception.NoSuchTagcloudException {

		return getPersistence().findByPrimaryKey(tagcloudId);
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 */
	public static Tagcloud fetchByPrimaryKey(long tagcloudId) {
		return getPersistence().fetchByPrimaryKey(tagcloudId);
	}

	/**
	 * Returns all the tagclouds.
	 *
	 * @return the tagclouds
	 */
	public static List<Tagcloud> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 */
	public static List<Tagcloud> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tagclouds
	 */
	@Deprecated
	public static List<Tagcloud> findAll(
		int start, int end, OrderByComparator<Tagcloud> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tagclouds
	 */
	public static List<Tagcloud> findAll(
		int start, int end, OrderByComparator<Tagcloud> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the tagclouds from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TagcloudPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TagcloudPersistence, TagcloudPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TagcloudPersistence.class);

		ServiceTracker<TagcloudPersistence, TagcloudPersistence>
			serviceTracker =
				new ServiceTracker<TagcloudPersistence, TagcloudPersistence>(
					bundle.getBundleContext(), TagcloudPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}