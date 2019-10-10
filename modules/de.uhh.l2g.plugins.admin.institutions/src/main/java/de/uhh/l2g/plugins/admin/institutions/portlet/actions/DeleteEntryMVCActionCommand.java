package de.uhh.l2g.plugins.admin.institutions.portlet.actions;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminInstitutionManagementPortletKeys.AdminInstitutionManagement,
	        "mvc.command.name=/delete"
	    },
	    service = MVCActionCommand.class
)
public class DeleteEntryMVCActionCommand implements MVCActionCommand {

	protected static Log _log = LogFactoryUtil.getLog(AdminInstitutionManagementPortletKeys.class.getName());

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long institutionId = ParamUtil.getLong(actionRequest, "institutionId");
		String backURL = ParamUtil.getString(actionRequest, "backURL");
		Institution removedInstitution = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			removedInstitution = InstitutionLocalServiceUtil.deleteInstitution(institutionId);
		} catch (PortalException e) {
			_log.error("can't remove institution object with id "+institutionId);
		}
		//
		if(removedInstitution.getInstitutionId()>0){
			// Remove anything from link table if there...
			List<Institution_Host> linstitution_Host;
			try {
				linstitution_Host = Institution_HostLocalServiceUtil.getListByInstitutionId(institutionId);
				if (linstitution_Host.size() > 0) {
					for (Institution_Host link : linstitution_Host) {
						long ihId = link.getPrimaryKey();
						// System.out.println(ihId);
						Institution_HostLocalServiceUtil.deleteLinkById(ihId);
					}
				}
				//
				actionResponse.sendRedirect(backURL);
			} catch (IOException e) {
				_log.error("can't redirect to location "+backURL);
			} catch (SystemException e) {
				_log.error("can't remove related institutions to the institution with object with id "+institutionId);
			} catch (PortalException e) {
				_log.error("can't remove related institutions to the institution with object with id "+institutionId);
			} 
		}
		return true;
	}

}
