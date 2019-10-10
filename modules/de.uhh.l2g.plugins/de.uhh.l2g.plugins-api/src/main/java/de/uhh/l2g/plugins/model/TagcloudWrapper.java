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
 * This class is a wrapper for {@link Tagcloud}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Tagcloud
 * @generated
 */
@ProviderType
public class TagcloudWrapper
	extends BaseModelWrapper<Tagcloud>
	implements Tagcloud, ModelWrapper<Tagcloud> {

	public TagcloudWrapper(Tagcloud tagcloud) {
		super(tagcloud);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagcloudId", getTagcloudId());
		attributes.put("objectClassType", getObjectClassType());
		attributes.put("objectId", getObjectId());
		attributes.put("tags", getTags());
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
		Long tagcloudId = (Long)attributes.get("tagcloudId");

		if (tagcloudId != null) {
			setTagcloudId(tagcloudId);
		}

		String objectClassType = (String)attributes.get("objectClassType");

		if (objectClassType != null) {
			setObjectClassType(objectClassType);
		}

		Long objectId = (Long)attributes.get("objectId");

		if (objectId != null) {
			setObjectId(objectId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
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
	 * Returns the company ID of this tagcloud.
	 *
	 * @return the company ID of this tagcloud
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this tagcloud.
	 *
	 * @return the create date of this tagcloud
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this tagcloud.
	 *
	 * @return the group ID of this tagcloud
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this tagcloud.
	 *
	 * @return the modified date of this tagcloud
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the object class type of this tagcloud.
	 *
	 * @return the object class type of this tagcloud
	 */
	@Override
	public String getObjectClassType() {
		return model.getObjectClassType();
	}

	/**
	 * Returns the object ID of this tagcloud.
	 *
	 * @return the object ID of this tagcloud
	 */
	@Override
	public long getObjectId() {
		return model.getObjectId();
	}

	/**
	 * Returns the primary key of this tagcloud.
	 *
	 * @return the primary key of this tagcloud
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tagcloud ID of this tagcloud.
	 *
	 * @return the tagcloud ID of this tagcloud
	 */
	@Override
	public long getTagcloudId() {
		return model.getTagcloudId();
	}

	/**
	 * Returns the tags of this tagcloud.
	 *
	 * @return the tags of this tagcloud
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the user ID of this tagcloud.
	 *
	 * @return the user ID of this tagcloud
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this tagcloud.
	 *
	 * @return the user name of this tagcloud
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this tagcloud.
	 *
	 * @return the user uuid of this tagcloud
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
	 * Sets the company ID of this tagcloud.
	 *
	 * @param companyId the company ID of this tagcloud
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tagcloud.
	 *
	 * @param createDate the create date of this tagcloud
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this tagcloud.
	 *
	 * @param groupId the group ID of this tagcloud
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this tagcloud.
	 *
	 * @param modifiedDate the modified date of this tagcloud
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the object class type of this tagcloud.
	 *
	 * @param objectClassType the object class type of this tagcloud
	 */
	@Override
	public void setObjectClassType(String objectClassType) {
		model.setObjectClassType(objectClassType);
	}

	/**
	 * Sets the object ID of this tagcloud.
	 *
	 * @param objectId the object ID of this tagcloud
	 */
	@Override
	public void setObjectId(long objectId) {
		model.setObjectId(objectId);
	}

	/**
	 * Sets the primary key of this tagcloud.
	 *
	 * @param primaryKey the primary key of this tagcloud
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tagcloud ID of this tagcloud.
	 *
	 * @param tagcloudId the tagcloud ID of this tagcloud
	 */
	@Override
	public void setTagcloudId(long tagcloudId) {
		model.setTagcloudId(tagcloudId);
	}

	/**
	 * Sets the tags of this tagcloud.
	 *
	 * @param tags the tags of this tagcloud
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the user ID of this tagcloud.
	 *
	 * @param userId the user ID of this tagcloud
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this tagcloud.
	 *
	 * @param userName the user name of this tagcloud
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tagcloud.
	 *
	 * @param userUuid the user uuid of this tagcloud
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TagcloudWrapper wrap(Tagcloud tagcloud) {
		return new TagcloudWrapper(tagcloud);
	}

}