<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그인 처리
	// : 아이디의 값과 비밀번호의 값을 문자열 비교해서 같으면 로그인 처리 (session의 속성에 저장)
	// 1. 아이디, 비밀번호 데이터를 먼저 받는다.
	// 2. 로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	// 3. 로그인 처리 : session에 사용자 정보를 저장
	// 4. 응답 처리 : html (분기처리 - 로그인 시 or 로그인 아닐 시)
	
	
	// 1. 아이디, 비밀번호 데이터를 먼저 받는다.
	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	
	// 2. 로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	boolean loginChk = false;
	
	if(uid.equals(upw)){
		// 3. 로그인 처리 : session에 사용자 정보를 저장
		//로그인 처리 : 세션의 속성에 데이터 저장
		//session.setAttribute("memberId", uid);
		session.setAttribute("memberInfo", new MemberInfo(uid, upw));
		loginChk=true;
	}
	
%>

<%
	// 4. 응답 처리 : html (분기처리 - 로그인 시 or 로그인 아닐 시)
	if(loginChk){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login</title>
</head>
<body>
	<h1>로그인 되었습니다.</h1>
	<h2>아이디 : <%= uid %>, 패스워드 : <%= upw %></h2>
	<a href="myPage.jsp">마이페이지</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>
<%
	}else {
%>
<script>
	alert("아이디 또는 비밀번호를 확인해주세요.");
	history.go(-1);
</script>
<%
	}



%>