<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String pw = request.getParameter("pw");
	int mid = Integer.parseInt(request.getParameter("mid"));
	
	// MessageDeleteService 
	//	→ dao.selectMessage(mid); 게시물 존재여부 확인하고 패스워드 일치 확인 후
	//	→ dao.deleteMessage();	
	
	DeleteMessageService service = DeleteMessageService.getInstance();
	int resultCnt = service.deleteMessage(mid, pw);
	
	// 메시징 다르게 처리
	request.setAttribute("statusCode", resultCnt);
	
	
	

%>


<jsp:forward page="deleteMessage_view.jsp"/>