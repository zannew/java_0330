<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	
	#classList {
		background-color: yellow;
		width : 50%;
		height : 100px;
		float: left;
	}
	
	table>tbody>tr>td {
	border: 1px solid;
	padding: 0;
	width: 40px;
	height:15px;
	}
	

</style>
</head>
<body>

	<div id="classList"></div>
	
	<form>
		<table>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		
	</form>
	
	
	<input type="button" value="자세히보기" id="open"><input type="button" value="닫기" id="close">
	
	
	


</body>
</html>
<script>

	$(document).ready(function() {
		
		 $.getJSON('new_data_json.jsp', function(data){
			//data와 각각 어떻게 처리할지 함수 정의
			$.each(data, function(key, value){
				
				$('#classList').append('<span>'+value.idx+'</span>'
										+'<span>'+value.time+'</span>'
										+'<span>'+value.cName+'</span>'
										+'<div>'+value.cRoom+'</div>'
										/* +'<span>'+value.day+'</span>'
										+'<span>'+value.startTime+'</span>'
										+'<span>'+value.endTime+'</span>'
										+'<span>'+value.totalPer+'</span>'
										+'<span>'+value.applyPer+'</span>'
										+'<span>'+value.tIdx+'</span>' */
										+'<input type='+"button"+' value='+"자세히보기"+' id='+"open"+'>'
										+'<input type='+"button"+' value='+"닫기"+' id='+"close"+'>'); 				
				//$('body').append('<h1>제품 : '+value.name+', 가격 : '+value.price+'</h1>');		
				
			});
			
		});
		 /*$("p").on({ 
			  click: function() {
			    $("div").append("마우스가 문장을 클릭했습니다.<br>");
			  },
			  mouseenter: function() {
			    $("div").append("마우스가 커서가 문장 위로 들어왔습니다.<br>");
			  },
			  mouseleave: function() {
			    $("div").append("마우스가 커서가 문장을 빠져 나갔습니다.<br>");
			  }
			});*/
		 
		
		/* $('#open').on({
				click: function(){
					$('#classList').animate({width : '50%',	height : '300px'});
				
				});
			
		$('#close').on(
				click: function(){
					$('#classList').animate({width: '50%', height: '100px'});
				}
		}); */
		$('#open').click(function() {
			$('#classList').animate({
				width : '50%',
				height : '300px'
			});
		});
		$('#close').click(function() {
			$('#classList').animate({
				width : '50%',
				height : '100px'
			});
		});
		

	 	/* $.getJSON('new_data_json.jsp', function() {

			html = '';

			for (key in data) {

				html += '	<div>';
				html += '		<div>' + data[key].idx + '</div>';
				html += '		<div>' + data[key].time + '</div>';
				html += '		<div>' + data[key].cName + '</div>';
				html += '		<div>' + data[key].cRoom + '</div>';
				html += '	</div>';

				//$('body').empty();
				//$('body').html(html);
				
				$('#classListBody').empty();
				$('#classListBody').html(html);
			}

		}); */

	});
</script>