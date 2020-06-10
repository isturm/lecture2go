<video
        id="l2g-player"
        class="video-js"
        data-setup='{
            "playbackRates": [0.75, 1, 1.25, 1.5],
            "controlBar": {"pictureInPictureToggle": false },
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

    function initializePlayer() {
        AUI().use('aui-io-request', function (A) {
            A.io.request("${getJSONVideoURL}", {
                method: 'post',
                dataType: 'json',
                sync: true,
                data: {
                    "<portlet:namespace/>videoId": "${reqVideo.videoId}"
                },
                on: {
                    success: function () {
                        //json object
                        var data = this.get('responseData');
                        var videoUrls = [];
                        for(var i in data.playerUris) {
                        	var videoUrl = data.playerUris[i];
                        	videoUrls.push({type: getVideoMimeType(videoUrl.file), src: videoUrl.file});
                        }
                        initVideoPlayer(player, videoUrls, data.thumbnail, null, is360Video);
                    }
                }
            });
        });
    }
</script>