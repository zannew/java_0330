<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<div id="desktopNav">
	
	<form>
		검색어 : <input type="text" name="test1">
	</form>
	
	</div>

</body>
</html>
<script>


	//Search box change by Readiz 
	$("#desktopNav input").focusin(function() {
		$("#desktopNav form").animate({
			"width" : "200px"
		}, 300, function() {
		});
	});
	$("#desktopNav input").blur(function() {
		$("#desktopNav form").animate({
			"width" : "60px"
		}, 300, function() {
		});
	});
	$("#desktopNav form").click(function() {
		$("#desktopNav input").focus();
	});
	
	
	
</script>