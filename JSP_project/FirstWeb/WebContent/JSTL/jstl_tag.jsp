<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setAttribute("price", 10000);

	request.setAttribute("now", new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL tag</title>
</head>
<body>

	<h3>

	▷ 날짜 표현<br>
	<fmt:formatDate value="${now}"/><br>
	기본타입 : <fmt:formatDate value="${now}" type="date"/><br>
	스타일(short) : <fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	스타일(full) : <fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	<br>
	
	▷ 시간 표현<br>
	기본타입 : <fmt:formatDate value="${now}" type="time"/><br>
	스타일(short) : <fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
	스타일(full) : <fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
	<br>
	
	▷ 날짜와 시간 동시표현<br>
	기본타입 : <fmt:formatDate value="${now}" type="both"/><br>
	스타일(full) : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	스타일(short) : <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
	<br>
	
	■ 날짜 포맷팅 - pattern <br>
	<fmt:timeZone value="Africa/El_Aaiun">
	
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss"/><br>
	<fmt:formatDate value="${now}" pattern="yy.MM.dd H:mm"/><br>
	
	</fmt:timeZone>


	<hr>
	숫자 타입 : <fmt:formatNumber value="${price}" type="number"/>,
	<fmt:formatNumber value="${price}" type="number" var="numberType"/>
	${numberType}
	<br>

	통화 : <fmt:formatNumber value="${price}" type="currency"/>,
	<fmt:formatNumber value="${price}" type="currency" currencySymbol="$"/>
	<br>

	퍼센트 : <fmt:formatNumber value="${price/30000}" type="percent"/>,
	<fmt:formatNumber value="${price/30000}" type="percent" groupingUsed="false"/>
	<br>

	패턴 : <fmt:formatNumber value="${price}" pattern="000000.00"/>,	
	<fmt:formatNumber value="${price}" pattern="000,000"/>	
	
	</h3>
	
	
	<hr>
	<c:out value="jstl tag out → 데이터를 출력합니다."/>
	<br><br>
	<c:out value="${members[7].email}" default="<i>이메일 없음</i>" escapeXml="false"/>
	<br><br>
	<c:out value="${members[8].email}" escapeXml="false">
		<span style="color:red">이메일 없음!</span>
	</c:out>
	
	<c:if test="${members[8].email == null}">
		<span style="color:blue">이메일 없음!</span>
	</c:if>

	<c:forEach items="${applicationScope.members}" 
				var="member"
				varStatus="status">
		<h3>
		
		${status.index+1}) ${status.count}개
		
		이름 : ${member.name}, 이메일 : 
		<c:out value="${member.email}" escapeXml="false">
			<span style="color:red">이메일음슴</span>
		</c:out> 
			
		<c:if test="${member.email == null}">
			<span style="color:blue">이메일 없음!</span>
		</c:if>
	
		<c:if test="${empty member.email}">
			<span style="color:green">이메일 없음!</span>
		</c:if>
		
		</h3>
	</c:forEach>
	
	<select name="year">
		<c:forEach var="year" begin="1950" end="2020" step="1">
			<option value="${year}" ${param.year==year?'selected':''}>${year}</option>
		</c:forEach>
	</select>
	<br>
	<c:forTokens items="손흥민, 010-1234-1234,런든" delims="," var="token">
		${token}<br>
	</c:forTokens>

	<h1>
		URL1 : <c:url value="/index.jsp" context="/web"/>
		<br>
		
		<a href="<c:url value="/index.jsp" context="/web"/>">홈</a>
		
		<br>
		URL2 : <c:url value="jstl_tag2.jsp">
			<c:param name="year" value="1999"/>
		</c:url>
		<br>
		URL3 : <c:url value="jstl_tag2.jsp?year=1999"/>
		<br>
		<c:url value="jstl_tag2.jsp?year=1999" var="reurl"/>
		URL4 : ${reurl}
	</h1>
	
	<h4>▶ context="경로"는 선택적 사용</h4>
	<h4>▶ var="reurl" : url값을 default로 저장함</h4>


	<%-- <c:redirect url="${reurl}">
		<c:param name="month">7</c:param>
	</c:redirect> --%>
	
	<c:forEach var="id" items="<%= java.util.TimeZone.getAvailableIDs() %>"> ${id}<br/> </c:forEach>



</body>
</html>