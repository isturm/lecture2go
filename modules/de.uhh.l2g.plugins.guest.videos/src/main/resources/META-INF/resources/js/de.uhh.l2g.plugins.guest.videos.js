
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
        //create autocomplete object for findVideos input box
    	var inputField = '#'+nameSpace + 'findVideos';
        autoCompleteList = new A.AutoCompleteList({
            activateFirstItem: 'true',
            inputNode: inputField,
            resultTextLocator: 'word',
            render: 'true',
            resultHighlighter: 'phraseMatch',
            resultFilters: ['phraseMatch'],
            source: function(query, callback) {
            	var searchURL = Liferay.PortletURL.createURL(findVideosURL);
            	searchURL.setParameter("searchText", A.one(inputField).get('value'));
            	searchURL.setParameter("resultLimit", 10);
            	A.io.request(searchURL.toString(), {
            		dataType: 'json',
        	        method: 'POST',
        	        sync: true,
        	        on: {
	                    success:function(){
	                       callback(this.get('responseData'));
	                    }
	                }
            	});
            },
            typeAhead: true,
            maxResults: 10,
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
	});	
	//---prepare auto complete results end
	
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
