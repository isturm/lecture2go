
$( function() {	
	$('#<portlet:namespace/>submit').click(function(){
		return confirm('<liferay-ui:message key="correct-institution-selected-question"/>');
	});
	$('#<portlet:namespace/>cancel').click(function(){
		   window.location.href="/";
	});
});
