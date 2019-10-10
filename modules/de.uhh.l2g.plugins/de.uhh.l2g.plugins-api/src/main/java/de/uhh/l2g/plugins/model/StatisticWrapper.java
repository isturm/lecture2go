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
 * This class is a wrapper for {@link Statistic}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Statistic
 * @generated
 */
@ProviderType
public class StatisticWrapper
	extends BaseModelWrapper<Statistic>
	implements Statistic, ModelWrapper<Statistic> {

	public StatisticWrapper(Statistic statistic) {
		super(statistic);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("createDate", getCreateDate());
		attributes.put("publicVideos", getPublicVideos());
		attributes.put("privateVideos", getPrivateVideos());
		attributes.put("autofillRow", getAutofillRow());
		attributes.put("statisticId", getStatisticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Integer publicVideos = (Integer)attributes.get("publicVideos");

		if (publicVideos != null) {
			setPublicVideos(publicVideos);
		}

		Integer privateVideos = (Integer)attributes.get("privateVideos");

		if (privateVideos != null) {
			setPrivateVideos(privateVideos);
		}

		Integer autofillRow = (Integer)attributes.get("autofillRow");

		if (autofillRow != null) {
			setAutofillRow(autofillRow);
		}

		Long statisticId = (Long)attributes.get("statisticId");

		if (statisticId != null) {
			setStatisticId(statisticId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the autofill row of this statistic.
	 *
	 * @return the autofill row of this statistic
	 */
	@Override
	public int getAutofillRow() {
		return model.getAutofillRow();
	}

	/**
	 * Returns the company ID of this statistic.
	 *
	 * @return the company ID of this statistic
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this statistic.
	 *
	 * @return the create date of this statistic
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this statistic.
	 *
	 * @return the group ID of this statistic
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this statistic.
	 *
	 * @return the modified date of this statistic
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this statistic.
	 *
	 * @return the primary key of this statistic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the private videos of this statistic.
	 *
	 * @return the private videos of this statistic
	 */
	@Override
	public int getPrivateVideos() {
		return model.getPrivateVideos();
	}

	/**
	 * Returns the public videos of this statistic.
	 *
	 * @return the public videos of this statistic
	 */
	@Override
	public int getPublicVideos() {
		return model.getPublicVideos();
	}

	/**
	 * Returns the statistic ID of this statistic.
	 *
	 * @return the statistic ID of this statistic
	 */
	@Override
	public long getStatisticId() {
		return model.getStatisticId();
	}

	/**
	 * Returns the user ID of this statistic.
	 *
	 * @return the user ID of this statistic
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this statistic.
	 *
	 * @return the user name of this statistic
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this statistic.
	 *
	 * @return the user uuid of this statistic
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
	 * Sets the autofill row of this statistic.
	 *
	 * @param autofillRow the autofill row of this statistic
	 */
	@Override
	public void setAutofillRow(int autofillRow) {
		model.setAutofillRow(autofillRow);
	}

	/**
	 * Sets the company ID of this statistic.
	 *
	 * @param companyId the company ID of this statistic
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this statistic.
	 *
	 * @param createDate the create date of this statistic
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this statistic.
	 *
	 * @param groupId the group ID of this statistic
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this statistic.
	 *
	 * @param modifiedDate the modified date of this statistic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this statistic.
	 *
	 * @param primaryKey the primary key of this statistic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the private videos of this statistic.
	 *
	 * @param privateVideos the private videos of this statistic
	 */
	@Override
	public void setPrivateVideos(int privateVideos) {
		model.setPrivateVideos(privateVideos);
	}

	/**
	 * Sets the public videos of this statistic.
	 *
	 * @param publicVideos the public videos of this statistic
	 */
	@Override
	public void setPublicVideos(int publicVideos) {
		model.setPublicVideos(publicVideos);
	}

	/**
	 * Sets the statistic ID of this statistic.
	 *
	 * @param statisticId the statistic ID of this statistic
	 */
	@Override
	public void setStatisticId(long statisticId) {
		model.setStatisticId(statisticId);
	}

	/**
	 * Sets the user ID of this statistic.
	 *
	 * @param userId the user ID of this statistic
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this statistic.
	 *
	 * @param userName the user name of this statistic
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this statistic.
	 *
	 * @param userUuid the user uuid of this statistic
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected StatisticWrapper wrap(Statistic statistic) {
		return new StatisticWrapper(statistic);
	}

}