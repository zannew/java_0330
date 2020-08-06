<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>"> 
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<div>
	${member}
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>