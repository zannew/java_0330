<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*반환된 Object타입 String으로 형변환  */
	String userName = (String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		session의 속성으로 저장한 데이터<br>
		username : <%= userName %><br>
		<a href="../index.jsp">다른 페이지</a>
		<a href="logOut.jsp">로그아웃</a>
		
	</h1>
</body>
</html>