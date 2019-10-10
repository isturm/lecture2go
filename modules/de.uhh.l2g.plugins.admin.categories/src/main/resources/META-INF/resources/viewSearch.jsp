<%@include file="init.jsp" %>

<%
	int cId = ParamUtil.getInteger(request, "cId");
	String cName = ParamUtil.getString(request, "cName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<c:set var="cId" value="<%= cId==0 ? " ":cId %>"/>
<c:set var="cName" value="<%=ParamUtil.getString(request, "cName")%>"/>
<c:set var="displayTerms" value="<%=displayTerms%>"/>

	<input class="form-control search-query" id="toggle_id_video_searchkeywords" name="<portlet:namespace></portlet:namespace>keywords" placeholder="keywords" title="keywords" type="text" value="${displayTerms.keywords}">
<br/>

