jQuery(document).ready(function(){
    jQuery('#toTop').click(function(){
        jQuery('#navbar_menu').html("<div>dfsdfsdfds</div>");
    })
});


    $('#toTop').click(function() {
        $('body,html').animate({scrollTop:0},1800);
});