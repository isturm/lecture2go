package de.uhh.l2g.plugins.admin.roles.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.admin.roles.constants.AdminRolesPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Roles",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + AdminRolesPortletKeys.AdminRoles,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminRolesPortlet extends MVCPortlet {
}