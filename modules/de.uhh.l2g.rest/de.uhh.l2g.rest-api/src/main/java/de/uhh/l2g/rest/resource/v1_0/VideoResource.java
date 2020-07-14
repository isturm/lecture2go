package de.uhh.l2g.rest.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import de.uhh.l2g.rest.dto.v1_0.Video;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/lecture2go/v1.0
 *
 * @author Jonas Laacke
 * @generated
 */
@Generated("")
public interface VideoResource {

	public Page<Video> getVideosPage(
			Long lectureseriesId, Boolean producerRestricted,
			Pagination pagination)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}