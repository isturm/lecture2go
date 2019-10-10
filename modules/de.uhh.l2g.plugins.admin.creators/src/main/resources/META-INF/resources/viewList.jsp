<%@page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Video"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.model.Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Video_Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries_Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Term"%>

<%@include file="init.jsp"%>

<%
	long companyId = company.getCompanyId();
	long groupId = company.getGroup().getGroupId();			

	String name = User.class.getName();
	User u = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
	PortletURL portletURL = renderResponse.createRenderURL();

	String jobTitle = ParamUtil.getString(request, "jobTitle");
	String firstName = ParamUtil.getString(request, "firstName");
	String middleName = ParamUtil.getString(request, "middleName");
	String lastName  = ParamUtil.getString(request, "lastName");
	String fullName = ParamUtil.getString(request, "fullName");
	
	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);
	String[] ct =  LanguageUtil.get(request, "creator-titles").split(",");
	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
%>

<c:set var="backURL" value="<%=backURL%>"/>
<c:set var="pageName" value="<%=pageName%>"/>

<c:set var="portletURL" value="<%=portletURL%>"/>
<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="creatorsSearchURL">
    <portlet:param name="mvcPath" value="/viewList.jsp" />
</liferay-portlet:renderURL>

<div class="view list">		
	<a href="${addURL}" class="add link">
	    <liferay-ui:message key="add-new-creator"/> <span class="icon-large icon-plus-sign"/>
	</a>
	
	<aui:form action="${creatorsSearchURL}" method="post" name="fm">
		<liferay-ui:search-container emptyResultsMessage="no-creators-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			<liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}" />
			<liferay-ui:search-container-results>
				<%
					DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					String keywords = displayTerms.getKeywords(); 
					List<Creator> creatorList =  Collections.EMPTY_LIST;
					
					if (displayTerms.isAdvancedSearch()) {//Advance Search
						creatorList = CreatorLocalServiceUtil.getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(jobTitle,firstName,middleName,lastName ,fullName, companyId, displayTerms.isAndOperator());
					} else if(!Validator.isBlank(keywords)){//Basic Search
						creatorList = CreatorLocalServiceUtil.getByKeyWordsAndCompanyId(keywords, companyId);
					} else{//No Search
						 creatorList = CreatorLocalServiceUtil.getAllByCompany(companyId);
					} 
					searchContainer.setTotal(creatorList.size());		 
					searchContainer.setResults(ListUtil.subList(creatorList,searchContainer.getStart(),searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Creator" keyProperty="creatorId" modelVar="creator">
				<c:set var="creatorId" value="<%=creator.getCreatorId()%>"/>
				
				<portlet:renderURL var="editURL">
					<portlet:param name="creatorId" value='${creatorId}' />
					<portlet:param name="mvcPath" value="/viewEdit.jsp" />
					<portlet:param name="backURL" value='${backURL}' />
				</portlet:renderURL>
				
				<portlet:actionURL name="delete" var="removeURL">
					<portlet:param name="creatorId" value='${creatorId}' />
					<portlet:param name="backURL" value='${backURL}' />
				</portlet:actionURL>		
				
				<liferay-ui:search-container-column-text>
					${creator.fullName}
					<br/>
					<c:set var="videoCreators" value="<%=Video_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId())%>"/>
					<c:if test="${videoCreators.size()>0}">
						<b><liferay-ui:message key="video-s"/></b>
					</c:if>
					<c:forEach items="${videoCreators}" var="vidcr" varStatus="status">
					   <br/>
					   <c:set var="vId" value="${vidcr.videoId}"/>
					   <c:set var="video" value="<%=VideoLocalServiceUtil.getVideo((Long)pageContext.getAttribute("vId"))%>"/>
					   <a href='${video.url}' target="_blank">${video.title}</a>
					</c:forEach>
					<br/>
					<c:set var="lectserCreators" value="<%=Lectureseries_CreatorLocalServiceUtil.getByCreator(creator.getCreatorId())%>"/>
					<c:if test="${lectserCreators.size()>0}">
						<b><liferay-ui:message key="lecture-series"/></b>
					</c:if>
					<c:forEach items="${lectserCreators}" var="lecre" varStatus="status">
					   <br/>
					   <c:set var="lecrId" value="${lecre.lectureseriesId}"/>
					   <c:set var="lectureseries" value="<%=LectureseriesLocalServiceUtil.getLectureseries((Long)pageContext.getAttribute("lecrId"))%>"/>
					   <c:set var="term" value="<%=TermLocalServiceUtil.getById(LectureseriesLocalServiceUtil.getLectureseries((Long)pageContext.getAttribute("lecrId")).getTermId())%>"/>
					   <c:out value="${lectureseries.name} - ${term.prefix} ${term.year}"/>
					</c:forEach>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
					<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
					   <span class="icon-large icon-pencil"></span>
					</a>
					<a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
						<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
					</a>	
				</liferay-ui:search-container-column-text>				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:form>
</div>