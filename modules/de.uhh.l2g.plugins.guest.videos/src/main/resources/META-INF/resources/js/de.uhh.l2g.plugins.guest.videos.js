
$( function() {	
	//hide video sublist if lecture series was found
	$('ul.hideOnLoad').hide();

	//toggle functionality for video sublist 
	$('div[id^="vt"]').click(function() {
		var pId = "p"+this.id.substring(2);
		var bId = "b"+this.id.substring(2);
		$("#"+pId).toggle("slow");
		$("#"+bId + " i").toggleClass("icon-chevron-down");
	});
	
	$('button[id^="b"]').click(function() {
		var pId = "p"+this.id.substring(1);
		var bId = "b"+this.id.substring(1);
		$("#"+pId).toggle("slow");
		$("#"+bId + " i").toggleClass("icon-chevron-down");
	});
	
	//turn off autocomplete
	$(document).on('focus', ':input', function() {
	    $(this).attr('autocomplete', 'off');
	});
	
	// only show the last terms
	var maxTerms = 4;
	$("ul.terms > li").slice(maxTerms).hide();

	// show the remaining terms
	$('#loadMoreTerms').click(function () {
	    $('ul.terms > li').show();
	    $('#loadMoreTerms').hide();
	});

	// only show 4 entries at first
	const maxEntries = 4;
	toggleEntriesForCharacter('*', 'creator');
	toggleEntriesForCharacter('*', 'tag');

	function toggleEntriesForCharacter(character, entity) {
		let hiddenEntries;

		if (character === '*') {
			$('div.alphabet-list[data-entity="' + entity + '"]').show();
			$('div.alphabet-list[data-entity="' + entity + '"] > ul > li').slice(maxEntries).hide();
			hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"] > ul > li:hidden');
		} else {
			$('div.alphabet-list[data-entity="' + entity + '"]').hide();
			$('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"]').show();
			const listEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li');
			listEntries.slice(0, maxEntries).show();
			listEntries.slice(maxEntries).hide();
			hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li:hidden');
		}

		$('a.load-more-link[data-entity="' + entity + '"]').hide();
		if (hiddenEntries.length > maxEntries) {
			$('.load-more-link[data-entity="' + entity + '"][data-character="' + character + '"]').show();
		}
	}

	// show the remaining list entries in batches of 50
	function expandEntries(character, entity) {
		let hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"] > ul > li:hidden');
		if (character === '*') {
			if (hiddenEntries.length <= 50) {
				hiddenEntries.show();
				$('.load-more-link[data-entity="' + entity + '"]').hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenEntries.eq(i).show();
				}
			}
		} else {
			hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li:hidden');
			if (hiddenEntries.length <= 50) {
				hiddenEntries.show();
				$('.load-more-link[data-character="' + character + '"][data-entity="' + entity + '"]').hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenEntries.eq(i).show();
				}
			}
		}
	}

	$('.load-more-link').click(function (event) {
		expandEntries(event.target.dataset.character, event.target.dataset.entity);
	});

	$('.select-character').click(function(event) {
		const target = event.target;
		$('a.select-character.selected[data-entity="' + target.dataset.entity + '"]').removeClass('selected');
		target.classList.add('selected');
		const character = target.dataset.character.toString();
		const entity = target.dataset.entity.toString();
		toggleEntriesForCharacter(character, entity);
	});
});
