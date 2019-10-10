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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Video service. Represents a row in the &quot;LG_Video&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see VideoModel
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.VideoImpl")
@ProviderType
public interface Video extends PersistedModel, VideoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>de.uhh.l2g.plugins.model.impl.VideoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Video, Long> VIDEO_ID_ACCESSOR =
		new Accessor<Video, Long>() {

			@Override
			public Long get(Video video) {
				return video.getVideoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Video> getTypeClass() {
				return Video.class;
			}

		};

	public de.uhh.l2g.plugins.model.Host getHost();

	public de.uhh.l2g.plugins.model.Producer getProducer();

	/**
	 * Returns the current file prefix depending on openaccess field
	 */
	public String getCurrentPrefix();

	/**
	 * Returns the current file name depending on openaccess field
	 */
	public String getCurrentFilename();

	public String getLectureseriesName();

	public void setLectureseriesName(String lectureseriesName);

	public String getLectureseriesNumber();

	public void setLectureseriesNumber(String lectureseriesNumber);

	public String getCreatorFullName();

	public void setCreatorFullName(String creatorFullName);

	/**
	 * Returns the complete URL to the lectureseries of this video
	 */
	public String getLectureseriesUrl();

	public void setLectureseriesUrl(String lectureseriesUrl);

	public Integer getAccessPermitted();

	public void setAccessPermitted(Integer accessPermitted);

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerUris();

	public void setJsonPlayerUris(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerUris);

	public java.util.ArrayList<String> getPlayerUris();

	public void setPlayerUris(java.util.ArrayList<String> playerUris);

	/**
	 * Returns and sets the URIs for the video player as a JSONAray
	 */
	public com.liferay.portal.kernel.json.JSONArray getJsonPlayerTracks();

	public void setJsonPlayerTracks(
		com.liferay.portal.kernel.json.JSONArray jsonPlayerTracks);

	/**
	 * Returns the complete embed code for commsy depending on the openaccess field
	 */
	public String getEmbedCommsy();

	public void setEmbedCommsy(String embedCommsy);

	/**
	 * Returns the complete iframe embed code (usable for openaccess and non-openaccess videos)
	 */
	public String getEmbedIframe();

	public void setEmbedIframe(String embedIframe);

	/**
	 * Returns the complete html5 embed code depending on the openaccess field and container format
	 */
	public String getEmbedHtml5();

	public void setEmbedHtml5(String embedHtml5);

	/**
	 * Returns the path to the vtt-chapter-file
	 */
	public String getVttChapterFile();

	public void setVttChapterFile(String vttChapterFile);

	/**
	 * Returns the url to the vtt-caption-file
	 */
	public String getVttCaptionUrl();

	public void setVttCaptionUrl(String vttCaptionUrl);

	public String getVttThumbsFilde();

	public void setVttThumbsFilde(String vttThumbsFilde);

	public String getMp4RssLink();

	public void setMp4RssLink(String mp4RssLink);

	public String getMp3RssLink();

	public void setMp3RssLink(String mp3RssLink);

	public String getM4vRssLink();

	public void setM4vRssLink(String m4vRssLink);

	public String getM4aRssLink();

	public void setM4aRssLink(String m4aRssLink);

	public String getOggRssLink();

	public void setOggRssLink(String oggRssLink);

	public String getFlvRssLink();

	public void setFlvRssLink(String flvRssLink);

	public String getWebmRssLink();

	public void setWebmRssLink(String webmRssLink);

	/**
	 * Checks if file has chapters
	 */
	public boolean isHasChapters();

	public boolean isHasComments();

	public void setHasComments(boolean hasComments);

	/**
	 * Returns the complete URL to the open access video
	 */
	public String getUrl();

	public void setUrl(String url);

	/**
	 * Returns the complete secure URL to the NON open access video
	 */
	public String getSecureUrl();

	public void setSecureUrl(String secureUrl);

	/**
	 * Returns the current URL depending on the openaccess field
	 */
	public String getCurrentURL();

	/**
	 * Returns the mp4 file (unchecked if existing)
	 */
	public java.io.File getMp4File();

	public void setMp4File(java.io.File mp4File);

	/**
	 * Returns the pdf file (unchecked if existing)
	 */
	public java.io.File getPdfFile();

	public void setPdfFile(java.io.File pdfFile);

	/**
	 * Returns the mp3 file (unchecked if existing)
	 */
	public java.io.File getMp3File();

	public void setMp3File(java.io.File mp3File);

	/**
	 * Returns the m4v file (unchecked if existing)
	 */
	public java.io.File getM4vFile();

	public void setM4vFile(java.io.File m4vFile);

	/**
	 * Returns the m4a file (unchecked if existing)
	 */
	public java.io.File getM4aFile();

	public void setM4aFile(java.io.File m4aFile);

	/**
	 * Returns the flv file (unchecked if existing)
	 */
	public java.io.File getFlvFile();

	public void setFlvFile(java.io.File flvFile);

	/**
	 * Returns the ogg file (unchecked if existing)
	 */
	public java.io.File getOggFile();

	public void setOggFile(java.io.File oggFile);

	/**
	 * Returns the webm file (unchecked if existing)
	 */
	public java.io.File getWebmFile();

	public void setWebmFile(java.io.File webmFile);

	/**
	 * Returns the vtt file (unchecked if existing) from the user repository
	 */
	public java.io.File getVttFile();

	public void setVttFile(java.io.File vttFile);

	/**
	 * Returns the current filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 * Checks if prefix is _openaccess_ or secure and returns the correct one.
	 */
	public String getCurrentMp4FilenameWithReasonableBitrate();

	/**
	 * Returns the secure filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	public String getSecureMp4FilenameWithReasonableBitrate();

	/**
	 * Returns the _openaccess_ filename of the video with a reasonable _bitrate_, this is either the original file or, if multiple qualities are
	 * referenced from a _smil_ file, the version with the download suffix.
	 */
	public String getMp4FilenameWithReasonableBitrate();

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getMp4DownloadLink();

	public void setMp4DownloadLink(String mp4DownloadLink);

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getPdfDownloadLink();

	public void setPdfDownloadLink(String pdfDownloadLink);

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	public String getMp3DownloadLink();

	public void setMp3DownloadLink(String mp3DownloadLink);

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getM4vDownloadLink();

	public void setM4vDownloadLink(String m4vDownloadLink);

	/**
	 * Returns the download link to the audio file depending on the openaccess field
	 */
	public String getM4aDownloadLink();

	public void setM4aDownloadLink(String m4aDownloadLink);

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getFlvDownloadLink();

	public void setFlvDownloadLink(String flvDownloadLink);

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getOggDownloadLink();

	public void setOggDownloadLink(String oggDownloadLink);

	/**
	 * Returns the download link to the video file depending on the openaccess field
	 */
	public String getWebmDownloadLink();

	public void setWebmDownloadLink(String webmDownloadLink);

	/**
	 * Returns the formatted generation date with time
	 */
	public String getDate();

	public void setDate(String date);

	/**
	 * Returns the formatted generation date without time
	 */
	public String getSimpleDate();

	public void setSimpleDate(String simpleDate);

	public String getBitrate();

	public void setBitrate(String bitrate);

	/**
	 * Returns the image in original size (checks which file should be used (thumbnail, audio, ... ))
	 */
	public String getImage();

	public void setImage(String image);

	/**
	 * Returns the image in small size (checks which file should be used (thumbnail, audio, ... ))
	 */
	public String getImageSmall();

	public void setImageSmall(String imageSmall);

	/**
	 * Returns the image in medium size (checks which file should be used (thumbnail, audio, ... ))
	 */
	public String getImageMedium();

	public void setImageMedium(String imageMedium);

	public boolean isHasCaption();

	/**
	 * Returns the title in a truncated form
	 */
	public String getShortTitle();

	public void setShortTitle(String shortTitle);

	/**
	 * Returns the secure prefix of the file (filename without extension)
	 */
	public String getSPreffix();

	/**
	 * Returns the open access prefix of the file (filename without extension)
	 */
	public String getPreffix();

	public String getLinkedCreators();

	public void setLinkedCreators(String linkedCreators);

	public String getCreators();

	public void setCreators(String creators);

}