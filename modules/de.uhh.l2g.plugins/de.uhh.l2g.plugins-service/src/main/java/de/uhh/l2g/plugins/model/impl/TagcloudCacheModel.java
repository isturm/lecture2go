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

import de.uhh.l2g.plugins.model.Tagcloud;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Tagcloud in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class TagcloudCacheModel
	implements CacheModel<Tagcloud>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TagcloudCacheModel)) {
			return false;
		}

		TagcloudCacheModel tagcloudCacheModel = (TagcloudCacheModel)obj;

		if (tagcloudId == tagcloudCacheModel.tagcloudId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tagcloudId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{tagcloudId=");
		sb.append(tagcloudId);
		sb.append(", objectClassType=");
		sb.append(objectClassType);
		sb.append(", objectId=");
		sb.append(objectId);
		sb.append(", tags=");
		sb.append(tags);
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
	public Tagcloud toEntityModel() {
		TagcloudImpl tagcloudImpl = new TagcloudImpl();

		tagcloudImpl.setTagcloudId(tagcloudId);

		if (objectClassType == null) {
			tagcloudImpl.setObjectClassType("");
		}
		else {
			tagcloudImpl.setObjectClassType(objectClassType);
		}

		tagcloudImpl.setObjectId(objectId);

		if (tags == null) {
			tagcloudImpl.setTags("");
		}
		else {
			tagcloudImpl.setTags(tags);
		}

		tagcloudImpl.setGroupId(groupId);
		tagcloudImpl.setCompanyId(companyId);
		tagcloudImpl.setUserId(userId);

		if (userName == null) {
			tagcloudImpl.setUserName("");
		}
		else {
			tagcloudImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tagcloudImpl.setCreateDate(null);
		}
		else {
			tagcloudImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tagcloudImpl.setModifiedDate(null);
		}
		else {
			tagcloudImpl.setModifiedDate(new Date(modifiedDate));
		}

		tagcloudImpl.resetOriginalValues();

		return tagcloudImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagcloudId = objectInput.readLong();
		objectClassType = objectInput.readUTF();

		objectId = objectInput.readLong();
		tags = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tagcloudId);

		if (objectClassType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(objectClassType);
		}

		objectOutput.writeLong(objectId);

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
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

	public long tagcloudId;
	public String objectClassType;
	public long objectId;
	public String tags;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}