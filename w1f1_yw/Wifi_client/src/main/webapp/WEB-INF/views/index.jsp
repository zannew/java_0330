<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/default.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/include/background.jsp" %>	
	<%@ include file="/WEB-INF/views/include/header.jsp" %>



      <c:if test="${empty loginInfo}">
	    <div class="box container">
	      <h1>Login</h1>
				<div>
					<form method="POST">
						<a href="${kakaoUrl}" id="linkToLogin"><img id="loginBtn" src=<c:url value="resources/images/kakao_login_medium_narrow.png"/>/></a>				
					</form>			
				</div>
	      <p>추가정보를  입력하시려면? <span>추가정보 입력</span></p>
	    
	    </div>
	    
		</c:if>
		<c:if test="${!empty loginInfo}">
			<div>
				<a href=${logoutUrl}>로그아웃</a>
				<h1>접속한 유저 : ${loginInfo}</h1>
				<h1>아이디 출력 : ${loginInfo.id}</h1>			
			</div>
		</c:if>
    
		

</body>
</html>
<script>
	alert('메인페이지입니다.');
	

	var promises = [];
	function makePromise(i, video) {
	  promises[i] = new $.Deferred();
	  // This event tells us video can be played all the way through, without stopping or buffering
	  video.oncanplaythrough = function() {
	    // Resolve the promise
	    promises[i].resolve();
	  }
	}
	// Pause all videos and create the promise array
	$('video').each(function(index){
	  this.pause();
	  makePromise(index, this);
	})

	// Wait for all promises to resolve then start playing
	$.when.apply(null, promises).done(function () {
	  $('video').each(function(){
	    this.play();
	  });
	});

	
	
</script>