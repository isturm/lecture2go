package de.uhh.l2g.plugins.admin.streaming.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.admin.streaming.constants.StreamerManagementPortletKeys;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;
import de.uhh.l2g.plugins.util.RepositoryManager;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Streaming",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + StreamerManagementPortletKeys.StreamerManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StreamerManagementPortlet extends MVCPortlet {
	protected static Log _log = LogFactoryUtil.getLog(StreamerManagementPortlet.class.getName());
	public static final String DEFAULT_STREAMER = "Default";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		//
		//Remote user
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try { remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); } catch (Exception e1) {
			_log.error("user can't be fatched!");
		} 
		//
		Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(remoteUser);		
		//permissions
		renderRequest.setAttribute("permissionAdmin", l2goRole.isL2gAdmin());				
		renderRequest.setAttribute("permissionProducer", l2goRole.isProducer());				
		renderRequest.setAttribute("permissionCoordinator", l2goRole.isCoordinator());	
		
		Long hostId = new Long(0);
		try{
			Host h = HostLocalServiceUtil.createHost(0);
			try {
				hostId = new Long(renderRequest.getParameter("hostId"));
				h = HostLocalServiceUtil.getHost(hostId);
			}catch (Exception e) {}
			renderRequest.setAttribute("host", h);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}
		//show all
		catch (Exception e) {}
		super.render(renderRequest, renderResponse);
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long reqHostId = ParamUtil.getLong(request, "hostId");
		String backURL = ParamUtil.getString(request, "backURL");
        //
		String protocol = ParamUtil.getString(request, "protocol");
		String streamer = ParamUtil.getString(request, "streamer");
		int port = ParamUtil.getInteger(request, "port");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//
		try {
			Host host = HostLocalServiceUtil.getHost(reqHostId);
			host.setProtocol(protocol);
			host.setStreamer(streamer);
			host.setPort(port);
			//
			host.setUserId(userId);
			host.setUserName(user.getScreenName());
			host.setCompanyId(companyId);
			host.setGroupId(groupId);
			//
			HostLocalServiceUtil.updateHost(host);
		} catch (Exception e) {
			_log.error("Unable to update host.");
			SessionErrors.add(request, e.getClass().getName());
		}
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(ActionRequest request, ActionResponse response) {
		Long hostId = ParamUtil.getLong(request, "hostId");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		_log.info("Trying to remove " + hostId);
		try {
			if (hostId > 0) HostLocalServiceUtil.deleteHost(hostId);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			_log.error("Failed deleting Streaming Server", e);
		}
		//
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void add(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		String hostName = "";
		String streamer = ParamUtil.getString(request, "streamer");
		String protocol = ParamUtil.getString(request, "protocol");
		int port = ParamUtil.getInteger(request, "port");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		//
		_log.info("Trying to add " + hostName + ": " + streamer);
		try {
			Host host = HostLocalServiceUtil.createHost(0);
			host.setProtocol(protocol);
			host.setPort(port);
			host.setStreamer(streamer);
			//
			host.setUserId(userId);
			host.setUserName(user.getScreenName());
			host.setCompanyId(companyId);
			host.setGroupId(groupId);
			host = HostLocalServiceUtil.addHost(host);
			// update server root
			host.setServerRoot(RepositoryManager.prepareServerRoot(host.getHostId()));
			host.setName(RepositoryManager.prepareServerRoot(host.getHostId()));
			HostLocalServiceUtil.updateHost(host);
			// Create Directory
			try {
				RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			_log.error("Failed adding Streaming Server", e);
		}
		//
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTreeRoot(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Institution.class.getName(), request);
		String institutionName = ParamUtil.getString(request, "treeRoot");
		long institutionId = ParamUtil.getLong(request, "treeRootId");
		_log.info("Root: " + institutionId);
		try {
			InstitutionLocalServiceUtil.updateInstitution(institutionId, institutionName, 1, serviceContext);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			_log.error("Failed updating top level institution name ", e);
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/admin/institutionList.jsp");
		}
	}	
}