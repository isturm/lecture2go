package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.TermQuery;
import com.liferay.portal.search.query.WildcardQuery;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
		Stream<Document> searchResults = getSearchResultsBySearchWordAndFilter(searchText, null, resultLimit, false);
		List<String> resultList = new ArrayList<String>();
		searchResults.forEach(document -> {
			for (String value : document.getStrings("tagCloud")) {
				if (value != null && !value.isEmpty()) {
					if (!isDuplicate(resultList, value.trim())) {
						resultList.add(value.trim());
					}
				}
			}
		});

		return createWordArray(resultList);
	}

	public List<VideoListSearchResult> searchVideoList(String searchText, Map<String, Object> filters, int resultLimit)
			throws SearchException, ParseException {
		Stream<Document> searchResults = getSearchResultsBySearchWordAndFilter(searchText, filters, resultLimit, true);
		List<VideoListSearchResult> videoList = new ArrayList<VideoListSearchResult>();
		searchResults.forEach(document -> {
			VideoListSearchResult searchResult = new VideoListSearchResult();

			searchResult.setVideoId(document.getLong("videoId"));
			searchResult.setLectureseriesId(document.getLong("lectureSeriesId"));
			searchResult.setLatestOpenAccessVideoId(document.getLong("latestOpenAccessVideoId"));
			searchResult.setPreviewVideoId(document.getLong("previewVideoId"));
			searchResult.setNumberOfOpenAccessVideos(document.getLong("numberOfOpenAccessVideos"));
			searchResult.setTermId(document.getLong("termId"));
			searchResult.setCategoryId(document.getLong("categoryId"));
			searchResult.setName(document.getString("name"));

			videoList.add(searchResult);
		});

		return videoList;
	}

	public Stream<Document> getSearchResultsBySearchWordAndFilter(String searchText, Map<String, Object> filters,
			int resultLimit, boolean getOnlySeparateItems) throws SearchException, ParseException {
		BooleanQuery completeQuery = queries.booleanQuery();

		// search query
		if (searchText != null && !searchText.isEmpty()) {
			BooleanQuery enclosingQuery = queries.booleanQuery();

			MatchQuery matchQuery = queries.match("tagCloud", searchText);
			enclosingQuery.addShouldQueryClauses(matchQuery);

			for (String singleWord : searchText.split(" ")) {
				WildcardQuery wildcardQuery = queries.wildcard("tagCloud", "*" + singleWord.trim().toLowerCase() + "*");
				enclosingQuery.addShouldQueryClauses(wildcardQuery);
			}

			completeQuery.addMustQueryClauses(enclosingQuery);
		}

		// only allow open access videos
		TermQuery openAccessQuery = queries.term("openAccess", 1);
		completeQuery.addMustQueryClauses(openAccessQuery);

		// apply filters
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

		Stream<Document> documents = searchResponse.getDocumentsStream();

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
