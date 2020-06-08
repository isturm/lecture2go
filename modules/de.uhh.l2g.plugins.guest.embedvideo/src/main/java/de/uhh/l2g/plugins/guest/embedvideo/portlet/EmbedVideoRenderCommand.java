package de.uhh.l2g.plugins.guest.embedvideo.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import de.uhh.l2g.plugins.guest.embedvideo.constants.EmbedVideoPortletKeys;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author fho
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + EmbedVideoPortletKeys.EMBEDVIDEO,
				"mvc.command.name=/embed"
		},
		service = MVCRenderCommand.class
)
public class EmbedVideoRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		try {
			long videoId = Long.parseLong(ParamUtil.getString(renderRequest, "videoId"));
			Video video = VideoLocalServiceUtil.getVideo(videoId);
			String startTime = ParamUtil.getString(renderRequest, "startTime");
			String endTime = ParamUtil.getString(renderRequest, "endTime");
			int startTimeInt = 0;
			int endTimeInt = 0;
			if (!startTime.isEmpty() && !endTime.isEmpty()) {
				startTimeInt = Integer.parseInt(ParamUtil.getString(renderRequest, "startTime"));
				endTimeInt = Integer.parseInt(ParamUtil.getString(renderRequest, "endTime"));
			}

			renderRequest.setAttribute("citationAllowed", video.getCitation2go());
			renderRequest.setAttribute("image", video.getImage());
			renderRequest.setAttribute("uris", video.getJsonPlayerUris());
			renderRequest.setAttribute("tracks", video.getJsonPlayerTracks());
			renderRequest.setAttribute("startTime", startTimeInt);
			renderRequest.setAttribute("endTime", endTimeInt);
			renderRequest.setAttribute("sourceUrl", video.getCurrentURL());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return "/view.jsp";
	}
}