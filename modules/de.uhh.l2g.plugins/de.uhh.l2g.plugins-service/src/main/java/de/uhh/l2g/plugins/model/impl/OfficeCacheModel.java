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

import de.uhh.l2g.plugins.model.Office;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Office in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class OfficeCacheModel implements CacheModel<Office>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeCacheModel)) {
			return false;
		}

		OfficeCacheModel officeCacheModel = (OfficeCacheModel)obj;

		if (officeId == officeCacheModel.officeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, officeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{officeId=");
		sb.append(officeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", www=");
		sb.append(www);
		sb.append(", email=");
		sb.append(email);
		sb.append(", institutionId=");
		sb.append(institutionId);
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
	public Office toEntityModel() {
		OfficeImpl officeImpl = new OfficeImpl();

		officeImpl.setOfficeId(officeId);

		if (name == null) {
			officeImpl.setName("");
		}
		else {
			officeImpl.setName(name);
		}

		if (www == null) {
			officeImpl.setWww("");
		}
		else {
			officeImpl.setWww(www);
		}

		if (email == null) {
			officeImpl.setEmail("");
		}
		else {
			officeImpl.setEmail(email);
		}

		officeImpl.setInstitutionId(institutionId);
		officeImpl.setGroupId(groupId);
		officeImpl.setCompanyId(companyId);
		officeImpl.setUserId(userId);

		if (userName == null) {
			officeImpl.setUserName("");
		}
		else {
			officeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			officeImpl.setCreateDate(null);
		}
		else {
			officeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			officeImpl.setModifiedDate(null);
		}
		else {
			officeImpl.setModifiedDate(new Date(modifiedDate));
		}

		officeImpl.resetOriginalValues();

		return officeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeId = objectInput.readLong();
		name = objectInput.readUTF();
		www = objectInput.readUTF();
		email = objectInput.readUTF();

		institutionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(officeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (www == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(www);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(institutionId);

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

	public long officeId;
	public String name;
	public String www;
	public String email;
	public long institutionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}