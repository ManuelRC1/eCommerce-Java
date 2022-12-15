
/*=============================Buscador=====================================*/

$(document).ready(function() {
    $('#close-btn').click(function() {
        $('#search-overlay').fadeOut();
        $('#search-btn').show();
    });
    $('#search-btn').click(function() {
        $(this).hide();
        $('#search-overlay').fadeIn();
    });
});






document.querySelector('.menu-btn').addEventListener('click', () => document.querySelector('.main-menu').classList.toggle('show'));
