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

package de.uhh.l2g.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Video_MediaTypeSoap implements Serializable {

	public static Video_MediaTypeSoap toSoapModel(Video_MediaType model) {
		Video_MediaTypeSoap soapModel = new Video_MediaTypeSoap();

		soapModel.setVideoMediaTypeId(model.getVideoMediaTypeId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setMediaTypeId(model.getMediaTypeId());

		return soapModel;
	}

	public static Video_MediaTypeSoap[] toSoapModels(Video_MediaType[] models) {
		Video_MediaTypeSoap[] soapModels =
			new Video_MediaTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Video_MediaTypeSoap[][] toSoapModels(
		Video_MediaType[][] models) {

		Video_MediaTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new Video_MediaTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Video_MediaTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Video_MediaTypeSoap[] toSoapModels(
		List<Video_MediaType> models) {

		List<Video_MediaTypeSoap> soapModels =
			new ArrayList<Video_MediaTypeSoap>(models.size());

		for (Video_MediaType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Video_MediaTypeSoap[soapModels.size()]);
	}

	public Video_MediaTypeSoap() {
	}

	public long getPrimaryKey() {
		return _videoMediaTypeId;
	}

	public void setPrimaryKey(long pk) {
		setVideoMediaTypeId(pk);
	}

	public long getVideoMediaTypeId() {
		return _videoMediaTypeId;
	}

	public void setVideoMediaTypeId(long videoMediaTypeId) {
		_videoMediaTypeId = videoMediaTypeId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getMediaTypeId() {
		return _MediaTypeId;
	}

	public void setMediaTypeId(long MediaTypeId) {
		_MediaTypeId = MediaTypeId;
	}

	private long _videoMediaTypeId;
	private long _videoId;
	private long _MediaTypeId;

}