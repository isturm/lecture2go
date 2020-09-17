<%@ include file="init.jsp" %>

<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request"/>
<jsp:useBean id="l2goRoles" type="java.util.List<com.liferay.portal.kernel.model.Role>" scope="request"/>
<jsp:useBean id="l2goUsers" type="java.util.List<User>" scope="request"/>
<jsp:useBean id="institutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="roleId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="permissionProducerPending" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="backURL" type="javax.portlet.PortletURL" scope="request"/>
<jsp:useBean id="displayTerms" type="de.uhh.l2g.plugins.admin.roles.search.UserDisplayTerms" scope="request"/>
<jsp:useBean id="userSearchContainer" type="de.uhh.l2g.plugins.admin.roles.search.UserSearchContainer" scope="request"/>

<c:set var="application" value="<%=application%>"/>

<liferay-portlet:renderURL varImpl="userSearchURL">
</liferay-portlet:renderURL>

<c:choose>
	<c:when test = "${permissionProducerPending}">
		<portlet:actionURL name="/panding" var="updateURL"/>
		
		<div id="pending-producer-text">
			<liferay-ui:message key="pending-producer-note"/>
		</div>
		
		<aui:form action="${updateURL}" method="post">
			<aui:fieldset helpMessage="" column="true">
					<div id="metadata-upload">
						<c:if test='${permissionProducerPending}'>
								<aui:select name="pfId" label="" required="true">
									<aui:option disabled='true' selected="true"><liferay-ui:message key="select-institution"/></aui:option>
		      						<c:forEach items="${institutions}" var="inst">
				                        <aui:option value='${inst.institutionId}'>${inst.name}</aui:option>
				                    </c:forEach>
								</aui:select>
						</c:if>
						<aui:input type="hidden" name="isStud" value="false"/>				
						<aui:input type="hidden" name="userId" value="${userId}"/>				
					
						<aui:button-row>
				      		<aui:button type="submit" name="submit"/>
				    	</aui:button-row>
					</div>
			</aui:fieldset>
		</aui:form>
		
	</c:when>
	<c:when test= "${permissionAdmin}">
		<div class="view list user-role">
		    <div class="col-md-4">
		        <aui:fieldset helpMessage="choose-filter" column="true" cssClass="list">
		            <portlet:actionURL name="/select" var="selectURL"/>
		            <form action="${selectURL}" method="post">
		                <aui:select name="roleId" label="" onChange="submit();">
		                    <aui:option value=""><liferay-ui:message key="select-l2go-role"/></aui:option>
		                    <c:forEach items="${l2goRoles}" var="role">
		                        <aui:option value='${role.roleId}'>${role.name}</aui:option>
		                    </c:forEach>
		                </aui:select>
		            </form>
		        </aui:fieldset>
		
		        <aui:form action="${userSearchURL}" method="post" name="fm">
		        <liferay-ui:search-container emptyResultsMessage="no-users-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
		        <liferay-ui:search-container-results>
		            <div id="modifiedSearch">
		                <liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}"/>
		            </div>
		
		            <%
		                String keywords = displayTerms.getKeywords();
		                searchContainer.setTotal(UserSearchHelper.getTotalUserCount(displayTerms, userSearchContainer.getStart(), userSearchContainer.getEnd()));
		                searchContainer.setResults(UserSearchHelper.getUser(displayTerms, userSearchContainer.getStart(), userSearchContainer.getEnd()));
		            %>
		        </liferay-ui:search-container-results>
		    </div>
		    
		    <div class="col-md-8 edit-table">
		        <liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" keyProperty="userId" modelVar="usr">
		            <c:set var="userId" value="${usr.userId}"/>
		            <liferay-ui:search-container-column-text>
		                <div class="admin-title">${usr.fullName}</div>
		                <div class="admin-subtitle">
			                <c:set var="roles" value="${usr.roles}"/>
			                <c:set var="n" value=""/>
			                <c:forEach items="${roles}" var="item">
			                    <c:set var="n" value="<%=TextManager.getRolesDescription(usr)%>"/>
			                </c:forEach>
			                ${n}
		                </div>
		            </liferay-ui:search-container-column-text>
		
		            <liferay-ui:search-container-column-text>
		                <portlet:renderURL var="editURL">
		                    <portlet:param name="userId" value='${userId}'/>
		                    <portlet:param name="backURL" value='${backURL}'/>
		                    <portlet:param name="mvcRenderCommandName" value="/edit"/>
		                </portlet:renderURL>
		                <a href="${editURL}" title="<liferay-ui:message key='edit'/>">
		                    <span class="icon-large icon-pencil"></span>
		                </a>
		            </liferay-ui:search-container-column-text>
		        </liferay-ui:search-container-row>
		
		        <liferay-ui:search-iterator/>
		        </liferay-ui:search-container>
		        </aui:form>
		    </div>
		</div>
	</c:when>
</c:choose>