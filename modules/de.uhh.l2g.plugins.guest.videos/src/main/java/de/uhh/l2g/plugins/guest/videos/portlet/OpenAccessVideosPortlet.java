package de.uhh.l2g.plugins.guest.videos.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;

import java.io.IOException;
import java.util.List;

/**
 * @author isturm
 */

@Component(immediate = true, property = { "com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.socialshareprivacy.js",
		"com.liferay.portlet.header-portlet-javascript=/js/qrc.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.cookie.js",
		"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/readmore.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.mark.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.guest.videos.js",
		"javax.portlet.display-name=Guest Videos", "javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/videoPlayer.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/lang/de.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-contrib-quality-levels.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-hls-quality-selector.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/offset/videojs-offset.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/vr/videojs-vr.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.js",
		"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.css",
		"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video-js.min.css", }, service = Portlet.class)
public class OpenAccessVideosPortlet extends MVCPortlet {
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException {
		String resourceID = resourceRequest.getResourceID();

		if (resourceID.equals("getVideosForLectureSeries")) {
			String objectId = ParamUtil.getString(resourceRequest, "objectId");
			String videoIds = ParamUtil.getString(resourceRequest, "videoIds");

			List<Video> videos;
			if (!videoIds.equals("")) {
				videoIds = videoIds.substring(1, videoIds.length()-1);
				String[] videoIdsStringArray = videoIds.split(",");
				long[] videoIdsArray = new long[videoIdsStringArray.length];
				for (int i=0; i<videoIdsStringArray.length; i++) {
					videoIdsArray[i] = new Long(videoIdsStringArray[i].trim());
				}
				videos = VideoLocalServiceUtil.getByVideoIds(videoIdsArray);
			} else {
				videos = VideoLocalServiceUtil.getByLectureseries(new Long(objectId));
			}

			JSONArray json = JSONFactoryUtil.createJSONArray();
			json.put(videos);
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}
}