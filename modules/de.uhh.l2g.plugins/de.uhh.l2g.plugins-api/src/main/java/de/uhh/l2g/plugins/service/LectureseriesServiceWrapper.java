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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LectureseriesService}.
 *
 * @author Iavor Sturm
 * @see LectureseriesService
 * @generated
 */
public class LectureseriesServiceWrapper
	implements LectureseriesService, ServiceWrapper<LectureseriesService> {

	public LectureseriesServiceWrapper(
		LectureseriesService lectureseriesService) {

		_lectureseriesService = lectureseriesService;
	}

	@Override
	public de.uhh.l2g.plugins.model.LectureseriesWithVideos
			getLectureSeriesWithVideos(long lectureseriesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lectureseriesService.getLectureSeriesWithVideos(
			lectureseriesId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lectureseriesService.getOSGiServiceIdentifier();
	}

	@Override
	public LectureseriesService getWrappedService() {
		return _lectureseriesService;
	}

	@Override
	public void setWrappedService(LectureseriesService lectureseriesService) {
		_lectureseriesService = lectureseriesService;
	}

	private LectureseriesService _lectureseriesService;

}