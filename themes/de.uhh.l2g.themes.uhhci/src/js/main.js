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
    $('#searchCollapse').removeClass('show');
});

$("#search").click(function(){
    $('#search').toggleClass('closeSearch');
    $('#menu').removeClass('closeMenu');
    $('#navigationCollapse').removeClass('show');
    $('#menuCover').removeClass('show');
});

$("body").click(function(event){
	if(event.target.id == "menu" || event.target.id == "search")
		return;
	if($(event.target).closest('#menu').length > 0 || $(event.target).closest('#search').length > 0 || $(event.target).closest('#searchCollapse').length > 0)
		return;
	$('#search').removeClass('closeSearch');
    $('#menu').removeClass('closeMenu');
    $('#navigationCollapse').removeClass('show');
    $('#searchCollapse').removeClass('show');
    $('#menuCover').removeClass('show');
});

window.onscroll = function() {stickDesktopNavbar()};
var desktopNavbar = document.getElementById("navigationDesktop");
var stickyDesktopNavbar = desktopNavbar.offsetTop;
function stickDesktopNavbar() {
  if (window.pageYOffset >= stickyDesktopNavbar) {
	  desktopNavbar.classList.add("sticky")
  } else {
	  desktopNavbar.classList.remove("sticky");
  }
} 
