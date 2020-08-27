<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
		
	<h1> 공구글 작성하기 </h1>
	
	<div id="regArea">
		<div class="regForm">
			<form id="regForm" onsubmit="return false;">


			공구글제목 : <input type="text" name="title" id="title" required><br>
			가격 : <input type="number" name="price" id="price" required><br>
			공구인원 : <input type="number" name="count_m" id="count_m" min="0" required><br>
			수령날짜 : <input type="datetime-local" id="receive" name="receive" required><br>
			판매처주소 : <input type="text" name="addr" id="addr" required><br>
			판매처위치 : <input type="text" name="location" id="location"><br>
			내용 : <input type="text" name="content" id="content"><br>
			사진 : <input type="file" name="photo" id="photo"><br>
			공구상태 : <input type="checkbox" name="state" id="state" value="1">추천공구로 등록하기<input type="checkbox" name="state" id="state" value="0">일반공구로 등록하기<br> 
			분류 : <select id="category">
						<option value="0">과일</option>
						<option value="1">육류</option>
						<option value="2">해산물</option>
						<option value="3">채소</option>
						<option value="4">생필품</option>
						<option value="5">음료</option>
						<option value="6">기타</option>
				</select><br>
			게시자idx : <input type="number" name="midx" id="midx" value=${loginInfo.midx}><br>
			<input type="submit" value="공구등록" onclick="regSubmit(); ">
			<input type="reset">
			</form>
		</div>
	</div>
	
	
</body>
</html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script>
var mainUrl ="http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/items";

function regSubmit(){
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
		regFormData.append('state', $('#state').val());
		regFormData.append('view_count', 123);
		regFormData.append('category', $('#category').val());
		regFormData.append('midx', $('#midx').val());
		
		$.ajax({
			
			url : mainUrl,
			type : 'POST',
			processData : false,
			contentType : false,
			data : regFormData,
			success : function(data){
				alert('공구등록완료');
				//getItemListView();
				location.href="/wifi/board/itemList";
				
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
</script>