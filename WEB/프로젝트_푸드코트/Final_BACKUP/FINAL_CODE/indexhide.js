$(document).ready(function(){


$('.js-click-modal').click(function(){
  $('.container').addClass('modal-open');
  $('#modal').css('display','block');
});

$('.js-close-modal').click(function(){
  $('.container').removeClass('modal-open');
});

$('.js-click-modal_korea').click(function(){
  $('#wrap_kiosk').addClass('modal-open');
  $('#wrap_kiosk').css('display','block');
  $('#order_outside').css('display','block');

});




    $('.menuOpt > a').on('click', function(){
    
        var GetaName = $(this).attr('href').split('#');
        $('html,body').animate({scrollTop : $('a[name ='+GetaName[1]+']').offset().top},10000);
       
    });
});



  
  