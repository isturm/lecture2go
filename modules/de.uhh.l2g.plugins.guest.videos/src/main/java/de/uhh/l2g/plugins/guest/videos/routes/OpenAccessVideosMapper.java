package de.uhh.l2g.plugins.guest.videos.routes;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;

@Component(
		 property = {
			 "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
			 "javax.portlet.name="+OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS
		 },
		 service = FriendlyURLMapper.class
)
public class OpenAccessVideosMapper extends DefaultFriendlyURLMapper {

	@Override
	 public String getMapping() {
		return "get";
	 }
}
