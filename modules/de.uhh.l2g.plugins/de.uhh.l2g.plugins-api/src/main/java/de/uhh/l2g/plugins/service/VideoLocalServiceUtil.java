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

package de.uhh.l2g.plugins.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Video. This utility wraps
 * <code>de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see VideoLocalService
 * @generated
 */
@ProviderType
public class VideoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * required properties for jwplayer in portal-ext.properties file
	 *
	 * [host]=configured host in database (automatically e.g. streaming.server.com)
	 * [ext]=file extension (automatically e.g mp3)
	 * [l2go_path]=generated lecture2go file path (automatically e.g. 3l2gproducer1)
	 * [filename]=video file name (automatically e.g 00.000_video_2015-06-08_08-06.mp4)
	 * [protocol]=host protocol (automatically e.g rtmpt)
	 * [port]=host port (automatically e.g 80)
	 * [smilfile]=adaptive streaming file
	 *
	 * example for lecture2go configuration
	 * lecture2go.uri1.player.template=https://[host]/vod/_definst/smil:[l2go_path]/[smilfile]/playlist.m3u8
	 * lecture2go.uri2.player.template=https://[host]/vod/_definst/[ext]:[l2go_path]/[filename]/playlist.m3u8
	 * lecture2go.uri3.player.template=rtmpt://[host]/vod/_definst/[ext]:[l2go_path]/[filename]
	 * lecture2go.uri4.player.template=${lecture2go.downloadserver.web.root}/abo/[filename]
	 * lecture2go.uri5.player.template=rtsp://[host]:[port]/vod/_definst/[ext]:[l2go_path]/[filename]
	 */
	public static void addPlayerUris2Video(
		de.uhh.l2g.plugins.model.Video video) {

		getService().addPlayerUris2Video(video);
	}

	/**
	 * This adds the "tracks" section for the video player json if there are any captions or chapters
	 */
	public static void addTracksToVideoPlayer(
		de.uhh.l2g.plugins.model.Video video) {

		getService().addTracksToVideoPlayer(video);
	}

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	public static de.uhh.l2g.plugins.model.Video addVideo(
		de.uhh.l2g.plugins.model.Video video) {

		return getService().addVideo(video);
	}

	/**
	 * Checks if the video has a related smil-file in the file system
	 */
	public static boolean checkSmilFile(de.uhh.l2g.plugins.model.Video video) {
		return getService().checkSmilFile(video);
	}

	public static int countByLectureseries(Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByLectureseries(lectureseriesId);
	}

	public static int countByLectureseriesAndOpenaccess(
			Long lectureseriesId, int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);
	}

	public static void createLastVideoList()
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().createLastVideoList();
	}

	/**
	 * Creates a symlink for the caption of the video to to captions folder
	 */
	public static void createSymLinkForCaptionIfExisting(Long videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().createSymLinkForCaptionIfExisting(videoId);
	}

	public static void createSymLinkToDownloadableFileIfNotExisting(
		Long videoId) {

		getService().createSymLinkToDownloadableFileIfNotExisting(videoId);
	}

	public static void createThumbnailsIfNotExisting(Long videoId) {
		getService().createThumbnailsIfNotExisting(videoId);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	public static de.uhh.l2g.plugins.model.Video createVideo(long videoId) {
		return getService().createVideo(videoId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video deleteVideo(long videoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideo(videoId);
	}

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	public static de.uhh.l2g.plugins.model.Video deleteVideo(
		de.uhh.l2g.plugins.model.Video video) {

		return getService().deleteVideo(video);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.uhh.l2g.plugins.model.Video fetchVideo(long videoId) {
		return getService().fetchVideo(videoId);
	}

	public static boolean fileStringSegmentFoundInArray(
		String file, com.liferay.portal.kernel.json.JSONArray jsonArray) {

		return getService().fileStringSegmentFoundInArray(file, jsonArray);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAll();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByAllSearchWords()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByAllSearchWords();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getByFilename(
			String filename)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByFilename(filename);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getByHits() {
		return getService().getByHits();
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getByHits(
		Long hits) {

		return getService().getByHits(hits);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
		getByHitsAndOpenAccess(Long hits) {

		return getService().getByHitsAndOpenAccess(hits);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByLectureseries(Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByLectureseries(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByLectureseriesAndOpenaccess(
				Long lectureseriesId, int openAccess)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByLectureseriesAndOpenaccess(
			lectureseriesId, openAccess);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByOpenAccess(int bool)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByOpenAccess(bool);
	}

	public static int getByOpenAccessAndUploadedFile(int bool)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByOpenAccessAndUploadedFile(bool);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getByProducer(
			Long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByProducer(producerId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByProducerAndDownloadLink(Long producerId, int downloadLink)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByProducerAndDownloadLink(
			producerId, downloadLink);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByProducerAndLectureseries(Long producerId, Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByProducerAndLectureseries(
			producerId, lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getByRootInstitution(Long rootInstitutionId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByRootInstitution(rootInstitutionId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getBySearchWord(String word, int limit)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getBySearchWord(word, limit);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
			getBySearchWordAndLectureseriesId(String word, Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getBySearchWordAndLectureseriesId(
			word, lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Video getBySecureUrl(String surl)
		throws com.liferay.portal.kernel.exception.SystemException,
			   de.uhh.l2g.plugins.exception.NoSuchVideoException {

		return getService().getBySecureUrl(surl);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getByTerm(
			Long termId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByTerm(termId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONArray getJSONVideo(
		Long videoId) {

		return getService().getJSONVideo(videoId);
	}

	public static Long getLatestClosedAccessVideoId(Long lectureseriesId) {
		return getService().getLatestClosedAccessVideoId(lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Video
		getLatestOpenAccessVideoForLectureseries(Long lectureseriesId) {

		return getService().getLatestOpenAccessVideoForLectureseries(
			lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video>
		getLatestVideos() {

		return getService().getLatestVideos();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> getPopular(
		int limit) {

		return getService().getPopular(limit);
	}

	/**
	 * Returns the video with the primary key.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static de.uhh.l2g.plugins.model.Video getVideo(long videoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideo(videoId);
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>de.uhh.l2g.plugins.model.impl.VideoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	public static java.util.List<de.uhh.l2g.plugins.model.Video> getVideos(
		int start, int end) {

		return getService().getVideos(start, end);
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public static int getVideosCount() {
		return getService().getVideosCount();
	}

	/**
	 * Checks if file is a symoblic link
	 *
	 * @param file the file to check
	 * @return true if file is sym link, false if not
	 */
	public static boolean isSymlink(java.io.File file) {
		return getService().isSymlink(file);
	}

	public static int unlinkLectureseriesFromVideos(Long lectureseriesId) {
		return getService().unlinkLectureseriesFromVideos(lectureseriesId);
	}

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	public static de.uhh.l2g.plugins.model.Video updateVideo(
		de.uhh.l2g.plugins.model.Video video) {

		return getService().updateVideo(video);
	}

	public static VideoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoLocalService, VideoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoLocalService.class);

		ServiceTracker<VideoLocalService, VideoLocalService> serviceTracker =
			new ServiceTracker<VideoLocalService, VideoLocalService>(
				bundle.getBundleContext(), VideoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}