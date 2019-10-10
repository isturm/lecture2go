<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys "%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.springframework.web.bind.ServletRequestUtils"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<%@page import="de.uhh.l2g.plugins.model.Term" %>
<%@page import="de.uhh.l2g.plugins.model.Creator" %>
<%@page import="de.uhh.l2g.plugins.model.Category" %>
<%@page import="de.uhh.l2g.plugins.model.Video" %>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries" %>
<%@page import="de.uhh.l2g.plugins.model.Institution" %>
<%@page import="de.uhh.l2g.plugins.model.Video_Institution" %>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries_Institution" %>

<%@page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil" %>

<%@page import="de.uhh.l2g.plugins.util.AutocompleteManager"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="companyId" value="<%=company.getCompanyId()%>"/>
<c:set var="groupId" value="<%=company.getGroup().getGroupId()%>"/>
<c:set var="userId" value="<%=realUser.getUserId()%>"/>

<%
	Long companyId = company.getCompanyId();
	Long groupId = company.getGroup().getGroupId();		
	Long userId = realUser.getUserId();		
%>

<script>
	var nameSpace = "<portlet:namespace />";
</script>

<c:set var="nameSpace" value="<portlet:namespace />"/>