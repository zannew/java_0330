<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	
	#a {
		background-color: yellow;
	}

	


</style>
</head>
<body>

	<div id="a"></div>
	
	<input type="button" value="자세히보기" id="open"><input type="button" value="닫기" id="close">


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
		
	});
	
	
	

</script>