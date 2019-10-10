package de.uhh.l2g.plugins.admin.terms.portlet;

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

import de.uhh.l2g.plugins.admin.terms.constants.TermsManagementPortletKeys;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Terms",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + TermsManagementPortletKeys.TermsManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TermsManagementPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(TermsManagementPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Long termId = new Long(0);
		Term t = TermLocalServiceUtil.createTerm(0);
		//
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		try{
			try {
				termId = ParamUtil.getLong(renderRequest, "termId");
				t = TermLocalServiceUtil.getTerm(termId);
			} catch (Exception e) {}
			renderRequest.setAttribute("term", t);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}
		//show all
		catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}
	
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = ParamUtil.getString(request, "backURL");
		String y = ParamUtil.getString(request, "year");
		String p = ParamUtil.getString(request, "prefix");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		String languageId = user.getLanguageId();
		//	
		try {
			Term term = TermLocalServiceUtil.createTerm(0);
			term.setYear(y);
			term.setPrefix(p);
			//
			term.setLanguageId(languageId);
			term.setUserName(user.getScreenName());
			term.setUserId(userId);
			term.setCompanyId(companyId);
			term.setGroupId(groupId);
			//
			TermLocalServiceUtil.addTerm(term);
		} catch (Exception e) {
			_log.warn("Unable to add new term entry!");
			SessionErrors.add(request, e.getClass().getName());
		}	
		//
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = ParamUtil.getLong(request, "termId");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		String y = ParamUtil.getString(request, "year");
		String p = ParamUtil.getString(request, "prefix");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//
		try {
			Term term = TermLocalServiceUtil.getTerm(reqTermId);
			term.setYear(y);
			term.setPrefix(p);
			//
			term.setUserName(user.getScreenName());
			term.setUserId(userId);
			term.setCompanyId(companyId);
			term.setGroupId(groupId);
			term.setModifiedDate(new Date());
			//
			TermLocalServiceUtil.updateTerm(term);
		} catch (Exception e) {
			_log.warn("Unable to update category.");
			SessionErrors.add(request, e.getClass().getName());
		}
		
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqTermId = ParamUtil.getLong(request, "termId");
		String backURL  = ParamUtil.getString(request, "backURL");
		//Video_Term, Lecture_Term, Term
		TermLocalServiceUtil.deleteById(reqTermId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}