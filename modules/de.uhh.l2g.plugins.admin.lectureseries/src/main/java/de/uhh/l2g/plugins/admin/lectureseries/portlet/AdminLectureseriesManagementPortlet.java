package de.uhh.l2g.plugins.admin.lectureseries.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
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

import de.uhh.l2g.plugins.admin.lectureseries.constants.AdminLectureseriesManagementPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.TagcloudLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.persistence.CreatorUtil;
import de.uhh.l2g.plugins.util.EmailManager;
import de.uhh.l2g.plugins.util.FileManager;
import de.uhh.l2g.plugins.util.Htaccess;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;
import de.uhh.l2g.plugins.util.ProzessManager;

/**
 * @author isturm
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Lectureseries",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.tmpl.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery-ui-1.10.3.custom.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/autocomplete-creator.js",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + AdminLectureseriesManagementPortletKeys.AdminLectureseriesManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminLectureseriesManagementPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AdminLectureseriesManagementPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		//get view
		String mvcPath = ParamUtil.getString(renderRequest,"mvcPath");
		String backURL = ParamUtil.getString(renderRequest,"backURL");
		//
		//Remote user
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try { remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); } catch (Exception e1) {
			_log.error("user can't be fatched!");
		} 
		//
		long reqLectureseriesId = ParamUtil.getLong(renderRequest, "lectureseriesId");
		Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(remoteUser);
		Long institutionId=new Long(0);
		Map<String,String> institutions = new LinkedHashMap<String, String>();
		List<Producer> producers = new ArrayList<Producer>();
		List<Long> pIds = new ArrayList<Long>();
		List<Category> categories = new ArrayList<Category>();
		Term term = TermLocalServiceUtil.createTerm(0);
		JSONArray allCreatorsJSON = JSONFactoryUtil.createJSONArray();
		List<Creator> creators = new ArrayList<Creator>();
		String assignedCreators = "";
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
		
		//lecture series  and depending objects
		switch (reqLectureseriesId+"") {
		case "0":
			pIds.add(new Long(0));
			break;
		default:
			//lecture series
			try { lectureseries = LectureseriesLocalServiceUtil.getLectureseries(reqLectureseriesId); } catch (Exception e) { _log.info("can not instatiate lecture series with id "+ reqLectureseriesId); }
			try { term = TermLocalServiceUtil.getById(lectureseries.getTermId()); }catch (Exception e){ _log.info("can not instatiate term with lecture series id " + reqLectureseriesId); }
			//institution id
			try{ institutionId = InstitutionLocalServiceUtil.getByLectureseriesId(lectureseries.getLectureseriesId(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS).iterator().next().getInstitutionId();}catch(Exception npe){ _log.info("can not instatiate institution with lecture series id " + reqLectureseriesId);}				
			//assigned creators
			assignedCreators = CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId(lectureseries.getLectureseriesId()).toString();
			//producer ids
			pIds = ProducerLocalServiceUtil.getAllProducerIds(reqLectureseriesId);
			break;
		}
		//
		// creators list as json array
		creators = CreatorLocalServiceUtil.getAll(); 
		ListIterator<Creator> it = creators.listIterator();
		while(it.hasNext()){
			Creator creator = CreatorUtil.create(0);
			creator = it.next();
			JSONObject c = JSONFactoryUtil.createJSONObject();
			//
			c.put("id", creator.getCreatorId());
			c.put("value", creator.getFullName());
			c.put("label", creator.getFullName());
			allCreatorsJSON.put(c);
		}
		// categories
		categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		// terms
		List<Term> terms = new ArrayList<Term>();
		terms = TermLocalServiceUtil.getAllSemesters(); 
		renderRequest.setAttribute("terms", terms);
		// institutions and producers
		if (l2goRole.isL2gAdmin()) {
			institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		}
		//
		if (l2goRole.isCoordinator()) {
			Coordinator c;
			try {
				c = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId());
				if (institutionId == 0) institutionId = c.getInstitutionId();
				institutions = InstitutionLocalServiceUtil.getByParent(c.getInstitutionId());
				producers = ProducerLocalServiceUtil.getProducersByInstitutionId(c.getInstitutionId());
			} catch (Exception e) {
				_log.info("can not instatiate coordinator from remote user with id " + remoteUser.getUserId());
			}
		}
		//
		if (l2goRole.isProducer()) {
			Producer p;
			try {
				p = ProducerLocalServiceUtil.getProdUcer(remoteUser.getUserId());
				if (institutionId == 0) institutionId = p.getInstitutionId();
				institutions = InstitutionLocalServiceUtil.getByParent(p.getInstitutionId());
			} catch (Exception e) {
				_log.info("can not instantiate producer from remote user with id " + remoteUser.getUserId());
			}
		}
		//
		renderRequest.setAttribute("producerIds", pIds);
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute("term", term);
		renderRequest.setAttribute("institutionId", institutionId);
		renderRequest.setAttribute("lectureseries", lectureseries);
		renderRequest.setAttribute("allCreators", allCreatorsJSON);
		renderRequest.setAttribute("assignedCreators", assignedCreators);
		//
		renderRequest.setAttribute("institutions", institutions);
		renderRequest.setAttribute("producers", producers);
		renderRequest.setAttribute("backURL", backURL);
		//permissions
		renderRequest.setAttribute("permissionAdmin", l2goRole.isL2gAdmin());				
		renderRequest.setAttribute("permissionProducer", l2goRole.isProducer());				
		renderRequest.setAttribute("permissionCoordinator", l2goRole.isCoordinator());		
		//
		renderResponse.setProperty("jspPage", mvcPath);
		super.render(renderRequest, renderResponse);
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Long lId = new Long(ParamUtil.getString(request,"lectureseriesId"));
		String backURL = ParamUtil.getString(request,"backURL");
		//remove lecture series
		try {
			LectureseriesLocalServiceUtil.deleteLectureseries(lId);
			//dependencies
			Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lId);//institution
			Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//producer
			VideoLocalServiceUtil.unlinkLectureseriesFromVideos(lId);//video
			Video_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);//video links to lecture series
			TagcloudLocalServiceUtil.deleteByObjectId(lId);//tag cloud
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		//generate new JSON date for auto complete functionality
	}

	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//	
		EmailManager em = new EmailManager();
		//search tags
//		ArrayList<String> tagCloudArrayString = new ArrayList<String>();

		Long lId = new Long(ParamUtil.getString(request,"lectureseriesId"));
		String[] producers = ParamUtil.getParameterValues(request, "producers");
		
		String[] institutions = ParamUtil.getParameterValues(request, "institutions");
		String s = ParamUtil.getString(request,"longDesc");
		String backURL = ParamUtil.getString(request,"backURL");
		Long termId = new Long(0);
		try{
			termId = ParamUtil.getLong(request, "termId");
			Term t = TermLocalServiceUtil.getTerm(termId);
//			tagCloudArrayString.add(t.getPrefix());
//			tagCloudArrayString.add(t.getYear());
//			tagCloudArrayString.add(t.getPrefix());
//			tagCloudArrayString.add(t.getPrefix()+" "+t.getYear());
		}catch(Exception e){}
		Long categoryId = new Long(0);
		try{
			categoryId = ParamUtil.getLong(request,"categoryId");
		}catch(Exception e){}
		Integer videoSort = new Integer(0);
		try{
			videoSort = "1".equals(ParamUtil.getString(request, "videoSort")) ? new Integer(1) : videoSort;
		}catch(Exception e){}

		Locale locale = request.getLocale(); 

		//update object
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.getLectureseries(lId);
		//only for admin or coordinator can update this flag
		if(new Lecture2GoRoleChecker().isCoordinator(user) || new Lecture2GoRoleChecker().isL2gAdmin(user)){
			lectureseries.setApproved(1);
		}
		// If no lectureseries number is set, the default-number 00.000 will be set
		lectureseries.setNumber("".equals(ParamUtil.getString(request, "number")) ? LanguageUtil.get(locale, "lecture-series-default-number"):ParamUtil.getString(request, "number"));
		//update categoryId
		lectureseries.setCategoryId(categoryId);
		//and all linked objects to this category over the lecture series object
		LectureseriesLocalServiceUtil.updateCategoryForLectureseries(lectureseries.getLectureseriesId(), categoryId);
		lectureseries.setName(ParamUtil.getString(request, "name"));
		lectureseries.setShortDesc(ParamUtil.getString(request, "shortDesc"));
		lectureseries.setTermId(termId);
		lectureseries.setLanguage(ParamUtil.getString(request, "language"));
		lectureseries.setFacultyName(ParamUtil.getString(request, "facultyName"));
		lectureseries.setPassword(ParamUtil.getString(request, "password"));
		lectureseries.setLongDesc(s);	
		lectureseries.setVideoSort(videoSort);
		//
		lectureseries.setCompanyId(companyId);
		lectureseries.setGroupId(groupId);
		lectureseries.setUserId(userId);
		lectureseries.setUserName(user.getScreenName());
		lectureseries.setModifiedDate(new Date());
		//		
		//update database
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		//update previewVideoId
		LectureseriesLocalServiceUtil.updatePreviewVideoOpenAccess(lectureseries);
		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//update institution link
		//delete old entries first
		Lectureseries_InstitutionLocalServiceUtil.removeByLectureseriesId(lectureseries.getLectureseriesId());
		//new links to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_Institution lf = Lectureseries_InstitutionLocalServiceUtil.createLectureseries_Institution(0);
			lf.setLectureseriesId(lId);
			Institution parentInst = InstitutionLocalServiceUtil.createInstitution(0);
			Institution inst = InstitutionLocalServiceUtil.createInstitution(0);
			inst = InstitutionLocalServiceUtil.getById(new Long(institutions[i]));
			parentInst = InstitutionLocalServiceUtil.getById(inst.getParentId());
			lf.setInstitutionId(inst.getInstitutionId());
			lf.setInstitutionParentId(inst.getParentId());
			if(!Lectureseries_InstitutionLocalServiceUtil.institutionAssignedToLectureseries(lf))
				Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
			//
//			tagCloudArrayString.add(inst.getName());
//			tagCloudArrayString.add(parentInst.getName());
		}
		
		// get all videos of this lectureSeries 
		List<Video> videosByLectureseries = VideoLocalServiceUtil.getByLectureseries(lId);
		for (int i = 0; i < videosByLectureseries.size(); i++) {
			Video video = videosByLectureseries.get(i);

			// Update table LG_Video_Institution
			Video_InstitutionLocalServiceUtil.removeByVideoId(video.getVideoId()); // Delete old entries
			for (int j = 0; j < institutions.length; j++) {
				Institution inst = InstitutionLocalServiceUtil.createInstitution(0);
				inst = InstitutionLocalServiceUtil.getById(new Long(institutions[j]));
				Video_Institution vi = Video_InstitutionLocalServiceUtil.createVideo_Institution(0);
				vi.setVideoId(video.getVideoId());
				vi.setInstitutionId(inst.getInstitutionId());
				vi.setInstitutionParentId(inst.getParentId());
				Video_InstitutionLocalServiceUtil.addVideo_Institution(vi);
			}

			// update column termId in lg_video table
			Long videoTermId = video.getTermId();
			if (termId.longValue() != videoTermId.longValue()) {
				video.setTermId(termId);
				VideoLocalServiceUtil.updateVideo(video);
			}
		}
		
		//update producer link
		//delete old entries first
		Producer_LectureseriesLocalServiceUtil.removeByLectureseriesId(lId);
		//new links to producer
		for(int i=0;i<producers.length;i++){
			Producer_Lectureseries pl = Producer_LectureseriesLocalServiceUtil.createProducer_Lectureseries(0);
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			//producer not assigned to lecture series yet
			if(!Producer_LectureseriesLocalServiceUtil.producerAssignedToLectureseries(pl))
				Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}	
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//update tag cloud
		TagcloudLocalServiceUtil.generateForLectureseries(lectureseries.getLectureseriesId());

		//email notification after edit

		//send an email to all producer, if logged in as coordinator or admin
		//and lecture serice edited
		if(new Lecture2GoRoleChecker().isCoordinator(user) || new Lecture2GoRoleChecker().isL2gAdmin(user) ){
			List<Long> pIds = ProducerLocalServiceUtil.getAllProducerIds(lectureseries.getLectureseriesId());
			java.util.ListIterator<Long> itt=  pIds.listIterator();
			while(itt.hasNext()){
				String pId= itt.next()+"";
				Long pIdL=new Long(pId);
				Producer pr = ProducerLocalServiceUtil.getProdUcer(pIdL);
				String PRODEMAILADDRESS = pr.getEmailAddress();
				// Subject
				String SUBJECT = LanguageUtil.get(locale, "lecture-series-edited-and-allowed");
				String BODY = user.getFirstName() + " " + user.getLastName()+ " " + LanguageUtil.get(locale, "edited-and-allowed-lecture-series") + " \n" + LanguageUtil.get(locale, "lecture-series") +":" + lectureseries.getNumber() + ": " + lectureseries.getName();
				// Send mail to producer
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PRODEMAILADDRESS , SUBJECT, BODY);
			}
		}	
	}

	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//		
		EmailManager em = new EmailManager();
		//search tags
		
		String s = ParamUtil.getString(request, "longDesc");
		String[] producers = ParamUtil.getParameterValues(request, "producers");
		String[] institutions = ParamUtil.getParameterValues(request, "institutions");
		String backURL = ParamUtil.getString(request, "backURL");
		Long termId = new Long(0);
		try{
			termId = ParamUtil.getLong(request, "termId");
		}catch(Exception e){}
		Long categoryId = new Long(0);
		try{
			categoryId = ParamUtil.getLong(request, "categoryId");
		}catch(Exception e){}
		Integer videoSort = new Integer(0);
		try{
			videoSort = "1".equals(ParamUtil.getString(request, "videoSort")) ? new Integer(1) : videoSort;
		}catch(Exception e){}
		
		Locale locale = request.getLocale(); 
		
		//build lecture series object
		Lectureseries lectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
		lectureseries.setApproved(0);
		// If no lectureseries number is set, the default-number 00.000 will be set
		lectureseries.setNumber("".equals(ParamUtil.getString(request, "number")) ? LanguageUtil.get(locale, "lecture-series-default-number"):ParamUtil.getString(request, "number"));
		lectureseries.setCategoryId(categoryId);
		lectureseries.setName(ParamUtil.getString(request, "name"));
		lectureseries.setShortDesc(ParamUtil.getString(request, "shortDesc"));
		lectureseries.setTermId(termId);
		lectureseries.setLanguage(ParamUtil.getString(request, "language"));
		lectureseries.setFacultyName(ParamUtil.getString(request, "facultyName"));
		lectureseries.setPassword(ParamUtil.getString(request, "password"));
		lectureseries.setLongDesc(s);
		lectureseries.setVideoSort(videoSort);
		
		//add an USID
		lectureseries.setUSID(RandomStringUtils.random(11, true, true));
		//
		lectureseries.setCompanyId(companyId);
		lectureseries.setGroupId(groupId);
		lectureseries.setUserId(userId);
		lectureseries.setUserName(user.getScreenName());
		//		
		//save object to database
		Lectureseries newlect = LectureseriesLocalServiceUtil.addLectureseries(lectureseries);
		//add to Lectureseries_Category table
		Lectureseries_Category lcat = Lectureseries_CategoryLocalServiceUtil.createLectureseries_Category(0);
		lcat.setLectureseriesId(newlect.getLectureseriesId());
		lcat.setCategoryId(newlect.getCategoryId());
		Lectureseries_CategoryLocalServiceUtil.addLectureseries_Category(lcat);
		//
		Long lId = newlect.getLectureseriesId();

		//refresh htaccess authentication files 
		Htaccess.writePW(LectureseriesLocalServiceUtil.getAllLectureseriesWhithPassword());
		
		//link to institution
		for(int i=0;i<institutions.length;i++){
			Lectureseries_Institution lf = Lectureseries_InstitutionLocalServiceUtil.createLectureseries_Institution(0);
			lf.setLectureseriesId(lId);
			Institution parentInst = InstitutionLocalServiceUtil.createInstitution(0);
			Institution inst = InstitutionLocalServiceUtil.createInstitution(0);
			inst = InstitutionLocalServiceUtil.getById(new Long(institutions[i]));
			parentInst = InstitutionLocalServiceUtil.getById(inst.getParentId());
			
			lf.setInstitutionId(inst.getInstitutionId());
			lf.setInstitutionParentId(inst.getParentId());
			Lectureseries_InstitutionLocalServiceUtil.addLectureseries_Institution(lf);
		}

		//new creators
		String[] firstNames = ParamUtil.getParameterValues(request, "firstName");
		String[] lastNames = ParamUtil.getParameterValues(request, "lastName");
		String[] jobTitles = ParamUtil.getParameterValues(request, "jobTitle");
		String[] genders = ParamUtil.getParameterValues(request, "gender");
		String[] creatorIds = ParamUtil.getParameterValues(request, "creatorId");
		Long cId = new Long(0);
		//remove all creators for this lecture series first
		Lectureseries_CreatorLocalServiceUtil.removeByLectureseriesId(lId);
		//and add the new creators
		try{
			for(int i=0;i<creatorIds.length;i++){
				if(creatorIds[i].equals("0")){
					Creator c = CreatorLocalServiceUtil.createCreator(0);
					c.setFirstName(firstNames[i]);
					c.setLastName(lastNames[i]);
					c.setJobTitle(jobTitles[i]);
					c.setGender(genders[i]);
					c.setFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					List<Creator> cl = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]);
					if(cl.size()==0)cId = CreatorLocalServiceUtil.addCreator(c).getCreatorId();
					else cId = CreatorLocalServiceUtil.getByFullName(jobTitles[i]+" "+firstNames[i]+" "+lastNames[i]).iterator().next().getCreatorId();
				}else{
					cId = new Long(creatorIds[i]);
				}
				//add created creator to lecture series
				Lectureseries_Creator lc = Lectureseries_CreatorLocalServiceUtil.createLectureseries_Creator(0);
				lc.setLectureseriesId(lId);
				lc.setCreatorId(cId);
				if(Lectureseries_CreatorLocalServiceUtil.getByLectureseriesIdAndCreatorId(lId, cId).size()==0){
					Lectureseries_CreatorLocalServiceUtil.addLectureseries_Creator(lc);
				}
				
			}
		}catch (NullPointerException e){}
		//link to producer
		for(int i=0;i<producers.length;i++){
			Producer_Lectureseries pl = Producer_LectureseriesLocalServiceUtil.createProducer_Lectureseries(0);
			pl.setProducerId(new Long(producers[i]));
			pl.setLectureseriesId(lId);
			Producer_LectureseriesLocalServiceUtil.addProducer_Lectureseries(pl);
		}
		
		//Tag cloud
		TagcloudLocalServiceUtil.generateForLectureseries(newlect.getLectureseriesId());
		
		//
		request.setAttribute("institutions", institutions);
		request.setAttribute("producers", producers);
		request.setAttribute("backURL", backURL);
		//send an email to coordinator and administrator, if logged in as producer
		if(new Lecture2GoRoleChecker().isProducer(user)){
			//get producer details
			Producer p = ProducerLocalServiceUtil.createProducer(0);
			p = ProducerLocalServiceUtil.getProdUcer(user.getUserId());//full object "getProdUser()"
			Coordinator c = CoordinatorLocalServiceUtil.createCoordinator(0);
			// Subject
			String SUBJECT = LanguageUtil.get(locale, "new-request-for-approval") ;
			String BODY = LanguageUtil.get(locale, "you-have-a-new-request-for-approval") + " \n" + LanguageUtil.get(locale, "lecture-series") + " : " + newlect.getNumber() + ": " + newlect.getName();
			//if coordinator exists
			boolean coordExists = false;
			// Coordinator for this Producer
			try{
				c = CoordinatorLocalServiceUtil.getByInstitution(p.getInstitutionId());
				if(c.getCoordinatorId()>0)coordExists = true;
			}catch(NoSuchElementException e){}
			//check 
			if(coordExists){
				String COORDEMAILADDRESS = c.getEmailAddress();				
				String BODY2 =  LanguageUtil.get(locale, "coordinator") + " " + c.getFirstName() + " " + c.getLastName() + " " + LanguageUtil.get(locale, "got-a-new-request-for-approval") + "  \n" + LanguageUtil.get(locale, "lecture-series") + ": "  +newlect.getNumber() + ": " + newlect.getName();
				// Send mail to Coordinator
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), COORDEMAILADDRESS, SUBJECT, BODY);
				// Send mail to L2Go
				em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address"), SUBJECT, BODY2);
			}
			// Send mail to Producer
			String PRODEMAILADDRESS = p.getEmailAddress();
			String BODY3 = LanguageUtil.get(locale, "your-request-was-sent") +"  \n" + LanguageUtil.get(locale, "lecture-series") +" :" + newlect.getNumber() + ": " + newlect.getName();
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PRODEMAILADDRESS, SUBJECT, BODY3);
		}	

		//send an email to  administrator, if logged in as coordinator
		if(new Lecture2GoRoleChecker().isCoordinator(user)){
			//get coordinator details
			Coordinator c = CoordinatorLocalServiceUtil.createCoordinator(0);
			c = CoordinatorLocalServiceUtil.getById(user.getUserId());
			// Subject
			String SUBJECT = LanguageUtil.get(locale, "new-lectureseries");
			String BODY = LanguageUtil.get(locale, "coordinator") +" "+ c.getFirstName() + " " + c.getLastName()+ " " + LanguageUtil.get(locale, "has-entered-a-new-lecture-series") + " \n" + LanguageUtil.get(locale, "lecture-series") +":" + newlect.getNumber() + ": " + newlect.getName();
			// Send mail to L2Go
			em.sendEmail(PropsUtil.get("lecture2go.response.email.address"), PropsUtil.get("lecture2go.response.email.address")  , SUBJECT, BODY);
		}	
		
	}
	
	public void generateRSSforAllLectureseriesWhithOpenaccessVideos(){
		List<Lectureseries> allLect = LectureseriesLocalServiceUtil.getAllLectureseriesWhithOpenaccessVideos();
		Iterator<Lectureseries> ittLect = allLect.iterator();
		Log LOG = LogFactoryUtil.getLog(AdminLectureseriesManagementPortlet.class.getName());	
		int a = 1;
		while(ittLect.hasNext()){
			Lectureseries l = ittLect.next();
			Video v;
			try {
				v = VideoLocalServiceUtil.getVideo(l.getLatestOpenAccessVideoId());
				// generate RSS
				LOG.info("Generate RSS" +a+" fol lecture series with ID: "+l.getLectureseriesId()+" and latest open access video with ID: "+v.getVideoId());
				ProzessManager pm = new ProzessManager();
				for (String f: FileManager.MEDIA_FORMATS) {           
					try {
						pm.generateRSS(v, f);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}		
				LOG.info("RSS "+a+" generated");
				a++;
			} catch (PortalException e1) {
				LOG.info("Can't get video with id "+l.getLatestOpenAccessVideoId());
			}
		}
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String resourceID = resourceRequest.getResourceID();
		
		if(resourceID.equals("getJSONCreator")){
			String creatorId = ParamUtil.getString(resourceRequest, "creatorId");
			Long cId = new Long(0);
			try{
				cId = new Long(creatorId);
			}catch(Exception e){
				e.printStackTrace();
			}
			JSONArray json = JSONFactoryUtil.createJSONArray();
			try {
				json = CreatorLocalServiceUtil.getJSONCreatorArray(cId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			writeJSON(resourceRequest, resourceResponse, json);			
		}
		
		if(resourceID.equals("updateCreators")){
			/* TODO: to be filled */
		}

	}	
}