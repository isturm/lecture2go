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

import de.uhh.l2g.plugins.model.Producer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Producer in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class ProducerCacheModel
	implements CacheModel<Producer>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProducerCacheModel)) {
			return false;
		}

		ProducerCacheModel producerCacheModel = (ProducerCacheModel)obj;

		if (producerId == producerCacheModel.producerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, producerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{producerId=");
		sb.append(producerId);
		sb.append(", idNum=");
		sb.append(idNum);
		sb.append(", homeDir=");
		sb.append(homeDir);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", numberOfProductions=");
		sb.append(numberOfProductions);
		sb.append(", approved=");
		sb.append(approved);
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
	public Producer toEntityModel() {
		ProducerImpl producerImpl = new ProducerImpl();

		producerImpl.setProducerId(producerId);

		if (idNum == null) {
			producerImpl.setIdNum("");
		}
		else {
			producerImpl.setIdNum(idNum);
		}

		if (homeDir == null) {
			producerImpl.setHomeDir("");
		}
		else {
			producerImpl.setHomeDir(homeDir);
		}

		producerImpl.setHostId(hostId);
		producerImpl.setInstitutionId(institutionId);
		producerImpl.setNumberOfProductions(numberOfProductions);
		producerImpl.setApproved(approved);
		producerImpl.setGroupId(groupId);
		producerImpl.setCompanyId(companyId);
		producerImpl.setUserId(userId);

		if (userName == null) {
			producerImpl.setUserName("");
		}
		else {
			producerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			producerImpl.setCreateDate(null);
		}
		else {
			producerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			producerImpl.setModifiedDate(null);
		}
		else {
			producerImpl.setModifiedDate(new Date(modifiedDate));
		}

		producerImpl.resetOriginalValues();

		return producerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		producerId = objectInput.readLong();
		idNum = objectInput.readUTF();
		homeDir = objectInput.readUTF();

		hostId = objectInput.readLong();

		institutionId = objectInput.readLong();

		numberOfProductions = objectInput.readLong();

		approved = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(producerId);

		if (idNum == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idNum);
		}

		if (homeDir == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homeDir);
		}

		objectOutput.writeLong(hostId);

		objectOutput.writeLong(institutionId);

		objectOutput.writeLong(numberOfProductions);

		objectOutput.writeInt(approved);

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

	public long producerId;
	public String idNum;
	public String homeDir;
	public long hostId;
	public long institutionId;
	public long numberOfProductions;
	public int approved;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}