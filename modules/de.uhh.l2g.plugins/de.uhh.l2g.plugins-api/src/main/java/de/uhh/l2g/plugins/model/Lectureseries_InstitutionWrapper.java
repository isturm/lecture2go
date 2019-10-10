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
 * This class is a wrapper for {@link Lectureseries_Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_Institution
 * @generated
 */
@ProviderType
public class Lectureseries_InstitutionWrapper
	extends BaseModelWrapper<Lectureseries_Institution>
	implements Lectureseries_Institution,
			   ModelWrapper<Lectureseries_Institution> {

	public Lectureseries_InstitutionWrapper(
		Lectureseries_Institution lectureseries_Institution) {

		super(lectureseries_Institution);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"lectureseriesInstitutionId", getLectureseriesInstitutionId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("institutionId", getInstitutionId());
		attributes.put("institutionParentId", getInstitutionParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lectureseriesInstitutionId = (Long)attributes.get(
			"lectureseriesInstitutionId");

		if (lectureseriesInstitutionId != null) {
			setLectureseriesInstitutionId(lectureseriesInstitutionId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long institutionParentId = (Long)attributes.get("institutionParentId");

		if (institutionParentId != null) {
			setInstitutionParentId(institutionParentId);
		}
	}

	/**
	 * Returns the institution ID of this lectureseries_ institution.
	 *
	 * @return the institution ID of this lectureseries_ institution
	 */
	@Override
	public long getInstitutionId() {
		return model.getInstitutionId();
	}

	/**
	 * Returns the institution parent ID of this lectureseries_ institution.
	 *
	 * @return the institution parent ID of this lectureseries_ institution
	 */
	@Override
	public long getInstitutionParentId() {
		return model.getInstitutionParentId();
	}

	/**
	 * Returns the lectureseries ID of this lectureseries_ institution.
	 *
	 * @return the lectureseries ID of this lectureseries_ institution
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	/**
	 * Returns the lectureseries institution ID of this lectureseries_ institution.
	 *
	 * @return the lectureseries institution ID of this lectureseries_ institution
	 */
	@Override
	public long getLectureseriesInstitutionId() {
		return model.getLectureseriesInstitutionId();
	}

	/**
	 * Returns the primary key of this lectureseries_ institution.
	 *
	 * @return the primary key of this lectureseries_ institution
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
	 * Sets the institution ID of this lectureseries_ institution.
	 *
	 * @param institutionId the institution ID of this lectureseries_ institution
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		model.setInstitutionId(institutionId);
	}

	/**
	 * Sets the institution parent ID of this lectureseries_ institution.
	 *
	 * @param institutionParentId the institution parent ID of this lectureseries_ institution
	 */
	@Override
	public void setInstitutionParentId(long institutionParentId) {
		model.setInstitutionParentId(institutionParentId);
	}

	/**
	 * Sets the lectureseries ID of this lectureseries_ institution.
	 *
	 * @param lectureseriesId the lectureseries ID of this lectureseries_ institution
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	/**
	 * Sets the lectureseries institution ID of this lectureseries_ institution.
	 *
	 * @param lectureseriesInstitutionId the lectureseries institution ID of this lectureseries_ institution
	 */
	@Override
	public void setLectureseriesInstitutionId(long lectureseriesInstitutionId) {
		model.setLectureseriesInstitutionId(lectureseriesInstitutionId);
	}

	/**
	 * Sets the primary key of this lectureseries_ institution.
	 *
	 * @param primaryKey the primary key of this lectureseries_ institution
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected Lectureseries_InstitutionWrapper wrap(
		Lectureseries_Institution lectureseries_Institution) {

		return new Lectureseries_InstitutionWrapper(lectureseries_Institution);
	}

}