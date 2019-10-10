package de.uhh.l2g.plugins.guest.videos.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;

@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS, 
	        "mvc.command.name=/view/action/list"
	    },
	    service = MVCActionCommand.class
	)
public class ViewActionList extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String searchQuery = ParamUtil.getString(actionRequest, "findVideos", "");
		actionResponse.addProperty("findVideos",searchQuery);
		actionRequest.setAttribute("findVideos",searchQuery);
	}

}
