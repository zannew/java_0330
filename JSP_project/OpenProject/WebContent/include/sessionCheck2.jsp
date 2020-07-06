<%@page pageEncoding="utf-8" %>
<%@page import="model.MemberInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
	if(memberInfo==null){
		%>
	<script>
	
	
	alert("회원 전용 페이지입니다. \n 로그인 해주세요.");		
		location.href='<%= request.getContextPath()%>/member/memberLoginForm.jsp';
	</script>
		<%
	}
%>