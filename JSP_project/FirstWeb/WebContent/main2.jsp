<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Test</title>
<style>
	header {
		text-align: center;
	}
	#wrap {
		overflow: hidden;
	}
	#news {
		width: 45%;
		float: left;
	}
	#shopping {
		width: 45%;
		float: right;
	}
	
	
</style>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<div id="wrap">
	<%@ include file="include/news.jsp" %>
	<%@ include file="include/shopping.jsp" %>
	</div>
	<jsp:include page="include/footer.jsp">
		<jsp:param value="cool@mgail.com" name="email"/>
		<jsp:param value="010-5225-5214" name="tel"/>
	</jsp:include>
</body>
</html>