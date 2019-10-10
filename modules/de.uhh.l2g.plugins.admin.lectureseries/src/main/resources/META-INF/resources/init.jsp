<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@

taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.model.PortletPreferences" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONException"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Set"%>

<%@page import="de.uhh.l2g.plugins.util.Lecture2GoRoleChecker"%>
<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.ProducerLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.model.Coordinator"%>
<%@page import="de.uhh.l2g.plugins.model.Institution"%>
<%@page import="de.uhh.l2g.plugins.model.Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Term"%>
<%@page import="de.uhh.l2g.plugins.model.Category"%>
<%@page import="de.uhh.l2g.plugins.service.CategoryLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.TermLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.CreatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.ProducerLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil"%>
<%@page import="de.uhh.l2g.plugins.model.Lectureseries"%>
<%@page import="de.uhh.l2g.plugins.model.Producer"%>
<%@page import="de.uhh.l2g.plugins.model.Coordinator"%>
<%@page import="de.uhh.l2g.plugins.model.Institution"%>
<%@page import="de.uhh.l2g.plugins.model.Creator"%>
<%@page import="de.uhh.l2g.plugins.model.Term"%>
<%@page import="de.uhh.l2g.plugins.model.Category"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />



