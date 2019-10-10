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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.exception.NoSuchVideoException;
import de.uhh.l2g.plugins.model.Video;

import java.io.File;
import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Video. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see VideoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface VideoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoLocalServiceUtil} to access the video local service. Add custom service methods to <code>de.uhh.l2g.plugins.service.impl.VideoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	public void addPlayerUris2Video(Video video);

	/**
	 * This adds the "tracks" section for the video player json if there are any captions or chapters
	 */
	public void addTracksToVideoPlayer(Video video);

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Video addVideo(Video video);

	/**
	 * Checks if the video has a related smil-file in the file system
	 */
	public boolean checkSmilFile(Video video);

	public int countByLectureseries(Long lectureseriesId)
		throws SystemException;

	public int countByLectureseriesAndOpenaccess(
			Long lectureseriesId, int openAccess)
		throws SystemException;

	public void createLastVideoList() throws SystemException;

	/**
	 * Creates a symlink for the caption of the video to to captions folder
	 */
	public void createSymLinkForCaptionIfExisting(Long videoId)
		throws PortalException, SystemException;

	public void createSymLinkToDownloadableFileIfNotExisting(Long videoId);

	public void createThumbnailsIfNotExisting(Long videoId);

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	@Transactional(enabled = false)
	public Video createVideo(long videoId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Video deleteVideo(long videoId) throws PortalException;

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Video deleteVideo(Video video);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video fetchVideo(long videoId);

	public boolean fileStringSegmentFoundInArray(
		String file, JSONArray jsonArray);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getAll() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByAllSearchWords() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByFilename(String filename) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHits();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHits(Long hits);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByHitsAndOpenAccess(Long hits);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByLectureseries(Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByLectureseriesAndOpenaccess(
			Long lectureseriesId, int openAccess)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByOpenAccess(int bool) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getByOpenAccessAndUploadedFile(int bool) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducer(Long producerId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducerAndDownloadLink(
			Long producerId, int downloadLink)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByProducerAndLectureseries(
			Long producerId, Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByRootInstitution(Long rootInstitutionId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getBySearchWord(String word, int limit)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getBySearchWordAndLectureseriesId(
			String word, Long lectureseriesId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getBySecureUrl(String surl)
		throws NoSuchVideoException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getByTerm(Long termId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getJSONVideo(Long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Long getLatestClosedAccessVideoId(Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getLatestOpenAccessVideoForLectureseries(Long lectureseriesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getLatestVideos();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getPopular(int limit);

	/**
	 * Returns the video with the primary key.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Video getVideo(long videoId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Video> getVideos(int start, int end);

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideosCount();

	/**
	 * Checks if file is a symoblic link
	 *
	 * @param file the file to check
	 * @return true if file is sym link, false if not
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSymlink(File file);

	public int unlinkLectureseriesFromVideos(Long lectureseriesId);

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Video updateVideo(Video video);

}