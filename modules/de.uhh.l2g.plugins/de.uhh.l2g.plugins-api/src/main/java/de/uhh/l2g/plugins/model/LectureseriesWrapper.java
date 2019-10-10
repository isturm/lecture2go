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
 * This class is a wrapper for {@link Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries
 * @generated
 */
@ProviderType
public class LectureseriesWrapper
	extends BaseModelWrapper<Lectureseries>
	implements Lectureseries, ModelWrapper<Lectureseries> {

	public LectureseriesWrapper(Lectureseries lectureseries) {
		super(lectureseries);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("eventType", getEventType());
		attributes.put("categoryId", getCategoryId());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("termId", getTermId());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());
		attributes.put("latestOpenAccessVideoId", getLatestOpenAccessVideoId());
		attributes.put("latestVideoUploadDate", getLatestVideoUploadDate());
		attributes.put(
			"latestVideoGenerationDate", getLatestVideoGenerationDate());
		attributes.put("videoSort", getVideoSort());
		attributes.put("USID", getUSID());
		attributes.put("previewVideoId", getPreviewVideoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String longDesc = (String)attributes.get("longDesc");

		if (longDesc != null) {
			setLongDesc(longDesc);
		}

		Long latestOpenAccessVideoId = (Long)attributes.get(
			"latestOpenAccessVideoId");

		if (latestOpenAccessVideoId != null) {
			setLatestOpenAccessVideoId(latestOpenAccessVideoId);
		}

		Date latestVideoUploadDate = (Date)attributes.get(
			"latestVideoUploadDate");

		if (latestVideoUploadDate != null) {
			setLatestVideoUploadDate(latestVideoUploadDate);
		}

		String latestVideoGenerationDate = (String)attributes.get(
			"latestVideoGenerationDate");

		if (latestVideoGenerationDate != null) {
			setLatestVideoGenerationDate(latestVideoGenerationDate);
		}

		Integer videoSort = (Integer)attributes.get("videoSort");

		if (videoSort != null) {
			setVideoSort(videoSort);
		}

		String USID = (String)attributes.get("USID");

		if (USID != null) {
			setUSID(USID);
		}

		Long previewVideoId = (Long)attributes.get("previewVideoId");

		if (previewVideoId != null) {
			setPreviewVideoId(previewVideoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
	 * Returns the approved of this lectureseries.
	 *
	 * @return the approved of this lectureseries
	 */
	@Override
	public int getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the category ID of this lectureseries.
	 *
	 * @return the category ID of this lectureseries
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	@Override
	public String getClosedAccessURI() {
		return model.getClosedAccessURI();
	}

	/**
	 * Returns the company ID of this lectureseries.
	 *
	 * @return the company ID of this lectureseries
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this lectureseries.
	 *
	 * @return the create date of this lectureseries
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event type of this lectureseries.
	 *
	 * @return the event type of this lectureseries
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the faculty name of this lectureseries.
	 *
	 * @return the faculty name of this lectureseries
	 */
	@Override
	public String getFacultyName() {
		return model.getFacultyName();
	}

	/**
	 * Returns the group ID of this lectureseries.
	 *
	 * @return the group ID of this lectureseries
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this lectureseries.
	 *
	 * @return the language of this lectureseries
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the latest open access video ID of this lectureseries.
	 *
	 * @return the latest open access video ID of this lectureseries
	 */
	@Override
	public long getLatestOpenAccessVideoId() {
		return model.getLatestOpenAccessVideoId();
	}

	/**
	 * Returns the latest video generation date of this lectureseries.
	 *
	 * @return the latest video generation date of this lectureseries
	 */
	@Override
	public String getLatestVideoGenerationDate() {
		return model.getLatestVideoGenerationDate();
	}

	/**
	 * Returns the latest video upload date of this lectureseries.
	 *
	 * @return the latest video upload date of this lectureseries
	 */
	@Override
	public Date getLatestVideoUploadDate() {
		return model.getLatestVideoUploadDate();
	}

	/**
	 * Returns the lectureseries ID of this lectureseries.
	 *
	 * @return the lectureseries ID of this lectureseries
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	/**
	 * Returns the long desc of this lectureseries.
	 *
	 * @return the long desc of this lectureseries
	 */
	@Override
	public String getLongDesc() {
		return model.getLongDesc();
	}

	/**
	 * Returns the modified date of this lectureseries.
	 *
	 * @return the modified date of this lectureseries
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this lectureseries.
	 *
	 * @return the name of this lectureseries
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the number of this lectureseries.
	 *
	 * @return the number of this lectureseries
	 */
	@Override
	public String getNumber() {
		return model.getNumber();
	}

	@Override
	public int getNumberOfOpenAccessVideos() {
		return model.getNumberOfOpenAccessVideos();
	}

	@Override
	public int getNumberOfVideos() {
		return model.getNumberOfVideos();
	}

	@Override
	public String getOpenAccessURI() {
		return model.getOpenAccessURI();
	}

	/**
	 * Returns the password of this lectureseries.
	 *
	 * @return the password of this lectureseries
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the preview video ID of this lectureseries.
	 *
	 * @return the preview video ID of this lectureseries
	 */
	@Override
	public long getPreviewVideoId() {
		return model.getPreviewVideoId();
	}

	/**
	 * Returns the primary key of this lectureseries.
	 *
	 * @return the primary key of this lectureseries
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the short desc of this lectureseries.
	 *
	 * @return the short desc of this lectureseries
	 */
	@Override
	public String getShortDesc() {
		return model.getShortDesc();
	}

	/**
	 * Returns the term ID of this lectureseries.
	 *
	 * @return the term ID of this lectureseries
	 */
	@Override
	public long getTermId() {
		return model.getTermId();
	}

	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this lectureseries.
	 *
	 * @return the user ID of this lectureseries
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lectureseries.
	 *
	 * @return the user name of this lectureseries
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lectureseries.
	 *
	 * @return the user uuid of this lectureseries
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the usid of this lectureseries.
	 *
	 * @return the usid of this lectureseries
	 */
	@Override
	public String getUSID() {
		return model.getUSID();
	}

	/**
	 * Returns the video sort of this lectureseries.
	 *
	 * @return the video sort of this lectureseries
	 */
	@Override
	public int getVideoSort() {
		return model.getVideoSort();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the approved of this lectureseries.
	 *
	 * @param approved the approved of this lectureseries
	 */
	@Override
	public void setApproved(int approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the category ID of this lectureseries.
	 *
	 * @param categoryId the category ID of this lectureseries
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this lectureseries.
	 *
	 * @param companyId the company ID of this lectureseries
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lectureseries.
	 *
	 * @param createDate the create date of this lectureseries
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event type of this lectureseries.
	 *
	 * @param eventType the event type of this lectureseries
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the faculty name of this lectureseries.
	 *
	 * @param facultyName the faculty name of this lectureseries
	 */
	@Override
	public void setFacultyName(String facultyName) {
		model.setFacultyName(facultyName);
	}

	/**
	 * Sets the group ID of this lectureseries.
	 *
	 * @param groupId the group ID of this lectureseries
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this lectureseries.
	 *
	 * @param language the language of this lectureseries
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the latest open access video ID of this lectureseries.
	 *
	 * @param latestOpenAccessVideoId the latest open access video ID of this lectureseries
	 */
	@Override
	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		model.setLatestOpenAccessVideoId(latestOpenAccessVideoId);
	}

	/**
	 * Sets the latest video generation date of this lectureseries.
	 *
	 * @param latestVideoGenerationDate the latest video generation date of this lectureseries
	 */
	@Override
	public void setLatestVideoGenerationDate(String latestVideoGenerationDate) {
		model.setLatestVideoGenerationDate(latestVideoGenerationDate);
	}

	/**
	 * Sets the latest video upload date of this lectureseries.
	 *
	 * @param latestVideoUploadDate the latest video upload date of this lectureseries
	 */
	@Override
	public void setLatestVideoUploadDate(Date latestVideoUploadDate) {
		model.setLatestVideoUploadDate(latestVideoUploadDate);
	}

	/**
	 * Sets the lectureseries ID of this lectureseries.
	 *
	 * @param lectureseriesId the lectureseries ID of this lectureseries
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the long desc of this lectureseries.
	 *
	 * @param longDesc the long desc of this lectureseries
	 */
	@Override
	public void setLongDesc(String longDesc) {
		model.setLongDesc(longDesc);
	}

	/**
	 * Sets the modified date of this lectureseries.
	 *
	 * @param modifiedDate the modified date of this lectureseries
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this lectureseries.
	 *
	 * @param name the name of this lectureseries
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the number of this lectureseries.
	 *
	 * @param number the number of this lectureseries
	 */
	@Override
	public void setNumber(String number) {
		model.setNumber(number);
	}

	@Override
	public void setNumberOfOpenAccessVideos(int numberOfOpenAccessVideos) {
		model.setNumberOfOpenAccessVideos(numberOfOpenAccessVideos);
	}

	@Override
	public void setNumberOfVideos(int numberOfVideos) {
		model.setNumberOfVideos(numberOfVideos);
	}

	/**
	 * Sets the password of this lectureseries.
	 *
	 * @param password the password of this lectureseries
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the preview video ID of this lectureseries.
	 *
	 * @param previewVideoId the preview video ID of this lectureseries
	 */
	@Override
	public void setPreviewVideoId(long previewVideoId) {
		model.setPreviewVideoId(previewVideoId);
	}

	/**
	 * Sets the primary key of this lectureseries.
	 *
	 * @param primaryKey the primary key of this lectureseries
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the short desc of this lectureseries.
	 *
	 * @param shortDesc the short desc of this lectureseries
	 */
	@Override
	public void setShortDesc(String shortDesc) {
		model.setShortDesc(shortDesc);
	}

	/**
	 * Sets the term ID of this lectureseries.
	 *
	 * @param termId the term ID of this lectureseries
	 */
	@Override
	public void setTermId(long termId) {
		model.setTermId(termId);
	}

	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this lectureseries.
	 *
	 * @param userId the user ID of this lectureseries
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lectureseries.
	 *
	 * @param userName the user name of this lectureseries
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lectureseries.
	 *
	 * @param userUuid the user uuid of this lectureseries
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the usid of this lectureseries.
	 *
	 * @param USID the usid of this lectureseries
	 */
	@Override
	public void setUSID(String USID) {
		model.setUSID(USID);
	}

	/**
	 * Sets the video sort of this lectureseries.
	 *
	 * @param videoSort the video sort of this lectureseries
	 */
	@Override
	public void setVideoSort(int videoSort) {
		model.setVideoSort(videoSort);
	}

	@Override
	protected LectureseriesWrapper wrap(Lectureseries lectureseries) {
		return new LectureseriesWrapper(lectureseries);
	}

}