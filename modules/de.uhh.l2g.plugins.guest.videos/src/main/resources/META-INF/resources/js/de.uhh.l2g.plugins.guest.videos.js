
$( function() {	
	//hide all video sublists on load
	$('ul[id^="p"]').hide();

	//toggle functionality for video sublist 
	$('div[id^="vt"]').click(function() {
		var pId = "p"+this.id.substring(2);
		var bId = "b"+this.id.substring(2);
		$("#"+pId).toggle("slow");
		$("#"+bId + " i").toggleClass("icon-chevron-down");
	});
	
	$('button[id^="b"]').click(function() {
		var pId = "p"+this.id.substring(1);
		var bId = "b"+this.id.substring(1);
		$("#"+pId).toggle("slow");
		$("#"+bId + " i").toggleClass("icon-chevron-down");
	});
	
	//turn off autocomplete
	$(document).on('focus', ':input', function() {
	    $(this).attr('autocomplete', 'off');
	});
	
	// only show the last terms
	var maxTerms = 4;
	$("ul.terms > li").slice(maxTerms).hide();
	
	// show the remaining terms
	$('#loadMoreTerms').click(function () {
	    $('ul.terms > li').show();
	    $('#loadMoreTerms').hide();
	});
});
