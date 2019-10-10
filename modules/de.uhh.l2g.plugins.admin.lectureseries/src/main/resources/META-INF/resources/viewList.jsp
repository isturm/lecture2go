<%@include file="init.jsp"%>

<jsp:useBean id="institutions" type="java.util.LinkedHashMap" scope="request" />
<jsp:useBean id="producers" type="java.util.List<de.uhh.l2g.plugins.model.Producer>" scope="request" />
<jsp:useBean id="terms" type="java.util.List<de.uhh.l2g.plugins.model.Term>" scope="request" />
 
<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<%
	Long companyId = company.getCompanyId();
	Long groupId = company.getGroup().getGroupId();		

	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));

	List<Lectureseries> tempLectureseriesList = new ArrayList();

	Long producerId = ParamUtil.getLong(request, "producerId");
	Long semesterId = ParamUtil.getLong(request, "semesterId");
	Integer statusId = ParamUtil.getInteger(request, "statusId");
	Long institutionId = ParamUtil.getLong(request, "institutionId");

	//
	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	//
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("institutionId", institutionId+"");
	portletURL.setParameter("producerId", producerId+"");
	portletURL.setParameter("semesterId", semesterId+"");
	portletURL.setParameter("statusId", statusId+"");

	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);

	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

<c:set var="backURL" value="<%=backURL%>"/>

<liferay-portlet:renderURL varImpl="lectureseriesSearchURL">
    <portlet:param name="mvcPath" value="/viewList.jsp" />
</liferay-portlet:renderURL>

<c:set var="pageName" value="<%=pageName%>"/>

<c:set var="portletURL" value="<%=portletURL%>"/>
<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<c:set var="producerId" value="<%=producerId%>"/>
<c:set var="semesterId" value="<%=semesterId%>"/>
<c:set var="statusId" value="<%=statusId%>"/>
<c:set var="institutionId" value="<%=institutionId%>"/>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>

<div class="view list">		
		<c:if test="${permissionAdmin || permissionCoordinator}">
				<portlet:renderURL var="sortByInstitution">
					<portlet:param name="jspPage" value="/viewList.jsp" />
					<portlet:param name="producerId" value="${producerId}"/>
					<portlet:param name="semesterId" value="${semesterId}"/>
					<portlet:param name="statusId" value="${statusId}"/>
				</portlet:renderURL>
				<aui:form action="${sortByInstitution}" method="post">
					<aui:select name="institutionId" label="" onChange="submit();">
						<aui:option value=""><liferay-ui:message key="select-institution"/></aui:option>
						<c:forEach items="${institutions}" var="item">
							<aui:option value='${item.key}'>${item.value}</aui:option>
						</c:forEach>
					</aui:select>
				</aui:form>	

				<portlet:renderURL var="sortByProducer">
					<portlet:param name="jspPage" value="/viewList.jsp" />
					<portlet:param name="institutionId" value="${institutionId}"/>
					<portlet:param name="semesterId" value="${semesterId}"/>
					<portlet:param name="statusId" value="${statusId}"/>
				</portlet:renderURL>
				<aui:form action="${sortByProducer}" method="post">
					<aui:select name="producerId" label="" onChange="submit();">
						<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
						<c:forEach items="${producers}" var="item">
							<aui:option value='${item.producerId}'>${item.lastName} ${item.firstName}</aui:option>
						</c:forEach>
					</aui:select>
				</aui:form>	
		</c:if>		
		<portlet:renderURL var="sortBySemester">
			<portlet:param name="jspPage" value="/viewList.jsp" />
			<portlet:param name="institutionId" value="${institutionId}"/>
			<portlet:param name="statusId" value="${statusId}"/>
			<portlet:param name="producerId" value="${producerId}"/>
		</portlet:renderURL>
		<aui:form action="${sortBySemester}" method="post">
			<aui:select name="semesterId" label="" onChange="submit();">
				<aui:option value=""><liferay-ui:message key="select-semester"/></aui:option>
					<c:forEach items="${terms}" var="item">
						<aui:option value='${item.termId}'>${item.prefix} ${item.year}</aui:option>
					</c:forEach>
			</aui:select>
		</aui:form>		
									
		<portlet:renderURL var="sortByStatus">
			<portlet:param name="jspPage" value="/viewList.jsp" />
			<portlet:param name="institutionId" value="${institutionId}"/>
			<portlet:param name="producerId" value="${producerId}"/>
			<portlet:param name="semesterId" value="${semesterId}"/>
		</portlet:renderURL>
		<aui:form action="${sortByStatus}" method="post">
			<aui:select name="statusId" label="" onChange="submit();">
				<aui:option value="3"><liferay-ui:message key="select-status"/></aui:option>
					<c:choose>
					  <c:when test="${statusId==0}">
							<aui:option value='0' selected="true"><liferay-ui:message key="approved-false"/></aui:option>
					  </c:when>
					  <c:otherwise>
							<aui:option value='0'><liferay-ui:message key="approved-false"/></aui:option>
					  </c:otherwise>
					</c:choose>	
					<c:choose>
					  <c:when test="${statusId==1}">
							<aui:option value='1' selected="true"><liferay-ui:message key="approved-true"/></aui:option>
					  </c:when>
					  <c:otherwise>
							<aui:option value='1'><liferay-ui:message key="approved-true"/></aui:option>
					  </c:otherwise>
					</c:choose>						
			</aui:select>
		</aui:form>

	<a href="${addURL}" class="add link">
    	<liferay-ui:message key="add-new-lectureseries"/> <span class="icon-large icon-plus-sign"/>
	</a>

	<aui:form action="${lectureseriesSearchURL}" method="post" name="fm">
		<liferay-ui:search-container emptyResultsMessage="no-lectureseries-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
		<liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}" />
				<liferay-ui:search-container-results>
					<%
						DisplayTerms displayTerms =searchContainer.getDisplayTerms();
						String keywords = displayTerms.getKeywords(); 
						List<Lectureseries> lectureseriesList =  Collections.EMPTY_LIST;
						if (displayTerms.isAdvancedSearch()) {
							//Advance Search
							//lectureseriesList = LectureseriesLocalServiceUtil.getByIdTitleisAndOperatorAndCompanyId(cId, cName, displayTerms.isAndOperator(), companyId);
						} else if(!Validator.isBlank(keywords)){//Basic Search
							lectureseriesList = LectureseriesLocalServiceUtil.getByKeyWordsAndCompanyId(keywords, companyId);
						} else{//No Search
							lectureseriesList = LectureseriesLocalServiceUtil.getFilteredByApprovedSemesterFacultyProducer(statusId, semesterId, new Long(institutionId), new Long(producerId), new Long(0), companyId);
						}
					    searchContainer.setTotal(lectureseriesList.size());		 
					    searchContainer.setResults(ListUtil.subList(lectureseriesList, searchContainer.getStart(), searchContainer.getEnd()));
					%>				
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
						<portlet:renderURL var="editURL">
							<portlet:param name="lectureseriesId" value="${lectser.lectureseriesId}" />
							<portlet:param name="backURL" value="${backURL}" />
							<portlet:param name="mvcPath" value="/viewEdit.jsp" />
						</portlet:renderURL>
						
						<portlet:actionURL name="delete" var="removeURL">
							<portlet:param name="lectureseriesId" value='${lectser.lectureseriesId}' />
							<portlet:param name="backURL" value='${backURL}' />
						</portlet:actionURL>	
						
						<%
							Term t = TermLocalServiceUtil.createTerm(0);
							try{ t = TermLocalServiceUtil.getById(lectser.getTermId()); }catch(Exception e){}
						%>			
						<c:set var="lTerm" value="<%=t.getTermName()%>"/>
						
						<liferay-ui:search-container-column-text name="name">
							<div class="adminrow wide">
								<div class="admintile wide">
									<strong>${lectser.name} <c:if test="${fn:length(lTerm)>0}">(${lTerm})</c:if></strong><br/>
									<p><a href="${lectser.closedAccessURI}" target="blank"><liferay-ui:message key="lecture-series-closed-access-uri"/></a>&nbsp;|&nbsp;<a href="${lectser.closedAccessURI}" target="blank"><liferay-ui:message key="lecture-series-open-access-uri"/></a></p>
									<br/>
									<%
									List<Long> pIds = new ArrayList<Long>();
									String prds = "";
										try{
											pIds = ProducerLocalServiceUtil.getAllProducerIds(lectser.getLectureseriesId());
											for (int i = 0; i < pIds.size(); i++) {
												Long pLid = new Long(pIds.get(i)+"");
												Producer p = ProducerLocalServiceUtil.createProducer(0);
												p=ProducerLocalServiceUtil.getProdUcer(pLid);
												prds+=p.getLastName()+", "+ p.getFirstName()+"<br/>";
											}
										}catch(Exception e){}
						 			%>
						 			<%=prds %>
						 			<br />
						 			<c:if test="${lectser.numberOfVideos > 0}">
						 				<p>
							 				${lectser.numberOfVideos}
							 				<c:if test="${lectser.numberOfVideos > 1}"><liferay-ui:message key="video-datasets"/></c:if>
							 				<c:if test="${lectser.numberOfVideos == 1}"><liferay-ui:message key="video-dataset"/></c:if>
						 				</p>
						 			</c:if>
						 			<c:if test="${lectser.numberOfVideos == 0}">
						 				<p><liferay-ui:message key="no-videos-uploaded"/></p>
						 			</c:if>			 			
						 		</div>
						 		<div class="admintile wide icons">
									
									<c:choose>
										  <c:when test="${lectser.numberOfVideos > 0 || (permissionProducer && lectser.approved==1)}">
										  		<!-- nothing -->
										  </c:when>
										  <c:otherwise>
												<a href="${removeURL}">
													<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
												</a>						  
										 </c:otherwise>
									</c:choose>		
														
									<a href="${editURL}">
								   		<span class="icon-large icon-pencil"></span>
									</a>					
								</div>
							</div>
						</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:form>
</div>