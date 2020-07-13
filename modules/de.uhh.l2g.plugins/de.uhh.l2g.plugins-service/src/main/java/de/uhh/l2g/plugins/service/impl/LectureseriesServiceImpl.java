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

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.service.base.LectureseriesServiceBaseImpl;

/**
 * The implementation of the lectureseries remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>de.uhh.l2g.plugins.service.LectureseriesService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Iavor Sturm
 * @see LectureseriesServiceBaseImpl
 */
public class LectureseriesServiceImpl extends LectureseriesServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>de.uhh.l2g.plugins.service.VideoServiceUtil</code> to access the video
	 * remote service.
	 */

	public Lectureseries getLectureSeries(long lectureseriesId) throws PortalException {
		Lectureseries lectureSeries = lectureseriesLocalService.getLectureseries(lectureseriesId);
		return lectureSeries;
	}

}