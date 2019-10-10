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

import de.uhh.l2g.plugins.model.Video;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Video in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class VideoCacheModel implements CacheModel<Video>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoCacheModel)) {
			return false;
		}

		VideoCacheModel videoCacheModel = (VideoCacheModel)obj;

		if (videoId == videoCacheModel.videoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, videoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{videoId=");
		sb.append(videoId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", producerId=");
		sb.append(producerId);
		sb.append(", containerFormat=");
		sb.append(containerFormat);
		sb.append(", filename=");
		sb.append(filename);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", hostId=");
		sb.append(hostId);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", generationDate=");
		sb.append(generationDate);
		sb.append(", openAccess=");
		sb.append(openAccess);
		sb.append(", downloadLink=");
		sb.append(downloadLink);
		sb.append(", metadataId=");
		sb.append(metadataId);
		sb.append(", secureFilename=");
		sb.append(secureFilename);
		sb.append(", hits=");
		sb.append(hits);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append(", permittedToSegment=");
		sb.append(permittedToSegment);
		sb.append(", rootInstitutionId=");
		sb.append(rootInstitutionId);
		sb.append(", citation2go=");
		sb.append(citation2go);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", password=");
		sb.append(password);
		sb.append(", licenseId=");
		sb.append(licenseId);
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
	public Video toEntityModel() {
		VideoImpl videoImpl = new VideoImpl();

		videoImpl.setVideoId(videoId);

		if (title == null) {
			videoImpl.setTitle("");
		}
		else {
			videoImpl.setTitle(title);
		}

		videoImpl.setLectureseriesId(lectureseriesId);
		videoImpl.setProducerId(producerId);

		if (containerFormat == null) {
			videoImpl.setContainerFormat("");
		}
		else {
			videoImpl.setContainerFormat(containerFormat);
		}

		if (filename == null) {
			videoImpl.setFilename("");
		}
		else {
			videoImpl.setFilename(filename);
		}

		if (resolution == null) {
			videoImpl.setResolution("");
		}
		else {
			videoImpl.setResolution(resolution);
		}

		if (duration == null) {
			videoImpl.setDuration("");
		}
		else {
			videoImpl.setDuration(duration);
		}

		videoImpl.setHostId(hostId);

		if (fileSize == null) {
			videoImpl.setFileSize("");
		}
		else {
			videoImpl.setFileSize(fileSize);
		}

		if (generationDate == null) {
			videoImpl.setGenerationDate("");
		}
		else {
			videoImpl.setGenerationDate(generationDate);
		}

		videoImpl.setOpenAccess(openAccess);
		videoImpl.setDownloadLink(downloadLink);
		videoImpl.setMetadataId(metadataId);

		if (secureFilename == null) {
			videoImpl.setSecureFilename("");
		}
		else {
			videoImpl.setSecureFilename(secureFilename);
		}

		videoImpl.setHits(hits);

		if (uploadDate == Long.MIN_VALUE) {
			videoImpl.setUploadDate(null);
		}
		else {
			videoImpl.setUploadDate(new Date(uploadDate));
		}

		videoImpl.setPermittedToSegment(permittedToSegment);
		videoImpl.setRootInstitutionId(rootInstitutionId);
		videoImpl.setCitation2go(citation2go);
		videoImpl.setTermId(termId);

		if (tags == null) {
			videoImpl.setTags("");
		}
		else {
			videoImpl.setTags(tags);
		}

		if (password == null) {
			videoImpl.setPassword("");
		}
		else {
			videoImpl.setPassword(password);
		}

		videoImpl.setLicenseId(licenseId);
		videoImpl.setGroupId(groupId);
		videoImpl.setCompanyId(companyId);
		videoImpl.setUserId(userId);

		if (userName == null) {
			videoImpl.setUserName("");
		}
		else {
			videoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoImpl.setCreateDate(null);
		}
		else {
			videoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoImpl.setModifiedDate(null);
		}
		else {
			videoImpl.setModifiedDate(new Date(modifiedDate));
		}

		videoImpl.resetOriginalValues();

		return videoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoId = objectInput.readLong();
		title = objectInput.readUTF();

		lectureseriesId = objectInput.readLong();

		producerId = objectInput.readLong();
		containerFormat = objectInput.readUTF();
		filename = objectInput.readUTF();
		resolution = objectInput.readUTF();
		duration = objectInput.readUTF();

		hostId = objectInput.readLong();
		fileSize = objectInput.readUTF();
		generationDate = objectInput.readUTF();

		openAccess = objectInput.readInt();

		downloadLink = objectInput.readInt();

		metadataId = objectInput.readLong();
		secureFilename = objectInput.readUTF();

		hits = objectInput.readLong();
		uploadDate = objectInput.readLong();

		permittedToSegment = objectInput.readInt();

		rootInstitutionId = objectInput.readLong();

		citation2go = objectInput.readInt();

		termId = objectInput.readLong();
		tags = objectInput.readUTF();
		password = objectInput.readUTF();

		licenseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(videoId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(lectureseriesId);

		objectOutput.writeLong(producerId);

		if (containerFormat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(containerFormat);
		}

		if (filename == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filename);
		}

		if (resolution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resolution);
		}

		if (duration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duration);
		}

		objectOutput.writeLong(hostId);

		if (fileSize == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (generationDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(generationDate);
		}

		objectOutput.writeInt(openAccess);

		objectOutput.writeInt(downloadLink);

		objectOutput.writeLong(metadataId);

		if (secureFilename == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secureFilename);
		}

		objectOutput.writeLong(hits);
		objectOutput.writeLong(uploadDate);

		objectOutput.writeInt(permittedToSegment);

		objectOutput.writeLong(rootInstitutionId);

		objectOutput.writeInt(citation2go);

		objectOutput.writeLong(termId);

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeLong(licenseId);

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

	public long videoId;
	public String title;
	public long lectureseriesId;
	public long producerId;
	public String containerFormat;
	public String filename;
	public String resolution;
	public String duration;
	public long hostId;
	public String fileSize;
	public String generationDate;
	public int openAccess;
	public int downloadLink;
	public long metadataId;
	public String secureFilename;
	public long hits;
	public long uploadDate;
	public int permittedToSegment;
	public long rootInstitutionId;
	public int citation2go;
	public long termId;
	public String tags;
	public String password;
	public long licenseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}