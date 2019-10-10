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
 * Provides a wrapper for {@link LectureseriesLocalService}.
 *
 * @author Iavor Sturm
 * @see LectureseriesLocalService
 * @generated
 */
@ProviderType
public class LectureseriesLocalServiceWrapper
	implements LectureseriesLocalService,
			   ServiceWrapper<LectureseriesLocalService> {

	public LectureseriesLocalServiceWrapper(
		LectureseriesLocalService lectureseriesLocalService) {

		_lectureseriesLocalService = lectureseriesLocalService;
	}

	/**
	 * Adds the lectureseries to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries addLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {

		return _lectureseriesLocalService.addLectureseries(lectureseries);
	}

	/**
	 * Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	 *
	 * @param lectureseriesId the primary key for the new lectureseries
	 * @return the new lectureseries
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries createLectureseries(
		long lectureseriesId) {

		return _lectureseriesLocalService.createLectureseries(lectureseriesId);
	}

	/**
	 * Deletes the lectureseries from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {

		return _lectureseriesLocalService.deleteLectureseries(lectureseries);
	}

	/**
	 * Deletes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws PortalException if a lectureseries with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries deleteLectureseries(
			long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseriesLocalService.deleteLectureseries(lectureseriesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseriesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lectureseriesLocalService.dynamicQuery();
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

		return _lectureseriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lectureseriesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lectureseriesLocalService.dynamicQuery(
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

		return _lectureseriesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lectureseriesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries fetchLectureseries(
		long lectureseriesId) {

		return _lectureseriesLocalService.fetchLectureseries(lectureseriesId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lectureseriesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseriesLocalService.getAll();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getAllForVideo(de.uhh.l2g.plugins.model.Video video) {

		return _lectureseriesLocalService.getAllForVideo(video);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getAllLectureseriesWhithOpenaccessVideos() {

		return _lectureseriesLocalService.
			getAllLectureseriesWhithOpenaccessVideos();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getAllLectureseriesWhithPassword() {

		return _lectureseriesLocalService.getAllLectureseriesWhithPassword();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
			getByKeyWordsAndCompanyId(String keywords, Long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseriesLocalService.getByKeyWordsAndCompanyId(
			keywords, companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
			getByLatestVideoId(Long latestVideoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseriesLocalService.getByLatestVideoId(latestVideoId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getByTerm(
			Long termId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lectureseriesLocalService.getByTerm(termId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Lectureseries getByUSID(String usid) {
		return _lectureseriesLocalService.getByUSID(usid);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getFilteredByApprovedSemesterFacultyProducer(
			Integer approved, Long semester, Long facultyId, Long producerId,
			Long groupId, Long companyId) {

		return _lectureseriesLocalService.
			getFilteredByApprovedSemesterFacultyProducer(
				approved, semester, facultyId, producerId, groupId, companyId);
	}

	@Override
	public java.util.Map
		<de.uhh.l2g.plugins.model.Term,
		 java.util.List<de.uhh.l2g.plugins.model.Lectureseries>>
			getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
				Integer approved, Long semester, Long facultyId,
				Long producerId, Long groupId, Long companyId) {

		return _lectureseriesLocalService.
			getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
				approved, semester, facultyId, producerId, groupId, companyId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
			Long institutionId, Long parentInstitutionId, Long termId,
			Long categoryId, Long creatorId, String searchQuery, Long groupId,
			Long companyId) {

		return _lectureseriesLocalService.
			getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
				institutionId, parentInstitutionId, termId, categoryId,
				creatorId, searchQuery, groupId, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lectureseriesLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> getLatest(
		int limit, Long groupId, Long companyId) {

		return _lectureseriesLocalService.getLatest(limit, groupId, companyId);
	}

	/**
	 * Returns the lectureseries with the primary key.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws PortalException if a lectureseries with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries getLectureseries(
			long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseriesLocalService.getLectureseries(lectureseriesId);
	}

	/**
	 * Returns a range of all the lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureserieses
	 * @param end the upper bound of the range of lectureserieses (not inclusive)
	 * @return the range of lectureserieses
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		getLectureserieses(int start, int end) {

		return _lectureseriesLocalService.getLectureserieses(start, end);
	}

	/**
	 * Returns the number of lectureserieses.
	 *
	 * @return the number of lectureserieses
	 */
	@Override
	public int getLectureseriesesCount() {
		return _lectureseriesLocalService.getLectureseriesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lectureseriesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseriesLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void updateCategoryForLectureseries(
			Long lectureseriesId, Long newCategoryId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		_lectureseriesLocalService.updateCategoryForLectureseries(
			lectureseriesId, newCategoryId);
	}

	/**
	 * Updates the lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Lectureseries updateLectureseries(
		de.uhh.l2g.plugins.model.Lectureseries lectureseries) {

		return _lectureseriesLocalService.updateLectureseries(lectureseries);
	}

	@Override
	public void updateOpenAccess(
			de.uhh.l2g.plugins.model.Video video,
			de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {

		_lectureseriesLocalService.updateOpenAccess(video, lectureseries);
	}

	@Override
	public void updatePreviewVideoOpenAccess(
			de.uhh.l2g.plugins.model.Lectureseries lectureseries)
		throws com.liferay.portal.kernel.exception.SystemException {

		_lectureseriesLocalService.updatePreviewVideoOpenAccess(lectureseries);
	}

	@Override
	public void updateUploadAndGenerationDate()
		throws com.liferay.portal.kernel.exception.SystemException {

		_lectureseriesLocalService.updateUploadAndGenerationDate();
	}

	@Override
	public LectureseriesLocalService getWrappedService() {
		return _lectureseriesLocalService;
	}

	@Override
	public void setWrappedService(
		LectureseriesLocalService lectureseriesLocalService) {

		_lectureseriesLocalService = lectureseriesLocalService;
	}

	private LectureseriesLocalService _lectureseriesLocalService;

}