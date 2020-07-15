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
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.MediaType;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.VideoListSearchResult;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
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

	@Reference
	protected SearchManager searchManager;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long parentInstitutionId = ParamUtil.getLong(renderRequest, "parentInstitutionId");
		Long institutionId = ParamUtil.getLong(renderRequest, "institutionId", 0);
		Long termId = ParamUtil.getLong(renderRequest, "termId", 0);
		Long categoryId = ParamUtil.getLong(renderRequest, "categoryId", 0);
		Long creatorId = ParamUtil.getLong(renderRequest, "creatorId", 0);
		Long mediaTypeId = ParamUtil.getLong(renderRequest, "mediaTypeId", 0);
		Long licenseId = ParamUtil.getLong(renderRequest, "licenseId", 0);
		Integer searchTypeCode = ParamUtil.getInteger(renderRequest, "searchType", 0);
		SearchType searchType = SearchType.fromCode(searchTypeCode);
		String findVideos = ParamUtil.getString(renderRequest, "findVideos", "");
		String tag = ParamUtil.getString(renderRequest, "tag", "0");
		String sortBy = ParamUtil.getString(renderRequest, "sortBy", "");
		String previousSortBy = ParamUtil.getString(renderRequest, "previousSortBy", "");
		String sortByOrder = ParamUtil.getString(renderRequest, "sortByOrder", "");
		int maxTerms = 4;
		boolean hasInstitutionFiltered = (institutionId != 0);
		boolean hasParentInstitutionFiltered = (parentInstitutionId != 0);
		boolean hasTermFiltered = (termId != 0);
		boolean hasCreatorFiltered = (creatorId != 0);
		boolean hasCategoryFiltered = (categoryId != 0);
		boolean hasMediaTypeFiltered = (mediaTypeId != 0);
		boolean hasTagFiltered = (!tag.equals("0"));
		boolean hasLicenseFiltered = (licenseId != 0);
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
		if (hasLicenseFiltered) {
			filters.put("licenseId", licenseId);
		}

		// get desired sorting
		if (sortBy != null && !sortBy.isEmpty()) {
			if (!sortBy.equals(previousSortBy)) {
				// default sort by for field
				sortByOrder = "latestVideoGenerationDate".equals(sortBy) ? "DESC" : "ASC";
			} else {
				// toggle order
				sortByOrder = "ASC".equals(sortByOrder) ? "DESC" : "ASC";
			}
		} else if (findVideos == null || findVideos.isEmpty()) {
			// order by date if no order is selected and it is no search
			sortBy = "latestVideoGenerationDate";
			sortByOrder = "DESC";
		}

		try {
			videoList = searchManager.searchVideoList(companyId, searchType, findVideos, filters, -1, sortBy,
					sortByOrder);
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
		Set<License> presentLicenses;

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

		/*
		 * FILTER BY LICENSE
		 */
		presentLicenses = filterByLicenses(hasLicenseFiltered, licenseId, videoIds, lectureseriesIds);

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
		portletURL.setParameter("licenseId", String.valueOf(licenseId));
		portletURL.setParameter("searchType", searchTypeCode.toString());
		portletURL.setParameter("findVideos", findVideos);
		//
		boolean resultSetEmpty = true;
		if (presentParentInstitutions.size() > 0 || presentInstitutions.size() > 0 || presentTerms.size() > 0
				|| presentCategories.size() > 0 || presentMediaTypes.size() > 0 || presentLicenses.size() > 0) {
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
		renderRequest.setAttribute("licenseId", licenseId);
		renderRequest.setAttribute("searchType", searchTypeCode);
		renderRequest.setAttribute("findVideos", findVideos);
		renderRequest.setAttribute("sortBy", sortBy);
		renderRequest.setAttribute("sortByOrder", sortByOrder);
		renderRequest.setAttribute("sortableFields", Arrays.asList("name", "latestVideoGenerationDate"));

		renderRequest.setAttribute("maxTerms", maxTerms);
		renderRequest.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
		renderRequest.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
		renderRequest.setAttribute("hasTermFiltered", hasTermFiltered);
		renderRequest.setAttribute("hasCreatorFiltered", hasCreatorFiltered);
		renderRequest.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
		renderRequest.setAttribute("hasMediaTypeFiltered", hasMediaTypeFiltered);
		renderRequest.setAttribute("hasTagFiltered", hasTagFiltered);
		renderRequest.setAttribute("hasLicenseFiltered", hasLicenseFiltered);
		renderRequest.setAttribute("isSearched", isSearched);
		renderRequest.setAttribute("videoList", videoList);
		renderRequest.setAttribute("lectureseriesIds", lectureseriesIds);
		renderRequest.setAttribute("videoIds", videoIds);
		renderRequest.setAttribute("presentParentInstitutions", presentParentInstitutions);
		renderRequest.setAttribute("presentInstitutions", presentInstitutions);
		renderRequest.setAttribute("presentTerms", presentTerms);
		renderRequest.setAttribute("presentCategories", presentCategories);
		renderRequest.setAttribute("presentMediaTypes", presentMediaTypes);
		renderRequest.setAttribute("presentLicenses", presentLicenses);
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
	 * Accepts two lists with video IDs and lecture series IDs and creates a list of
	 * licenses for those videos. If hasLicenseFiltered is set to true, only
	 * licenses for licenseId are returned.
	 * 
	 * @param hasLicenseFiltered true, if filtering for only one license
	 * @param licenseId          license ID you're filtering for. Only relevant if
	 *                           hasLicenseFiltered is set to true
	 * @param videoIds           list of video IDs
	 * @param lectureseriesIds   list of lecture series IDs
	 * @return list of licenses for videos and videos of lecture series.
	 */
	private Set<License> filterByLicenses(boolean hasLicenseFiltered, long licenseId, ArrayList<Long> videoIds,
			ArrayList<Long> lectureseriesIds) {
		Set<License> licenses = new TreeSet<>();
		if (hasLicenseFiltered) {
			try {
				licenses.add(LicenseLocalServiceUtil.getLicense(licenseId));
			} catch (Exception e) {
				_log.error("can't add license id " + licenseId);
			}
		} else {
			ArrayList<Long> allVideoIds = new ArrayList<>();

			lectureseriesIds.forEach(lectureseriesId -> {
				VideoLocalServiceUtil.getByLectureseries(lectureseriesId).forEach(video -> {
					allVideoIds.add(video.getVideoId());
				});
			});

			allVideoIds.addAll(videoIds);
			licenses.addAll(LicenseLocalServiceUtil.getLicensesFromVideoIds(allVideoIds));
		}

		return licenses;
	}
}