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
 * This class is a wrapper for {@link Video_MediaType}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_MediaType
 * @generated
 */
@ProviderType
public class Video_MediaTypeWrapper
	extends BaseModelWrapper<Video_MediaType>
	implements Video_MediaType, ModelWrapper<Video_MediaType> {

	public Video_MediaTypeWrapper(Video_MediaType video_MediaType) {
		super(video_MediaType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoMediaTypeId", getVideoMediaTypeId());
		attributes.put("videoId", getVideoId());
		attributes.put("MediaTypeId", getMediaTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoMediaTypeId = (Long)attributes.get("videoMediaTypeId");

		if (videoMediaTypeId != null) {
			setVideoMediaTypeId(videoMediaTypeId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long MediaTypeId = (Long)attributes.get("MediaTypeId");

		if (MediaTypeId != null) {
			setMediaTypeId(MediaTypeId);
		}
	}

	/**
	 * Returns the media type ID of this video_ media type.
	 *
	 * @return the media type ID of this video_ media type
	 */
	@Override
	public long getMediaTypeId() {
		return model.getMediaTypeId();
	}

	/**
	 * Returns the primary key of this video_ media type.
	 *
	 * @return the primary key of this video_ media type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video ID of this video_ media type.
	 *
	 * @return the video ID of this video_ media type
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	/**
	 * Returns the video media type ID of this video_ media type.
	 *
	 * @return the video media type ID of this video_ media type
	 */
	@Override
	public long getVideoMediaTypeId() {
		return model.getVideoMediaTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the media type ID of this video_ media type.
	 *
	 * @param MediaTypeId the media type ID of this video_ media type
	 */
	@Override
	public void setMediaTypeId(long MediaTypeId) {
		model.setMediaTypeId(MediaTypeId);
	}

	/**
	 * Sets the primary key of this video_ media type.
	 *
	 * @param primaryKey the primary key of this video_ media type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video ID of this video_ media type.
	 *
	 * @param videoId the video ID of this video_ media type
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	/**
	 * Sets the video media type ID of this video_ media type.
	 *
	 * @param videoMediaTypeId the video media type ID of this video_ media type
	 */
	@Override
	public void setVideoMediaTypeId(long videoMediaTypeId) {
		model.setVideoMediaTypeId(videoMediaTypeId);
	}

	@Override
	protected Video_MediaTypeWrapper wrap(Video_MediaType video_MediaType) {
		return new Video_MediaTypeWrapper(video_MediaType);
	}

}