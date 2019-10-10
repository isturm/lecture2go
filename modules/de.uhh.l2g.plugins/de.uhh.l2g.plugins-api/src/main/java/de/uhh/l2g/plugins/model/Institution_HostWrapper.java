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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Institution_Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution_Host
 * @generated
 */
@ProviderType
public class Institution_HostWrapper
	extends BaseModelWrapper<Institution_Host>
	implements Institution_Host, ModelWrapper<Institution_Host> {

	public Institution_HostWrapper(Institution_Host institution_Host) {
		super(institution_Host);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionHostId", getInstitutionHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("hostId", getHostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionHostId = (Long)attributes.get("institutionHostId");

		if (institutionHostId != null) {
			setInstitutionHostId(institutionHostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this institution_ host.
	 *
	 * @return the company ID of this institution_ host
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this institution_ host.
	 *
	 * @return the group ID of this institution_ host
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the host ID of this institution_ host.
	 *
	 * @return the host ID of this institution_ host
	 */
	@Override
	public long getHostId() {
		return model.getHostId();
	}

	/**
	 * Returns the institution host ID of this institution_ host.
	 *
	 * @return the institution host ID of this institution_ host
	 */
	@Override
	public long getInstitutionHostId() {
		return model.getInstitutionHostId();
	}

	/**
	 * Returns the institution ID of this institution_ host.
	 *
	 * @return the institution ID of this institution_ host
	 */
	@Override
	public long getInstitutionId() {
		return model.getInstitutionId();
	}

	/**
	 * Returns the primary key of this institution_ host.
	 *
	 * @return the primary key of this institution_ host
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this institution_ host.
	 *
	 * @param companyId the company ID of this institution_ host
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this institution_ host.
	 *
	 * @param groupId the group ID of this institution_ host
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the host ID of this institution_ host.
	 *
	 * @param hostId the host ID of this institution_ host
	 */
	@Override
	public void setHostId(long hostId) {
		model.setHostId(hostId);
	}

	/**
	 * Sets the institution host ID of this institution_ host.
	 *
	 * @param institutionHostId the institution host ID of this institution_ host
	 */
	@Override
	public void setInstitutionHostId(long institutionHostId) {
		model.setInstitutionHostId(institutionHostId);
	}

	/**
	 * Sets the institution ID of this institution_ host.
	 *
	 * @param institutionId the institution ID of this institution_ host
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		model.setInstitutionId(institutionId);
	}

	/**
	 * Sets the primary key of this institution_ host.
	 *
	 * @param primaryKey the primary key of this institution_ host
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected Institution_HostWrapper wrap(Institution_Host institution_Host) {
		return new Institution_HostWrapper(institution_Host);
	}

}