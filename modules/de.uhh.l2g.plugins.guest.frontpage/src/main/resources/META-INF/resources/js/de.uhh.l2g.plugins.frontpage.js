$(document).ready(function(){
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
	
	// process different things depending on the screen size
	mediaCheck({
	  	media: '(min-width: 768px)',
	  	entry: function() {
		  	//hide all carousel items but the first and show carousel navigation
		  	$("#news-carousel .item:not(:first)").removeClass("active");
		  	$("#popular-carousel .item:not(:first)").removeClass("active");
		  	$(".carousel-control").show();
		  	showOrHideCarouselControl('#news-carousel');
		  	showOrHideCarouselControl('#popular-carousel');
		  	addBGVideo();
		 },
	  exit: function() {
		  	transformSearchToSmallView();
		  	// do not show the big button on desktop
		  	$(".filter-facility-menu").hide();
		  	//show all carousel items and hide carousel navigation
		  	$(".item").addClass("active");
		  	$(".carousel-control").hide();
		 }
	});

	// handle the previous and next buttons of the carousel
    $('#news-carousel').on('slid.bs.carousel', function() { 
    	showOrHideCarouselControl('#news-carousel');
    	// the truncation of the elements needs to be triggered manually on carousel switch
    	$(".active .title-small, .active .creator-small2, .active .lectureseries-small").trigger("update.dot");
    	});

    $('#popular-carousel').on('slid.bs.carousel', function() { 
    	showOrHideCarouselControl('#popular-carousel');
    	// the truncation of the elements needs to be triggered manually on carousel switch
    	$(".active .title-small, .active .creator-small2, .active .lectureseries-small").trigger("update.dot");
    });
    
    $('#vid-control').on("click", function(){
        var video = document.getElementById("bg-vid");
  		var $controlIcon = $(this).find('i').eq(0);
  		if (video.paused) {
  			video.play();
  			$controlIcon.switchClass("icon-play", "icon-pause");
  		} else {
  			video.pause();
  			$controlIcon.switchClass("icon-pause", "icon-play");
  		}
	});

});
		
// hides the "previous"-control-button on first carousel page and 
// the "next"-control-button on the last carousel page
function showOrHideCarouselControl(id) {
  	var $this = $(id);
  	if($this.find('.carousel-inner .item:first').hasClass('active')) {
  		$this.children('.left.carousel-control').hide();
  	} else if($this.find('.carousel-inner .item:last').hasClass('active')) {
    	$this.children('.right.carousel-control').hide();
  	} else {
    	$this.children('.carousel-control').show();
  	}
}

// add the video source to the video
function addBGVideo() {
	$('#bg-vid').prepend('<source src="/o/de.uhh.l2g.plugins.guest.frontpage/img/background.mp4" type="video/mp4">');
}