<%@page import="util.CookieBox"%>
<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 처리
	// : 아이디의 값과 비밀번호의 값을 문자열 비교해서 같으면 로그인 처리 (session의 속성에 저장)
	// 1. 아이디, 비밀번호 데이터를 먼저 받는다.
	// 2. 로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	// 3. 로그인 처리 : session에 사용자 정보를 저장
	// 4. 응답 처리 : html (분기처리 - 로그인 시 or 로그인 아닐 시)

	// 1. 아이디, 비밀번호 데이터를 먼저 받는다.
	String uid = request.getParameter("id");
	String upw = request.getParameter("pw");
	String chk = request.getParameter("checkbox_id");
	

	
	// 2. 로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	boolean loginChk = false;
	
	if(uid.equals(upw)){
		MemberInfo memberInfo = new MemberInfo(uid, upw, "default", "default.jpg");
	// 3. 로그인 처리 : session에 사용자 정보를 저장
	session.setAttribute("memberInfo", memberInfo);
	loginChk = true;	
	
	}

	
	// 4. 응답 처리 : html (분기 login or non-login)
	if(loginChk){
		
		String cookieId="id";
		String cookiePath=request.getContextPath();
		
		//회원 아이디 쿠키 설정
		if(chk!=null){
			response.addCookie(CookieBox.createCookie(cookieId, uid, cookiePath, 60*60));
		}else{
			response.addCookie(CookieBox.createCookie(cookieId, uid, cookiePath, 0));
		}
		%>
			<script>
			alert("로그인에 성공하셨습니다. \n 마이페이지로 바로 이동합니다.");
		location.href= "<%= request.getContextPath()%>/member/myPage/myPage.jsp";
			</script>
		<%
	} else {
		
	%>
	<script>
		alert("아이디와 비밀번호를 확인해주세요.");
		history.go(-1);
	</script>
	<% 
	}
	%>
	
<%-- <!DOCTYPE html>
		//response.sendRedirect(rediectUri);
<html>
<head>
<meta charset="UTF-8">
<title>memberLogin</title>
</head>
<body>
	<h1>로그인에 성공하셨습니다.</h1>
	<h2> 아이디 : <%= uid %></h2>
	<h2> 패스워드  : <%= upw %></h2>
	
	<a href="<%= request.getContextPath()%>/member/myPage/myPage.jsp">마이페이지</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>
<%
	}else {
%>
<script>
	alert("아이디와 비밀번호를 확인해주세요.");
	history.go(-1);
</script>
<%
	}
%> --%>