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
 * This class is a wrapper for {@link Producer_Lectureseries}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Producer_Lectureseries
 * @generated
 */
@ProviderType
public class Producer_LectureseriesWrapper
	extends BaseModelWrapper<Producer_Lectureseries>
	implements Producer_Lectureseries, ModelWrapper<Producer_Lectureseries> {

	public Producer_LectureseriesWrapper(
		Producer_Lectureseries producer_Lectureseries) {

		super(producer_Lectureseries);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("producerLectureseriesId", getProducerLectureseriesId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long producerLectureseriesId = (Long)attributes.get(
			"producerLectureseriesId");

		if (producerLectureseriesId != null) {
			setProducerLectureseriesId(producerLectureseriesId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}
	}

	/**
	 * Returns the lectureseries ID of this producer_ lectureseries.
	 *
	 * @return the lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	/**
	 * Returns the primary key of this producer_ lectureseries.
	 *
	 * @return the primary key of this producer_ lectureseries
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the producer ID of this producer_ lectureseries.
	 *
	 * @return the producer ID of this producer_ lectureseries
	 */
	@Override
	public long getProducerId() {
		return model.getProducerId();
	}

	/**
	 * Returns the producer lectureseries ID of this producer_ lectureseries.
	 *
	 * @return the producer lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public long getProducerLectureseriesId() {
		return model.getProducerLectureseriesId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the lectureseries ID of this producer_ lectureseries.
	 *
	 * @param lectureseriesId the lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the primary key of this producer_ lectureseries.
	 *
	 * @param primaryKey the primary key of this producer_ lectureseries
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producer ID of this producer_ lectureseries.
	 *
	 * @param producerId the producer ID of this producer_ lectureseries
	 */
	@Override
	public void setProducerId(long producerId) {
		model.setProducerId(producerId);
	}

	/**
	 * Sets the producer lectureseries ID of this producer_ lectureseries.
	 *
	 * @param producerLectureseriesId the producer lectureseries ID of this producer_ lectureseries
	 */
	@Override
	public void setProducerLectureseriesId(long producerLectureseriesId) {
		model.setProducerLectureseriesId(producerLectureseriesId);
	}

	@Override
	protected Producer_LectureseriesWrapper wrap(
		Producer_Lectureseries producer_Lectureseries) {

		return new Producer_LectureseriesWrapper(producer_Lectureseries);
	}

}