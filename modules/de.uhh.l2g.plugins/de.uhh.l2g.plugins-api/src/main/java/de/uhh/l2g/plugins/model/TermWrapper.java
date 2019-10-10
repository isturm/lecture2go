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
 * This class is a wrapper for {@link Term}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Term
 * @generated
 */
@ProviderType
public class TermWrapper
	extends BaseModelWrapper<Term> implements Term, ModelWrapper<Term> {

	public TermWrapper(Term term) {
		super(term);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("prefix", getPrefix());
		attributes.put("year", getYear());
		attributes.put("translation", getTranslation());
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
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String prefix = (String)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
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
	 * Returns the company ID of this term.
	 *
	 * @return the company ID of this term
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this term.
	 *
	 * @return the create date of this term
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this term.
	 *
	 * @return the group ID of this term
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language ID of this term.
	 *
	 * @return the language ID of this term
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the modified date of this term.
	 *
	 * @return the modified date of this term
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parent ID of this term.
	 *
	 * @return the parent ID of this term
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the prefix of this term.
	 *
	 * @return the prefix of this term
	 */
	@Override
	public String getPrefix() {
		return model.getPrefix();
	}

	/**
	 * Returns the primary key of this term.
	 *
	 * @return the primary key of this term
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the term ID of this term.
	 *
	 * @return the term ID of this term
	 */
	@Override
	public long getTermId() {
		return model.getTermId();
	}

	/**
	 * @return the full termName (prefix + year)
	 */
	@Override
	public String getTermName() {
		return model.getTermName();
	}

	/**
	 * Returns the translation of this term.
	 *
	 * @return the translation of this term
	 */
	@Override
	public String getTranslation() {
		return model.getTranslation();
	}

	/**
	 * Returns the user ID of this term.
	 *
	 * @return the user ID of this term
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this term.
	 *
	 * @return the user name of this term
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this term.
	 *
	 * @return the user uuid of this term
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the year of this term.
	 *
	 * @return the year of this term
	 */
	@Override
	public String getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this term.
	 *
	 * @param companyId the company ID of this term
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this term.
	 *
	 * @param createDate the create date of this term
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this term.
	 *
	 * @param groupId the group ID of this term
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language ID of this term.
	 *
	 * @param languageId the language ID of this term
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the modified date of this term.
	 *
	 * @param modifiedDate the modified date of this term
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent ID of this term.
	 *
	 * @param parentId the parent ID of this term
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the prefix of this term.
	 *
	 * @param prefix the prefix of this term
	 */
	@Override
	public void setPrefix(String prefix) {
		model.setPrefix(prefix);
	}

	/**
	 * Sets the primary key of this term.
	 *
	 * @param primaryKey the primary key of this term
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the term ID of this term.
	 *
	 * @param termId the term ID of this term
	 */
	@Override
	public void setTermId(long termId) {
		model.setTermId(termId);
	}

	/**
	 * Sets the translation of this term.
	 *
	 * @param translation the translation of this term
	 */
	@Override
	public void setTranslation(String translation) {
		model.setTranslation(translation);
	}

	/**
	 * Sets the user ID of this term.
	 *
	 * @param userId the user ID of this term
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this term.
	 *
	 * @param userName the user name of this term
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this term.
	 *
	 * @param userUuid the user uuid of this term
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the year of this term.
	 *
	 * @param year the year of this term
	 */
	@Override
	public void setYear(String year) {
		model.setYear(year);
	}

	@Override
	protected TermWrapper wrap(Term term) {
		return new TermWrapper(term);
	}

}