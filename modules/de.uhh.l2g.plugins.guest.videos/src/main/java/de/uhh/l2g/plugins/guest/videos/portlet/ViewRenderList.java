package de.uhh.l2g.plugins.guest.videos.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.MediaType;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.VideoListSearchResult;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.MediaTypeLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.util.EncodingUtil;
import de.uhh.l2g.plugins.util.SearchManager;
import de.uhh.l2g.plugins.util.SearchManager.SearchType;

@Component(immediate = true, property = { "javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS,
		"mvc.command.name=/view/render/list", "mvc.command.name=/" }, service = MVCRenderCommand.class)
public class ViewRenderList implements MVCRenderCommand {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);
	private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ+";

	@Reference
	protected SearchManager searchManager;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long parentInstitutionId = ParamUtil.getLong(renderRequest, "parentInstitutionId");
		Long institutionId = ParamUtil.getLong(renderRequest, "institutionId", 0);
		Long termId = ParamUtil.getLong(renderRequest, "termId", 0);
		Long categoryId = ParamUtil.getLong(renderRequest, "categoryId", 0);
		Long creatorId = ParamUtil.getLong(renderRequest, "creatorId", 0);
		long mediaTypeId = ParamUtil.getLong(renderRequest, "mediaTypeId", 0);
		Integer searchTypeCode = ParamUtil.getInteger(renderRequest, "searchType", 0);
		SearchType searchType = SearchType.fromCode(searchTypeCode);
		String findVideos = ParamUtil.getString(renderRequest, "findVideos", "");
		String tag = ParamUtil.getString(renderRequest, "tag", "0");
		String sortBy = ParamUtil.getString(renderRequest, "sortBy", "");
		int maxTerms = 4;
		boolean hasInstitutionFiltered = (institutionId != 0);
		boolean hasParentInstitutionFiltered = (parentInstitutionId != 0);
		boolean hasTermFiltered = (termId != 0);
		boolean hasCreatorFiltered = (creatorId != 0);
		boolean hasCategoryFiltered = (categoryId != 0);
		boolean hasMediaTypeFiltered = (mediaTypeId != 0);
		boolean hasTagFiltered = (!tag.equals("0"));
		boolean isSearched = (findVideos.trim().length() > 0);
		//
		long companyId = PortalUtil.getCompanyId(renderRequest);
		long groupId = new Long(0);

		// the institution is dependent on the parentinstitution, do not allow
		// institution-filters without parentinstitution-filter
		if (hasInstitutionFiltered && !hasParentInstitutionFiltered) {
			institutionId = new Long(0);
		}
		List<VideoListSearchResult> videoList = new ArrayList<VideoListSearchResult>();
		Map<String, Object> filters = new HashMap<String, Object>();

		if (hasInstitutionFiltered) {
			filters.put("institutionId", institutionId);
		}
		if (hasParentInstitutionFiltered) {
			filters.put("institutionParentId", parentInstitutionId);
		}
		if (hasTermFiltered) {
			filters.put("termId", termId);
		}
		if (hasCreatorFiltered) {
			filters.put("creatorId", creatorId);
		}
		if (hasCategoryFiltered) {
			filters.put("categoryId", categoryId);
		}
		if (hasMediaTypeFiltered) {
			filters.put("mediaTypeId", mediaTypeId);
		}
		if (hasTagFiltered) {
			filters.put("encodedTags", EncodingUtil.encodeString(tag));
		}

		try {
			videoList = searchManager.searchVideoList(companyId, searchType, findVideos, filters, -1, sortBy);
		} catch (SearchException | ParseException e) {
			// TODO handle exception
		}
		// differentiate returned lectureseries in real lectureseries and fake video
		// lectureseries
		ArrayList<Long> lectureseriesIds = new ArrayList<Long>();
		ArrayList<Long> videoIds = new ArrayList<Long>();
		for (VideoListSearchResult searchResult : videoList) {
			if (searchResult.getVideoId() < 0) {
				lectureseriesIds.add(searchResult.getLectureseriesId());
			} else {
				videoIds.add(searchResult.getVideoId());
			}
		}
		//
		// get the institutions, parentinstitutuons, terms, categories and creators
		// which are part of the dataset. those are displayed so the user can do further
		// filtering
		List<Institution> presentParentInstitutions = new ArrayList<>();
		List<Institution> presentInstitutions = new ArrayList<>();
		List<Term> presentTerms = new ArrayList<>();
		List<Category> presentCategories = new ArrayList<>();
		Set<MediaType> presentMediaTypes;

		// if a filter is selected, only show the selected one else show all
		if (hasParentInstitutionFiltered) {
			presentParentInstitutions.add(InstitutionLocalServiceUtil.getById(parentInstitutionId));
		} else {
			presentParentInstitutions = InstitutionLocalServiceUtil
					.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		}

		if (hasParentInstitutionFiltered && hasInstitutionFiltered) {
			presentInstitutions.add(InstitutionLocalServiceUtil.getById(institutionId));
		} else {
			presentInstitutions = InstitutionLocalServiceUtil
					.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentInstitutionId);
		}

		if (hasTermFiltered) {
			try {
				presentTerms.add(TermLocalServiceUtil.getById(termId));
			} catch (Exception e) {
				_log.error("can't add term id" + termId);
			}
		} else {
			presentTerms = TermLocalServiceUtil.getTermsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		}

		/*
		 * FILTER BY MEDIA TYPE
		 */
		presentMediaTypes = filterByMediaTypes(hasMediaTypeFiltered, mediaTypeId, videoIds, lectureseriesIds);

		/*
		 * FILTER BY TAGS
		 */
		Map<Character, Set<String>> tagsSplitAlphabetically = splitTagsAlphabetically(
				filterByTags(hasTagFiltered, tag, videoIds, lectureseriesIds));
		Set<String> presentTags = filterByTags(hasTagFiltered, tag, videoIds, lectureseriesIds);

		/*
		 * FILTER BY CREATOR
		 */
		Map<Character, List<Creator>> creatorsSplitAlphabetically = splitCreatorsAlphabetically(
				filterCreators(hasCreatorFiltered, creatorId, lectureseriesIds, videoIds));

		/*
		 * FILTER BY CATEGORY
		 */
		if (hasCategoryFiltered) {
			try {
				presentCategories.add(CategoryLocalServiceUtil.getById(categoryId));
			} catch (Exception e) {
				_log.error("can't add category with id" + categoryId);
			}
		} else {
			presentCategories = CategoryLocalServiceUtil.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds,
					videoIds);
		}
		//
		PortletURL portletURL = renderResponse.createRenderURL();
		// set parameter for search iterator or possible backURL
		portletURL.setParameter("parentInstitutionId", parentInstitutionId.toString());
		portletURL.setParameter("institutionId", institutionId.toString());
		portletURL.setParameter("termId", termId.toString());
		portletURL.setParameter("categoryId", categoryId.toString());
		portletURL.setParameter("creatorId", creatorId.toString());
		portletURL.setParameter("mediaTypeId", String.valueOf(mediaTypeId));
		portletURL.setParameter("tag", tag);
		portletURL.setParameter("searchType", searchTypeCode.toString());
		portletURL.setParameter("findVideos", findVideos);
		//
		boolean resultSetEmpty = true;
		if (presentParentInstitutions.size() > 0 || presentInstitutions.size() > 0 || presentTerms.size() > 0
				|| presentCategories.size() > 0 || presentMediaTypes.size() > 0) {
			resultSetEmpty = false;
		}
		//
		Institution insti = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if (institutionId > 0)
				insti = InstitutionLocalServiceUtil.getById(institutionId);
		} catch (Exception e) {
			_log.error("can't get insti bei id");
		}
		//
		Institution pInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if (parentInstitutionId > 0)
				pInst = InstitutionLocalServiceUtil.getById(parentInstitutionId);
		} catch (Exception e) {
			_log.error("can't get pInst bei id");
		}
		//
		Institution rInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			rInst = InstitutionLocalServiceUtil.getRootByParentAndCompanyAndGroup(0, companyId, groupId);
		} catch (Exception e) {
			_log.error("can't get rInst bei company and group id");
		}
		//
		renderRequest.setAttribute("parentInstitutionId", parentInstitutionId);
		renderRequest.setAttribute("institutionId", institutionId);
		renderRequest.setAttribute("termId", termId);
		renderRequest.setAttribute("categoryId", categoryId);
		renderRequest.setAttribute("creatorId", creatorId);
		renderRequest.setAttribute("tag", tag);
		renderRequest.setAttribute("mediaTypeId", mediaTypeId);
		renderRequest.setAttribute("searchType", searchTypeCode);
		renderRequest.setAttribute("findVideos", findVideos);
		renderRequest.setAttribute("sortBy", sortBy);
		renderRequest.setAttribute("sortableFields", Arrays.asList("name", "latestVideoGenerationDate"));
		renderRequest.setAttribute("maxTerms", maxTerms);
		renderRequest.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
		renderRequest.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
		renderRequest.setAttribute("hasTermFiltered", hasTermFiltered);
		renderRequest.setAttribute("hasCreatorFiltered", hasCreatorFiltered);
		renderRequest.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
		renderRequest.setAttribute("hasMediaTypeFiltered", hasMediaTypeFiltered);
		renderRequest.setAttribute("hasTagFiltered", hasTagFiltered);
		renderRequest.setAttribute("isSearched", isSearched);
		renderRequest.setAttribute("videoList", videoList);
		renderRequest.setAttribute("lectureseriesIds", lectureseriesIds);
		renderRequest.setAttribute("videoIds", videoIds);
		renderRequest.setAttribute("presentParentInstitutions", presentParentInstitutions);
		renderRequest.setAttribute("presentInstitutions", presentInstitutions);
		renderRequest.setAttribute("presentTerms", presentTerms);
		renderRequest.setAttribute("creatorsSplitAlphabetically", creatorsSplitAlphabetically);
		renderRequest.setAttribute("tagsSplitAlphabetically", tagsSplitAlphabetically);
		renderRequest.setAttribute("presentCategories", presentCategories);
		renderRequest.setAttribute("presentMediaTypes", presentMediaTypes);
		renderRequest.setAttribute("presentTags", presentTags);
		renderRequest.setAttribute("portletURL", portletURL);
		renderRequest.setAttribute("resultSetEmpty", resultSetEmpty);
		//
		renderRequest.setAttribute("insti", insti);
		renderRequest.setAttribute("pInst", pInst);
		renderRequest.setAttribute("rInst", rInst);
		//

		return "/viewList.jsp";
	}

	/**
	 *
	 * @param hasTagFiltered
	 * @param tag
	 * @param videoIds
	 * @param lectureseriesIds
	 * @return
	 */
	private Set<String> filterByTags(boolean hasTagFiltered, String tag, List<Long> videoIds,
			List<Long> lectureseriesIds) {
		Set<String> tags = new TreeSet<>();

		if (hasTagFiltered) {
			tags.add(tag);
		} else {
			videoIds.forEach(videoId -> {
				try {
					tags.addAll(Arrays.asList(getTagsForString(VideoLocalServiceUtil.getVideo(videoId).getTags())));
				} catch (PortalException portalException) {
					portalException.printStackTrace();
				}
			});

			lectureseriesIds.forEach(lectureseriesId -> {
				VideoLocalServiceUtil.getByLectureseries(lectureseriesId).forEach(video -> {
					tags.addAll(Arrays.asList(getTagsForString(video.getTags())));
				});
			});
		}

		return tags;
	}

	/**
	 * Takes a flat list of tags and sorts it to an alphabetical map
	 *
	 * @param tagList {Apple; Bee; Anaconda; ...}
	 * @return A={Anaconda; Apple; ...}, B={Bee; ...}
	 */
	private Map<Character, Set<String>> splitTagsAlphabetically(Set<String> tagList) {
		Map<Character, Set<String>> presentTagsAlphabetMap = new HashMap<>();

		for (int i = 0; i < alphabet.length(); i++) {
			presentTagsAlphabetMap.put(alphabet.charAt(i), new TreeSet<>());
		}

		tagList.forEach(tag -> {
			if (!tag.trim().isEmpty()) {
				char firstChar = mapSpecialCharacters(tag);

				Set<String> tagsForChar = presentTagsAlphabetMap.get(firstChar);

				if (tagsForChar != null) {
					tagsForChar.add(tag.trim());
				} else {
					presentTagsAlphabetMap.get('+').add(tag.trim());
				}
			}
		});

		return presentTagsAlphabetMap;
	}

	/**
	 *
	 * @param string
	 * @return
	 */
	private char mapSpecialCharacters(String string) {
		char firstChar = string.trim().toUpperCase().charAt(0);

		// Umlauts/accents are mapped to "base" character
		if (firstChar == 'Š' || firstChar == 'Ş')
			firstChar = 'S';
		if (firstChar == 'Ö')
			firstChar = 'O';
		if (firstChar == 'Ü')
			firstChar = 'U';
		if (firstChar == 'Ä')
			firstChar = 'A';
		if (firstChar == 'İ')
			firstChar = 'I';

		return firstChar;
	}

	/**
	 * Accepts two lists with video IDs and lecture series IDs and creates a list of
	 * media types for those videos. If hasMediaTypeFiltered is set to true, only
	 * media types for mediaTypeId are returned.
	 * 
	 * @param hasMediaTypeFiltered true, if filtering for only one media type
	 * @param mediaTypeId          media type ID you're filtering for. Only relevant
	 *                             if hasMediaTypeFiltered is set to true
	 * @param videoIds             list of video IDs
	 * @param lectureseriesIds     list of lecture series IDs
	 * @return list of media types for videos and videos of lecture series.
	 */
	private Set<MediaType> filterByMediaTypes(boolean hasMediaTypeFiltered, long mediaTypeId, ArrayList<Long> videoIds,
			ArrayList<Long> lectureseriesIds) {
		Set<MediaType> mediaTypes = new TreeSet<>();
		if (hasMediaTypeFiltered) {
			try {
				mediaTypes.add(MediaTypeLocalServiceUtil.getMediaType(mediaTypeId));
			} catch (Exception e) {
				_log.error("can't add media type id " + mediaTypeId);
			}
		} else {
			ArrayList<Long> allVideoIds = new ArrayList<>();

			lectureseriesIds.forEach(lectureseriesId -> {
				VideoLocalServiceUtil.getByLectureseries(lectureseriesId).forEach(video -> {
					allVideoIds.add(video.getVideoId());
				});
			});

			allVideoIds.addAll(videoIds);
			mediaTypes.addAll(MediaTypeLocalServiceUtil.getMediaTypesFromVideoIds(allVideoIds));
		}

		return mediaTypes;
	}

	/**
	 * Constructs a list of creators from given video and lecture series IDs, and
	 * returns a one-item list of the creator with id creatorId. If the filter is
	 * not active, the entire list is returned.
	 * 
	 * @param filterIsActive   if true, list is filtered for creatorId
	 * @param creatorId        ID of creator to filter for. Can be null if
	 *                         filterIsActive is false
	 * @param lectureseriesIds IDs of the lecture series whose creators the list
	 *                         will contain
	 * @param videoIds         IDs of the videos whose creators the list will
	 *                         contain
	 * @return list of creators of given video/lectureSeries IDs. Single-item list
	 *         if filter is active and creator ID is given.
	 */
	private List<Creator> filterCreators(Boolean filterIsActive, long creatorId, ArrayList<Long> lectureseriesIds,
			ArrayList<Long> videoIds) {
		List<Creator> filteredCreators = new ArrayList<>();
		if (filterIsActive) {
			try {
				filteredCreators.add(CreatorLocalServiceUtil.getById(creatorId));
			} catch (Exception e) {
				_log.error("can't add creator id " + creatorId);
			}
		} else {
			filteredCreators = CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,
					videoIds);
		}

		return filteredCreators;
	}

	/**
	 * Takes a flat list of creators and sorts it to an alphabetical map
	 * 
	 * @param creatorList {Biene, Maja; Aaronson, John; ...}
	 * @return A={Aaronson, John; ...}, B={Biene, Maja; ...}
	 */
	private Map<Character, List<Creator>> splitCreatorsAlphabetically(List<Creator> creatorList) {
		Map<Character, List<Creator>> presentCreatorsAlphabetMap = new HashMap<>();

		for (int i = 0; i < alphabet.length(); i++) {
			presentCreatorsAlphabetMap.put(alphabet.charAt(i), new ArrayList<>());
		}

		creatorList.forEach(creator -> {
			char firstChar = mapSpecialCharacters(creator.getLastName());
			List<Creator> creatorsForChar = presentCreatorsAlphabetMap.get(firstChar);

			if (creatorsForChar != null) {
				creatorsForChar.add(creator);
			} else {
				presentCreatorsAlphabetMap.get('+').add(creator);
			}
		});

		return presentCreatorsAlphabetMap;
	}

	/**
	 * Accepts a string with arbitrarily formatted tags and tries to make sense of
	 * it.
	 * 
	 * @param tagsString String with tags.
	 * @return Tags as array; split by semicolon, comma, or not at all (in that
	 *         order).
	 */
	private String[] getTagsForString(String tagsString) {
		if (tagsString.isEmpty()) {
			return new String[0];
		}

		String[] splitBySemicolon = tagsString.split(";");
		if (splitBySemicolon.length > 1) {
			return splitBySemicolon;
		} else {
			return tagsString.split(",");
		}
	}

}