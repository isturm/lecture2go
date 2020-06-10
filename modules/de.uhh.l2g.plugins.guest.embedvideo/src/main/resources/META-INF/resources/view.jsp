<%@ include file="/init.jsp" %>

<portlet:renderURL var="embedURL">
	<portlet:param name="mvcRenderCommandName" value="/embed" />
</portlet:renderURL>

<video
		id="embed-player"
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
	const uris = [].concat(<%= request.getAttribute("uris") %>);
	const tracks = [].concat(<%= request.getAttribute("tracks") %>);
	const citationAllowed = 0 + <%= request.getAttribute("citationAllowed") %>;
	const startTime = 0 + <%= request.getAttribute("startTime") %>;
	const endTime = 0 + <%= request.getAttribute("endTime") %>;
	const image = "<%= request.getAttribute("image") %>";
	const is360Video = <%= request.getAttribute("is360Video") %> ? true : false;

	const player = videojs('embed-player');
			initVideoPlayer(player, convertVideoUrls(uris), image, tracks, is360Video);

	if (citationAllowed === 1) {
		setCitationFrameWindow(player, startTime, endTime);
	}

	if (startTime === 0 && endTime === 0) {
		player.chapterMarkersPlugin();
	}

	const button = videojs.getComponent('Button');
	const sourceLinkButton = videojs.extend(button, {
		constructor: function() {
			button.apply(this, arguments);
			this.addClass('source-link-button');
		},
		handleClick: function() {
			player.pause();
			window.open('<%= request.getAttribute("sourceUrl") %>', '_blank');
		}
	});

	videojs.registerComponent('SourceLinkButton', sourceLinkButton);
	player.getChild('controlBar').addChild('sourceLinkButton', {});
</script>