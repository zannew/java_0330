<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wifi.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>    
<style>
#nav {
  overflow: hidden;
  list-style: none;
  font-size: 25px;
  margin: -50px 0px 0px 50px;
  padding: 15px 20px;
  width: 80%;
}

li {
  float: left;
  border: 0;
  margin-left: 100px;
  padding: 15px 20px;
}

#list {
  margin-left: 250px;
}

#logout {
  float: letf;
}

h3 {
  margin: 0%;
  color: #FFFFFF;
}

li a {
  color: #FFFFFF;
}
</style>
	
<div id="header">
	<div class="wifi-symbol">
		<div class="wifi-circle first"></div>
		<div class="wifi-circle second"></div>
		<div class="wifi-circle third"></div>
		<div class="wifi-circle fourth"></div>
	</div>
	
	<ul id="nav">		
		<li id="list"><a href="
			<c:if test="${!empty loginInfo}"><c:url value="/board/itemList"/></c:if>
			<c:if test="${empty loginInfo}"><c:url value="${kakao_url}"/></c:if> ">게시판으로</a>
		</li>
	<c:if test="${!empty loginInfo}">
		<li id="logout">
			<a href="${logout_url}">로그아웃</a>
		</li>
		<li id="info">
			<h3>아이디 출력 : ${loginInfo.id}</h3>
		</li>
	</c:if>
	</ul>
	
	

</div>
