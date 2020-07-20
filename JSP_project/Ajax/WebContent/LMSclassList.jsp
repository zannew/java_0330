<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tableTest</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<div>
		<table style="border: 1px;" id="dynamicTable">
			<thead>
				<tr>
					<th>강의번호</th>
					<th>시간</th>
					<th>과목명</th>
					<th>강의장소</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<th>09:30</th>
					<th>4차산업혁명</th>
					<th>A403</th>
				</tr>
				<tr>
					<th>2</th>
					<th>11:00</th>
					<th>음악사</th>
					<th>B305</th>
				</tr>
				<tr>
					<th>3</th>
					<th>10:30</th>
					<th>음악이론</th>
					<th>A402</th>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<button onclick="tableCreate()">강의 추가</button>
	</div>
	
	<div>
		<table style="border: 1px;" id="dynamicTable">
			<thead>
				<tr>
					<th>강의번호</th>
					<th>시간</th>
					<th>과목명</th>
					<th>강의장소</th>
				</tr>
			</thead>
			<tbody id="dynamicTbody">

			</tbody>
		</table>
	</div>


</body>
</html>
<script>

	function tableCreate() {

		$.ajax({

			url : "testTable.jsp",
			success : function(data) {
				var html = '';

				for (key in data) {
					html += '<tr>';
					html += '<td>' + data[key].idx + '</td>';
					html += '<td>' + data[key].startTime + '</td>';
					html += '<td>' + data[key].className + '</td>';
					html += '<td>' + data[key].classRoom + '</td>';
					html += '</tr>';
				}

				$("#dynamicTbody").empty();
				$("#dynamicTbody").append(html);

			}
		})
	}
</script>




