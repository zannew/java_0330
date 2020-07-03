<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* Cookie cookie = new Cookie("uid","COOL");
	cookie.setMaxAge(60);
	response.addCookie(cookie);
	
	Cookie cookie2 = new Cookie("uname","장윤원");
	response.addCookie(cookie2); */
	
	
	
	if(request.getParameter("checkbox_id").equals("checked")){
		response.addCookie(CookieBox.createCookie("id", request.getParameter("id"),"/OP/member", 60*60));
	}else{
		response.addCookie(CookieBox.createCookie("id", "", "/OP/member", 0));
	}
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Cookie</title>
</head>
<body>
	<h1>쿠키생성완료</h1>
	
	<a href="viewCookie.jsp">쿠키확인</a>
	<a href="memberLoginForm.jsp">로그인 화면으로 돌아가기</a>
	
	
</body>
</html>