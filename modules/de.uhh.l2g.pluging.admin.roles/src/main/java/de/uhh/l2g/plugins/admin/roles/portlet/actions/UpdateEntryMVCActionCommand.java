package de.uhh.l2g.plugins.admin.roles.portlet.actions;

import java.io.File;
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
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.admin.roles.constants.AdminRolesPortletKeys;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+AdminRolesPortletKeys.AdminRoles,
	        "mvc.command.name=/update"
	    },
	    service = MVCActionCommand.class
)
public class UpdateEntryMVCActionCommand implements MVCActionCommand {
	protected static Log _log = LogFactoryUtil.getLog(AdminRolesPortletKeys.class.getName());

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		Long coordinatorInstitutionId = ParamUtil.getLong(actionRequest, "cfId", 0);
		Long producerInstitutionId = ParamUtil.getLong(actionRequest, "pfId", 0);
		boolean isL2gAdmin = ParamUtil.getBoolean(actionRequest, "isL2gAdmin", false);
		Long reqUserId = ParamUtil.getLong(actionRequest, "userId", 0);
		User reqUser = UserLocalServiceUtil.createUser(0);

		//
		String backURL = ParamUtil.getString(actionRequest, "backURL");
		System.out.println(backURL);
		
		try {
			reqUser = UserLocalServiceUtil.getUser(reqUserId);
		} catch (Exception e1) {
			_log.error("user can't be fatched!");
		}
		
		//make user coordinator
		if(coordinatorInstitutionId>0){//add or edit coordinator role
			try {
				handleCoordinatorRequest(reqUser, coordinatorInstitutionId);
			} catch (Exception e) {
				_log.error("user coordinator role can't be updated!");
			}
		}else{//delete action or nothing to do
			try {
				deleteL2GoRole(AdminRolesPortletKeys.L2G_COORDINATOR, reqUser);
			}  catch (Exception e) {
				_log.error("user coordinator role can't be deleted!");
			}
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
		
		//make user admin
		if(isL2gAdmin){//add or edit admin role
			try {
				addL2GoRole(AdminRolesPortletKeys.L2G_ADMIN, reqUser);
			} catch (Exception e) {
				_log.error("user admin role can't be updated!");
			}
		}else{//delete or nothing to do
			try {
				deleteL2GoRole(AdminRolesPortletKeys.L2G_ADMIN, reqUser);
			}  catch (Exception e) {
				_log.error("user admin role can't be deleted!");
			}
		}
		
		//redirect the root view location
		try {
			actionResponse.sendRedirect(backURL);
		} catch (IOException e) {
			_log.error("can't redirect to location "+backURL);
		}
		
		return true;
	}
	
	private void addL2GoRole(String n, User u) throws PortalException, SystemException{
		// add role to user
		Role nRo = RoleLocalServiceUtil.getRole(u.getCompanyId(), n);
		//user roles
		List<Role> uRo = RoleLocalServiceUtil.getUserRoles(u.getUserId());
		//add new role to user roles
		uRo.add(nRo);
		//set roles to user
		RoleLocalServiceUtil.addUserRoles(u.getUserId(), uRo);		
	}
	
	private void handleCoordinatorRequest(User user, Long institutionId) throws NumberFormatException, PortalException, SystemException {
		Coordinator c = CoordinatorLocalServiceUtil.createCoordinator(0);
		try {
			c = CoordinatorLocalServiceUtil.getCoordinator(user.getUserId());
		} catch (PortalException e) {
			c = CoordinatorLocalServiceUtil.createCoordinator(user.getUserId());
		}

		// add role to user
		addL2GoRole(AdminRolesPortletKeys.L2G_COORDINATOR, user);
		
		// save role to l2go coordinator table
		c.setCoordinatorId(user.getUserId());
		c.setInstitutionId(institutionId);
		CoordinatorLocalServiceUtil.updateCoordinator(c);// add or edit entry
	}
	
	public static boolean createProducersRepository(Host host, Producer producer) throws IOException{
		boolean ret = false;
		File folder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/");
		Runtime runtime = Runtime.getRuntime();
		if (!folder.exists()) {
			//create repository for producer
			if (folder.mkdir()) {
				String[] cmdArray = {PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray);
				String[] cmdArray1 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chown nobody:nobody " + folder.getAbsolutePath() };
				runtime.exec(cmdArray1);
				String[] cmdArray2 = { PropsUtil.get("lecture2go.shell.bin"), "-c", "chmod 701 " + folder.getAbsolutePath() };
				runtime.exec(cmdArray2);

				ret = true;
			}
		}else{
			ret = true;
		}
		//link to main server dir
		File prodFolder = new File(PropsUtil.get("lecture2go.httpstreaming.video.repository") + "/" + producer.getInstitutionId() + "l2g" + producer.getHomeDir());
		if (!prodFolder.exists()) {
			String cmd = "ln -s " + folder.getAbsolutePath() + " " + prodFolder.getAbsolutePath();
			runtime.exec(cmd);
		}
		return ret;
	}
	
	private void deleteL2GoRole(String n, User u) throws PortalException, SystemException{
		Role r = RoleLocalServiceUtil.getRole(u.getCompanyId(), n);
		RoleLocalServiceUtil.deleteUserRole(u.getUserId(), r);
		UserLocalServiceUtil.deleteRoleUser(r.getRoleId(), u.getUserId());		
		if(n.equals(AdminRolesPortletKeys.L2G_COORDINATOR)){
			// remove role from l2go coordinator table, because empty
			if (CoordinatorLocalServiceUtil.fetchCoordinator(u.getUserId()) != null)
				CoordinatorLocalServiceUtil.deleteCoordinator(u.getUserId());			
		}
		if(n.equals(AdminRolesPortletKeys.L2G_PRODUCER)){
			// remove role from l2go producer table, because empty
			Producer p = ProducerLocalServiceUtil.fetchProducer(u.getUserId());
			if ( p != null) {
				p.setInstitutionId(0);
				p.setApproved(0);
				ProducerLocalServiceUtil.updateProducer(p);	
			}
		}
	}

	private void handleProducerRequest(User user, Long producerInstitutionId) throws NumberFormatException, PortalException, SystemException, IOException {
		Producer p = ProducerLocalServiceUtil.createProducer(0);
		//initialize producer
		try {
			p = ProducerLocalServiceUtil.getProducer(user.getUserId());
		} catch (Exception e) {
			p.setProducerId(user.getUserId());
		}
		// save role to l2go producer table
		p.setInstitutionId(producerInstitutionId);
		p.setApproved(1);
		// home directory 
		p.setHomeDir(user.getScreenName());
		p.setIdNum(user.getScreenName());
		// repository for producer
		Host h = HostLocalServiceUtil.createHost(0);
		try{
			h = Institution_HostLocalServiceUtil.getByInstitution(p.getInstitutionId());
			// host to producer 
			p.setHostId(h.getHostId());
		}catch(Exception e){
			_log.error("host or institution error!");
		}
		
		if(createProducersRepository(h, p)){
			// add or update entry
			ProducerLocalServiceUtil.updateProducer(p);				
			// finaly add role to user
			addL2GoRole(AdminRolesPortletKeys.L2G_PRODUCER, user);
			UserLocalServiceUtil.addRoleUser(RoleLocalServiceUtil.getRole(user.getCompanyId(), AdminRolesPortletKeys.L2G_PRODUCER).getRoleId(), user.getUserId());	
		}else{
			_log.error("system permission error!");
		}
	}
}
