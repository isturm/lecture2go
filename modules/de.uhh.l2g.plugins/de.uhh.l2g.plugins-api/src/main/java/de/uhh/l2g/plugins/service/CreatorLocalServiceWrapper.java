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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CreatorLocalService}.
 *
 * @author Iavor Sturm
 * @see CreatorLocalService
 * @generated
 */
@ProviderType
public class CreatorLocalServiceWrapper
	implements CreatorLocalService, ServiceWrapper<CreatorLocalService> {

	public CreatorLocalServiceWrapper(CreatorLocalService creatorLocalService) {
		_creatorLocalService = creatorLocalService;
	}

	/**
	 * Adds the creator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Creator addCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return _creatorLocalService.addCreator(creator);
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	@Override
	public de.uhh.l2g.plugins.model.Creator createCreator(long creatorId) {
		return _creatorLocalService.createCreator(creatorId);
	}

	@Override
	public void deleteById(Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		_creatorLocalService.deleteById(id);
	}

	/**
	 * Deletes the creator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Creator deleteCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return _creatorLocalService.deleteCreator(creator);
	}

	/**
	 * Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws PortalException if a creator with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Creator deleteCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creatorLocalService.deleteCreator(creatorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creatorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creatorLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _creatorLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _creatorLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _creatorLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _creatorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _creatorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Creator fetchCreator(long creatorId) {
		return _creatorLocalService.fetchCreator(creatorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _creatorLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getAll();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getAllByCompany(
			Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getAllByCompany(companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getAllByGroup(
			Long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getAllByGroup(groupId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getByFullName(
			String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getByFullName(fullName);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByJobTitleFirstNameMiddleNameLastNameFullName(
				String jobTitle, String firstName, String middleName,
				String lastName, String fullName, boolean isAndOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.
			getByJobTitleFirstNameMiddleNameLastNameFullName(
				jobTitle, firstName, middleName, lastName, fullName,
				isAndOperator);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(
				String jobTitle, String firstName, String middleName,
				String lastName, String fullName, Long companyId,
				boolean isAndOperator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.
			getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(
				jobTitle, firstName, middleName, lastName, fullName, companyId,
				isAndOperator);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getByKeyWordsAnd(
			String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getByKeyWordsAnd(keywords);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
			getByKeyWordsAndCompanyId(String keywords, Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getByKeyWordsAndCompanyId(
			keywords, companyId);
	}

	@Override
	public String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
		Long lectureseriesId, int maxCreators) {

		return _creatorLocalService.
			getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
				lectureseriesId, maxCreators);
	}

	@Override
	public String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators) {

		return _creatorLocalService.
			getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
				videoId, maxCreators);
	}

	@Override
	public String
		getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
			Long lectureseriesId, int maxCreators) {

		return _creatorLocalService.
			getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
				lectureseriesId, maxCreators);
	}

	@Override
	public String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators) {

		return _creatorLocalService.
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
	@Override
	public de.uhh.l2g.plugins.model.Creator getCreator(long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creatorLocalService.getCreator(creatorId);
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
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator> getCreators(
		int start, int end) {

		return _creatorLocalService.getCreators(start, end);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByLectureseriesId(Long lectureseriesId) {

		return _creatorLocalService.getCreatorsByLectureseriesId(
			lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
			Long lectureseriesId) {

		return _creatorLocalService.
			getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
				lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsByVideoId(Long videoId) {

		return _creatorLocalService.getCreatorsByVideoId(videoId);
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	@Override
	public int getCreatorsCount() {
		return _creatorLocalService.getCreatorsCount();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsForLectureseriesOverTheAssigenedVideos(
			Long lectureseriesId) {

		return _creatorLocalService.
			getCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
		getCreatorsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds) {

		return _creatorLocalService.getCreatorsFromLectureseriesIdsAndVideoIds(
			lectureseriesIds, videoIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _creatorLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getJSONCreatorArray(
			Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getJSONCreatorArray(creatorId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getJSONCreatorObject(
			Long creatorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.getJSONCreatorObject(creatorId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getJSONCreatorsByLectureseriesId(Long lectureseriesId) {

		return _creatorLocalService.getJSONCreatorsByLectureseriesId(
			lectureseriesId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getJSONCreatorsByVideoId(
		Long videoId) {

		return _creatorLocalService.getJSONCreatorsByVideoId(videoId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _creatorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creatorLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId() {
		_creatorLocalService.
			updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();
	}

	/**
	 * Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Creator updateCreator(
		de.uhh.l2g.plugins.model.Creator creator) {

		return _creatorLocalService.updateCreator(creator);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Creator>
			updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
				Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _creatorLocalService.
			updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
				lectureseriesId);
	}

	@Override
	public CreatorLocalService getWrappedService() {
		return _creatorLocalService;
	}

	@Override
	public void setWrappedService(CreatorLocalService creatorLocalService) {
		_creatorLocalService = creatorLocalService;
	}

	private CreatorLocalService _creatorLocalService;

}