package de.uhh.l2g.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import de.uhh.l2g.rest.internal.graphql.mutation.v1_0.Mutation;
import de.uhh.l2g.rest.internal.graphql.query.v1_0.Query;
import de.uhh.l2g.rest.resource.v1_0.LectureseriesResource;
import de.uhh.l2g.rest.resource.v1_0.VideoResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Jonas Laacke
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Query.setLectureseriesResourceComponentServiceObjects(
			_lectureseriesResourceComponentServiceObjects);
		Query.setVideoResourceComponentServiceObjects(
			_videoResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/lecture2go-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<LectureseriesResource>
		_lectureseriesResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<VideoResource>
		_videoResourceComponentServiceObjects;

}