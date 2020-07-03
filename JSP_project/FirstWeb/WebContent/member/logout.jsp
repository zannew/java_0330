<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃 되었습니다.</h1>
	<a href="myPage.jsp">마이페이지</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>