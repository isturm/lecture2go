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

import de.uhh.l2g.plugins.model.Metadata;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Metadata in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class MetadataCacheModel
	implements CacheModel<Metadata>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MetadataCacheModel)) {
			return false;
		}

		MetadataCacheModel metadataCacheModel = (MetadataCacheModel)obj;

		if (metadataId == metadataCacheModel.metadataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, metadataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{metadataId=");
		sb.append(metadataId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", language=");
		sb.append(language);
		sb.append(", title=");
		sb.append(title);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publisher=");
		sb.append(publisher);
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
	public Metadata toEntityModel() {
		MetadataImpl metadataImpl = new MetadataImpl();

		metadataImpl.setMetadataId(metadataId);

		if (type == null) {
			metadataImpl.setType("");
		}
		else {
			metadataImpl.setType(type);
		}

		if (language == null) {
			metadataImpl.setLanguage("");
		}
		else {
			metadataImpl.setLanguage(language);
		}

		if (title == null) {
			metadataImpl.setTitle("");
		}
		else {
			metadataImpl.setTitle(title);
		}

		if (subject == null) {
			metadataImpl.setSubject("");
		}
		else {
			metadataImpl.setSubject(subject);
		}

		if (description == null) {
			metadataImpl.setDescription("");
		}
		else {
			metadataImpl.setDescription(description);
		}

		if (publisher == null) {
			metadataImpl.setPublisher("");
		}
		else {
			metadataImpl.setPublisher(publisher);
		}

		metadataImpl.setGroupId(groupId);
		metadataImpl.setCompanyId(companyId);
		metadataImpl.setUserId(userId);

		if (userName == null) {
			metadataImpl.setUserName("");
		}
		else {
			metadataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			metadataImpl.setCreateDate(null);
		}
		else {
			metadataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			metadataImpl.setModifiedDate(null);
		}
		else {
			metadataImpl.setModifiedDate(new Date(modifiedDate));
		}

		metadataImpl.resetOriginalValues();

		return metadataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metadataId = objectInput.readLong();
		type = objectInput.readUTF();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();
		publisher = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(metadataId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (publisher == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publisher);
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

	public long metadataId;
	public String type;
	public String language;
	public String title;
	public String subject;
	public String description;
	public String publisher;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}