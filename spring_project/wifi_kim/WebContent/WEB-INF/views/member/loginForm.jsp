<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<form id="loginForm" method="post">
		<input type="hidden" name="id" id="id" value="${email}" readonly>
	</form>
	<script>this.document.getElementById("loginForm").submit();</script>>
</body>
</html>
