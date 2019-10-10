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
 * This class is a wrapper for {@link Video_Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Institution
 * @generated
 */
@ProviderType
public class Video_InstitutionWrapper
	extends BaseModelWrapper<Video_Institution>
	implements Video_Institution, ModelWrapper<Video_Institution> {

	public Video_InstitutionWrapper(Video_Institution video_Institution) {
		super(video_Institution);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoInstitutionId", getVideoInstitutionId());
		attributes.put("videoId", getVideoId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("institutionParentId", getInstitutionParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoInstitutionId = (Long)attributes.get("videoInstitutionId");

		if (videoInstitutionId != null) {
			setVideoInstitutionId(videoInstitutionId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long institutionParentId = (Long)attributes.get("institutionParentId");

		if (institutionParentId != null) {
			setInstitutionParentId(institutionParentId);
		}
	}

	/**
	 * Returns the institution ID of this video_ institution.
	 *
	 * @return the institution ID of this video_ institution
	 */
	@Override
	public long getInstitutionId() {
		return model.getInstitutionId();
	}

	/**
	 * Returns the institution parent ID of this video_ institution.
	 *
	 * @return the institution parent ID of this video_ institution
	 */
	@Override
	public long getInstitutionParentId() {
		return model.getInstitutionParentId();
	}

	/**
	 * Returns the primary key of this video_ institution.
	 *
	 * @return the primary key of this video_ institution
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video ID of this video_ institution.
	 *
	 * @return the video ID of this video_ institution
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	/**
	 * Returns the video institution ID of this video_ institution.
	 *
	 * @return the video institution ID of this video_ institution
	 */
	@Override
	public long getVideoInstitutionId() {
		return model.getVideoInstitutionId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the institution ID of this video_ institution.
	 *
	 * @param institutionId the institution ID of this video_ institution
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		model.setInstitutionId(institutionId);
	}

	/**
	 * Sets the institution parent ID of this video_ institution.
	 *
	 * @param institutionParentId the institution parent ID of this video_ institution
	 */
	@Override
	public void setInstitutionParentId(long institutionParentId) {
		model.setInstitutionParentId(institutionParentId);
	}

	/**
	 * Sets the primary key of this video_ institution.
	 *
	 * @param primaryKey the primary key of this video_ institution
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video ID of this video_ institution.
	 *
	 * @param videoId the video ID of this video_ institution
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	/**
	 * Sets the video institution ID of this video_ institution.
	 *
	 * @param videoInstitutionId the video institution ID of this video_ institution
	 */
	@Override
	public void setVideoInstitutionId(long videoInstitutionId) {
		model.setVideoInstitutionId(videoInstitutionId);
	}

	@Override
	protected Video_InstitutionWrapper wrap(
		Video_Institution video_Institution) {

		return new Video_InstitutionWrapper(video_Institution);
	}

}