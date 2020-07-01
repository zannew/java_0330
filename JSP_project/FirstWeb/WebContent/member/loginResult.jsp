<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>

</head>
<body>

	<h1>로그인 결과</h1>
	<hr>
	
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%= request.getParameter("id") %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= request.getParameter("pw") %></td>
		</tr>
		<tr>
			<td>요청 메서드</td>
			<td><%= request.getMethod() %></td>
		</tr>
		<tr>
			<td>쿠키 정보</td>
			<td><%= request.getCookies() %></td>
		</tr>
		<tr>
			<td>요청 정보 URL</td>
			<td>
				<%= request.getProtocol() %><br>
				URL : <%= request.getRequestURL() %><br>
				URI : <%= request.getRequestURI() %>
			</td>
		</tr>
	</table>

</body>
</html>