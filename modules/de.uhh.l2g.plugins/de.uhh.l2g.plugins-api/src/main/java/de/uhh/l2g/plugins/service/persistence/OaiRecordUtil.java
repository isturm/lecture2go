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

import de.uhh.l2g.plugins.model.OaiRecord;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the oai record service. This utility wraps <code>de.uhh.l2g.plugins.service.persistence.impl.OaiRecordPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecordPersistence
 * @generated
 */
public class OaiRecordUtil {

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
	public static void clearCache(OaiRecord oaiRecord) {
		getPersistence().clearCache(oaiRecord);
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
	public static Map<Serializable, OaiRecord> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OaiRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OaiRecord> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OaiRecord update(OaiRecord oaiRecord) {
		return getPersistence().update(oaiRecord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OaiRecord update(
		OaiRecord oaiRecord, ServiceContext serviceContext) {

		return getPersistence().update(oaiRecord, serviceContext);
	}

	/**
	 * Returns the oai record where videoId = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	public static OaiRecord findByVideo(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().findByVideo(videoId);
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public static OaiRecord fetchByVideo(long videoId) {
		return getPersistence().fetchByVideo(videoId);
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public static OaiRecord fetchByVideo(long videoId, boolean useFinderCache) {
		return getPersistence().fetchByVideo(videoId, useFinderCache);
	}

	/**
	 * Removes the oai record where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @return the oai record that was removed
	 */
	public static OaiRecord removeByVideo(long videoId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().removeByVideo(videoId);
	}

	/**
	 * Returns the number of oai records where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching oai records
	 */
	public static int countByVideo(long videoId) {
		return getPersistence().countByVideo(videoId);
	}

	/**
	 * Returns the oai record where identifier = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	public static OaiRecord findByIdentifier(String identifier)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().findByIdentifier(identifier);
	}

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public static OaiRecord fetchByIdentifier(String identifier) {
		return getPersistence().fetchByIdentifier(identifier);
	}

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identifier the identifier
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public static OaiRecord fetchByIdentifier(
		String identifier, boolean useFinderCache) {

		return getPersistence().fetchByIdentifier(identifier, useFinderCache);
	}

	/**
	 * Removes the oai record where identifier = &#63; from the database.
	 *
	 * @param identifier the identifier
	 * @return the oai record that was removed
	 */
	public static OaiRecord removeByIdentifier(String identifier)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().removeByIdentifier(identifier);
	}

	/**
	 * Returns the number of oai records where identifier = &#63;.
	 *
	 * @param identifier the identifier
	 * @return the number of matching oai records
	 */
	public static int countByIdentifier(String identifier) {
		return getPersistence().countByIdentifier(identifier);
	}

	/**
	 * Caches the oai record in the entity cache if it is enabled.
	 *
	 * @param oaiRecord the oai record
	 */
	public static void cacheResult(OaiRecord oaiRecord) {
		getPersistence().cacheResult(oaiRecord);
	}

	/**
	 * Caches the oai records in the entity cache if it is enabled.
	 *
	 * @param oaiRecords the oai records
	 */
	public static void cacheResult(List<OaiRecord> oaiRecords) {
		getPersistence().cacheResult(oaiRecords);
	}

	/**
	 * Creates a new oai record with the primary key. Does not add the oai record to the database.
	 *
	 * @param oaiRecordId the primary key for the new oai record
	 * @return the new oai record
	 */
	public static OaiRecord create(long oaiRecordId) {
		return getPersistence().create(oaiRecordId);
	}

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	public static OaiRecord remove(long oaiRecordId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().remove(oaiRecordId);
	}

	public static OaiRecord updateImpl(OaiRecord oaiRecord) {
		return getPersistence().updateImpl(oaiRecord);
	}

	/**
	 * Returns the oai record with the primary key or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	public static OaiRecord findByPrimaryKey(long oaiRecordId)
		throws de.uhh.l2g.plugins.exception.NoSuchOaiRecordException {

		return getPersistence().findByPrimaryKey(oaiRecordId);
	}

	/**
	 * Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	 */
	public static OaiRecord fetchByPrimaryKey(long oaiRecordId) {
		return getPersistence().fetchByPrimaryKey(oaiRecordId);
	}

	/**
	 * Returns all the oai records.
	 *
	 * @return the oai records
	 */
	public static List<OaiRecord> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @return the range of oai records
	 */
	public static List<OaiRecord> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai records
	 */
	public static List<OaiRecord> findAll(
		int start, int end, OrderByComparator<OaiRecord> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai records
	 */
	public static List<OaiRecord> findAll(
		int start, int end, OrderByComparator<OaiRecord> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the oai records from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of oai records.
	 *
	 * @return the number of oai records
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OaiRecordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OaiRecordPersistence, OaiRecordPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OaiRecordPersistence.class);

		ServiceTracker<OaiRecordPersistence, OaiRecordPersistence>
			serviceTracker =
				new ServiceTracker<OaiRecordPersistence, OaiRecordPersistence>(
					bundle.getBundleContext(), OaiRecordPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}