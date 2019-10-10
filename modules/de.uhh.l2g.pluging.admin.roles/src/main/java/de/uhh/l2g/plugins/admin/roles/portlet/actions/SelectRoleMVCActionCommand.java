package de.uhh.l2g.plugins.admin.roles.portlet.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.roles.constants.AdminRolesPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminRolesPortletKeys.AdminRoles,
	        "mvc.command.name=/select"
	    },
	    service = MVCActionCommand.class
)
public class SelectRoleMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		Long roleId = ParamUtil.getLong(actionRequest, "roleId");
	
		actionResponse.setProperty("roleId", roleId+"");
		actionResponse.addProperty("roleId",roleId+"");
		//
		return true;
	}

}
