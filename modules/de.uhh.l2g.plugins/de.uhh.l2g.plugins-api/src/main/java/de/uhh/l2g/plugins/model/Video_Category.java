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
 * The extended model interface for the Video_Category service. Represents a row in the &quot;LG_Video_Category&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see Video_CategoryModel
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.Video_CategoryImpl")
@ProviderType
public interface Video_Category extends PersistedModel, Video_CategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>de.uhh.l2g.plugins.model.impl.Video_CategoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Video_Category, Long>
		VIDEO_CATEGORY_ID_ACCESSOR = new Accessor<Video_Category, Long>() {

			@Override
			public Long get(Video_Category video_Category) {
				return video_Category.getVideoCategoryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Video_Category> getTypeClass() {
				return Video_Category.class;
			}

		};

}