$(document).ready(function(){
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