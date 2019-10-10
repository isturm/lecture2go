package de.uhh.l2g.plugins.guest.frontpage.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.URLStringEncoder;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.guest.frontpage.constants.FrontPagePortletKeys;
import de.uhh.l2g.plugins.util.AutocompleteManager;
import de.uhh.l2g.plugins.util.HTMLFilter;


/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		//"com.liferay.portlet.header-portlet-javascript=/js/jquery.dotdotdot.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.frontpage.js",
		"javax.portlet.display-name=Guest Frontpage",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FrontPagePortletKeys.FrontPage,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class FrontPagePortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(FrontPagePortlet.class);

	@ProcessAction(name="search")
	public void search(ActionRequest req, ActionResponse res){
		String findVideos = ParamUtil.getString(req, "findVideos");
		//XSS anti scripting required!
		HTMLFilter hF = new HTMLFilter();
		findVideos = hF.filter(findVideos);
		//Encode URL to string 
		try {
			String partUrl = PropsUtil.get("lecture2go.web.root") + "/web/vod/l2go/-/get/0/0/0/0/0/";
			URLStringEncoder encoder = new URLStringEncoder();
			String url=partUrl+encoder.encode(findVideos);
			System.out.println(url);
			res.sendRedirect(url); 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} 
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		log.info("Executing serveResource method");
	    //getting task name to do
	    String task = ParamUtil.getString(resourceRequest, "task");
	    if (Validator.isNull(task)) {
	        return;
	    }
	    // get theme display object
	    // get writer for write data
	    PrintWriter out = resourceResponse.getWriter();
	    JSONArray searchWordsJsonArray = JSONFactoryUtil.createJSONArray();
	    switch (task) {
	        case"findVideos":
	            searchWordsJsonArray = AutocompleteManager.SEARCH_WORDS_JSONArray;
	            break;
	    }
	    log.info("Search words array size" + searchWordsJsonArray.length());
	    out.println(searchWordsJsonArray.toString());
	    log.info("End serveResource method");
	}
}