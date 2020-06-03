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
    initVideoPlayer(player, convertVideoUrls(${video.jsonPlayerUris}), "${video.image}", ${video.jsonPlayerTracks});
    
    const citationAllowed = ${video.citation2go};
    if(citationAllowed === 1) {
    	setCitationFrameWindow(player, ${timeStart}, ${timeEnd});
    }

    if (0 === ${timeStart} && ${timeEnd} === 0) {
        player.chapterMarkersPlugin();
    }
    
    $(document).ready(function(){
      enableSegmentation(player, $("#<portlet:namespace></portlet:namespace>timeStart"),  $("#<portlet:namespace></portlet:namespace>timeEnd"), "${video.url}", "${video.videoId}", "${lecture2goWebRoot}", $("#<portlet:namespace></portlet:namespace>citation"), $("#<portlet:namespace></portlet:namespace>citationiframe"));
    });
</script>