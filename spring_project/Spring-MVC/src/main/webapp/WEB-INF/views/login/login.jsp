  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>