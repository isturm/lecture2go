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

import de.uhh.l2g.plugins.model.Coordinator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Coordinator in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class CoordinatorCacheModel
	implements CacheModel<Coordinator>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinatorCacheModel)) {
			return false;
		}

		CoordinatorCacheModel coordinatorCacheModel =
			(CoordinatorCacheModel)obj;

		if (coordinatorId == coordinatorCacheModel.coordinatorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coordinatorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{coordinatorId=");
		sb.append(coordinatorId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", officeId=");
		sb.append(officeId);
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
	public Coordinator toEntityModel() {
		CoordinatorImpl coordinatorImpl = new CoordinatorImpl();

		coordinatorImpl.setCoordinatorId(coordinatorId);
		coordinatorImpl.setInstitutionId(institutionId);
		coordinatorImpl.setOfficeId(officeId);
		coordinatorImpl.setGroupId(groupId);
		coordinatorImpl.setCompanyId(companyId);
		coordinatorImpl.setUserId(userId);

		if (userName == null) {
			coordinatorImpl.setUserName("");
		}
		else {
			coordinatorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			coordinatorImpl.setCreateDate(null);
		}
		else {
			coordinatorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			coordinatorImpl.setModifiedDate(null);
		}
		else {
			coordinatorImpl.setModifiedDate(new Date(modifiedDate));
		}

		coordinatorImpl.resetOriginalValues();

		return coordinatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coordinatorId = objectInput.readLong();

		institutionId = objectInput.readLong();

		officeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(coordinatorId);

		objectOutput.writeLong(institutionId);

		objectOutput.writeLong(officeId);

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

	public long coordinatorId;
	public long institutionId;
	public long officeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}