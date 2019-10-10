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

import de.uhh.l2g.plugins.model.Lectureseries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Lectureseries in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class LectureseriesCacheModel
	implements CacheModel<Lectureseries>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LectureseriesCacheModel)) {
			return false;
		}

		LectureseriesCacheModel lectureseriesCacheModel =
			(LectureseriesCacheModel)obj;

		if (lectureseriesId == lectureseriesCacheModel.lectureseriesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lectureseriesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{number=");
		sb.append(number);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", shortDesc=");
		sb.append(shortDesc);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", facultyName=");
		sb.append(facultyName);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", longDesc=");
		sb.append(longDesc);
		sb.append(", latestOpenAccessVideoId=");
		sb.append(latestOpenAccessVideoId);
		sb.append(", latestVideoUploadDate=");
		sb.append(latestVideoUploadDate);
		sb.append(", latestVideoGenerationDate=");
		sb.append(latestVideoGenerationDate);
		sb.append(", videoSort=");
		sb.append(videoSort);
		sb.append(", USID=");
		sb.append(USID);
		sb.append(", previewVideoId=");
		sb.append(previewVideoId);
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
	public Lectureseries toEntityModel() {
		LectureseriesImpl lectureseriesImpl = new LectureseriesImpl();

		if (number == null) {
			lectureseriesImpl.setNumber("");
		}
		else {
			lectureseriesImpl.setNumber(number);
		}

		if (eventType == null) {
			lectureseriesImpl.setEventType("");
		}
		else {
			lectureseriesImpl.setEventType(eventType);
		}

		lectureseriesImpl.setCategoryId(categoryId);

		if (name == null) {
			lectureseriesImpl.setName("");
		}
		else {
			lectureseriesImpl.setName(name);
		}

		if (shortDesc == null) {
			lectureseriesImpl.setShortDesc("");
		}
		else {
			lectureseriesImpl.setShortDesc(shortDesc);
		}

		lectureseriesImpl.setTermId(termId);

		if (language == null) {
			lectureseriesImpl.setLanguage("");
		}
		else {
			lectureseriesImpl.setLanguage(language);
		}

		if (facultyName == null) {
			lectureseriesImpl.setFacultyName("");
		}
		else {
			lectureseriesImpl.setFacultyName(facultyName);
		}

		lectureseriesImpl.setLectureseriesId(lectureseriesId);

		if (password == null) {
			lectureseriesImpl.setPassword("");
		}
		else {
			lectureseriesImpl.setPassword(password);
		}

		lectureseriesImpl.setApproved(approved);

		if (longDesc == null) {
			lectureseriesImpl.setLongDesc("");
		}
		else {
			lectureseriesImpl.setLongDesc(longDesc);
		}

		lectureseriesImpl.setLatestOpenAccessVideoId(latestOpenAccessVideoId);

		if (latestVideoUploadDate == Long.MIN_VALUE) {
			lectureseriesImpl.setLatestVideoUploadDate(null);
		}
		else {
			lectureseriesImpl.setLatestVideoUploadDate(
				new Date(latestVideoUploadDate));
		}

		if (latestVideoGenerationDate == null) {
			lectureseriesImpl.setLatestVideoGenerationDate("");
		}
		else {
			lectureseriesImpl.setLatestVideoGenerationDate(
				latestVideoGenerationDate);
		}

		lectureseriesImpl.setVideoSort(videoSort);

		if (USID == null) {
			lectureseriesImpl.setUSID("");
		}
		else {
			lectureseriesImpl.setUSID(USID);
		}

		lectureseriesImpl.setPreviewVideoId(previewVideoId);
		lectureseriesImpl.setGroupId(groupId);
		lectureseriesImpl.setCompanyId(companyId);
		lectureseriesImpl.setUserId(userId);

		if (userName == null) {
			lectureseriesImpl.setUserName("");
		}
		else {
			lectureseriesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lectureseriesImpl.setCreateDate(null);
		}
		else {
			lectureseriesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lectureseriesImpl.setModifiedDate(null);
		}
		else {
			lectureseriesImpl.setModifiedDate(new Date(modifiedDate));
		}

		lectureseriesImpl.resetOriginalValues();

		return lectureseriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		number = objectInput.readUTF();
		eventType = objectInput.readUTF();

		categoryId = objectInput.readLong();
		name = objectInput.readUTF();
		shortDesc = objectInput.readUTF();

		termId = objectInput.readLong();
		language = objectInput.readUTF();
		facultyName = objectInput.readUTF();

		lectureseriesId = objectInput.readLong();
		password = objectInput.readUTF();

		approved = objectInput.readInt();
		longDesc = objectInput.readUTF();

		latestOpenAccessVideoId = objectInput.readLong();
		latestVideoUploadDate = objectInput.readLong();
		latestVideoGenerationDate = objectInput.readUTF();

		videoSort = objectInput.readInt();
		USID = objectInput.readUTF();

		previewVideoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (number == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(number);
		}

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		objectOutput.writeLong(categoryId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (shortDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortDesc);
		}

		objectOutput.writeLong(termId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (facultyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facultyName);
		}

		objectOutput.writeLong(lectureseriesId);

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeInt(approved);

		if (longDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longDesc);
		}

		objectOutput.writeLong(latestOpenAccessVideoId);
		objectOutput.writeLong(latestVideoUploadDate);

		if (latestVideoGenerationDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latestVideoGenerationDate);
		}

		objectOutput.writeInt(videoSort);

		if (USID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(USID);
		}

		objectOutput.writeLong(previewVideoId);

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

	public String number;
	public String eventType;
	public long categoryId;
	public String name;
	public String shortDesc;
	public long termId;
	public String language;
	public String facultyName;
	public long lectureseriesId;
	public String password;
	public int approved;
	public String longDesc;
	public long latestOpenAccessVideoId;
	public long latestVideoUploadDate;
	public String latestVideoGenerationDate;
	public int videoSort;

	public String USID;

	public long previewVideoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}