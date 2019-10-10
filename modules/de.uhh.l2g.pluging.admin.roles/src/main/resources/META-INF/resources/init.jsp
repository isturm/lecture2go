<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="java.util.Collections"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@ page import="com.liferay.portal.kernel.model.Role"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ page import="de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.admin.roles.util.TextManager"%>
<%@ page import="de.uhh.l2g.plugins.admin.roles.search.UserSearchHelper"%>

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