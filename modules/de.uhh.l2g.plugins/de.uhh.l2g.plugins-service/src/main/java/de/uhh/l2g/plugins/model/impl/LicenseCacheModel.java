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

import de.uhh.l2g.plugins.model.License;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing License in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class LicenseCacheModel implements CacheModel<License>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LicenseCacheModel)) {
			return false;
		}

		LicenseCacheModel licenseCacheModel = (LicenseCacheModel)obj;

		if (licenseId == licenseCacheModel.licenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, licenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", shortIdentifier=");
		sb.append(shortIdentifier);
		sb.append(", url=");
		sb.append(url);
		sb.append(", schemeName=");
		sb.append(schemeName);
		sb.append(", schemeUrl=");
		sb.append(schemeUrl);
		sb.append(", selectable=");
		sb.append(selectable);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public License toEntityModel() {
		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setLicenseId(licenseId);

		if (fullName == null) {
			licenseImpl.setFullName("");
		}
		else {
			licenseImpl.setFullName(fullName);
		}

		if (shortIdentifier == null) {
			licenseImpl.setShortIdentifier("");
		}
		else {
			licenseImpl.setShortIdentifier(shortIdentifier);
		}

		if (url == null) {
			licenseImpl.setUrl("");
		}
		else {
			licenseImpl.setUrl(url);
		}

		if (schemeName == null) {
			licenseImpl.setSchemeName("");
		}
		else {
			licenseImpl.setSchemeName(schemeName);
		}

		if (schemeUrl == null) {
			licenseImpl.setSchemeUrl("");
		}
		else {
			licenseImpl.setSchemeUrl(schemeUrl);
		}

		licenseImpl.setSelectable(selectable);

		if (description == null) {
			licenseImpl.setDescription("");
		}
		else {
			licenseImpl.setDescription(description);
		}

		licenseImpl.resetOriginalValues();

		return licenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readLong();
		fullName = objectInput.readUTF();
		shortIdentifier = objectInput.readUTF();
		url = objectInput.readUTF();
		schemeName = objectInput.readUTF();
		schemeUrl = objectInput.readUTF();

		selectable = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(licenseId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (shortIdentifier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortIdentifier);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (schemeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schemeName);
		}

		if (schemeUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schemeUrl);
		}

		objectOutput.writeBoolean(selectable);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long licenseId;
	public String fullName;
	public String shortIdentifier;
	public String url;
	public String schemeName;
	public String schemeUrl;
	public boolean selectable;
	public String description;

}