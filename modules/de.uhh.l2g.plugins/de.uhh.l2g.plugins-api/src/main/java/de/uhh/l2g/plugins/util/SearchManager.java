package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.document.Field;
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
import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.sort.Sorts;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.VideoListSearchResult;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

@Component(service = SearchManager.class)
public class SearchManager {

	@Reference
	protected Queries queries;

	@Reference
	protected Sorts sorts;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	public JSONArray getAutocompleteResultArrayBySearchWord(long companyId, String searchText, int resultLimit)
			throws SearchException, ParseException {
		Stream<Document> searchResults = getSearchResultsBySearchWordAndFilter(companyId, SearchType.WILDCARD_MATCH,
				searchText, null, resultLimit, null);
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

	public List<VideoListSearchResult> searchVideoList(long companyId, SearchType searchType, String searchText,
			Map<String, Object> filters, int resultLimit, String sortByField) throws SearchException, ParseException {
		Stream<Document> searchResults = getSearchResultsBySearchWordAndFilter(companyId, searchType, searchText,
				filters, resultLimit, sortByField);
		List<VideoListSearchResult> videoList = new ArrayList<VideoListSearchResult>();
		searchResults.forEach(document -> {
			VideoListSearchResult searchResult = new VideoListSearchResult();

			setSearchResultFields(document, searchResult);
			addSearchResultToResultList(videoList, searchResult);
		});

		return videoList;
	}

	private void setSearchResultFields(Document document, VideoListSearchResult searchResult) {
		Map<String, Field> fields = document.getFields();
		if (fields.containsKey("videoId")) {
			searchResult.setVideoId(document.getLong("videoId"));
		}
		if (fields.containsKey("lectureSeriesId")) {
			searchResult.setLectureseriesId(document.getLong("lectureSeriesId"));
		}
		if (fields.containsKey("latestOpenAccessVideoId")) {
			searchResult.setLatestOpenAccessVideoId(document.getLong("latestOpenAccessVideoId"));
		}
		if (fields.containsKey("previewVideoId")) {
			searchResult.setPreviewVideoId(document.getLong("previewVideoId"));
		}
		if (fields.containsKey("numberOfOpenAccessVideos")) {
			searchResult.setNumberOfOpenAccessVideos(document.getLong("numberOfOpenAccessVideos"));
		}
		if (fields.containsKey("termId")) {
			searchResult.setTermId(document.getLong("termId"));
		}
		if (fields.containsKey("categoryId")) {
			searchResult.setCategoryId(document.getLong("categoryId"));
		}
		if (fields.containsKey("mediaTypeId")) {
			searchResult.setMediaTypeId(document.getLong("mediaTypeId"));
		}
		if (fields.containsKey("tags")) {
			searchResult.setTags(document.getString("tags"));
		}
		if (fields.containsKey("name")) {
			searchResult.setName(document.getString("name"));
		}
	}

	private void addSearchResultToResultList(List<VideoListSearchResult> videoList,
			VideoListSearchResult searchResult) {
		if (searchResult.getLectureseriesId() > 0) {
			if (searchResult.getVideoId() > 0) {
				VideoListSearchResult dummyLectureSeries = new VideoListSearchResult();
				dummyLectureSeries.setVideoId(-1);
				dummyLectureSeries.setLectureseriesId(searchResult.getLectureseriesId());

				// add video to list of lecture series (if lecture series video list is empty
				// (i.e. lecture series was found itself in search), all videos of lecture
				// series should be shown)
				if (videoList.contains(dummyLectureSeries)) {
					List<Long> videoIds = videoList.get(videoList.indexOf(dummyLectureSeries)).getVideoIds();
					if (!videoIds.isEmpty()) {
						videoIds.add(searchResult.getVideoId());
					}
				} else {
					// create lecture series item to contain the video
					try {
						Lectureseries lectureSeries = LectureseriesLocalServiceUtil
								.getLectureseries(searchResult.getLectureseriesId());
						dummyLectureSeries.setCategoryId(lectureSeries.getCategoryId());
						dummyLectureSeries.setLatestOpenAccessVideoId(lectureSeries.getLatestOpenAccessVideoId());
						dummyLectureSeries.setName(lectureSeries.getName());
						dummyLectureSeries.setNumberOfOpenAccessVideos(VideoLocalServiceUtil
								.countByLectureseriesAndOpenaccess(searchResult.getLectureseriesId(), 1));
						dummyLectureSeries.setPreviewVideoId(lectureSeries.getPreviewVideoId());
						dummyLectureSeries.setTermId(lectureSeries.getTermId());
						dummyLectureSeries.getVideoIds().add(searchResult.getVideoId());
						videoList.add(dummyLectureSeries);
					} catch (PortalException e) {
						// TODO handle exception
					}
				}
			} else {
				if (videoList.contains(searchResult)) {
					List<Long> videoIds = videoList.get(videoList.indexOf(searchResult)).getVideoIds();
					videoIds.clear();
				} else {
					videoList.add(searchResult);
				}
			}
		} else {
			videoList.add(searchResult);
		}
	}

	public Stream<Document> getSearchResultsBySearchWordAndFilter(long companyId, SearchType searchType,
			String searchText, Map<String, Object> filters, int resultLimit, String sortByField)
			throws SearchException, ParseException {
		BooleanQuery completeQuery = queries.booleanQuery();

		// search query
		if (searchText != null && !searchText.isEmpty()) {
			try {
				searchText = URLDecoder.decode(searchText, StandardCharsets.UTF_8.name());
			} catch (UnsupportedEncodingException e) {
				// not going to happen - value came from JDK's own StandardCharsets
			}

			BooleanQuery enclosingQuery = queries.booleanQuery();

			if (SearchType.EXACT_MATCH.equals(searchType)) {
				TermQuery exactQuery = queries.term("encodedTagCloud", EncodingUtil.encodeString(searchText));
				enclosingQuery.addMustQueryClauses(exactQuery);
			} else if (SearchType.WILDCARD_MATCH.equals(searchType)) {
				MatchQuery matchQuery = queries.match("tagCloud", searchText);
				enclosingQuery.addShouldQueryClauses(matchQuery);

				for (String singleWord : searchText.split(" ")) {
					WildcardQuery wildcardQuery = queries.wildcard("tagCloud",
							"*" + singleWord.trim().toLowerCase() + "*");
					enclosingQuery.addShouldQueryClauses(wildcardQuery);
				}
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
			searchContext.setCompanyId(companyId);
			String[] entryClassNames = { Video.class.getName(), Lectureseries.class.getName() };
			searchContext.setEntryClassNames(entryClassNames);
		});
		if (resultLimit > 0) {
			searchRequestBuilder.size(resultLimit);
		}
		if (sortByField != null && !sortByField.isEmpty()) {
			Sort sort;
			if ("latestVideoGenerationDate".equals(sortByField)) {
				sort = sorts.field(sortByField + "_String_sortable", SortOrder.DESC);
			} else {
				sort = sorts.field(sortByField + "_String_sortable");
			}
			searchRequestBuilder.sorts(sort);
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

	public enum SearchType {
		WILDCARD_MATCH(0), EXACT_MATCH(1);

		private final int code;

		public int getCode() {
			return code;
		}

		private SearchType(int code) {
			this.code = code;
		}

		public static SearchType fromCode(int code) {
			for (SearchType searchType : SearchType.values()) {
				if (searchType.getCode() == code) {
					return searchType;
				}
			}

			return SearchType.WILDCARD_MATCH;
		}

	}

}
