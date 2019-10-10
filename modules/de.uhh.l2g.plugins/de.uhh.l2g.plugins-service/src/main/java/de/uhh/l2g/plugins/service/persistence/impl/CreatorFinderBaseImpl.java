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

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.persistence.CreatorPersistence;

/**
 * @author Iavor Sturm
 * @generated
 */
public class CreatorFinderBaseImpl extends BasePersistenceImpl<Creator> {

	public CreatorFinderBaseImpl() {
		setModelClass(Creator.class);
	}

	/**
	 * Returns the creator persistence.
	 *
	 * @return the creator persistence
	 */
	public CreatorPersistence getCreatorPersistence() {
		return creatorPersistence;
	}

	/**
	 * Sets the creator persistence.
	 *
	 * @param creatorPersistence the creator persistence
	 */
	public void setCreatorPersistence(CreatorPersistence creatorPersistence) {
		this.creatorPersistence = creatorPersistence;
	}

	@BeanReference(type = CreatorPersistence.class)
	protected CreatorPersistence creatorPersistence;

}