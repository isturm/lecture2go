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

import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.service.persistence.StatisticPersistence;

/**
 * @author Iavor Sturm
 * @generated
 */
public class StatisticFinderBaseImpl extends BasePersistenceImpl<Statistic> {

	public StatisticFinderBaseImpl() {
		setModelClass(Statistic.class);
	}

	/**
	 * Returns the statistic persistence.
	 *
	 * @return the statistic persistence
	 */
	public StatisticPersistence getStatisticPersistence() {
		return statisticPersistence;
	}

	/**
	 * Sets the statistic persistence.
	 *
	 * @param statisticPersistence the statistic persistence
	 */
	public void setStatisticPersistence(
		StatisticPersistence statisticPersistence) {

		this.statisticPersistence = statisticPersistence;
	}

	@BeanReference(type = StatisticPersistence.class)
	protected StatisticPersistence statisticPersistence;

}