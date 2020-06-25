// 클릭말고 일정시간 후에 팝업창 올라오게 구현

$('.js-click-modal').click(function(){
    $('.container').addClass('modal-open');
  });
  
  $('.js-close-modal').click(function(){
    $('.container').removeClass('modal-open');
  });