package de.uhh.l2g.plugins.hook.login.actions;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;

import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
 immediate = true,
 property = {
 "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
 "mvc.command.name=/login/login",
 "service.ranking:Integer=100"
 },
 service = MVCActionCommand.class
 )
public class CustomLoginActionCommand extends BaseMVCActionCommand {

 @Override
 protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		String login = ParamUtil.getString(actionRequest, "login");
		String password = ParamUtil.getString(actionRequest, "password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_EA;

		AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		
		User user = PortalUtil.getUser(request);
		//check roles for user
		Lecture2GoRoleChecker role = new Lecture2GoRoleChecker(user);
		
		String redirect = "";
		if(role.isProducerPending())redirect="/web/vod/user-roles";
		else redirect = themeDisplay.getPathMain();
		
		actionResponse.sendRedirect(redirect);
 
 }
 
 /*
 * You still execute original logic
 */
 @Reference(target = "(&(mvc.command.name=/login/login)(javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet))")
 protected MVCActionCommand mvcActionCommand;

}