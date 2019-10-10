<%@page import="de.uhh.l2g.plugins.model.Video_Category"%>
<%@page import="de.uhh.l2g.plugins.model.Category"%>
<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil"%>

<%@include file="init.jsp"%>

<%
	long companyId = company.getCompanyId();
	long groupId = company.getGroup().getGroupId();			

	int cId = ParamUtil.getInteger(request, "cId");
	String cName = ParamUtil.getString(request, "cName");
	PortletURL portletURL = renderResponse.createRenderURL();
	String delta = request.getParameter("delta");
	String cur = request.getParameter("cur");
	PortletURL backURL = portletURL;
	backURL.setParameter("delta", delta);
	backURL.setParameter("cur", cur);
%> 
 
<c:set var="backURL" value="<%=backURL%>"/>

<liferay-portlet:renderURL varImpl="categoriesSearchURL">
    <portlet:param name="mvcPath" value="/viewList.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="addURL">
	<portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>

<c:set var="groupId" value="<%=groupId%>"/>
<c:set var="companyId" value="<%=companyId%>"/>

<c:set var="portletURL" value="<%=portletURL%>"/>
<c:set var="application" value="<%=application%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<div class="view list">		
	<a href="${addURL}" class="add link">
	    <liferay-ui:message key="add-new-category"/> <span class="icon-large icon-plus-sign"/>
	</a>
			
	<aui:form action="${categoriesSearchURL}" method="post" name="fm">
		<liferay-ui:search-container emptyResultsMessage="no-categories-found" delta="5" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			<liferay-ui:search-form page="/viewSearch.jsp" servletContext="${application}" />
			<liferay-ui:search-container-results>
				<%
					DisplayTerms displayTerms =searchContainer.getDisplayTerms();
					String keywords = displayTerms.getKeywords(); 
					List<Category> categoriesList =  Collections.EMPTY_LIST;
					if (displayTerms.isAdvancedSearch()) {//Advance Search
						categoriesList = CategoryLocalServiceUtil.getByIdTitleisAndOperatorAndCompanyId(cId, cName, displayTerms.isAndOperator(), companyId);
					} else if(!Validator.isBlank(keywords)){//Basic Search
						categoriesList = CategoryLocalServiceUtil.getByKeyWordsAndCompanyId(keywords, companyId); 
					} else{//No Search
						 categoriesList = CategoryLocalServiceUtil.getAllCategoriesByCompanyId(companyId);
					}  
				    searchContainer.setTotal(categoriesList.size());		 
				    searchContainer.setResults(ListUtil.subList(categoriesList,searchContainer.getStart(),searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>
		
			<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Category" keyProperty="categoryId" modelVar="category">
				<% 
					Long catIdLong = category.getCategoryId();
					//count videos from category
					List<Video_Category> vcl = Video_CategoryLocalServiceUtil.getByCategory(catIdLong);
					int count = vcl.size();
				%>
				<c:set var="count" value="<%=count%>"/>
				<c:set var="catId" value="<%=catIdLong%>"/>
				
				<portlet:actionURL name="delete" var="removeURL">
					<portlet:param name="categoryId" value='${catId}' />
					<portlet:param name="backURL" value='${backURL}' />
				</portlet:actionURL>		

				<portlet:renderURL var="editURL">
					<portlet:param name="categoryId" value='${catId}' />
					<portlet:param name="mvcPath" value="/viewEdit.jsp" />
					<portlet:param name="backURL" value='${backURL}' />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text>
					${category.name}
					<c:if test="${count>0}">
						<p><b>${count}</b> <liferay-ui:message key="video-s"/></p>
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text>
						<a href="${editURL}" title="<liferay-ui:message key='edit'/>">
						   <span class="icon-large icon-pencil"></span>
						</a>
						<c:if test="${count==0}">						
						<a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
							<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
						</a>	
						</c:if>				
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>	
	</aui:form>
</div>