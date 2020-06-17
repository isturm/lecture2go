package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.exception.SystemException;
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

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;


public class AutocompleteManager {
	/** The dao bean factory. */
	
	public List<String> getAllVideos() {
		
		List<String> resultList = new ArrayList<String>();
		List<Video> videoList = new ArrayList<Video>();

		try {
			videoList = VideoLocalServiceUtil.getAll();
		} catch (SystemException e) {
			////e.printStackTrace();
		}
				
		for (Video video : videoList) resultList.add(video.getTitle());
		return resultList;
	}
	
	public static synchronized JSONArray getAutocompleteResultArrayBySearchWord(String searchText, int resultLimit) throws SearchException, ParseException {
		return createWordArray(getAutocompleteResultsBySearchWord(searchText, resultLimit));
	}
	
	public static synchronized List<String> getAutocompleteResultsBySearchWord(String searchText, int resultLimit) throws SearchException, ParseException {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		searchContext.setEnd(resultLimit);
		
		String[] searchFields = {"videoTitle","creators","tags","lectureSeriesName"};
		BooleanQuery booleanQuery = new BooleanQueryImpl();
		for(String searchField : searchFields) {
			booleanQuery.addTerm(searchField, searchText);
		}
		
		Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);
		
		List<String> resultList = new ArrayList<String>();
		for(Document doc:hits.getDocs()) {
			for(String searchField : searchFields) {
				Field field = doc.getField(searchField);
				if(field != null) {
					String value = field.getValue();
					if(value != null && !value.isEmpty()) {
						for(String valuePart:value.split(",")) {
							if (!isDuplicate(resultList, valuePart.trim())) {
								resultList.add(valuePart.trim());
							}
						}
					}
				}
			}
		}
		return resultList;
	}
	
	public static synchronized List<String> getAutocompleteResults() throws SystemException {
		List<String> resultList = new ArrayList<String>();
		List<Video> videoList = new ArrayList<Video>();	
		if (videoList.size() == 0) videoList = VideoLocalServiceUtil.getByAllSearchWords();
		for (Video video : videoList) {
			/** Return only the string, that contained the search term */
			String title = video.getTitle().trim();
			String series = video.getLectureseriesName().trim();
			String[] carr = video.getCreators().split("###");
			String tags = video.getTags().trim();

			if (!isDuplicate(resultList, title)) resultList.add(title);
			if (!isDuplicate(resultList, series)) resultList.add(series);
			for(int i = 0; i<carr.length; i++){
				if (!isDuplicate(resultList, carr[i])) resultList.add(carr[i]);
			}
			if (!isDuplicate(resultList, tags)) resultList.add(tags);

			/**
			 * Limit the number of result strings for ajax request to 10 if
			 * (resultList.size() >= 10) { break; }
			 */

		}
		return resultList;
	}
	
	public static JSONArray SEARCH_WORDS_JSONArray = JSONFactoryUtil.createJSONArray();
	
	public static synchronized boolean generateAutocompleteResults() throws SystemException  {
		List<String> arrStr = getAutocompleteResults();
		SEARCH_WORDS_JSONArray = createWordArray(arrStr);
		return true;
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
	
	private static boolean isDuplicate(List<String> resultList, String word){
		boolean ret = false;
		for(String w : resultList){
			w=w.trim();
			if(w.equals(word)) ret=true;
		}
		return ret;
	}

}
