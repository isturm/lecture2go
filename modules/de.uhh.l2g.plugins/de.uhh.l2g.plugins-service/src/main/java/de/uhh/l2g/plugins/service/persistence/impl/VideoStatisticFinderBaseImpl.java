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

import de.uhh.l2g.plugins.model.VideoStatistic;
import de.uhh.l2g.plugins.service.persistence.VideoStatisticPersistence;

/**
 * @author Iavor Sturm
 * @generated
 */
public class VideoStatisticFinderBaseImpl extends BasePersistenceImpl<VideoStatistic> {
	public VideoStatisticFinderBaseImpl() {
		setModelClass(VideoStatistic.class);
	}

	/**
	 * Returns the video statistic persistence.
	 *
	 * @return the video statistic persistence
	 */
	public VideoStatisticPersistence getVideoStatisticPersistence() {
		return videoStatisticPersistence;
	}

	/**
	 * Sets the video statistic persistence.
	 *
	 * @param videoStatisticPersistence the video statistic persistence
	 */
	public void setVideoStatisticPersistence(
		VideoStatisticPersistence videoStatisticPersistence) {
		this.videoStatisticPersistence = videoStatisticPersistence;
	}

	@BeanReference(type = VideoStatisticPersistence.class)
	protected VideoStatisticPersistence videoStatisticPersistence;
}