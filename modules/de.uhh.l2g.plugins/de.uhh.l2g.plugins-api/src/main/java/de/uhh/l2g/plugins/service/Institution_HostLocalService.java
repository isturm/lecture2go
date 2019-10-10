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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Institution_Host. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see Institution_HostLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface Institution_HostLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Institution_HostLocalServiceUtil} to access the institution_ host local service. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.Institution_HostLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * if not added with Institution
	 *
	 * @throws SystemException
	 * @throws PortalException
	 */
	public long addDefaultInstitutionHost(
			long defaultInstitutionId, long defaultHostId,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Institution_Host addEntry(
			long institutionId, long hostId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Adds the institution_ host to the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Institution_Host addInstitution_Host(
		Institution_Host institution_Host);

	/**
	 * Creates a new institution_ host with the primary key. Does not add the institution_ host to the database.
	 *
	 * @param institutionHostId the primary key for the new institution_ host
	 * @return the new institution_ host
	 */
	@Transactional(enabled = false)
	public Institution_Host createInstitution_Host(long institutionHostId);

	/**
	 * Deletes the institution_ host from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Institution_Host deleteInstitution_Host(
		Institution_Host institution_Host);

	/**
	 * Deletes the institution_ host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host that was removed
	 * @throws PortalException if a institution_ host with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Institution_Host deleteInstitution_Host(long institutionHostId)
		throws PortalException;

	public Institution_Host deleteLinkById(long institutionHostId)
		throws PortalException, SystemException;

	public Institution_Host deleteLinkById(
			long institutionHostId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Institution_Host deleteLinkByInstitution(
			Institution institution, long groupId, long companyId)
		throws PortalException, SystemException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public Institution_Host fetchInstitution_Host(long institutionHostId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getByCompanyIdAndHostIdCount(long companyId, long hostId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution_Host> getByGroupId(long groupId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByGroupIdAndHostId(long groupId, long hostId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getByGroupIdAndHostIdCount(long groupId, long hostId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Host getByGroupIdAndInstitutionId(
			long companyId, long groupId, long institutionId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Host getByInstitution(long institutionId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Host getByInstitutionId(long institutionId)
		throws PortalException, SystemException;

	/**
	 * Assume one Institution has at most one Host that remains constant
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDefaultInstitutionHostId(long companyId, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the institution_ host with the primary key.
	 *
	 * @param institutionHostId the primary key of the institution_ host
	 * @return the institution_ host
	 * @throws PortalException if a institution_ host with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution_Host getInstitution_Host(long institutionHostId)
		throws PortalException;

	/**
	 * Returns a range of all the institution_ hosts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of institution_ hosts
	 * @param end the upper bound of the range of institution_ hosts (not inclusive)
	 * @return the range of institution_ hosts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution_Host> getInstitution_Hosts(int start, int end);

	/**
	 * Returns the number of institution_ hosts.
	 *
	 * @return the number of institution_ hosts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getInstitution_HostsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution_Host getLinkByGroupIdAndInstitutionId(
			long groupId, long institutionId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution_Host> getListByGroupIdAndHostId(
			long groupId, long hostId)
		throws PortalException, SystemException;

	/**
	 * Actually this should never give a list because, there can be only one host per isntitution
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution_Host> getListByGroupIdAndInstitutionId(
			long companyId, long groupId, long institutionId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution_Host> getListByInstitutionId(long institutionId)
		throws PortalException, SystemException;

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

	public Institution_Host updateEntry(
			long institutionId, long hostId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Updates the institution_ host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param institution_Host the institution_ host
	 * @return the institution_ host that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Institution_Host updateInstitution_Host(
		Institution_Host institution_Host);

}