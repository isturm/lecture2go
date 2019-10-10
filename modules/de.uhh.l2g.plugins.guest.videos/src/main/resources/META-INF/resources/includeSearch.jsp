<portlet:actionURL name="/view/action/list" var="actionURL"/>

<aui:form action="/web/vod/l2go/-/get/0/0/0/0/0/" method="POST" name="submitForm">
	<aui:input name="findVideos" id="findVideos" label="" inlineField="true" value="${memberDTO.findVideos}"/>
</aui:form>		