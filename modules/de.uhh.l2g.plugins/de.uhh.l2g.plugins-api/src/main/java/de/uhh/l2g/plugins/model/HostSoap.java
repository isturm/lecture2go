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

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class HostSoap implements Serializable {

	public static HostSoap toSoapModel(Host model) {
		HostSoap soapModel = new HostSoap();

		soapModel.setHostId(model.getHostId());
		soapModel.setDirectory(model.getDirectory());
		soapModel.setName(model.getName());
		soapModel.setDefaultHost(model.getDefaultHost());
		soapModel.setPrefix(model.getPrefix());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static HostSoap[] toSoapModels(Host[] models) {
		HostSoap[] soapModels = new HostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HostSoap[][] toSoapModels(Host[][] models) {
		HostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HostSoap[] toSoapModels(List<Host> models) {
		List<HostSoap> soapModels = new ArrayList<HostSoap>(models.size());

		for (Host model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HostSoap[soapModels.size()]);
	}

	public HostSoap() {
	}

	public long getPrimaryKey() {
		return _hostId;
	}

	public void setPrimaryKey(long pk) {
		setHostId(pk);
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public String getDirectory() {
		return _directory;
	}

	public void setDirectory(String directory) {
		_directory = directory;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getDefaultHost() {
		return _defaultHost;
	}

	public void setDefaultHost(int defaultHost) {
		_defaultHost = defaultHost;
	}

	public String getPrefix() {
		return _prefix;
	}

	public void setPrefix(String prefix) {
		_prefix = prefix;
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

	private long _hostId;
	private String _directory;
	private String _name;
	private int _defaultHost;
	private String _prefix;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}