/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.exception.HostNameException;
import de.uhh.l2g.plugins.exception.HostStreamerException;
import de.uhh.l2g.plugins.exception.NoPropertyException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.HostLocalServiceBaseImpl;
import de.uhh.l2g.plugins.util.RepositoryManager;

public class HostLocalServiceImpl extends HostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.uhh.l2g.plugins.service.HostLocalServiceUtil} to access the host local
	 * service.
	 */

	protected static Log LOG = LogFactoryUtil.getLog(Host.class.getName());
	protected static final String SYS_ROOT = "vh_000";
	protected static final String SYS_SERVER = "localhost";
	protected static final String SYS_PROTOCOL = "http";
	protected static final int SYS_PORT = 80;

	public Host getByInstitution(long institutionId) throws SystemException {
		Host h = null;
		try {
			h = Institution_HostLocalServiceUtil.getByInstitutionId(institutionId);
		} catch (PortalException e) {
			//e.printStackTrace();
		}
		return h;
	}

	public Host getByHostId(long hostId) throws SystemException {
		return hostPersistence.fetchByPrimaryKey(hostId);
	}

	public List<Host> getByCompanyId(long companyId) throws SystemException {
		return hostPersistence.findByCompany(companyId);
	}
	
	public List<Host> getByGroupId(long groupId) throws SystemException {
		return hostPersistence.findByGroup(groupId);
	}

	public List<Host> getByGroupId(long groupId, int start, int end) throws SystemException {
		return hostPersistence.findByGroup(groupId, start, end);
	}

	public int getByGroupIdCount(long groupId) throws SystemException {
		return hostPersistence.countByGroup(groupId);
	}

	public Host getByGroupIdAndHostId(long groupId, long hostId) throws SystemException {
		return hostPersistence.fetchByG_H(groupId, hostId);
	}

	public List<Host> getByCompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		return hostPersistence.findByCompanyIdAndGroupId(companyId, groupId);
	}

	public Host getByDefault(long companyId, long groupId) throws SystemException {
		Host defaultHost = hostPersistence.fetchByDefaultHost(companyId, groupId, false);
		return defaultHost;
	}

	public long getDefaultHostId(long companyId, long groupId) throws SystemException {
		Host defaultHost = hostPersistence.fetchByDefaultHost(companyId, groupId, false);
		if (defaultHost == null) return 0;
		else return defaultHost.getPrimaryKey();
	}

	/** Host is locked if it is linked to an institution */
	public int getLockingElements(long companyId, long hostId) throws SystemException {
		int c = 0;
		try {
			c = Institution_HostLocalServiceUtil.getByCompanyIdAndHostIdCount(companyId, hostId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return c;
	}

	protected void validate(String name, String streamer) throws PortalException {
		// only default host db entries name field is allowed to be empty
		if (Validator.isNull(name)) {
			throw new HostNameException();
		}

		if (Validator.isNull(streamer) || !Validator.isDomain(streamer) || !Validator.isHostName(streamer)) {
			throw new HostStreamerException();
		}
	}

	public static final String DEFAULT_STREAMER = "Default";

	/**
	 * Special handling for default entries (no update)
	 * 
	 */
	public Host addDefaultHost(ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long hostId = counterLocalService.increment(Host.class.getName());

		Host defaultHost = hostPersistence.create(hostId);

		LOG.debug("Writing Host");
		defaultHost.setName(DEFAULT_STREAMER);
		defaultHost.setGroupId(groupId);
		defaultHost.setCompanyId(companyId);

		// Load from Portal Properties
		String streamer = GetterUtil.getString(PropsUtil.get("lecture2go.default.streamingHost"));
		String protocol = GetterUtil.getString(PropsUtil.get("lecture2go.default.streamingProtocol"));
		String serverRoot = GetterUtil.getString(PropsUtil.get("lecture2go.default.serverRoot"));
		int port = Integer.valueOf(GetterUtil.getInteger(PropsUtil.get("lecture2go.default.streamingPort")));

		if (streamer.isEmpty()) {
			streamer = RepositoryManager.SYS_SERVER;
			LOG.error("Portal property lecture2go.default.streamingHost not set. Using default!");
		}
		if (protocol.isEmpty()) {
			protocol = RepositoryManager.SYS_PROTOCOL;
			LOG.error("Portal property lecture2go.default.streamingProtocol not set. Using default!");
		}
		if (serverRoot.isEmpty()) {
			serverRoot = RepositoryManager.SYS_ROOT;
			LOG.error("Portal property lecture2go.default.serverRoot not set. Using default!");
		}
		if (port == 0) {
			port = RepositoryManager.SYS_PORT;
			LOG.error("Portal property lecture2go.default.streamingPort not set. Using default!");
		}
		defaultHost.setStreamer(streamer);
		defaultHost.setProtocol(protocol);
		defaultHost.setServerRoot(serverRoot);
		defaultHost.setPort(port);
		defaultHost.setDefaultHost(1);
		hostPersistence.update(defaultHost);

		String repository = GetterUtil.getString(PropsUtil.get("lecture2go.media.repository"));
		if (repository.isEmpty()) {
			LOG.error("Portal property lecture2go.media.repository not set. This path must be specified set before installation!");
			throw new NoPropertyException();
		}
		try {
			RepositoryManager.createFolder(PropsUtil.get("lecture2go.media.repository") + "/" + defaultHost.getServerRoot());
		} catch (IOException e) {
			LOG.error("Folder creation failed!", e);
		}
		return defaultHost;
	}

	/**
	 * Removes database record of Host
	 * 
	 * This will not remove Folder on Filesystem, Folder will not be reused
	 * 
	 */
	public Host deleteHost(long hostId, ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		Host host = getHost(hostId);
		int l = getLockingElements(groupId, hostId);
		//
		if (l < 1) {
			host = deleteHost(hostId);
		} else {
			String message = LanguageUtil.format(serviceContext.getLocale(), "There are {0} objects still refering to this institution", l);
			SessionMessages.add(serviceContext.getRequest(), "deletion-locked", message);
			System.out.println("Could not delete Host because it is still used by " + l + " Institutions");
		}
		return host;

	}

	public List<Host> getAll(){
		List<Host> ret = new ArrayList<Host>(); 
		try {
			ret = hostPersistence.findAll();
		} catch (SystemException e) {
			LOG.debug("Can't fetch list of all hosts");
		}
		return ret;
	}
}
