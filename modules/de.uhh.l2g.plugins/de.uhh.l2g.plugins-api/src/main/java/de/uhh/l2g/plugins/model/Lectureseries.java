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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Lectureseries service. Represents a row in the &quot;LG_Lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see LectureseriesModel
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.LectureseriesImpl")
@ProviderType
public interface Lectureseries extends LectureseriesModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>de.uhh.l2g.plugins.model.impl.LectureseriesImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Lectureseries, Long>
		LECTURESERIES_ID_ACCESSOR = new Accessor<Lectureseries, Long>() {

			@Override
			public Long get(Lectureseries lectureseries) {
				return lectureseries.getLectureseriesId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Lectureseries> getTypeClass() {
				return Lectureseries.class;
			}

		};

	public int getNumberOfVideos();

	public int getNumberOfOpenAccessVideos();

	public String getType();

	public void setType(String type);

	public String getClosedAccessURI();

	public String getOpenAccessURI();

	public void setNumberOfVideos(int numberOfVideos);

	public void setNumberOfOpenAccessVideos(int numberOfOpenAccessVideos);

}