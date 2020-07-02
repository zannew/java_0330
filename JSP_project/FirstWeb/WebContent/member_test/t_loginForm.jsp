<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	CookieBox cookieBox = new CookieBox(request);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 - 아이디저장</title>
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

	<%
		String savedId="";
		if(cookieBox.getValue("id")!=null){
			savedId = cookieBox.getValue("id");
		}else{
			savedId = "";
			
		}
	%>

	 <h1>회원 로그인</h1>
        <hr>
        
        <form action="t_makeCookie.jsp" method="post" id="loginform"> 
        <table id="form">
            <tr>
                <td>아이디(이메일)</td>
                <td><input type="text" name="id" id="id" value="<%= savedId %>"><br></td>
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


</body>
</html>

<!-- <script src="../JS/login_check.js"></script> -->