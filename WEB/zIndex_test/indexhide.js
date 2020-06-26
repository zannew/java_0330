$('.js-click-modal').click(function(){
  $('.container').addClass('modal-open');
});

$('.js-close-modal').click(function(){
  $('.container').removeClass('modal-open');
});

$('.js-click-modal_korea').click(function(){

  $('#wrap_kiosk').addClass('modal-open');
});



$(document).ready(function(){

  $('#koreafood').click(function(){
    alert('asf');
  // if($('#menuTable_jap').css('display')=="inline"){
  //   $(this).hide();
  // }
  });
  
  
  
  
  
  
  
    $('#btn1').click(function(){
      var offset = $('#menuTable_jap').offset();
          $('html').animate({scrollTop : offset.top}, 0);
         
          if($('#menuTable_jap').css('display') == 'none'){
            $('#menuTable_jap').show();
        }else{
            $('#menuTable_jap').hide();
        }
  
    });
  
  });
  