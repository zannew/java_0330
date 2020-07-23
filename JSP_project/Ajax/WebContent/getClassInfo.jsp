<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	
	#classListArea {
		background-color: yellow;
		width : 50%;
		height : 100px;
		float: left;
	}
	
	
	#courseCart {
		clear: both;
		background-color: grey;
		width : 50%;
		height : 100px;
		float: left;
	}
	
	div.classList {
	border: 1px solid;
	width: 100%;
	height: 200%
	float: left;
	}
	
	table>tbody>tr>td {
	border: 1px solid;
	width: 40px;
	height:15px;
	}
	

</style>
</head>
<body>

	<div id="wrap">
		<div id="classListArea">
			
		</div>
		<div id="detailArea">
		</div>
		
		
	</div>
	
	
	<div id="courseCart">
		
	
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
		
		$('#detailArea').css('display', 'block');
		
		$('#classListArea'+cIdx+'').animate({
			//width: '50%',
			height: '200px'
		}, 1500);
		
		$.getJSON('new_data_json.jsp', function(data){
			
			$.each(data, function(key, value){
				if(value.idx==cIdx){
					$('#classListArea'+cIdx+'').append('<div id="contents">강의 내용 : '+JSON.stringify(value.contents)+'</div>');
				}
			})
			
			
		});
		
		
		
		/* $.ajax({ 
			
			url: 'new_data_json.jsp',
			type: 'GET',
			data: {idx: cIdx},
			//dataType: 'json',
			//contentType: 'application/json',
			/* success: function(data){
				var param2 = $(data).serializeArray();
			[0]은 idx, [1]은 time, [2]는 cName, [3]은 cRoom, [4]는 세부내용
			$('#details').html(param2[4].value); */
 			/* success: function(data) {
			    var e = $(data).find('contents');
			    $('#details').append(JSON.stringify(e));
				alert("e : "+e);
			} */
			
			/* success: function(data) {
				alert("json : "+JSON.stringify(data));
			   $(data).each(data, function(key, value){
				   var contents = $(data).find('contents').text();
				   
				   $('#details').append('<div>강의 내용 : '+JSON.stringify(contents)+'</div>');
			   })
			}
			
			//alert('param2 : '+param2);
			//}
			
			
			$.each(data, function(key, value){
				
				$('body').append('<h1>제품 : '+value.name+', 가격 : '+value.price+'</h1>');		
				
			});
				
		});	 */
		
		alert('cIdx : '+cIdx);
		toggle=true;
		
	}
	
	function hideDetail(cIdx){
		
		$('#wrap').on('click','#close', function(){
			
			$('div.classList').animate({
				//width: '50%',
				height: '100px'
			});
		});
		
		$('#detailArea').css('display', 'none');
		$('#contents').remove();
	}
	
	
	 
	
	function addCart(cIdx, sIdx, cTime, cName, cRoom){
				//경로 : 내가 받아올 데이터가 있는 경로
				//받아온 내용들 args로 받아서 선택한 강의 리스트에 showoff (굳이 ajax안함)
			 	/* $.getJSON('new_data_json.jsp', function(data){
			 		
			 		$.each(data, function(key, value){
			 			if(value.idx==cIdx){
			 				
			 			var str1='';
			 			str1+='	<span>강의 번호 : '+ value.idx+'</span>';
			 			str1+='	<span>강의명 : '+ value.cName+'</span>';
			 			str1+='	<span>강의실 : '+ value.cRoom+'</span>';
			 				
			 			alert(str1);
							$('#courseCart').append(str1); 
			 			}
			 		})
			 	}) */
			 	
			 	var str='';
				str+='<div>';
				str+='강의번호 : '+cIdx;
				str+='강의명 : '+cName;
				str+='강의실 : '+cRoom;
				str+='</div>';
			 	
			 	$('#courseCart').append(str);
			 	
			 
			//+클릭하면 바로 db에 mycourse에 저장(cidx, sidx)	 
			//경로 : 보낼 경로
			/* $.ajax({
				
				url : 'courseList.do',
				type: 'post',
				data: { sIdx: sIdx,
						cIdx: cIdx },
				dataType: 'text',
				success: 
					alert("강의가 리스트에 저장되었습니다.")
						
			}) */
			 
	}
	
	function removeCart(cIdx){
		
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		
		$.ajax({
			 url : ''
			
		})		
		
		
	}
	
	
	/*//[4]삭제 버튼을 클릭했을 때 작동되는 함수
			$(document).on('click','.delete',function(){
			
			var id = $(this).attr("id");
			if(confirm("삭제 하시겠습니까?"))
			{
			//구분자
			var action = "delete";
			$.ajax({
			url:"action.php",
			method:"POST",
			data:{id:id,action:action},
			success:function(data){
			//리스트 다시 조회
			fetchUser();
			alert(data);
			}
			});
			}else
			{
			return false;
			}
			
			});

*/
	
	


	$(document).ready(function() {
		
		alert('jqeury');
		
		var sIdx = 1;
		
		
		 $.getJSON('new_data_json.jsp', function(data){
			//data와 각각 어떻게 처리할지 함수 정의
			$.each(data, function(key, value){
				
				var cIdx = value.idx;
				var cTime = value.time;
				var cRoom = value.cRoom;
				var cName = value.cName;
				var contents = value.contents;

				var classParam="classList"+cIdx;
				alert("clasNAme : "+classParam);
				var addStr1='<div class="'+classParam+'"';
				addStr1+=' id="classListArea';
				addStr1+=cIdx;
				addStr1+='">';
				addStr1+='<div> 강의 번호 : '+cIdx;
				addStr1+='강의 시간 : '+cTime;
				addStr1+='강의명 : '+cName+'</div>';
				addStr1+='';
				addStr1+='';
				addStr1+='<input type="button" value="자세히보기" id="open';
				//addStr1+=idx;
				addStr1+='" onclick="showDetail(\'';
				addStr1+=cIdx;
				addStr1+='\')">';
				//alert(addStr1);
				var addStr2='<input type="button" value="닫기" id="close';
				//addStr2+=idx;
				addStr2+='" onclick="hideDetail(\'';
				addStr2+=cIdx;
				addStr2+='\')">';
				addStr2+='<input type="image" src="/plusIcon.png" alt="추가" onclick="addCart(\'';
				addStr2+=cIdx, sIdx, cTime, cName, cRoom;
				addStr2+='\')">';
				addStr2+='<input type="image" src="/minusIcon.png" alt="빼기" onclick="removeCart(\'';
				addStr2+=sIdx;
				addStr2+='\')">';
				addStr2+='</div>';
				//alert(addStr);
				
				$('#classListArea').append(
						/* +'<span>'+value.cRoom+'</span>' */
						/* +'<div>'+value.contents+'</div>' */
						addStr1+addStr2);
				
				/*<input type="image" src="/examples/images/submit_icon.png" alt="제출버튼">*/
				
			});
			
			
		});
		 

	});
	
	
</script>