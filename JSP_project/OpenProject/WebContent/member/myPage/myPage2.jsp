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

#profile {
	margin: 10px 10px;
}

h1{
	padding: 15px 20px;
}
h2 {
	margin: 0 20px;
	padding: 10px 15px;
}
h3 {
	margin: 0 10px;
}
a.btn {
	margin: 50px 10px;
	padding: 50px 5px;
}

#profile>tbody>tr>td {
	margin: 10px 10px;
	padding: 3px 3px;
	font-weight: bold;
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
	<h3>▶ <%= memberInfo.getMname() %>님의 회원정보</h3>
	<br>
	<div class="profile">
	
		<table id="profile">
			<tr>
				<td>아이디</td>
				<td><%= memberInfo.getMid() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%= memberInfo.getMpw() %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= memberInfo.getMname() %></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><%= memberInfo.getMphoto() %></td>
			</tr>
		</table>
	</div>
	
	<a href="<%= request.getContextPath() %>/member/logout.jsp" class="btn logout">로그아웃</a>
	<a href="<%= request.getContextPath() %>/member/logout.jsp" class="btn main">메인으로 가기</a>
	
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>
<%
	}
%>
