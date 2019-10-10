<%@ include file="init.jsp" %>

<jsp:useBean id="title" type="java.lang.String" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<jsp:useBean id="cInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="allInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Institution>" scope="request"/>
<jsp:useBean id="cfId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="pfId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="admin" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="reqUserId" type="java.lang.Long" scope="request"/>

<portlet:actionURL name="/update" var="updateURL"/>

<aui:form action="${updateURL}" method="post">
	<aui:fieldset helpMessage="" column="true" label='${title}'>
		<div>
			<liferay-ui:message key="set-coordinator-for-institution"/>
			<aui:select name="cfId" label="">
				<aui:option value=""><liferay-ui:message key="please-select-institution"/></aui:option>
				<c:forEach items="${cInstitutions}" var="item">
					<c:set var="selected" value="false"/>
					<c:if test="${cfId==item.institutionId}">
						<c:set var="selected" value="true"/>
					</c:if>
					<aui:option value='${item.institutionId}' selected="${selected}"> ${item.name}</aui:option>
				</c:forEach>
			</aui:select>
		</div>
		
		<div>
			<liferay-ui:message key="set-producer-for-institution"/>
			<aui:select name="pfId" label="">
				<aui:option value=""><liferay-ui:message key="please-select-institution"/></aui:option>
				<c:forEach items="${allInstitutions}" var="item">
					<c:set var="selected" value="false"/>
					<c:if test="${pfId==item.institutionId}">
						<c:set var="selected" value="true"/>
					</c:if>
					<aui:option value='${item.institutionId}' selected="${selected}"> ${item.name}</aui:option>
				</c:forEach>
			</aui:select>
		</div>
		
		<div>
			<liferay-ui:message key="set-admin"/>
			<aui:select name="isL2gAdmin" label="">
					<c:set var="selected" value="false"/>
					<c:if test="${admin}">
						<c:set var="selected" value="true"/>
					</c:if>
					<aui:option value='0' selected="${selected}"> <liferay-ui:message key="is-not-an-admin"/> </aui:option>
					<aui:option value='1' selected="${selected}"> <liferay-ui:message key="is-an-admin"/> </aui:option>
			</aui:select>
		</div>
		
			<aui:input name="userId" type="hidden" value="${reqUserId}"/>
		<aui:input name="backURL" type="hidden" value="${backURL}"/>
		<aui:button type="submit"/>
		<aui:button type="cancel" value="cancel" href="${backURL}" id="cancel"/>
	</aui:fieldset>
</aui:form>