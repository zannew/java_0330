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
<h1>공구등록폼</h1>

	<form id="regForm" onsubmit="return false;">

	공구글제목 : <input type="text" name="title" id="title" required><br>
	가격 : <input type="number" name="price" id="price" required><br>
	공구인원 : <input type="number" name="countM" id="countM" min="0" required><br>
	수령날짜시각 : <input type="datetime-local" id="receive" name="receive" required><br>
	판매처주소 : <input type="text" name="addr" id="addr" required><br>
	판매처위치 : <input type="text" name="location" id="location"><br>
	내용 : <input type="text" name="content" id="content"><br>
	사진 : <input type="file" name="photo" id="photo"><br>
	공구상태 : <input type="number" name="state" id="state" required><br>
	분류1 : <select id="category">
				<option value="0">과일</option>
				<option value="1">육고기</option>
				<option value="2">채소</option>
				<option value="3">생필품</option>
				<option value="4">기타</option>
		</select><br>
	게시자idx : <input type="number" name="midx" id="midx"><br>
	<input type="submit" value="공구등록" onclick="regSubmit(); ">
	<input type="reset">


	</form>
	
<script>

function regSubmit(){

	var regFormData = new FormData();
	regFormData.append('title', $('#title').val());
	regFormData.append('price', $('#price').val());
	regFormData.append('countM', $('#countM').val());
	regFormData.append('countW', $('#countM').val()*2);
	regFormData.append('receive', $('#receive').val());
	regFormData.append('addr', $('#addr').val());
	regFormData.append('location', $('#location').val());
	regFormData.append('content', $('#content').val());
	// 파일 첨부
	if($('#photo')[0].files[0] != null){
	regFormData.append('photo', $('#photo')[0].files[0]);
	}
	regFormData.append('state', $('#state').val());
	regFormData.append('viewCount', 123);
	regFormData.append('category', $('#category').val());
	regFormData.append('midx', $('#midx').val());
	
	alert('공구등록중1~');
	
	$.ajax({
		
		url : 'http://localhost:8080/wifi/items',
		type : 'POST',
		processData : false,
		contentType : false,
		data : regFormData,
		success : function(data){
			alert(data);
			$('#regForm').reset();
			//location.href='index';
			alert('공구등록완료');
		}
	});

}


</script>
	
</body>
</html>
