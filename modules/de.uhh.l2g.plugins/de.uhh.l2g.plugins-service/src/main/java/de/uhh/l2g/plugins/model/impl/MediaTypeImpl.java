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

package de.uhh.l2g.plugins.model.impl;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the MediaType service. Represents a row in the &quot;LG_MediaType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>de.uhh.l2g.plugins.model.MediaType</code> interface.
 * </p>
 *
 * @author Iavor Sturm
 */
@ProviderType
public class MediaTypeImpl extends MediaTypeBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a media type model instance should use the {@link de.uhh.l2g.plugins.model.MediaType} interface instead.
	 */
	public MediaTypeImpl() {
	}

}