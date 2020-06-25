<%@include file="init.jsp"%>

<%
    PortletURL backURL = renderResponse.createRenderURL();
%>

<c:set var="backURL" value="<%=backURL%>"/>

<liferay-portlet:renderURL var="addURL">
    <portlet:param name="backURL" value='${backURL}' />
    <portlet:param name="mvcPath" value="/viewEdit.jsp" />
</liferay-portlet:renderURL>


<a href="${addURL}" class="add-link">
    <span class="icon-large icon-plus"></span> <liferay-ui:message key="add-new-media-type"/>
</a>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="de.uhh.l2g.plugins.model.MediaType" %>
<%@ page import="de.uhh.l2g.plugins.service.MediaTypeLocalServiceUtil" %>
<%@ page import="javax.portlet.PortletURL" %>

<%
    List<MediaType> mediaTypes = MediaTypeLocalServiceUtil.getMediaTypes(-1,-1);
%>

<liferay-ui:search-container total="<%=mediaTypes.size()%>" var="searchContainer" delta="10" deltaConfigurable="true"
                             emptyResultsMessage="There Are No Media Types To Display.">

    <liferay-ui:search-container-results results="<%=ListUtil.subList(mediaTypes, searchContainer.getStart(),searchContainer.getEnd())%>" />
    <liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.MediaType" modelVar="mediaType" keyProperty="mediaTypeId" >
        <portlet:actionURL name="delete" var="removeURL">
            <portlet:param name="mediaTypeId" value='${mediaType.mediaTypeId}' />
            <portlet:param name="backURL" value='${backURL}' />
        </portlet:actionURL>

        <portlet:renderURL var="editURL">
            <portlet:param name="mediaTypeId" value='${mediaType.mediaTypeId}' />
            <portlet:param name="mvcPath" value="/viewEdit.jsp" />
            <portlet:param name="backURL" value='${backURL}' />
        </portlet:renderURL>

        <liferay-ui:search-container-column-text name="ID" value="${mediaType.mediaTypeId}"/>
        <liferay-ui:search-container-column-text name="Name" value="${mediaType.mediaTypeName}"/>
        <liferay-ui:search-container-column-text name="Edit">
            <a href="${editURL}" title="<liferay-ui:message key='edit'/>">
                <span class="icon-large icon-pencil"></span>
            </a>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Delete">
            <a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
                <span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
            </a>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />

</liferay-ui:search-container>
