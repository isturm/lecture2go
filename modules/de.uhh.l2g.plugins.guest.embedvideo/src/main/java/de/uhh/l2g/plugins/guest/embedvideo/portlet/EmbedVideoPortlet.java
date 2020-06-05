package de.uhh.l2g.plugins.guest.embedvideo.portlet;

import de.uhh.l2g.plugins.guest.embedvideo.constants.EmbedVideoPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;
import org.osgi.service.component.annotations.Component;

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
				"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.js",
				"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.css",
				"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video-js.min.css",
		},
		service = Portlet.class
)
public class EmbedVideoPortlet extends MVCPortlet {

}