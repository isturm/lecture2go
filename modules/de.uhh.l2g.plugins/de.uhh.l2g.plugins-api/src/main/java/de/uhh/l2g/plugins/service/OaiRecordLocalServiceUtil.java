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

package de.uhh.l2g.plugins.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OaiRecord. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.OaiRecordLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see OaiRecordLocalService
 * @generated
 */
public class OaiRecordLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.OaiRecordLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the oai record to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord the oai record
	 * @return the oai record that was added
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord addOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord) {

		return getService().addOaiRecord(oaiRecord);
	}

	/**
	 * Creates a new oai record with the primary key. Does not add the oai record to the database.
	 *
	 * @param oaiRecordId the primary key for the new oai record
	 * @return the new oai record
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord createOaiRecord(
		long oaiRecordId) {

		return getService().createOaiRecord(oaiRecordId);
	}

	/**
	 * Deletes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws PortalException if a oai record with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord deleteOaiRecord(
			long oaiRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteOaiRecord(oaiRecordId);
	}

	/**
	 * Deletes the oai record from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord the oai record
	 * @return the oai record that was removed
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord deleteOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord) {

		return getService().deleteOaiRecord(oaiRecord);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.OaiRecord fetchOaiRecord(
		long oaiRecordId) {

		return getService().fetchOaiRecord(oaiRecordId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the oai record with the primary key.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record
	 * @throws PortalException if a oai record with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord getOaiRecord(
			long oaiRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOaiRecord(oaiRecordId);
	}

	/**
	 * Returns a range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @return the range of oai records
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.OaiRecord>
		getOaiRecords(int start, int end) {

		return getService().getOaiRecords(start, end);
	}

	/**
	 * Returns the number of oai records.
	 *
	 * @return the number of oai records
	 */
	public static int getOaiRecordsCount() {
		return getService().getOaiRecordsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the oai record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecord the oai record
	 * @return the oai record that was updated
	 */
	public static de.uhh.l2g.plugins.model.OaiRecord updateOaiRecord(
		de.uhh.l2g.plugins.model.OaiRecord oaiRecord) {

		return getService().updateOaiRecord(oaiRecord);
	}

	public static OaiRecordLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OaiRecordLocalService, OaiRecordLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OaiRecordLocalService.class);

		ServiceTracker<OaiRecordLocalService, OaiRecordLocalService>
			serviceTracker =
				new ServiceTracker
					<OaiRecordLocalService, OaiRecordLocalService>(
						bundle.getBundleContext(), OaiRecordLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}