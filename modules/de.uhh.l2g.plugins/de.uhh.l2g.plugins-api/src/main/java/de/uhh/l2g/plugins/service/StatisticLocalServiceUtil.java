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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Statistic. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see StatisticLocalService
 * @generated
 */
@ProviderType
public class StatisticLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static de.uhh.l2g.plugins.model.Statistic add(
			int privateVideos, int publicVideos)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().add(privateVideos, publicVideos);
	}

	public static de.uhh.l2g.plugins.model.Statistic addDefaultEntry(
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addDefaultEntry(serviceContext);
	}

	public static de.uhh.l2g.plugins.model.Statistic addEntry(
			int privateVideos, int publicVideos,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addEntry(
			privateVideos, publicVideos, serviceContext);
	}

	/**
	 * Adds the statistic to the database. Also notifies the appropriate model listeners.
	 *
	 * @param statistic the statistic
	 * @return the statistic that was added
	 */
	public static de.uhh.l2g.plugins.model.Statistic addStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic) {

		return getService().addStatistic(statistic);
	}

	/**
	 * Add Database View with same Name
	 */
	public static boolean addVideoStatisticView() {
		return getService().addVideoStatisticView();
	}

	/**
	 * Creates a new statistic with the primary key. Does not add the statistic to the database.
	 *
	 * @param statisticId the primary key for the new statistic
	 * @return the new statistic
	 */
	public static de.uhh.l2g.plugins.model.Statistic createStatistic(
		long statisticId) {

		return getService().createStatistic(statisticId);
	}

	public static de.uhh.l2g.plugins.model.Statistic deleteLinkById(
			long statisticId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteLinkById(statisticId, serviceContext);
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

	/**
	 * Deletes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic that was removed
	 * @throws PortalException if a statistic with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Statistic deleteStatistic(
			long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStatistic(statisticId);
	}

	/**
	 * Deletes the statistic from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statistic the statistic
	 * @return the statistic that was removed
	 */
	public static de.uhh.l2g.plugins.model.Statistic deleteStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic) {

		return getService().deleteStatistic(statistic);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Statistic fetchStatistic(
		long statisticId) {

		return getService().fetchStatistic(statisticId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONObject getAllStatistics()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllStatistics();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Statistic>
			getByCompanyIdandGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByCompanyIdandGroupId(companyId, groupId);
	}

	public static de.uhh.l2g.plugins.model.Statistic getByStatisticId(
			long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByStatisticId(statisticId);
	}

	public static de.uhh.l2g.plugins.model.Statistic getByStatisticId(
			long companyId, long groupId, long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getByStatisticId(companyId, groupId, statisticId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the statistic with the primary key.
	 *
	 * @param statisticId the primary key of the statistic
	 * @return the statistic
	 * @throws PortalException if a statistic with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Statistic getStatistic(
			long statisticId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStatistic(statisticId);
	}

	/**
	 * Returns a range of all the statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.StatisticModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of statistics
	 * @param end the upper bound of the range of statistics (not inclusive)
	 * @return the range of statistics
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Statistic>
		getStatistics(int start, int end) {

		return getService().getStatistics(start, end);
	}

	/**
	 * Returns the number of statistics.
	 *
	 * @return the number of statistics
	 */
	public static int getStatisticsCount() {
		return getService().getStatisticsCount();
	}

	/**
	 * Drop table via custom query
	 * https://web.liferay.com/de/community/wiki/-/wiki/Main/Working+with+Database+Views+in+Liferay
	 */
	public static boolean removeVideoStatisticDefaultTable() {
		return getService().removeVideoStatisticDefaultTable();
	}

	public static de.uhh.l2g.plugins.model.Statistic updateEntry(
			long statisticId, int privateVideos, int publicVideos,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateEntry(
			statisticId, privateVideos, publicVideos, serviceContext);
	}

	/**
	 * Updates the statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param statistic the statistic
	 * @return the statistic that was updated
	 */
	public static de.uhh.l2g.plugins.model.Statistic updateStatistic(
		de.uhh.l2g.plugins.model.Statistic statistic) {

		return getService().updateStatistic(statistic);
	}

	public static StatisticLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatisticLocalService, StatisticLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StatisticLocalService.class);

		ServiceTracker<StatisticLocalService, StatisticLocalService>
			serviceTracker =
				new ServiceTracker
					<StatisticLocalService, StatisticLocalService>(
						bundle.getBundleContext(), StatisticLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}