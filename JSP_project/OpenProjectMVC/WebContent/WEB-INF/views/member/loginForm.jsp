<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
		
		
		<div>
			<h1 class="subtitle">회원가입</h1>
			
			<hr>
			
			<form action="login.jsp" method="post">
			
				<input type="text" name="redirecUri" 
				
				value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >			
				
				
				<table class="table">
					<tr>
						<td> ID </td>
						<td> <input type="text" name="uid" value="<%= uidValue%>"> </td>
					</tr>
					<tr>
						<td> PW </td>
						<td> <input type="password" name="pw"> </td>
					</tr>				
					<tr>
						<td></td>
						<td> <input type="checkbox" name="remember" value="r" <%= checked %> > 아이디 기억하기  </td>
					</tr>
					<tr>
						<td colspan="2"> <input type="submit" value="로그인"> </td>
					</tr>
				</table>
			
			</form>
			
			
		</div>
		
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>