AUI().ready(
	'liferay-sign-in-modal',
	function(A) {
		var signIn = A.one('.sign-in > a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);

$("#menu").click(function(){
    $('#menu').toggleClass('closeMenu');
    $('#search').removeClass('closeSearch');
    $('.searchCollapse').removeClass('show');
});

$("#search").click(function(){
    $('#search').toggleClass('closeSearch');
    $('#menu').removeClass('closeMenu');
    $('#navigationCollapse').removeClass('show');
    $('#menuCover').removeClass('show');
});

$("#desktopSearch").click(function(){
    $('#desktopSearch').toggleClass('closeSearch');
});

$("body").click(function(event){
	if(event.target.id == "menu" || event.target.id == "search" || event.target.id == "desktopSearch")
		return;
	if($(event.target).closest('#menu').length > 0 || $(event.target).closest('#search').length > 0 || $(event.target).closest('#desktopSearch').length > 0 || $(event.target).closest('.searchCollapse').length > 0)
		return;
	$('#search').removeClass('closeSearch');
	$('#desktopSearch').removeClass('closeSearch');
    $('#menu').removeClass('closeMenu');
    $('#navigationCollapse').removeClass('show');
    $('.searchCollapse').removeClass('show');
    $('#menuCover').removeClass('show');
});

var desktopNavbar = document.getElementById("navigationDesktop");
if (desktopNavbar) {
    window.onscroll = function() {stickDesktopNavbar()};
    var stickyDesktopNavbar = desktopNavbar.offsetTop;
    function stickDesktopNavbar() {
        if (window.pageYOffset >= stickyDesktopNavbar) {
            desktopNavbar.classList.add("sticky");
            document.getElementById("desktopSearchCollapse").classList.add("sticky");
        } else {
            desktopNavbar.classList.remove("sticky");
            document.getElementById("desktopSearchCollapse").classList.remove("sticky");
        }
    }
}

