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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import de.uhh.l2g.plugins.model.Host;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Host in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class HostCacheModel implements CacheModel<Host>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HostCacheModel)) {
			return false;
		}

		HostCacheModel hostCacheModel = (HostCacheModel)obj;

		if (hostId == hostCacheModel.hostId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, hostId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{hostId=");
		sb.append(hostId);
		sb.append(", protocol=");
		sb.append(protocol);
		sb.append(", streamer=");
		sb.append(streamer);
		sb.append(", port=");
		sb.append(port);
		sb.append(", serverRoot=");
		sb.append(serverRoot);
		sb.append(", name=");
		sb.append(name);
		sb.append(", defaultHost=");
		sb.append(defaultHost);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Host toEntityModel() {
		HostImpl hostImpl = new HostImpl();

		hostImpl.setHostId(hostId);

		if (protocol == null) {
			hostImpl.setProtocol("");
		}
		else {
			hostImpl.setProtocol(protocol);
		}

		if (streamer == null) {
			hostImpl.setStreamer("");
		}
		else {
			hostImpl.setStreamer(streamer);
		}

		hostImpl.setPort(port);

		if (serverRoot == null) {
			hostImpl.setServerRoot("");
		}
		else {
			hostImpl.setServerRoot(serverRoot);
		}

		if (name == null) {
			hostImpl.setName("");
		}
		else {
			hostImpl.setName(name);
		}

		hostImpl.setDefaultHost(defaultHost);
		hostImpl.setGroupId(groupId);
		hostImpl.setCompanyId(companyId);
		hostImpl.setUserId(userId);

		if (userName == null) {
			hostImpl.setUserName("");
		}
		else {
			hostImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hostImpl.setCreateDate(null);
		}
		else {
			hostImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hostImpl.setModifiedDate(null);
		}
		else {
			hostImpl.setModifiedDate(new Date(modifiedDate));
		}

		hostImpl.resetOriginalValues();

		return hostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		hostId = objectInput.readLong();
		protocol = objectInput.readUTF();
		streamer = objectInput.readUTF();

		port = objectInput.readInt();
		serverRoot = objectInput.readUTF();
		name = objectInput.readUTF();

		defaultHost = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(hostId);

		if (protocol == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(protocol);
		}

		if (streamer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(streamer);
		}

		objectOutput.writeInt(port);

		if (serverRoot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serverRoot);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(defaultHost);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long hostId;
	public String protocol;
	public String streamer;
	public int port;
	public String serverRoot;
	public String name;
	public int defaultHost;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}