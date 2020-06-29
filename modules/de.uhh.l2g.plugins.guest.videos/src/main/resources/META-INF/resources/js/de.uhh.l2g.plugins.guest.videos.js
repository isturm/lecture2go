
$( function() {	
	//hide all video sublists on load
	$('ul[id^="p"]').hide();

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

	// only show 4 creators at first
	const maxCreators = 4;
	const loadMoreCreatorsLink = $('.load-more-creators');
	const loadMoreTagsLink = $('.load-more-tags');
	toggleCreatorsForCharacter('*');
	toggleTagsForCharacter('*');

	function toggleCreatorsForCharacter(character) {
		let hiddenCreators;

		if (character === '*') {
			$('div.creators').show();
			$('div.creators > ul > li').slice(maxCreators).hide();
			hiddenCreators = $('div.creators > ul > li:hidden');
		} else {
			$('div.creators').hide();
			$('div.creators[data-character="' + character + '"]').show();
			const creators = $('div.creators[data-character="' + character + '"] > ul > li');
			creators.slice(0, maxCreators).show();
			creators.slice(maxCreators).hide();
			hiddenCreators = $('div.creators[data-character="' + character + '"] > ul > li:hidden');
		}

		loadMoreCreatorsLink.hide();
		if (hiddenCreators.length > maxCreators) {
			$('.load-more-creators[data-character="' + character + '"]').show();
		}
	}

	function toggleTagsForCharacter(character) {
		let hiddenTags;

		if (character === '*') {
			$('div.tags').show();
			$('div.tags > ul > li').slice(maxCreators).hide();
			hiddenTags = $('div.tags > ul > li:hidden');
		} else {
			$('div.tags').hide();
			$('div.tags[data-character="' + character + '"]').show();
			const tags = $('div.tags[data-character="' + character + '"] > ul > li');
			tags.slice(0, maxCreators).show();
			tags.slice(maxCreators).hide();
			hiddenTags = $('div.tags[data-character="' + character + '"] > ul > li:hidden');
		}

		loadMoreTagsLink.hide();
		if (hiddenTags.length > maxCreators) {
			$('.load-more-tags[data-character="' + character + '"]').show();
		}
	}

	// show the remaining creators in batches of 50
	function expandCreators(character) {
		if (character === '*') {
			const hiddenCreators = $('div.creators > ul > li:hidden');
			if (hiddenCreators.length <= 50) {
				hiddenCreators.show();
				loadMoreCreatorsLink.hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenCreators.eq(i).show();
				}
			}
		} else {
			const hiddenCreators = $('div.creators[data-character="' + character + '"] > ul > li:hidden');
			if (hiddenCreators.length <= 50) {
				hiddenCreators.show();
				$('.load-more-creators[data-character="' + character + '"]').hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenCreators.eq(i).show();
				}
			}
		}
	}

	// show the remaining tags in batches of 50
	function expandTags(character) {
		if (character === '*') {
			const hiddenTags = $('div.tags > ul > li:hidden');
			if (hiddenTags.length <= 50) {
				hiddenTags.show();
				loadMoreTagsLink.hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenTags.eq(i).show();
				}
			}
		} else {
			const hiddenTags = $('div.tags[data-character="' + character + '"] > ul > li:hidden');
			if (hiddenTags.length <= 50) {
				hiddenTags.show();
				$('.load-more-tags[data-character="' + character + '"]').hide();
			} else {
				for (let i=0; i<50; i++) {
					hiddenTags.eq(i).show();
				}
			}
		}
	}

	loadMoreCreatorsLink.click(function (event) {
		expandCreators(event.target.dataset.character);
	});

	loadMoreTagsLink.click(function (event) {
		expandTags(event.target.dataset.character);
	});

	$('.select-creator-character').click(function(event) {
		const target = event.target;
		$('a.select-creator-character.selected').removeClass('selected');
		target.classList.add('selected');
		toggleCreatorsForCharacter(target.dataset.character);
	});

	$('.select-tag-character').click(function(event) {
		const target = event.target;
		$('a.select-tag-character.selected').removeClass('selected');
		target.classList.add('selected');
		toggleTagsForCharacter(target.dataset.character);
	});
});
