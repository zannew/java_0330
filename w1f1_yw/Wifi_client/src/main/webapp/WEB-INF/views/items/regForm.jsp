<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
<link rel="stylesheet" href="<c:url value="/resources/css/default.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/aside.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c35fdaa3a50bc0c680e435eb402d8491&libraries=services"></script>

</head>
<body>
<%@ include file="/WEB-INF/views/include/regBootstrap.jsp" %>
<%@ include file="/WEB-INF/views/include/aside.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
 
<h2> 공구글 작성 </h2>
 
<div class="container">
    <!-- <form action="/insertProc" method="post"> -->
    <form onsubmit="return false;">
      <div class="form-group">
        <label for="subject">제목</label>
       <!--  <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요."> -->
        <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요." required>
      </div>
      <div class="form-group">
        <label for="midx">작성자</label>
        <input type="text" class="form-control" id="midx" name="midx" value="${loginInfo.midx}">
      </div>
      <div class="form-group">
        <label for="price">가격</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="text" class="form-control" id="price" name="price" placeholder="가격을 입력하세요." required>
      </div>
      <div class="form-group">
        <label for="count_m">모집인원</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="text" class="form-control" id="count_m" name="count_m" min="0" placeholder="모집인원을 입력하세요.">
      </div>
      <div class="form-group">
        <label for="receive">수령날짜</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="datetime-local" class="form-control" id="receive" name="receive" style="cursor:pointer;" required >
      </div>
      <div class="form-group">
        <label for="addr">수령장소</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="text" class="form-control" id="addr" name="addr" placeholder="판매처 주소를 입력하세요.">
      </div>
      <div class="form-group">
        <input type="text" id="sample5_address" placeholder="주소">
	<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
	<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
      </div>
      <div class="form-group">
        <label for="location">수령위치</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="text" class="form-control" id="location" name="location">
      </div>
      <div class="form-group">
        <label for="photo">첨부사진</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
        <input type="file" class="form-control" id="photo" name="photo">
      </div>
      <div class="form-group">
        <label for="category">카테고리</label>
        <!-- <input type="text" class="form-control" id="writer" name="writer" value=${loginInfo.midx} placeholder="내용을 입력하세요."> -->
       <!--  <input type="text" class="form-control" id="category" name="category"> -->
		<select id="category" class="form-control">
						<option value="0">과일</option>
						<option value="1">육류</option>
						<option value="2">해산물</option>
						<option value="3">채소</option>
						<option value="4">생필품</option>
						<option value="5">음료</option>
						<option value="6">기타</option>
				</select>
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
      </div>
      <div class="form-group">
        <label for=state">추천공구</label>
        <!-- <input class="state" type="checkbox" name="state" id="basic" value="0">일반공구로 등록하기 -->
		<input class="state" type="checkbox" name="state" id="recommend" value="1">추천공구로 등록하기<br>
      </div>
     <!--  <input type="submit" value="공구올리기" class="btn btn-primary submit_btn" onclick="regSubmit();"> -->
      <input type="submit" value="공구올리기" class="submit_btn" onclick="regSubmit();">
     <!--  <input type="reset" value="초기화" class="btn btn-primary reset_btn"> -->
      <input type="reset" value="초기화" class="reset_btn">
      
    </form>
</div>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };
    
    // 좌표를 전역변수로 뺌
    var coords=null;
	var result=null;
	
    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        coords = new daum.maps.LatLng(result.y, result.x);
                        // 받은 좌표 확인
                        console.log('coords : '+coords);
                        
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }

//var mainUrl ="http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/items";
var mainUrl ="http://localhost:8080/order/items";

function regSubmit(){
	
		var regFormData = new FormData();
		regFormData.append('title', $('#title').val());
		regFormData.append('price', $('#price').val());
		regFormData.append('count_m', $('#count_m').val());
		regFormData.append('count_w', $('#count_m').val()*2);
		regFormData.append('receive', moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
		regFormData.append('addr', $('#addr').val());
		//regFormData.append('location', $('#location').val());
		regFormData.append('location_y', result.y);
		regFormData.append('location_x', result.x);
		regFormData.append('content', $('#content').val());
		// 파일 첨부
		if($('#photo')[0].files[0] != null){
			regFormData.append('photo', $('#photo')[0].files[0]);
		}
		if ($('input:checkbox[id="recommend"]').is(":checked") == true){
			regFormData.append('state', $('.state').val());
		}

		regFormData.append('view_count', 0);
		regFormData.append('category', $('#category').val());
		regFormData.append('midx', $('#midx').val());
		console.log('midx : '+$('#midx').val());
		console.log('title : '+$('#title').val());
		console.log('price : '+$('#price').val());
		console.log('count_m : '+$('#count_m').val());
		console.log('addr : '+$('#addr').val());
		console.log('content : '+$('#content').val());
		console.log('state : '+$('.state').val());
		
		$.ajax({
			
			url : mainUrl,
			type : 'POST',
			processData : false,
			contentType : false,
			data : regFormData,
			success : function(data){
				alert('공구등록완료');
				//getItemListView();
				location.href="/wifi/items/itemList";
				
			},
			error : function(data){
				console.log(data);
				alert('실패');
			}
		});
	}
		
	 function closeRegForm(){
		 document.getElementById('regForm').style.display='none';
	 }
		 
	function checkRecommendCount(){
		$.ajax({
			
			url : mainUrl,
			type: 'GET',
			data : {
				'istate': 1
			},
			success : function(data){
				if(data < 10){
					alert('추천공구 등록가능!');
				}else {
					alert('추천공구 등록 불가능....ㅠ');
					
				}
			}
			
		});
	} 
		
</script>

</body>
</html>