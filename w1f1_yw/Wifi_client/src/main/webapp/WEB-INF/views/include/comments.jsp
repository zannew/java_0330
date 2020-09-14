<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='//fonts.googleapis.com/css?family=PT+Sans:400,700&subset=cyrillic' rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<br><br><br>

	<div class="commentArea">
	</div>
	<br>

	<div class="wrap">
  		<a href="javascript:openRegForm();" class="button" style="position:relative; display:block;">댓글쓰기</a>
	</div>
	
	<br><br><br><br><br>

	<div class="commentRegArea" id="commentRegArea">
		<h4 style="text-align:center; color:#424140;">댓글</h2>
		<form id="commentform" name="commentForm" onsubmit="return false;">
		  <div class="__cl-c-gap___">
		    <label class="__cl-c-form-label___" for="name" data-error="Please enter your name">작성자</label>
		    <input class="__cl-c-field___" type="text" id="name" name="name" value="${loginInfo.name}" readonly/>
		  </div>
		  <div class="__cl-c-gap___">
		    <label class="__cl-c-form-label___" for="midx" data-error="Please enter a valid midx"></label>
		    <input class="__cl-c-field___" type="hidden" id="midx" name="midx" value="${loginInfo.midx}"/>
		  </div>
		  <div class="__cl-c-gap___">
		    <label class="__cl-c-form-label___" for="iidx" data-error="Please enter a valid iidx"></label>
		    <input class="__cl-c-field___" type="hidden" id="iidx" name="iidx" value="${iidx}"/>
		  </div>
		  <div class="__cl-c-gap___">
		    <label class="__cl-c-form-label___" for="cidx" data-error="Please enter a valid cidx"></label>
		    <input class="__cl-c-field___" type="hidden" id="cidx" name="cidx" />
		  </div>
		  <div class="__cl-c-gap___">
		    <label class="__cl-c-form-label___" for="content" data-error="Please enter comment (min. length 10)">댓글을 남겨주세요</label>
		    <textarea class="__cl-c-field___" id="content" name="content"></textarea>
		  </div>
		  <div class="__cl-c-gap___">
		    <button class="__cl-c-btn___" id="submit_button" type="submit" data-send="Сообщение отправлено" onclick="regComment();">확인</button>
		  </div>
		  <div class="__cl-c-gap___">
		    <button class="__cl-c-btn___" id="edit_submit_button" type="submit" data-send="Сообщение отправлено" onclick="editComment();">수정</button>
		  </div>
		</form>
	</div>

	

<script>
	//var commentUrl='http://localhost:8080/comment/comments';


	


$(document).ready(
		
	
		
		
	/* function () {
	   var validateParams = {
	    rules: {
	      author: "required",
	      subject: "required",
	      comment: {
	        required: true,
	        minlength: 10
	      },
	      email: {
	        required: true,
	        email: true
	      }
	    },
	    messages: {
	      author: $('[for="author"]').data('error'),
	      comment: $('[for="comment"]').data('error'),
	      email: $('[for="email"]').data('error'),
	      subject: $('[for="subject"]').data('error'),
	    },
	    submitHandler: function submitHandler(form) {
	      var loader = '<div class="c-loader" style="margin-top: 20px"></div>';
	      $('#form-message').remove();
	      $('.wpcf7-form').append(loader);
	      $('#commentform').append(loader);

	      setTimeout(function () {
	        $('.c-loader').remove();
	        
	        $('.wpcf7-form [name]').val('');
	        $('#commentform [name]').val('');

	        var message = '<div id="form-message" style="display: block; text-align: left; margin-top: 15px">' + $('#submit_button').data('send') + '</div>';

	        if ($('#form-message').length === 0) {
	          $('.wpcf7-form').append(message);
	          $('#commentform').append(message);
	        }
	      }, 1000);
	    }
	  }; */
	 // $(".wpcf7-form").validate(validateParams); // привязка для контактной формы
	 // $("#commentform").validate(validateParams); // привязка для формы комментов
	//}
	);
</script>

</body>
</html>

