<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>w1f1 - 1인가구를 위한 공동구매</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<div class="header_area">
		<ul id="nav">
			<li>
			<c:if test="${!empty loginInfo}">
				<a href="<c:url value="/items/itemList"/>">공구리스트</a>
			</c:if>
			<c:if test="${empty loginInfo}">
			<a href="<c:url value="${kakaoUrl}" />" id="login_btn">공구리스트</a>
			</c:if>
			
			<c:if test="${!empty loginInfo}">
				<li><a href="<c:url value="/login/logout"/>"><button id="logout_btn">로그아웃</button></a></li>
			</c:if>
		</ul>
	
	</div>

	

</body>
</html>
<script>

	$(document).ready(function(){
		
		
		$('#login_btn').click(function(){
			
			alert("로그인이 필요합니다.");
			
		});
		
	});
</script>