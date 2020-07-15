<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="<c:url value="/CSS/default.css"/>"> 
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
	
	#chk {
		display: none;
		
	}
	
	.delBtn {
		
	}

</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	
	<div>
		<h1 class="subtitle">회원 가입</h1><span class="totalMemberCount">현재 총 회원 수 : ${listView.memberTotalCount} 명</span>
		<hr>
		<h3>
		
			<c:if test="${not empty listView}">
				
			
			</c:if>
			
			<c:if test="${not empty listView.memberList}">
				
				<c:forEach items="${listView.memberList}" var="member">
					<div class="memberInfo">
						회원번호 : ${member.idx}<br>
						아이디 : ${member.uid}<br>
						이름 : ${member.uname}<br>
						<div>[프로필 사진]</div><img src="<c:url value="${member.uphoto}"/>" id="profile_photo"><br>
						가입일 : ${member.regdate}<br>
						<a href="#?idx=${member.idx}" id="delBtn">삭제</a><a>수정</a>
						<hr>
						
						<div id="chk">
						
							감췄다가 나타나게할 영역
						</div>
						
						
					</div>					
				</c:forEach>
			</c:if>
			
			<div class="paging">
			<c:if test="${listView.pageTotalCount>0}">
				<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
					<a href="memberListConfirm.do?page=${num}" ${listView.currentPageNumber eq num ? 'class="currentPage"':''}>[${num}]</a>
				
				</c:forEach>
			
			</c:if>
			
			</div>
			
			
			
			
		
		</h3>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
<script>

	//var delBtn = document.getElementById("delBtn");

	$(document).ready(function(){
	
		$('#delBtn').click(function(){
		
			$('#chk').css('display', 'block');
			
		}
		
	});
	


</script>

