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
 * This class is a wrapper for {@link Video_Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Creator
 * @generated
 */
@ProviderType
public class Video_CreatorWrapper
	extends BaseModelWrapper<Video_Creator>
	implements Video_Creator, ModelWrapper<Video_Creator> {

	public Video_CreatorWrapper(Video_Creator video_Creator) {
		super(video_Creator);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCreatorId", getVideoCreatorId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCreatorId = (Long)attributes.get("videoCreatorId");

		if (videoCreatorId != null) {
			setVideoCreatorId(videoCreatorId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	/**
	 * Returns the creator ID of this video_ creator.
	 *
	 * @return the creator ID of this video_ creator
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the primary key of this video_ creator.
	 *
	 * @return the primary key of this video_ creator
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video creator ID of this video_ creator.
	 *
	 * @return the video creator ID of this video_ creator
	 */
	@Override
	public long getVideoCreatorId() {
		return model.getVideoCreatorId();
	}

	/**
	 * Returns the video ID of this video_ creator.
	 *
	 * @return the video ID of this video_ creator
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the creator ID of this video_ creator.
	 *
	 * @param creatorId the creator ID of this video_ creator
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the primary key of this video_ creator.
	 *
	 * @param primaryKey the primary key of this video_ creator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video creator ID of this video_ creator.
	 *
	 * @param videoCreatorId the video creator ID of this video_ creator
	 */
	@Override
	public void setVideoCreatorId(long videoCreatorId) {
		model.setVideoCreatorId(videoCreatorId);
	}

	/**
	 * Sets the video ID of this video_ creator.
	 *
	 * @param videoId the video ID of this video_ creator
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected Video_CreatorWrapper wrap(Video_Creator video_Creator) {
		return new Video_CreatorWrapper(video_Creator);
	}

}