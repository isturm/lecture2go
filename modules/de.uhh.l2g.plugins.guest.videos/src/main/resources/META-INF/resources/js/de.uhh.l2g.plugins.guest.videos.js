
$( function() {
	//---prepare auto complete results start
	//set here your portlet name space.
	var autoCompleteList;
	//auto complete list for findVideos
	AUI().use('autocomplete-list', 'aui-base', 'aui-io-request', 'autocomplete-filters', 'autocomplete-highlighters', function(A) {
	    //URL for call serverResource method
		var nameSpace = A.one('#portletNamespace').get('text'); 
	    var findVideosURL = A.one('#findVideosURL').get('text');
	    //findVideos name
	    //call serverResource method with ajax which give in response.
	    A.io.request(findVideosURL, {
	        dataType: 'json',
	        method: 'POST',
	        sync: true,
	        on: {
	            success: function() {
	                console.log("Enter in success");
	                //create autocomplete obejct for findVideos input box
	                autoCompleteList = new A.AutoCompleteList({
	                    activateFirstItem: 'true',
	                    inputNode: '#'+nameSpace + 'findVideos',
	                    resultTextLocator: 'word',
	                    render: 'true',
	                    resultHighlighter: 'phraseMatch',
	                    resultFilters: ['phraseMatch'],
	                    source: this.get('responseData'),
	                    typeAhead: true,
	                    maxResults: 20,
	                    minQueryLength: 3,
	                });
	                //submit selected search word
	                autoCompleteList.on(
	                		'select',
	                		function(event) {
	                			var searchWord=event.result.text;
	                			$('#'+nameSpace + 'findVideos').val(searchWord);
	                			$('#'+nameSpace + 'submitForm').submit();
	                		}
	                );
	            }
	        }
	    });
	});	
	//---prepare auto complete results end
	
	//hide all video sublists on load
	$('ul[id^="p"]').hide();

	//toggle functionality for video sublist 
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
