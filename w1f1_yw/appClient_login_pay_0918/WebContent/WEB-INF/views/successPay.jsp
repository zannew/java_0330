<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>

	$(document).ready(function(){
		
		setPayment();
		
	});
	
	function setPayment() {
		opener.document.getElementById("setPayInfo").value = document.getElementById("payInfo").value
	}
</script>
</head>
<body>
	<!-- 김승연 2020. 09. 18 추가 -->
	<!-- 결제 영수증을 위한 페이지 -->
	<!-- css 추가할 예정 -->
	<h1> 결제 확인 창 </h1>
	<h3> 결제 성공! </h3>
	<h3>결제 코드 : ${successPay.tid}</h3>
	<h3>가맹점 번호 : ${successPay.partner_order_id}</h3>
	<h3>가맹 회원 : ${successPay.partner_user_id}</h3>
	<h3>상품명 : ${successPay.item_name} <input type="text" value="결제 완료" id="payInfo" style="display:none" readonly/></h3>
	<h3>결제 금액 : ${successPay.amount.total}</h3>
	<h3>결제 요청 날짜 : ${successPay.created_at}</h3>
	<h3>결제 승인 날짜 : ${successPay.approved_at}</h3>
	
	<br>
	<input id="close" type="button" value="결제창 닫기" onclick="window.close();"/>	
</body>
</html>