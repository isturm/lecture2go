package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.TermQuery;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.model.VideoListSearchResult;

@Component(service = SearchManager.class)
public class SearchManager {

	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	public JSONArray getAutocompleteResultArrayBySearchWord(String searchText, int resultLimit)
			throws SearchException, ParseException {
		List<Document> searchResults = getSearchResultsBySearchWordAndFilter(searchText, null, resultLimit, false);
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

	public List<VideoListSearchResult> searchVideoList(String searchText, Map<String, Object> filters, int resultLimit)
			throws SearchException, ParseException {
		List<Document> searchResults = getSearchResultsBySearchWordAndFilter(searchText, filters, resultLimit, true);
		List<VideoListSearchResult> videoList = new ArrayList<VideoListSearchResult>(searchResults.size());
		for (Document document : searchResults) {
			VideoListSearchResult searchResult = new VideoListSearchResult();
			if (document.hasField("videoId")) {
				searchResult.setVideoId(Long.parseLong(document.getField("videoId").getValue()));
			}
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

	public List<Document> getSearchResultsBySearchWordAndFilter(String searchText, Map<String, Object> filters,
			int resultLimit, boolean getOnlySeparateItems) throws SearchException, ParseException {
		BooleanQuery completeQuery = queries.booleanQuery();

		if (searchText != null && !searchText.isEmpty()) {
			MatchQuery searchQuery = queries.match("tagCloud", searchText);
			completeQuery.addMustQueryClauses(searchQuery);
		}

		// only allow open access videos
		TermQuery openAccessQuery = queries.term("openAccess", 1);
		completeQuery.addMustQueryClauses(openAccessQuery);

		// e.g. in video catalogue we only want seprate items (i.e. lecture series or
		// videos without lecture series)
		if (getOnlySeparateItems) {
			TermQuery termQuery = queries.term("isSeparateVideoListItem", true);
			completeQuery.addMustQueryClauses(termQuery);
		}
		if (filters != null) {
			for (String filter : filters.keySet()) {
				TermQuery termQuery = queries.term(filter, filters.get(filter));
				completeQuery.addMustQueryClauses(termQuery);
			}
		}

		SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();
		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(searchContext -> {
			searchContext.setCompanyId(PortalUtil.getDefaultCompanyId());
		});
		if (resultLimit > 0) {
			searchRequestBuilder.size(resultLimit);
		}
		SearchRequest searchRequest = searchRequestBuilder.query(completeQuery).build();
		SearchResponse searchResponse = searcher.search(searchRequest);

		List<Document> documents = searchResponse.getDocuments71();

		return documents;
	}

	private JSONArray createWordArray(List<String> wordList) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (String word : wordList) {
			JSONObject wordJSON = JSONFactoryUtil.createJSONObject();
			wordJSON.put("word", word);
			jsonArray.put(wordJSON);
		}
		return jsonArray;
	}

	private boolean isDuplicate(List<String> resultList, String word) {
		boolean ret = false;
		for (String w : resultList) {
			w = w.trim();
			if (w.equals(word))
				ret = true;
		}
		return ret;
	}

}
