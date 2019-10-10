package de.uhh.l2g.plugins.admin.scheduler.portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.admin.scheduler.constants.AdminSchedulerManagementPortletKeys;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=de.uhh.l2g.plugins.admin.scheduler Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminSchedulerManagementPortletKeys.AdminSchedulerManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = AdminSchedulerManagementPortlet.class
)
public class AdminSchedulerManagementPortlet extends MVCPortlet {

	
}