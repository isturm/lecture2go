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

import de.uhh.l2g.plugins.model.Producer;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the producer service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.ProducerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerPersistence
 * @generated
 */
@ProviderType
public class ProducerUtil {

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
	public static void clearCache(Producer producer) {
		getPersistence().clearCache(producer);
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
	public static Map<Serializable, Producer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Producer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Producer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Producer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Producer update(Producer producer) {
		return getPersistence().update(producer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Producer update(
		Producer producer, ServiceContext serviceContext) {

		return getPersistence().update(producer, serviceContext);
	}

	/**
	 * Returns all the producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching producers
	 */
	public static List<Producer> findByHost(long hostId) {
		return getPersistence().findByHost(hostId);
	}

	/**
	 * Returns a range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByHost(long hostId, int start, int end) {
		return getPersistence().findByHost(hostId, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByHost(long, int, int, OrderByComparator)}
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByHost(
		long hostId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByHost(
			hostId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByHost(
		long hostId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByHost(
			hostId, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByHost_First(
			long hostId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByHost_First(hostId, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByHost_First(
		long hostId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByHost_First(hostId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByHost_Last(
			long hostId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByHost_Last(hostId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByHost_Last(
		long hostId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByHost_Last(hostId, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByHost_PrevAndNext(
			long producerId, long hostId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByHost_PrevAndNext(
			producerId, hostId, orderByComparator);
	}

	/**
	 * Removes all the producers where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	public static void removeByHost(long hostId) {
		getPersistence().removeByHost(hostId);
	}

	/**
	 * Returns the number of producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching producers
	 */
	public static int countByHost(long hostId) {
		return getPersistence().countByHost(hostId);
	}

	/**
	 * Returns all the producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching producers
	 */
	public static List<Producer> findByInstitution(long institutionId) {
		return getPersistence().findByInstitution(institutionId);
	}

	/**
	 * Returns a range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByInstitution(
		long institutionId, int start, int end) {

		return getPersistence().findByInstitution(institutionId, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByInstitution(long, int, int, OrderByComparator)}
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByInstitution(
		long institutionId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByInstitution(
			institutionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByInstitution(
		long institutionId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByInstitution(
			institutionId, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByInstitution_First(
			long institutionId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByInstitution_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByInstitution_First(
		long institutionId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByInstitution_First(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByInstitution_Last(
			long institutionId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByInstitution_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByInstitution_Last(
		long institutionId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByInstitution_Last(
			institutionId, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where institutionId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByInstitution_PrevAndNext(
			long producerId, long institutionId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByInstitution_PrevAndNext(
			producerId, institutionId, orderByComparator);
	}

	/**
	 * Removes all the producers where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public static void removeByInstitution(long institutionId) {
		getPersistence().removeByInstitution(institutionId);
	}

	/**
	 * Returns the number of producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching producers
	 */
	public static int countByInstitution(long institutionId) {
		return getPersistence().countByInstitution(institutionId);
	}

	/**
	 * Returns all the producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching producers
	 */
	public static List<Producer> findByStatus(int approved) {
		return getPersistence().findByStatus(approved);
	}

	/**
	 * Returns a range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByStatus(
		int approved, int start, int end) {

		return getPersistence().findByStatus(approved, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByStatus(int, int, int, OrderByComparator)}
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByStatus(
		int approved, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			approved, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByStatus(
		int approved, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByStatus(
			approved, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByStatus_First(
			int approved, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByStatus_First(approved, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByStatus_First(
		int approved, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByStatus_First(
			approved, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByStatus_Last(
			int approved, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByStatus_Last(approved, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByStatus_Last(
		int approved, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByStatus_Last(approved, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByStatus_PrevAndNext(
			long producerId, int approved,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByStatus_PrevAndNext(
			producerId, approved, orderByComparator);
	}

	/**
	 * Removes all the producers where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	public static void removeByStatus(int approved) {
		getPersistence().removeByStatus(approved);
	}

	/**
	 * Returns the number of producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching producers
	 */
	public static int countByStatus(int approved) {
		return getPersistence().countByStatus(approved);
	}

	/**
	 * Returns the producer where homeDir = &#63; or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByDirectory(String homeDir)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByDirectory(homeDir);
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByDirectory(String)}
	 * @param homeDir the home dir
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Deprecated
	public static Producer fetchByDirectory(
		String homeDir, boolean useFinderCache) {

		return getPersistence().fetchByDirectory(homeDir, useFinderCache);
	}

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param homeDir the home dir
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByDirectory(String homeDir) {
		return getPersistence().fetchByDirectory(homeDir);
	}

	/**
	 * Removes the producer where homeDir = &#63; from the database.
	 *
	 * @param homeDir the home dir
	 * @return the producer that was removed
	 */
	public static Producer removeByDirectory(String homeDir)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().removeByDirectory(homeDir);
	}

	/**
	 * Returns the number of producers where homeDir = &#63;.
	 *
	 * @param homeDir the home dir
	 * @return the number of matching producers
	 */
	public static int countByDirectory(String homeDir) {
		return getPersistence().countByDirectory(homeDir);
	}

	/**
	 * Returns the producer where idNum = &#63; or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param idNum the id num
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByUID(String idNum)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByUID(idNum);
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUID(String)}
	 * @param idNum the id num
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	@Deprecated
	public static Producer fetchByUID(String idNum, boolean useFinderCache) {
		return getPersistence().fetchByUID(idNum, useFinderCache);
	}

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idNum the id num
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByUID(String idNum) {
		return getPersistence().fetchByUID(idNum);
	}

	/**
	 * Removes the producer where idNum = &#63; from the database.
	 *
	 * @param idNum the id num
	 * @return the producer that was removed
	 */
	public static Producer removeByUID(String idNum)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().removeByUID(idNum);
	}

	/**
	 * Returns the number of producers where idNum = &#63;.
	 *
	 * @param idNum the id num
	 * @return the number of matching producers
	 */
	public static int countByUID(String idNum) {
		return getPersistence().countByUID(idNum);
	}

	/**
	 * Returns all the producers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching producers
	 */
	public static List<Producer> findByGroup(long groupId) {
		return getPersistence().findByGroup(groupId);
	}

	/**
	 * Returns a range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByGroup(long groupId, int start, int end) {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByGroup(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByGroup_First(
			long groupId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByGroup_First(
		long groupId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByGroup_Last(
			long groupId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByGroup_Last(
		long groupId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where groupId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByGroup_PrevAndNext(
			long producerId, long groupId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroup_PrevAndNext(
			producerId, groupId, orderByComparator);
	}

	/**
	 * Removes all the producers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroup(long groupId) {
		getPersistence().removeByGroup(groupId);
	}

	/**
	 * Returns the number of producers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching producers
	 */
	public static int countByGroup(long groupId) {
		return getPersistence().countByGroup(groupId);
	}

	/**
	 * Returns all the producers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching producers
	 */
	public static List<Producer> findByCompany(long companyId) {
		return getPersistence().findByCompany(companyId);
	}

	/**
	 * Returns a range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByCompany(
		long companyId, int start, int end) {

		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByCompany(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByCompany_First(
			long companyId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByCompany_First(
		long companyId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByCompany_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByCompany_Last(
			long companyId, OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByCompany_Last(
		long companyId, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByCompany_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where companyId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByCompany_PrevAndNext(
			long producerId, long companyId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByCompany_PrevAndNext(
			producerId, companyId, orderByComparator);
	}

	/**
	 * Removes all the producers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompany(long companyId) {
		getPersistence().removeByCompany(companyId);
	}

	/**
	 * Returns the number of producers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching producers
	 */
	public static int countByCompany(long companyId) {
		return getPersistence().countByCompany(companyId);
	}

	/**
	 * Returns all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching producers
	 */
	public static List<Producer> findByGroupAndCompany(
		long groupId, long companyId) {

		return getPersistence().findByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns a range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public static List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	@Deprecated
	public static List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Producer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public static List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public static Producer findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public static Producer fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Producer> orderByComparator) {

		return getPersistence().fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the producers before and after the current producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer[] findByGroupAndCompany_PrevAndNext(
			long producerId, long groupId, long companyId,
			OrderByComparator<Producer> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByGroupAndCompany_PrevAndNext(
			producerId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the producers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupAndCompany(long groupId, long companyId) {
		getPersistence().removeByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Returns the number of producers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching producers
	 */
	public static int countByGroupAndCompany(long groupId, long companyId) {
		return getPersistence().countByGroupAndCompany(groupId, companyId);
	}

	/**
	 * Caches the producer in the entity cache if it is enabled.
	 *
	 * @param producer the producer
	 */
	public static void cacheResult(Producer producer) {
		getPersistence().cacheResult(producer);
	}

	/**
	 * Caches the producers in the entity cache if it is enabled.
	 *
	 * @param producers the producers
	 */
	public static void cacheResult(List<Producer> producers) {
		getPersistence().cacheResult(producers);
	}

	/**
	 * Creates a new producer with the primary key. Does not add the producer to the database.
	 *
	 * @param producerId the primary key for the new producer
	 * @return the new producer
	 */
	public static Producer create(long producerId) {
		return getPersistence().create(producerId);
	}

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer that was removed
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer remove(long producerId)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().remove(producerId);
	}

	public static Producer updateImpl(Producer producer) {
		return getPersistence().updateImpl(producer);
	}

	/**
	 * Returns the producer with the primary key or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public static Producer findByPrimaryKey(long producerId)
		throws de.uhh.l2g.plugins.exception.NoSuchProducerException {

		return getPersistence().findByPrimaryKey(producerId);
	}

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 */
	public static Producer fetchByPrimaryKey(long producerId) {
		return getPersistence().fetchByPrimaryKey(producerId);
	}

	/**
	 * Returns all the producers.
	 *
	 * @return the producers
	 */
	public static List<Producer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of producers
	 */
	public static List<Producer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producers
	 */
	@Deprecated
	public static List<Producer> findAll(
		int start, int end, OrderByComparator<Producer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producers
	 */
	public static List<Producer> findAll(
		int start, int end, OrderByComparator<Producer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the producers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of producers.
	 *
	 * @return the number of producers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProducerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProducerPersistence, ProducerPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProducerPersistence.class);

		ServiceTracker<ProducerPersistence, ProducerPersistence>
			serviceTracker =
				new ServiceTracker<ProducerPersistence, ProducerPersistence>(
					bundle.getBundleContext(), ProducerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}