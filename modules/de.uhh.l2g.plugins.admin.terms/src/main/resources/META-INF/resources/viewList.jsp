<%@page import="de.uhh.l2g.plugins.model.Term"%>
<%@page import="de.uhh.l2g.plugins.model.Video"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>

<%@include file="init.jsp"%>

<%
	long companyId = company.getCompanyId();
	long groupId = company.getGroup().getGroupId();	

	PortletURL portletURL = renderResponse.createRenderURL();
	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);
	String pageName = themeDisplay.getLayout().getName(themeDisplay.getLocale());
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
	    <liferay-ui:message key="add-new-term"/> <span class="icon-large icon-plus-sign"/>
	</a>	
	
	<liferay-ui:search-container emptyResultsMessage="no-terms-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			<liferay-ui:search-container-results>
				<%
					DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					String keywords = displayTerms.getKeywords(); 
					List<Term> termsList =  Collections.EMPTY_LIST;
					termsList = TermLocalServiceUtil.getByCompanyId(companyId);
				    searchContainer.setTotal(termsList.size());		 
				    searchContainer.setResults(ListUtil.subList(termsList, searchContainer.getStart(), searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>
	
		<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Term" keyProperty="termId" modelVar="term">
			<%
				List<Video> vl = VideoLocalServiceUtil.getByTerm(term.getTermId());
				ListIterator<Video> vli = vl.listIterator(); 
				int count1 = vl.size();
				//
				List<Lectureseries> ll = LectureseriesLocalServiceUtil.getByTerm(term.getTermId()); 
				ListIterator<Lectureseries> lli = ll.listIterator();  
				int count2 = ll.size();
				//
				Long termIdLong = term.getTermId();
			%>
			<c:set var="count1" value="<%=count1%>"/>
			<c:set var="count2" value="<%=count2%>"/>
			<c:set var="termId" value="<%=termIdLong%>"/>
				
			<portlet:actionURL name="delete" var="removeURL">
				<portlet:param name="termId" value='${termId}' />
				<portlet:param name="backURL" value='${backURL}' />
			</portlet:actionURL>		

			<portlet:renderURL var="editURL">
				<portlet:param name="termId" value='${termId}' />
				<portlet:param name="mvcPath" value="/viewEdit.jsp" />
				<portlet:param name="backURL" value='${backURL}' />
			</portlet:renderURL>	
			
			<liferay-ui:search-container-column-text>
				${term.prefix} ${term.year}
				<c:if test="${count1>0}">
					<br/><b>${count1}</b> <liferay-ui:message key="video-s"/>
				</c:if>
				<c:if test="${count2>0}">
					<br/><b>${count2}</b> <liferay-ui:message key="lecture-series-s"/>
				</c:if>					
			</liferay-ui:search-container-column-text>
				
			<liferay-ui:search-container-column-text>
				<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
				   <span class="icon-large icon-pencil"></span>
				</a>
				<c:if test="${count1==0 && count2==0}">						
				<a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
					<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
				</a>	
				</c:if>				
			</liferay-ui:search-container-column-text>			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>