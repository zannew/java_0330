<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<link rel="stylesheet"  href="<%= request.getContextPath() %>/CSS/default.css">
<style>
	 body, div, h1, form {
                
                margin:0;
                padding:0;
            }
            
            h1{
                margin: 15px;
            }
            
            #form{
                margin: 10px auto;
            }
            
            td{
                padding: 10px;
            }
            
            #btn_submit{
                padding: 5px;
                background-color: bisque;
                font-weight: bold;
                color: chocolate;
                border: 1px solid #EEEEEE;
            }
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	
	
	<div>
		<h1>로그인</h1>
		
		<hr>
        
        <form action="#" method="post" id="loginform"> 
        <table id="form">
            <tr>
                <td>아이디(이메일)</td>
                <td><input type="text" name="id" id="id"><br></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw" id="pw"><br></td>
            </tr>
            <tr>
                <td>아이디 저장</td>
                <td><input type="checkbox" name="checkbox_id" id="checkbox_id" value="checked"></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="btn_submit"type="submit" value="로그인"></td>
            </tr>
            
        
        </table>
        
         </form>
	</div>
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>