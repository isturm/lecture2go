<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.service.persistence.PortletUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>

<%@ page import="de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil" %>
<%@ page import="de.uhh.l2g.plugins.service.HostLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.model.Institution"%>
<%@ page import="de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil"%>
<%@ page import="de.uhh.l2g.plugins.model.Host"%>


<%@ page import="de.uhh.l2g.plugins.admin.institutions.constants.AdminInstitutionManagementPortletKeys"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />