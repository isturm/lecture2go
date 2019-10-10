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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Coordinator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Coordinator
 * @generated
 */
@ProviderType
public class CoordinatorWrapper
	extends BaseModelWrapper<Coordinator>
	implements Coordinator, ModelWrapper<Coordinator> {

	public CoordinatorWrapper(Coordinator coordinator) {
		super(coordinator);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coordinatorId", getCoordinatorId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("officeId", getOfficeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coordinatorId = (Long)attributes.get("coordinatorId");

		if (coordinatorId != null) {
			setCoordinatorId(coordinatorId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the company ID of this coordinator.
	 *
	 * @return the company ID of this coordinator
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the coordinator ID of this coordinator.
	 *
	 * @return the coordinator ID of this coordinator
	 */
	@Override
	public long getCoordinatorId() {
		return model.getCoordinatorId();
	}

	/**
	 * Returns the create date of this coordinator.
	 *
	 * @return the create date of this coordinator
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this coordinator.
	 *
	 * @return the group ID of this coordinator
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution ID of this coordinator.
	 *
	 * @return the institution ID of this coordinator
	 */
	@Override
	public long getInstitutionId() {
		return model.getInstitutionId();
	}

	@Override
	public Date getLastLoginDate() {
		return model.getLastLoginDate();
	}

	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this coordinator.
	 *
	 * @return the modified date of this coordinator
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the office ID of this coordinator.
	 *
	 * @return the office ID of this coordinator
	 */
	@Override
	public long getOfficeId() {
		return model.getOfficeId();
	}

	/**
	 * Returns the primary key of this coordinator.
	 *
	 * @return the primary key of this coordinator
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this coordinator.
	 *
	 * @return the user ID of this coordinator
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this coordinator.
	 *
	 * @return the user name of this coordinator
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this coordinator.
	 *
	 * @return the user uuid of this coordinator
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this coordinator.
	 *
	 * @param companyId the company ID of this coordinator
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the coordinator ID of this coordinator.
	 *
	 * @param coordinatorId the coordinator ID of this coordinator
	 */
	@Override
	public void setCoordinatorId(long coordinatorId) {
		model.setCoordinatorId(coordinatorId);
	}

	/**
	 * Sets the create date of this coordinator.
	 *
	 * @param createDate the create date of this coordinator
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this coordinator.
	 *
	 * @param groupId the group ID of this coordinator
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution ID of this coordinator.
	 *
	 * @param institutionId the institution ID of this coordinator
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		model.setInstitutionId(institutionId);
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		model.setLastLoginDate(lastLoginDate);
	}

	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this coordinator.
	 *
	 * @param modifiedDate the modified date of this coordinator
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the office ID of this coordinator.
	 *
	 * @param officeId the office ID of this coordinator
	 */
	@Override
	public void setOfficeId(long officeId) {
		model.setOfficeId(officeId);
	}

	/**
	 * Sets the primary key of this coordinator.
	 *
	 * @param primaryKey the primary key of this coordinator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this coordinator.
	 *
	 * @param userId the user ID of this coordinator
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this coordinator.
	 *
	 * @param userName the user name of this coordinator
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this coordinator.
	 *
	 * @param userUuid the user uuid of this coordinator
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CoordinatorWrapper wrap(Coordinator coordinator) {
		return new CoordinatorWrapper(coordinator);
	}

}