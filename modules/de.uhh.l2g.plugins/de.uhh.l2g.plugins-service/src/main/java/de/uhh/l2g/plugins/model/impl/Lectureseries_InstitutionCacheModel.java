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

import de.uhh.l2g.plugins.model.Lectureseries_Institution;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Lectureseries_Institution in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Lectureseries_InstitutionCacheModel
	implements CacheModel<Lectureseries_Institution>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lectureseries_InstitutionCacheModel)) {
			return false;
		}

		Lectureseries_InstitutionCacheModel
			lectureseries_InstitutionCacheModel =
				(Lectureseries_InstitutionCacheModel)obj;

		if (lectureseriesInstitutionId ==
				lectureseries_InstitutionCacheModel.
					lectureseriesInstitutionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lectureseriesInstitutionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{lectureseriesInstitutionId=");
		sb.append(lectureseriesInstitutionId);
		sb.append(", lectureseriesId=");
		sb.append(lectureseriesId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", institutionParentId=");
		sb.append(institutionParentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lectureseries_Institution toEntityModel() {
		Lectureseries_InstitutionImpl lectureseries_InstitutionImpl =
			new Lectureseries_InstitutionImpl();

		lectureseries_InstitutionImpl.setLectureseriesInstitutionId(
			lectureseriesInstitutionId);
		lectureseries_InstitutionImpl.setLectureseriesId(lectureseriesId);
		lectureseries_InstitutionImpl.setInstitutionId(institutionId);
		lectureseries_InstitutionImpl.setInstitutionParentId(
			institutionParentId);

		lectureseries_InstitutionImpl.resetOriginalValues();

		return lectureseries_InstitutionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lectureseriesInstitutionId = objectInput.readLong();

		lectureseriesId = objectInput.readLong();

		institutionId = objectInput.readLong();

		institutionParentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lectureseriesInstitutionId);

		objectOutput.writeLong(lectureseriesId);

		objectOutput.writeLong(institutionId);

		objectOutput.writeLong(institutionParentId);
	}

	public long lectureseriesInstitutionId;
	public long lectureseriesId;
	public long institutionId;
	public long institutionParentId;

}