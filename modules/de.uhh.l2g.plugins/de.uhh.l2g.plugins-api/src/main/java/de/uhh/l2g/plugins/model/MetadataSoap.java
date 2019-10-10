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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class MetadataSoap implements Serializable {

	public static MetadataSoap toSoapModel(Metadata model) {
		MetadataSoap soapModel = new MetadataSoap();

		soapModel.setMetadataId(model.getMetadataId());
		soapModel.setType(model.getType());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTitle(model.getTitle());
		soapModel.setSubject(model.getSubject());
		soapModel.setDescription(model.getDescription());
		soapModel.setPublisher(model.getPublisher());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MetadataSoap[] toSoapModels(Metadata[] models) {
		MetadataSoap[] soapModels = new MetadataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MetadataSoap[][] toSoapModels(Metadata[][] models) {
		MetadataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MetadataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MetadataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MetadataSoap[] toSoapModels(List<Metadata> models) {
		List<MetadataSoap> soapModels = new ArrayList<MetadataSoap>(
			models.size());

		for (Metadata model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MetadataSoap[soapModels.size()]);
	}

	public MetadataSoap() {
	}

	public long getPrimaryKey() {
		return _metadataId;
	}

	public void setPrimaryKey(long pk) {
		setMetadataId(pk);
	}

	public long getMetadataId() {
		return _metadataId;
	}

	public void setMetadataId(long metadataId) {
		_metadataId = metadataId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _metadataId;
	private String _type;
	private String _language;
	private String _title;
	private String _subject;
	private String _description;
	private String _publisher;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}