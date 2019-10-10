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
 * This class is a wrapper for {@link Lectureseries_Category}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Category
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryWrapper
	extends BaseModelWrapper<Lectureseries_Category>
	implements Lectureseries_Category, ModelWrapper<Lectureseries_Category> {

	public Lectureseries_CategoryWrapper(
		Lectureseries_Category lectureseries_Category) {

		super(lectureseries_Category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lectureseriesCategoryId", getLectureseriesCategoryId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("lectureseriesId", getLectureseriesId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesCategoryId = (Long)attributes.get(
			"lectureseriesCategoryId");

		if (lectureseriesCategoryId != null) {
			setLectureseriesCategoryId(lectureseriesCategoryId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}
	}

	/**
	 * Returns the category ID of this lectureseries_ category.
	 *
	 * @return the category ID of this lectureseries_ category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the lectureseries category ID of this lectureseries_ category.
	 *
	 * @return the lectureseries category ID of this lectureseries_ category
	 */
	@Override
	public long getLectureseriesCategoryId() {
		return model.getLectureseriesCategoryId();
	}

	/**
	 * Returns the lectureseries ID of this lectureseries_ category.
	 *
	 * @return the lectureseries ID of this lectureseries_ category
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	/**
	 * Returns the primary key of this lectureseries_ category.
	 *
	 * @return the primary key of this lectureseries_ category
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
	 * Sets the category ID of this lectureseries_ category.
	 *
	 * @param categoryId the category ID of this lectureseries_ category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the lectureseries category ID of this lectureseries_ category.
	 *
	 * @param lectureseriesCategoryId the lectureseries category ID of this lectureseries_ category
	 */
	@Override
	public void setLectureseriesCategoryId(long lectureseriesCategoryId) {
		model.setLectureseriesCategoryId(lectureseriesCategoryId);
	}

	/**
	 * Sets the lectureseries ID of this lectureseries_ category.
	 *
	 * @param lectureseriesId the lectureseries ID of this lectureseries_ category
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the primary key of this lectureseries_ category.
	 *
	 * @param primaryKey the primary key of this lectureseries_ category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected Lectureseries_CategoryWrapper wrap(
		Lectureseries_Category lectureseries_Category) {

		return new Lectureseries_CategoryWrapper(lectureseries_Category);
	}

}