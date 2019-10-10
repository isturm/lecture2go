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
 * Provides a wrapper for {@link VideohitlistLocalService}.
 *
 * @author Iavor Sturm
 * @see VideohitlistLocalService
 * @generated
 */
@ProviderType
public class VideohitlistLocalServiceWrapper
	implements VideohitlistLocalService,
			   ServiceWrapper<VideohitlistLocalService> {

	public VideohitlistLocalServiceWrapper(
		VideohitlistLocalService videohitlistLocalService) {

		_videohitlistLocalService = videohitlistLocalService;
	}

	/**
	 * Adds the videohitlist to the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlist the videohitlist
	 * @return the videohitlist that was added
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist addVideohitlist(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist) {

		return _videohitlistLocalService.addVideohitlist(videohitlist);
	}

	/**
	 * Creates a new videohitlist with the primary key. Does not add the videohitlist to the database.
	 *
	 * @param videohitlistId the primary key for the new videohitlist
	 * @return the new videohitlist
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist createVideohitlist(
		long videohitlistId) {

		return _videohitlistLocalService.createVideohitlist(videohitlistId);
	}

	@Override
	public void deleteAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		_videohitlistLocalService.deleteAll();
	}

	@Override
	public void deleteByVideoId(Long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_videohitlistLocalService.deleteByVideoId(videoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videohitlistLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the videohitlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist that was removed
	 * @throws PortalException if a videohitlist with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist deleteVideohitlist(
			long videohitlistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videohitlistLocalService.deleteVideohitlist(videohitlistId);
	}

	/**
	 * Deletes the videohitlist from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlist the videohitlist
	 * @return the videohitlist that was removed
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist deleteVideohitlist(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist) {

		return _videohitlistLocalService.deleteVideohitlist(videohitlist);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videohitlistLocalService.dynamicQuery();
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

		return _videohitlistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _videohitlistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _videohitlistLocalService.dynamicQuery(
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

		return _videohitlistLocalService.dynamicQueryCount(dynamicQuery);
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

		return _videohitlistLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Videohitlist fetchVideohitlist(
		long videohitlistId) {

		return _videohitlistLocalService.fetchVideohitlist(videohitlistId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _videohitlistLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _videohitlistLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _videohitlistLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videohitlistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the videohitlist with the primary key.
	 *
	 * @param videohitlistId the primary key of the videohitlist
	 * @return the videohitlist
	 * @throws PortalException if a videohitlist with the primary key could not be found
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist getVideohitlist(
			long videohitlistId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videohitlistLocalService.getVideohitlist(videohitlistId);
	}

	/**
	 * Returns a range of all the videohitlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideohitlistModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videohitlists
	 * @param end the upper bound of the range of videohitlists (not inclusive)
	 * @return the range of videohitlists
	 */
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Videohitlist>
		getVideohitlists(int start, int end) {

		return _videohitlistLocalService.getVideohitlists(start, end);
	}

	/**
	 * Returns the number of videohitlists.
	 *
	 * @return the number of videohitlists
	 */
	@Override
	public int getVideohitlistsCount() {
		return _videohitlistLocalService.getVideohitlistsCount();
	}

	/**
	 * Updates the videohitlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param videohitlist the videohitlist
	 * @return the videohitlist that was updated
	 */
	@Override
	public de.uhh.l2g.plugins.model.Videohitlist updateVideohitlist(
		de.uhh.l2g.plugins.model.Videohitlist videohitlist) {

		return _videohitlistLocalService.updateVideohitlist(videohitlist);
	}

	@Override
	public VideohitlistLocalService getWrappedService() {
		return _videohitlistLocalService;
	}

	@Override
	public void setWrappedService(
		VideohitlistLocalService videohitlistLocalService) {

		_videohitlistLocalService = videohitlistLocalService;
	}

	private VideohitlistLocalService _videohitlistLocalService;

}