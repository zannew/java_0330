<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/sessionCheck.jsp" %>
<%
	if(memberInfo!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenProject 마이페이지</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/default.css">
<style>
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	
	<div>
		<h1>마이페이지</h1>
	</div>
	<h2>환영합니다!</h2>
	<br>
	<h2><%= memberInfo.getUid() %>님의 회원정보</h2>
	<br>
	<div class="profile">
		아이디 : <%= memberInfo.getUid() %><br>
		비밀번호 : <%= memberInfo.getUpw() %><br>
		이름 : <%= memberInfo.getUname() %><br>
		이메일 : <%= memberInfo.getEmail() %><br>
		
	</div>
	
	<a href="<%= request.getContextPath() %>/member/logout.jsp">로그아웃</a>
	
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<%
	}
%>
