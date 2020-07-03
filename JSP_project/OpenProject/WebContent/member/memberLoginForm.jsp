<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
	CookieBox cookieBox = new CookieBox(request);
	String cookieId = cookieBox.getValue("id");
	
	
	//저장된 값 여부 확인
	String savedId = "";
	String checked="";
	
	if(cookieId!=null){
		savedId=cookieId;
		checked="checked";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project - 회원 가입 페이지 로그인 폼</title>
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
	
		<%
		/*  String idValue=cookieBox.getValue("id");
		String savedId="";
		if(idValue!=null){
			savedId = idValue;
		}else{
			savedId = "";
			
		} */
		
/* 		String chkId=(String)session.getAttribute("id"); 
 */		
		/* String checked = "";
		if(request.getParameter("checkbox_id").equals("checked")){
			response.addCookie(CookieBox.createCookie("id", request.getParameter("id"),"/OP/member", 60*60));
			checked="checked";
		}else{
			response.addCookie(CookieBox.createCookie("id", "", "/OP/member", 0));
		} */
	%>
	
	<div>
		<h1>로그인</h1>
		
		<hr>
        
        <form action="memberLogin.jsp" method="post" id="loginform"> 
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
                <td>이름</td>
                <td><input type="text" name="name" id="name"><br></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" id="email"><br></td>
            </tr>
            <tr>
                <td>아이디 저장</td>
                <td><input type="checkbox" name="checkbox_id" id="checkbox_id" <%= checked %>></td>
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