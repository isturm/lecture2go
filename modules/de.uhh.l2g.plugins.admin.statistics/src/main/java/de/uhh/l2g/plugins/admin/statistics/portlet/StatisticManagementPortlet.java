package de.uhh.l2g.plugins.admin.statistics.portlet;

import de.uhh.l2g.plugins.admin.statistics.constants.StatisticManagementPortletKeys;
import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author isturm
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Admin Statistics",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StatisticManagementPortletKeys.StatisticManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StatisticManagementPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// ****** START - DO NOT USE IN PRODUCTION ******
		// this block is temporary for fixing the tagcloud table 
		// TagcloudLocalServiceUtil.generateForAllLectureseries();
		// ****** END ******

		//Update the statistics view 
		
		JSONObject jsonObject = StatisticLocalServiceUtil.getAllStatistics();
		JSONArray array = jsonObject.getJSONArray("statistic");

		String totalVideos = "-";
		String totalPublic = "";
		String totalPrivate = "";

		String totalYesterday = "0";
		String totalYesterdayPublic = "0";
		String totalYesterdayPrivate = "0";

		String totalOneWeek = "0";
		String totalOneWeekPublic = "0";
		String totalOneWeekPrivate = "0";

		String totalOneMonth = "0";
		String totalOneMonthPublic = "0";
		String totalOneMonthPrivate = "0";

		String totalOneYear ="0";
		String totalOneYearPublic = "0";
		String totalOneYearPrivate = "0";

		for(int i=0;i<array.length();i++){
		    JSONObject object = array.getJSONObject(i);
		    String timespan = (String)object.get("timespan");
		    
		    if(timespan.equals("0")){
		    	 totalVideos = object.get("total") + "";
		    	 totalPublic = object.get("public") + "";
				 totalPrivate = object.get("private") + "";    	
		    }
		    if(timespan.equals("DAY")){
				 totalYesterday = object.get("totalDiff") + "";
				 totalYesterdayPublic = object.get("publicDiff") + "";
				 totalYesterdayPrivate = object.get("privateDiff") + "";    	
		    }
		    if(timespan.equals("WEEK")){
				 totalOneWeek = object.get("totalDiff") + "";
				 totalOneWeekPublic = object.get("publicDiff") + "";
				 totalOneWeekPrivate = object.get("privateDiff") + "";  	
		    }
		    if(timespan.equals("MONTH")){
				 totalOneMonth = object.get("totalDiff") + "";
				 totalOneMonthPublic = object.get("publicDiff") + "";
				 totalOneMonthPrivate = object.get("privateDiff") + "";    	
		    }
		    if(timespan.equals("YEAR")){
				 totalOneYear = object.get("totalDiff") + "";
				 totalOneYearPublic = object.get("publicDiff") + "";
				 totalOneYearPrivate = object.get("privateDiff") + "";
		    }
		}
		
		renderRequest.setAttribute("totalVideos", totalVideos);
		renderRequest.setAttribute("totalPublic", totalPublic);
		renderRequest.setAttribute("totalPrivate", totalPrivate);
		
		renderRequest.setAttribute("totalYesterday", totalYesterday);
		renderRequest.setAttribute("totalYesterdayPublic", totalYesterdayPublic);
		renderRequest.setAttribute("totalYesterdayPrivate", totalYesterdayPrivate);
		
		renderRequest.setAttribute("totalOneWeek", totalOneWeek);
		renderRequest.setAttribute("totalOneWeekPublic", totalOneWeekPublic);
		renderRequest.setAttribute("totalOneWeekPrivate", totalOneWeekPrivate);
		
		renderRequest.setAttribute("totalOneMonth", totalOneMonth);
		renderRequest.setAttribute("totalOneMonthPublic", totalOneMonthPublic);
		renderRequest.setAttribute("totalOneMonthPrivate", totalOneMonthPrivate);
		
		renderRequest.setAttribute("totalOneYear", totalOneYear);
		renderRequest.setAttribute("totalOneYearPublic", totalOneYearPublic);
		renderRequest.setAttribute("totalOneYearPrivate", totalOneYearPrivate);
		
		super.render(renderRequest, renderResponse);
	}
}