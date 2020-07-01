<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 출력</title>
</head>
<body>

	<h1>회원가입 회원 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디(이메일)</td>
			<td><%= request.getParameter("id") %></td>
		</tr>	
		<tr>
			<td>비밀번호</td>
			<td><%= request.getParameter("pw") %></td>
		</tr>	
		<tr>
			<td>이름</td>
			<td><%= request.getParameter("uname") %></td>
		</tr>	
		<tr>
			<td>사진</td>
			<td></td>
		</tr>	
	
	</table>

</body>
</html>