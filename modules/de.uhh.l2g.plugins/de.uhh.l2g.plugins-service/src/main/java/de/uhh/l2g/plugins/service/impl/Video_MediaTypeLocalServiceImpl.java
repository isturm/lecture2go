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

import com.liferay.portal.kernel.exception.SystemException;
import de.uhh.l2g.plugins.model.Video_MediaType;
import de.uhh.l2g.plugins.service.base.Video_MediaTypeLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the video_ media type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>de.uhh.l2g.plugins.service.Video_MediaTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_MediaTypeLocalServiceBaseImpl
 */
public class Video_MediaTypeLocalServiceImpl
	extends Video_MediaTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>de.uhh.l2g.plugins.service.Video_MediaTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>de.uhh.l2g.plugins.service.Video_MediaTypeLocalServiceUtil</code>.
	 */

	public List<Video_MediaType> getByVideo(Long videoId){
		List<Video_MediaType> vmt = new ArrayList<Video_MediaType>();
		try {
			vmt = video_MediaTypePersistence.findByVideo(videoId);
		} catch (SystemException ignored) {}
		return vmt;
	}
}