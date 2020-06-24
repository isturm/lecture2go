package de.uhh.l2g.plugins.model;

public class VideoListSearchResult {

	private long lectureseriesId, latestOpenAccessVideoId, previewVideoId, termId, categoryId,
			numberOfOpenAccessVideos = -1;

	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
