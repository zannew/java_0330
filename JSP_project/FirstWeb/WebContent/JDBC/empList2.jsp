<%@page import="lms.service.EmpListService"%>
<%@page import="dao.EmpDAO"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="model.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList</title>
<style>
table {
	width: 80%;
}

table td {
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<%
		List<Emp> empList = EmpListService.getInstance().getEmpList();
		request.setAttribute("empList", empList);
	%>

	<jsp:forward page="empList_view.jsp" />


</body>
</html>