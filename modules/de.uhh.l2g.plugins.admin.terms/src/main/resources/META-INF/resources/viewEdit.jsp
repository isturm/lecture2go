<%@page import="de.uhh.l2g.plugins.model.Term" %>
<%@include file="init.jsp" %>

<jsp:useBean id="term" type="de.uhh.l2g.plugins.model.Term" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<c:choose>
  <c:when test="${term.termId>0}">
	<portlet:actionURL name="edit" var="actionURL">
		<portlet:param name="termId" value='${term.termId}' />
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
		                    <aui:input name="prefix" value="${term.prefix}" type="text" label="prefix"/> 
		                    <aui:input name="year" value="${term.year}" type="text" label="year"/> 
		                    <aui:input name="termId" value="${term.termId}" type="hidden"/>  
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${term.termId>0}">
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