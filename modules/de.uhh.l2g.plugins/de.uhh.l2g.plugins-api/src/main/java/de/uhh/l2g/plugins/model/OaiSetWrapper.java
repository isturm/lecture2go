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

/**
 * <p>
 * This class is a wrapper for {@link OaiSet}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSet
 * @generated
 */
public class OaiSetWrapper
	extends BaseModelWrapper<OaiSet> implements ModelWrapper<OaiSet>, OaiSet {

	public OaiSetWrapper(OaiSet oaiSet) {
		super(oaiSet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiSetId", getOaiSetId());
		attributes.put("setSpec", getSetSpec());
		attributes.put("setName", getSetName());
		attributes.put("setDescription", getSetDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}

		String setSpec = (String)attributes.get("setSpec");

		if (setSpec != null) {
			setSetSpec(setSpec);
		}

		String setName = (String)attributes.get("setName");

		if (setName != null) {
			setSetName(setName);
		}

		String setDescription = (String)attributes.get("setDescription");

		if (setDescription != null) {
			setSetDescription(setDescription);
		}
	}

	/**
	 * Returns the oai set ID of this oai set.
	 *
	 * @return the oai set ID of this oai set
	 */
	@Override
	public long getOaiSetId() {
		return model.getOaiSetId();
	}

	/**
	 * Returns the primary key of this oai set.
	 *
	 * @return the primary key of this oai set
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the set description of this oai set.
	 *
	 * @return the set description of this oai set
	 */
	@Override
	public String getSetDescription() {
		return model.getSetDescription();
	}

	/**
	 * Returns the set name of this oai set.
	 *
	 * @return the set name of this oai set
	 */
	@Override
	public String getSetName() {
		return model.getSetName();
	}

	/**
	 * Returns the set spec of this oai set.
	 *
	 * @return the set spec of this oai set
	 */
	@Override
	public String getSetSpec() {
		return model.getSetSpec();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the oai set ID of this oai set.
	 *
	 * @param oaiSetId the oai set ID of this oai set
	 */
	@Override
	public void setOaiSetId(long oaiSetId) {
		model.setOaiSetId(oaiSetId);
	}

	/**
	 * Sets the primary key of this oai set.
	 *
	 * @param primaryKey the primary key of this oai set
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the set description of this oai set.
	 *
	 * @param setDescription the set description of this oai set
	 */
	@Override
	public void setSetDescription(String setDescription) {
		model.setSetDescription(setDescription);
	}

	/**
	 * Sets the set name of this oai set.
	 *
	 * @param setName the set name of this oai set
	 */
	@Override
	public void setSetName(String setName) {
		model.setSetName(setName);
	}

	/**
	 * Sets the set spec of this oai set.
	 *
	 * @param setSpec the set spec of this oai set
	 */
	@Override
	public void setSetSpec(String setSpec) {
		model.setSetSpec(setSpec);
	}

	@Override
	protected OaiSetWrapper wrap(OaiSet oaiSet) {
		return new OaiSetWrapper(oaiSet);
	}

}