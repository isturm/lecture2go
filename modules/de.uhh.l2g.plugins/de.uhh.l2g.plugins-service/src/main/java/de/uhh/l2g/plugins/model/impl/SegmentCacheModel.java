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

import de.uhh.l2g.plugins.model.Segment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Segment in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class SegmentCacheModel implements CacheModel<Segment>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegmentCacheModel)) {
			return false;
		}

		SegmentCacheModel segmentCacheModel = (SegmentCacheModel)obj;

		if (segmentId == segmentCacheModel.segmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, segmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{segmentId=");
		sb.append(segmentId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", start=");
		sb.append(start);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", end=");
		sb.append(end);
		sb.append(", chapter=");
		sb.append(chapter);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
	public Segment toEntityModel() {
		SegmentImpl segmentImpl = new SegmentImpl();

		segmentImpl.setSegmentId(segmentId);
		segmentImpl.setVideoId(videoId);

		if (start == null) {
			segmentImpl.setStart("");
		}
		else {
			segmentImpl.setStart(start);
		}

		if (title == null) {
			segmentImpl.setTitle("");
		}
		else {
			segmentImpl.setTitle(title);
		}

		if (description == null) {
			segmentImpl.setDescription("");
		}
		else {
			segmentImpl.setDescription(description);
		}

		if (end == null) {
			segmentImpl.setEnd("");
		}
		else {
			segmentImpl.setEnd(end);
		}

		segmentImpl.setChapter(chapter);
		segmentImpl.setUserId(userId);
		segmentImpl.setGroupId(groupId);
		segmentImpl.setCompanyId(companyId);

		if (userName == null) {
			segmentImpl.setUserName("");
		}
		else {
			segmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			segmentImpl.setCreateDate(null);
		}
		else {
			segmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			segmentImpl.setModifiedDate(null);
		}
		else {
			segmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		segmentImpl.resetOriginalValues();

		return segmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		segmentId = objectInput.readLong();

		videoId = objectInput.readLong();
		start = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		end = objectInput.readUTF();

		chapter = objectInput.readInt();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(segmentId);

		objectOutput.writeLong(videoId);

		if (start == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(start);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (end == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(end);
		}

		objectOutput.writeInt(chapter);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long segmentId;
	public long videoId;
	public String start;
	public String title;
	public String description;
	public String end;
	public int chapter;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}