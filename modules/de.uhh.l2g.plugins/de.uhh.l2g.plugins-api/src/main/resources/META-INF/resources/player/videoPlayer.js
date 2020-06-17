function initVideoPlayer(player, videoUrls, poster, textTracks = null, is360Video = false) {
    player.fluid(true);
    player.controls(true);
    player.aspectRatio("16:9");
	player.src(videoUrls);
    player.poster(poster);
    if (textTracks != null) {
		addTextTracks(textTracks, player);
	}
    player.hlsQualitySelector();
    videojs.registerPlugin('chapterMarkersPlugin', ChapterMarkersPlugin);
    player.chromecast({preloadWebComponents: true});


	for (let pipButton of document.querySelectorAll('.vjs-picture-in-picture-control')) {
		pipButton.style.display = 'none';
	}

    if (is360Video) {
		player.vr({projection: '360'});
		for (let cardboardButton of document.querySelectorAll('.vjs-button-vr')) {
			cardboardButton.style.display = 'none';
		}
	}
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
    if(timeStart >= 0 && timeEnd > timeStart){
        player.offset({
            start: timeStart,
            end: timeEnd,
            restart_beginning: true
        });
    }
}

function enableSegmentation(player, timeStart, timeEnd, videoUrl, videoId, host, citation, citationiframe) {
	timeStart.click(function() {
		let segmentStartTime = player.currentTime();
	    timeStart.val(secondsToTime(segmentStartTime));
	    if(timeEnd.val() != "" && !isValidClipTime(timeStart, timeEnd)) {
	    	timeEnd.val(timeStart.val());
	    }
	    generateClipLink(segmentStartTime, timeToSeconds(timeEnd.val()), videoUrl, videoId, host, citation, citationiframe);
	});
	timeEnd.click(function() {
		let segmentEndTime = player.currentTime();
		timeEnd.val(secondsToTime(segmentEndTime));
	    if(timeStart.val() != "" && !isValidClipTime(timeStart, timeEnd)) {
	    	timeStart.val(timeEnd.val());
	    }
	    generateClipLink(timeToSeconds(timeStart.val()), segmentEndTime, videoUrl, videoId, host, citation, citationiframe);
	});
}

function isValidClipTime(timeStart, timeEnd) {
	if(timeStart.val() == "" || timeEnd.val() == "") {
		return false;
	} else {
		return timeToSeconds(timeStart.val()) < timeToSeconds(timeEnd.val());
	}
}

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
   if (firstFrame != null && lastFrame != null && citation != null && citationiframe != null) {
	    firstFrame = Math.round(firstFrame);
	    lastFrame = Math.round(lastFrame);
        citation.val(videoUrl+"/"+firstFrame+"/"+lastFrame);
        const iframe="<iframe src='"+host+"/iframe?v="+videoId+"/"+firstFrame+"/"+lastFrame+"' frameborder='0' width='647' height='373' allowfullscreen></iframe>";
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
	if(timeStr == "") {
		return null;
	}
	
	var seconds = 0;
	var hh = timeStr.slice(0,2);
	var mm = timeStr.slice(3,5);
	var ss = timeStr.slice(6,8);
	seconds = parseInt(hh) * 3600;
	seconds = seconds + parseInt(mm) * 60;
	seconds = seconds + parseInt(ss);
	return seconds;
};