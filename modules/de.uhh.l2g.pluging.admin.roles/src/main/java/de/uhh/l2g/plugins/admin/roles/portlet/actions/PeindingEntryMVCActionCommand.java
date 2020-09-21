package de.uhh.l2g.plugins.admin.roles.portlet.actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import de.uhh.l2g.plugins.admin.roles.constants.AdminRolesPortletKeys;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminRolesPortletKeys.AdminRoles,
	        "mvc.command.name=/panding"
	    },
	    service = MVCActionCommand.class
)
public class PeindingEntryMVCActionCommand extends UpdateEntryMVCActionCommand implements MVCActionCommand {
	protected static Log _log = LogFactoryUtil.getLog(AdminRolesPortletKeys.class.getName());

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		Long producerInstitutionId = ParamUtil.getLong(actionRequest, "pfId", 0);
		Long reqUserId = ParamUtil.getLong(actionRequest, "userId", 0);
		User reqUser = UserLocalServiceUtil.createUser(0);

		
		try {
			reqUser = UserLocalServiceUtil.getUser(reqUserId);
		} catch (Exception e1) {
			_log.error("user can't be fatched!");
		}
		
		
		//make user producer
		if(producerInstitutionId>0){//add or edit producer role
			try {
				handleProducerRequest(reqUser, producerInstitutionId);
			} catch (Exception e) {
				_log.error("user producer role can't be updated!");
			}
		}else{//delete or nothing to do
			try {
				deleteL2GoRole(AdminRolesPortletKeys.L2G_PRODUCER, reqUser);
			}  catch (Exception e) {
				_log.error("user producer role can't be deleted!");
			}
		}
		
		try {
			actionResponse.sendRedirect("/web/vod/videos");
		} catch (IOException e) {
			_log.error("can't redirect to location /web/vod/videos");
		}
		return true;
	}
	
}
