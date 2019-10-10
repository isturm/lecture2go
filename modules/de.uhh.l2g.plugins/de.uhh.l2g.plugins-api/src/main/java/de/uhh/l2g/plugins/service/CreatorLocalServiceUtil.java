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
 * Provides the local service utility for Creator. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see CreatorLocalService
 * @generated
 */
@ProviderType
public class CreatorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the creator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was added
	 */
	public static de.uhh.l2g.plugins.model.Creator addCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return getService().addCreator(creator);
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	public static de.uhh.l2g.plugins.model.Creator createCreator(
		long creatorId) {

		return getService().createCreator(creatorId);
	}

	public static void deleteById(Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().deleteById(id);
	}

	/**
	 * Deletes the creator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was removed
	 */
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return getService().deleteCreator(creator);
	}

	/**
	 * Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws PortalException if a creator with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Creator deleteCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCreator(creatorId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.uhh.l2g.plugins.model.Creator fetchCreator(
		long creatorId) {

		return getService().fetchCreator(creatorId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAll();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getAllByCompany(Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllByCompany(companyId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getAllByGroup(Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllByGroup(groupId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByFullName(String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByFullName(fullName);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByJobTitleFirstNameMiddleNameLastNameFullName(
				String jobTitle, String firstName, String middleName,
				String lastName, String fullName, boolean isAndOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByJobTitleFirstNameMiddleNameLastNameFullName(
			jobTitle, firstName, middleName, lastName, fullName, isAndOperator);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(
				String jobTitle, String firstName, String middleName,
				String lastName, String fullName, Long companyId,
				boolean isAndOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().
			getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(
				jobTitle, firstName, middleName, lastName, fullName, companyId,
				isAndOperator);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByKeyWordsAnd(String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByKeyWordsAnd(keywords);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByKeyWordsAndCompanyId(String keywords, Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByKeyWordsAndCompanyId(keywords, companyId);
	}

	public static String
		getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
			Long lectureseriesId, int maxCreators) {

		return getService().
			getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
				lectureseriesId, maxCreators);
	}

	public static String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators) {

		return getService().getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
			videoId, maxCreators);
	}

	public static String
		getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
			Long lectureseriesId, int maxCreators) {

		return getService().
			getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
				lectureseriesId, maxCreators);
	}

	public static String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators) {

		return getService().
			getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
				videoId, maxCreators);
	}

	/**
	 * Returns the creator with the primary key.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws PortalException if a creator with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Creator getCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCreator(creatorId);
	}

	/**
	 * Returns a range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of creators
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Creator> getCreators(
		int start, int end) {

		return getService().getCreators(start, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByLectureseriesId(Long lectureseriesId) {

		return getService().getCreatorsByLectureseriesId(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
			Long lectureseriesId) {

		return getService().getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
			lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByVideoId(Long videoId) {

		return getService().getCreatorsByVideoId(videoId);
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	public static int getCreatorsCount() {
		return getService().getCreatorsCount();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsForLectureseriesOverTheAssigenedVideos(
			Long lectureseriesId) {

		return getService().getCreatorsForLectureseriesOverTheAssigenedVideos(
			lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds) {

		return getService().getCreatorsFromLectureseriesIdsAndVideoIds(
			lectureseriesIds, videoIds);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONCreatorArray(
			Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getJSONCreatorArray(creatorId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getJSONCreatorObject(Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getJSONCreatorObject(creatorId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getJSONCreatorsByLectureseriesId(Long lectureseriesId) {

		return getService().getJSONCreatorsByLectureseriesId(lectureseriesId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getJSONCreatorsByVideoId(Long videoId) {

		return getService().getJSONCreatorsByVideoId(videoId);
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

	public static void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId() {
		getService().
			updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();
	}

	/**
	 * Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was updated
	 */
	public static de.uhh.l2g.plugins.model.Creator updateCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return getService().updateCreator(creator);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Creator>
			updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
				Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().
			updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
				lectureseriesId);
	}

	public static CreatorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CreatorLocalService, CreatorLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CreatorLocalService.class);

		ServiceTracker<CreatorLocalService, CreatorLocalService>
			serviceTracker =
				new ServiceTracker<CreatorLocalService, CreatorLocalService>(
					bundle.getBundleContext(), CreatorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}