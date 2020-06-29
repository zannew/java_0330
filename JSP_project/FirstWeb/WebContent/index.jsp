<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<%
		//스크립트릿 영역 : java코드 작성 (앞으로는 사용하지 않는다 - MVC활용 시)
		Date now = new Date();
	%>
	<!-- 표현식 -->
	<%= now %>

</body>
</html>