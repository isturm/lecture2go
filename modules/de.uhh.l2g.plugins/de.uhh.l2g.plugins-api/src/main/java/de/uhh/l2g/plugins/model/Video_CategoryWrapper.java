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
 * This class is a wrapper for {@link Video_Category}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Category
 * @generated
 */
@ProviderType
public class Video_CategoryWrapper
	extends BaseModelWrapper<Video_Category>
	implements Video_Category, ModelWrapper<Video_Category> {

	public Video_CategoryWrapper(Video_Category video_Category) {
		super(video_Category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoCategoryId", getVideoCategoryId());
		attributes.put("videoId", getVideoId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoCategoryId = (Long)attributes.get("videoCategoryId");

		if (videoCategoryId != null) {
			setVideoCategoryId(videoCategoryId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	 * Returns the category ID of this video_ category.
	 *
	 * @return the category ID of this video_ category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the primary key of this video_ category.
	 *
	 * @return the primary key of this video_ category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video category ID of this video_ category.
	 *
	 * @return the video category ID of this video_ category
	 */
	@Override
	public long getVideoCategoryId() {
		return model.getVideoCategoryId();
	}

	/**
	 * Returns the video ID of this video_ category.
	 *
	 * @return the video ID of this video_ category
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
	 * Sets the category ID of this video_ category.
	 *
	 * @param categoryId the category ID of this video_ category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the primary key of this video_ category.
	 *
	 * @param primaryKey the primary key of this video_ category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video category ID of this video_ category.
	 *
	 * @param videoCategoryId the video category ID of this video_ category
	 */
	@Override
	public void setVideoCategoryId(long videoCategoryId) {
		model.setVideoCategoryId(videoCategoryId);
	}

	/**
	 * Sets the video ID of this video_ category.
	 *
	 * @param videoId the video ID of this video_ category
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected Video_CategoryWrapper wrap(Video_Category video_Category) {
		return new Video_CategoryWrapper(video_Category);
	}

}