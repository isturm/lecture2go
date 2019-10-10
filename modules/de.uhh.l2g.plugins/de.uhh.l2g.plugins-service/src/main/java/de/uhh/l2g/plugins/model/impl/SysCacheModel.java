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

import de.uhh.l2g.plugins.model.Sys;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Sys in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class SysCacheModel implements CacheModel<Sys>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SysCacheModel)) {
			return false;
		}

		SysCacheModel sysCacheModel = (SysCacheModel)obj;

		if (sysId == sysCacheModel.sysId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sysId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{sysId=");
		sb.append(sysId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", setupWizard=");
		sb.append(setupWizard);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sys toEntityModel() {
		SysImpl sysImpl = new SysImpl();

		sysImpl.setSysId(sysId);

		if (version == null) {
			sysImpl.setVersion("");
		}
		else {
			sysImpl.setVersion(version);
		}

		sysImpl.setSetupWizard(setupWizard);

		sysImpl.resetOriginalValues();

		return sysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sysId = objectInput.readInt();
		version = objectInput.readUTF();

		setupWizard = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(sysId);

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeInt(setupWizard);
	}

	public int sysId;
	public String version;
	public int setupWizard;

}