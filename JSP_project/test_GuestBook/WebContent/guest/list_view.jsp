<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form - Insert</title>
<style>
	table td {
		padding: 10px;
	}
	
	input, textarea {
		padding : 5px;
	}
	
</style>
</head>
<body>

	<h1>입력폼 페이지</h1>
	
	<form action="messageWrite.jsp" method="post">
		<table>
			<tr>
				<td><label for="uname">이름</label></td>
				<td><input type="text" id="uname" name="uname" required></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td>
				<td><input type="password" id="pw" name="pw" required></td>
			</tr>
			<tr>
				<td><label for="msg">글쓰기</label></td>
				<td><textarea name="msg" id="msg" cols="30" row="30" required></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="글쓰기"><input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>