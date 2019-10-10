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
 * This class is a wrapper for {@link ScheduledThread}.
 * </p>
 *
 * @author Iavor Sturm
 * @see ScheduledThread
 * @generated
 */
@ProviderType
public class ScheduledThreadWrapper
	extends BaseModelWrapper<ScheduledThread>
	implements ScheduledThread, ModelWrapper<ScheduledThread> {

	public ScheduledThreadWrapper(ScheduledThread scheduledThread) {
		super(scheduledThread);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduledThreadId", getScheduledThreadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("schedulerClassName", getSchedulerClassName());
		attributes.put("cronText", getCronText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduledThreadId = (Long)attributes.get("scheduledThreadId");

		if (scheduledThreadId != null) {
			setScheduledThreadId(scheduledThreadId);
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

		String schedulerClassName = (String)attributes.get(
			"schedulerClassName");

		if (schedulerClassName != null) {
			setSchedulerClassName(schedulerClassName);
		}

		String cronText = (String)attributes.get("cronText");

		if (cronText != null) {
			setCronText(cronText);
		}
	}

	/**
	 * Returns the company ID of this scheduled thread.
	 *
	 * @return the company ID of this scheduled thread
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this scheduled thread.
	 *
	 * @return the create date of this scheduled thread
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the cron text of this scheduled thread.
	 *
	 * @return the cron text of this scheduled thread
	 */
	@Override
	public String getCronText() {
		return model.getCronText();
	}

	/**
	 * Returns the group ID of this scheduled thread.
	 *
	 * @return the group ID of this scheduled thread
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this scheduled thread.
	 *
	 * @return the modified date of this scheduled thread
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this scheduled thread.
	 *
	 * @return the primary key of this scheduled thread
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the scheduled thread ID of this scheduled thread.
	 *
	 * @return the scheduled thread ID of this scheduled thread
	 */
	@Override
	public long getScheduledThreadId() {
		return model.getScheduledThreadId();
	}

	/**
	 * Returns the scheduler class name of this scheduled thread.
	 *
	 * @return the scheduler class name of this scheduled thread
	 */
	@Override
	public String getSchedulerClassName() {
		return model.getSchedulerClassName();
	}

	/**
	 * Returns the user ID of this scheduled thread.
	 *
	 * @return the user ID of this scheduled thread
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this scheduled thread.
	 *
	 * @return the user name of this scheduled thread
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this scheduled thread.
	 *
	 * @return the user uuid of this scheduled thread
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
	 * Sets the company ID of this scheduled thread.
	 *
	 * @param companyId the company ID of this scheduled thread
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this scheduled thread.
	 *
	 * @param createDate the create date of this scheduled thread
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the cron text of this scheduled thread.
	 *
	 * @param cronText the cron text of this scheduled thread
	 */
	@Override
	public void setCronText(String cronText) {
		model.setCronText(cronText);
	}

	/**
	 * Sets the group ID of this scheduled thread.
	 *
	 * @param groupId the group ID of this scheduled thread
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this scheduled thread.
	 *
	 * @param modifiedDate the modified date of this scheduled thread
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this scheduled thread.
	 *
	 * @param primaryKey the primary key of this scheduled thread
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scheduled thread ID of this scheduled thread.
	 *
	 * @param scheduledThreadId the scheduled thread ID of this scheduled thread
	 */
	@Override
	public void setScheduledThreadId(long scheduledThreadId) {
		model.setScheduledThreadId(scheduledThreadId);
	}

	/**
	 * Sets the scheduler class name of this scheduled thread.
	 *
	 * @param schedulerClassName the scheduler class name of this scheduled thread
	 */
	@Override
	public void setSchedulerClassName(String schedulerClassName) {
		model.setSchedulerClassName(schedulerClassName);
	}

	/**
	 * Sets the user ID of this scheduled thread.
	 *
	 * @param userId the user ID of this scheduled thread
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this scheduled thread.
	 *
	 * @param userName the user name of this scheduled thread
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this scheduled thread.
	 *
	 * @param userUuid the user uuid of this scheduled thread
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ScheduledThreadWrapper wrap(ScheduledThread scheduledThread) {
		return new ScheduledThreadWrapper(scheduledThread);
	}

}