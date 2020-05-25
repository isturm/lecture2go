// Diese Funktion benutzen wir später zum Formatieren von Zeitangaben
var secondsToTime = function(secs) {
    var sec_num = parseInt(secs, 10);
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    return hours+':'+minutes+':'+seconds;
};

var timeToSeconds = function (timeStr) {
	var seconds = 0;
	var hh = timeStr.slice(0,2);
	var mm = timeStr.slice(3,5);
	var ss = timeStr.slice(6,8);
	seconds = parseInt(hh) * 3600;
	seconds = seconds + parseInt(mm) * 60;
	seconds = seconds + parseInt(ss);
	return seconds;
};