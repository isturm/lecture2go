<%@page import="de.uhh.l2g.plugins.model.Host" %>
<%@include file="init.jsp" %>

<jsp:useBean id="host" type="de.uhh.l2g.plugins.model.Host" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<c:choose>
  <c:when test="${host.hostId>0}">
	<portlet:actionURL name="edit" var="actionURL">
		<portlet:param name="hostId" value='${host.hostId}' />
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
		                    <aui:input name="protocol" value="${host.protocol}" type="text" label="protocol"/> 
		                    <aui:input name="streamer" value="${host.streamer}" type="text" label="streamer"/> 
		                    <aui:input name="port" value="${host.port}" type="text" label="port"/> 
		                    <aui:input name="hostId" value="${host.hostId}" type="hidden"/>  
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${host.hostId>0}">
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