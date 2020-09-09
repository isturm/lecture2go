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
 * This class is a wrapper for {@link OaiRecord_OaiSet}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSet
 * @generated
 */
public class OaiRecord_OaiSetWrapper
	extends BaseModelWrapper<OaiRecord_OaiSet>
	implements ModelWrapper<OaiRecord_OaiSet>, OaiRecord_OaiSet {

	public OaiRecord_OaiSetWrapper(OaiRecord_OaiSet oaiRecord_OaiSet) {
		super(oaiRecord_OaiSet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordOaiSetId", getOaiRecordOaiSetId());
		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("oaiSetId", getOaiSetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordOaiSetId = (Long)attributes.get("oaiRecordOaiSetId");

		if (oaiRecordOaiSetId != null) {
			setOaiRecordOaiSetId(oaiRecordOaiSetId);
		}

		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}
	}

	/**
	 * Returns the oai record ID of this oai record_ oai set.
	 *
	 * @return the oai record ID of this oai record_ oai set
	 */
	@Override
	public long getOaiRecordId() {
		return model.getOaiRecordId();
	}

	/**
	 * Returns the oai record oai set ID of this oai record_ oai set.
	 *
	 * @return the oai record oai set ID of this oai record_ oai set
	 */
	@Override
	public long getOaiRecordOaiSetId() {
		return model.getOaiRecordOaiSetId();
	}

	/**
	 * Returns the oai set ID of this oai record_ oai set.
	 *
	 * @return the oai set ID of this oai record_ oai set
	 */
	@Override
	public long getOaiSetId() {
		return model.getOaiSetId();
	}

	/**
	 * Returns the primary key of this oai record_ oai set.
	 *
	 * @return the primary key of this oai record_ oai set
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the oai record ID of this oai record_ oai set.
	 *
	 * @param oaiRecordId the oai record ID of this oai record_ oai set
	 */
	@Override
	public void setOaiRecordId(long oaiRecordId) {
		model.setOaiRecordId(oaiRecordId);
	}

	/**
	 * Sets the oai record oai set ID of this oai record_ oai set.
	 *
	 * @param oaiRecordOaiSetId the oai record oai set ID of this oai record_ oai set
	 */
	@Override
	public void setOaiRecordOaiSetId(long oaiRecordOaiSetId) {
		model.setOaiRecordOaiSetId(oaiRecordOaiSetId);
	}

	/**
	 * Sets the oai set ID of this oai record_ oai set.
	 *
	 * @param oaiSetId the oai set ID of this oai record_ oai set
	 */
	@Override
	public void setOaiSetId(long oaiSetId) {
		model.setOaiSetId(oaiSetId);
	}

	/**
	 * Sets the primary key of this oai record_ oai set.
	 *
	 * @param primaryKey the primary key of this oai record_ oai set
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected OaiRecord_OaiSetWrapper wrap(OaiRecord_OaiSet oaiRecord_OaiSet) {
		return new OaiRecord_OaiSetWrapper(oaiRecord_OaiSet);
	}

}