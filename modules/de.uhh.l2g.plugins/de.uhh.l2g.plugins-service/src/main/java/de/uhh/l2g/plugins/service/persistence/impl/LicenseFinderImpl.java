package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.persistence.LicenseFinder;

public class LicenseFinderImpl extends LicenseFinderBaseImpl implements LicenseFinder {
	public List<License> findByVideoIds(ArrayList<Long> videoIds) {
		if (videoIds == null || videoIds.isEmpty()) {
			return new ArrayList<License>();
		}

		ClassLoader classLoader = getClass().getClassLoader();

		DynamicQuery licenseIdQuery = DynamicQueryFactoryUtil.forClass(Video.class, classLoader)
				.add(RestrictionsFactoryUtil.in("videoId", videoIds))
				.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("licenseId")));

		DynamicQuery licenseQuery = DynamicQueryFactoryUtil.forClass(License.class, classLoader)
				.add(PropertyFactoryUtil.forName("licenseId").in(licenseIdQuery));

		List<License> licenses = licensePersistence.findWithDynamicQuery(licenseQuery);

		return licenses;
	}
}
