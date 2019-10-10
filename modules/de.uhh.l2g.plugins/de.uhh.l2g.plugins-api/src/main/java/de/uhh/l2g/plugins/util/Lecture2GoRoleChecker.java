package de.uhh.l2g.plugins.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

public class Lecture2GoRoleChecker extends RoleLocalServiceUtil {
	
	private  boolean producer = false;
	private  boolean coordinator = false;
	private  boolean l2gAdmin = false;
	
	public Lecture2GoRoleChecker(){}
	
	public Lecture2GoRoleChecker(User remoteUser) {
		try {
			l2gAdmin = isL2gAdmin(remoteUser);
			coordinator = isCoordinator(remoteUser);
			producer = isProducer(remoteUser);
			if (l2gAdmin) {
				coordinator = false;
				producer = false;
			} else {
				if (coordinator) {
					producer = false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean isProducer() {
		return producer;
	}

	public void setProducer(boolean producer) {
		this.producer = producer;
	}

	public boolean isCoordinator() {
		return coordinator;
	}

	public void setCoordinator(boolean coordinator) {
		this.coordinator = coordinator;
	}

	public boolean isL2gAdmin() {
		return l2gAdmin;
	}

	public void setL2gAdmin(boolean l2gAdmin) {
		this.l2gAdmin = l2gAdmin;
	}

	public  boolean isProducer(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
//			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Producer"))producer=true;
		return producer;
	}
	
	public  boolean isCoordinator(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
//			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Coordinator"))coordinator=true;
		return coordinator;
	}
	
	public  boolean isL2gAdmin(User user) {
		List<Role> rL = new ArrayList<Role>();
		try {
			rL = user.getRoles();
		} catch (SystemException e) {
//			//e.printStackTrace();
		}
		for (Role role : rL) if(role.getName().equals("L2Go Admin") || role.getName().equals("Administrator") )l2gAdmin=true;
		return l2gAdmin;
	}
	
}
