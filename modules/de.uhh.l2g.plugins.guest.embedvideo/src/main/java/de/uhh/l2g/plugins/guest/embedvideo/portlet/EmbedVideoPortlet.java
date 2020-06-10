package de.uhh.l2g.plugins.guest.embedvideo.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalUtil;
import de.uhh.l2g.plugins.guest.embedvideo.constants.EmbedVideoPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author fho
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=lecture2go.plugins",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=false",
				"javax.portlet.display-name=EmbedVideo",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + EmbedVideoPortletKeys.EMBEDVIDEO,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/videoPlayer.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/lang/de.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-contrib-quality-levels.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-hls-quality-selector.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/offset/videojs-offset.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chromecast/dist/silvermine-videojs-chromecast.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chromecast/chromecast-framework.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/vr/videojs-vr.min.js",
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.js",
				"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.css",
				"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video-js.min.css",
		},
		service = Portlet.class
)
public class EmbedVideoPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		String videoIdParam = httpReq.getParameter("obj");
		if (videoIdParam == null) {
			// old API
			videoIdParam = httpReq.getParameter("v");
		}

		String[] splitParam = videoIdParam.split("/");
		int startTime = 0;
		int endTime = 0;
		String urlSuffix = "";
		if (splitParam.length > 1) {
			videoIdParam = splitParam[0];
			startTime = Integer.parseInt(splitParam[1]);
			endTime = Integer.parseInt(splitParam[2]);
			urlSuffix = "/" + startTime + "/" + endTime;
		}

		try {
			long videoId = Long.parseLong(videoIdParam);
			Video video = VideoLocalServiceUtil.getVideo(videoId);
			boolean is360Video = Video_CategoryLocalServiceUtil.getByVideo(videoId).get(0).getCategoryId() == 9;

			renderRequest.setAttribute("citationAllowed", video.getCitation2go());
			renderRequest.setAttribute("image", video.getImage());
			renderRequest.setAttribute("uris", video.getJsonPlayerUris());
			renderRequest.setAttribute("tracks", video.getJsonPlayerTracks());
			renderRequest.setAttribute("startTime", startTime);
			renderRequest.setAttribute("endTime", endTime);
			renderRequest.setAttribute("sourceUrl", video.getCurrentURL() + urlSuffix);
			renderRequest.setAttribute("is360Video", is360Video);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}
}