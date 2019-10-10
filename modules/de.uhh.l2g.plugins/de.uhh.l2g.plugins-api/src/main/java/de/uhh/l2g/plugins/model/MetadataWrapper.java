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
 * This class is a wrapper for {@link Metadata}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Metadata
 * @generated
 */
@ProviderType
public class MetadataWrapper
	extends BaseModelWrapper<Metadata>
	implements Metadata, ModelWrapper<Metadata> {

	public MetadataWrapper(Metadata metadata) {
		super(metadata);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataId", getMetadataId());
		attributes.put("type", getType());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("publisher", getPublisher());
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
		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
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
	 * Returns the company ID of this metadata.
	 *
	 * @return the company ID of this metadata
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this metadata.
	 *
	 * @return the create date of this metadata
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this metadata.
	 *
	 * @return the description of this metadata
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this metadata.
	 *
	 * @return the group ID of this metadata
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this metadata.
	 *
	 * @return the language of this metadata
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the metadata ID of this metadata.
	 *
	 * @return the metadata ID of this metadata
	 */
	@Override
	public long getMetadataId() {
		return model.getMetadataId();
	}

	/**
	 * Returns the modified date of this metadata.
	 *
	 * @return the modified date of this metadata
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this metadata.
	 *
	 * @return the primary key of this metadata
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publisher of this metadata.
	 *
	 * @return the publisher of this metadata
	 */
	@Override
	public String getPublisher() {
		return model.getPublisher();
	}

	/**
	 * Returns the subject of this metadata.
	 *
	 * @return the subject of this metadata
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the title of this metadata.
	 *
	 * @return the title of this metadata
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this metadata.
	 *
	 * @return the type of this metadata
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this metadata.
	 *
	 * @return the user ID of this metadata
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this metadata.
	 *
	 * @return the user name of this metadata
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this metadata.
	 *
	 * @return the user uuid of this metadata
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
	 * Sets the company ID of this metadata.
	 *
	 * @param companyId the company ID of this metadata
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this metadata.
	 *
	 * @param createDate the create date of this metadata
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this metadata.
	 *
	 * @param description the description of this metadata
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this metadata.
	 *
	 * @param groupId the group ID of this metadata
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this metadata.
	 *
	 * @param language the language of this metadata
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the metadata ID of this metadata.
	 *
	 * @param metadataId the metadata ID of this metadata
	 */
	@Override
	public void setMetadataId(long metadataId) {
		model.setMetadataId(metadataId);
	}

	/**
	 * Sets the modified date of this metadata.
	 *
	 * @param modifiedDate the modified date of this metadata
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this metadata.
	 *
	 * @param primaryKey the primary key of this metadata
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publisher of this metadata.
	 *
	 * @param publisher the publisher of this metadata
	 */
	@Override
	public void setPublisher(String publisher) {
		model.setPublisher(publisher);
	}

	/**
	 * Sets the subject of this metadata.
	 *
	 * @param subject the subject of this metadata
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the title of this metadata.
	 *
	 * @param title the title of this metadata
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this metadata.
	 *
	 * @param type the type of this metadata
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this metadata.
	 *
	 * @param userId the user ID of this metadata
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this metadata.
	 *
	 * @param userName the user name of this metadata
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this metadata.
	 *
	 * @param userUuid the user uuid of this metadata
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MetadataWrapper wrap(Metadata metadata) {
		return new MetadataWrapper(metadata);
	}

}