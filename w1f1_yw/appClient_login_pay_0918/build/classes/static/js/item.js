//var domain = "http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/Order0917";
var domain = "http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/Order0916";
//var domain = "http://localhost:8080/order";


/***** item : 공구 검색 / 리스트 출력 / 정렬 / 등록 / 삭제  *****************************/

var loginInfo = sessionStorage.getItem("loginInfo");
var loginMidx = document.getElementById("loginMidx");
var loginName = sessionStorage.getItem("loginName");
// var loginMidx = 1;


var recomItems = [];    	// 추천리스트 담아두는 배열
var items = [];				// 일반리스트 담아두는 배열
var sortRecomItems = []; 	// 추천리스트 평점순 정렬 담아두는 배열
var sortItems = []; 		// 일반리스트 평점순 정렬 담아두는 배열




$(document).ready(function(){
	var openPay;
	profile();  // 기능코드는 buyer.js에 작성
	allItemlist();  // 전체 공구리스트 출력
	

	/* ing 검색기능 */
	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
		  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	  });

	

	/* ing 나의 공구구매현황[구매자] - 평점등록  */
    /* 별 표시  */
    /* 1. Visualizing things on Hover - See next part for action on click */
    $('#stars li').mouseover(function(){
        var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on
    
        // Now highlight all the stars that's not after the current hovered star
        $(this).parent().children('li.star').each(function(e){
        if (e < onStar) {
            $(this).addClass('hover');
        }
        else {
            $(this).removeClass('hover');
        }
        });
        
    
    }).mouseout(function(){
        $(this).parent().children('li.star').each(function(e){
            $(this).removeClass('hover');
        });
    });
    


    /* ing 나의 공구구매현황[구매자] - 평점등록  */
    /* 별 표시 - 평점계산  */
    /* 2. Action to perform on click */
    $('#stars li').click(function(){

        var onStar = parseInt($(this).data('value'), 10); // The star currently selected
        var stars = $(this).parent().children('li.star');

        for (i = 0; i < stars.length; i++) {
            $(stars[i]).removeClass('selected');
        }

        for (i = 0; i < onStar; i++) {
            $(stars[i]).addClass('selected');
        }

        // JUST RESPONSE (Not needed)
        var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
        alert('ratingValue : '+ratingValue);

        $(this).parent().eq(2).data('value',ratingValue);

    });
    
    /* 결제 시스템 함수 */
    $('#regSubmit').click(function test_reg () {
			var payInfo = document.getElementById('setPayInfo').value;
			alert((payInfo==""));	
			console.log(payInfo);
			console.log(typeof(payInfo));
		
			var checkRadio = $('input:radio[id=recommend]').is(':checked');
		
			if(checkRadio) {
				
				if(payInfo == ""){
				
					window.name = "regItemForm";
					openPay = window.open("kakaoPay", "successPay", "width=500, height=500, left=200, top=200");
					var paytest = document.getElementById('regForm');
					paytest.target = "kakaoPay";
					paytest.action = "kakaoPay";
					
					paytest.submit();
				
				} else if (payInfo != ""){
					alert('추천 게시글 등록');
					regSubmit();
				}
				
			}else {
				alert('일반 게시글 등록 체크중');
				regSubmit();
			}
			
			
		});
    

});  // ready end



// 검색 관련 ------------------------------------------------------------------

	/* 카테고리 정렬 */
	function filterSelection(c) {
		
		$(".item_card_big").css('display', 'none');
		$(".item_card").css('display', 'none');
		$('.'+c).css("display","inline-block");
	
	};  // filterSelection(c) end
	
	
	
	$('.btn_search_category').click(function(){
	
		$('.btn_search_category').removeClass("active");
		$(this).addClass("active");
	
	});





// 리스트 관련 ------------------------------------------------------------------

	/* 모든 공구글 리스트 */
	function allItemlist(){
		recomItemlist();
		itemlist();
	};

	/* 추천 공구 리스트 */
	function recomItemlist(){

		$('.sort_reg').css('background-color', 'teal');
		$('.sort_rvs').css('background-color', 'aquamarine');
		
		$.ajax({
			url: domain+'/items/recomItem',
			type: 'GET',
			success: function(data){

				// 배열 새로 비우고 담아야한다.. 안그러면 정렬하고 돌아오면 배열요소 추가로 담겨 평점정렬할 때 요소 2배로 나온다..
				recomItems=[];
				
				// 추천 공구 리스트 ㅡ> 배열에 담기
				for (i in data) {
					recomItems.push(data[i]);
				}

				// recomItems = JSON.stringify(data);
				// alert('recomItems : '+recomItems);

				
				recomItemlist_print(data);

			} // success end

		});


	}; // recomItemlist()  end



	/* 일반 공구 리스트 */
	function itemlist(){

		$('.sort_reg').css('background-color', 'teal');
		$('.sort_rvs').css('background-color', 'aquamarine');
		
		$.ajax({
			url: domain+'/items',
			type: 'GET',
			success: function(data){

				// 배열 새로 비우고 담아야한다.. 안그러면 정렬하고 돌아오면 배열요소 추가로 담겨 평점정렬할 때 요소 2배로 나온다..
				items=[]; 

				// 일반 공구 리스트 ㅡ> 배열에 담기
				for (i in data) {
					items.push(data[i]);
				}
				
				// items = JSON.stringify(data);
				// alert('items : '+items);
				
				itemlist_print(data);

			} // success end

		});

	}; // itemlist() end



	/* 추천공구글 출력기능 */
	function recomItemlist_print(data){

		var html = '';
		var category = '';
				
		// 출력되어있는 추천 공구리스트 지우고 ㅡ> 다시 출력
		$('.swiper-container').html(' ');

		$('#itemlist_area').css('display','block');
		$('#itemRegForm_area').css('display','none');
		$('#itemView_area').css('display','none');


			html += '<ul class="swiper-wrapper ag-slide_list">';
		

		for(var i=0; i<data.length; i++){

			switch(data[i].category){
				case 0: 
					category = '';
					break;
				
				case 1: 
					category = '과일/채소';
					break;

				case 2: 
					category = '육류/해산물';
					break;

				case 3:
					category = '생필품/기타';
					break;
			}
			
			html += '	<li class="swiper-slide ag-slide_item" data-swiper-autoplay="1500" data-swiper-slide-index="'+i+'">';
			html += '		<button type="button"  class="item_card_big category'+data[i].category+'" onclick="itemView('+data[i].iidx+','+loginMidx+')">';
			html += '			<img src="/order/upload/'+data[i].photo+'" class="ag-slide_img" alt="">';
			
			html += '			<div class="ag-slide_info clearfix">';
			
			html += '				<div class="ag-slide-info_descr">';
			html += '					<small class="ag-slide-info_category">'+category+'</small>';
			html += '					<h6 class="ag-slide-info_title"><b>'+data[i].iidx+': '+data[i].title+'</b></h6>';
			html += '					<h5 class="ag-slide-info_title">price : '+data[i].price+'</h6>';
			html += '					<h5 class="ag-slide-info_title">D-day : '+data[i].receive+'</h6>';
			html += '					<h5 class="ag-slide-info_title">location : '+data[i].location+'</h6>';
			html += '					<span class="ag-slide-info_route">';
			html += '						<span class="seller_name">'+data[i].midx+'.'+data[i].name+' | 평균 ★ '+data[i].rvs_avg+'(총 '+data[i].rvs_totalRow+'건)</span><br>';
			html += '					</span>';
			html += '				</div>';
			
			html += '				<div class="ag-slide-info_rate">';
			html += '					<b class="ag-slide-info_strong">'+data[i].view_count+'</b>';
			html += '					<span class="ag-slide-info_comments">view</span>';
			html += '				</div>';
			
			html += '			</div>';

			html += '		</button>';
			html += '	</li>';
			

		} // for end
		
			html += '</ul>';
			

			// 표시되는 위치
			$('.swiper-container').html(html);



			//★ swiper 기능을 이 안에 두니까 에러가 해결되었다 ㅠㅠㅠㅠㅠ
			(function ($) {
				$(function () {
			
				var agSwiper = $('.swiper-container');
			
				if (agSwiper.length > 0) {
			
				var sliderView = 3;
				var ww = $(window).width();
				if (ww >= 1700) sliderView = 3;
				if (ww <= 1700) sliderView = 3;
				if (ww <= 1560) sliderView = 3;
				if (ww <= 1400) sliderView = 3;
				if (ww <= 1060) sliderView = 3;
				if (ww <= 800) sliderView = 3;
				if (ww <= 560) sliderView = 3;
				if (ww <= 400) sliderView = 1;
			
				var swiper = new Swiper('.swiper-container', {
					slidesPerView: sliderView,
					spaceBetween: 100,
					loop: true,
					loopedSlides: 10,
					speed: 450,
					autoplay: true,
					autoplayDisableOnInteraction: true,
					centeredSlides: true
				});
			
				$(window).resize(function () {
					var ww = $(window).width();
					if (ww >= 1700) swiper.params.slidesPerView = 3;
					if (ww <= 1700) swiper.params.slidesPerView = 3;
					if (ww <= 1560) swiper.params.slidesPerView = 3;
					if (ww <= 1400) swiper.params.slidesPerView = 3;
					if (ww <= 1060) swiper.params.slidesPerView = 3;
					if (ww <= 800) swiper.params.slidesPerView = 3;
					if (ww <= 560) swiper.params.slidesPerView = 2;
					if (ww <= 400) swiper.params.slidesPerView = 1;
				});
			
				$(window).trigger('resize');
			
				var mySwiper = document.querySelector('.swiper-container').swiper;
			
				agSwiper.mouseenter(function () {
					mySwiper.autoplay.stop();
					console.log('slider stopped');
				});
			
				agSwiper.mouseleave(function () {
					mySwiper.autoplay.start();
					console.log('slider started again');
				});
				}
			
				});
			})(jQuery);
		


	}; // recomItemlist_print(data) end




	/* 일반공구글 출력기능 */
	function itemlist_print(data){


		var html = '';
		var category = '';

		// 출력되어있는 일반 공구리스트 지우고 ㅡ> 다시 출력
		$('#itemlist_small_area').html(' ');
		
		$('#itemlist_area').css('display','block');
		$('#itemRegForm_area').css('display','none');
		$('#itemView_area').css('display','none');
		
		html += '<div class="itemlist_buttons">';


		for(var i=0; i<data.length; i++){

			switch(data[i].category){
				case 0: 
					category = '';
					break;
				
				case 1: 
					category = '과일/채소';
					break;

				case 2: 
					category = '육류/해산물';
					break;

				case 3:
					category = '생필품/기타';
					break;
			}


			
			html += '	<button type="button" class="item_card category'+data[i].category+'" onclick="itemView('+data[i].iidx+','+loginMidx+')">';
			//html += '		<input type="hidden" value="'+data[i].iidx+'">';
			html += '		<img class="item_img" src="/order/upload/'+data[i].photo+'">';
			html += '		<div class="item_info">';
			//html += '				<h2 class="item_category">'+category+'</h2>';
			html += '				<h2 ><b class="item_title">'+data[i].iidx+': '+data[i].title+'</b></h2>';
			//html += '				<h4 class="seller_rating">view '+data[i].view_count+'</h4>';
			html += '				<h3 class="item_price">price : '+data[i].price+'</h4> ';
			html += '				<h3 class="item_limitDate">D-day : '+data[i].receive+'</h4>';
			html += '				<h3 class="item_location">location : '+data[i].location+'</h4>';
			html += '				<h3 class="seller_name">'+data[i].midx+'.'+data[i].name+' | 평균 ★ '+data[i].rvs_avg+'(총 '+data[i].rvs_totalRow+'건)</h4>';
			html += '		</div>';
			html += '	</button>';
			
			
		} // for end
			
			html += '</div>';
			

			// 표시되는 위치
			$("#itemlist_small_area").html(html);

	}; // itemlist_print(data) end





	/* 평점순 클릭시 ㅡ> 평점순 정렬 후 리스트 출력  */
	function allItemlist_sortRvs(){

		// 버튼 색상변경
		$('.sort_rvs').css('background-color', 'teal');
		$('.sort_reg').css('background-color', 'aquamarine');

		// 평점순 정렬기능 호출 ㅡ> 공구 리스트 다시 출력
		sortRvs(recomItems);
		recomItemlist_print(recomItems);

		sortRvs(items);
		itemlist_print(items);

	};



	/* 평점순 정렬기능 */
	function sortRvs(arr){
		arr.sort(function (a, b) { 
			return b.rvs_avg - a.rvs_avg;  
		});
	};






// 공구등록.수정.삭제 관련 (수정은 ing) ------------------------------------------------------------------

	/* 공구등록 폼  */
	/* function regItemForm(){

		$('#regItemForm_page').html('  ');
		$('#itemlist_area').css('display','none');
		$('#itemView_area').css('display','none');
		$('#itemRegForm_area').css('display','block');

		var html='';

		html +='<form id="regItemForm" onsubmit="return false;" >';
		html +='	<label for="title">제목</label>';
		html +='	<input type="text"  id="title" name=title required>';
		html +='	<label for="price">가격</label> ';
		html +='	<input type="number"  id="price" name="price" required>원';
		html +='	<label for="count_m">모집인원</label>  ';
		html +='	<input type="number" id="count_m" name="count_m" required>명';
		html +='	<label for="receive">물품수령일시</label>';
		html +='	<input type="datetime-local"  id="receive" name="receive" required>';
		html +='	<label for="addr">판매처</label>';
		html +='	<input type="text" id="addr" name="addr">';
		html +='	<label for="location">좌표</label>';
		html +='	<input type="text" id="location" name="location">';
		html +='	<label for="content">본문</label> ';
		html +='	<textarea id="content"  name="content" rows="10" cols="30"></textarea>';
		html +='	<label for="photo">첨부사진</label>';
		html +='	<input type="file" id="photo" name="photo">';
		html +='	<label for="category">카테고리</label> ';
		html +='		<select id="category" name="category">';
		html +='			<option value="0" selected>전체</option>';
		html +='			<option value="1">1.과일/채소</option>';
		html +='			<option value="2">2.육류/해산물</option>';
		html +='			<option value="3">3.생필품/기타</option>';
		html +='		</select>';
		html +='	<input type="radio" name="state" class="state" value="0" checked>일반공구로 등록하기';
		html +='	<input type="radio" name="state" class="state" value="1">추천공구로 등록하기';
		html +='	<label for="regItem_midx">작성자</label>';
		html +='	<input type="text" value="2" id="midx" name="midx" disabled>';
		html +='	<input type="submit" value="공구등록" onclick="regSubmit();">';
		html +='</form>';
	

		$('#regItemForm_page').html(html);

	};   // regItemForm end */




	/* 공구등록 */
	/* function regSubmit(){

		var regFormData = new FormData();

		regFormData.append('title', $('#title').val());
		regFormData.append('price', $('#price').val());
		regFormData.append('count_m', $('#count_m').val());
		regFormData.append('count_w', $('#count_m').val()*2);
		regFormData.append('receive', moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
		regFormData.append('addr', $('#addr').val());
		regFormData.append('location', $('#location').val());
		regFormData.append('content', $('#content').val());

		// 파일 첨부
		if($('#photo')[0].files[0] != null){
		regFormData.append('photo', $('#photo')[0].files[0]);
		}

		regFormData.append('state', $('input[name="state"]:checked').val());
		regFormData.append('viewCount', 0);
		regFormData.append('category', $('#category').val());
		regFormData.append('midx', $('#midx').val());	

		//alert("regFormData.title"+regFormData.title); 

		$.ajax({
			url : domain+'/items',
			type : 'POST',
			processData: false, // File 전송시 필수
			contentType: false, // multipart/form-data
			data : regFormData,
			success : function(iidx){
				alert("공구등록완료");
				alert("등록한 공구 iidx : " + iidx); 
				document.getElementById('regItemForm').reset();
				
				itemView(iidx);
				

			},

			Error: function(error){
				alert('공구등록 실패');
				allItemlist();
			}
			
		});
			
			
	}; */



	/* 공구글 상세보기 */
	function itemView(iidx) {
		

		$.ajax({
			url: domain+'/items/'+iidx,
			type: 'GET',
			success: function(data){

				$('#itemView_context').html(' ');
				$('#itemlist_area').css('display','none');
				$('#itemRegForm_area').css('display','none');
				$('#itemView_area').css('display','block');
				
				var html = '';
					
				html += '<div class="w3-container" class="ItemView" style="margin-top:65px;" >';
				html += '	<h2 class="w3-xlarge text-purple"><b>Item View</b></h2>';
				html += '	<hr style="width:50px;border:5px solid purple;"  class="w3-round">';
				html += '</div>';
				html += '<div class="itemView_table">';
				html += '	<table border="1">';
				html += '		<tr><td>iidx</td><td>'+data.iidx+'</td></tr>';
				html += '		<tr><td>제목</td><td>'+data.title+'</td></tr>';
				html += '		<tr><td>작성자</td><td>'+data.midx+'</td></tr>';
				html += '		<tr><td>작성자 평균평점</td><td>'+data.rvs_avg+'</td></tr>';
				html += '		<tr><td>작성자 총평점수</td><td>'+data.rvs_totalRow+'</td></tr>';
				html += '		<tr><td>조회수</td><td>'+data.view_count+'</td></tr>';
				html += '		<tr><td>첨부사진</td><td><img class="item_img" src="/order/upload/'+data.photo+'"></td></tr>';
				html += '		<tr><td>카테고리</td><td>'+data.category+'</td></tr>';
				html += '		<tr><td>가격</td><td>'+data.price+'</td></tr>';
				html += '		<tr><td>모집정원</td><td>'+data.count_m+'</td></tr>';
				html += '		<tr><td>대기정원</td><td>'+data.count_m*2+'</td></tr>';
				html += '		<tr><td>물품수령일시</td><td>'+data.receive+'</td></tr>';
				html += '		<tr><td>판매처</td><td>'+data.addr+'</td></tr>';
				html += '		<tr><td>좌표</td><td>'+data.location+'</td></tr>';
				html += '		<tr><td>본문</td><td>'+data.content+'</td></tr>';
				html += '		<tr><td clospan="2">';
				html += '			<input type="button" class="btn_itmelist" value="목록으로" onclick="allItemlist()">'; 

				// 만약에 로그인한 사람이 작성자가 아니면, 참여신청버튼 활성화
				if(loginMidx != data.midx){
					html += '			<input type="button" class="btn_join" value="참여신청" onclick="regOrder('+loginMidx+','+data.iidx+')">';
				}

				// 만약에 로그인한 사람이 작성자와 같으면, 글수정. 글삭제 활성화
				if(loginMidx == data.midx){
					html += '			<input type="button" class="btn_itmelist" value="글수정" onclick="editItem('+data.iidx+')">'; 
					html += '			<input type="button" class="btn_itmelist" value="글삭제" onclick="delItem('+data.iidx+')">'; 
				}
				html += '		</td></tr>'; 
				html += '	</table>';
				html += '</div>';
				
				$('#itemView_context').html(html);
				
				// 해당글의 댓글 리스트 호출 및 출력
				getComment(iidx);

				// 댓글등록 폼 출력
				regCommentForm(iidx);

				
			}


		});

	} //itemView() end

	
	/* 공구 삭제 */
	function delItem(iidx){

		if(confirm("정말 삭제하시겠습니까?")){
			$.ajax({
				url: domain+'/items/'+iidx,
				type: 'DELETE',
				success: function(data){
					alert('공구삭제 성공');
					alert(data);
					allItemlist();
					myitem(midx);
					
				}

			});
		};
			
	};
	
	/* 가람이 Js 추가 (공구 등록 form) */
	
		// 1000 단위 쉼표입력 함수
	 function commaSeparateNumber(val){
	  while (/(\d+)(\d{3})/.test(val.toString())){
	    val = val.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
	  }
	  return val;
	}
	$('#price').focusout(function(){
	  $(this).val(commaSeparateNumber($(this).val()));
	});
	
	// 공구 등록 form 활성화 함수
	function openRegForm(){
	      document.getElementById('regArea').style.display='block';
	  }
	// 공구 등록 form 비활성화 함수
	function closeRegForm(){
	  document.getElementById('regArea').style.display='none';
	  document.getElementById('regForm').reset();
	}
	function reload(){
	  $('#food').load(location.href + " #food");
	}
	
	// 공구 등록 함수
	function regSubmit(){
	
	  var regFormData = new FormData();
	  regFormData.append('title', $('#title').val());
	  regFormData.append('price', parseInt($('#price').val().replace(/,/g, ""), 10));
	  regFormData.append('count_m', $('#count_m').val());
	  regFormData.append('count_w', $('#count_m').val()*2);
	  regFormData.append('receive', moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
	  regFormData.append('addr', $('#addr').val());
	  //regFormData.append('location', $('#location').val());
	  regFormData.append('location_y', $('#location_y').val());
	  regFormData.append('location_x', $('#location_x').val());
	  regFormData.append('content', $('#content').val());
	  // 파일 첨부
	  if($('#photo')[0].files[0] != null){
	    regFormData.append('photo', $('#photo')[0].files[0]);
	  }
	  regFormData.append('state', $('input[name=state]:checked').val());
	  regFormData.append('view_count', 0);
	  regFormData.append('category', $('#category').val());
	  regFormData.append('midx', $('#midx').val());
	  
	  $.ajax({
	    url : domain+'/items',
	    type : 'POST',
	    processData : false,
	    contentType : false,
	    data : regFormData,
	    success : function(data){
	      swal({
	        text: "등록되었습니다",
	        icon: "success",
	        button: "확인"
	      });
	
	      closeRegForm();
	      reload();
	      getItemListView();
	    },  // success end
	    error : function(data){
	      console.log(data);
	
	      swal({
	        title: "무언가 잘못된것 같네요",
	        text: "확인 후 다시 시도해주세요.",
	        icon: "warning",
	        button: "확인"
	      });
	    } // error end
	  })  // ajax end
	};  // regSubmit function end 
	
// 상세보기에서 지도 출력관련 : 마커 이미지 변경필요  ------------------------------------------------------------------	




