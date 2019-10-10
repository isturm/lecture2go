<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />

<jsp:useBean id="root" type="de.uhh.l2g.plugins.model.Institution" scope="request" />
<jsp:useBean id="institutionsList" type="java.util.List<Institution>" scope="request" />

<portlet:renderURL var="viewURL">
	<portlet:param name="jspPage" value="/admin/institutionList.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/add" var="addURL" />
<portlet:actionURL name="/delete" var="deleteURL"/>
<portlet:actionURL name="/update" var="updateURL"/>

<c:set var="backURL" value="<%=String.valueOf(PortalUtil.getCurrentCompleteURL(request))%>"/>

<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchInstitutionContainer = null;%>
<%!com.liferay.portal.kernel.dao.search.SearchContainer<Institution> searchSubInstitutionContainer = null;%>

<div class="noresponsive">
		<%--ADD START--%>
		<c:if test="${permissionAdmin}">
			<aui:fieldset column="false" label="${pageName}" cssClass="add-institution" >
					<aui:form action="${addURL}">
						<aui:input name="institution" label="institution" required="true" inlineField="true"/>
		            		<aui:select name="hostId" id="select-streamer" label="streaming-server-name">
								<c:forEach items="${hostList}" var="host">
									<aui:option label="${host.name}" value="${host.hostId}"/>
								</c:forEach>
						    </aui:select>
					    <aui:input name='parent' type='hidden' inlineField="true" value='${root.institutionId}'/>
					    <aui:input name='level' type='hidden' inlineField="true" value='1'/>
					    <aui:input name="backURL" type='hidden' inlineField="true" value = "${backURL}"/>
						<aui:button type="submit" value="add" ></aui:button>
					</aui:form>
			</aui:fieldset>
		</c:if>
		<%--ADD END--%>
	
		<%--INSTITUTIONS START--%>
			<liferay-ui:search-container emptyResultsMessage="no-results-were-found" delta="5"  iteratorURL="${portletURL}" searchContainer="${searchInstitutionContainer}">
				<liferay-ui:search-container-results>
					<%
						DisplayTerms displayTerms =searchContainer.getDisplayTerms();
						//String keywords = displayTerms.getKeywords(); 
						searchContainer.setTotal(institutionsList.size());		 
						searchContainer.setResults(ListUtil.subList(institutionsList, searchContainer.getStart(), searchContainer.getEnd()));
					%>
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Institution" modelVar="institut" keyProperty="institutionId"  escapedModel="<%= false %>" indexVar="i">
				        <liferay-ui:search-container-column-text name="institution">
				 			<aui:form action="${updateURL}">
					 			<input name="<portlet:namespace/>name" value = "${institut.name}"  />
					 			<input name="<portlet:namespace/>institution-order" value = "${institut.sort}" />
								<%-- Only display streamer if user is allowed to view host and institution is child of top level --%>
								<c:if test='${institut.parentId == root.institutionId}'>
									<c:set var="instHost" value="<%= HostLocalServiceUtil.getByHostId(Institution_HostLocalServiceUtil.getByInstitution(institut.getInstitutionId()).getHostId())%>"/>
									<input name="streaming-server-name" value = "${instHost.name}" disabled="true"/>
								</c:if>
								<aui:input name="hostId" type='hidden' inlineField="true" value = "${host.hostId}"/>
								<aui:input name="institutionId" type='hidden' inlineField="true" value = "${institut.institutionId}"/>
								<aui:input name="backURL" type='hidden' inlineField="true" value = "${backURL}"/>
								<aui:button type="submit" value="update"/>
							</aui:form>
							<c:if test='<%= InstitutionLocalServiceUtil.getLockingElements(institut.getInstitutionId()) < 1 %>'>
								<aui:form action="${deleteURL}">
									<aui:button value="delete" type="submit"/>
									<aui:input name="backURL" type='hidden' inlineField="true" value = "${backURL}"/>
									<aui:input name="institutionId" type='hidden' inlineField="true" value = "${institut.institutionId}"/>
								</aui:form>
							</c:if>
							
							<c:set var="sublist" value="<%= InstitutionLocalServiceUtil.getByParentId(institut.getInstitutionId())%>"/>
							<c:if test="${!sublist.isEmpty()}">
								<ul class='subinstlist'>
										<li>
											<aui:form action="${addURL}">
												<input name="<portlet:namespace/>institution" label="subinstitution" required="true" inlineField="true"/>
						 						<input name="<portlet:namespace/>institution-order" value = "" />
											    <aui:input name='parent' type='hidden' inlineField="true" value='${institut.institutionId}'/>
											    <aui:input name='level' type='hidden' inlineField="true" value='2'/>
												<aui:input name="backURL" type='hidden' inlineField="true" value = "${backURL}"/>
												<aui:button type="submit" value="add" />
											</aui:form>	
										</li>
										<c:forEach items="${sublist}" var="element">
												<li>
										 			<aui:form action="${updateURL}">
											 			<input name="<portlet:namespace/>name" value = "${element.name}"  />
											 			<input name="<portlet:namespace/>institution-order" value = "${element.sort}" />
														<aui:input name="institutionId" type='hidden' inlineField="true" value = "${element.institutionId}"/>
														<aui:input name="backURL" type='hidden' inlineField="true" value = "<%=String.valueOf(PortalUtil.getCurrentCompleteURL(request))%>"/>
														<aui:button type="submit" value="update" />
													</aui:form>
													
													<c:set var="elementId" value="${element.institutionId}"/>
													<c:if test='<%= InstitutionLocalServiceUtil.getLockingElements((Long)pageContext.getAttribute("elementId")) < 1 %>'>
														<aui:form action="${deleteURL}">
															<aui:input name="institutionId" type='hidden' inlineField="true" value = "${element.institutionId}"/>
															<aui:input name="backURL" type='hidden' inlineField="true" value = "${backURL}"/>
															<aui:button value="delete" type="submit" />
														</aui:form>
													</c:if>													
												</li>
										</c:forEach>
										<c:if test="${isSearched && (videoCount>1)}">
											<li class="videotile small show-all" onClick="window.location='${view1URL}'">
													<liferay-ui:message key="all-videos"/>
											</li>
										</c:if>
								</ul>
							</c:if>
							
						</liferay-ui:search-container-column-text>
		    	</liferay-ui:search-container-row>
		   	 	
		   	 	<liferay-ui:search-iterator searchContainer="${searchInstitutionContainer}" />
			</liferay-ui:search-container>
		<%--INSTITUTIONS END--%>

</div>