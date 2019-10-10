<%@page import="de.uhh.l2g.plugins.model.Host" %>
<%@page import="de.uhh.l2g.plugins.service.HostLocalServiceUtil" %>

<%@include file="init.jsp"%>

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<portlet:renderURL var="viewURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></portlet:renderURL>
<liferay-portlet:renderURL varImpl="outerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="innerURL"><portlet:param name="jspPage" value="/admin/institutionList.jsp" /></liferay-portlet:renderURL>

<%
	long companyId = company.getCompanyId();
	long groupId = company.getGroup().getGroupId();			
	
	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	PortletURL portletURL = renderResponse.createRenderURL();

	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);
%>

<c:set var="backURL" value="<%=backURL%>"/>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>

<c:set var="portletURL" value="<%=portletURL%>"/>
<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<div class="view list">		
	<a href="${addURL}" class="add link">
	    <liferay-ui:message key="add-new-host"/> <span class="icon-large icon-plus-sign"/>
	</a>
	
	<liferay-ui:search-container emptyResultsMessage="no-hosts-found" delta="5" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
		<liferay-ui:search-container-results>
			<%
				DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				String keywords = displayTerms.getKeywords(); 
				List<Host> hostsList =  Collections.EMPTY_LIST;
				hostsList = HostLocalServiceUtil.getByCompanyId(companyId);
			    searchContainer.setTotal(hostsList.size());		 
			    searchContainer.setResults(ListUtil.subList(hostsList, searchContainer.getStart(), searchContainer.getEnd()));
			%>
		</liferay-ui:search-container-results>	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Host" keyProperty="hostId" modelVar="host">
			<%
				int inst = HostLocalServiceUtil.getLockingElements(companyId, host.getHostId());
			%>
			<c:set var="hostId" value="<%=host.getHostId()%>"/>
			<c:set var="isAdmin" value="<%=permissionAdmin%>"/>
			<c:set var="isCoordinator" value="<%=permissionCoordinator%>"/>
			<c:set var="inst" value="<%=inst%>"/>
				
			<portlet:actionURL name="delete" var="removeURL">
				<portlet:param name="hostId" value='${hostId}' />
				<portlet:param name="backURL" value='${backURL}' />
			</portlet:actionURL>		

			<portlet:renderURL var="editURL">
				<portlet:param name="hostId" value='${hostId}' />
				<portlet:param name="mvcPath" value="/viewEdit.jsp" />
				<portlet:param name="backURL" value='${backURL}' />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text>
				${host.streamer} | <liferay-ui:message key="directory"/> ${host.name}
				<c:if test="${inst>0}">
					<p><b>${inst}</b> <liferay-ui:message key="institution-s"/></p>
				</c:if>
			</liferay-ui:search-container-column-text>
				
			<liferay-ui:search-container-column-text>
				<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
				   <span class="icon-large icon-pencil"></span>
				</a>
				<c:if test="${inst==0}">						
					<a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
						<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
					</a>	
				</c:if>				
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
