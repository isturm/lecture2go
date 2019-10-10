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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Lectureseries. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see LectureseriesLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LectureseriesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LectureseriesLocalServiceUtil} to access the lectureseries local service. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.LectureseriesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the lectureseries to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Lectureseries addLectureseries(Lectureseries lectureseries);

	/**
	 * Creates a new lectureseries with the primary key. Does not add the lectureseries to the database.
	 *
	 * @param lectureseriesId the primary key for the new lectureseries
	 * @return the new lectureseries
	 */
	@Transactional(enabled = false)
	public Lectureseries createLectureseries(long lectureseriesId);

	/**
	 * Deletes the lectureseries from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Lectureseries deleteLectureseries(Lectureseries lectureseries);

	/**
	 * Deletes the lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries that was removed
	 * @throws PortalException if a lectureseries with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Lectureseries deleteLectureseries(long lectureseriesId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lectureseries fetchLectureseries(long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getAll() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getAllForVideo(Video video);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getAllLectureseriesWhithOpenaccessVideos();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getAllLectureseriesWhithPassword();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getByKeyWordsAndCompanyId(
			String keywords, Long companyId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getByLatestVideoId(Long latestVideoId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getByTerm(Long termId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lectureseries getByUSID(String usid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getFilteredByApprovedSemesterFacultyProducer(
		Integer approved, Long semester, Long facultyId, Long producerId,
		Long groupId, Long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<Term, List<Lectureseries>>
		getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(
			Integer approved, Long semester, Long facultyId, Long producerId,
			Long groupId, Long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries>
		getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
			Long institutionId, Long parentInstitutionId, Long termId,
			Long categoryId, Long creatorId, String searchQuery, Long groupId,
			Long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getLatest(
		int limit, Long groupId, Long companyId);

	/**
	 * Returns the lectureseries with the primary key.
	 *
	 * @param lectureseriesId the primary key of the lectureseries
	 * @return the lectureseries
	 * @throws PortalException if a lectureseries with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lectureseries getLectureseries(long lectureseriesId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lectureseries> getLectureserieses(int start, int end);

	/**
	 * Returns the number of lectureserieses.
	 *
	 * @return the number of lectureserieses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLectureseriesesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void updateCategoryForLectureseries(
			Long lectureseriesId, Long newCategoryId)
		throws NoSuchModelException, SystemException;

	/**
	 * Updates the lectureseries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseries the lectureseries
	 * @return the lectureseries that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Lectureseries updateLectureseries(Lectureseries lectureseries);

	public void updateOpenAccess(Video video, Lectureseries lectureseries)
		throws SystemException;

	public void updatePreviewVideoOpenAccess(Lectureseries lectureseries)
		throws SystemException;

	public void updateUploadAndGenerationDate() throws SystemException;

}