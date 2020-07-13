<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:import url="/include/header.jsp"/>
	
	<div>
		<h1>회원 가입</h1>
		
        <hr>
        
        <form action="memberReg.jsp" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디(이메일)</td>
                <td><input type="text" name="mid" id="mid"><br></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="mpw" id="mpw"><br></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="mname" id="mname"></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="mphoto" id="mphoto"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="등록"> <input type="reset"></td>
            </tr>
            
        
        </table>
        
         </form>
	</div>
	
	<c:import url="/include/footer.jsp"/>
</body>
</html>