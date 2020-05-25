<video
        id="l2g-player"
        class="video-js"
        data-setup='{
            "playbackRates": [0.75, 1, 1.25, 1.5],
            "controlBar": {"pictureInPictureToggle": false },
            "fluid": true,
            "poster": "${video.image}",
            "controls": true,
            "preload": "auto",
            "aspectRatio": "16:9"
        }'
>

    <!-- TODO: proper file type recognition -->
    <c:forEach items="${video.jsonPlayerUris.iterator()}" var="uri">
        <c:if test="${uri.get('file').contains('.m3u8')}">
            <source src="${uri.get('file')}" type="application/x-mpegURL" />
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
    player.hlsQualitySelector({
        displayCurrentQuality: true,
    });

    // Diese Funktion wird genutzt, um die Url-Parameter auszulesen
    const getUrlParameter = function(sParam) {
        const sPageURL = window.location.search.substring(1);
        const sURLVariables = sPageURL.split('&');
        for (let i = 0; i < sURLVariables.length; i++) {
            const sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName[1];
            }
        }
    };

    // Start- und Endzeit der Zitatfunktion ermitteln (Durch die URL Parameter)
    let frameStart = getUrlParameter('start');
    let frameEnd = getUrlParameter('end');
    const fs = ${timeStart};
    const fe = ${timeEnd};
    const citationAllowed = ${video.citation2go};

    if(citationAllowed === 1 && fs >= 0 && fe > fs){
        frameStart = ${timeStart};
        frameEnd = ${timeEnd};

        player.offset({
            start: frameStart,
            end: frameEnd,
            restart_beginning: true
        });
    }

    let citationStartTime;
    let citationEndTime;
    $(document).ready(function(){
        $("#<portlet:namespace></portlet:namespace>timeStart").click(function() {
            citationStartTime = player.currentTime();
            $("#<portlet:namespace></portlet:namespace>timeStart").val(secondsToTime(citationStartTime));
            generateClipLink(citationStartTime, citationEndTime);
        });
        $("#<portlet:namespace></portlet:namespace>timeEnd").click(function() {
            citationEndTime = player.currentTime();
            $("#<portlet:namespace></portlet:namespace>timeEnd").val(secondsToTime(citationEndTime));
            generateClipLink(citationStartTime, citationEndTime);
        });
    });

    function generateClipLink(firstFrame, lastFrame) {
        firstFrame = Math.round(firstFrame);
        lastFrame = Math.round(lastFrame);

        if (citationStartTime != null && citationEndTime != null) {
            $("#<portlet:namespace></portlet:namespace>citation").val("${video.url}"+"/"+firstFrame+"/"+lastFrame);
            const videoId = "${video.videoId}";
            const host ="${lecture2goWebRoot}";

            const iframe="<iframe src='"+host+"/TODO/?v="+videoId+"/"+firstFrame+"/"+lastFrame+"' frameborder='0' width='647' height='373' allowfullscreen></iframe>";
            $("#<portlet:namespace></portlet:namespace>citationiframe").val(iframe);
        }
    }
</script>