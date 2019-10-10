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
public interface LectureseriesFinder {

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findAllLectureseriesWhithPassword();

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findAllLectureseriesForVideo(de.uhh.l2g.plugins.model.Video video);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findAllLectureseriesWhithOpenaccessVideos();

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries> findLatest(
		int limit, Long groupId, Long companyId);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
			Long institutionId, Long parentInstitutionId, Long termId,
			Long categoryId, Long creatorId, String searchQuery, Long groupId,
			Long companyId);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(
			Long institutionId, Long parentInstitutionId, Long termId,
			Long categoryId, Long creatorId, String searchQuery, int limit,
			Long groupId, Long companyId);

	public java.util.List<de.uhh.l2g.plugins.model.Lectureseries>
		findFilteredByApprovedSemesterFacultyProducer(
			Integer approved, Long termId, Long facultyId, Long producerId,
			Long groupId, Long companyId);

}