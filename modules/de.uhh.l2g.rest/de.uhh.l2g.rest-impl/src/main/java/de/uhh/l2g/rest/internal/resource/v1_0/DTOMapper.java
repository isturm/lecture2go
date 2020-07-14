package de.uhh.l2g.rest.internal.resource.v1_0;

import java.util.ArrayList;
import java.util.stream.Collectors;

import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.rest.dto.v1_0.Category;
import de.uhh.l2g.rest.dto.v1_0.Creator;
import de.uhh.l2g.rest.dto.v1_0.Institution;
import de.uhh.l2g.rest.dto.v1_0.Lectureseries;
import de.uhh.l2g.rest.dto.v1_0.License;
import de.uhh.l2g.rest.dto.v1_0.Metadata;
import de.uhh.l2g.rest.dto.v1_0.Term;
import de.uhh.l2g.rest.dto.v1_0.Video;

public class DTOMapper {

	public static Video toVideoDTO(de.uhh.l2g.plugins.model.Video video) {
		return new Video() {
			{
				videoId = video.getVideoId();
				lectureseriesId = video.getLectureseriesId();
				title = video.getTitle();
				url = video.getUrl();
				embedIframe = video.getEmbedIframe();
				duration = video.getDuration();
				generationDate = video.getGenerationDate();
				openAccess = video.getOpenAccess();
				downloadLink = video.getDownloadLink();

				// referenced entities
				ArrayList<Long> emptyList = new ArrayList<Long>();
				ArrayList<Long> videoIds = new ArrayList<Long>();
				videoIds.add(video.getVideoId());

				try {
					metadata = toMetadataDTO(MetadataLocalServiceUtil.getMetadata(video.getMetadataId()));
				} catch (Exception e) {

				}
				creators = CreatorLocalServiceUtil.getCreatorsByVideoId(video.getVideoId()).stream()
						.map(creator -> toCreatorDTO(creator)).collect(Collectors.toList()).toArray(new Creator[0]);

				categories = CategoryLocalServiceUtil.getCategoriesFromLectureseriesIdsAndVideoIds(emptyList, videoIds)
						.stream().map(category -> toCategoryDTO(category)).collect(Collectors.toList())
						.toArray(new Category[0]);

				try {
					term = toTermDTO(TermLocalServiceUtil.getTerm(video.getTermId()));
				} catch (Exception e) {

				}

				institutions = InstitutionLocalServiceUtil
						.getInstitutionsFromLectureseriesIdsAndVideoIds(emptyList, videoIds).stream()
						.map(institution -> toInstitutionDTO(institution)).collect(Collectors.toList())
						.toArray(new Institution[0]);

				try {
					license = toLicenseDTO(LicenseLocalServiceUtil.getLicense(video.getLicenseId()));
				} catch (Exception e) {

				}
			}
		};
	}

	public static Lectureseries toLectureseriesDTO(de.uhh.l2g.plugins.model.Lectureseries lectureseries) {
		return new Lectureseries() {
			{
				lectureseriesId = lectureseries.getLectureseriesId();
				number = lectureseries.getNumber();
				name = lectureseries.getName();
				longDesc = lectureseries.getLongDesc();
				closedAccessURI = lectureseries.getClosedAccessURI();
				openAccessURI = lectureseries.getOpenAccessURI();

				// referenced entities
				ArrayList<Long> emptyList = new ArrayList<Long>();
				ArrayList<Long> lectureseriesIds = new ArrayList<Long>();
				lectureseriesIds.add(lectureseries.getLectureseriesId());

				creators = CreatorLocalServiceUtil.getCreatorsByLectureseriesId(lectureseries.getLectureseriesId())
						.stream().map(creator -> toCreatorDTO(creator)).collect(Collectors.toList())
						.toArray(new Creator[0]);

				categories = CategoryLocalServiceUtil
						.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds, emptyList).stream()
						.map(category -> toCategoryDTO(category)).collect(Collectors.toList()).toArray(new Category[0]);

				try {
					term = toTermDTO(TermLocalServiceUtil.getTerm(lectureseries.getTermId()));
				} catch (Exception e) {

				}

				institutions = InstitutionLocalServiceUtil
						.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, emptyList).stream()
						.map(institution -> toInstitutionDTO(institution)).collect(Collectors.toList())
						.toArray(new Institution[0]);
			}
		};
	}

	public static Metadata toMetadataDTO(de.uhh.l2g.plugins.model.Metadata metadata) {
		return new Metadata() {
			{
				metadataId = metadata.getMetadataId();
				language = metadata.getLanguage();
				subject = metadata.getSubject();
				description = metadata.getDescription();
			}
		};
	}

	public static Creator toCreatorDTO(de.uhh.l2g.plugins.model.Creator creator) {
		return new Creator() {
			{
				creatorId = creator.getCreatorId();
				fullName = creator.getFullName();
			}
		};
	}

	public static Category toCategoryDTO(de.uhh.l2g.plugins.model.Category category) {
		return new Category() {
			{
				categoryName = category.getName();
			}
		};
	}

	public static Term toTermDTO(de.uhh.l2g.plugins.model.Term term) {
		return new Term() {
			{
				termId = term.getTermId();
				termName = term.getTermName();
			}
		};
	}

	public static Institution toInstitutionDTO(de.uhh.l2g.plugins.model.Institution institution) {
		return new Institution() {
			{
				institutionName = institution.getName();
			}
		};
	}

	public static License toLicenseDTO(de.uhh.l2g.plugins.model.License license) {
		return new License() {
			{
				licenseId = license.getLicenseId();
				fullName = license.getFullName();
				shortIdentifier = license.getShortIdentifier();
			}
		};
	}

}
