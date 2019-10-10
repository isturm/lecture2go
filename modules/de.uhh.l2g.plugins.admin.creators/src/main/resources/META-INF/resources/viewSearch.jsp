<%@include file="init.jsp" %>
<%
	String jobTitle = ParamUtil.getString(request, "jobTitle");
	String firstName = ParamUtil.getString(request, "firstName");
	String middleName = ParamUtil.getString(request, "middleName");
	String lastName = ParamUtil.getString(request, "lastName");
	String fullName = ParamUtil.getString(request, "fullName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
	<input class="form-control search-query" id="toggle_id_video_searchkeywords" name="<portlet:namespace></portlet:namespace>keywords" placeholder="keywords" title="keywords" type="text" value="${displayTerms.keywords}">
<br/>