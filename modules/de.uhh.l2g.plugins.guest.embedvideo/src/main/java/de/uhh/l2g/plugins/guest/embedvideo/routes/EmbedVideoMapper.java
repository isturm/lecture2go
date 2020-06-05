package de.uhh.l2g.plugins.guest.embedvideo.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import de.uhh.l2g.plugins.guest.embedvideo.constants.EmbedVideoPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
		property = {
				"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
				"javax.portlet.name="+ EmbedVideoPortletKeys.EMBEDVIDEO,
				"mvc.command.name=/embed"
		},
		service = FriendlyURLMapper.class
)
public class EmbedVideoMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return "embed";
	}
}
