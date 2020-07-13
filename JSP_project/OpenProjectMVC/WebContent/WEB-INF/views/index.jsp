<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<%-- <link rel="stylesheet"  href="<%= request.getContextPath() %>/CSS/default.css"> --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/default.css">
<%-- <link rel="stylesheet"  href="<c:url value="/CSS/default.css" context="/OPMVC"/>"> --%>
<style>
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<div>
		
		메인입니다 :-)
		
		
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>