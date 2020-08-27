<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<style>

#commentList {
	overflow: hidden;
}

div.card1>ul>li {
	list-style: none;
	font-size: 12px;
}

#contentText {
	font-size: 32px;
}

#editForm{
	/* display: none; */
}

button.deleteImg {
  background : url("images/delete.png");
  position : right;
  border: none;
  width: 24px;
  height: 24px;
  cursor: pointer;
}

button.editImg {
  background : url("images/pencil.png");
  position : right;
  border: none;
  width: 24px;
  height: 24px;
  cursor: pointer;
}

input.form-control{
	width: 40%;
}

#cidx {
	width: 3%;
	display: none;
}

#editForm {
	display: none;
}

#container {

	padding: 50px;
	
}

</style>

<body>

<div id="container">
	<h3>댓글 리스트</h3>
	<div id="commentList"></div>
	<button class="btn btn-secondary">댓글 더보기</button>

	<form id="commentForm" onsubmit="return false;">
	<br>
		<h3>댓글 작성</h3>
		<input type="text" class="form-control" name="content" id="content" placeholder="댓글을 작성하세요">
		<div class="invalid-feedback" id="invalid-feedback"> 내용을 입력하세요 </div>
		<div class="valid-feedback" id="valid-feedback"> 댓글 등록 성공!</div>
		<button class="btn btn-primary" onclick="commentSubmit();">등록</button>
	</form>
	
	<form id="editForm" onsubmit="return false;">
	<br>
	<h3>댓글 수정</h3>
		<input type="text" class="form-control" name="cidx" id="cidx" readonly>
		<input type="text" class="form-control" name="content" id="econtent" placeholder="댓글을 수정하세요">
		<div class="invalid-feedback" id="invalid-feedback2"> 내용을 입력하세요 </div>
		<button class="btn btn-primary" onclick="editSubmit();">수정</button>
		<button class="btn btn-primary" onclick="editCancle();">취소</button>
	</form>

	<br>
	<div>
		<h3>남은 기능</h3>
		<p>더보기버튼 페이징처리</p>
		<!-- <p>수정 클릭 시 수정 시간 변경</p> -->
		<p>CSS 수정</p>
	</div>
</div>

<script>


	var domain = 'http://ec2-13-209-17-96.ap-northeast-2.compute.amazonaws.com:8080/wifiComment/comment';
	//var domain = 'http://localhost:8080/comment/comment'
	
	$(document).ready(function(){
	
		commentList();
		
	})

	$('ul.list-group-item').each(function(){
       var $ul = $(this),
           $lis = $ul.find('li:gt(2)'),
           isExpanded = $ul.hasClass('expanded');
       $lis[isExpanded ? 'show' : 'hide']();

       if($lis.length > 0){
           $ul
               .append($('<li class="expand"><span>' + (isExpanded ? 'Show Less' : 'Show More') + '</span></li>')
               .click(function(event){
                   var isExpanded = $ul.hasClass('expanded');
                   event.preventDefault();
                   $(this).text(isExpanded ? 'More' : 'Less');
                   $ul.toggleClass('expanded');
                   $lis.toggle();
               }));
       }
});
	
	//prependTo()를 사용해서 더보기 
	//$('.more').on('click', function(){
	//$('<p>추가내용<p>').prependTo('.last_li');	//여기다 데이터를 저장해서 불러오기(json)
	//});
	
	function commentSubmit(){
		
		var commentFormData = new FormData();
		
		if($('#content').val() == ""){
			$('#invalid-feedback').show(0).delay(2000).hide(500);
			$('#valid-feedback').hide();
		} else {
			commentFormData.append('content', $('#content').val());
			$('#invalid-feedback').hide();
			$('#valid-feedback').show(0).delay(2000).hide(500);
		}
		
			$.ajax({
				url: domain,
				type: 'POST',
				data: commentFormData,
				processData: false, // File 전송시 필수
				contentType: false, // multipart/form-data
				success: function(data){
					commentList();
					document.getElementById('commentForm').reset();
				}
				
			});
	}
	

	
	function commentList(){
		
		
		$.ajax({
			url: domain ,	
			type: 'GET',
			success: function(data){
				
				var html = '';
				var len = data.length;
				
				for(var i=0; i<len; i++){
					html += '<div class="card1">';
					html += '	<ul class="list-group-item">';	
					//html += '		<li>댓글번호 : '+data[i].cidx+'</li>';
					html += '		<li>작성자: '+data[i].midx+'</li>';
					html += '		<li id="date">'+data[i].regdate+'</li>';
					html += '		<br>';
					html += '		<li id="contentText">'+data[i].content;
					//html += '		<li>댓글상태 : '+data[i].state+'</li>';
					html += '		<button class="editImg" onclick="editForm('+data[i].cidx+')"></button>';
					html += '		<button class="deleteImg" onclick="deleteComment('+data[i].cidx+')"></button></li>';
					html += '	</ul>';
					html += '</div>';
				}
			$('#commentList').html(html);
				
			}
		});
		
	}
	

	function editForm(cidx){
		
		$('#commentForm').hide();
		$('#editForm').show();
		
		$.ajax({
			url : domain+'/'+cidx,
			type : 'GET',
			success : function(data){
				
				$('#cidx').val(data.cidx);
				$('#econtent').val(data.content);
				$('#econtent').focus();
				
			}
			
		});
	}
	
	function editSubmit(){

		var commentFormData = new FormData();
		
		if($('#econtent').val() == ""){
			$('#invalid-feedback2').show().delay(2000).hide(500);
		} else {
			commentFormData.append('content', $('#econtent').val());
			// $('#date').replaceWith('<li>ggg</li>')
			$('#invalid-feedback2').hide();
			$('#editForm').hide(500);
			$('#commentForm').delay(700).show(500);
		}
		
		
		$.ajax({
			url : domain+'/'+$('#cidx').val(),
			type : 'POST',
			processData: false, // File 전송시 필수
			contentType: false, // multipart/form-data
			data : commentFormData,
			success : function(data){
				commentList();
				document.getElementById('editForm').reset();
			}
		});

	}

	function editCancle(){
		$('#editForm').hide();
		$('#commentForm').show();
	}
	
	
	function deleteComment(cidx){
		
		if(confirm('정말 삭제하시겠습니까?')){
			
			$.ajax({
				url : domain+'/'+cidx,
				type : 'DELETE',
				success : function(data){
					commentList();
				}
			});
		}
	}
	
	
	


</script>

</body>
</html>