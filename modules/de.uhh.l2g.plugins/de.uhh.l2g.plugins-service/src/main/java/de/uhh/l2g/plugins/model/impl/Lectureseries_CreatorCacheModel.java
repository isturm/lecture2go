/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import de.uhh.l2g.plugins.model.Lectureseries_Creator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Lectureseries_Creator in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Lectureseries_CreatorCacheModel
	implements CacheModel<Lectureseries_Creator>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_CreatorCacheModel)) {
			return false;
		}

		Lectureseries_CreatorCacheModel lectureseries_CreatorCacheModel =
			(Lectureseries_CreatorCacheModel)obj;

		if (lectureseriesCreatorId ==
				lectureseries_CreatorCacheModel.lectureseriesCreatorId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lectureseriesCreatorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{lectureseriesCreatorId=");
		sb.append(lectureseriesCreatorId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries_Creator toEntityModel() {
		Lectureseries_CreatorImpl lectureseries_CreatorImpl =
			new Lectureseries_CreatorImpl();

		lectureseries_CreatorImpl.setLectureseriesCreatorId(
			lectureseriesCreatorId);
		lectureseries_CreatorImpl.setLectureseriesId(lectureseriesId);
		lectureseries_CreatorImpl.setCreatorId(creatorId);

		lectureseries_CreatorImpl.resetOriginalValues();

		return lectureseries_CreatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesCreatorId = objectInput.readLong();

		lectureseriesId = objectInput.readLong();

		creatorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lectureseriesCreatorId);

		objectOutput.writeLong(lectureseriesId);

		objectOutput.writeLong(creatorId);
	}

	public long lectureseriesCreatorId;
	public long lectureseriesId;
	public long creatorId;

}