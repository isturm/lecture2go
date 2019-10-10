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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the VideoStatistic service. Represents a row in the &quot;LG_VideoStatistic&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see VideoStatisticModel
 * @see de.uhh.l2g.plugins.model.impl.VideoStatisticImpl
 * @see de.uhh.l2g.plugins.model.impl.VideoStatisticModelImpl
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.VideoStatisticImpl")
@ProviderType
public interface VideoStatistic extends VideoStatisticModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.VideoStatisticImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<VideoStatistic, Long> VIDEO_STATISTIC_ID_ACCESSOR =
		new Accessor<VideoStatistic, Long>() {
			@Override
			public Long get(VideoStatistic videoStatistic) {
				return videoStatistic.getVideoStatisticId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<VideoStatistic> getTypeClass() {
				return VideoStatistic.class;
			}
		};
}