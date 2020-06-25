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

import de.uhh.l2g.plugins.model.Video_MediaType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Video_MediaType in entity cache.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Video_MediaTypeCacheModel
	implements CacheModel<Video_MediaType>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_MediaTypeCacheModel)) {
			return false;
		}

		Video_MediaTypeCacheModel video_MediaTypeCacheModel =
			(Video_MediaTypeCacheModel)obj;

		if (videoMediaTypeId == video_MediaTypeCacheModel.videoMediaTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, videoMediaTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoMediaTypeId=");
		sb.append(videoMediaTypeId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", MediaTypeId=");
		sb.append(MediaTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video_MediaType toEntityModel() {
		Video_MediaTypeImpl video_MediaTypeImpl = new Video_MediaTypeImpl();

		video_MediaTypeImpl.setVideoMediaTypeId(videoMediaTypeId);
		video_MediaTypeImpl.setVideoId(videoId);
		video_MediaTypeImpl.setMediaTypeId(MediaTypeId);

		video_MediaTypeImpl.resetOriginalValues();

		return video_MediaTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videoMediaTypeId = objectInput.readLong();

		videoId = objectInput.readLong();

		MediaTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(videoMediaTypeId);

		objectOutput.writeLong(videoId);

		objectOutput.writeLong(MediaTypeId);
	}

	public long videoMediaTypeId;
	public long videoId;
	public long MediaTypeId;

}