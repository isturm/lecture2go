package de.uhh.l2g.plugins.util;

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

public class AutocompleteManager {

	public static synchronized JSONArray getAutocompleteResultArrayBySearchWord(String searchText, int resultLimit)
			throws SearchException, ParseException {
		return createWordArray(getAutocompleteResultsBySearchWord(searchText, resultLimit));
	}

	public static synchronized List<String> getAutocompleteResultsBySearchWord(String searchText, int resultLimit)
			throws SearchException, ParseException {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		searchContext.setEnd(resultLimit);

		BooleanQuery booleanQuery = new BooleanQueryImpl();
		booleanQuery.addTerm("tagCloud", searchText);

		Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

		List<String> resultList = new ArrayList<String>();
		for (Document doc : hits.getDocs()) {
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
		return resultList;
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
