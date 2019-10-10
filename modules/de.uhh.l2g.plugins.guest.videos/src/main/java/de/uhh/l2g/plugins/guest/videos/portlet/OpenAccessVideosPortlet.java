package de.uhh.l2g.plugins.guest.videos.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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
		"com.liferay.portlet.header-portlet-javascript=/player/jwplayer-8.4.1/jwplayer.js",
		"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/readmore.min.js",
//		"com.liferay.portlet.header-portlet-javascript=/js/jquery.dotdotdot.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.mark.js",
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.guest.videos.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jwplayer.custom.util.js",
		"javax.portlet.display-name=Guest Videos", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class 
)
public class OpenAccessVideosPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);
	
	@Override
	public void serveResource( ResourceRequest resourceRequest, ResourceResponse resourceResponse ) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		if (cmd.equals("get_search_words")) {
			getSearchWords(resourceRequest, resourceResponse);
		}
		
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
	        	JSONArray searchWordsJsonArray = JSONFactoryUtil.createJSONArray();
	            searchWordsJsonArray = AutocompleteManager.SEARCH_WORDS_JSONArray;
	            _log.info("Search words array size" + searchWordsJsonArray.length());
	            out.println(searchWordsJsonArray.toString());
	            _log.info("End serveResource method");	
	            break;
	    }
		//--- Autocomplete end
	}
	
	public static JSONArray wordsJSONArray = JSONFactoryUtil.createJSONArray();
	
	private void getSearchWords(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		PrintWriter out = resourceResponse.getWriter();
		out.println(wordsJSONArray);
	}
	
}