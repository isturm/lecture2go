package de.uhh.l2g.plugins.util;

import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.PortletPreferences;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.PortletKeys;


/**Simplifies add and remove Permissions programmatically (per Portlet)
 * 
 * Fixes Scope to beeing constant over all L2Go Portlets (currently L2G resources support Group&Company Scope)

 * Works with Role Name, for clarity and human readableness of permissions Setting
 * Could be rewritten easily by passing Role Object directly to reduce one layer of possible failure (i.e. retrieve RoleId)
 *
 * Remark: Permission in Liferay are granted hierarchically Company > Group > Entity and cant't be revoked 
 * on a lower scope
 * 
 * Individual Permissions only work when addResource is performed for each entity instance (Migration Portlet does not 
 * correctly add Resources for old entities yet)
 */
public class PermissionManager {

protected static Log LOG;	
private ServiceContext context;

     /**Initiate new Manager Instance by Service Context
      * 
      * @param serviceContext
      */
     public PermissionManager(ServiceContext serviceContext) {
    	 LOG = LogFactoryUtil.getLog(PermissionManager.class.getName());
    	 context = serviceContext;
	
     }
     
     /**Initiate new Manager Instance by Request and Class Name
      * 
      * @param portletRequest
      * @param className
      */
     public PermissionManager(PortletRequest portletRequest, String className) {
    	LOG = LogFactoryUtil.getLog(PermissionManager.class.getName()); 
 	    ServiceContext serviceContext = null;
		
			try {
				serviceContext = ServiceContextFactory.getInstance(portletRequest);
			} catch (PortalException e) {
				LOG.warn("Could not generate Service Context for "+className, e);
			} catch (SystemException e) {
				LOG.warn("Could not generate Service Context", e);
			}
			context = serviceContext;	
     }
     
     /**Generate ServiceContext from Plid, PortletId and User (Use with Caution!)
      * 
      * If ServiceContext is not retrieved from Request we have no PortletId
      * 
      * Current estimate does not support multi-portlet pages! 
      * 
      * @param plid - LayoutId
      * @param pId - portletId
      * @param u
      * @throws PortalException
      * @throws SystemException
      */
     public PermissionManager(Long plid, User u){
    	 LOG = LogFactoryUtil.getLog(PermissionManager.class.getName());
	     Layout layout = null;
	    	 try {
				layout  = LayoutLocalServiceUtil.fetchLayout(plid);
			 } catch (SystemException e) {
				LOG.warn("Layout not found for "+plid, e);
			 }
	    	 
	    	 ServiceContext serviceContext = new ServiceContext();
	    	 
	    	 //Data from Layout
	    	 serviceContext.setScopeGroupId(layout.getGroupId());
	    	 serviceContext.setCompanyId(layout.getCompanyId());
	    	 serviceContext.setPlid(layout.getPlid());
	    	    	   
	    	 //Data from User
	    	 serviceContext.setUserId(u.getUserId());
	    	 	 
	    	 context = serviceContext;
  
     }
     
     
     /**Retrieves Portlet Permission if set or null
      * 
      * @param roleName
      * @return ResourcePermission
      * @throws SystemException
      */
     public ResourcePermission getPermissionforRole(String roleName) throws SystemException{
 		String pId = context.getPortletId();
 		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
    	 
    	 Role role = null;
    	 try{
  	    	role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);
 		} catch (PortalException e) {
 			LOG.warn("Could not retrieve Role "+roleName+". Please, make sure that User Managemt Portlet has been initilized.", e);
 		}   	   		
    	 ResourcePermission rp = ResourcePermissionLocalServiceUtil.fetchResourcePermission(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId());   	
		 return rp;	
     }
     
     
 
      
      /**Grant View Permission on Entity/Model to Role (Model/Group)
  	 * 
  	 * @param roleName
  	 * @param entityName
  	 * @param entityName
  	 * @param serviceContext
  	 * @throws SystemException
  	 * @throws PortalException
  	 */
  	public void setL2GEntityViewPermissions(String roleName, String entityName) throws SystemException, PortalException {
  	
  	    try{
  	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
  			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), new String[] {ActionKeys.VIEW});
  	
  		} catch (PortalException e) {
  			LOG.warn("Could not set Permission for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
  		}
  					
  	}	
  	
	/**Remove Permissions on Entity/Model to Role (Model/Group)
 	 * 
 	 * @param roleName
 	 * @param entityName
 	 * @param entityName
 	 * @param serviceContext
 	 * @throws SystemException
 	 * @throws PortalException
 	 */
 	public void removeL2GEntityVieWPermissions(String roleName, String entityName) throws SystemException, PortalException {
 	
 	    try{
 	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);			
 		    ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), ActionKeys.VIEW);
 	
 		} catch (PortalException e) {
 			LOG.warn("Could not remove Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
 		}
 					
 	}
          
     
     /**Grant Permission on Entity/Model to Role (Model/Group)
 	 * 
 	 * @param roleName
 	 * @param entityName
 	 * @param entityName
 	 * @param serviceContext
 	 * @throws SystemException
 	 * @throws PortalException
 	 */
 	public void setL2GEntityPermissions(String roleName, String entityName, String action) throws SystemException, PortalException {
 	
 	    try{
 	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
 			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), new String[] {action});
 	
 		} catch (PortalException e) {
 			LOG.warn("Could not set Permission for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
 		}
 					
 	}
 	
	
 	
	/**Grant Permissions on Entity/Model to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GEntityPermissions(String roleName, String entityName, String[] actions) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions);
	
		} catch (PortalException e) {
			LOG.warn("Could not set Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
		}
					
	}	
	
	
	/**Remove Permissions on Entity/Model to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GEntityPermissions(String roleName, String entityName, String action) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
		
		    ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), action);

		} catch (PortalException e) {
			LOG.warn("Could not remove Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
		}
					
	}
	/**Remove Permissions on Entity/Model to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GEntityPermissions(String roleName, String entityName, String[] actions) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
	    	
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions[i]);
			}
	
		} catch (PortalException e) {
			LOG.warn("Could not remove Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")", e);
		}
					
	}
	
	
	/**Grant Permissions on calling Portlet to Role 
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GPortletPermissions(String roleName, String action) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
		
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), new String[] {action});
		
		} catch (PortalException e) {
			LOG.warn("Could not set Permission for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	
	
	/**Grant Permissions on calling Portlet to Role 
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GPortletPermissions(String roleName,  String[] actions) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
		
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions);
		
		} catch (PortalException e) {
			LOG.warn("Could not set Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	
	
	/**Remove Permissions on calling Portlet to Role (Portlet/Group)
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GPortletPermissions(String roleName,  String action) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), action);

		
		} catch (PortalException e) {
			LOG.warn("Could not remove Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	
	/**Remove Permissions on calling Portlet to Role (Portlet/Group)
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GPortletPermissions(String roleName,  String[] actions) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions[i]);
			}
		
		} catch (PortalException e) {
			LOG.warn("Could not remove Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	
	/**Grant Page View Permission to Role (Layout/Individual)
	 * 
	 * @param roleName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutViewPermission(String roleName) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), new String[] {ActionKeys.VIEW});			
		
		} catch (PortalException e) {
			LOG.warn("Could not set View Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}	
	}
	
	/**Remove Page View Permission to Role (Layout/Individual)
	 * 
	 * @param roleName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GLayoutViewPermission(String roleName) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), ActionKeys.VIEW);
				
		} catch (PortalException e) {
			LOG.warn("Could not remove View Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}	
	}
	
	
	/**Add Permission on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutPermissions(String roleName, String action) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), new String[] {action});			
		
		} catch (PortalException e) {
			LOG.warn("Could not set Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}	
	 }
	
	
	/**Add Permissions on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutPermissions(String roleName, String[] actions) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), actions);			
		
		} catch (PortalException e) {
			LOG.warn("Could not set Permissions for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}	
	 }
	
	
	/**Remove Permission on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeL2GLayoutPermissions(String roleName, String action) throws PortalException, SystemException{
		       
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), action);
		
		} catch (PortalException e) {
			LOG.warn("Could not remove Permissions for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	/**Remove Permissions on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeL2GLayoutPermissions(String roleName, String[] actions) throws PortalException, SystemException{
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);
		
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), actions[i]);
			}		
		} catch (PortalException e) {
			LOG.warn("Could not remove Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")", e);
		}
	}
	
    /**Get L2G Portlet by Layout (expects only one L2G portlet per page)
     * 
     * @param plid
     * @throws SystemException 
     */
	public String getL2GPortletByPlid(long plid) throws SystemException{ 
		String portletId ="";
		long ownerId = 0;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
	    List<PortletPreferences> pPrefs = PortletPreferencesLocalServiceUtil.getPortletPreferences(ownerId, ownerType, plid);
	    
	    int i = 0;
	    
	    while (i < pPrefs.size() && portletId.equals("") ){
	    	PortletPreferences p = pPrefs.get(i);
	    	if (p.getPortletId().startsWith("lg")) portletId = p.getPortletId();
	     i++;
	    }	
	    if (portletId.equalsIgnoreCase("")) LOG.warn("No Portlet for "+plid);
	    
	    return portletId;
	    
	}
	
	/** Auxiliary Function to Set Layout(Page) View Permission based on Page "friendlyURL"
	 *  
	 *  Usable if Page has no Portlet Representation in Backend but a constant name
	 * @param companyId
	 * @param groupId
	 * @param role
	 * @param friendlyurl
	 * @throws PortalException
	 * @throws SystemException
	 */
	@SuppressWarnings("unused")
	private static void setPageViewPermissionByFriendlyUrl(long companyId, long groupId, Role role, String friendlyurl) throws PortalException, SystemException{
		 
		Layout imPage = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, friendlyurl);
       
		//Page Permission
        ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), role.getRoleId(), new String[] {ActionKeys.VIEW});			
		
	}
	
	/** Auxiliary Function to Remove Layout(Page) View Permission based on Page "friendlyURL"
	 *  
	 *  Usable if Page has no Portlet Representation in Backend but a constant name
	 *  
	 * @param companyId
	 * @param groupId
	 * @param role
	 * @param friendlyurl
	 * @throws PortalException
	 * @throws SystemException
	 */
	@SuppressWarnings("unused")
	private static void removePageViewPermissionByFriendlyUrl(long companyId, long groupId, Role role, String friendlyurl) throws PortalException, SystemException{
		 
		Layout imPage = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, friendlyurl);
       
		//Page Permission
		ResourcePermissionLocalServiceUtil.removeResourcePermission(companyId, "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(imPage.getPlid()), role.getRoleId(), ActionKeys.VIEW);

	
		
	}

}
