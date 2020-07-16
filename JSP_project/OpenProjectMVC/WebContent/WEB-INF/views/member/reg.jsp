<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<%-- <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/default.css"> --%>
<link rel="stylesheet" href="<c:url value="/CSS/default.css"/>"> 
<style>
	a {
		margin: 10px 10px;
	}
	
	#congratsMsg {
		color: green;
		
	}
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	
	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<h3>
			
			<c:if test="${result gt 0 && member ne null}">
				<div id="congratsMsg">
					<h2>▶ 축하합니다 ◀</h2>
					<h2>회원가입이 정상적으로 처리되었습니다.</h2>
	
				</div>
				<br><br>
				
				<a href="${pageContext.request.contextPath}/member/memberList.do">회원리스트</a>
				
			</c:if>
			
			<c:if test="${not (result gt 0 && member ne null)}">
				<div>
					회원가입 실패				
				</div>
			</c:if>
			
			
		
		</h3>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>

