<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.model.PortletPreferences" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@page import="java.util.LinkedHashMap"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONException"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<%@page import="de.uhh.l2g.plugins.model.Video" %>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries" %>
<%@page import="de.uhh.l2g.plugins.model.Institution" %>
<%@page import="de.uhh.l2g.plugins.model.Video_Institution" %>
<%@page import="de.uhh.l2g.plugins.service.VideoLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil" %>
<%@page import="de.uhh.l2g.plugins.util.Lecture2GoRoleChecker"%>

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