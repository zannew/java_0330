<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/default.css">
<%-- <link rel="stylesheet" href="<c:url value="/CSS/default.css"/>" context="/OPMVC"/> --%>
<style>
	.check_ok {
		color: blue;
	}
	.check_not {
		color: red;
		font-weight: bold;
	}
	#idchk {
		display: none;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	
	<div>
		<h1 class="subtitle">회원 가입</h1><br>


		<form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="email" name="uid" id="uid" >
					<span id="checkmsg"></span>
					<input type="checkbox" name="idchk" id="idchk">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="회원가입">
						<inpyt type="reset">
					</td>
				</tr>
			</table>
		
		</form>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
<script>

	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#idchk').prop('checked')){
				
				alert("아이디 중복 체크는 필수 항목입니다.");
				$('#uid').focus();
				return false;
			}
			
		});
		
		$('#uid').focusin(function(){
			
			$(this).val('');
			
			$('#idchk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
			
		});
		
		
		
		$('#uid').focusout(function(){
			
			if($(this).val().length<1){
				$('#checkmsg').text("아이디는 필수 입력사항입니다.");
				$('#checkmsg').addClass('check_not');
				
				return false;
			}
			
			
			// 비동기통신 
			$.ajax({
				url: 'idCheck.do',
				data: { uid : $(this).val() },
				success: function(data){
					if(data=='Y'){
						/* $('#checkmsg').removeClass('check_not');
						$('#checkmsg').removeClass('check_ok'); */
						$('#checkmsg').text("사용 가능한 아이디입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
						
						
					} else {
						/* $('#checkmsg').removeClass('check_not');
						$('#checkmsg').removeClass('check_ok'); */
						$('#checkmsg').text("사용할 수 없는 아이디입니다.");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				}
			});
		});
		
	});
</script>


