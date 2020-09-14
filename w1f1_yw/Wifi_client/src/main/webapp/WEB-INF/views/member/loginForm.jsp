<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


<%@ include file="/WEB-INF/views/include/background.jsp" %>

	<h1>IdCheck!!</h1>
	<h3>전화번호</h3>
	<h3>주소</h3>
	
	<div class="container">
  		<h2>Stacked form</h2>
		  <form id="loginCheck" method="post">
		  	<div class="form-group">
		      <label for="id">아이디:</label>
		      <input type="hidden" class="form-control" id="id" name="id" value="${email}" readonly>
		    </div>
		  </form>
		  <script>this.document.getElementById("loginCheck").submit();</script>
	</div>


</body>
</html>