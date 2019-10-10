package de.uhh.l2g.plugins.guest.videos.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS,
	    		"mvc.command.name=/view/render/list", "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
)
public class ViewRenderList implements MVCRenderCommand{
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long parentInstitutionId = ParamUtil.getLong(renderRequest, "parentInstitutionId");
		Long institutionId 	= ParamUtil.getLong(renderRequest, "institutionId", 0);
		Long termId = ParamUtil.getLong(renderRequest, "termId", 0);
		Long categoryId = ParamUtil.getLong(renderRequest, "categoryId", 0);
		Long creatorId = ParamUtil.getLong(renderRequest, "creatorId", 0);
		String findVideos = ParamUtil.getString(renderRequest, "findVideos", "");
		int maxTerms = 4;
		boolean hasInstitutionFiltered 	= (institutionId != 0);
		boolean hasParentInstitutionFiltered = (parentInstitutionId != 0);
		boolean hasTermFiltered	= (termId != 0);
		boolean hasCategoryFiltered	= (categoryId != 0);
		boolean isSearched = (findVideos.trim().length()>0);
		//
		long companyId = PortalUtil.getCompanyId(renderRequest);
		long groupId = new Long(0); 

		// the institution is dependent on the parentinstitution, do not allow institution-filters without parentinstitution-filter
		if (hasInstitutionFiltered && !hasParentInstitutionFiltered) {
			institutionId = new Long(0);
		}		
		// get filtered lectureseries and single videos
		List<Lectureseries> reqLectureseries = LectureseriesLocalServiceUtil.getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termId, categoryId, creatorId, findVideos, groupId, companyId);
		// differentiate returned lectureseries in real lectureseries and fake video lectureseries (openAccessVideoId is negative on videos)
		ArrayList<Long> lectureseriesIds = new ArrayList<Long>();
		ArrayList<Long> videoIds = new ArrayList<Long>();
		long id;
	 	for (Lectureseries lecture : reqLectureseries) {
			id = lecture.getLectureseriesId();
			if (lecture.getLatestOpenAccessVideoId() < 0) {
				videoIds.add(id);
			} else {
				lectureseriesIds.add(id);
			}
		} 
	 	//
	 	// get the institutions, parentinstitutuons, terms, categories and creators which are part of the dataset. those are displayed so the user can do further filtering
		List<Institution> presentParentInstitutions 	= new ArrayList<Institution>();
		List<Institution> presentInstitutions 			= new ArrayList<Institution>();
		List<Term> presentTerms 						= new ArrayList<Term>();
		List<Creator> presentCreators 					= new ArrayList<Creator>();
		List<Category> presentCategories 				= new ArrayList<Category>();

		// if a filter is selected, only show the selected one else show all
	 	if (hasParentInstitutionFiltered) {
			presentParentInstitutions.add(InstitutionLocalServiceUtil.getById(parentInstitutionId));
		} else {
			presentParentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		} 
		
	 	if (hasParentInstitutionFiltered && hasInstitutionFiltered) {
			presentInstitutions.add(InstitutionLocalServiceUtil.getById(institutionId));
		} else {
			presentInstitutions = InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds, parentInstitutionId);
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
		
		if (hasCategoryFiltered) {
			try {
				presentCategories.add(CategoryLocalServiceUtil.getById(categoryId));
			} catch (Exception e) {
				_log.error("can't add category with id" + categoryId);
			}
		} else {
			presentCategories = CategoryLocalServiceUtil.getCategoriesFromLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
		}
		//
		PortletURL portletURL = renderResponse.createRenderURL();
		// set parameter for search iterator or possible backURL
		portletURL.setParameter("parentInstitutionId", parentInstitutionId.toString());
		portletURL.setParameter("institutionId", institutionId.toString());
		portletURL.setParameter("termId", termId.toString());
		portletURL.setParameter("categoryId", categoryId.toString());
		portletURL.setParameter("creatorId", creatorId.toString());
		portletURL.setParameter("findVideos", findVideos);
		//
		boolean resultSetEmpty = true;
		if(presentParentInstitutions.size()>0||presentInstitutions.size()>0||presentTerms.size()>0||presentCategories.size()>0){
			resultSetEmpty=false;
		}
		//
		Institution insti = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if(institutionId>0)insti=InstitutionLocalServiceUtil.getById(institutionId);
		} catch (Exception e) {
			_log.error("can't get insti bei id");
		}
		//
		Institution pInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			if(parentInstitutionId>0)pInst=InstitutionLocalServiceUtil.getById(parentInstitutionId);
		} catch (Exception e) {
			_log.error("can't get pInst bei id");
		}
		//
		Institution rInst = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			rInst=InstitutionLocalServiceUtil.getRootByParentAndCompanyAndGroup(0, companyId, groupId);
		} catch (Exception e) {
			_log.error("can't get rInst bei company and group id");
		}
		//
		renderRequest.setAttribute("parentInstitutionId", parentInstitutionId);
		renderRequest.setAttribute("institutionId", institutionId);
		renderRequest.setAttribute("termId", termId);
		renderRequest.setAttribute("categoryId", categoryId);
		renderRequest.setAttribute("creatorId", creatorId);
		renderRequest.setAttribute("findVideos", findVideos);
		renderRequest.setAttribute("maxTerms", maxTerms);
		renderRequest.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
		renderRequest.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
		renderRequest.setAttribute("hasTermFiltered", hasTermFiltered);
		renderRequest.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
		renderRequest.setAttribute("isSearched", isSearched);
		renderRequest.setAttribute("reqLectureseries", reqLectureseries);
		renderRequest.setAttribute("lectureseriesIds", lectureseriesIds);
		renderRequest.setAttribute("videoIds", videoIds);
		renderRequest.setAttribute("presentParentInstitutions", presentParentInstitutions);
		renderRequest.setAttribute("presentInstitutions", presentInstitutions);
		renderRequest.setAttribute("presentTerms", presentTerms);
		renderRequest.setAttribute("presentCreators", presentCreators);
		renderRequest.setAttribute("presentCategories", presentCategories);
		renderRequest.setAttribute("portletURL", portletURL);
		renderRequest.setAttribute("resultSetEmpty", resultSetEmpty);
		//
		renderRequest.setAttribute("insti", insti);
		renderRequest.setAttribute("pInst", pInst);
		renderRequest.setAttribute("rInst", rInst);
		//	
	    
		return "/viewList.jsp"; 
	}

}
