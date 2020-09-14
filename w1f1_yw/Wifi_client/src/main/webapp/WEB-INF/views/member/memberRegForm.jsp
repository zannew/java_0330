<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
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

	<h1>RegForm..</h1>
	<h3>전화번호</h3>
	<h3>주소</h3>
	
	<div class="container">
  		<h2>Stacked form</h2>
		  <form method="post">
		  	<div class="form-group">
		      <label for="id">아이디:</label>
		      <input type="email" class="form-control" id="id" name="id" value="${email}" readonly>
		    </div>
		    <div class="form-group">
		      <label for="name">이름 :</label>
		      <input type="text" class="form-control" id="name" placeholder="이름(닉네임)을 입력하세요." name="name">
		    </div>
		     <div class="form-group">
		      <label for="addr">주소:</label>
		      <input type="text" class="form-control" id="addr" placeholder="주소를 입력하세요." name="addr">
		    </div>
		    <div class="form-group">
		      <label for="phone">전화번호:</label>
		      <input type="text" class="form-control" id="phone" placeholder="전화번호를 입력하세요." name="phone">
		    </div>
		    <input type="submit" value="가입하기" class="btn btn-primary">
		  </form>
	</div>

</body>
</html>