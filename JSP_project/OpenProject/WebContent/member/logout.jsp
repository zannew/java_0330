<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenProject 로그아웃 페이지</title>

</head>
<body>
	
</body>
</html>
<script>
	alert("로그아웃 되었습니다. \n 다시 로그인페이지로 이동합니다.");
	location.href="memberLoginForm.jsp";
</script>