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
 * This class is a wrapper for {@link Institution}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Institution
 * @generated
 */
@ProviderType
public class InstitutionWrapper
	extends BaseModelWrapper<Institution>
	implements Institution, ModelWrapper<Institution> {

	public InstitutionWrapper(Institution institution) {
		super(institution);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("institutionId", getInstitutionId());
		attributes.put("parentId", getParentId());
		attributes.put("name", getName());
		attributes.put("typ", getTyp());
		attributes.put("www", getWww());
		attributes.put("level", getLevel());
		attributes.put("sort", getSort());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this institution.
	 *
	 * @return the company ID of this institution
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this institution.
	 *
	 * @return the group ID of this institution
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution ID of this institution.
	 *
	 * @return the institution ID of this institution
	 */
	@Override
	public long getInstitutionId() {
		return model.getInstitutionId();
	}

	/**
	 * Returns the level of this institution.
	 *
	 * @return the level of this institution
	 */
	@Override
	public int getLevel() {
		return model.getLevel();
	}

	/**
	 * Returns the name of this institution.
	 *
	 * @return the name of this institution
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this institution.
	 *
	 * @return the parent ID of this institution
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the primary key of this institution.
	 *
	 * @return the primary key of this institution
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sort of this institution.
	 *
	 * @return the sort of this institution
	 */
	@Override
	public int getSort() {
		return model.getSort();
	}

	/**
	 * Returns the typ of this institution.
	 *
	 * @return the typ of this institution
	 */
	@Override
	public String getTyp() {
		return model.getTyp();
	}

	/**
	 * Returns the www of this institution.
	 *
	 * @return the www of this institution
	 */
	@Override
	public String getWww() {
		return model.getWww();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this institution.
	 *
	 * @param companyId the company ID of this institution
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this institution.
	 *
	 * @param groupId the group ID of this institution
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution ID of this institution.
	 *
	 * @param institutionId the institution ID of this institution
	 */
	@Override
	public void setInstitutionId(long institutionId) {
		model.setInstitutionId(institutionId);
	}

	/**
	 * Sets the level of this institution.
	 *
	 * @param level the level of this institution
	 */
	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	/**
	 * Sets the name of this institution.
	 *
	 * @param name the name of this institution
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this institution.
	 *
	 * @param parentId the parent ID of this institution
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the primary key of this institution.
	 *
	 * @param primaryKey the primary key of this institution
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sort of this institution.
	 *
	 * @param sort the sort of this institution
	 */
	@Override
	public void setSort(int sort) {
		model.setSort(sort);
	}

	/**
	 * Sets the typ of this institution.
	 *
	 * @param typ the typ of this institution
	 */
	@Override
	public void setTyp(String typ) {
		model.setTyp(typ);
	}

	/**
	 * Sets the www of this institution.
	 *
	 * @param www the www of this institution
	 */
	@Override
	public void setWww(String www) {
		model.setWww(www);
	}

	@Override
	protected InstitutionWrapper wrap(Institution institution) {
		return new InstitutionWrapper(institution);
	}

}