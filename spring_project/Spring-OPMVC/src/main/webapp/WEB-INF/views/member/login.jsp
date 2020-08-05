<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>">
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<h1>Login</h1>
	<form action="" method="get">
		<table>
			<tr>
				<td>아이디</td>
				<td>${login.uid}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${login.upw}</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	
</body>
</html>