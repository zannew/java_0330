<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* Cookie[] cookies = request.getCookies(); */
	CookieBox cookieBox = new CookieBox(request);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewCookie</title>
</head>
<body>
	<h1>쿠키 정보</h1>
	<div> id = <%= cookieBox.getValue("id") %></div>
	아이디를 저장합니다.
	
	
	<%
		/* cookies배열이 null이 아니고 0보다 큰지 체크 */
		/* 	if(cookies!=null && cookies.length>0){		
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("uid")){
					out.println("<div>"+cookies[i].getName()+" = "+cookies[i].getValue()+"</div>");
				}
			}
		} */
	
	%>
	
	<a href="memberloginForm.jsp">로그인 화면으로 돌아가기</a>
	
	
</body>
</html>