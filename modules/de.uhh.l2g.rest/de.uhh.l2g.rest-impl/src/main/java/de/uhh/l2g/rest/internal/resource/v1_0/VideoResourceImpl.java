package de.uhh.l2g.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import de.uhh.l2g.plugins.service.VideoService;
import de.uhh.l2g.rest.dto.v1_0.Video;
import de.uhh.l2g.rest.resource.v1_0.VideoResource;

/**
 * @author Jonas Laacke
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/video.properties", scope = ServiceScope.PROTOTYPE, service = VideoResource.class)
public class VideoResourceImpl extends BaseVideoResourceImpl {

	@Reference
	private VideoService videoService;

	@Override
	public Page<Video> getVideosPage(Long lectureseriesId, Pagination pagination) throws Exception {
		List<de.uhh.l2g.plugins.model.Video> videos = videoService.getVideos(lectureseriesId,
				pagination.getStartPosition(), pagination.getEndPosition());
		return Page.of(videos.stream().map(video -> DTOMapper.toVideoDTO(video)).collect(Collectors.toList()),
				pagination, videoService.getVideoCount(lectureseriesId));
	}
}