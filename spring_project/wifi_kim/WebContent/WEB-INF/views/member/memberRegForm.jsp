<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가입력</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<div>
		<form id="regForm" method="post">
			<table class="table">
				<tr>
					<td>카카오 이메일</td>
					<td> <input type="email" name="id" id="id" value="${email}" readonly>
					 </td>
				</tr>
				<tr>
					<td>닉네임 (기본값 : 설정하신 카카오 이름 / 변경 가능)</td>
					<td><input type="text" name="name" id="name" placeholder="닉네임" required>
						<span  id="checkmsg"></span>
						<input type="checkbox" name="namechk" id="namechk">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td> <input type="text" name="phone" id="phone" placeholder="전화번호" required> </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" value="회원가입">
					</td>
				</tr>
			</table>
			<h3>주소</h3>
			<input type="text" name="addr" id="addr" placeholder="주소" onclick="sample5_execDaumPostcode()" required>
			<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			<div id="map" style="width:300px; height:300px; margin-top:10px; display:none"></div>
		</form>
	</div>
</body>
</html>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1991f08acbd1c4f19d653c9a9391bb42&libraries=services"></script>
<script>
	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#namechk').prop('checked')){
				alert('닉네임 중복 체크는 필수 항목 입니다');
				$('#name').focus();
				return false;
			}
			
			
			
		}); // regForm submit end
	
		$('#name').focusin(function(){
			
			$(this).val('');
			$('#namechk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
			
		}); // name focusin end
		
		$('#name').focusout(function(){
			
			
			
			if($(this).val().length < 1) {
				
				$('#checkmsg').text("닉네임 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			} // name focusout if end
			
			$.ajax({
				url:'nameCheck',
				data: {name: $('#name').val()},
				success: function(data){
					if(data == 'Y') {
						$('#checkmsg').text("사용 가능한 닉네임입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#namechk').prop('checked', true);
					} else {
						$('#checkmsg').text("이미 사용중인 닉네임입니다.");
						$('#checkmsg').addClass('check_not');
						$('#namechk').prop('checked', false);
					
					} // success if end
					
				} // success function end
				
				
			}); // ajax check name end
			
			
		}); // name focusout function end
		
		
	}); // jquery end
	

   var mapContainer = document.getElementById('map'), // 지도를 표시할 div
       mapOption = {
           center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
           level: 5 // 지도의 확대 레벨
       };

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
               document.getElementById("addr").value = addr;
               // 주소로 상세 정보를 검색
               geocoder.addressSearch(data.address, function(results, status) {
                   // 정상적으로 검색이 완료됐으면
                   if (status === daum.maps.services.Status.OK) {

                       var result = results[0]; //첫번째 결과의 값을 활용

                       // 해당 주소에 대한 좌표를 받아서
                       var coords = new daum.maps.LatLng(result.y, result.x);
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
</script>