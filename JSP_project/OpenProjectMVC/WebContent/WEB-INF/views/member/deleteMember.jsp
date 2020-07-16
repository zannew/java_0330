<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

	function check(){
		
		if(confirm('삭제하시겠습니까?')){
			return true;
			
			location.href = "<c:url value="/member/memberList.do"/>";
		}
		
		return false;
	}
	

	

</script>

<jsp:forward page="deleteMemberConfirm.do"/>















