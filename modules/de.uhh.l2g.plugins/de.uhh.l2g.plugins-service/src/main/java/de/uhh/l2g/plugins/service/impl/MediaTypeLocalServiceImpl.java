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

package de.uhh.l2g.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import de.uhh.l2g.plugins.model.MediaType;
import de.uhh.l2g.plugins.service.base.MediaTypeLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the media type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>de.uhh.l2g.plugins.service.MediaTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see MediaTypeLocalServiceBaseImpl
 */
public class MediaTypeLocalServiceImpl extends MediaTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>de.uhh.l2g.plugins.service.MediaTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>de.uhh.l2g.plugins.service.MediaTypeLocalServiceUtil</code>.
	 */

	@Override
	public List<MediaType> getMediaTypesFromVideoIds(ArrayList<Long> videoIds) {
		ArrayList<MediaType> mediaTypes = new ArrayList<>();

		videoIds.forEach(videoId -> {
			video_MediaTypeLocalService.getByVideo(videoId).forEach(videoMediaType -> {
				try {
					MediaType mediaType = mediaTypeLocalService.getMediaType(videoMediaType.getMediaTypeId());
					if (!mediaTypes.contains(mediaType)) {
						mediaTypes.add(mediaType);
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
			});
		});

		return mediaTypes;
	}

}