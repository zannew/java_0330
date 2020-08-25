<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<h1>메인이오</h1>
	
	<div>
		<c:if test="${empty loginInfo}">
			<div>
				<form method="POST">
					<a href="${kakaoUrl}"><img id="loginBtn" src=<c:url value="/images/kakao_login_medium_narrow.png"/>/></a>				
				</form>			
			</div>
		</c:if>
		<c:if test="${!empty loginInfo}">
			<div>
				<a href=${logoutUrl}>로그아웃</a>			
			</div>
		</c:if>
		<c:if test="${!empty loginInfo}">
			<h1>접속한 유저 : ${loginInfo}</h1>		
			<h1>아이디 확인 : ${loginInfo.id}</h1>
		</c:if>
	</div>


</body>
</html>
<script>
	alert('카카오 로그인 페이지입니다.');
	
	
	
</script>