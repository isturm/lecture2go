package de.uhh.l2g.plugins.guest.videos.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.util.ProzessManager;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS,
	    		"mvc.command.name=/view/render/details"
	    },
	    service = MVCRenderCommand.class
)
public class ViewRenderDetails implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String objectType = ParamUtil.getString(renderRequest, "objectType");
		String password = ParamUtil.getString(renderRequest, "password");
		boolean objectExists = true;
		
		Long objectId = new Long(0);
		boolean secLink = false;
	   	String oid = ParamUtil.getString(renderRequest, "objectId");
		
	    try{
	    	objectId = new Long(oid);
	    }catch(NumberFormatException e){
		    if(objectType.equals("v")){ //for video objects
	    		try {
					objectId = VideoLocalServiceUtil.getBySecureUrl(oid).getVideoId();		
					secLink = true;
				} catch (NoSuchVideoException e1) {
				} catch (SystemException e1) {}
	    	 }
		    if(objectType.equals("l")){ //for lecture series objects
		    	objectId = LectureseriesLocalServiceUtil.getByUSID(oid).getLectureseriesId();
				secLink = true;
		    }
	    }

	    Long timeStart = new Long(0);
	    Long timeEnd = new Long(0);
	    
	    try{
	    	timeStart = new Long(ParamUtil.getString(renderRequest, "timeStart"));
	    	timeEnd = new Long(ParamUtil.getString(renderRequest, "timeEnd"));
	    }catch(Exception e){}
	   
	    Video video = VideoLocalServiceUtil.createVideo(0);
	    //lecture series object
	    Lectureseries lectureseries = LectureseriesLocalServiceUtil.createLectureseries(0);
	    
	    //Lecture series
	    if(objectType.equals("l")){
	    	try{
	    		lectureseries = LectureseriesLocalServiceUtil.getLectureseries(objectId);
	    		if(!secLink){
	    			try {
	    				video = VideoLocalServiceUtil.getVideo(lectureseries.getPreviewVideoId());
	    			} catch (PortalException e1) {}
	    		}else{
	    			Long videoId = VideoLocalServiceUtil.getLatestClosedAccessVideoId(objectId);
	    			try {video = VideoLocalServiceUtil.getVideo(videoId);} catch (PortalException e1) {}
	    		}
	    	}catch(Exception e){ 
	    		objectExists = false;
	    		//response.setRenderParameter("jspPage","/noVideosFound.jsp");	
	    	}
	    }else if(objectType.equals("v")){
			try {video = VideoLocalServiceUtil.getVideo(objectId);} catch (PortalException e1) {}
	    	if(video.getVideoId()==0)objectExists=false;
	    	try{lectureseries = LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId());}catch (Exception e){}
	    }
	    if(objectExists){
	    	// create symlink to downloadable file if not existing
	    	VideoLocalServiceUtil.createSymLinkToDownloadableFileIfNotExisting(video.getVideoId());

			/* 
			   generate symbolic links in the download folder if the download is enabled and symbolic links are not yet existing. 
	    	   we currently check this on every video page view, as there may be files generated in the file system (like a generation of a mp3 by the postprocessing engine ) which 
	    	   do not trigger an event in lecture2go, so it could be handled there
	    	*/
			if (video.getDownloadLink()==1) {
				ProzessManager pm = new ProzessManager();
				pm.generateSymbolicLinks(video);
			}
			
	    	List<Video> relatedVideos = new ArrayList<Video>();
		    //related videos by lectureseries id
	    	try {
	    		int os = 0;
	    		if(video.getOpenAccess()==1)os=1;
				relatedVideos = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(),os);
			} catch (SystemException e) {}
		    
		    //chapters and segments
		    List<Segment> segments= new ArrayList<Segment>();
			try {
				segments = SegmentLocalServiceUtil.getSegmentsByVideoId(objectId);
			} catch (PortalException e) {
			} catch (SystemException e) {}
		    
		    //lectureseries for video
		    List<Video_Lectureseries> vl = new ArrayList<Video_Lectureseries>();
		    try {
				vl = Video_LectureseriesLocalServiceUtil.getByVideo(video.getVideoId());
			} catch (Exception e) {}
		    
		    //institutions for video
		    List<Video_Institution> vi = new ArrayList<Video_Institution>();
		    vi = Video_InstitutionLocalServiceUtil.getByVideo(video.getVideoId());
		    
		    //metadata for video
		    Metadata m = MetadataLocalServiceUtil.createMetadata(0);
		    try {
				m = MetadataLocalServiceUtil.getMetadata(video.getMetadataId());
			} catch (PortalException e) {
			} catch (SystemException e) {}
		    
		    //update video hits
		    Long hits = video.getHits();
		    hits = hits+1;
		    video.setHits(hits);
		    try {
				VideoLocalServiceUtil.updateVideo(video);
			} catch (SystemException e) {}
		    
		    //check password access
		    if(secLink==false){
		    	if(video.getOpenAccess()==1) video.setAccessPermitted(1);
		    	else video.setAccessPermitted(2);
		    }else{
		    	//access denied by default
		    	video.setAccessPermitted(0);
		    	
	    		//1. authentication by lecture series password
				try{
			    	if(password.equals(lectureseries.getPassword()))video.setAccessPermitted(1);
		   			else video.setAccessPermitted(0);				
				}catch(Exception e){}

	   			
	    		//2. authentication by cookie
				Cookie[] c = renderRequest.getCookies();
				try{
					for(int i=0; i<c.length;i++){
						Cookie coo = c[i];
						String cooVal ="";
						if(coo.getName().equals("L2G_LSID"))cooVal=c[i].getValue();
						//has been already logged in
						if(cooVal.equals(video.getLectureseriesId()+"")){
							video.setAccessPermitted(1);
						}
					}
				}catch(java.lang.NullPointerException e){
					System.out.print(e);
				}
	    		
	    		//3. authentication by video password
	    		if(!video.getPassword().isEmpty()){
	    			try{
	        			if(password.equals(video.getPassword())){
	        				video.setAccessPermitted(1);
	        			}else{
	        				video.setAccessPermitted(0);
	        			}   				
	    			}catch(Exception e){ 
	    				video.setAccessPermitted(0);
	    			}
	    		}
	    	}
		    
		    renderRequest.setAttribute("videoMetadata",m);
		    renderRequest.setAttribute("videoInstitutions",vi);
		    renderRequest.setAttribute("videoLectureseries",vl);
		    renderRequest.setAttribute("video",video);
		    renderRequest.setAttribute("relatedVideos",relatedVideos);
		    renderRequest.setAttribute("segments",segments);
		    renderRequest.setAttribute("lectureseries",lectureseries);
		    renderRequest.setAttribute("timeStart",timeStart);
		    renderRequest.setAttribute("timeEnd",timeEnd);
		    renderRequest.setAttribute("objectType",objectType);
		    renderRequest.setAttribute("objectId",oid);
	    }
	    
		return "/viewDetails.jsp"; 
	}

}
