<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/regBootstrap.jsp" %>
 
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
		regFormData.append('location', $('#location').val());
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