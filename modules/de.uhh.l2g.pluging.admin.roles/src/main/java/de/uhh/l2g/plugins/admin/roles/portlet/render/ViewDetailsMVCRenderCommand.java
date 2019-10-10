package de.uhh.l2g.plugins.admin.roles.portlet.render;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.roles.constants.AdminRolesPortletKeys;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + AdminRolesPortletKeys.AdminRoles,
	    		"mvc.command.name=/edit"
	    },
	    service = MVCRenderCommand.class
)
public class ViewDetailsMVCRenderCommand implements MVCRenderCommand {
	protected static Log _log = LogFactoryUtil.getLog(AdminRolesPortletKeys.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		//Remote user
		User remoteUser = UserLocalServiceUtil.createUser(0);
		try {
			remoteUser = UserLocalServiceUtil.getUser(new Long(renderRequest.getRemoteUser())); 
		} catch (Exception e1) {
			_log.error("remote user can't be fatched!");
		} 
		
		//
		String backURL = ParamUtil.getString(renderRequest, "backURL");

		// requestet user
		Long reqUserId = ParamUtil.getLong(renderRequest, "userId", 0);
		User reqUser = UserLocalServiceUtil.createUser(0);
		try {
			reqUser = UserLocalServiceUtil.getUser(reqUserId);
		} catch (Exception e1) {
			_log.error("user can't be fatched!");
		}
		Lecture2GoRoleChecker reqRole = new Lecture2GoRoleChecker(reqUser);

		// institutions
		List<Institution> allInstitutions = InstitutionLocalServiceUtil.getByLevel(1);
		//
		// available instituitions
		List<Institution> allAvailableInstitutions = new ArrayList<Institution>();
		for (Institution institution : allInstitutions) {
			Coordinator c = CoordinatorLocalServiceUtil.createCoordinator(0);
			try {
				c = CoordinatorLocalServiceUtil.getByInstitution(institution.getInstitutionId());
			} catch (Exception e) {
				// _log.error("coordinator can't be fatched for the institution id "+institution.getInstitutionId()+" !");
			}
			if (c.getCoordinatorId() == 0)
				allAvailableInstitutions.add(institution);
		}
		//
		// for coordinator
		Coordinator reqCoordinator = CoordinatorLocalServiceUtil.createCoordinator(0);
		List<Institution> cInstitutions = new ArrayList<Institution>();
		//
		try {
			reqCoordinator = CoordinatorLocalServiceUtil.getCoordinator(reqUserId);
		} catch (Exception e) {
			// _log.error("coordinator can't be fatched for the user id "+reqUserId+" !");
		}
		//
		cInstitutions = allAvailableInstitutions;
		Institution cI = InstitutionLocalServiceUtil.createInstitution(0);
		try {
			cI = InstitutionLocalServiceUtil.getInstitution(reqCoordinator.getInstitutionId());
			cInstitutions.add(cI);
		} catch (Exception e) {}
		//
		// for producer
		Producer reqProducer = ProducerLocalServiceUtil.createProducer(0);
		try {
			reqProducer = ProducerLocalServiceUtil.getProdUcer(reqUserId);
		} catch (Exception e) {
			// _log.error("producer can't be fatched for the user id "+reqUserId+" !");
		}
		
		String title = LanguageUtil.get(remoteUser.getLocale(), "l2go-roles-for")+" "+reqUser.getFullName();
		
		renderRequest.setAttribute("cInstitutions", cInstitutions);
		renderRequest.setAttribute("allInstitutions", allInstitutions);
		renderRequest.setAttribute("title", title);
		renderRequest.setAttribute("backURL", backURL);

		renderRequest.setAttribute("cfId", reqCoordinator.getInstitutionId());
		renderRequest.setAttribute("pfId", reqProducer.getInstitutionId());
		renderRequest.setAttribute("admin", reqRole.isL2gAdmin());
		renderRequest.setAttribute("reqUserId", reqUserId);
		
		return "/viewEdit.jsp";
	}

}
