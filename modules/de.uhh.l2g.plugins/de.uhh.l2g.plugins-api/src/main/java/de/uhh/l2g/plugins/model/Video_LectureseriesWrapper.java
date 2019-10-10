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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Video_Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_Lectureseries
 * @generated
 */
@ProviderType
public class Video_LectureseriesWrapper implements Video_Lectureseries,
	ModelWrapper<Video_Lectureseries> {
	public Video_LectureseriesWrapper(Video_Lectureseries video_Lectureseries) {
		_video_Lectureseries = video_Lectureseries;
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoLectureseriesId", getVideoLectureseriesId());
		attributes.put("videoId", getVideoId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("openAccess", getOpenAccess());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoLectureseriesId = (Long)attributes.get("videoLectureseriesId");

		if (videoLectureseriesId != null) {
			setVideoLectureseriesId(videoLectureseriesId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Integer openAccess = (Integer)attributes.get("openAccess");

		if (openAccess != null) {
			setOpenAccess(openAccess);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _video_Lectureseries.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _video_Lectureseries.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _video_Lectureseries.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _video_Lectureseries.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.uhh.l2g.plugins.model.Video_Lectureseries> toCacheModel() {
		return _video_Lectureseries.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries toEscapedModel() {
		return new Video_LectureseriesWrapper(_video_Lectureseries.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video_Lectureseries toUnescapedModel() {
		return new Video_LectureseriesWrapper(_video_Lectureseries.toUnescapedModel());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.model.Video_Lectureseries video_Lectureseries) {
		return _video_Lectureseries.compareTo(video_Lectureseries);
	}

	/**
	* Returns the open access of this video_ lectureseries.
	*
	* @return the open access of this video_ lectureseries
	*/
	@Override
	public int getOpenAccess() {
		return _video_Lectureseries.getOpenAccess();
	}

	@Override
	public int hashCode() {
		return _video_Lectureseries.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _video_Lectureseries.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Video_LectureseriesWrapper((Video_Lectureseries)_video_Lectureseries.clone());
	}

	@Override
	public java.lang.String toString() {
		return _video_Lectureseries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video_Lectureseries.toXmlString();
	}

	/**
	* Returns the lectureseries ID of this video_ lectureseries.
	*
	* @return the lectureseries ID of this video_ lectureseries
	*/
	@Override
	public long getLectureseriesId() {
		return _video_Lectureseries.getLectureseriesId();
	}

	/**
	* Returns the primary key of this video_ lectureseries.
	*
	* @return the primary key of this video_ lectureseries
	*/
	@Override
	public long getPrimaryKey() {
		return _video_Lectureseries.getPrimaryKey();
	}

	/**
	* Returns the video ID of this video_ lectureseries.
	*
	* @return the video ID of this video_ lectureseries
	*/
	@Override
	public long getVideoId() {
		return _video_Lectureseries.getVideoId();
	}

	/**
	* Returns the video lectureseries ID of this video_ lectureseries.
	*
	* @return the video lectureseries ID of this video_ lectureseries
	*/
	@Override
	public long getVideoLectureseriesId() {
		return _video_Lectureseries.getVideoLectureseriesId();
	}

	@Override
	public void persist() {
		_video_Lectureseries.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video_Lectureseries.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_video_Lectureseries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_video_Lectureseries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_video_Lectureseries.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the lectureseries ID of this video_ lectureseries.
	*
	* @param lectureseriesId the lectureseries ID of this video_ lectureseries
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_video_Lectureseries.setLectureseriesId(lectureseriesId);
	}

	@Override
	public void setNew(boolean n) {
		_video_Lectureseries.setNew(n);
	}

	/**
	* Sets the open access of this video_ lectureseries.
	*
	* @param openAccess the open access of this video_ lectureseries
	*/
	@Override
	public void setOpenAccess(int openAccess) {
		_video_Lectureseries.setOpenAccess(openAccess);
	}

	/**
	* Sets the primary key of this video_ lectureseries.
	*
	* @param primaryKey the primary key of this video_ lectureseries
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video_Lectureseries.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_video_Lectureseries.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the video ID of this video_ lectureseries.
	*
	* @param videoId the video ID of this video_ lectureseries
	*/
	@Override
	public void setVideoId(long videoId) {
		_video_Lectureseries.setVideoId(videoId);
	}

	/**
	* Sets the video lectureseries ID of this video_ lectureseries.
	*
	* @param videoLectureseriesId the video lectureseries ID of this video_ lectureseries
	*/
	@Override
	public void setVideoLectureseriesId(long videoLectureseriesId) {
		_video_Lectureseries.setVideoLectureseriesId(videoLectureseriesId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_LectureseriesWrapper)) {
			return false;
		}

		Video_LectureseriesWrapper video_LectureseriesWrapper = (Video_LectureseriesWrapper)obj;

		if (Objects.equals(_video_Lectureseries,
					video_LectureseriesWrapper._video_Lectureseries)) {
			return true;
		}

		return false;
	}

	@Override
	public Video_Lectureseries getWrappedModel() {
		return _video_Lectureseries;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _video_Lectureseries.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _video_Lectureseries.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_video_Lectureseries.resetOriginalValues();
	}

	private final Video_Lectureseries _video_Lectureseries;
}