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

import de.uhh.l2g.plugins.model.Lastvideolist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Lastvideolist in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class LastvideolistCacheModel
	implements CacheModel<Lastvideolist>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LastvideolistCacheModel)) {
			return false;
		}

		LastvideolistCacheModel lastvideolistCacheModel =
			(LastvideolistCacheModel)obj;

		if (lastvideolistId == lastvideolistCacheModel.lastvideolistId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lastvideolistId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{lastvideolistId=");
		sb.append(lastvideolistId);
		sb.append(", videoId=");
		sb.append(videoId);
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
	public Lastvideolist toEntityModel() {
		LastvideolistImpl lastvideolistImpl = new LastvideolistImpl();

		lastvideolistImpl.setLastvideolistId(lastvideolistId);
		lastvideolistImpl.setVideoId(videoId);
		lastvideolistImpl.setGroupId(groupId);
		lastvideolistImpl.setCompanyId(companyId);
		lastvideolistImpl.setUserId(userId);

		if (userName == null) {
			lastvideolistImpl.setUserName("");
		}
		else {
			lastvideolistImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lastvideolistImpl.setCreateDate(null);
		}
		else {
			lastvideolistImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lastvideolistImpl.setModifiedDate(null);
		}
		else {
			lastvideolistImpl.setModifiedDate(new Date(modifiedDate));
		}

		lastvideolistImpl.resetOriginalValues();

		return lastvideolistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lastvideolistId = objectInput.readInt();

		videoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(lastvideolistId);

		objectOutput.writeLong(videoId);

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

	public int lastvideolistId;
	public long videoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}