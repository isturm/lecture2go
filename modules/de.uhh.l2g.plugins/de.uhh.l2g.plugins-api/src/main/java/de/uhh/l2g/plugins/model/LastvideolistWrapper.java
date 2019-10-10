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
 * This class is a wrapper for {@link Lastvideolist}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lastvideolist
 * @generated
 */
@ProviderType
public class LastvideolistWrapper
	extends BaseModelWrapper<Lastvideolist>
	implements Lastvideolist, ModelWrapper<Lastvideolist> {

	public LastvideolistWrapper(Lastvideolist lastvideolist) {
		super(lastvideolist);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lastvideolistId", getLastvideolistId());
		attributes.put("videoId", getVideoId());
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
		Integer lastvideolistId = (Integer)attributes.get("lastvideolistId");

		if (lastvideolistId != null) {
			setLastvideolistId(lastvideolistId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
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
	 * Returns the company ID of this lastvideolist.
	 *
	 * @return the company ID of this lastvideolist
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this lastvideolist.
	 *
	 * @return the create date of this lastvideolist
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this lastvideolist.
	 *
	 * @return the group ID of this lastvideolist
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lastvideolist ID of this lastvideolist.
	 *
	 * @return the lastvideolist ID of this lastvideolist
	 */
	@Override
	public int getLastvideolistId() {
		return model.getLastvideolistId();
	}

	/**
	 * Returns the modified date of this lastvideolist.
	 *
	 * @return the modified date of this lastvideolist
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this lastvideolist.
	 *
	 * @return the primary key of this lastvideolist
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this lastvideolist.
	 *
	 * @return the user ID of this lastvideolist
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lastvideolist.
	 *
	 * @return the user name of this lastvideolist
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lastvideolist.
	 *
	 * @return the user uuid of this lastvideolist
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the video ID of this lastvideolist.
	 *
	 * @return the video ID of this lastvideolist
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this lastvideolist.
	 *
	 * @param companyId the company ID of this lastvideolist
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lastvideolist.
	 *
	 * @param createDate the create date of this lastvideolist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this lastvideolist.
	 *
	 * @param groupId the group ID of this lastvideolist
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lastvideolist ID of this lastvideolist.
	 *
	 * @param lastvideolistId the lastvideolist ID of this lastvideolist
	 */
	@Override
	public void setLastvideolistId(int lastvideolistId) {
		model.setLastvideolistId(lastvideolistId);
	}

	/**
	 * Sets the modified date of this lastvideolist.
	 *
	 * @param modifiedDate the modified date of this lastvideolist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this lastvideolist.
	 *
	 * @param primaryKey the primary key of this lastvideolist
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this lastvideolist.
	 *
	 * @param userId the user ID of this lastvideolist
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lastvideolist.
	 *
	 * @param userName the user name of this lastvideolist
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lastvideolist.
	 *
	 * @param userUuid the user uuid of this lastvideolist
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the video ID of this lastvideolist.
	 *
	 * @param videoId the video ID of this lastvideolist
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected LastvideolistWrapper wrap(Lastvideolist lastvideolist) {
		return new LastvideolistWrapper(lastvideolist);
	}

}