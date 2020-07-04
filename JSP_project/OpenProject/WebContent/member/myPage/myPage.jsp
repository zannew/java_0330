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

#profile, h2, a, h1 {
	margin: 15px 15px;
}

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
	
		<table id="profile">
			<tr>
				<td>아이디 :</td>
				<td><%= memberInfo.getUid() %></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><%= memberInfo.getUpw() %></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><%= memberInfo.getUname() %></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><%= memberInfo.getEmail() %></td>
			</tr>
		</table>
	</div>
	
	<a href="<%= request.getContextPath() %>/member/logout.jsp">로그아웃</a>
	
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<%
	}
%>
