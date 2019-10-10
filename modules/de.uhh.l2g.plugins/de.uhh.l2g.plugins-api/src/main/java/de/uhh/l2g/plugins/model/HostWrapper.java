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
 * This class is a wrapper for {@link Host}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Host
 * @generated
 */
@ProviderType
public class HostWrapper
	extends BaseModelWrapper<Host> implements Host, ModelWrapper<Host> {

	public HostWrapper(Host host) {
		super(host);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());
		attributes.put("defaultHost", getDefaultHost());
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
		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String streamer = (String)attributes.get("streamer");

		if (streamer != null) {
			setStreamer(streamer);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String serverRoot = (String)attributes.get("serverRoot");

		if (serverRoot != null) {
			setServerRoot(serverRoot);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer defaultHost = (Integer)attributes.get("defaultHost");

		if (defaultHost != null) {
			setDefaultHost(defaultHost);
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
	 * Returns the company ID of this host.
	 *
	 * @return the company ID of this host
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this host.
	 *
	 * @return the create date of this host
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the default host of this host.
	 *
	 * @return the default host of this host
	 */
	@Override
	public int getDefaultHost() {
		return model.getDefaultHost();
	}

	/**
	 * Returns the group ID of this host.
	 *
	 * @return the group ID of this host
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the host ID of this host.
	 *
	 * @return the host ID of this host
	 */
	@Override
	public long getHostId() {
		return model.getHostId();
	}

	/**
	 * Returns the modified date of this host.
	 *
	 * @return the modified date of this host
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this host.
	 *
	 * @return the name of this host
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the port of this host.
	 *
	 * @return the port of this host
	 */
	@Override
	public int getPort() {
		return model.getPort();
	}

	/**
	 * Returns the primary key of this host.
	 *
	 * @return the primary key of this host
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the protocol of this host.
	 *
	 * @return the protocol of this host
	 */
	@Override
	public String getProtocol() {
		return model.getProtocol();
	}

	/**
	 * Returns the server root of this host.
	 *
	 * @return the server root of this host
	 */
	@Override
	public String getServerRoot() {
		return model.getServerRoot();
	}

	/**
	 * Returns the streamer of this host.
	 *
	 * @return the streamer of this host
	 */
	@Override
	public String getStreamer() {
		return model.getStreamer();
	}

	/**
	 * Returns the user ID of this host.
	 *
	 * @return the user ID of this host
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this host.
	 *
	 * @return the user name of this host
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this host.
	 *
	 * @return the user uuid of this host
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
	 * Sets the company ID of this host.
	 *
	 * @param companyId the company ID of this host
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this host.
	 *
	 * @param createDate the create date of this host
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default host of this host.
	 *
	 * @param defaultHost the default host of this host
	 */
	@Override
	public void setDefaultHost(int defaultHost) {
		model.setDefaultHost(defaultHost);
	}

	/**
	 * Sets the group ID of this host.
	 *
	 * @param groupId the group ID of this host
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the host ID of this host.
	 *
	 * @param hostId the host ID of this host
	 */
	@Override
	public void setHostId(long hostId) {
		model.setHostId(hostId);
	}

	/**
	 * Sets the modified date of this host.
	 *
	 * @param modifiedDate the modified date of this host
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this host.
	 *
	 * @param name the name of this host
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the port of this host.
	 *
	 * @param port the port of this host
	 */
	@Override
	public void setPort(int port) {
		model.setPort(port);
	}

	/**
	 * Sets the primary key of this host.
	 *
	 * @param primaryKey the primary key of this host
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the protocol of this host.
	 *
	 * @param protocol the protocol of this host
	 */
	@Override
	public void setProtocol(String protocol) {
		model.setProtocol(protocol);
	}

	/**
	 * Sets the server root of this host.
	 *
	 * @param serverRoot the server root of this host
	 */
	@Override
	public void setServerRoot(String serverRoot) {
		model.setServerRoot(serverRoot);
	}

	/**
	 * Sets the streamer of this host.
	 *
	 * @param streamer the streamer of this host
	 */
	@Override
	public void setStreamer(String streamer) {
		model.setStreamer(streamer);
	}

	/**
	 * Sets the user ID of this host.
	 *
	 * @param userId the user ID of this host
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this host.
	 *
	 * @param userName the user name of this host
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this host.
	 *
	 * @param userUuid the user uuid of this host
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected HostWrapper wrap(Host host) {
		return new HostWrapper(host);
	}

}