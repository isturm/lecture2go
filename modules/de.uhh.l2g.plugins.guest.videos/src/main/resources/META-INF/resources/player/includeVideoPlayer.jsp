<video
        id="l2g-player"
        class="video-js"
        data-setup='{
            "playbackRates": [0.75, 1, 1.25, 1.5],
            "controlBar": {"pictureInPictureToggle": false },
            "preload": "auto"
        }'
>

	<c:forEach items="${video.jsonPlayerTracks.iterator()}" var="track">
        <c:if test="${track.get('kind')} == 'captions'">
            <track kind="${track.get('kind')}" src="${track.get('file')}" label="${track.get('label')}" default>
        </c:if>
    </c:forEach>
	
    <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a
        web browser that
        <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
</video>

<script>
    const player = videojs('l2g-player');
    initVideoPlayer(player, convertVideoUrls(${video.jsonPlayerUris}), "${video.image}");
    
    const citationAllowed = ${video.citation2go};
    if(citationAllowed === 1) {
    	setCitationFrameWindow(player, ${timeStart}, ${timeEnd});
    }
    
    $(document).ready(function(){
      enableCitation(player, $("#<portlet:namespace></portlet:namespace>timeStart"),  $("#<portlet:namespace></portlet:namespace>timeEnd"), "${video.url}", "${video.videoId}", "${lecture2goWebRoot}", $("#<portlet:namespace></portlet:namespace>citation"), $("#<portlet:namespace></portlet:namespace>citationiframe"));
    });
</script>