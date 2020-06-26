package de.uhh.l2g.plugins.model;

import java.util.ArrayList;
import java.util.List;

public class VideoListSearchResult {

	private long videoId = -1, lectureseriesId = -1, latestOpenAccessVideoId = -1, previewVideoId = -1, termId = -1,
			categoryId = -1, mediaTypeId = -1, numberOfOpenAccessVideos = 0;

	private String name;

	private List<Long> videoIds = new ArrayList<Long>();

	public long getVideoId() {
		return videoId;
	}

	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}

	public long getLectureseriesId() {
		return lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		this.lectureseriesId = lectureseriesId;
	}

	public long getLatestOpenAccessVideoId() {
		return latestOpenAccessVideoId;
	}

	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		this.latestOpenAccessVideoId = latestOpenAccessVideoId;
	}

	public long getPreviewVideoId() {
		return previewVideoId;
	}

	public void setPreviewVideoId(long previewVideoId) {
		this.previewVideoId = previewVideoId;
	}

	public long getNumberOfOpenAccessVideos() {
		return numberOfOpenAccessVideos;
	}

	public void setNumberOfOpenAccessVideos(long numberOfOpenAccessVideos) {
		this.numberOfOpenAccessVideos = numberOfOpenAccessVideos;
	}

	public long getTermId() {
		return termId;
	}

	public void setTermId(long termId) {
		this.termId = termId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getVideoIds() {
		return videoIds;
	}

	public long[] getVideoIdsArray() {
		long[] videoIdsArray = new long[videoIds.size()];
		for (int i = 0; i < videoIds.size(); i++) {
			videoIdsArray[i] = videoIds.get(i);
		}
		return videoIdsArray;
	}

	public void setVideoIds(List<Long> videoIds) {
		this.videoIds = videoIds;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VideoListSearchResult)) {
			return false;
		}

		return videoId == ((VideoListSearchResult) obj).getVideoId()
				&& lectureseriesId == ((VideoListSearchResult) obj).getLectureseriesId();
	}

}
