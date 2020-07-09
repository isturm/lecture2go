package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializable;

import java.util.List;

public class LectureseriesWithVideos implements JSONSerializable {

	private Lectureseries lectureseries;
	private List<Video> videos;

	public Lectureseries getLectureseries() {
		return lectureseries;
	}

	public void setLectureseries(Lectureseries lectureseries) {
		this.lectureseries = lectureseries;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toJSONString() {
		try {
			JSONObject result = JSONFactoryUtil.createJSONObject();

			JSONObject lectureseriesJSON = JSONFactoryUtil
					.createJSONObject(JSONFactoryUtil.createJSONSerializer().serialize(lectureseries));
			result.put("lectureseries", lectureseriesJSON);

			JSONArray videoArray = JSONFactoryUtil.createJSONArray(videos);
			result.put("videos", videoArray);

			return result.toJSONString();
		} catch (JSONException e) {
			return null;
		}
	}

}
