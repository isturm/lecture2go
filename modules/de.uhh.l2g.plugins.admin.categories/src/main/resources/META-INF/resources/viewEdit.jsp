<%@page import="de.uhh.l2g.plugins.model.Category" %>
<%@include file="init.jsp" %>

<jsp:useBean id="category" type="de.uhh.l2g.plugins.model.Category" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<c:choose>
  <c:when test="${category.categoryId>0}">
	<portlet:actionURL name="edit" var="actionURL">
		<portlet:param name="categoryId" value='${category.categoryId}' />
		<portlet:param name="backURL" value='${backURL}' />
	</portlet:actionURL>
  </c:when>
  <c:otherwise>
	<portlet:actionURL name="add" var="actionURL">
		<portlet:param name="backURL" value='${backURL}' />
	</portlet:actionURL>
  </c:otherwise>
</c:choose>

<div class="view edit">
	<aui:form action="${actionURL}" commandName="model">
		<aui:container cssClass='super-awesome-container'>
		        <aui:row>
		                <aui:col>
		                    <aui:input name="name" value="${category.name}" type="text" label="name"/> 
		                    <aui:input name="categoryId" value="${category.categoryId}" type="hidden"/>  
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${category.categoryId>0}">
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