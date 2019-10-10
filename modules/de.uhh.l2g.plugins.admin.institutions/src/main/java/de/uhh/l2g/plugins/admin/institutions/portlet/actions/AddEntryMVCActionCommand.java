package de.uhh.l2g.plugins.admin.institutions.portlet.actions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys;
import de.uhh.l2g.plugins.admin.institutions.portlet.util.InstitutionsComparatorBySortDesc;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminInstitutionManagementPortletKeys.AdminInstitutionManagement,
	        "mvc.command.name=/add"
	    },
	    service = MVCActionCommand.class
)
public class AddEntryMVCActionCommand implements MVCActionCommand {

	protected static Log _log = LogFactoryUtil.getLog(AdminInstitutionManagementPortletKeys.class.getName());

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String name = ParamUtil.getString(actionRequest, "institution");
		long parentId = ParamUtil.getLong(actionRequest, "parent");
		long hostId = ParamUtil.getLong(actionRequest, "hostId");
		int level = ParamUtil.getInteger(actionRequest, "level");
		int sort = ParamUtil.getInteger(actionRequest, "institution-order",0);
		String backURL = ParamUtil.getString(actionRequest, "backURL");
		//institutions list
		List<Institution> modifiableList = new LinkedList<Institution>();
		List<Institution> iList = InstitutionLocalServiceUtil.getByParentId(parentId);
		//make this list modifiable
		ListIterator<Institution> it = iList.listIterator();
		while (it.hasNext()){
			Institution i = it.next();
			modifiableList.add(i);
		}
		//and order by sort descending
		InstitutionsComparatorBySortDesc c = new InstitutionsComparatorBySortDesc();
		modifiableList.sort(c);	
		if(sort==0) sort = modifiableList.get(0).getSort()+1;
		//
		Institution institution = InstitutionLocalServiceUtil.createInstitution(0);
		institution.setSort(sort);
		institution.setParentId(parentId);
		institution.setName(name);
		institution.setLevel(level);
		institution.setTyp("tree1");
		//
		Institution nI = InstitutionLocalServiceUtil.addInstitution(institution);
		// only add if set
		if (hostId > 0 && nI.getInstitutionId()>0) {
			Institution_Host institution_Host = Institution_HostLocalServiceUtil.createInstitution_Host(0);
			institution_Host.setInstitutionId(nI.getInstitutionId());
			institution_Host.setHostId(hostId);
			Institution_HostLocalServiceUtil.addInstitution_Host(institution_Host);
		}
		//
		try {
			actionResponse.sendRedirect(backURL);
		} catch (IOException e) {
			_log.error("can't redirect to location "+backURL);
		}
		return true;
	}

}
