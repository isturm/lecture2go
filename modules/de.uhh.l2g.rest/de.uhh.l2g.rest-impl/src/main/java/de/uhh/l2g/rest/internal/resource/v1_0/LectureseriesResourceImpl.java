package de.uhh.l2g.rest.internal.resource.v1_0;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import de.uhh.l2g.plugins.service.LectureseriesService;
import de.uhh.l2g.rest.dto.v1_0.Lectureseries;
import de.uhh.l2g.rest.resource.v1_0.LectureseriesResource;

/**
 * @author Jonas Laacke
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/lectureseries.properties", scope = ServiceScope.PROTOTYPE, service = LectureseriesResource.class)
public class LectureseriesResourceImpl extends BaseLectureseriesResourceImpl {

	@Reference
	private LectureseriesService lectureseriesService;

	@Override
	public Lectureseries getLectureseries(Long lectureseriesId) throws Exception {
		return DTOMapper.toLectureseriesDTO(lectureseriesService.getLectureSeries(lectureseriesId));
	}
}