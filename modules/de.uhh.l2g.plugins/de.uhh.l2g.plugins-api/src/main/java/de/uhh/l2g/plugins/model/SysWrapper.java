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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Sys}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Sys
 * @generated
 */
@ProviderType
public class SysWrapper
	extends BaseModelWrapper<Sys> implements Sys, ModelWrapper<Sys> {

	public SysWrapper(Sys sys) {
		super(sys);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sysId", getSysId());
		attributes.put("version", getVersion());
		attributes.put("setupWizard", getSetupWizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer sysId = (Integer)attributes.get("sysId");

		if (sysId != null) {
			setSysId(sysId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupWizard = (Integer)attributes.get("setupWizard");

		if (setupWizard != null) {
			setSetupWizard(setupWizard);
		}
	}

	/**
	 * Returns the primary key of this sys.
	 *
	 * @return the primary key of this sys
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the setup wizard of this sys.
	 *
	 * @return the setup wizard of this sys
	 */
	@Override
	public int getSetupWizard() {
		return model.getSetupWizard();
	}

	/**
	 * Returns the sys ID of this sys.
	 *
	 * @return the sys ID of this sys
	 */
	@Override
	public int getSysId() {
		return model.getSysId();
	}

	/**
	 * Returns the version of this sys.
	 *
	 * @return the version of this sys
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this sys.
	 *
	 * @param primaryKey the primary key of this sys
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the setup wizard of this sys.
	 *
	 * @param setupWizard the setup wizard of this sys
	 */
	@Override
	public void setSetupWizard(int setupWizard) {
		model.setSetupWizard(setupWizard);
	}

	/**
	 * Sets the sys ID of this sys.
	 *
	 * @param sysId the sys ID of this sys
	 */
	@Override
	public void setSysId(int sysId) {
		model.setSysId(sysId);
	}

	/**
	 * Sets the version of this sys.
	 *
	 * @param version the version of this sys
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	protected SysWrapper wrap(Sys sys) {
		return new SysWrapper(sys);
	}

}