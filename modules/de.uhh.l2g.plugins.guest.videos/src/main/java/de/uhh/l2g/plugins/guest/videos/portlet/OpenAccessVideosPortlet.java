package de.uhh.l2g.plugins.guest.videos.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.util.AutocompleteManager;

/**
 * @author isturm
 */

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=lecture2go.plugins",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.header-portlet-javascript=/js/jquery.socialshareprivacy.js",
				"com.liferay.portlet.header-portlet-javascript=/js/qrc.js",
				"com.liferay.portlet.header-portlet-javascript=/js/jquery.cookie.js",
				"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
				"com.liferay.portlet.header-portlet-javascript=/js/readmore.min.js",
//		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dotdotdot.min.js",
				"com.liferay.portlet.header-portlet-javascript=/js/jquery.mark.js",
				"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.guest.videos.js",
				"javax.portlet.display-name=Guest Videos",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS ,
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
public class OpenAccessVideosPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);

	@Override
	public void serveResource( ResourceRequest resourceRequest, ResourceResponse resourceResponse ) throws IOException, PortletException {
		//--- Autocomplete start
		//getting task name to do
		String task = ParamUtil.getString(resourceRequest, "task");
		if (Validator.isNull(task)) {
			return;
		}
		switch (task) {
			case"findVideos":
				// get writer for write data
				PrintWriter out = resourceResponse.getWriter();
				
				try {
					String searchText = ParamUtil.getString(resourceRequest, "searchText");
					int resultLimit = ParamUtil.getInteger(resourceRequest, "resultLimit");
				String elasticsearchResults = AutocompleteManager
						.getAutocompleteResultArrayBySearchWord(searchText, resultLimit).toString();
					out.println(elasticsearchResults);
				}
				catch(SearchException|ParseException e) {
					_log.error(e);
				}
				break;
		}
		//--- Autocomplete end
	}

}