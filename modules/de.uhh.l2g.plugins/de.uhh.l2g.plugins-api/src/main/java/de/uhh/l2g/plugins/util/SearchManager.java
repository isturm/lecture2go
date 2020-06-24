package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uhh.l2g.plugins.model.VideoListSearchResult;

public class SearchManager {

	public static JSONArray getAutocompleteResultArrayBySearchWord(String searchText, int resultLimit)
			throws SearchException, ParseException {
		Document[] searchResults = getSearchResultsBySearchWordAndFilter(searchText, null, resultLimit);
		List<String> resultList = new ArrayList<String>();
		for (Document doc : searchResults) {
			Field field = doc.getField("tagCloud");
			if (field != null) {
				for (String value : field.getValues()) {
					if (value != null && !value.isEmpty()) {
						if (!isDuplicate(resultList, value.trim())) {
							resultList.add(value.trim());
						}
					}
				}
			}
		}

		return createWordArray(resultList);
	}

	public static List<VideoListSearchResult> searchVideoList(String searchText, Map<String, Object> filters,
			int resultLimit) throws SearchException, ParseException {
		Document[] searchResults = getSearchResultsBySearchWordAndFilter(searchText, filters, resultLimit);
		List<VideoListSearchResult> videoList = new ArrayList<VideoListSearchResult>(searchResults.length);
		for (Document document : searchResults) {
			VideoListSearchResult searchResult = new VideoListSearchResult();
			if (document.hasField("lectureSeriesId")) {
				searchResult.setLectureseriesId(Long.parseLong(document.getField("lectureSeriesId").getValue()));
			}
			if (document.hasField("latestOpenAccessVideoId")) {
				searchResult.setLatestOpenAccessVideoId(
						Long.parseLong(document.getField("latestOpenAccessVideoId").getValue()));
			}
			if (document.hasField("previewVideoId")) {
				searchResult.setPreviewVideoId(Long.parseLong(document.getField("previewVideoId").getValue()));
			}
			if (document.hasField("numberOfOpenAccessVideos")) {
				searchResult.setNumberOfOpenAccessVideos(
						Long.parseLong(document.getField("numberOfOpenAccessVideos").getValue()));
			}
			if (document.hasField("termId")) {
				searchResult.setTermId(Long.parseLong(document.getField("termId").getValue()));
			}
			if (document.hasField("categoryId")) {
				searchResult.setCategoryId(Long.parseLong(document.getField("categoryId").getValue()));
			}
			if (document.hasField("name")) {
				searchResult.setName(document.getField("name").getValue());
			}
			videoList.add(searchResult);
		}

		return videoList;
	}

	public static Document[] getSearchResultsBySearchWordAndFilter(String searchText, Map<String, Object> filters,
			int resultLimit) throws SearchException, ParseException {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		if (resultLimit > 0) {
			searchContext.setEnd(resultLimit);
		} else {
			searchContext.setEnd(QueryUtil.ALL_POS);
		}

		BooleanQuery booleanQuery = new BooleanQueryImpl();
		if (searchText != null && !searchText.isEmpty()) {
			booleanQuery.addTerm("tagCloud", searchText);
		}
		if (filters != null) {

		}

		Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

		return hits.getDocs();
	}

	private static JSONArray createWordArray(List<String> wordList) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (String word : wordList) {
			JSONObject wordJSON = JSONFactoryUtil.createJSONObject();
			wordJSON.put("word", word);
			jsonArray.put(wordJSON);
		}
		return jsonArray;
	}

	private static boolean isDuplicate(List<String> resultList, String word) {
		boolean ret = false;
		for (String w : resultList) {
			w = w.trim();
			if (w.equals(word))
				ret = true;
		}
		return ret;
	}

}
