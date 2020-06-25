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
 * This class is a wrapper for {@link MediaType}.
 * </p>
 *
 * @author Iavor Sturm
 * @see MediaType
 * @generated
 */
@ProviderType
public class MediaTypeWrapper
	extends BaseModelWrapper<MediaType>
	implements MediaType, ModelWrapper<MediaType> {

	public MediaTypeWrapper(MediaType mediaType) {
		super(mediaType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mediaTypeId", getMediaTypeId());
		attributes.put("mediaTypeName", getMediaTypeName());
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
		Long mediaTypeId = (Long)attributes.get("mediaTypeId");

		if (mediaTypeId != null) {
			setMediaTypeId(mediaTypeId);
		}

		String mediaTypeName = (String)attributes.get("mediaTypeName");

		if (mediaTypeName != null) {
			setMediaTypeName(mediaTypeName);
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
	 * Returns the company ID of this media type.
	 *
	 * @return the company ID of this media type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this media type.
	 *
	 * @return the create date of this media type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this media type.
	 *
	 * @return the group ID of this media type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the media type ID of this media type.
	 *
	 * @return the media type ID of this media type
	 */
	@Override
	public long getMediaTypeId() {
		return model.getMediaTypeId();
	}

	/**
	 * Returns the media type name of this media type.
	 *
	 * @return the media type name of this media type
	 */
	@Override
	public String getMediaTypeName() {
		return model.getMediaTypeName();
	}

	/**
	 * Returns the modified date of this media type.
	 *
	 * @return the modified date of this media type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this media type.
	 *
	 * @return the primary key of this media type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this media type.
	 *
	 * @return the user ID of this media type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this media type.
	 *
	 * @return the user name of this media type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this media type.
	 *
	 * @return the user uuid of this media type
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
	 * Sets the company ID of this media type.
	 *
	 * @param companyId the company ID of this media type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this media type.
	 *
	 * @param createDate the create date of this media type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this media type.
	 *
	 * @param groupId the group ID of this media type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the media type ID of this media type.
	 *
	 * @param mediaTypeId the media type ID of this media type
	 */
	@Override
	public void setMediaTypeId(long mediaTypeId) {
		model.setMediaTypeId(mediaTypeId);
	}

	/**
	 * Sets the media type name of this media type.
	 *
	 * @param mediaTypeName the media type name of this media type
	 */
	@Override
	public void setMediaTypeName(String mediaTypeName) {
		model.setMediaTypeName(mediaTypeName);
	}

	/**
	 * Sets the modified date of this media type.
	 *
	 * @param modifiedDate the modified date of this media type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this media type.
	 *
	 * @param primaryKey the primary key of this media type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this media type.
	 *
	 * @param userId the user ID of this media type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this media type.
	 *
	 * @param userName the user name of this media type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this media type.
	 *
	 * @param userUuid the user uuid of this media type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MediaTypeWrapper wrap(MediaType mediaType) {
		return new MediaTypeWrapper(mediaType);
	}

}