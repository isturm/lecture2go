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
 * This class is a wrapper for {@link Lectureseries_Creator}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Creator
 * @generated
 */
@ProviderType
public class Lectureseries_CreatorWrapper
	extends BaseModelWrapper<Lectureseries_Creator>
	implements Lectureseries_Creator, ModelWrapper<Lectureseries_Creator> {

	public Lectureseries_CreatorWrapper(
		Lectureseries_Creator lectureseries_Creator) {

		super(lectureseries_Creator);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCreatorId", getLectureseriesCreatorId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("creatorId", getCreatorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCreatorId = (Long)attributes.get(
			"lectureseriesCreatorId");

		if (lectureseriesCreatorId != null) {
			setLectureseriesCreatorId(lectureseriesCreatorId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}
	}

	/**
	 * Returns the creator ID of this lectureseries_ creator.
	 *
	 * @return the creator ID of this lectureseries_ creator
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the lectureseries creator ID of this lectureseries_ creator.
	 *
	 * @return the lectureseries creator ID of this lectureseries_ creator
	 */
	@Override
	public long getLectureseriesCreatorId() {
		return model.getLectureseriesCreatorId();
	}

	/**
	 * Returns the lectureseries ID of this lectureseries_ creator.
	 *
	 * @return the lectureseries ID of this lectureseries_ creator
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	/**
	 * Returns the primary key of this lectureseries_ creator.
	 *
	 * @return the primary key of this lectureseries_ creator
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
	 * Sets the creator ID of this lectureseries_ creator.
	 *
	 * @param creatorId the creator ID of this lectureseries_ creator
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the lectureseries creator ID of this lectureseries_ creator.
	 *
	 * @param lectureseriesCreatorId the lectureseries creator ID of this lectureseries_ creator
	 */
	@Override
	public void setLectureseriesCreatorId(long lectureseriesCreatorId) {
		model.setLectureseriesCreatorId(lectureseriesCreatorId);
	}

	/**
	 * Sets the lectureseries ID of this lectureseries_ creator.
	 *
	 * @param lectureseriesId the lectureseries ID of this lectureseries_ creator
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the primary key of this lectureseries_ creator.
	 *
	 * @param primaryKey the primary key of this lectureseries_ creator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected Lectureseries_CreatorWrapper wrap(
		Lectureseries_Creator lectureseries_Creator) {

		return new Lectureseries_CreatorWrapper(lectureseries_Creator);
	}

}