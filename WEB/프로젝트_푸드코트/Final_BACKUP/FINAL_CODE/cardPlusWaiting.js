
window.onload = function () {

  // Get the button that opens the modal
  var wrap01 = document.getElementById('wrap01');
  var wrap02 = document.getElementById('wrap02');
  var wrap03 = document.getElementById('wrap03');
  var orderPop = document.getElementById('order_outside');
  var wrap_kiosk = document.getElementById('wrap_kiosk');
  var modalWrap = document.getElementById('modal');
  var overlay2 = document.getElementById('overlay2');
  var first = document.getElementById('first');
  var btn_payment = document.getElementById('credit');
  var btn_cancel = document.getElementById('cancel');
  var btn_pay = document.getElementById('payment');

  
  btn_pay.onclick = function(){
    orderPop.style.display = "block";

  }


  btn_cancel.onclick = function(){
    orderPop.style.display = "none";
    overlay2.style.display = "none";

  }

  
  btn_payment.onclick = function(){
    wrap01.style.display = "block";
    orderPop.style.display = "none";
    wrap_kiosk.style.display= "none";
    modalWrap.style.display= "none";
    overlay2.style.display = "none";

    $('#take_btn').css({
      'border' : '15px solid dimgray'
   });
   $('#hall_btn').css({
      'border' : '15px solid dimgray'
   });

    setTimeout(function () {
      wrap01.style.display = "none";
      wrap02.style.display = "block";
      
    }, 1000*5);
    
    setTimeout(function(){
      wrap02.style.display="none";
      wrap03.style.display = "none";
      location.reload();
      //첫화면
      first.style.display="block";
      first.setAttribute('class','container');
      
    }, 1000*10);


  }

 

}
