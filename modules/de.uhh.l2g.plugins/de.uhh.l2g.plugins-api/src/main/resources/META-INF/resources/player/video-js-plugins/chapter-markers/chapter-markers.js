const Plugin = videojs.getPlugin('plugin');

class ChapterMarkersPlugin extends Plugin {

    constructor(player, options) {
        super(player, options);

        const cues = [];

        player.on('loadedmetadata', function() {
            Array.prototype
                .filter.call(player.textTracks(), track => track.kind === 'chapters')
                .forEach(chapterTrack =>
                    Array.prototype.forEach.call(chapterTrack.cues, cue => cues.push(cue))
                );

            addMarkers(cues, player.duration());
        });

        function addMarkers(cues, videoDuration) {
            const progressBar = document.getElementsByClassName('vjs-progress-holder')[0];
            cues.forEach(cue => {
                const markerDiv = document.createElement('div');
                markerDiv.classList.add('vjs-marker', 'bg-primary-color');
                markerDiv.id = 'cuepoint' + cue.startTime;
                markerDiv.style.left = (cue.startTime / videoDuration) * 100 + '%';
                markerDiv.addEventListener('click', () => player.currentTime(Math.floor(cue.startTime)))
                progressBar.appendChild(markerDiv);
                const tooltip = document.createElement('span');
                tooltip.className = 'tooltip';
                tooltip.innerHTML = cue.text;
                markerDiv.append(tooltip);
            })
        }
    }
}
