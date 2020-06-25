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

import de.uhh.l2g.plugins.model.MediaType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing MediaType in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class MediaTypeCacheModel
	implements CacheModel<MediaType>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MediaTypeCacheModel)) {
			return false;
		}

		MediaTypeCacheModel mediaTypeCacheModel = (MediaTypeCacheModel)obj;

		if (mediaTypeId == mediaTypeCacheModel.mediaTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mediaTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{mediaTypeId=");
		sb.append(mediaTypeId);
		sb.append(", mediaTypeName=");
		sb.append(mediaTypeName);
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
	public MediaType toEntityModel() {
		MediaTypeImpl mediaTypeImpl = new MediaTypeImpl();

		mediaTypeImpl.setMediaTypeId(mediaTypeId);

		if (mediaTypeName == null) {
			mediaTypeImpl.setMediaTypeName("");
		}
		else {
			mediaTypeImpl.setMediaTypeName(mediaTypeName);
		}

		mediaTypeImpl.setGroupId(groupId);
		mediaTypeImpl.setCompanyId(companyId);
		mediaTypeImpl.setUserId(userId);

		if (userName == null) {
			mediaTypeImpl.setUserName("");
		}
		else {
			mediaTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mediaTypeImpl.setCreateDate(null);
		}
		else {
			mediaTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mediaTypeImpl.setModifiedDate(null);
		}
		else {
			mediaTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		mediaTypeImpl.resetOriginalValues();

		return mediaTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mediaTypeId = objectInput.readLong();
		mediaTypeName = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mediaTypeId);

		if (mediaTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mediaTypeName);
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

	public long mediaTypeId;
	public String mediaTypeName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}