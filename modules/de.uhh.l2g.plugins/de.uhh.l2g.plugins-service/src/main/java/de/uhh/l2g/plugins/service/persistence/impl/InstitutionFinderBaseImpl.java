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

package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.persistence.InstitutionPersistence;

/**
 * @author Iavor Sturm
 * @generated
 */
public class InstitutionFinderBaseImpl
	extends BasePersistenceImpl<Institution> {

	public InstitutionFinderBaseImpl() {
		setModelClass(Institution.class);
	}

	/**
	 * Returns the institution persistence.
	 *
	 * @return the institution persistence
	 */
	public InstitutionPersistence getInstitutionPersistence() {
		return institutionPersistence;
	}

	/**
	 * Sets the institution persistence.
	 *
	 * @param institutionPersistence the institution persistence
	 */
	public void setInstitutionPersistence(
		InstitutionPersistence institutionPersistence) {

		this.institutionPersistence = institutionPersistence;
	}

	@BeanReference(type = InstitutionPersistence.class)
	protected InstitutionPersistence institutionPersistence;

}