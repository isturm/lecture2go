package de.uhh.l2g.plugins.admin.institutions.portlet.render;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys;
import de.uhh.l2g.plugins.admin.institutions.portlet.AdminInstitutionManagementPortlet;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + AdminInstitutionManagementPortletKeys.AdminInstitutionManagement,
	    		"mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
)
public class ViewListMVCRenderCommand implements MVCRenderCommand {
	private static final Log _log = LogFactoryUtil.getLog(AdminInstitutionManagementPortlet.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Institution root = InstitutionLocalServiceUtil.getByParentId(0).iterator().next();
		List<Institution> institutionsList = (List<Institution>) renderRequest.getAttribute("institutionsList");
		institutionsList = InstitutionLocalServiceUtil.getByParentId(root.getInstitutionId());
		//
		PortletURL portletURL = renderResponse.createRenderURL();
		//Remote user
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try {
			remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); 
		} catch (Exception e1) {
			_log.error("user can't be fatched!");
		} 
		//
		Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(remoteUser);
		List<Host> hostList = HostLocalServiceUtil.getHosts(0, 100);
		
		renderRequest.setAttribute("root", root);
		renderRequest.setAttribute("institutionsList", institutionsList);	
		renderRequest.setAttribute("portletURL", portletURL);	
		renderRequest.setAttribute("hostList", hostList);	
		
		//permissions
		renderRequest.setAttribute("permissionAdmin", l2goRole.isL2gAdmin());				
		renderRequest.setAttribute("permissionProducer", l2goRole.isProducer());				
		renderRequest.setAttribute("permissionCoordinator", l2goRole.isCoordinator());
		
		return "/view.jsp"; 
	}

}
