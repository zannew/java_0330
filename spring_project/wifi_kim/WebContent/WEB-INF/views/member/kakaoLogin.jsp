<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인 REST API 테스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<h1>카카오 로그인 REST API 테스트페이지</h1>
	
	<div id="kakao_id_login" style="text-align: center"> 
	
		<a href="${kakao_url}"> 로그인 </a> 
	
	</div>
	
</body>
</html>