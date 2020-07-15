package de.uhh.l2g.plugins.guest.videos.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.Portlet;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import de.uhh.l2g.plugins.guest.videos.constants.OpenAccessVideosPortletKeys;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.util.ConverterUtil;

/**
 * @author isturm
 */

@Component(immediate = true, property = { "com.liferay.portlet.display-category=lecture2go.plugins",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.socialshareprivacy.js",
		"com.liferay.portlet.header-portlet-javascript=/js/qrc.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.cookie.js",
		"com.liferay.portlet.header-portlet-javascript=/js/mediaCheck-min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/readmore.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.mark.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/de.uhh.l2g.plugins.guest.videos.js",
		"javax.portlet.display-name=Guest Videos", "javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + OpenAccessVideosPortletKeys.OPEN_ACCESS_VIDEOS,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/videoPlayer.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/lang/de.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-contrib-quality-levels.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/quality-levels/videojs-hls-quality-selector.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/offset/videojs-offset.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/vr/videojs-vr.min.js",
		"com.liferay.portlet.header-portal-javascript=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.js",
		"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-plugins/chapter-markers/chapter-markers.css",
		"com.liferay.portlet.header-portal-css=/o/de.uhh.l2g.plugins-api/player/video-js-7.8.1/video-js.min.css", }, service = Portlet.class)
public class OpenAccessVideosPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(OpenAccessVideosPortlet.class);

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		String resourceID = resourceRequest.getResourceID();

		if (resourceID.equals("getVideosForLectureSeries")) {
			String objectId = ParamUtil.getString(resourceRequest, "objectId");
			String videoIds = ParamUtil.getString(resourceRequest, "videoIds");

			List<Video> videos;
			if (!videoIds.equals("") && !videoIds.equals("[]")) {
				long[] videoIdsArray = ConverterUtil.convertStringToIdArray(videoIds);
				videos = VideoLocalServiceUtil.getByVideoIds(videoIdsArray);
			} else {
				videos = VideoLocalServiceUtil.getByLectureseries(new Long(objectId));
			}

			JSONArray json = JSONFactoryUtil.createJSONArray();
			json.put(videos);
			writeJSON(resourceRequest, resourceResponse, json);
		}

		if (resourceID.equals("getCreators")) {
			boolean hasCreatorFiltered = ParamUtil.getBoolean(resourceRequest, "hasCreatorFiltered");
			long creatorId = ParamUtil.getLong(resourceRequest, "creatorId");
			ArrayList<Long> lectureSeriesIds = ConverterUtil
					.convertStringToIdList(ParamUtil.getString(resourceRequest, "lectureSeriesIds"));
			ArrayList<Long> videoIds = ConverterUtil
					.convertStringToIdList(ParamUtil.getString(resourceRequest, "videoIds"));

			Map<Character, List<Creator>> creatorsSplitAlphabetically = splitCreatorsAlphabetically(
					filterCreators(hasCreatorFiltered, creatorId, lectureSeriesIds, videoIds));

			JSONArray json = JSONFactoryUtil.createJSONArray();
			json.put(creatorsSplitAlphabetically);
			writeJSON(resourceRequest, resourceResponse, json);
		}

		if (resourceID.equals("getTags")) {
			boolean hasTagFiltered = ParamUtil.getBoolean(resourceRequest, "hasTagFiltered");
			String tag = ParamUtil.getString(resourceRequest, "tag");
			ArrayList<Long> lectureSeriesIds = ConverterUtil
					.convertStringToIdList(ParamUtil.getString(resourceRequest, "lectureSeriesIds"));
			ArrayList<Long> videoIds = ConverterUtil
					.convertStringToIdList(ParamUtil.getString(resourceRequest, "videoIds"));

			Map<Character, Set<String>> tagsSplitAlphabetically = splitTagsAlphabetically(
					filterByTags(hasTagFiltered, tag, videoIds, lectureSeriesIds));

			JSONArray json = JSONFactoryUtil.createJSONArray();
			json.put(tagsSplitAlphabetically);
			writeJSON(resourceRequest, resourceResponse, json);
		}
	}

	/**
	 * Accepts a string with arbitrarily formatted tags and tries to make sense of
	 * it.
	 *
	 * @param tagsString String with tags.
	 * @return Tags as array; split by semicolon, comma, or not at all (in that
	 *         order).
	 */
	private String[] getTagsForString(String tagsString) {
		if (tagsString.isEmpty()) {
			return new String[0];
		}

		String[] splitBySemicolon = tagsString.split(";");
		if (splitBySemicolon.length > 1) {
			return splitBySemicolon;
		} else {
			return tagsString.split(",");
		}
	}

	/**
	 *
	 * @param hasTagFiltered
	 * @param tag
	 * @param videoIds
	 * @param lectureseriesIds
	 * @return
	 */
	private Set<String> filterByTags(boolean hasTagFiltered, String tag, List<Long> videoIds,
			List<Long> lectureseriesIds) {
		Set<String> tags = new TreeSet<>();

		if (hasTagFiltered) {
			tags.add(tag);
		} else {
			videoIds.forEach(videoId -> {
				try {
					tags.addAll(Arrays
							.asList(getTagsForString(VideoLocalServiceUtil.getCurrentlyValidVideo(videoId).getTags())));
				} catch (PortalException portalException) {
					portalException.printStackTrace();
				}
			});

			lectureseriesIds.forEach(lectureseriesId -> {
				VideoLocalServiceUtil.getByLectureseries(lectureseriesId).forEach(video -> {
					tags.addAll(Arrays.asList(getTagsForString(video.getTags())));
				});
			});
		}

		return tags;
	}

	/**
	 * Takes a flat list of tags and sorts it to an alphabetical map
	 *
	 * @param tagList {Apple; Bee; Anaconda; ...}
	 * @return A={Anaconda; Apple; ...}, B={Bee; ...}
	 */
	private Map<Character, Set<String>> splitTagsAlphabetically(Set<String> tagList) {
		Map<Character, Set<String>> presentTagsAlphabetMap = new HashMap<>();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ+";
		for (int i = 0; i < alphabet.length(); i++) {
			presentTagsAlphabetMap.put(alphabet.charAt(i), new TreeSet<>());
		}

		tagList.forEach(tag -> {
			if (!tag.trim().isEmpty()) {
				char firstChar = mapSpecialCharacters(tag);

				Set<String> tagsForChar = presentTagsAlphabetMap.get(firstChar);

				if (tagsForChar != null) {
					tagsForChar.add(tag.trim());
				} else {
					presentTagsAlphabetMap.get('+').add(tag.trim());
				}
			}
		});

		return presentTagsAlphabetMap;
	}

	/**
	 * Constructs a list of creators from given video and lecture series IDs, and
	 * returns a one-item list of the creator with id creatorId. If the filter is
	 * not active, the entire list is returned.
	 *
	 * @param filterIsActive   if true, list is filtered for creatorId
	 * @param creatorId        ID of creator to filter for. Can be null if
	 *                         filterIsActive is false
	 * @param lectureseriesIds IDs of the lecture series whose creators the list
	 *                         will contain
	 * @param videoIds         IDs of the videos whose creators the list will
	 *                         contain
	 * @return list of creators of given video/lectureSeries IDs. Single-item list
	 *         if filter is active and creator ID is given.
	 */
	private List<Creator> filterCreators(Boolean filterIsActive, long creatorId, ArrayList<Long> lectureseriesIds,
			ArrayList<Long> videoIds) {
		List<Creator> filteredCreators = new ArrayList<>();
		if (filterIsActive) {
			try {
				filteredCreators.add(CreatorLocalServiceUtil.getById(creatorId));
			} catch (Exception e) {
				_log.error("can't add creator id " + creatorId);
			}
		} else {
			filteredCreators = CreatorLocalServiceUtil.getCreatorsFromLectureseriesIdsAndVideoIds(lectureseriesIds,
					videoIds);
		}

		return filteredCreators;
	}

	/**
	 * Takes a flat list of creators and sorts it to an alphabetical map
	 *
	 * @param creatorList {Biene, Maja; Aaronson, John; ...}
	 * @return A={Aaronson, John; ...}, B={Biene, Maja; ...}
	 */
	private Map<Character, List<Creator>> splitCreatorsAlphabetically(List<Creator> creatorList) {
		Map<Character, List<Creator>> presentCreatorsAlphabetMap = new HashMap<>();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ+";
		for (int i = 0; i < alphabet.length(); i++) {
			presentCreatorsAlphabetMap.put(alphabet.charAt(i), new ArrayList<>());
		}

		creatorList.forEach(creator -> {
			char firstChar = mapSpecialCharacters(creator.getLastName());
			List<Creator> creatorsForChar = presentCreatorsAlphabetMap.get(firstChar);

			if (creatorsForChar != null) {
				creatorsForChar.add(creator);
			} else {
				presentCreatorsAlphabetMap.get('+').add(creator);
			}
		});

		return presentCreatorsAlphabetMap;
	}

	/**
	 *
	 * @param string
	 * @return
	 */
	private char mapSpecialCharacters(String string) {
		char firstChar = string.trim().toUpperCase().charAt(0);

		// Umlauts/accents are mapped to "base" character
		if (firstChar == 'Š' || firstChar == 'Ş')
			firstChar = 'S';
		if (firstChar == 'Ö')
			firstChar = 'O';
		if (firstChar == 'Ü')
			firstChar = 'U';
		if (firstChar == 'Ä')
			firstChar = 'A';
		if (firstChar == 'İ')
			firstChar = 'I';

		return firstChar;
	}
}