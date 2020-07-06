<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%
	//로그인 여부 체크! ( session에 memberInfo 객체 )
	boolean loginStatus = session.getAttribute("memberInfo")==null?false:true;
	//String checkId=(String)session.getAttribute("id");
	
%>
	<h1 id="header">Open Project</h1>
		<ul id="nav">
			<li><a href="<c:url value="/member/memberRegForm.jsp" context="/op"/>">회원가입</a></li>
	<% 
	if(loginStatus){
	%>
			<li><a href="<%= request.getContextPath() %>/member/logout.jsp">로그아웃</a></li>
	<% }else { %>
			<li><a href="<%= request.getContextPath() %>/member/memberLoginForm.jsp">로그인</a></li>
			
	<% } %>
			<li><a href="<%= request.getContextPath()%>/member/myPage/myPage.jsp">마이페이지</a></li>
			<li><a href="<%= request.getContextPath() %>/guestBook/list.jsp">방명록(비회원)</a></li>
			<li><a href="<%= request.getContextPath() %>/board/list.jsp">게시판(회원제)</a></li>
	</ul>

    