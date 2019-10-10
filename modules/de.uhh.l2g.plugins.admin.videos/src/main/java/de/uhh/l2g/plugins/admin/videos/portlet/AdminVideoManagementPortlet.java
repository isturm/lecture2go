package de.uhh.l2g.plugins.admin.videos.portlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import de.uhh.l2g.plugins.admin.videos.constants.AdminVideoManagementPortletKeys;
import de.uhh.l2g.plugins.admin.videos.search.VideoDisplayTerms;
import de.uhh.l2g.plugins.admin.videos.search.VideoSearchContainer;
import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.FFmpegManager;
import de.uhh.l2g.plugins.util.FileManager;
import de.uhh.l2g.plugins.util.Htaccess;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;
import de.uhh.l2g.plugins.util.ProzessManager;
import de.uhh.l2g.plugins.util.Security;
import de.uhh.l2g.plugins.util.VideoGenerationDateComparator;


/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/js/jquery.datetimepicker.css",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui-1.11.1.js",
		"com.liferay.portlet.header-portlet-javascript=/upload-9.27.0/js/vendor/jquery.ui.widget.js",		
		"com.liferay.portlet.header-portlet-javascript=/upload-9.27.0/js/jquery.iframe-transport.js",		
		"com.liferay.portlet.header-portlet-javascript=/upload-9.27.0/js/jquery.fileupload.js",		
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.loadTemplate.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.datetimepicker.js",
		"com.liferay.portlet.header-portlet-javascript=https://cdn.jwplayer.com/libraries/aVr2lJgW.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jwplayer.custom.util.js",		
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.creators.js",		
		"javax.portlet.display-name=Admin Videos",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + AdminVideoManagementPortletKeys.AdminVideoManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class 
)
public class AdminVideoManagementPortlet extends MVCPortlet {
	protected static Log _log = LogFactoryUtil.getLog(AdminVideoManagementPortletKeys.class.getName());
	
	public void addSegment(ActionRequest request, ActionResponse response){
		Video reqVideo = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		try {reqVideo = VideoLocalServiceUtil.getVideo(reqVideoId);} catch (PortalException e1) {}
		
		request.setAttribute("reqVideo", reqVideo);
		String backURL = request.getParameter("backURL");
		request.setAttribute("backURL", backURL);
		response.setRenderParameter("jspPage", "/admin/segments.jsp");
	}

	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		
		//
		PortletURL portletURL = renderResponse.createRenderURL();
		
		VideoSearchContainer videoSearchContainer = new VideoSearchContainer(renderRequest, portletURL);	
		VideoDisplayTerms displayTerms = (VideoDisplayTerms)videoSearchContainer.getDisplayTerms();
		
		//Remote user
		Long userId = new Long(renderRequest.getRemoteUser());
		User user = UserLocalServiceUtil.createUser(0);
		long companyId = new Long(0);
		long groupId = new Long(0);
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try {
			remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); 
			user = UserLocalServiceUtil.getUser(userId);
			companyId = user.getCompanyId();
			//groupId = user.getGroupId();
		} catch (Exception e1) {
			_log.error("user can't be fatched!");
		} 
		//
		Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(remoteUser);		
		//permissions
		boolean permissionAdmin = l2goRole.isL2gAdmin();
		boolean permissionCoordinator = l2goRole.isCoordinator();
		boolean permissionProducer = l2goRole.isProducer();
		//initialize all view variables
		List<Coordinator> coordinators = new ArrayList<Coordinator>();
		List<Producer> producers = new ArrayList<Producer>();
		List<Lectureseries> lectureseries = new ArrayList<Lectureseries>();
		List<Video> tempVideosList = new ArrayList<Video>();
		Map<Term, List<Lectureseries>> lectureseriesAsTreeList = new TreeMap<Term, List<Lectureseries>>();
		Long coordinatorId = ParamUtil.getLong(renderRequest, "coordinatorId", 0);
		Long producerId = ParamUtil.getLong(renderRequest, "producerId", 0);
		Long lectureseriesId = ParamUtil.getLong(renderRequest, "lectureseriesId", 0);
		//if coordinator, producer or lecture series clicked, 
		//add to portlet url
		if(coordinatorId>0)portletURL.setParameter("coordinatorId", coordinatorId.toString());
		if(producerId>0)portletURL.setParameter("producerId", producerId.toString());
		if(lectureseriesId>0)portletURL.setParameter("lectureseriesId", lectureseriesId.toString());
		//detail all possible view variables
		Long videoId = ParamUtil.getLong(renderRequest, "videoId", 0);
		Video reqVideo = VideoLocalServiceUtil.createVideo(0);
		try {reqVideo = VideoLocalServiceUtil.getVideo(videoId);} catch (PortalException e1) {}
		List<Lectureseries> reqLectureseriesList = new ArrayList<Lectureseries>();
		Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
		License reqLicense = LicenseLocalServiceUtil.createLicense(0);
		// requested license list - all licenses to choose from
		List<License> reqLicenseList = new ArrayList<License>();
		try{reqLicenseList = LicenseLocalServiceUtil.getLicenses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);}catch(Exception e){}
		Producer reqProducer = ProducerLocalServiceUtil.createProducer(0);
		Long reqPproducerId = ParamUtil.getLong(renderRequest, "pproducerId", 0);
		Long reqLectureseriesId = ParamUtil.getLong(renderRequest, "lectureseriesId", 0);
		Metadata reqMetadata = MetadataLocalServiceUtil.createMetadata(0);
		List<Video_Institution> reqSubInstitutions = new ArrayList<Video_Institution>();	
		JSONArray allCreatorsJSON = JSONFactoryUtil.createJSONArray();
		List<Term> terms = new ArrayList<Term>(); 
		List<Category> categories = new ArrayList<Category>();
		List<Institution> producersSubInstitutions = new ArrayList<Institution>();
		Host host = HostLocalServiceUtil.createHost(0);
		String uploadRepository = "";
		JSONArray assignedCreators = JSONFactoryUtil.createJSONArray();
    
		Locale locale = renderRequest.getLocale();
		ResourceBundle resourceBundle = ResourceBundleUtil. getBundle("content.Language", locale, getClass());
		String languages = LanguageUtil.get(resourceBundle, "de.uhh.l2g.plugins.admin.videos.languages");
		
		//DIFFERENT VIEWS HERE
		//list view
		if(mvcPath.contains("viewList") || mvcPath.isEmpty()){
			if(permissionAdmin){
				coordinators = CoordinatorLocalServiceUtil.getAllCoordinators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
				if(coordinatorId>0){
					try{
						Long institutionId = CoordinatorLocalServiceUtil.getCoordinator(coordinatorId).getInstitutionId();
						producers = ProducerLocalServiceUtil.getProducersByInstitutionId(institutionId);
						if(producerId==0)tempVideosList = VideoLocalServiceUtil.getByRootInstitution(institutionId);
						else {
							lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId, groupId, companyId);
							lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, new Long(0), new Long(0), producerId, new Long(0), companyId);
							if(lectureseriesId==0) tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
							else tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
						}
					}catch(Exception e){}
				}else{ 
					producerId = new Long(0);
					tempVideosList = VideoLocalServiceUtil.getVideos(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
				}
			}else{
				if(permissionCoordinator){
					try{
						coordinatorId = remoteUser.getUserId();
						producerId = ParamUtil.getLong(renderRequest, "producerId", 0);
						Long institutionId = CoordinatorLocalServiceUtil.getCoordinator(coordinatorId).getInstitutionId();
						producers = ProducerLocalServiceUtil.getProducersByInstitutionId(institutionId);
						if(producerId>0){
							lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId, groupId, companyId);
							lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, new Long(0), new Long(0), producerId, new Long(0), companyId);
							if(lectureseriesId==0)tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
							else tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
						}else{
							tempVideosList = VideoLocalServiceUtil.getByRootInstitution(institutionId);
						}
					}catch(Exception e){}
				}else{
					if(permissionProducer){
						producerId = remoteUser.getUserId();
						if(lectureseriesId>0) tempVideosList = VideoLocalServiceUtil.getByProducerAndLectureseries(producerId, lectureseriesId);
						else tempVideosList = VideoLocalServiceUtil.getByProducer(producerId);
						lectureseries = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, new Long(0), new Long(0), producerId, groupId, companyId);
						lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, new Long(0), new Long(0), producerId, new Long(0), companyId);
					}
				}
			}	
		}
		//edit view
		if(mvcPath.contains("viewEdit")){
			//prepare details view
			if(reqVideo.getVideoId()>0){
				//hack for empty secure filename on the first upload
				if(reqVideo.getFilename().length()==0 && reqVideo.getSecureFilename().length()==0){
					reqVideo.setSecureFilename(Security.createSecureFileName()+".xx");
					VideoLocalServiceUtil.updateVideo(reqVideo);
				}
				
				//requested producer
				try{
					if(reqVideo.getVideoId()>0)reqProducer = ProducerLocalServiceUtil.getProdUcer(reqVideo.getProducerId());
					else {
						reqProducer = ProducerLocalServiceUtil.getProdUcer(reqPproducerId);
						reqVideo.setProducerId(reqPproducerId);
					}
				}catch(Exception e){}
				
				// requested lecture series object
				try{
					if(reqVideo.getVideoId()>0)reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqVideo.getLectureseriesId());
					else{
						reqLectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqLectureseriesId);
						reqVideo.setLectureseriesId(reqLectureseriesId);
					}
				}catch(Exception e){}
				
				// requested metadata
				try{
					if(reqVideo.getVideoId()>0)reqMetadata = (Metadata)MetadataLocalServiceUtil.getMetadata(reqVideo.getMetadataId());
					else{
						reqMetadata.setDescription(reqLectureseries.getLongDesc());
						reqMetadata.setPublisher(reqProducer.getFirstName()+" "+reqProducer.getLastName());
						reqMetadata.setLanguage(reqLectureseries.getLanguage());
					}
				}catch(Exception e){}
				
				// requested lecture series list
				try{
					if(reqVideo.getVideoId()>0)reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, (long) 0, (long) 0, reqVideo.getProducerId(), groupId, companyId);
					else reqLectureseriesList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(1, (long) 0, (long) 0, reqPproducerId, groupId, companyId);
				}catch(Exception e){}
				
				//requested sub institutions
				reqSubInstitutions = Video_InstitutionLocalServiceUtil.getByVideo(reqVideo.getVideoId());
			}	

			//all creator to json
			List<Creator> creators = new ArrayList<Creator>();
			try{creators = CreatorLocalServiceUtil.getCreators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch (NullPointerException e){}
			for (Creator creator: creators) {
				JSONObject c = JSONFactoryUtil.createJSONObject();
				c.put("id", creator.getCreatorId());
				c.put("value", creator.getFullName());
				c.put("label", creator.getFullName());
				allCreatorsJSON.put(c);
			}
			
			//terms 
			try{terms = TermLocalServiceUtil.getAllSemesters();}catch(Exception e){}
			
			//categories
			try{categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);}catch(Exception e){}

			//sub institutions for producer
			producersSubInstitutions = InstitutionLocalServiceUtil.getByParentId(reqProducer.getInstitutionId());
			
			//host 
			host = HostLocalServiceUtil.getByHostId(reqVideo.getHostId());	
			
			//repo
			uploadRepository = PropsUtil.get("lecture2go.media.repository")+"/"+host.getServerRoot()+"/"+reqProducer.getIdNum();

			//lecture series
			if(reqVideo.getVideoId()>0)lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, (long) 0, (long) 0, reqVideo.getProducerId(),groupId, companyId);
			else lectureseriesAsTreeList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(1, (long) 0, (long) 0, reqProducer.getProducerId(),groupId, companyId);

			//creators
			assignedCreators = CreatorLocalServiceUtil.getJSONCreatorsByVideoId(reqVideo.getVideoId());
		}
		
		//assign to render request and response finally
		renderRequest.setAttribute("uploadRepository", uploadRepository);	
		renderRequest.setAttribute("reqHost", host);	
		renderRequest.setAttribute("terms", terms);	
		renderRequest.setAttribute("categories", categories);	
		renderRequest.setAttribute("allCreatorsJSON", allCreatorsJSON);	
		renderRequest.setAttribute("reqMetadata", reqMetadata);	
		renderRequest.setAttribute("reqProducer", reqProducer);	
		renderRequest.setAttribute("reqLectureseries", reqLectureseries);
		renderRequest.setAttribute("reqLectureseriesList", reqLectureseriesList);
		renderRequest.setAttribute("reqSubInstitutions", reqSubInstitutions);
		renderRequest.setAttribute("reqLicense", reqLicense);
		renderRequest.setAttribute("reqLicenseList", reqLicenseList);
		renderRequest.setAttribute("permissionAdmin", permissionAdmin);				
		renderRequest.setAttribute("permissionProducer", permissionProducer);				
		renderRequest.setAttribute("permissionCoordinator", permissionCoordinator);	
		renderRequest.setAttribute("lectureseriesId", lectureseriesId);	
		renderRequest.setAttribute("coordinators", coordinators);	
		renderRequest.setAttribute("coordinatorId", coordinatorId);	
		renderRequest.setAttribute("producers", producers);	
		renderRequest.setAttribute("producerId", producerId);	
		renderRequest.setAttribute("lectureseriesAsTreeList", lectureseriesAsTreeList);	
		renderRequest.setAttribute("tempVideosList", tempVideosList);	
		renderRequest.setAttribute("portletURL", portletURL);	
		renderRequest.setAttribute("backURL", backURL);
		renderRequest.setAttribute("remoteUser", remoteUser);	
		renderRequest.setAttribute("reqVideo", reqVideo);
		renderRequest.setAttribute("languages", languages);
		renderRequest.setAttribute("assignedCreators", assignedCreators);
		renderRequest.setAttribute("displayTerms", displayTerms);
		renderRequest.setAttribute("videoSearchContainer", videoSearchContainer);
		//
		renderResponse.setProperty("jspPage", mvcPath);
		super.render(renderRequest, renderResponse);
	}
	
	public void addVideo(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		
		//first metadata
		Metadata reqMetadata = MetadataLocalServiceUtil.createMetadata(0);
		reqMetadata = MetadataLocalServiceUtil.addMetadata(reqMetadata);

		//lecture series
		Long lectureseriesId = new Long(request.getParameter("lectureseriesId"));
		//forward to the render method
		response.setRenderParameter("lectureseriesId", lectureseriesId+"");
		//
		Lectureseries reqLectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
		try{
			reqLectureseries = (Lectureseries) LectureseriesLocalServiceUtil.getLectureseries(lectureseriesId); 
			Category ctgr = CategoryLocalServiceUtil.createCategory(0);
			try{ctgr = CategoryLocalServiceUtil.getCategory(reqLectureseries.getCategoryId());}catch(Exception e){}			
		}catch(Exception e){}
		
		//producer
		Long producerId = new Long(request.getParameter("producerId"));
		Producer reqProducer = ProducerLocalServiceUtil.createProducer(0);
		reqProducer = (Producer)ProducerLocalServiceUtil.getProdUcer(producerId);
		//forward to the render method
		response.setRenderParameter("producerId", producerId+"");
		//		
		//video
		Video newVideo =  VideoLocalServiceUtil.createVideo(0);
		newVideo.setProducerId(producerId);
		if(lectureseriesId>0)newVideo.setLectureseriesId(lectureseriesId);
		else {
			java.util.Date date= new java.util.Date();
			newVideo.setLectureseriesId(-date.getTime());
		}
		newVideo.setHostId(reqProducer.getHostId());
		newVideo.setMetadataId(reqMetadata.getMetadataId());
		newVideo.setRootInstitutionId(reqProducer.getInstitutionId());
		newVideo.setOpenAccess(0);
		newVideo.setSecureFilename(Security.createSecureFileName()+".xx");
		newVideo.setCitation2go(1);
		//save it
		Video video = VideoLocalServiceUtil.addVideo(newVideo);
		//forward to the render method
		response.setRenderParameter("videoId", video.getVideoId()+"");

		// update uploads for producer
		Producer p = ProducerLocalServiceUtil.createProducer(0);
		p = (Producer)ProducerLocalServiceUtil.getProducer(producerId);
		int n = 0;
		n = VideoLocalServiceUtil.getByProducer(p.getProducerId()).size();
		p.setNumberOfProductions(n);
		ProducerLocalServiceUtil.updateProducer(p);
			
		//link to lectureseries list
		Video_Lectureseries vl = Video_LectureseriesLocalServiceUtil.createVideo_Lectureseries(0);
		vl.setLectureseriesId(lectureseriesId);
		vl.setVideoId(newVideo.getVideoId());
		vl.setOpenAccess(newVideo.getOpenAccess()); 
		Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);
		
		//requested sub institutions
		List<Video_Institution> reqSubInstitutions = new ArrayList<Video_Institution>();
		reqSubInstitutions = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());

		//update lg_video_institution table and update previewVideoId in lg_lecturseries table
		if(lectureseriesId>0){
			LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(LectureseriesLocalServiceUtil.getLectureseries(lectureseriesId));
			List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectureseriesId);
			ListIterator<Lectureseries_Institution> i = li.listIterator();
			while(i.hasNext()){
				Institution ins = InstitutionLocalServiceUtil.getInstitution(i.next().getInstitutionId());
				Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
				vi.setVideoId(video.getVideoId());
				vi.setInstitutionId(ins.getInstitutionId());
				vi.setInstitutionParentId(ins.getParentId());
				Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
			}
		}else{
			//no lecture series 
			Institution ins = InstitutionLocalServiceUtil.getInstitution(video.getRootInstitutionId());
			Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
			vi.setVideoId(video.getVideoId());
			vi.setInstitutionId(video.getRootInstitutionId());
			
			if(ins.getLevel()==1)vi.setInstitutionParentId(0);
			else vi.setInstitutionParentId(ins.getParentId());
			
			Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
		}
	
		//creators
		JSONArray creatorsArray = CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId(lectureseriesId);
		for (int i = 0; i< creatorsArray.length(); i++){
			JSONObject creator;
			creator = creatorsArray.getJSONObject(i);
			Long creatorId= creator.getLong("creatorId");
			Video_Creator vc = Video_CreatorLocalServiceUtil.createVideo_Creator(0);
			vc.setCreatorId(creatorId);
			vc.setVideoId(newVideo.getVideoId());
			Video_CreatorLocalServiceUtil.addVideo_Creator(vc);
		}
		
		//add tags to tag cloud
		TagcloudLocalServiceUtil.generateForVideo(video.getVideoId());
		//
		String backURL = request.getParameter("backURL");
		response.setRenderParameter("backURL", backURL);
		response.setRenderParameter("mvcPath", "/viewEdit.jsp");
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String userID = resourceRequest.getRemoteUser();
		Long userId = new Long(userID);
		String resourceID = resourceRequest.getResourceID();
		Long videoId = ParamUtil.getLong(resourceRequest, "videoId");
		Video video = VideoLocalServiceUtil.createVideo(0);
		try {video = VideoLocalServiceUtil.getVideo(videoId);} catch (PortalException e1) {}
		Metadata metadata = MetadataLocalServiceUtil.createMetadata(0);
		try {
			Long metadataId = video.getMetadataId();
			metadata = MetadataLocalServiceUtil.getMetadata(metadataId);
		} catch (PortalException e) {
			//e.printStackTrace();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		
		if(resourceID.equals("updateVideoFileName")){
			String fileName = ParamUtil.getString(resourceRequest, "fileName");
			String secureFileName = ParamUtil.getString(resourceRequest, "secureFileName");
			String generationDate = ParamUtil.getString(resourceRequest, "generationDate");

			String containerFormat = fileName.split("\\.")[fileName.split("\\.").length-1];
			//update data base
			try {
				video.setFilename(fileName);
				video.setSecureFilename(secureFileName);
				video.setContainerFormat(containerFormat);
				video.setGenerationDate(generationDate);
				video.setUploadDate(new Date());
				//--- Database start
				VideoLocalServiceUtil.updateVideo(video);
				FFmpegManager.updateFfmpegMetadata(video);
				//--- Database end
				//delete old thumbs
				ProzessManager pm = new ProzessManager();
				pm.deleteThumbnails(video);
				//and thumbs for segments
				// delete all segment images from repository location
				try{
					List<Segment> segmentList = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
					SegmentLocalServiceUtil.deleteThumbhailsFromSegments(segmentList);
				}catch (PortalException e) {
					//e.printStackTrace();
				} catch (SystemException e) {
					//e.printStackTrace();
				} catch (NullPointerException e){
					//e.printStackTrace();
				}	
				//
			} catch (NumberFormatException e) {
				//e.printStackTrace();
			} catch (SystemException e) {
				//e.printStackTrace();
			} catch (PortalException e) {
				//e.printStackTrace();
			}
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(json.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("updateThumbnail")){
			String image="";
			String fileLocation="";
			String thumbnailLocation = "";
			int time = ParamUtil.getInteger(resourceRequest, "inputTime");
			
			//proceed only if time > 0
			if(time > 0){
				//create new thumb nail 
				if(video.getOpenAccess()==1){
					image = video.getPreffix()+".jpg";
					try {
						fileLocation = ProducerLocalServiceUtil.getProdUcer(video.getProducerId()).getHomeDir() + "/" + video.getFilename();
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}else{
					image = video.getSPreffix()+".jpg";
					try {
						fileLocation = ProducerLocalServiceUtil.getProdUcer(video.getProducerId()).getHomeDir() + "/" + video.getSecureFilename();
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}
				//
				try {
					thumbnailLocation = PropsUtil.get("lecture2go.images.system.path") + "/" + image;
					FFmpegManager.createThumbnail(fileLocation, thumbnailLocation, time);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		}
		
		if(resourceID.equals("updateAll")){
			ArrayList<String> errors = new ArrayList<>();
			//description start
			String description = ParamUtil.getString(resourceRequest, "description");
			metadata.setDescription(description);
			try {
				MetadataLocalServiceUtil.updateMetadata(metadata);
			} catch (SystemException e) {
				errors.add("DESCRIPTION_UPDATE_FAILED");
			}			
			//description end
			
			//creators start
			String creatorsJsonArray = ParamUtil.getString(resourceRequest, "creatorsJsonArray");
			try {
				JSONArray creatorsArray = JSONFactoryUtil.createJSONArray(creatorsJsonArray);
				// remove creators for video
				try {
					Video_CreatorLocalServiceUtil.deleteByVideoId(videoId);
					// and update with new creators from list
					for (int i = 0; i < creatorsArray.length(); i++) {
						JSONObject creator = creatorsArray.getJSONObject(i);
						Long creatorId = creator.getLong("creatorId");
						String firstName = creator.getString("firstName");
						String lastName = creator.getString("lastName");
						String middleName = creator.getString("middleName");
						String jobTitle = creator.getString("jobTitle");
						String gender = creator.getString("gender");
						String fullName = creator.getString("fullName");

						Video_Creator vc = Video_CreatorLocalServiceUtil.createVideo_Creator(0);
						Long newCreatorId = new Long(0);
						// if creator exists in DB, just add to video
						if (creatorId > new Long(0)) {
							newCreatorId = creatorId;
						} else {
							// if new creator doesn't exits in the creators DB
							// (check by full name),
							// create a new one in DB and add to video
							List<Creator> cL = CreatorLocalServiceUtil.getByFullName(fullName);
							if (cL.size() == 0) {
								Creator c = CreatorLocalServiceUtil.createCreator(0);
								c.setFirstName(firstName);
								c.setLastName(lastName);
								c.setMiddleName(middleName);
								c.setJobTitle(jobTitle);
								c.setGender(gender);
								c.setFullName(fullName);
								newCreatorId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
							} else {
								newCreatorId = cL.listIterator().next().getCreatorId();
							}
						}
						vc.setCreatorId(newCreatorId);
						vc.setVideoId(videoId);
						List<Video_Creator> vcl = new ArrayList<Video_Creator>();
						vcl = Video_CreatorLocalServiceUtil.getByVideoCreator(videoId, newCreatorId);
						if (vcl.size() == 0)
							Video_CreatorLocalServiceUtil.addVideo_Creator(vc);
					}
				} catch (SystemException e) {
					errors.add("CREATORS_UPDATE_FAILED_1");
				}
				// now update creators for the whole lecture series
				Long lId = video.getLectureseriesId();
				try {
					if (lId > 0) CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lId);
				} catch (SystemException e) {
					errors.add("CREATORS_UPDATE_FAILED_2");
				}
			} catch (JSONException e) {
				errors.add("CREATORS_UPDATE_FAILED_3");
			}		
			//creators end
			
			//sub institutions start
			String subInstitutions = ParamUtil.getString(resourceRequest, "subInstitutions");
			try {
				JSONArray institutionsArray = JSONFactoryUtil.createJSONArray(subInstitutions);
				//remove sub-institutions for video
				try {
					Video_InstitutionLocalServiceUtil.removeByVideoId(videoId);
					//and update with new institutions from list
					if(institutionsArray.length()>0){
						for (int i = 0; i< institutionsArray.length(); i++){
							JSONObject institution =  institutionsArray.getJSONObject(i);
							Long institutionId= institution.getLong("institutionId");
							Institution in = InstitutionLocalServiceUtil.createInstitution(0);
							try {
								in = InstitutionLocalServiceUtil.getInstitution(institutionId);
							} catch (PortalException e) {}
							//
							List<Video_Institution> vil = new ArrayList<Video_Institution>();
							vil = Video_InstitutionLocalServiceUtil.getByVideoAndInstitution(videoId, institutionId);
							
							Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
							vi.setInstitutionId(in.getInstitutionId());
							vi.setVideoId(videoId);
							if(in.getLevel()==1)vi.setInstitutionParentId(0);
							else vi.setInstitutionParentId(in.getParentId());
							if(vil.size()==0)Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
						}						
					}
				} catch (SystemException e) {
					errors.add("SUB_INSTITUTIONS_UPDATE_FAILED_1");
				}
			} catch (JSONException e) {
				errors.add("SUB_INSTITUTIONS_UPDATE_FAILED_2");
			}			
			//sub institutions end
			
			//metadata start
			String title = ParamUtil.getString(resourceRequest, "title");
			String language = ParamUtil.getString(resourceRequest, "language");
			String datetime = ParamUtil.getString(resourceRequest, "datetimepicker");
			String tags = ParamUtil.getString(resourceRequest, "tags");
			String publisher = ParamUtil.getString(resourceRequest, "publisher");
			Long lId = ParamUtil.getLong(resourceRequest, "lectureseriesId");
			Long termId = ParamUtil.getLong(resourceRequest, "termId");
			Long categoryId = ParamUtil.getLong(resourceRequest, "categoryId");
			Integer citationAllowed = ParamUtil.getInteger(resourceRequest, "citationAllowedCheckbox");
	 	    String password = ParamUtil.getString(resourceRequest, "password");	
	 	    //
	 	   Lectureseries oldLs = LectureseriesLocalServiceUtil.createLectureseries(0);
			Long oldLsId = video.getLectureseriesId();
			try {
				oldLs = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
			} catch (PortalException e1) {
				//e1.printStackTrace();
			} catch (SystemException e1) {
				//e1.printStackTrace();
			}

			Lectureseries newLect = LectureseriesLocalServiceUtil.createLectureseries(0);
			Category ctgr = CategoryLocalServiceUtil.createCategory(0);
			//update data base
			try {
				video.setTitle(title);
				video.setLectureseriesId(lId);
				if(lId>0)video.setLectureseriesId(lId);
				else {
					java.util.Date date= new java.util.Date();
					video.setLectureseriesId(-date.getTime());
					//update table video_lectureseries
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());
				}
				video.setTags(tags);
				if(lId>0){
					newLect = LectureseriesLocalServiceUtil.getLectureseries(lId);
					//
					termId = newLect.getTermId();
					categoryId = newLect.getCategoryId();
					//update lg_video_institution table
					Video_InstitutionLocalServiceUtil.removeByVideoId(video.getVideoId());
					List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lId);
					ListIterator<Lectureseries_Institution> l_i = li.listIterator();
					//institutions for video
					while(l_i.hasNext()){
						Institution in = InstitutionLocalServiceUtil.createInstitution(0);
						Lectureseries_Institution lectinst = l_i.next();
						in = InstitutionLocalServiceUtil.getInstitution(lectinst.getInstitutionId());
						Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
						vi.setVideoId(video.getVideoId());
						vi.setInstitutionId(lectinst.getInstitutionId());
						vi.setInstitutionParentId(in.getParentId());
						Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
					}
					//update lg_video_lectureseries 
					Video_Lectureseries vl = Video_LectureseriesLocalServiceUtil.createVideo_Lectureseries(0);
					vl.setVideoId(video.getVideoId());
					vl.setLectureseriesId(lId);
					vl.setOpenAccess(video.getOpenAccess());
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());//delete old entries
					Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);//add new
					LectureseriesLocalServiceUtil.updateLectureseries(newLect);
					//update lectureseries
					LectureseriesLocalServiceUtil.updateOpenAccess(video, newLect);
					LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(newLect);
					
				}else{
					//update institution for video only without lecture series
					List<Video_Institution> vinst = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());
					ListIterator<Video_Institution> vinstItt = vinst.listIterator();
					while(vinstItt.hasNext()){
						Institution inst = InstitutionLocalServiceUtil.getById(vinstItt.next().getInstitutionId());
						Institution parent = InstitutionLocalServiceUtil.getById(inst.getParentId());
					}
				}
				//add category and term to tag cloud
				//category
				try{ctgr = CategoryLocalServiceUtil.getCategory(categoryId);}catch(Exception e){}			

				video.setTermId(termId);
				//and update categories in DB for video
				Video_CategoryLocalServiceUtil.removeByVideo(videoId);
				Video_Category vc = Video_CategoryLocalServiceUtil.createVideo_Category(0);
				vc.setVideoId(videoId);
				vc.setCategoryId(categoryId);
				if(categoryId>0)Video_CategoryLocalServiceUtil.addVideo_Category(vc);
				
				//update date and time for this video if changed 
				int compartion = VideoGenerationDateComparator.compare(video.getGenerationDate(), datetime);
				//override the video date_time stamp!
				if (compartion !=0)video.setGenerationDate(datetime);

				//set citation 
				video.setCitation2go(citationAllowed);
				//password
				video.setPassword(password);
				// update video
				VideoLocalServiceUtil.updateVideo(video);
				// refresh open access and previewVideoId for old lecture if lid > 0
				if(oldLs.getLectureseriesId()>0) {
					LectureseriesLocalServiceUtil.updateOpenAccess(video, oldLs);
					LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(oldLs);
				}
				
				//update lg_lectureseries_creators
				if(lId.longValue() != oldLsId.longValue())
				{
					try{
						if(lId>0)CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lId);
					}catch(SystemException e){}
					//
					try{
						if(oldLsId>0)CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(oldLsId);
					}catch(SystemException e){}
				}
				
			} catch (NumberFormatException e) {
				errors.add("METADATA_UPDATE_FAILED_1");
			} catch (SystemException e) {
				errors.add("METADATA_UPDATE_FAILED_2");
			} catch (PortalException e) {
				errors.add("METADATA_UPDATE_FAILED_3");
			}
			//metadata
			try {
				metadata.setTitle(title);
				metadata.setPublisher(publisher);
				metadata.setLanguage(language);
				MetadataLocalServiceUtil.updateMetadata(metadata);
			} catch (NumberFormatException e) {
				errors.add("METADATA_UPDATE_FAILED_4");
			} catch (SystemException e) {
				errors.add("METADATA_UPDATE_FAILED_5");
			}
			
			//update tag cloud for this video
			TagcloudLocalServiceUtil.generateForVideo(video.getVideoId());
			//update tag cloud for the lectureseries of this video
			TagcloudLocalServiceUtil.generateForLectureseries(video.getLectureseriesId());
			// update tag cloud for the old lectureseries of this video
			if(lId.longValue() != oldLsId.longValue()) TagcloudLocalServiceUtil.generateForLectureseries(oldLsId);
			
			
			//rebuild rss
			// generate RSS
			ProzessManager pm = new ProzessManager();
			for (String f: FileManager.MEDIA_FORMATS) {           
				try {
					pm.generateRSS(video, f);
				} catch (Exception e) {
					errors.add("METADATA_UPDATE_FAILED_6");
				} 
			}	 	    
	 	    //metadata end
	 	    
			//return errors cont result after update
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("errorsCount", errors.size());
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		/* this method is deprecated */
		if(resourceID.equals("updateMetadata")){
			
	 	    String title = ParamUtil.getString(resourceRequest, "title");
			String language = ParamUtil.getString(resourceRequest, "language");
			String tags = ParamUtil.getString(resourceRequest, "tags");
			String publisher = ParamUtil.getString(resourceRequest, "publisher");
			Long lId = ParamUtil.getLong(resourceRequest, "lectureseriesId");
			Long termId = ParamUtil.getLong(resourceRequest, "termId");
			Long categoryId = ParamUtil.getLong(resourceRequest, "categoryId");
			Integer citationAllowed = ParamUtil.getInteger(resourceRequest, "citationAllowedCheckbox");
	 	    String password = ParamUtil.getString(resourceRequest, "password");

			Lectureseries oldLs = LectureseriesLocalServiceUtil.createLectureseries(0);
			Long oldLsId = video.getLectureseriesId();
			try {
				oldLs = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
			} catch (PortalException e1) {
				//e1.printStackTrace();
			} catch (SystemException e1) {
				//e1.printStackTrace();
			}
			//search tags

			Lectureseries newLect = LectureseriesLocalServiceUtil.createLectureseries(0);
			Category ctgr = CategoryLocalServiceUtil.createCategory(0);
			//update data base
			try {
				video.setTitle(title);
				video.setLectureseriesId(lId);
				if(lId>0)video.setLectureseriesId(lId);
				else {
					java.util.Date date= new java.util.Date();
					video.setLectureseriesId(-date.getTime());
					//update table video_lectureseries
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());
				}
				video.setTags(tags);
				if(lId>0){
					newLect = LectureseriesLocalServiceUtil.getLectureseries(lId);
					//
					termId = newLect.getTermId();
					categoryId = newLect.getCategoryId();
					//update lg_video_institution table
					Video_InstitutionLocalServiceUtil.removeByVideoId(video.getVideoId());
					List<Lectureseries_Institution> li = Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lId);
					ListIterator<Lectureseries_Institution> l_i = li.listIterator();
					//institutions for video
					while(l_i.hasNext()){
						Institution in = InstitutionLocalServiceUtil.createInstitution(0);
						Lectureseries_Institution lectinst = l_i.next();
						in = InstitutionLocalServiceUtil.getInstitution(lectinst.getInstitutionId());
						Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
						vi.setVideoId(video.getVideoId());
						vi.setInstitutionId(lectinst.getInstitutionId());
						vi.setInstitutionParentId(in.getParentId());
						Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
					}
					//update lg_video_lectureseries 
					Video_Lectureseries vl = Video_LectureseriesLocalServiceUtil.createVideo_Lectureseries(0);
					vl.setVideoId(video.getVideoId());
					vl.setLectureseriesId(lId);
					vl.setOpenAccess(video.getOpenAccess());
					Video_LectureseriesLocalServiceUtil.removeByVideoId(video.getVideoId());//delete old entries
					Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(vl);//add new
					LectureseriesLocalServiceUtil.updateLectureseries(newLect);
					//update lectureseries
					LectureseriesLocalServiceUtil.updateOpenAccess(video, newLect);
					LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(newLect);
				}
				
				//add category and term to tag cloud
				//category
				try{ctgr = CategoryLocalServiceUtil.getCategory(categoryId);}catch(Exception e){}			
				video.setTermId(termId);
				//
				//and update categories in DB for video
				Video_CategoryLocalServiceUtil.removeByVideo(videoId);
				Video_Category vc = Video_CategoryLocalServiceUtil.createVideo_Category(0);
				vc.setVideoId(videoId);
				vc.setCategoryId(categoryId);
				if(categoryId>0)Video_CategoryLocalServiceUtil.addVideo_Category(vc);

				//update tag cloud for this video
				TagcloudLocalServiceUtil.generateForLectureseries(newLect.getLectureseriesId());

				//set citation 
				video.setCitation2go(citationAllowed);
				//password
				video.setPassword(password);
				// update video
				VideoLocalServiceUtil.updateVideo(video);
				// refresh open access and previewVideoId for old lecture if lid > 0
				if(oldLs.getLectureseriesId()>0) {
					LectureseriesLocalServiceUtil.updateOpenAccess(video, oldLs);
					LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(oldLs);
				}
				
				//update lg_lectureseries_creators
				if(lId.longValue() != oldLsId.longValue())
				{
					try{
						if(lId>0)CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lId);
					}catch(SystemException e){}
					
					try{
						if(oldLsId>0)CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(oldLsId);
					}catch(SystemException e){}
				}
				
			} catch (NumberFormatException e) {
				//System.out.println(e);
			} catch (SystemException e) {
				//System.out.println(e);
			} catch (PortalException e) {
				////e.printStackTrace();
			}
			//metadata
			try {
				metadata.setTitle(title);
				metadata.setPublisher(publisher);
				metadata.setLanguage(language);
				MetadataLocalServiceUtil.updateMetadata(metadata);
			} catch (NumberFormatException e) {
//				System.out.println(e);
			} catch (SystemException e) {
//				System.out.println(e);
			}
			//rebuild rss
			// generate RSS
			ProzessManager pm = new ProzessManager();
			for (String f: FileManager.MEDIA_FORMATS) {           
				try {
					pm.generateRSS(video, f);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} 
			}			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			//generate new JSON date for auto complete functionality
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(json.toString());
	        writer.flush();
	        writer.close();
		}

		if(resourceID.equals("videoUpdateGenerationDate")){
			String generationDate = ParamUtil.getString(resourceRequest, "generationDate");
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			video.setGenerationDate(generationDate);
			try {
				VideoLocalServiceUtil.updateVideo(video);
				jo.put("generationDate", generationDate);
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		if (resourceID.equals("handleVttUpload")) {
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			try {
				VideoLocalServiceUtil.createSymLinkForCaptionIfExisting(videoId);
				writeJSON(resourceRequest, resourceResponse, jo);
			} catch (Exception e) {
				
			}
		}

		if (resourceID.equals("updateHtaccess")) {
			try {
				Host host = HostLocalServiceUtil.getHost(video.getHostId());
				Producer producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
				String url = PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/";
				long producerId = video.getProducerId();
				List<Video> lockedVideosByProducer;
				lockedVideosByProducer = VideoLocalServiceUtil.getByProducerAndDownloadLink(producerId, 0);
				Htaccess.makeHtaccess(url, lockedVideosByProducer);
			} catch (Exception e) {
				// 
			} 
		}
		
		if(resourceID.equals("getJSONVideo")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("title", video.getTitle());
			jo.put("playerUris", video.getJsonPlayerUris());
			jo.put("thumbnail", video.getImage());
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("getJSONUploadedVideos")){
			JSONArray jarr = JSONFactoryUtil.createJSONArray();
			jarr = VideoLocalServiceUtil.getJSONVideo(videoId);
			//
			PrintWriter writer = resourceResponse.getWriter();
			writer.print(jarr.toString());
			writer.flush();
			writer.close();
		}

		if(resourceID.equals("updateNumberOfProductions")){
			Producer producer = ProducerLocalServiceUtil.createProducer(0);
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			try {
				producer = ProducerLocalServiceUtil.getProducer(video.getProducerId());
				// update uploads for producer
				int n = 0;
				n = VideoLocalServiceUtil.getByProducer(producer.getProducerId()).size();
				producer.setNumberOfProductions(n);
				jo.put("numberOfProductions", n);				
				ProducerLocalServiceUtil.updateProducer(producer);
			} catch (Exception e1) {
				jo.put("numberOfProductions", "-1");
			} 
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}

		if(resourceID.equals("videoUpdateFirstTitle")){
			String firsttitle = ParamUtil.getString(resourceRequest, "firsttitle");
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			video.setTitle(firsttitle);
			try {
				//VideoLocalServiceUtil.updateVideo(video);
				jo.put("firsttitle", firsttitle);
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
	    }
		
		if(resourceID.equals("getGenerationDate")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("generationDate", video.getGenerationDate());
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}

		if(resourceID.equals("getFileName")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			String fileName="";
			if(video.getFilename().length()>0)fileName=video.getFilename();
			jo.put("fileName", fileName);
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("getSecureFileName")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			String secureFileName="";
			if(video.getSecureFilename().length()>0)secureFileName=video.getSecureFilename();
			jo.put("secureFileName", secureFileName);
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}

		if(resourceID.equals("getShare")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			String url = "";
			if(video.getOpenAccess()==0)url=video.getSecureUrl();
			else url=video.getUrl();
			jo.put("commsyEmbed", video.getEmbedCommsy());
			jo.put("html5Embed", video.getEmbedHtml5());
			jo.put("iframeEmbed", video.getEmbedIframe());
			jo.put("url", url);
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}		
		
		if(resourceID.equals("videoFileNameExists")){
			String filename = ParamUtil.getString(resourceRequest, "fileName");
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			try {
				List<Video> vl = VideoLocalServiceUtil.getByFilename(filename); 
				if(vl.size()>0)jo.put("exist", "1");
				else jo.put("exist", "0");
			} catch (SystemException e) {
				jo.put("exist", "0");
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("updateDescription")){
			String description = ParamUtil.getString(resourceRequest, "description");
			metadata.setDescription(description);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			//
			try {
				MetadataLocalServiceUtil.updateMetadata(metadata);
				_log.info("DESCRIPTION_UPDATE_SUCCESS");
				json.put("access", 1);
			} catch (SystemException e) {
				_log.info("DESCRIPTION_UPDATE_FAILED");
				json.put("access", 0);
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(json.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("toggleSegmentation")){
			String segmentation = ParamUtil.getString(resourceRequest, "segmentationPermittedCheckbox");
			int sAllowed = new Integer(segmentation);
			if(sAllowed==0)video.setPermittedToSegment(0);
			else video.setPermittedToSegment(1);
			
			try {
				VideoLocalServiceUtil.updateVideo(video);
			} catch (SystemException e) {
				//
			}
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(json.toString());
	        writer.flush();
	        writer.close();
		}
		
		if (resourceID.equals("addSegment")) {
			String shortTitle = ParamUtil.getString(resourceRequest, "chortTitle");
			String timeStart = ParamUtil.getString(resourceRequest, "timeStart");
			String timeEnd = ParamUtil.getString(resourceRequest, "timeEnd");
			String text = ParamUtil.getString(resourceRequest, "text");
			JSONObject jo = JSONFactoryUtil.createJSONObject();

			if (!shortTitle.trim().equals("") && !timeStart.trim().equals("") && !timeEnd.trim().equals("")) {
				Segment segment = SegmentLocalServiceUtil.createSegment(0);
				segment.setVideoId(videoId);
				segment.setTitle(shortTitle);
				segment.setStart(timeStart);
				segment.setEnd(timeEnd);
				segment.setChapter(1);
				segment.setDescription(text);
				segment.setUserId(userId);
				//
				try {
					//add and save to json object
					Segment s = SegmentLocalServiceUtil.createSegment(segment);
					jo.put("chapter", s.getChapter());
					jo.put("description", s.getDescription());
					jo.put("end", s.getEnd());
					jo.put("image", s.getImage());
					jo.put("number", s.getNumber());
					jo.put("segmentId", s.getPrimaryKey());
					jo.put("seconds", s.getSeconds());
					jo.put("start", s.getStart());
					jo.put("title", s.getTitle());
					jo.put("userId", s.getUserId());
					jo.put("videoId", s.getVideoId());
					jo.put("previousSegmentId", SegmentLocalServiceUtil.getPreviusSegmentId(s.getSegmentId()));
				} catch (SystemException e) {
					//
				} catch (PortalException e) {
					//
				}
			}
			//update chapter file (vtt)
			updateVttChapterFile(video);
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}

		if(resourceID.equals("showSegments")){
			String vId = ParamUtil.getString(resourceRequest, "videoId");
			Long vID = new Long(vId);
			JSONArray ja = JSONFactoryUtil.createJSONArray();
			//get segments for video and convert to json array
			try {
				List<Segment> sl= SegmentLocalServiceUtil.getSegmentsByVideoId(vID);
				ListIterator<Segment> sIt = sl.listIterator();
				while(sIt.hasNext()){
					Segment s = sIt.next();
					JSONObject jo = JSONFactoryUtil.createJSONObject();
					jo.put("chapter", s.getChapter());
					jo.put("description", s.getDescription());
					jo.put("end", s.getEnd());
					jo.put("image", s.getImage());
					jo.put("number", s.getNumber());
					jo.put("segmentId", s.getPrimaryKey());
					jo.put("seconds", s.getSeconds());
					jo.put("start", s.getStart());
					jo.put("title", s.getTitle());
					jo.put("userId", s.getUserId());
					jo.put("videoId", s.getVideoId());
					jo.put("previousSegmentId", SegmentLocalServiceUtil.getPreviusSegmentId(s.getSegmentId()));
					ja.put(jo);
				}
				
			} catch (PortalException e) {
				//
			} catch (SystemException e) {
				//
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(ja.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("deleteSegment")){
			String sId = ParamUtil.getString(resourceRequest, "segmentId");
			Long sID = new Long(sId);
			//delete requested segment
			try {
				Segment s = SegmentLocalServiceUtil.removeSegment(sID);
				JSONObject jo = JSONFactoryUtil.createJSONObject();
				jo.put("chapter", s.getChapter());
				jo.put("description", s.getDescription());
				jo.put("end", s.getEnd());
				jo.put("image", s.getImage());
				jo.put("number", s.getNumber());
				jo.put("segmentId", s.getPrimaryKey());
				jo.put("seconds", s.getSeconds());
				jo.put("start", s.getStart());
				jo.put("title", s.getTitle());
				jo.put("userId", s.getUserId());
				jo.put("videoId", s.getVideoId());
				writeJSON(resourceRequest, resourceResponse, jo);
			} catch (SystemException e) {
				//
			} catch (PortalException e) {
				//
			}
			//update chapter file (vtt)
			updateVttChapterFile(video);
		}

		if(resourceID.equals("isFirstUpload")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			if(video.getFilename().isEmpty())jo.put("firstUpload", "1");
			else jo.put("firstUpload", "0");
			//
			PrintWriter writer = resourceResponse.getWriter();
			writer.print(jo.toString());
			writer.flush();
			writer.close();
		}
		
		if(resourceID.equals("defaultContainer")){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("containerFormat", video.getContainerFormat());
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jo.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("deleteFile")){
			String fileName = ParamUtil.getString(resourceRequest, "fileName");
			String mainContainerFormat = "";

			//delete file
			String fPath="";
			try {
				fPath = PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(video.getHostId()).getServerRoot()+"/"+ProducerLocalServiceUtil.getProducer(video.getProducerId()).getHomeDir()+"/";
				mainContainerFormat = VideoLocalServiceUtil.getVideo(videoId).getContainerFormat();
			} catch (PortalException e) {
				//e.printStackTrace();
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			JSONArray jarr = JSONFactoryUtil.createJSONArray();
			//delete all
			
			if(fileName.endsWith(mainContainerFormat)){
				//delete all file on disc 
				//but not from DB
				JSONArray jVids = VideoLocalServiceUtil.getJSONVideo(video.getVideoId());
				for (int i = 0; i < jVids.length(); i++) {
					JSONObject o = jVids.getJSONObject(i);
					String fs = (String) o.get("name");
					File f = new File(fPath+fs);
					if(f.delete()){
						o.put("fileId", fs.replace(".", ""));
					}else{
						o.put("fileId", "");
					}
					jarr.put(o);
				}
				ProzessManager pm = new ProzessManager();
				try {
					pm.deleteFilesImagesFromVideo(video);
				} catch (Exception e) {
					//e.printStackTrace();
				} 
			}else{
				JSONObject o = JSONFactoryUtil.createJSONObject();
					File f = new File(fPath+fileName);
					if(f.delete()){
						o.put("fileId", fileName.replace(".", ""));
					}else{
						o.put("fileId", "");
					}
					jarr.put(o);
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(jarr.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("getJSONCreator")){
			String creatorId = ParamUtil.getString(resourceRequest, "creatorId");
			Long cId = new Long(0);
			try{
				cId = new Long(creatorId);
			}catch(Exception e){
				//e.printStackTrace();
			}
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				json = CreatorLocalServiceUtil.getJSONCreatorObject(cId);
			} catch (PortalException e) {
				//e.printStackTrace();
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(json.toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("updateCreators")){
			String creators = ParamUtil.getString(resourceRequest, "creator");
			try {
				JSONArray creatorsArray = JSONFactoryUtil.createJSONArray(creators);
				//remove creators for video
				try {
					Video_CreatorLocalServiceUtil.deleteByVideoId(videoId);			
					//and update with new creators from list
					for (int i = 0; i< creatorsArray.length(); i++){
						JSONObject creator =  creatorsArray.getJSONObject(i);
						Long creatorId= creator.getLong("creatorId");
						String firstName = creator.getString("firstName");
						String lastName = creator.getString("lastName");
						String middleName = creator.getString("middleName");
						String jobTitle = creator.getString("jobTitle");
						String gender = creator.getString("gender");
						String fullName = creator.getString("fullName");
						
						Video_Creator vc = Video_CreatorLocalServiceUtil.createVideo_Creator(0);
						Long newCreatorId = new Long(0);
						//if creator exists in DB, just add to video
						if(creatorId>new Long(0)){
							newCreatorId = creatorId;
						}else{ 
							//if new creator doesn't exits in the creators DB (check by full name),
							//create a new one in DB and add to video
							List<Creator> cL = CreatorLocalServiceUtil.getByFullName(fullName);
							if(cL.size()==0){
								Creator c = CreatorLocalServiceUtil.createCreator(0);
								c.setFirstName(firstName);
								c.setLastName(lastName);
								c.setMiddleName(middleName);
								c.setJobTitle(jobTitle);
								c.setGender(gender);
								c.setFullName(fullName);
								newCreatorId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
							}else{
								newCreatorId = cL.listIterator().next().getCreatorId();
							}
						}
						vc.setCreatorId(newCreatorId);
						vc.setVideoId(videoId);
						List<Video_Creator> vcl = new ArrayList<Video_Creator>();
						vcl = Video_CreatorLocalServiceUtil.getByVideoCreator(videoId, newCreatorId);
						if(vcl.size()==0)Video_CreatorLocalServiceUtil.addVideo_Creator(vc);
					}
				} catch (SystemException e) {
					//e.printStackTrace();
				}
				//now update creators for the whole lecture series
				Long lId = video.getLectureseriesId();
				try{
					if(lId>0)CreatorLocalServiceUtil.updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lId);
				}catch(SystemException e){}
			} catch (JSONException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId).toString());
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("updateSubInstitutions")){
			String subInstitutions = ParamUtil.getString(resourceRequest, "subInstitution");
			try {
				JSONArray institutionsArray = JSONFactoryUtil.createJSONArray(subInstitutions);
				//remove sub-institutions for video
				try {
					Video_InstitutionLocalServiceUtil.removeByVideoId(videoId);
					//and update with new institutions from list
					if(institutionsArray.length()>0){
						for (int i = 0; i< institutionsArray.length(); i++){
							JSONObject institution =  institutionsArray.getJSONObject(i);
							Long institutionId= institution.getLong("institutionId");
							Institution in = InstitutionLocalServiceUtil.createInstitution(0);
							try {
								in = InstitutionLocalServiceUtil.getInstitution(institutionId);
							} catch (PortalException e) {
								//e.printStackTrace();
							}
							List<Video_Institution> vil = new ArrayList<Video_Institution>();
							vil = Video_InstitutionLocalServiceUtil.getByVideoAndInstitution(videoId, institutionId);
							
							Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
							vi.setInstitutionId(in.getInstitutionId());
							vi.setVideoId(videoId);
							if(in.getLevel()==1)vi.setInstitutionParentId(0);
							else vi.setInstitutionParentId(in.getParentId());
							if(vil.size()==0)Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
						}						
					}
				} catch (SystemException e) {
					//e.printStackTrace();
				}
			} catch (JSONException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId));
	        writer.flush();
	        writer.close();
		}
		
		if(resourceID.equals("updateupdateOpenAccessForLectureseries")){
			Lectureseries lect = LectureseriesLocalServiceUtil.createLectureseries(0);
			try {
				lect = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());
			} catch (PortalException e) {
				//e.printStackTrace();
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			try {
				LectureseriesLocalServiceUtil.updateOpenAccess(video, lect);
			} catch (SystemException e) {
				//e.printStackTrace();
			}
			//
			PrintWriter writer = resourceResponse.getWriter();
	        writer.print(CreatorLocalServiceUtil.getJSONCreatorsByVideoId(videoId));
	        writer.flush();
	        writer.close();
		}
		
	}
	
	public void removeVideo(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		Video video = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		try {video = VideoLocalServiceUtil.getVideo(reqVideoId);} catch (PortalException e1) {}
		ProzessManager pm = new ProzessManager();	
		pm.deleteVideo(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void lockVideo(ActionRequest request, ActionResponse response){
		Video video = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		try {video = VideoLocalServiceUtil.getVideo(reqVideoId);} catch (PortalException e1) {}
		ProzessManager pm = new ProzessManager();	
		//deactivate open access
		//and refresh lecture series with this video
		try {
			pm.deactivateOpenaccess(video);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void unlockVideo(ActionRequest request, ActionResponse response){
		Video video = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		try {video = VideoLocalServiceUtil.getVideo(reqVideoId);} catch (PortalException e1) {}
		//activate open access
		//and refresh lecture series with this video
		ProzessManager pm = new ProzessManager();	
		try {
			pm.activateOpenaccess(video);
		} catch (SystemException e) {
		} catch (PortalException e) {
		}
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void activateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.activateDownload(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void deactivateDownload(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Video video = VideoLocalServiceUtil.createVideo(0);
		Long reqVideoId = new Long(0);
		try{reqVideoId = new Long(request.getParameterMap().get("videoId")[0]);}catch(Exception e){}
		video = VideoLocalServiceUtil.getVideo(reqVideoId);
		ProzessManager pm = new ProzessManager();
		pm.deactivateDownload(video);
		String backURL = request.getParameter("backURL");
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	public void updateVttChapterFile(Video video){
		File vttDirectory = new File(PropsUtil.get("lecture2go.chapters.system.path"));
		String dateiName = vttDirectory + "/" + video.getVideoId()+".vtt";
		//get all segments
		List<Segment> sL = new ArrayList<Segment>();
		try {
			sL = SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId());
		} 
		catch (PortalException e) {} 
		catch (SystemException e) {}
		//
		ListIterator<Segment> sLi = sL.listIterator();
		String text="WEBVTT \n\n";
		while(sLi.hasNext()){
			Segment seg = sLi.next();
			text +=seg.getStart()+" --> "+seg.getEnd()+" \n";
			if(seg.getChapter()==1){
				text +=seg.getTitle()+" \n\n";
			}else{
				String desc="";
				if(seg.getDescription().trim().length()>0)desc = " ("+seg.getDescription().trim() + ")";
				text += seg.getTitle()+ desc + " \n\n";
			}
		}
		FileOutputStream s;
		try {
			s = new FileOutputStream(dateiName);
			for (int i = 0; i < text.length(); i++) {
				s.write((byte) text.charAt(i));
			}
			s.close();
		} 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
	}
	
	public void updateSegmentsForVideos(){
		try {
			List<Video> vl = VideoLocalServiceUtil.getAll();
			ListIterator<Video> vit = vl.listIterator();
			while(vit.hasNext()){
				Video v = VideoLocalServiceUtil.createVideo(0);
				try {v = VideoLocalServiceUtil.getVideo(vit.next().getVideoId());} catch (PortalException e) {}

				if(v.isHasChapters())updateVttChapterFile(v);
			}
		} catch (SystemException e) {
			//e.printStackTrace();
		}
	}
}