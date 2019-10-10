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
 * This class is a wrapper for {@link Videohitlist}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
@ProviderType
public class VideohitlistWrapper
	extends BaseModelWrapper<Videohitlist>
	implements Videohitlist, ModelWrapper<Videohitlist> {

	public VideohitlistWrapper(Videohitlist videohitlist) {
		super(videohitlist);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videohitlistId", getVideohitlistId());
		attributes.put("hitsPerDay", getHitsPerDay());
		attributes.put("hitsPerWeek", getHitsPerWeek());
		attributes.put("hitsPerMonth", getHitsPerMonth());
		attributes.put("hitsPerYear", getHitsPerYear());
		attributes.put("videoId", getVideoId());
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
		Long videohitlistId = (Long)attributes.get("videohitlistId");

		if (videohitlistId != null) {
			setVideohitlistId(videohitlistId);
		}

		Long hitsPerDay = (Long)attributes.get("hitsPerDay");

		if (hitsPerDay != null) {
			setHitsPerDay(hitsPerDay);
		}

		Long hitsPerWeek = (Long)attributes.get("hitsPerWeek");

		if (hitsPerWeek != null) {
			setHitsPerWeek(hitsPerWeek);
		}

		Long hitsPerMonth = (Long)attributes.get("hitsPerMonth");

		if (hitsPerMonth != null) {
			setHitsPerMonth(hitsPerMonth);
		}

		Long hitsPerYear = (Long)attributes.get("hitsPerYear");

		if (hitsPerYear != null) {
			setHitsPerYear(hitsPerYear);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
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
	 * Returns the company ID of this videohitlist.
	 *
	 * @return the company ID of this videohitlist
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this videohitlist.
	 *
	 * @return the create date of this videohitlist
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this videohitlist.
	 *
	 * @return the group ID of this videohitlist
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hits per day of this videohitlist.
	 *
	 * @return the hits per day of this videohitlist
	 */
	@Override
	public long getHitsPerDay() {
		return model.getHitsPerDay();
	}

	/**
	 * Returns the hits per month of this videohitlist.
	 *
	 * @return the hits per month of this videohitlist
	 */
	@Override
	public long getHitsPerMonth() {
		return model.getHitsPerMonth();
	}

	/**
	 * Returns the hits per week of this videohitlist.
	 *
	 * @return the hits per week of this videohitlist
	 */
	@Override
	public long getHitsPerWeek() {
		return model.getHitsPerWeek();
	}

	/**
	 * Returns the hits per year of this videohitlist.
	 *
	 * @return the hits per year of this videohitlist
	 */
	@Override
	public long getHitsPerYear() {
		return model.getHitsPerYear();
	}

	/**
	 * Returns the modified date of this videohitlist.
	 *
	 * @return the modified date of this videohitlist
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this videohitlist.
	 *
	 * @return the primary key of this videohitlist
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this videohitlist.
	 *
	 * @return the user ID of this videohitlist
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this videohitlist.
	 *
	 * @return the user name of this videohitlist
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this videohitlist.
	 *
	 * @return the user uuid of this videohitlist
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the videohitlist ID of this videohitlist.
	 *
	 * @return the videohitlist ID of this videohitlist
	 */
	@Override
	public long getVideohitlistId() {
		return model.getVideohitlistId();
	}

	/**
	 * Returns the video ID of this videohitlist.
	 *
	 * @return the video ID of this videohitlist
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
	 * Sets the company ID of this videohitlist.
	 *
	 * @param companyId the company ID of this videohitlist
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this videohitlist.
	 *
	 * @param createDate the create date of this videohitlist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this videohitlist.
	 *
	 * @param groupId the group ID of this videohitlist
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hits per day of this videohitlist.
	 *
	 * @param hitsPerDay the hits per day of this videohitlist
	 */
	@Override
	public void setHitsPerDay(long hitsPerDay) {
		model.setHitsPerDay(hitsPerDay);
	}

	/**
	 * Sets the hits per month of this videohitlist.
	 *
	 * @param hitsPerMonth the hits per month of this videohitlist
	 */
	@Override
	public void setHitsPerMonth(long hitsPerMonth) {
		model.setHitsPerMonth(hitsPerMonth);
	}

	/**
	 * Sets the hits per week of this videohitlist.
	 *
	 * @param hitsPerWeek the hits per week of this videohitlist
	 */
	@Override
	public void setHitsPerWeek(long hitsPerWeek) {
		model.setHitsPerWeek(hitsPerWeek);
	}

	/**
	 * Sets the hits per year of this videohitlist.
	 *
	 * @param hitsPerYear the hits per year of this videohitlist
	 */
	@Override
	public void setHitsPerYear(long hitsPerYear) {
		model.setHitsPerYear(hitsPerYear);
	}

	/**
	 * Sets the modified date of this videohitlist.
	 *
	 * @param modifiedDate the modified date of this videohitlist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this videohitlist.
	 *
	 * @param primaryKey the primary key of this videohitlist
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this videohitlist.
	 *
	 * @param userId the user ID of this videohitlist
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this videohitlist.
	 *
	 * @param userName the user name of this videohitlist
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this videohitlist.
	 *
	 * @param userUuid the user uuid of this videohitlist
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the videohitlist ID of this videohitlist.
	 *
	 * @param videohitlistId the videohitlist ID of this videohitlist
	 */
	@Override
	public void setVideohitlistId(long videohitlistId) {
		model.setVideohitlistId(videohitlistId);
	}

	/**
	 * Sets the video ID of this videohitlist.
	 *
	 * @param videoId the video ID of this videohitlist
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	protected VideohitlistWrapper wrap(Videohitlist videohitlist) {
		return new VideohitlistWrapper(videohitlist);
	}

}