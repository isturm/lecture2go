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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video
 * @generated
 */
@ProviderType
public class VideoWrapper
	extends BaseModelWrapper<Video> implements Video, ModelWrapper<Video> {

	public VideoWrapper(Video video) {
		super(video);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoId", getVideoId());
		attributes.put("title", getTitle());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());
		attributes.put("containerFormat", getContainerFormat());
		attributes.put("filename", getFilename());
		attributes.put("resolution", getResolution());
		attributes.put("duration", getDuration());
		attributes.put("hostId", getHostId());
		attributes.put("fileSize", getFileSize());
		attributes.put("generationDate", getGenerationDate());
		attributes.put("openAccess", getOpenAccess());
		attributes.put("downloadLink", getDownloadLink());
		attributes.put("metadataId", getMetadataId());
		attributes.put("secureFilename", getSecureFilename());
		attributes.put("hits", getHits());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("permittedToSegment", getPermittedToSegment());
		attributes.put("rootInstitutionId", getRootInstitutionId());
		attributes.put("citation2go", getCitation2go());
		attributes.put("termId", getTermId());
		attributes.put("tags", getTags());
		attributes.put("password", getPassword());
		attributes.put("licenseId", getLicenseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String containerFormat = (String)attributes.get("containerFormat");

		if (containerFormat != null) {
			setContainerFormat(containerFormat);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String resolution = (String)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String generationDate = (String)attributes.get("generationDate");

		if (generationDate != null) {
			setGenerationDate(generationDate);
		}

		Integer openAccess = (Integer)attributes.get("openAccess");

		if (openAccess != null) {
			setOpenAccess(openAccess);
		}

		Integer downloadLink = (Integer)attributes.get("downloadLink");

		if (downloadLink != null) {
			setDownloadLink(downloadLink);
		}

		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String secureFilename = (String)attributes.get("secureFilename");

		if (secureFilename != null) {
			setSecureFilename(secureFilename);
		}

		Long hits = (Long)attributes.get("hits");

		if (hits != null) {
			setHits(hits);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}

		Integer permittedToSegment = (Integer)attributes.get(
			"permittedToSegment");

		if (permittedToSegment != null) {
			setPermittedToSegment(permittedToSegment);
		}

		Long rootInstitutionId = (Long)attributes.get("rootInstitutionId");

		if (rootInstitutionId != null) {
			setRootInstitutionId(rootInstitutionId);
		}

		Integer citation2go = (Integer)attributes.get("citation2go");

		if (citation2go != null) {
			setCitation2go(citation2go);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Integer getAccessPermitted() {
		return model.getAccessPermitted();
	}

	@Override
	public String getBitrate() {
		return model.getBitrate();
	}

	/**
	 * Returns the citation2go of this video.
	 *
	 * @return the citation2go of this video
	 */
	@Override
	public int getCitation2go() {
		return model.getCitation2go();
	}

	/**
	 * Returns the company ID of this video.
	 *
	 * @return the company ID of this video
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the container format of this video.
	 *
	 * @return the container format of this video
	 */
	@Override
	public String getContainerFormat() {
		return model.getContainerFormat();
	}

	/**
	 * Returns the create date of this video.
	 *
	 * @return the create date of this video
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getCreatorFullName() {
		return model.getCreatorFullName();
	}

	@Override
	public String getCreators() {
		return model.getCreators();
	}

	/**
	 * Returns the current file name depending on openaccess field
	 */
	@Override
	public String getCurrentFilename() {
		return model.getCurrentFilename();
	}

	/**
	 * Returns the current filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 * Checks if prefix is _openaccess_ or secure and returns the correct one.
	 */
	@Override
	public String getCurrentMp4FilenameWithReasonableBitrate() {
		return model.getCurrentMp4FilenameWithReasonableBitrate();
	}

	/**
	 * Returns the current file prefix depending on openaccess field
	 */
	@Override
	public String getCurrentPrefix() {
		return model.getCurrentPrefix();
	}

	/**
	 * Returns the current URL depending on the openaccess field
	 */
	@Override
	public String getCurrentURL() {
		return model.getCurrentURL();
	}

	/**
	 * Returns the formatted generation date with time
	 */
	@Override
	public String getDate() {
		return model.getDate();
	}

	/**
	 * Returns the download link of this video.
	 *
	 * @return the download link of this video
	 */
	@Override
	public int getDownloadLink() {
		return model.getDownloadLink();
	}

	/**
	 * Returns the duration of this video.
	 *
	 * @return the duration of this video
	 */
	@Override
	public String getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the complete embed code for commsy depending on the openaccess field
	 */
	@Override
	public String getEmbedCommsy() {
		return model.getEmbedCommsy();
	}

	/**
	 * Returns the complete html5 embed code depending on the openaccess field and container format
	 */
	@Override
	public String getEmbedHtml5() {
		return model.getEmbedHtml5();
	}

	/**
	 * Returns the complete iframe embed code (usable for openaccess and non-openaccess videos)
	 */
	@Override
	public String getEmbedIframe() {
		return model.getEmbedIframe();
	}

	/**
	 * Returns the filename of this video.
	 *
	 * @return the filename of this video
	 */
	@Override
	public String getFilename() {
		return model.getFilename();
	}

	/**
	 * Returns the file size of this video.
	 *
	 * @return the file size of this video
	 */
	@Override
	public String getFileSize() {
		return model.getFileSize();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getFlvDownloadLink() {
		return model.getFlvDownloadLink();
	}

	/**
	 * Returns the flv file (unchecked if existing)
	 */
	@Override
	public java.io.File getFlvFile() {
		return model.getFlvFile();
	}

	@Override
	public String getFlvRssLink() {
		return model.getFlvRssLink();
	}

	/**
	 * Returns the generation date of this video.
	 *
	 * @return the generation date of this video
	 */
	@Override
	public String getGenerationDate() {
		return model.getGenerationDate();
	}

	/**
	 * Returns the group ID of this video.
	 *
	 * @return the group ID of this video
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hits of this video.
	 *
	 * @return the hits of this video
	 */
	@Override
	public long getHits() {
		return model.getHits();
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getHost() {
		return model.getHost();
	}

	/**
	 * Returns the host ID of this video.
	 *
	 * @return the host ID of this video
	 */
	@Override
	public long getHostId() {
		return model.getHostId();
	}

	/**
	 * Returns the image in original size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the image in medium size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImageMedium() {
		return model.getImageMedium();
	}

	/**
	 * Returns the image in small size (checks which file should be used (thumbnail, audio, ... ))
	 */
	@Override
	public String getImageSmall() {
		return model.getImageSmall();
	}

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerTracks() {
		return model.getJsonPlayerTracks();
	}

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerUris() {
		return model.getJsonPlayerUris();
	}

	/**
	 * Returns the lectureseries ID of this video.
	 *
	 * @return the lectureseries ID of this video
	 */
	@Override
	public long getLectureseriesId() {
		return model.getLectureseriesId();
	}

	@Override
	public String getLectureseriesName() {
		return model.getLectureseriesName();
	}

	@Override
	public String getLectureseriesNumber() {
		return model.getLectureseriesNumber();
	}

	/**
	 * Returns the complete URL to the lectureseries of this video
	 */
	@Override
	public String getLectureseriesUrl() {
		return model.getLectureseriesUrl();
	}

	/**
	 * Returns the license ID of this video.
	 *
	 * @return the license ID of this video
	 */
	@Override
	public long getLicenseId() {
		return model.getLicenseId();
	}

	@Override
	public String getLinkedCreators() {
		return model.getLinkedCreators();
	}

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	@Override
	public String getM4aDownloadLink() {
		return model.getM4aDownloadLink();
	}

	/**
	 * Returns the m4a file (unchecked if existing)
	 */
	@Override
	public java.io.File getM4aFile() {
		return model.getM4aFile();
	}

	@Override
	public String getM4aRssLink() {
		return model.getM4aRssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getM4vDownloadLink() {
		return model.getM4vDownloadLink();
	}

	/**
	 * Returns the m4v file (unchecked if existing)
	 */
	@Override
	public java.io.File getM4vFile() {
		return model.getM4vFile();
	}

	@Override
	public String getM4vRssLink() {
		return model.getM4vRssLink();
	}

	/**
	 * Returns the metadata ID of this video.
	 *
	 * @return the metadata ID of this video
	 */
	@Override
	public long getMetadataId() {
		return model.getMetadataId();
	}

	/**
	 * Returns the modified date of this video.
	 *
	 * @return the modified date of this video
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	@Override
	public String getMp3DownloadLink() {
		return model.getMp3DownloadLink();
	}

	/**
	 * Returns the mp3 file (unchecked if existing)
	 */
	@Override
	public java.io.File getMp3File() {
		return model.getMp3File();
	}

	@Override
	public String getMp3RssLink() {
		return model.getMp3RssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getMp4DownloadLink() {
		return model.getMp4DownloadLink();
	}

	/**
	 * Returns the mp4 file (unchecked if existing)
	 */
	@Override
	public java.io.File getMp4File() {
		return model.getMp4File();
	}

	/**
	 * Returns the _openaccess_ filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	@Override
	public String getMp4FilenameWithReasonableBitrate() {
		return model.getMp4FilenameWithReasonableBitrate();
	}

	@Override
	public String getMp4RssLink() {
		return model.getMp4RssLink();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getOggDownloadLink() {
		return model.getOggDownloadLink();
	}

	/**
	 * Returns the ogg file (unchecked if existing)
	 */
	@Override
	public java.io.File getOggFile() {
		return model.getOggFile();
	}

	@Override
	public String getOggRssLink() {
		return model.getOggRssLink();
	}

	/**
	 * Returns the open access of this video.
	 *
	 * @return the open access of this video
	 */
	@Override
	public int getOpenAccess() {
		return model.getOpenAccess();
	}

	/**
	 * Returns the password of this video.
	 *
	 * @return the password of this video
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getPdfDownloadLink() {
		return model.getPdfDownloadLink();
	}

	/**
	 * Returns the pdf file (unchecked if existing)
	 */
	@Override
	public java.io.File getPdfFile() {
		return model.getPdfFile();
	}

	/**
	 * Returns the permitted to segment of this video.
	 *
	 * @return the permitted to segment of this video
	 */
	@Override
	public int getPermittedToSegment() {
		return model.getPermittedToSegment();
	}

	@Override
	public java.util.ArrayList<String> getPlayerUris() {
		return model.getPlayerUris();
	}

	/**
	 * Returns the open access prefix of the file (filename without extension)
	 */
	@Override
	public String getPreffix() {
		return model.getPreffix();
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public de.uhh.l2g.plugins.model.Producer getProducer() {
		return model.getProducer();
	}

	/**
	 * Returns the producer ID of this video.
	 *
	 * @return the producer ID of this video
	 */
	@Override
	public long getProducerId() {
		return model.getProducerId();
	}

	/**
	 * Returns the resolution of this video.
	 *
	 * @return the resolution of this video
	 */
	@Override
	public String getResolution() {
		return model.getResolution();
	}

	/**
	 * Returns the root institution ID of this video.
	 *
	 * @return the root institution ID of this video
	 */
	@Override
	public long getRootInstitutionId() {
		return model.getRootInstitutionId();
	}

	/**
	 * Returns the secure filename of this video.
	 *
	 * @return the secure filename of this video
	 */
	@Override
	public String getSecureFilename() {
		return model.getSecureFilename();
	}

	/**
	 * Returns the secure filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	@Override
	public String getSecureMp4FilenameWithReasonableBitrate() {
		return model.getSecureMp4FilenameWithReasonableBitrate();
	}

	/**
	 * Returns the complete secure URL to the NON open access video
	 */
	@Override
	public String getSecureUrl() {
		return model.getSecureUrl();
	}

	/**
	 * Returns the title in a truncated form
	 */
	@Override
	public String getShortTitle() {
		return model.getShortTitle();
	}

	/**
	 * Returns the formatted generation date without time
	 */
	@Override
	public String getSimpleDate() {
		return model.getSimpleDate();
	}

	/**
	 * Returns the secure prefix of the file (filename without extension)
	 */
	@Override
	public String getSPreffix() {
		return model.getSPreffix();
	}

	/**
	 * Returns the tags of this video.
	 *
	 * @return the tags of this video
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the term ID of this video.
	 *
	 * @return the term ID of this video
	 */
	@Override
	public long getTermId() {
		return model.getTermId();
	}

	/**
	 * Returns the title of this video.
	 *
	 * @return the title of this video
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the upload date of this video.
	 *
	 * @return the upload date of this video
	 */
	@Override
	public Date getUploadDate() {
		return model.getUploadDate();
	}

	/**
	 * Returns the complete URL to the open access video
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this video.
	 *
	 * @return the user name of this video
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the video ID of this video.
	 *
	 * @return the video ID of this video
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	/**
	 * Returns the url to the vtt-caption-file
	 */
	@Override
	public String getVttCaptionUrl() {
		return model.getVttCaptionUrl();
	}

	/**
	 * Returns the path to the vtt-chapter-file
	 */
	@Override
	public String getVttChapterFile() {
		return model.getVttChapterFile();
	}

	/**
	 * Returns the vtt file (unchecked if existing) from the user repository
	 */
	@Override
	public java.io.File getVttFile() {
		return model.getVttFile();
	}

	@Override
	public String getVttThumbsFilde() {
		return model.getVttThumbsFilde();
	}

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	@Override
	public String getWebmDownloadLink() {
		return model.getWebmDownloadLink();
	}

	/**
	 * Returns the webm file (unchecked if existing)
	 */
	@Override
	public java.io.File getWebmFile() {
		return model.getWebmFile();
	}

	@Override
	public String getWebmRssLink() {
		return model.getWebmRssLink();
	}

	@Override
	public boolean isHasCaption() {
		return model.isHasCaption();
	}

	/**
	 * Checks if file has chapters
	 */
	@Override
	public boolean isHasChapters() {
		return model.isHasChapters();
	}

	@Override
	public boolean isHasComments() {
		return model.isHasComments();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void setAccessPermitted(Integer accessPermitted) {
		model.setAccessPermitted(accessPermitted);
	}

	@Override
	public void setBitrate(String bitrate) {
		model.setBitrate(bitrate);
	}

	/**
	 * Sets the citation2go of this video.
	 *
	 * @param citation2go the citation2go of this video
	 */
	@Override
	public void setCitation2go(int citation2go) {
		model.setCitation2go(citation2go);
	}

	/**
	 * Sets the company ID of this video.
	 *
	 * @param companyId the company ID of this video
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the container format of this video.
	 *
	 * @param containerFormat the container format of this video
	 */
	@Override
	public void setContainerFormat(String containerFormat) {
		model.setContainerFormat(containerFormat);
	}

	/**
	 * Sets the create date of this video.
	 *
	 * @param createDate the create date of this video
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	@Override
	public void setCreatorFullName(String creatorFullName) {
		model.setCreatorFullName(creatorFullName);
	}

	@Override
	public void setCreators(String creators) {
		model.setCreators(creators);
	}

	@Override
	public void setDate(String date) {
		model.setDate(date);
	}

	/**
	 * Sets the download link of this video.
	 *
	 * @param downloadLink the download link of this video
	 */
	@Override
	public void setDownloadLink(int downloadLink) {
		model.setDownloadLink(downloadLink);
	}

	/**
	 * Sets the duration of this video.
	 *
	 * @param duration the duration of this video
	 */
	@Override
	public void setDuration(String duration) {
		model.setDuration(duration);
	}

	@Override
	public void setEmbedCommsy(String embedCommsy) {
		model.setEmbedCommsy(embedCommsy);
	}

	@Override
	public void setEmbedHtml5(String embedHtml5) {
		model.setEmbedHtml5(embedHtml5);
	}

	@Override
	public void setEmbedIframe(String embedIframe) {
		model.setEmbedIframe(embedIframe);
	}

	/**
	 * Sets the filename of this video.
	 *
	 * @param filename the filename of this video
	 */
	@Override
	public void setFilename(String filename) {
		model.setFilename(filename);
	}

	/**
	 * Sets the file size of this video.
	 *
	 * @param fileSize the file size of this video
	 */
	@Override
	public void setFileSize(String fileSize) {
		model.setFileSize(fileSize);
	}

	@Override
	public void setFlvDownloadLink(String flvDownloadLink) {
		model.setFlvDownloadLink(flvDownloadLink);
	}

	@Override
	public void setFlvFile(java.io.File flvFile) {
		model.setFlvFile(flvFile);
	}

	@Override
	public void setFlvRssLink(String flvRssLink) {
		model.setFlvRssLink(flvRssLink);
	}

	/**
	 * Sets the generation date of this video.
	 *
	 * @param generationDate the generation date of this video
	 */
	@Override
	public void setGenerationDate(String generationDate) {
		model.setGenerationDate(generationDate);
	}

	/**
	 * Sets the group ID of this video.
	 *
	 * @param groupId the group ID of this video
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	@Override
	public void setHasComments(boolean hasComments) {
		model.setHasComments(hasComments);
	}

	/**
	 * Sets the hits of this video.
	 *
	 * @param hits the hits of this video
	 */
	@Override
	public void setHits(long hits) {
		model.setHits(hits);
	}

	/**
	 * Sets the host ID of this video.
	 *
	 * @param hostId the host ID of this video
	 */
	@Override
	public void setHostId(long hostId) {
		model.setHostId(hostId);
	}

	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	@Override
	public void setImageMedium(String imageMedium) {
		model.setImageMedium(imageMedium);
	}

	@Override
	public void setImageSmall(String imageSmall) {
		model.setImageSmall(imageSmall);
	}

	@Override
	public void setJsonPlayerTracks(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerTracks) {

		model.setJsonPlayerTracks(jsonPlayerTracks);
	}

	@Override
	public void setJsonPlayerUris(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerUris) {

		model.setJsonPlayerUris(jsonPlayerUris);
	}

	/**
	 * Sets the lectureseries ID of this video.
	 *
	 * @param lectureseriesId the lectureseries ID of this video
	 */
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		model.setLectureseriesId(lectureseriesId);
	}

	@Override
	public void setLectureseriesName(String lectureseriesName) {
		model.setLectureseriesName(lectureseriesName);
	}

	@Override
	public void setLectureseriesNumber(String lectureseriesNumber) {
		model.setLectureseriesNumber(lectureseriesNumber);
	}

	@Override
	public void setLectureseriesUrl(String lectureseriesUrl) {
		model.setLectureseriesUrl(lectureseriesUrl);
	}

	/**
	 * Sets the license ID of this video.
	 *
	 * @param licenseId the license ID of this video
	 */
	@Override
	public void setLicenseId(long licenseId) {
		model.setLicenseId(licenseId);
	}

	@Override
	public void setLinkedCreators(String linkedCreators) {
		model.setLinkedCreators(linkedCreators);
	}

	@Override
	public void setM4aDownloadLink(String m4aDownloadLink) {
		model.setM4aDownloadLink(m4aDownloadLink);
	}

	@Override
	public void setM4aFile(java.io.File m4aFile) {
		model.setM4aFile(m4aFile);
	}

	@Override
	public void setM4aRssLink(String m4aRssLink) {
		model.setM4aRssLink(m4aRssLink);
	}

	@Override
	public void setM4vDownloadLink(String m4vDownloadLink) {
		model.setM4vDownloadLink(m4vDownloadLink);
	}

	@Override
	public void setM4vFile(java.io.File m4vFile) {
		model.setM4vFile(m4vFile);
	}

	@Override
	public void setM4vRssLink(String m4vRssLink) {
		model.setM4vRssLink(m4vRssLink);
	}

	/**
	 * Sets the metadata ID of this video.
	 *
	 * @param metadataId the metadata ID of this video
	 */
	@Override
	public void setMetadataId(long metadataId) {
		model.setMetadataId(metadataId);
	}

	/**
	 * Sets the modified date of this video.
	 *
	 * @param modifiedDate the modified date of this video
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	@Override
	public void setMp3DownloadLink(String mp3DownloadLink) {
		model.setMp3DownloadLink(mp3DownloadLink);
	}

	@Override
	public void setMp3File(java.io.File mp3File) {
		model.setMp3File(mp3File);
	}

	@Override
	public void setMp3RssLink(String mp3RssLink) {
		model.setMp3RssLink(mp3RssLink);
	}

	@Override
	public void setMp4DownloadLink(String mp4DownloadLink) {
		model.setMp4DownloadLink(mp4DownloadLink);
	}

	@Override
	public void setMp4File(java.io.File mp4File) {
		model.setMp4File(mp4File);
	}

	@Override
	public void setMp4RssLink(String mp4RssLink) {
		model.setMp4RssLink(mp4RssLink);
	}

	@Override
	public void setOggDownloadLink(String oggDownloadLink) {
		model.setOggDownloadLink(oggDownloadLink);
	}

	@Override
	public void setOggFile(java.io.File oggFile) {
		model.setOggFile(oggFile);
	}

	@Override
	public void setOggRssLink(String oggRssLink) {
		model.setOggRssLink(oggRssLink);
	}

	/**
	 * Sets the open access of this video.
	 *
	 * @param openAccess the open access of this video
	 */
	@Override
	public void setOpenAccess(int openAccess) {
		model.setOpenAccess(openAccess);
	}

	/**
	 * Sets the password of this video.
	 *
	 * @param password the password of this video
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	@Override
	public void setPdfDownloadLink(String pdfDownloadLink) {
		model.setPdfDownloadLink(pdfDownloadLink);
	}

	@Override
	public void setPdfFile(java.io.File pdfFile) {
		model.setPdfFile(pdfFile);
	}

	/**
	 * Sets the permitted to segment of this video.
	 *
	 * @param permittedToSegment the permitted to segment of this video
	 */
	@Override
	public void setPermittedToSegment(int permittedToSegment) {
		model.setPermittedToSegment(permittedToSegment);
	}

	@Override
	public void setPlayerUris(java.util.ArrayList<String> playerUris) {
		model.setPlayerUris(playerUris);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producer ID of this video.
	 *
	 * @param producerId the producer ID of this video
	 */
	@Override
	public void setProducerId(long producerId) {
		model.setProducerId(producerId);
	}

	/**
	 * Sets the resolution of this video.
	 *
	 * @param resolution the resolution of this video
	 */
	@Override
	public void setResolution(String resolution) {
		model.setResolution(resolution);
	}

	/**
	 * Sets the root institution ID of this video.
	 *
	 * @param rootInstitutionId the root institution ID of this video
	 */
	@Override
	public void setRootInstitutionId(long rootInstitutionId) {
		model.setRootInstitutionId(rootInstitutionId);
	}

	/**
	 * Sets the secure filename of this video.
	 *
	 * @param secureFilename the secure filename of this video
	 */
	@Override
	public void setSecureFilename(String secureFilename) {
		model.setSecureFilename(secureFilename);
	}

	@Override
	public void setSecureUrl(String secureUrl) {
		model.setSecureUrl(secureUrl);
	}

	@Override
	public void setShortTitle(String shortTitle) {
		model.setShortTitle(shortTitle);
	}

	@Override
	public void setSimpleDate(String simpleDate) {
		model.setSimpleDate(simpleDate);
	}

	/**
	 * Sets the tags of this video.
	 *
	 * @param tags the tags of this video
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the term ID of this video.
	 *
	 * @param termId the term ID of this video
	 */
	@Override
	public void setTermId(long termId) {
		model.setTermId(termId);
	}

	/**
	 * Sets the title of this video.
	 *
	 * @param title the title of this video
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the upload date of this video.
	 *
	 * @param uploadDate the upload date of this video
	 */
	@Override
	public void setUploadDate(Date uploadDate) {
		model.setUploadDate(uploadDate);
	}

	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this video.
	 *
	 * @param userName the user name of this video
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the video ID of this video.
	 *
	 * @param videoId the video ID of this video
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	@Override
	public void setVttCaptionUrl(String vttCaptionUrl) {
		model.setVttCaptionUrl(vttCaptionUrl);
	}

	@Override
	public void setVttChapterFile(String vttChapterFile) {
		model.setVttChapterFile(vttChapterFile);
	}

	@Override
	public void setVttFile(java.io.File vttFile) {
		model.setVttFile(vttFile);
	}

	@Override
	public void setVttThumbsFilde(String vttThumbsFilde) {
		model.setVttThumbsFilde(vttThumbsFilde);
	}

	@Override
	public void setWebmDownloadLink(String webmDownloadLink) {
		model.setWebmDownloadLink(webmDownloadLink);
	}

	@Override
	public void setWebmFile(java.io.File webmFile) {
		model.setWebmFile(webmFile);
	}

	@Override
	public void setWebmRssLink(String webmRssLink) {
		model.setWebmRssLink(webmRssLink);
	}

	@Override
	protected VideoWrapper wrap(Video video) {
		return new VideoWrapper(video);
	}

}