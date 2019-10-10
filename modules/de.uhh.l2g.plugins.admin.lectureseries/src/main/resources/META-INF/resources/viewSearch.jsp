<%@include file="init.jsp" %>
<!-- TODO not implemented jet -->
<%
	int lId = ParamUtil.getInteger(request, "lId");
	String lName = ParamUtil.getString(request, "lName");
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<c:set var="lId" value="<%= lId==0 ? " ":lId %>"/>
<c:set var="lName" value="<%=ParamUtil.getString(request, "lName")%>"/>
<c:set var="displayTerms" value="<%=displayTerms%>"/>

<!-- 
<liferay-ui:search-toggle buttonLabel="lectureseries-search" displayTerms="${displayTerms}" id="toggle_id_lectureseries_search">
	<aui:input label="id" name="lId" value='${lId}'/> 
	<aui:input label="name" name="lName" value='${lName}'/>
</liferay-ui:search-toggle>
-->
