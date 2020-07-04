  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/default.css">
<style>
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	
	<div>
		<h1>회원 가입</h1>
		
        <hr>
        
        <form action="memberReg.jsp" method="post" id="refForm">
        <table>
            <tr>
                <td>아이디(이메일)</td>
                <td><input type="text" name="id" id="uid"><br></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw" id="upw"><br></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="uname" id="uname"></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="uphoto" id="uphoto"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="등록"> <input type="reset"></td>
            </tr>
            
        
        </table>
        
         </form>
	</div>
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>