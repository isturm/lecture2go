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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Creator;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Creator. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see CreatorLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CreatorLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreatorLocalServiceUtil} to access the creator local service. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.CreatorLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the creator to the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Creator addCreator(Creator creator);

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	@Transactional(enabled = false)
	public Creator createCreator(long creatorId);

	public void deleteById(Long id)
		throws NoSuchModelException, SystemException;

	/**
	 * Deletes the creator from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Creator deleteCreator(Creator creator);

	/**
	 * Deletes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws PortalException if a creator with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Creator deleteCreator(long creatorId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public Creator fetchCreator(long creatorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getAll() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getAllByCompany(Long companyId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getAllByGroup(Long groupId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getByFullName(String fullName) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getByJobTitleFirstNameMiddleNameLastNameFullName(
			String jobTitle, String firstName, String middleName,
			String lastName, String fullName, boolean isAndOperator)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator>
			getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(
				String jobTitle, String firstName, String middleName,
				String lastName, String fullName, Long companyId,
				boolean isAndOperator)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getByKeyWordsAnd(String keywords)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getByKeyWordsAndCompanyId(
			String keywords, Long companyId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(
		Long lectureseriesId, int maxCreators);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String
		getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(
			Long lectureseriesId, int maxCreators);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(
		Long videoId, int maxCreators);

	/**
	 * Returns the creator with the primary key.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws PortalException if a creator with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Creator getCreator(long creatorId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreators(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreatorsByLectureseriesId(Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreatorsByLectureseriesIdForOpenAccessVideosOnly(
		Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreatorsByVideoId(Long videoId);

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCreatorsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreatorsForLectureseriesOverTheAssigenedVideos(
		Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Creator> getCreatorsFromLectureseriesIdsAndVideoIds(
		ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getJSONCreatorArray(Long creatorId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getJSONCreatorObject(Long creatorId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getJSONCreatorsByLectureseriesId(Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getJSONCreatorsByVideoId(Long videoId);

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

	public void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId();

	/**
	 * Updates the creator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param creator the creator
	 * @return the creator that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Creator updateCreator(Creator creator);

	public List<Creator>
			updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(
				Long lectureseriesId)
		throws SystemException;

}