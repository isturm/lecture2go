const Plugin = videojs.getPlugin('plugin');

class ChapterMarkersPlugin extends Plugin {

    constructor(player, options) {
        super(player, options);

        const cues = [];

        player.on('loadedmetadata', function() {
            Array.from(player.textTracks()).filter(track => track.kind === 'chapters')
                .forEach(chapterTrack =>
                    Array.prototype.forEach.call(chapterTrack.cues, cue => cues.push(cue))
                );

            addMarkers(cues, player.duration());
        });

        function addMarkers(cues, videoDuration) {
            const progressBar = document.querySelector('.vjs-progress-holder');
            const progressBarWrapper = document.querySelector('.vjs-progress-control.vjs-control');
            cues.forEach(cue => {
                const markerDiv = document.createElement('div');
                markerDiv.className = 'vjs-marker';
                const markerPercentage = (cue.startTime / videoDuration) * 100;
                markerDiv.style.left = markerPercentage + '%';
                markerDiv.addEventListener('click', () => player.currentTime(Math.floor(cue.startTime)))
                progressBar.appendChild(markerDiv);

                const markerHitbox = document.createElement('div');
                markerHitbox.className = 'vjs-marker-hitbox';
                const marginOffset = 10 - markerPercentage * (20/100);
                markerHitbox.style.left = `calc(${markerPercentage}% + ${marginOffset}px)`;
                progressBarWrapper.appendChild(markerHitbox);

                const tooltip = document.createElement('span');
                tooltip.className = 'tooltip';
                tooltip.innerHTML = cue.text;
                markerHitbox.append(tooltip);

                addTimeTooltipEventListeners();
            })
        }

        function addTimeTooltipEventListeners() {
            Array.from(document.querySelectorAll('.vjs-marker-hitbox')).forEach(element => {
                element.addEventListener("mouseover", () => {
                    document.querySelector(".vjs-mouse-display .vjs-time-tooltip").style.display = 'none';
                })
                element.addEventListener("mouseout", () => {
                    document.querySelector(".vjs-mouse-display .vjs-time-tooltip").style.display = 'block';
                })
            });
        }
    }
}
