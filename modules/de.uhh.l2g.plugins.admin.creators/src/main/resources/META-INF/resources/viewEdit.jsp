<%@page import="de.uhh.l2g.plugins.model.Creator" %>
<%@include file="init.jsp" %>

<jsp:useBean id="creator" type="de.uhh.l2g.plugins.model.Creator" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<c:choose>
	  <c:when test="${creator.creatorId>0}">
		<portlet:actionURL name="edit" var="actionURL">
			<portlet:param name="creatorId" value='${creator.creatorId}' />
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:when>
	  
	  <c:otherwise>
		<portlet:actionURL name="add" var="actionURL">
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:otherwise>
</c:choose>

<div class="viewedit">
	<aui:form action="${actionURL}" commandName="model">
		<aui:container cssClass='super-awesome-container'>
		        <aui:row>
		                <aui:col>
		                    <aui:input name="jobTitle" value="${creator.jobTitle}" type="text" label="job-title"/> 
		                    <aui:input name="firstName" value="${creator.firstName}" type="text" label="first-name"/> 
		                    <aui:input name="middleName" value="${creator.middleName}" type="text" label="middle-name"/> 
		                    <aui:input name="lastName" value="${creator.lastName}" type="text" label="last-name"/> 
		                    <aui:input name="creatorId" value="${creator.creatorId}" type="hidden"/>  
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${creator.creatorId>0}">
				                     <aui:button type="submit" value="edit" id="edit"/>
							  </c:when>
							  <c:otherwise>
				                     <aui:button type="submit" value="add" id="add"/>
							  </c:otherwise>
							</c:choose>		
							<aui:button type="cancel" value="cancel" href="${backURL}"/>
						</aui:col>
		        </aui:row>
		</aui:container>
	</aui:form>
</div>