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

import de.uhh.l2g.plugins.model.Creator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Creator in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class CreatorCacheModel implements CacheModel<Creator>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreatorCacheModel)) {
			return false;
		}

		CreatorCacheModel creatorCacheModel = (CreatorCacheModel)obj;

		if (creatorId == creatorCacheModel.creatorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, creatorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{creatorId=");
		sb.append(creatorId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", fullName=");
		sb.append(fullName);
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
	public Creator toEntityModel() {
		CreatorImpl creatorImpl = new CreatorImpl();

		creatorImpl.setCreatorId(creatorId);

		if (firstName == null) {
			creatorImpl.setFirstName("");
		}
		else {
			creatorImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			creatorImpl.setLastName("");
		}
		else {
			creatorImpl.setLastName(lastName);
		}

		if (middleName == null) {
			creatorImpl.setMiddleName("");
		}
		else {
			creatorImpl.setMiddleName(middleName);
		}

		if (jobTitle == null) {
			creatorImpl.setJobTitle("");
		}
		else {
			creatorImpl.setJobTitle(jobTitle);
		}

		if (gender == null) {
			creatorImpl.setGender("");
		}
		else {
			creatorImpl.setGender(gender);
		}

		if (fullName == null) {
			creatorImpl.setFullName("");
		}
		else {
			creatorImpl.setFullName(fullName);
		}

		creatorImpl.setGroupId(groupId);
		creatorImpl.setCompanyId(companyId);
		creatorImpl.setUserId(userId);

		if (userName == null) {
			creatorImpl.setUserName("");
		}
		else {
			creatorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			creatorImpl.setCreateDate(null);
		}
		else {
			creatorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			creatorImpl.setModifiedDate(null);
		}
		else {
			creatorImpl.setModifiedDate(new Date(modifiedDate));
		}

		creatorImpl.resetOriginalValues();

		return creatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creatorId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		gender = objectInput.readUTF();
		fullName = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(creatorId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (middleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
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

	public long creatorId;
	public String firstName;
	public String lastName;
	public String middleName;
	public String jobTitle;
	public String gender;
	public String fullName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}