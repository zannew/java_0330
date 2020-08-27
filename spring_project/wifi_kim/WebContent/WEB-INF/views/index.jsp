<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<div>
		<c:if test="${empty loginInfo}">
		<div class="login-page"> 
			<div class="form"> 
            	<form class="login-form" method="POST">
	            <a href="${kakao_url}"> <img id="button" src=<c:url value="/images/kakao_login_medium_narrow.png" />/></a>
	            <p class="message">추가 정보를 입력하지 않으셨나요? <a href="#">추가정보 입력</a></p>
            	</form>
            </div>
		</div>
		</c:if>
		<c:if test="${!empty loginInfo}">
			<div id="kakao_id_logout" style="text-align: center"> 
				<a href="${logout_url}">로그아웃</a> 	
			</div>
		</c:if>
		<c:if test="${!empty loginInfo}">
			<h1>접속한 유저 : ${loginInfo}</h1>
			<h1>아이디 출력 : ${loginInfo.id}</h1>
		</c:if>
	</div>
</body>
</html>