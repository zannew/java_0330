<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Confirm View</title>
</head>
<body>
	<c:if test="${memberInfo>0}">
		아이디 : ${memberInfo.uid}<br>
		비밀번호 : ${memberInfo.upw}<br>
		이름 : ${memberInfo.uname}<br>
		프로필 사진<br><img src="<c:url value="${memberInfo.uphoto}"/>">
	</c:if>
	
	<c:if test="${memberInfo eq 0}">
		<h1>저장이 되지 않았습니다.</h1>
	</c:if>
	
	
	
</body>
</html>