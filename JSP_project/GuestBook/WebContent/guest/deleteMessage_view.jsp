<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteMessage_view</title>
</head>
<body>
	
	<c:if test="${statusCode eq 1}">
		<h1>메시지가 정상적으로 삭제되었습니다.</h1>
	</c:if>
	<c:if test="${statusCode eq -1}">
		<h1>삭제할 메시지가 존재하지 않습니다.</h1>
	</c:if>
	<c:if test="${statusCode eq -2}">
		<h1>비밀번호가 일치하지 않습니다.</h1>
	</c:if>
	
	<a href="list.jsp">리스트 보기</a>
	
	
	
	
	
</body>
</html>