<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Map<String, MemberInfo> memberMap = new HashMap<>();
	
	//1. 가입 정보를 받아온다.
	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	String uname = request.getParameter("uname");
	String uphoto = request.getParameter("uphoto");
	
%>
<script>
		
	//가입 의사 확인
	var regConfirm = confirm("회원가입을 계속 진행하시겠습니까?");

</script>
<% 
	//가입 완료 확인
	boolean regChk = false;

	if(regConfirm){
		
	//2. 해시맵에 저장
	memberMap.put(uid, new MemberInfo(uid, upw, uname, "uphoto.jpg"));
	
	//3. 어플리케이션 속성set
	application.setAttribute(uid, memberMap);
	
	if(application.getAttribute(uid)!=null){
		regChk = true;
	}%>
	<% 
		alert("성공적으로 가입되었습니다.");
	%>
	}else{<% 
		alert("가입을 중단하고 메인으로 돌아갑니다.");%>
		location.href = "<%= request.getContextPath()%>/index.jsp";
	}


<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project - 회원가입</title>
</head>
<body>

</body>
</html> -->
	<%-- confirm("이름 : "<%=uid%>"\n비밀번호 : "<%=upw%>"\n이름 : "<%=uname%>"\n위의 정보로 회원가입하시겠습니까?"); --%>
