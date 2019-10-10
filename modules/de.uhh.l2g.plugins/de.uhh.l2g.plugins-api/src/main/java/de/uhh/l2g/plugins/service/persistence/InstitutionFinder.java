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

package de.uhh.l2g.plugins.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public interface InstitutionFinder {

	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		findRootInstitutionsByOpenAccessVideos();

	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		findByLectureseriesId(long lectureseriesId, int begin, int end);

	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		findAllSortedAsTree(int begin, int end);

	public int findMaxSortByParent(long parentId);

	public int findLockingElements(long institutionId);

	public java.util.List<de.uhh.l2g.plugins.model.Institution>
		findInstitutionsByLectureseriesIdsAndVideoIds(
			java.util.ArrayList<Long> lectureseriesIds,
			java.util.ArrayList<Long> videoIds, Long parentId);

}