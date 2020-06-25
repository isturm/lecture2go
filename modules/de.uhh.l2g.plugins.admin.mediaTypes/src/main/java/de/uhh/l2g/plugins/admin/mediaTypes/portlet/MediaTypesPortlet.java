package de.uhh.l2g.plugins.admin.mediaTypes.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import de.uhh.l2g.plugins.admin.mediaTypes.constants.MediaTypesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;

import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;
import org.osgi.service.component.annotations.Component;

import de.uhh.l2g.plugins.model.MediaType;
import de.uhh.l2g.plugins.service.MediaTypeLocalServiceUtil;

import java.io.IOException;
import java.util.Date;

/**
 * @author fho
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin MediaTypes",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewList.jsp",
		"javax.portlet.name=" + MediaTypesPortletKeys.MEDIATYPES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MediaTypesPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(MediaTypesPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			long userId = new Long(renderRequest.getRemoteUser());
			User user = UserLocalServiceUtil.getUser(userId);
			Lecture2GoRoleChecker l2goRole = new Lecture2GoRoleChecker(user);
			if (!l2goRole.isL2gAdmin()) {
				return;
			}
		} catch (Exception e) {
			return;
		}

		long mediaTypeId = 0L;
		MediaType mediaType = MediaTypeLocalServiceUtil.createMediaType(mediaTypeId);

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		String backURL = ParamUtil.getString(renderRequest, "backURL");

		try {
			try {
				mediaTypeId = ParamUtil.getLong(renderRequest, "mediaTypeId");
				mediaType = MediaTypeLocalServiceUtil.getMediaType(mediaTypeId);
			} catch (Exception ignored) {}
			renderRequest.setAttribute("mediaType", mediaType);
			renderRequest.setAttribute("backURL", backURL);
			renderResponse.setProperty("jspPage", mvcPath);
		} catch (Exception ignored) {}
		super.render(renderRequest, renderResponse);
	}

	public void add(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		String backURL = ParamUtil.getString(request, "backURL");
		String mediaTypeName = ParamUtil.getString(request, "mediaTypeName");

		long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();

		try {
			MediaType mediaType = MediaTypeLocalServiceUtil.createMediaType(0L);
			mediaType.setMediaTypeName(mediaTypeName);

			mediaType.setUserName(user.getScreenName());
			mediaType.setUserId(userId);
			mediaType.setCompanyId(companyId);
			mediaType.setGroupId(groupId);

			MediaTypeLocalServiceUtil.addMediaType(mediaType);
		} catch(Exception e) {
			_log.warn("Unable to add new media type entry!");
			SessionErrors.add(request, e.getClass().getName());
		}

		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void edit(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long reqMediaTypeId = ParamUtil.getLong(request, "mediaTypeId");
		String backURL = ParamUtil.getString(request, "backURL");

		String mediaTypeName = ParamUtil.getString(request, "mediaTypeName");

		long userId = new Long(request.getRemoteUser());
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();

		try {
			MediaType mediaType = MediaTypeLocalServiceUtil.getMediaType(reqMediaTypeId);
			mediaType.setMediaTypeName(mediaTypeName);

			mediaType.setUserName(user.getScreenName());
			mediaType.setUserId(userId);
			mediaType.setCompanyId(companyId);
			mediaType.setGroupId(groupId);
			mediaType.setModifiedDate(new Date());

			MediaTypeLocalServiceUtil.updateMediaType(mediaType);
		} catch (Exception e) {
			_log.warn("Unable to update media type.");
			SessionErrors.add(request, e.getClass().getName());
		}

		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long reqMediaTypeId = ParamUtil.getLong(request, "mediaTypeId");
		String backURL  = ParamUtil.getString(request, "backURL");

		MediaTypeLocalServiceUtil.deleteMediaType(reqMediaTypeId);
		try {
			response.sendRedirect(backURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}