package de.uhh.l2g.plugins.admin.institutions.portlet.actions;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys;
import de.uhh.l2g.plugins.admin.institutions.portlet.util.InstitutionManager;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminInstitutionManagementPortletKeys.AdminInstitutionManagement,
	        "mvc.command.name=/update"
	    },
	    service = MVCActionCommand.class
)
public class UpdateEntryMVCActionCommand implements MVCActionCommand {

	protected static Log _log = LogFactoryUtil.getLog(AdminInstitutionManagementPortletKeys.class.getName());

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long institutionId = ParamUtil.getLong(actionRequest, "institutionId");
		String name = ParamUtil.getString(actionRequest, "name");
		String backURL = ParamUtil.getString(actionRequest, "backURL");
		int sort = ParamUtil.getInteger(actionRequest, "institution-order", 1);
		//
		try {
			Institution institution = InstitutionLocalServiceUtil.getInstitution(institutionId);
			Institution parent = InstitutionLocalServiceUtil.getInstitution(institution.getParentId());
			//
			institution.setName(name);
			institution.setSort(InstitutionManager.updateSort(institution, sort));
			// update
			InstitutionLocalServiceUtil.updateInstitution(institution);
			// and refresh order
			if (institution.getParentId() > 0) InstitutionManager.reorderChildren(parent);
			//
			actionResponse.sendRedirect(backURL);
		} catch (PortalException e) {
			_log.error("can't update the institution object with id "+institutionId);
		} catch (IOException e ) {
			_log.error("can't redirect to the location uri");
		}catch (IllegalArgumentException e ) {
			_log.error("can't redirect to the location uri");
		}
		//
		return true;
	}

}
