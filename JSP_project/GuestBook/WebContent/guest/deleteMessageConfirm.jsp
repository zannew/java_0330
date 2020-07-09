<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete confirm</title>
<script>

	//var form = document.getElementById("delForm");
	
	function check(){
		
		if(confirm('삭제하시겠습니까?')){
			return true;
		}
		
		return false;
	}
	
	
</script>
</head>
<body>
	<h3>메시지를 삭제하시고자 하시면 비밀번호를 입력해주세요.</h3>
	<form id="delForm" action="deleteMessage.jsp" onsubmit="return check();">
		비밀번호 <input type="password" name="pw">
		<input type="hidden" name="mid" value="${param.mid}">
		<input type="submit" value="삭제하기">
	</form>
</body>
</html>