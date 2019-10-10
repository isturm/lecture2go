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

import de.uhh.l2g.plugins.model.Video_Creator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Video_Creator in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Video_CreatorCacheModel
	implements CacheModel<Video_Creator>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_CreatorCacheModel)) {
			return false;
		}

		Video_CreatorCacheModel video_CreatorCacheModel =
			(Video_CreatorCacheModel)obj;

		if (videoCreatorId == video_CreatorCacheModel.videoCreatorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, videoCreatorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoCreatorId=");
		sb.append(videoCreatorId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_Creator toEntityModel() {
		Video_CreatorImpl video_CreatorImpl = new Video_CreatorImpl();

		video_CreatorImpl.setVideoCreatorId(videoCreatorId);
		video_CreatorImpl.setCreatorId(creatorId);
		video_CreatorImpl.setVideoId(videoId);

		video_CreatorImpl.resetOriginalValues();

		return video_CreatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoCreatorId = objectInput.readLong();

		creatorId = objectInput.readLong();

		videoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(videoCreatorId);

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(videoId);
	}

	public long videoCreatorId;
	public long creatorId;
	public long videoId;

}