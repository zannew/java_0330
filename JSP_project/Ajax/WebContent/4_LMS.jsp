<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- <script>
	
	$(document).ready(function(){
		
		
		 $( '#open' ).click( function() {
	          $( '#a' ).animate( {
	            width: '50%',
	            height: '200px'
	          } );
	        } );
	           $( '#close' ).click( function() {
	          $( '#a' ).animate( {
	            width: '50%',
	            height: '100px'
	          } );
	        } );
	           
	        // url에 받아올 데이터 주소
	   		$.getJSON('data_json_LMS.jsp', function(data){
	   			//data와 각각 어떻게 처리할지 함수 정의
	   			 $.each(data, function(key, value){
	   				
	   				$('body').append('<h1>강의번호 : '+value.classIdx+', 시간 : '+value.startTime+', 강의명: '+value.classRoom+', 강의실: '+value.className+'</h1>');		
	   				
	   			}); 
	   			
	   			/* 	html = '';

	   			for(key in data){
	   				
	   				html +='		<div id='+"classInfo"+'>';
	   				html +='			<span>'+data[key].classIdx+'</span>';
	   				html +='			<span>'+data[key].startTime+'</span>';
	   				html +='			<span>'+data[key].className+'</span>';
	   				html +='			<span>'+data[key].classRoom+'</span>';
	   				html +='			<span>'+data[key].contents+'</span>';
	   				html +='			<input type='+"button"+' id='+"open"+' value="세부정보"><input type='+"button"+' id='+"close"+' value="닫기">';
	   				html +='		</div>';
	   				
	   				
	   				$('#classListTbody').empty();
	   				$('#classListTbody').html(html);
	   			} */
	   			
	   			
	   		});
		
	});
	
	
</script> -->
<style>
#a {
	width: '50%';
	height: 100px;
	border: 3px solid;
	overflow: auto;
}

#classInfo {
	border: 1px solid black;
	/* background-color: yellow; */
}

tr {
	background-color: grey;
}

span {
	padding: 20px;
	background-color: yellow;
}

div.classListTbody {
	background-color: grey;
}
</style>
</head>
<body>
	<h1>나의 강의실</h1>

	<div id="a">
		<form id="classList">
			<div>
				<div>
					<div>
						<span>강의번호</span> <span>시간</span> <span>강의명</span> <span>강의실</span>
						<span>강의개요</span>
					</div>
				</div>
				<div class="classListTbody">
				</div>

			</div>
		</form>

	</div>

</body>
</html>
<script>

	$(document).ready(function() {

		$('#open').click(function() {
			$('#a').animate({
				width : '50%',
				height : '300px'
			});
		});
		$('#close').click(function() {
			$('#a').animate({
				width : '50%',
				height : '100px'
			});
		});

		// url에 받아올 데이터 주소
		$.getJSON('data_json_LMS.jsp', function(data) {
			//data와 각각 어떻게 처리할지 함수 정의
			/* $.each(data, function(key, value){
				
				$('body').append('<h1>강의번호 : '+value.classIdx+', 시간 : '+value.startTime+', 강의명: '+value.className+', 강의실: '+value.classRoom+'</h1>');		
				
			}); */

			html = '';

			for (key in data) {

				html += '		<div>';
				html += '			<span>' + data[key].classIdx + '</span>';
				html += '			<span>' + data[key].startTime + '</span>';
				html += '			<span>' + data[key].className + '</span>';
				html += '			<span>' + data[key].classRoom + '</span>';
				html += '			<span>' + data[key].contents + '</span>';
				//html +='			<input type='+"button"+' value='+"크게보기"+'>';
				html += '		</div>';

				$('div.classListTbody').empty();
				$('div.classListTbody').html(html);
			}

		});

	});
</script>
