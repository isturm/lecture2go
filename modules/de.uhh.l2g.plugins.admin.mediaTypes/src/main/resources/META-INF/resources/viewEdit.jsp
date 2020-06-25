<%@ include file="/init.jsp" %>

<jsp:useBean id="mediaType" type="de.uhh.l2g.plugins.model.MediaType" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />

<c:choose>
	<c:when test="${mediaType.mediaTypeId>0}">
		<portlet:actionURL name="edit" var="actionURL">
			<portlet:param name="mediaTypeId" value='${mediaType.mediaTypeId}' />
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="add" var="actionURL">
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	</c:otherwise>
</c:choose>

<div class="viewedit">
	<aui:form action="${actionURL}" commandName="model">
		<aui:container>
			<aui:row>
				<aui:col>
					<aui:input name="mediaTypeName" value="${mediaType.mediaTypeName}" type="text" label="media-type-name"/>
					<aui:input name="mediaTypeId" value="${mediaType.mediaTypeId}" type="hidden"/>
				</aui:col>
				<aui:col>
					<c:choose>
						<c:when test="${mediaType.mediaTypeId>0}">
							<aui:button type="submit" value="edit" id="edit"/>
						</c:when>
						<c:otherwise>
							<aui:button type="submit" value="add" id="add"/>
						</c:otherwise>
					</c:choose>
					<aui:button type="cancel" value="cancel" href="${backURL}"/>
				</aui:col>
			</aui:row>
		</aui:container>
	</aui:form>
</div>