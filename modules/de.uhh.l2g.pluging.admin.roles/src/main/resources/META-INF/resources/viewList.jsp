<%@ include file="init.jsp" %>

<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />
<jsp:useBean id="l2goRoles" type="java.util.List<com.liferay.portal.kernel.model.Role>" scope="request" />
<jsp:useBean id="l2goUsers" type="java.util.List<User>" scope="request" />
<jsp:useBean id="roleId" type="java.lang.Long" scope="request" />
<jsp:useBean id="backURL" type="javax.portlet.PortletURL" scope="request" />
<jsp:useBean id="displayTerms" type="de.uhh.l2g.plugins.admin.roles.search.UserDisplayTerms" scope="request" />
<jsp:useBean id="userSearchContainer" type="de.uhh.l2g.plugins.admin.roles.search.UserSearchContainer" scope="request" />

<c:set var="application" value="<%=application%>"/>

<liferay-portlet:renderURL varImpl="userSearchURL">
</liferay-portlet:renderURL>

<div class="noresponsive">
	<aui:fieldset helpMessage="choose-filter" column="true" cssClass="list">
		<portlet:actionURL name="/select" var="selectURL" />
		<form  action="${selectURL}" method="post">
			<aui:select name="roleId" label="" onChange="submit();">
				<aui:option value=""><liferay-ui:message key="select-l2go-role"/></aui:option>
				<c:forEach items="${l2goRoles}" var ="role">
					<aui:option value='${role.roleId}'>${role.name}</aui:option>
				</c:forEach>
			</aui:select>
		</form>
	</aui:fieldset>
</div>

<aui:form action="${userSearchURL}" method="post" name="fm">
	<liferay-ui:search-container emptyResultsMessage="no-users-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			<liferay-ui:search-container-results>
				<div id="modifiedSearch">
					<liferay-ui:search-form page="/viewSearch.jsp" servletContext="<%= application %>" />
				</div>
				
				<%
					String keywords = displayTerms.getKeywords(); 
					searchContainer.setTotal(UserSearchHelper.getTotalUserCount(displayTerms,userSearchContainer.getStart(), userSearchContainer.getEnd()));		 
					searchContainer.setResults(UserSearchHelper.getUser(displayTerms,userSearchContainer.getStart(), userSearchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" keyProperty="userId" modelVar="usr">
				<c:set var="userId" value="<%=usr.getUserId()%>"/>
				
				<liferay-ui:search-container-column-text>
					${usr.fullName}
					<br/>
					<c:set var="roles" value="<%=usr.getRoles()%>"/>
					<c:set var="n" value=""/>
					<c:forEach items="${roles}" var="item">
						<c:set var="n" value="<%=TextManager.getRolesDescription(usr)%>"/>
					</c:forEach>
					${n}
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
					<portlet:renderURL var="editURL">
						<portlet:param name="userId" value='${userId}' />
						<portlet:param name="backURL" value='${backURL}' />
						<portlet:param name="mvcRenderCommandName" value="/edit"/>
					</portlet:renderURL>					
					<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
					   <span class="icon-large icon-pencil"></span>
					</a>
				</liferay-ui:search-container-column-text>				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
</aui:form>		