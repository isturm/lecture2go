package de.uhh.l2g.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import de.uhh.l2g.rest.dto.v1_0.Lectureseries;
import de.uhh.l2g.rest.dto.v1_0.Video;
import de.uhh.l2g.rest.resource.v1_0.LectureseriesResource;
import de.uhh.l2g.rest.resource.v1_0.VideoResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Jonas Laacke
 * @generated
 */
@Generated("")
public class Query {

	public static void setLectureseriesResourceComponentServiceObjects(
		ComponentServiceObjects<LectureseriesResource>
			lectureseriesResourceComponentServiceObjects) {

		_lectureseriesResourceComponentServiceObjects =
			lectureseriesResourceComponentServiceObjects;
	}

	public static void setVideoResourceComponentServiceObjects(
		ComponentServiceObjects<VideoResource>
			videoResourceComponentServiceObjects) {

		_videoResourceComponentServiceObjects =
			videoResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Lectureseries getLectureseries(
			@GraphQLName("lectureseriesId") Long lectureseriesId)
		throws Exception {

		return _applyComponentServiceObjects(
			_lectureseriesResourceComponentServiceObjects,
			this::_populateResourceContext,
			lectureseriesResource -> lectureseriesResource.getLectureseries(
				lectureseriesId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Video> getVideosPage(
			@GraphQLName("lectureseriesId") Long lectureseriesId,
			@GraphQLName("producerRestricted") Boolean producerRestricted,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_videoResourceComponentServiceObjects,
			this::_populateResourceContext,
			videoResource -> {
				Page paginationPage = videoResource.getVideosPage(
					lectureseriesId, producerRestricted,
					Pagination.of(pageSize, page));

				return paginationPage.getItems();
			});
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			LectureseriesResource lectureseriesResource)
		throws Exception {

		lectureseriesResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(VideoResource videoResource)
		throws Exception {

		videoResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<LectureseriesResource>
		_lectureseriesResourceComponentServiceObjects;
	private static ComponentServiceObjects<VideoResource>
		_videoResourceComponentServiceObjects;

}