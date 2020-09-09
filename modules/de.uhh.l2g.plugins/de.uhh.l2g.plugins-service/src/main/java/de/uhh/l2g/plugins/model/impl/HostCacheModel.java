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

/**
 * The cache model class for representing Host in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
public class HostCacheModel implements CacheModel<Host>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HostCacheModel)) {
			return false;
		}

		HostCacheModel hostCacheModel = (HostCacheModel)object;

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
		StringBundler sb = new StringBundler(23);

		sb.append("{hostId=");
		sb.append(hostId);
		sb.append(", directory=");
		sb.append(directory);
		sb.append(", name=");
		sb.append(name);
		sb.append(", defaultHost=");
		sb.append(defaultHost);
		sb.append(", prefix=");
		sb.append(prefix);
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

		if (directory == null) {
			hostImpl.setDirectory("");
		}
		else {
			hostImpl.setDirectory(directory);
		}

		if (name == null) {
			hostImpl.setName("");
		}
		else {
			hostImpl.setName(name);
		}

		hostImpl.setDefaultHost(defaultHost);

		if (prefix == null) {
			hostImpl.setPrefix("");
		}
		else {
			hostImpl.setPrefix(prefix);
		}

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
		directory = objectInput.readUTF();
		name = objectInput.readUTF();

		defaultHost = objectInput.readInt();
		prefix = objectInput.readUTF();

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

		if (directory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(directory);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(defaultHost);

		if (prefix == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prefix);
		}

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
	public String directory;
	public String name;
	public int defaultHost;
	public String prefix;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}