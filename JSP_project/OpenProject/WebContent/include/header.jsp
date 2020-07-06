<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%
	//로그인 여부 체크! ( session에 memberInfo 객체 )
	boolean loginStatus = session.getAttribute("memberInfo")==null?false:true;
	/* boolean loginStatus = ${sessionScope.memberInfo}==null?false:true; */
	
	//String checkId=(String)session.getAttribute("id");
	
%>
	<%-- <c:forEach items="${sessionScope.memberInfo}" var="memberInfo" varStatus="status">
	</c:forEach> --%>

	<h1 id="header">Open Project</h1>
		<ul id="nav">
			<li><a href="<c:url value="/member/memberRegForm.jsp" context="/OP"/>">회원가입</a></li>
	<% 
	if(loginStatus){
	%>
			<li><a href="<c:url value="/member/logout.jsp" context="/OP"/>">로그아웃</a></li>
	<% }else { %>
			<li><a href="<c:url value="/member/memberLoginForm.jsp" context="/OP"/>">로그인</a></li>
			
	<% } %>
			<li><a href="<c:url value="/member/myPage/myPage.jsp" context="/OP"/>">마이페이지</a></li>
			<li><a href="<c:url value="/guestBook/list.jsp" context="/OP"/>">방명록(비회원)</a></li>
			<li><a href="<c:url value="/board/list.jsp" context="/OP"/>">게시판(회원제)</a></li>
	</ul>

    