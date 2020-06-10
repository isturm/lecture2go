<video
        id="l2g-player"
        class="video-js"
        data-setup='{
            "playbackRates": [0.75, 1, 1.25, 1.5],
            "controlBar": {"pictureInPictureToggle": false, "chaptersButton": false },
            "preload": "auto"
        }'
>
    <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a
        web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
</video>

<script>
    const player = videojs('l2g-player');
    const is360Video = <%= request.getAttribute("is360Video") %> ? true : false;

    initVideoPlayer(
        player,
        convertVideoUrls(${reqVideo.jsonPlayerUris}),
        "${reqVideo.image}",
        ${reqVideo.jsonPlayerTracks},
        is360Video
    );
    
    $(document).ready(function(){
    	let timeStart = $("#<portlet:namespace></portlet:namespace>timeStart");
    	let timeEnd = $("#<portlet:namespace></portlet:namespace>timeEnd");
    	
        enableSegmentation(player, timeStart,  timeEnd, $('#addSegmentButton'));
    	
        // Ausgewählte Zeiten validieren
        $('#segment-input-add').find("button").prop('disabled', true);
        $('div.segment-time').click(function() {
        	$('#segment-input-add').find("button").prop('disabled', !isValidClipTime(timeStart, timeEnd));
        });
        
        // Sollte der Nutzer auf die Kapitel klicken,
        // wird zur entsprechenden Stelle gesprungen
        const segments = $('#segments');
        segments.on('click', 'div.chaptertile-clickable', function(event) {
        	player.currentTime(timeToSeconds($(event.currentTarget).attr('begin')))
        	document.getElementById('videoTitle').scrollIntoView();
			if(player.paused()) {
				player.play();
			}
        });

        segments.find("input[alt='delete']").on("click", function(event) {
        	event.stopPropagation();
        });
    });
</script>