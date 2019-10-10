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
 * This class is a wrapper for {@link Producer}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer
 * @generated
 */
@ProviderType
public class ProducerWrapper
	extends BaseModelWrapper<Producer>
	implements Producer, ModelWrapper<Producer> {

	public ProducerWrapper(Producer producer) {
		super(producer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerId", getProducerId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("hostId", getHostId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());
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
		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long numberOfProductions = (Long)attributes.get("numberOfProductions");

		if (numberOfProductions != null) {
			setNumberOfProductions(numberOfProductions);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
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
	 * Returns the approved of this producer.
	 *
	 * @return the approved of this producer
	 */
	@Override
	public int getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the company ID of this producer.
	 *
	 * @return the company ID of this producer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this producer.
	 *
	 * @return the create date of this producer
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
	 * Returns the group ID of this producer.
	 *
	 * @return the group ID of this producer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home dir of this producer.
	 *
	 * @return the home dir of this producer
	 */
	@Override
	public String getHomeDir() {
		return model.getHomeDir();
	}

	/**
	 * Returns the host ID of this producer.
	 *
	 * @return the host ID of this producer
	 */
	@Override
	public long getHostId() {
		return model.getHostId();
	}

	/**
	 * Returns the id num of this producer.
	 *
	 * @return the id num of this producer
	 */
	@Override
	public String getIdNum() {
		return model.getIdNum();
	}

	/**
	 * Returns the institution ID of this producer.
	 *
	 * @return the institution ID of this producer
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
	 * Returns the modified date of this producer.
	 *
	 * @return the modified date of this producer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the number of productions of this producer.
	 *
	 * @return the number of productions of this producer
	 */
	@Override
	public long getNumberOfProductions() {
		return model.getNumberOfProductions();
	}

	/**
	 * Returns the primary key of this producer.
	 *
	 * @return the primary key of this producer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the producer ID of this producer.
	 *
	 * @return the producer ID of this producer
	 */
	@Override
	public long getProducerId() {
		return model.getProducerId();
	}

	/**
	 * Returns the user ID of this producer.
	 *
	 * @return the user ID of this producer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this producer.
	 *
	 * @return the user name of this producer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this producer.
	 *
	 * @return the user uuid of this producer
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
	 * Sets the approved of this producer.
	 *
	 * @param approved the approved of this producer
	 */
	@Override
	public void setApproved(int approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the company ID of this producer.
	 *
	 * @param companyId the company ID of this producer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this producer.
	 *
	 * @param createDate the create date of this producer
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
	 * Sets the group ID of this producer.
	 *
	 * @param groupId the group ID of this producer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home dir of this producer.
	 *
	 * @param homeDir the home dir of this producer
	 */
	@Override
	public void setHomeDir(String homeDir) {
		model.setHomeDir(homeDir);
	}

	/**
	 * Sets the host ID of this producer.
	 *
	 * @param hostId the host ID of this producer
	 */
	@Override
	public void setHostId(long hostId) {
		model.setHostId(hostId);
	}

	/**
	 * Sets the id num of this producer.
	 *
	 * @param idNum the id num of this producer
	 */
	@Override
	public void setIdNum(String idNum) {
		model.setIdNum(idNum);
	}

	/**
	 * Sets the institution ID of this producer.
	 *
	 * @param institutionId the institution ID of this producer
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
	 * Sets the modified date of this producer.
	 *
	 * @param modifiedDate the modified date of this producer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the number of productions of this producer.
	 *
	 * @param numberOfProductions the number of productions of this producer
	 */
	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		model.setNumberOfProductions(numberOfProductions);
	}

	/**
	 * Sets the primary key of this producer.
	 *
	 * @param primaryKey the primary key of this producer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producer ID of this producer.
	 *
	 * @param producerId the producer ID of this producer
	 */
	@Override
	public void setProducerId(long producerId) {
		model.setProducerId(producerId);
	}

	/**
	 * Sets the user ID of this producer.
	 *
	 * @param userId the user ID of this producer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this producer.
	 *
	 * @param userName the user name of this producer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this producer.
	 *
	 * @param userUuid the user uuid of this producer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ProducerWrapper wrap(Producer producer) {
		return new ProducerWrapper(producer);
	}

}