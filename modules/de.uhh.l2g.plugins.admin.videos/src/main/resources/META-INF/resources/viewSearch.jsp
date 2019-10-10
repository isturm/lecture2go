<%@include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

	<input class="form-control search-query" id="toggle_id_video_searchkeywords" name="<portlet:namespace></portlet:namespace>keywords" placeholder="keywords" title="keywords" type="text" value="${displayTerms.keywords}">
<br/>

