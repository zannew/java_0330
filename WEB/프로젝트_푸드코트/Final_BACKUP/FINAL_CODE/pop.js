$(document).ready(function() {

   $('.trigger').click(function() {
      $('.overlay').fadeIn(300);
   });


   $('.trigger2').click(function() {
      $('.overlay2').fadeIn(300);
      $('#overlay2').fadeIn(300);
   });

   $('.trigger3').click(function() {
      $('.overlay3').fadeIn(300);

      sessionStorage.clear();
      localStorage.clear();
      // 대기번호 추가 - 장윤원
      var mathRandom = Math.random();
      var randNum= document.getElementById("msg_waitingNum");
          randNum.innerText = '대기번호 : '+Math.floor( mathRandom * 1000 + 1 );


   });


   $('.close').click(function() { // 처음으로 
      // $('#overlay').fadeOut(300);
      $('#wrap_kiosk').removeClass('modal-open');
      $('.overlay').fadeOut(300);
      $('.container').removeClass('modal-open');

      sessionStorage.clear();

      setTimeout(function(){
         location.reload()
      },400);
   });


   $('#side_cancle').click(function(){ // 사이드에서 취소

      $('.overlay').fadeOut(300);
   });


   $('.cancle2').click(function(){ //결제하기

      $('.overlay2').fadeOut(300);
      $('#overlay2').fadeOut(300);
   });


   

   // $('.close').click(function() {
   //    $('.overlay2').fadeOut(300);
   // });


   
   // if($('div.wrap02').style.display='block'){
   //    setTimeout(function(){
   //       $('.overlay3').fadeOut(100);
   //       $('.overlay2').fadeOut(100);
   //       $('.overlay').fadeOut(100);
   //    },5000);
   // }

   $('.menu_btn').click(function(){

      var img = $(this).find('img').attr('src');
      // alert(img);

      $('#select_menu_img>img').attr('src', img);

      var name = $(this).find('h3').text();
      $('#menu_info>h2').text(name);

      var price = $(this).find('p').text();
      $('.select_menu_price').text(price);

      /* 가람: 사이드 메뉴 변경 로직 */
      var type = $(this).attr('data-value');
      $('.side_menu_div').attr('style', 'display: none');
      $("."+type).attr('style', 'display: block');
      $('#side_menu_div').html($(type).html())
   });






   //  (팝업-사이드창) 
   // 사이드메뉴 선택시 속성추가
   $('.side_menu_btn').click(function() {
      if($(this).hasClass('select_border')){  
         $(this).filter('img').removeClass('select_border');
         /* $(this).removeClass('select_border'); */
         console.log(true);
      }else{
         $(this).filter('img').addClass('select_border');
         /* $(this).addClass('select_border'); */
         console.log(false);
         
      }


   });



   //  (팝업-사이드창) 
   // 사이드메뉴 선택 후 ㅡ> 확인버튼 클릭시 ㅡ> 속성삭제
   $('#side_ok').click(function() {
      $('.side_menu_btn').removeClass('select_border');
      $('.overlay').fadeOut(300);
   });







   var menu = {};

   // 사이드창 선택사항 - 객체로
   $('.menu_btn').click(function(){
      
      
      var name = $(this).find('h3').text();
      var price = $(this).find('p').text();


      menu = {
         sname:name,
         sprice:price,
      }

     

      

   });



   var sidemenu = {};
   var sidemenuArr = [];

   // 사이드메뉴 선택. (여러개 선택시?)
   $('.side_menu_btn').click(function(){

      var amount = $('#select_count').find('input').val();

      // 만약에, 선택되어있다면, 
      if($(this).hasClass('select_border')){
      
         var sidename = $(this).find('h3').text();

         var sideprice = $(this).find('p').text();
         var price1 = sideprice.replace(',','');
         sideprice = parseInt(price1);

      } else {
         sidename=0;
         sideprice=0;
      } 

      sidemenu = {
         samount:amount,
         side_name:sidename,
         side_price:sideprice
      }

      sidemenuArr.push(sidemenu);
      
      menu.side=sidemenuArr;
      // alert(menu.sname);
      // alert(menu.side[1].side_name);


      
   });
   
   var order = $('#side_ok').click(function(){
      return menu;
   });

      //  테이크아웃 id #take_btn
 
   // $('#hall_btn').click(function(){
   //    alert('test')
   //    $('.togo').css('background-color',red);
   // });


   $('button.togo').click(function(){
      
      $(this).css({
         'background-color': 'orange',
         'border' : '1px solid orange'
      });

      $('button.hall').css({
         'background-color': 'dimgray',
         'border' : '1px solid dimgray'
      
      });

   });

   $('button.hall').click(function(){
      
      $(this).css({
         'background-color': 'orange',
         'border' : '1px solid orange'
      });

      $('button.togo').css({
         'background-color': 'dimgray',
         'border' : '1px solid dimgray'
      
      });

   });



   $('#hall_btn').click(function(){

      $('#hall_btn').css({
         'border' : '15px solid orange'
      });

      $('button.hall').css({
         'background-color': 'orange',
         'border' : '1px solid orange'
      });

      $('button.togo').css({
         'background-color': 'dimgray',
         'border' : '1px solid dimgray'
      
      });
   });

   $('#take_btn').click(function(){

      $('#take_btn').css({
         'border' : '15px solid orange'
      });

      $('button.togo').css({
         'background-color': 'orange',
         'border' : '1px solid orange'
      });
      
      $('button.hall').css({
         'background-color': 'dimgray',
         'border' : '1px solid dimgray'
      
      });
   });


   $('#bfbtn').click(function(){

      $('#take_btn').css({
         'border' : '15px solid dimgray'
      });
      $('#hall_btn').css({
         'border' : '15px solid dimgray'
      });

   });


   $('.menu').click(function(){
      $('#take_btn').css({
         'border' : '15px solid dimgray'
      });
      $('#hall_btn').css({
         'border' : '15px solid dimgray'
      });

   });


   
   var dessertbtn = $('#dessertbtn');
   var asianbtn = $('#asianbtn');
   var westembtn = $('#westembtn');
   var chinabtn = $('#chinabtn');
   var japanbtn = $('#japanbtn');
   var koreabtn = $('#koreabtn');


   
   dessertbtn.click(function(){

   $(this).css({
      'border' : '3px solid orange'
   });
   asianbtn.css('border','');
   westembtn.css('border','');
   chinabtn.css('border','');
   japanbtn.css('border','');
   koreabtn.css('border','');
   });


   
   asianbtn.click(function(){

      $(this).css({
         'border' : '3px solid orange'
      });
      dessertbtn.css('border','');
      westembtn.css('border','');
      chinabtn.css('border','');
      japanbtn.css('border','');
      koreabtn.css('border','');
      });

   
      westembtn.click(function(){

         $(this).css({
            'border' : '3px solid orange'
         });
         asianbtn.css('border','');
         dessertbtn.css('border','');
         chinabtn.css('border','');
         japanbtn.css('border','');
         koreabtn.css('border','');
         });

         chinabtn.click(function(){

            $(this).css({
               'border' : '3px solid orange'
            });
            asianbtn.css('border','');
            westembtn.css('border','');
            dessertbtn.css('border','');
            japanbtn.css('border','');
            koreabtn.css('border','');
            });
         
      
            japanbtn.click(function(){

               $(this).css({
                  'border' : '3px solid orange'
               });
               asianbtn.css('border','');
               westembtn.css('border','');
               chinabtn.css('border','');
               dessertbtn.css('border','');
               koreabtn.css('border','');
               });
            

               koreabtn.click(function(){

                  $(this).css({
                     'border' : '3px solid orange'
                  });
                  asianbtn.css('border','');
                  westembtn.css('border','');
                  chinabtn.css('border','');
                  japanbtn.css('border','');
                  dessertbtn.css('border','');
                  });
               

            var kr= $('#koreafood');
            var jp= $('#japanfood');
            var cn= $('#chinafood');
            var wt= $('#westemfood');
            var as= $('#asianfood');
            var de= $('#dessertfood');

            kr.click(function(){
               koreabtn.css({
                  'border' : '3px solid orange'
               })
               koreabtn.trigger('click');
            });

            jp.click(function(){
               japanbtn.css({
                  'border' : '3px solid orange'
               });
               japanbtn.trigger('click');

            });

            cn.click(function(){
               chinabtn.css({
                  'border' : '3px solid orange'
               })
               chinabtn.trigger('click');
            });
            wt.click(function(){
               westembtn.css({
                  'border' : '3px solid orange'
               })
               westembtn.trigger('click');
            });
            as.click(function(){
               asianbtn.css({
                  'border' : '3px solid orange'
               })
               asianbtn.trigger('click');
            });
            de.click(function(){
               dessertbtn.css({
                  'border' : '3px solid orange'
               })
               dessertbtn.trigger('click');
            });
               






   });

