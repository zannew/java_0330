<%@ page language="java" contentType="application.xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>"> 
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<style>

	span.totalMemberCount {
		color: green;
	}

	#profile_photo {
		width: 100px;
		height: 100px;
	}
	
	div.memberInfo {
		font-weight: bold;
		
		margin: 10px 10px;
		padding: 5px 5px;
		
	}
	
	.currentPage {
		background-color: yellow;
	}
	
	div.searchBox {
		border: 1px solid #DDD;
		padding: 20px;
		width: 80%;
	}

</style>

</head>
<body>
	
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>


