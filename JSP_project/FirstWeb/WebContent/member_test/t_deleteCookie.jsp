<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* Cookie cookie = new Cookie("uname","");
	cookie.setMaxAge(0);
	response.addCookie(cookie); */
	
	response.addCookie(CookieBox.createCookie("id", "", "/web/member_test", 0));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete cookie</title>
</head>
<body>
	<h1>쿠키를 삭제합니다.</h1>
	<a href="t_viewCookie.jsp">쿠키 확인하기</a>
	<a href="t_loginForm.jsp">로그인 화면으로 돌아가기</a>
	
</body>
</html>