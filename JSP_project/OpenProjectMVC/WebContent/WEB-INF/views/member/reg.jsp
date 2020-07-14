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
/* * {
	margin: 10px 10px;
	padding: 0;
}

body {
		margin: 30px 30px;
		padding: 10px 10px;
	}


#header {
	padding: 15px 20px;
}

#nav {
	border-bottom: 1px solid #ddd;
	border-top: 1px solid #ddd;
	overflow: hidden;
	list-style: none;
}

#nav>li {
	float: left;
	padding: 5px 20px;
}

footer {
	text-align: center;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	padding: 20px 0;
	margin-top: 10px;
	
} */
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	
	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<h3>
			
			<c:if test="${result gt 0 && member ne null}">
				<div>
					회원가입 완료
				</div>
				${member}
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