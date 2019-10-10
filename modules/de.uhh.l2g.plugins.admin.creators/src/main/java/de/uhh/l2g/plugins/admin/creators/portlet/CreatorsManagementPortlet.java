package de.uhh.l2g.plugins.admin.creators.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.creators.constants.CreatorsManagementPortletKeys;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Creators",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + CreatorsManagementPortletKeys.CreatorsManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CreatorsManagementPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(CreatorsManagementPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}

	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = ParamUtil.getString(request, "backURL");
		//
		String fn = ParamUtil.getString(request, "firstName");
		String mn = ParamUtil.getString(request, "middleName");
		String ln = ParamUtil.getString(request, "lastName");
		String t = ParamUtil.getString(request, "jobTitle");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//
		if (isValid(fn, ln)) {
			try {
				Creator creator = CreatorLocalServiceUtil.createCreator(0);
				creator.setFirstName(fn);
				creator.setMiddleName(mn);
				creator.setLastName(ln);
				creator.setJobTitle(t);
				creator.setFullName(fullName(fn, mn, ln, t));
				//
				creator.setCompanyId(companyId);
				creator.setGroupId(groupId);
				creator.setUserId(userId);
				creator.setUserName(user.getScreenName());
				//
				CreatorLocalServiceUtil.addCreator(creator);
			} catch (Exception e) {
				_log.warn("Unable to add new creator entry!");
				SessionErrors.add(request, e.getClass().getName());
			}	
			//
			try {
				response.sendRedirect(backURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String mvcPath = "";
		Long creatorId = new Long(0);
		Creator c = CreatorLocalServiceUtil.createCreator(0);
		//
		mvcPath = renderRequest.getParameter("mvcPath");
		String backURL = renderRequest.getParameter("backURL");
		try{
			try {
				creatorId = new Long(renderRequest.getParameter("creatorId"));
				c = CreatorLocalServiceUtil.getCreator(creatorId);
			} catch (Exception e) {}
			renderRequest.setAttribute("creator", c);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}
		//show all
		catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = ParamUtil.getLong(request, "creatorId");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		String fn = ParamUtil.getString(request, "firstName");
		String mn = ParamUtil.getString(request, "middleName");
		String ln = ParamUtil.getString(request, "lastName");
		String t = ParamUtil.getString(request, "jobTitle");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//		
		if (isValid(fn, ln)) {
			try {
				Creator creator = CreatorLocalServiceUtil.getCreator(reqCreatorId);
				creator.setFirstName(fn);
				creator.setMiddleName(mn);
				creator.setLastName(ln);
				creator.setJobTitle(t);
				creator.setFullName(fullName(fn, mn, ln, t));
				//
				creator.setCompanyId(companyId);
				creator.setGroupId(groupId);
				creator.setUserId(userId);
				creator.setUserName(user.getScreenName());
				creator.setModifiedDate(new Date());
				//
				CreatorLocalServiceUtil.updateCreator(creator);
			} catch (Exception e) {
				_log.warn("Unable to update creator entry!");
				SessionErrors.add(request, e.getClass().getName());
			}	
			//
		}else{
			_log.error("Edit failed. Not valid firs or last name!");
		}
		//redirect
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCreatorId = ParamUtil.getLong(request, "creatorId");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		//Video_Creator, Lecture_Creator, Creator
		CreatorLocalServiceUtil.deleteById(reqCreatorId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isValid(String fn, String ln) {
		String _fn = fn.trim();
		String _ln = ln.trim();
		return !"".equals(_fn) && !"".equals(_ln) && _fn.length() > 1 && _ln.length() > 1;
	}

	private String fullName(String fn, String mn, String ln, String t) {
		return (t.trim() + " " + (fn.trim() + " " + mn.trim()).trim() + " " + ln.trim()).trim();
	}
	

}