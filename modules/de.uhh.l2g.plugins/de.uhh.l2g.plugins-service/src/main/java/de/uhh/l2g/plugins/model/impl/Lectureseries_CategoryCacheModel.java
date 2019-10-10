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

import de.uhh.l2g.plugins.model.Lectureseries_Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Lectureseries_Category in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryCacheModel
	implements CacheModel<Lectureseries_Category>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_CategoryCacheModel)) {
			return false;
		}

		Lectureseries_CategoryCacheModel lectureseries_CategoryCacheModel =
			(Lectureseries_CategoryCacheModel)obj;

		if (lectureseriesCategoryId ==
				lectureseries_CategoryCacheModel.lectureseriesCategoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lectureseriesCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{lectureseriesCategoryId=");
		sb.append(lectureseriesCategoryId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries_Category toEntityModel() {
		Lectureseries_CategoryImpl lectureseries_CategoryImpl =
			new Lectureseries_CategoryImpl();

		lectureseries_CategoryImpl.setLectureseriesCategoryId(
			lectureseriesCategoryId);
		lectureseries_CategoryImpl.setCategoryId(categoryId);
		lectureseries_CategoryImpl.setLectureseriesId(lectureseriesId);

		lectureseries_CategoryImpl.resetOriginalValues();

		return lectureseries_CategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesCategoryId = objectInput.readLong();

		categoryId = objectInput.readLong();

		lectureseriesId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lectureseriesCategoryId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(lectureseriesId);
	}

	public long lectureseriesCategoryId;
	public long categoryId;
	public long lectureseriesId;

}