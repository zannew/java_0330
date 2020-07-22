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

	<div id="wrap">
			<div id="details">
		</div>
		
	</div>
	
	
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
	<!-- <input type="button" value="자세히보기" id="open"><input type="button" value="닫기" id="close"> -->
	


</body>
</html>
<script>


	function test(idx){
		alert("test");		
	}
	
	var toggle=false;
	
	function showDetail(cIdx){
		
		$('#details').css('display', 'block');
		
		$('#classList').animate({
			width: '50%',
			height: '300px'
		}, 1500);
		
		$.ajax({ 
			
			url: 'new_data_json.jsp',
			type: 'GET',
			data: {idx: cIdx},
			dataType: 'json',
			contentType: 'application/json',
			success: function(data){
				var param2 = $(data).serializeArray();
			//[0]은 name, [1]은 price
			$('#details').text(param2[4].value);
/* 			success: function(data) {
			    var e = $(data).find('idx').find('contents');
			    $('#details').html(JSON.stringify(e));
				alert("e : "+e);
			} */
			
			alert('param2 : '+param2);
			}
				
		});	
		
		alert('cIdx : '+cIdx);
		toggle=true;
		
	}
	
	function hideDetail(idx){
		
		$('#wrap').on('click','#close', function(){
			
			$('#classList').animate({
				width: '50%',
				height: '100px'
			});
			
		});
		
		$('#details').css('display', 'none');
		
		
		
				
	}



	$(document).ready(function() {
		
		 $.getJSON('new_data_json.jsp', function(data){
			//data와 각각 어떻게 처리할지 함수 정의
			$.each(data, function(key, value){
				
				var idx = value.idx;
				var addStr1='<div id="classList">'; 
				addStr1+='<input type="button" value="자세히보기" id="open';
				//addStr1+=idx;
				addStr1+='" onclick="showDetail(\'';
				addStr1+=idx;
				addStr1+='\')">';
				addStr1+='</div>';
				alert(addStr1);
				var addStr2='<input type="button" value="닫기" id="close';
				//addStr2+=idx;
				addStr2+='" onclick="hideDetail(\'';
				addStr2+=idx;
				addStr2+='\')">';
				//alert(addStr);
				$('#wrap').append('<div>'+value.idx+'</div>'
						+'<div>'+value.time+'</div>'
						+'<div>'+value.cName+'</div>'
						/* +'<span>'+value.cRoom+'</span>' */
						/* +'<div>'+value.contents+'</div>' */
						+addStr1
						+addStr2);
				
				
				
								
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
		 
		$('#wrap').on('click','#open', function(){
			
			$('#classList').animate({
				width: '50%',
				height: '300px'
			});
		});
		
		$('#wrap').on('click','#close', function(){
			
			$('#classList').animate({
				width: '50%',
				height: '100px'
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
	
	
	
	
	
	window.onload= function(){
		
		var openBtn = document.getElementById('open');
		var closeBtn =  document.getElementById('close');
		var classList = document.getElementById('classList');
		
		openBtn.onclick = function(){
			
			document.getElementById("classList").style.backgroundColor="red";
			
		}
		
		closeBtn.onclick = function(){
			
			document.getElementById("classList").style.backgroundColor="yellow";
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>