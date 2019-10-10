package de.uhh.l2g.plugins.admin.categories.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.admin.categories.constants.CategoryManagementPortletKeys;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Categories",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + CategoryManagementPortletKeys.CategoryManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CategoryManagementPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(CategoryManagementPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		//
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Long catId = new Long(0);
		//
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		//
		try{
			Category c = CategoryLocalServiceUtil.createCategory(0);
			try {
				catId = ParamUtil.getLong(renderRequest, "categoryId");
				c = CategoryLocalServiceUtil.getCategory(catId);
				renderRequest.setAttribute("category", c);
			}catch (Exception e) {
				// TODO: handle exception
			}
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		}catch (Exception e) {//show all
			// TODO: handle exception
		}
		super.render(renderRequest, renderResponse);
	}
	
	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = ParamUtil.getString(request, "backURL");
		String name = ParamUtil.getString(request, "name");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		String languageId = user.getLanguageId();
		try {
			Category category = CategoryLocalServiceUtil.createCategory(0);
			category.setName(name);
			//
			category.setUserName(user.getScreenName());
			category.setUserId(userId);
			category.setCompanyId(companyId);
			category.setGroupId(groupId);
			category.setUserName(user.getScreenName());
			category.setLanguageId(languageId);
			//
			CategoryLocalServiceUtil.addCategory(category);
		} catch (Exception e) {
			_log.error("Unable to add new category entry!");
			SessionErrors.add(request, e.getClass().getName());
		}	
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		String backURL = ParamUtil.getString(request, "backURL");
		//
		long reqCategoryId = ParamUtil.getLong(request, "categoryId");
		String name = ParamUtil.getString(request, "name");
		//
		Long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		try {
			Category category = CategoryLocalServiceUtil.getCategory(reqCategoryId);
			category.setName(name);
			//
			category.setUserName(user.getScreenName());
			category.setModifiedDate(new Date());
			category.setUserId(userId);
			category.setCompanyId(companyId);
			category.setGroupId(groupId);
			category.setUserName(user.getScreenName());
			//
			CategoryLocalServiceUtil.updateCategory(category);
		} catch (Exception e) {
			_log.error("Unable to update category.");
			SessionErrors.add(request, e.getClass().getName());
		}
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException{
		long reqCategoryId = ParamUtil.getLong(request, "categoryId");
		String backURL = ParamUtil.getString(request, "backURL");
		//
		CategoryLocalServiceUtil.deleteById(reqCategoryId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}