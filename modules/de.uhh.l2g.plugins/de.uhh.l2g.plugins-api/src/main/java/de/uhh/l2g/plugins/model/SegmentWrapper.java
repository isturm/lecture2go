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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Segment}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Segment
 * @generated
 */
@ProviderType
public class SegmentWrapper
	extends BaseModelWrapper<Segment>
	implements Segment, ModelWrapper<Segment> {

	public SegmentWrapper(Segment segment) {
		super(segment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("videoId", getVideoId());
		attributes.put("start", getStart());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("end", getEnd());
		attributes.put("chapter", getChapter());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String start = (String)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String end = (String)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}

		Integer chapter = (Integer)attributes.get("chapter");

		if (chapter != null) {
			setChapter(chapter);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the chapter of this segment.
	 *
	 * @return the chapter of this segment
	 */
	@Override
	public int getChapter() {
		return model.getChapter();
	}

	/**
	 * Returns the company ID of this segment.
	 *
	 * @return the company ID of this segment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this segment.
	 *
	 * @return the create date of this segment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this segment.
	 *
	 * @return the description of this segment
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end of this segment.
	 *
	 * @return the end of this segment
	 */
	@Override
	public String getEnd() {
		return model.getEnd();
	}

	/**
	 * Returns the group ID of this segment.
	 *
	 * @return the group ID of this segment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the modified date of this segment.
	 *
	 * @return the modified date of this segment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	@Override
	public int getNumber() {
		return model.getNumber();
	}

	@Override
	public long getPreviusSegmentId() {
		return model.getPreviusSegmentId();
	}

	/**
	 * Returns the primary key of this segment.
	 *
	 * @return the primary key of this segment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public int getSeconds() {
		return model.getSeconds();
	}

	/**
	 * Returns the segment ID of this segment.
	 *
	 * @return the segment ID of this segment
	 */
	@Override
	public long getSegmentId() {
		return model.getSegmentId();
	}

	/**
	 * Returns the start of this segment.
	 *
	 * @return the start of this segment
	 */
	@Override
	public String getStart() {
		return model.getStart();
	}

	/**
	 * Returns the title of this segment.
	 *
	 * @return the title of this segment
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this segment.
	 *
	 * @return the user ID of this segment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this segment.
	 *
	 * @return the user name of this segment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this segment.
	 *
	 * @return the user uuid of this segment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the video ID of this segment.
	 *
	 * @return the video ID of this segment
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
	 * Sets the chapter of this segment.
	 *
	 * @param chapter the chapter of this segment
	 */
	@Override
	public void setChapter(int chapter) {
		model.setChapter(chapter);
	}

	/**
	 * Sets the company ID of this segment.
	 *
	 * @param companyId the company ID of this segment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this segment.
	 *
	 * @param createDate the create date of this segment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this segment.
	 *
	 * @param description the description of this segment
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end of this segment.
	 *
	 * @param end the end of this segment
	 */
	@Override
	public void setEnd(String end) {
		model.setEnd(end);
	}

	/**
	 * Sets the group ID of this segment.
	 *
	 * @param groupId the group ID of this segment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the modified date of this segment.
	 *
	 * @param modifiedDate the modified date of this segment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNumber(int number) {
		model.setNumber(number);
	}

	@Override
	public void setPreviusSegmentId(long previusSegmentId) {
		model.setPreviusSegmentId(previusSegmentId);
	}

	/**
	 * Sets the primary key of this segment.
	 *
	 * @param primaryKey the primary key of this segment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public void setSeconds(int seconds) {
		model.setSeconds(seconds);
	}

	/**
	 * Sets the segment ID of this segment.
	 *
	 * @param segmentId the segment ID of this segment
	 */
	@Override
	public void setSegmentId(long segmentId) {
		model.setSegmentId(segmentId);
	}

	/**
	 * Sets the start of this segment.
	 *
	 * @param start the start of this segment
	 */
	@Override
	public void setStart(String start) {
		model.setStart(start);
	}

	/**
	 * Sets the title of this segment.
	 *
	 * @param title the title of this segment
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this segment.
	 *
	 * @param userId the user ID of this segment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this segment.
	 *
	 * @param userName the user name of this segment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this segment.
	 *
	 * @param userUuid the user uuid of this segment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the video ID of this segment.
	 *
	 * @param videoId the video ID of this segment
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected SegmentWrapper wrap(Segment segment) {
		return new SegmentWrapper(segment);
	}

}