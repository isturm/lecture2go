function initVideoPlayer(player, videoUrls, poster, textTracks) {
    player.fluid(true);
    player.controls(true);
    player.aspectRatio("16:9");
	player.src(videoUrls);
    player.poster(poster);

    addTextTracks(textTracks, player);

    player.hlsQualitySelector();
    videojs.registerPlugin('chapterMarkersPlugin', ChapterMarkersPlugin);
    player.chapterMarkersPlugin();

};

function convertVideoUrls(jsonPlayerUris) {
    var videoUrls = [];
    for(var i in jsonPlayerUris) {
    	var videoUrl = jsonPlayerUris[i];
    	videoUrls.push({type: getVideoMimeType(videoUrl.file), src: videoUrl.file});
    }
    return videoUrls;
};

function addTextTracks(jsonPlayerTracks, player) {
    jsonPlayerTracks.forEach(track =>
            player.addRemoteTextTrack({src: track.file, kind: track.kind, label: track.label, default: true})
    );
}

function getVideoMimeType(videoUrl) {
	if(videoUrl.includes('.m3u8')) {
		return 'application/x-mpegURL';
	} else if (videoUrl.includes('.mp4')) {
		return 'video/mp4';
	} else {
		return '';
	}
};

// Start- und Endzeit der Zitatfunktion ermitteln (Durch die URL Parameter)
function setCitationFrameWindow(player, timeStart, timeEnd) {
	let frameStart = getUrlParameter('start');
    let frameEnd = getUrlParameter('end');
    const fs = timeStart;
    const fe = timeEnd;

    if(fs >= 0 && fe > fs){
        frameStart = timeStart;
        frameEnd = timeEnd;

        player.offset({
            start: frameStart,
            end: frameEnd,
            restart_beginning: true
        });
    }
};

function enableCitation(player, timeStart, timeEnd, videoUrl, videoId, host, citation, citationiframe) {
	let citationStartTime;
    let citationEndTime;
	timeStart.click(function() {
	    citationStartTime = player.currentTime();
	    timeStart.val(secondsToTime(citationStartTime));
	    generateClipLink(citationStartTime, citationEndTime, videoUrl, videoId, host, citation, citationiframe);
	});
	timeEnd.click(function() {
	    citationEndTime = player.currentTime();
	    timeEnd.val(secondsToTime(citationEndTime));
	    generateClipLink(citationStartTime, citationEndTime, videoUrl, videoId, host, citation, citationiframe);
	});
};

// Diese Funktion wird genutzt, um die Url-Parameter auszulesen
function getUrlParameter(sParam) {
    const sPageURL = window.location.search.substring(1);
    const sURLVariables = sPageURL.split('&');
    for (let i = 0; i < sURLVariables.length; i++) {
        const sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) {
            return sParameterName[1];
        }
    }
};

function generateClipLink(firstFrame, lastFrame, videoUrl, videoId, host, citation, citationiframe) {
   if (firstFrame != null && lastFrame != null) {
	    firstFrame = Math.round(firstFrame);
	    lastFrame = Math.round(lastFrame);
        citation.val(videoUrl+"/"+firstFrame+"/"+lastFrame);
        const iframe="<iframe src='"+host+"/TODO/?v="+videoId+"/"+firstFrame+"/"+lastFrame+"' frameborder='0' width='647' height='373' allowfullscreen></iframe>";
        citationiframe.val(iframe);
    }
};

function secondsToTime(secs) {
    var sec_num = parseInt(secs, 10);
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    return hours+':'+minutes+':'+seconds;
};

function timeToSeconds(timeStr) {
	var seconds = 0;
	var hh = timeStr.slice(0,2);
	var mm = timeStr.slice(3,5);
	var ss = timeStr.slice(6,8);
	seconds = parseInt(hh) * 3600;
	seconds = seconds + parseInt(mm) * 60;
	seconds = seconds + parseInt(ss);
	return seconds;
};