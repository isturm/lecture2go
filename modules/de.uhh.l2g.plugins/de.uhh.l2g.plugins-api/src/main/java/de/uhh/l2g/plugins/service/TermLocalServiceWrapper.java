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
 * Provides a wrapper for {@link TermLocalService}.
 *
 * @author Iavor Sturm
 * @see TermLocalService
 * @generated
 */
@ProviderType
public class TermLocalServiceWrapper
	implements TermLocalService, ServiceWrapper<TermLocalService> {

	public TermLocalServiceWrapper(TermLocalService termLocalService) {
		_termLocalService = termLocalService;
	}

	/**
	 * Adds the term to the database. Also notifies the appropriate model listeners.
	 *
	 * @param term the term
	 * @return the term that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term addTerm(
		de.uhh.l2g.plugins.model.Term term) {

		return _termLocalService.addTerm(term);
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term createTerm(long termId) {
		return _termLocalService.createTerm(termId);
	}

	@Override
	public void deleteById(Long id)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		_termLocalService.deleteById(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws PortalException if a term with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term deleteTerm(long termId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.deleteTerm(termId);
	}

	/**
	 * Deletes the term from the database. Also notifies the appropriate model listeners.
	 *
	 * @param term the term
	 * @return the term that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term deleteTerm(
		de.uhh.l2g.plugins.model.Term term) {

		return _termLocalService.deleteTerm(term);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _termLocalService.dynamicQuery();
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

		return _termLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TermModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _termLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TermModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _termLocalService.dynamicQuery(
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

		return _termLocalService.dynamicQueryCount(dynamicQuery);
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

		return _termLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Term fetchTerm(long termId) {
		return _termLocalService.fetchTerm(termId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _termLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Term> getAllSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _termLocalService.getAllSemesters();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Term> getByCompanyId(
			Long companyId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _termLocalService.getByCompanyId(companyId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Term getById(Long termId)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _termLocalService.getById(termId);
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Term> getByPrefixAndYear(
			String prefix, String year)
		throws com.liferay.portal.kernel.exception.NoSuchModelException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _termLocalService.getByPrefixAndYear(prefix, year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _termLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _termLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the term with the primary key.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws PortalException if a term with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term getTerm(long termId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getTerm(termId);
	}

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.TermModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Term> getTerms(
		int start, int end) {

		return _termLocalService.getTerms(start, end);
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	@Override
	public int getTermsCount() {
		return _termLocalService.getTermsCount();
	}

	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Term>
		getTermsFromLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds) {

		return _termLocalService.getTermsFromLectureseriesIdsAndVideoIds(
			lectureseriesIds, videoIds);
	}

	/**
	 * Updates the term in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param term the term
	 * @return the term that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Term updateTerm(
		de.uhh.l2g.plugins.model.Term term) {

		return _termLocalService.updateTerm(term);
	}

	@Override
	public TermLocalService getWrappedService() {
		return _termLocalService;
	}

	@Override
	public void setWrappedService(TermLocalService termLocalService) {
		_termLocalService = termLocalService;
	}

	private TermLocalService _termLocalService;

}