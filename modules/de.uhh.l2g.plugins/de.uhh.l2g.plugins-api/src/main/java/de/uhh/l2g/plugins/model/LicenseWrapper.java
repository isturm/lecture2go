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
 * This class is a wrapper for {@link License}.
 * </p>
 *
 * @author Iavor Sturm
 * @see License
 * @generated
 */
@ProviderType
public class LicenseWrapper
	extends BaseModelWrapper<License>
	implements License, ModelWrapper<License> {

	public LicenseWrapper(License license) {
		super(license);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licenseId", getLicenseId());
		attributes.put("fullName", getFullName());
		attributes.put("shortIdentifier", getShortIdentifier());
		attributes.put("url", getUrl());
		attributes.put("schemeName", getSchemeName());
		attributes.put("schemeUrl", getSchemeUrl());
		attributes.put("selectable", isSelectable());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String shortIdentifier = (String)attributes.get("shortIdentifier");

		if (shortIdentifier != null) {
			setShortIdentifier(shortIdentifier);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String schemeName = (String)attributes.get("schemeName");

		if (schemeName != null) {
			setSchemeName(schemeName);
		}

		String schemeUrl = (String)attributes.get("schemeUrl");

		if (schemeUrl != null) {
			setSchemeUrl(schemeUrl);
		}

		Boolean selectable = (Boolean)attributes.get("selectable");

		if (selectable != null) {
			setSelectable(selectable);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the description of this license.
	 *
	 * @return the description of this license
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the full name of this license.
	 *
	 * @return the full name of this license
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the license ID of this license.
	 *
	 * @return the license ID of this license
	 */
	@Override
	public long getLicenseId() {
		return model.getLicenseId();
	}

	/**
	 * Returns the primary key of this license.
	 *
	 * @return the primary key of this license
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the scheme name of this license.
	 *
	 * @return the scheme name of this license
	 */
	@Override
	public String getSchemeName() {
		return model.getSchemeName();
	}

	/**
	 * Returns the scheme url of this license.
	 *
	 * @return the scheme url of this license
	 */
	@Override
	public String getSchemeUrl() {
		return model.getSchemeUrl();
	}

	/**
	 * Returns the selectable of this license.
	 *
	 * @return the selectable of this license
	 */
	@Override
	public boolean getSelectable() {
		return model.getSelectable();
	}

	/**
	 * Returns the short identifier of this license.
	 *
	 * @return the short identifier of this license
	 */
	@Override
	public String getShortIdentifier() {
		return model.getShortIdentifier();
	}

	/**
	 * Returns the url of this license.
	 *
	 * @return the url of this license
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns <code>true</code> if this license is selectable.
	 *
	 * @return <code>true</code> if this license is selectable; <code>false</code> otherwise
	 */
	@Override
	public boolean isSelectable() {
		return model.isSelectable();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this license.
	 *
	 * @param description the description of this license
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the full name of this license.
	 *
	 * @param fullName the full name of this license
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the license ID of this license.
	 *
	 * @param licenseId the license ID of this license
	 */
	@Override
	public void setLicenseId(long licenseId) {
		model.setLicenseId(licenseId);
	}

	/**
	 * Sets the primary key of this license.
	 *
	 * @param primaryKey the primary key of this license
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scheme name of this license.
	 *
	 * @param schemeName the scheme name of this license
	 */
	@Override
	public void setSchemeName(String schemeName) {
		model.setSchemeName(schemeName);
	}

	/**
	 * Sets the scheme url of this license.
	 *
	 * @param schemeUrl the scheme url of this license
	 */
	@Override
	public void setSchemeUrl(String schemeUrl) {
		model.setSchemeUrl(schemeUrl);
	}

	/**
	 * Sets whether this license is selectable.
	 *
	 * @param selectable the selectable of this license
	 */
	@Override
	public void setSelectable(boolean selectable) {
		model.setSelectable(selectable);
	}

	/**
	 * Sets the short identifier of this license.
	 *
	 * @param shortIdentifier the short identifier of this license
	 */
	@Override
	public void setShortIdentifier(String shortIdentifier) {
		model.setShortIdentifier(shortIdentifier);
	}

	/**
	 * Sets the url of this license.
	 *
	 * @param url the url of this license
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	protected LicenseWrapper wrap(License license) {
		return new LicenseWrapper(license);
	}

}