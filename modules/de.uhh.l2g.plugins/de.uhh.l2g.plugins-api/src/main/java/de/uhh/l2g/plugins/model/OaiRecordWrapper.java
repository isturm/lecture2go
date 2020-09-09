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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OaiRecord}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord
 * @generated
 */
public class OaiRecordWrapper
	extends BaseModelWrapper<OaiRecord>
	implements ModelWrapper<OaiRecord>, OaiRecord {

	public OaiRecordWrapper(OaiRecord oaiRecord) {
		super(oaiRecord);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiRecordId", getOaiRecordId());
		attributes.put("videoId", getVideoId());
		attributes.put("identifier", getIdentifier());
		attributes.put("datestamp", getDatestamp());
		attributes.put("deleted", isDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiRecordId = (Long)attributes.get("oaiRecordId");

		if (oaiRecordId != null) {
			setOaiRecordId(oaiRecordId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		Date datestamp = (Date)attributes.get("datestamp");

		if (datestamp != null) {
			setDatestamp(datestamp);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	 * Returns the datestamp of this oai record.
	 *
	 * @return the datestamp of this oai record
	 */
	@Override
	public Date getDatestamp() {
		return model.getDatestamp();
	}

	/**
	 * Returns the deleted of this oai record.
	 *
	 * @return the deleted of this oai record
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the identifier of this oai record.
	 *
	 * @return the identifier of this oai record
	 */
	@Override
	public String getIdentifier() {
		return model.getIdentifier();
	}

	/**
	 * Returns the oai record ID of this oai record.
	 *
	 * @return the oai record ID of this oai record
	 */
	@Override
	public long getOaiRecordId() {
		return model.getOaiRecordId();
	}

	/**
	 * Returns the primary key of this oai record.
	 *
	 * @return the primary key of this oai record
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video ID of this oai record.
	 *
	 * @return the video ID of this oai record
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	/**
	 * Returns <code>true</code> if this oai record is deleted.
	 *
	 * @return <code>true</code> if this oai record is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the datestamp of this oai record.
	 *
	 * @param datestamp the datestamp of this oai record
	 */
	@Override
	public void setDatestamp(Date datestamp) {
		model.setDatestamp(datestamp);
	}

	/**
	 * Sets whether this oai record is deleted.
	 *
	 * @param deleted the deleted of this oai record
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the identifier of this oai record.
	 *
	 * @param identifier the identifier of this oai record
	 */
	@Override
	public void setIdentifier(String identifier) {
		model.setIdentifier(identifier);
	}

	/**
	 * Sets the oai record ID of this oai record.
	 *
	 * @param oaiRecordId the oai record ID of this oai record
	 */
	@Override
	public void setOaiRecordId(long oaiRecordId) {
		model.setOaiRecordId(oaiRecordId);
	}

	/**
	 * Sets the primary key of this oai record.
	 *
	 * @param primaryKey the primary key of this oai record
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video ID of this oai record.
	 *
	 * @param videoId the video ID of this oai record
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected OaiRecordWrapper wrap(OaiRecord oaiRecord) {
		return new OaiRecordWrapper(oaiRecord);
	}

}