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

import de.uhh.l2g.plugins.model.Term;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Term in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class TermCacheModel implements CacheModel<Term>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TermCacheModel)) {
			return false;
		}

		TermCacheModel termCacheModel = (TermCacheModel)obj;

		if (termId == termCacheModel.termId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, termId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{termId=");
		sb.append(termId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", year=");
		sb.append(year);
		sb.append(", translation=");
		sb.append(translation);
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
	public Term toEntityModel() {
		TermImpl termImpl = new TermImpl();

		termImpl.setTermId(termId);
		termImpl.setParentId(parentId);

		if (languageId == null) {
			termImpl.setLanguageId("");
		}
		else {
			termImpl.setLanguageId(languageId);
		}

		if (prefix == null) {
			termImpl.setPrefix("");
		}
		else {
			termImpl.setPrefix(prefix);
		}

		if (year == null) {
			termImpl.setYear("");
		}
		else {
			termImpl.setYear(year);
		}

		if (translation == null) {
			termImpl.setTranslation("");
		}
		else {
			termImpl.setTranslation(translation);
		}

		termImpl.setGroupId(groupId);
		termImpl.setCompanyId(companyId);
		termImpl.setUserId(userId);

		if (userName == null) {
			termImpl.setUserName("");
		}
		else {
			termImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			termImpl.setCreateDate(null);
		}
		else {
			termImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			termImpl.setModifiedDate(null);
		}
		else {
			termImpl.setModifiedDate(new Date(modifiedDate));
		}

		termImpl.resetOriginalValues();

		return termImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		termId = objectInput.readLong();

		parentId = objectInput.readLong();
		languageId = objectInput.readUTF();
		prefix = objectInput.readUTF();
		year = objectInput.readUTF();
		translation = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(termId);

		objectOutput.writeLong(parentId);

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (prefix == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prefix);
		}

		if (year == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(year);
		}

		if (translation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(translation);
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

	public long termId;
	public long parentId;
	public String languageId;
	public String prefix;
	public String year;
	public String translation;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}