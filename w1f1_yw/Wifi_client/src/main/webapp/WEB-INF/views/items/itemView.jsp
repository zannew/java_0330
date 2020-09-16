<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/default.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/aside.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/itemView.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/comments.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
      p { 
          margin:20px 0px; 
        }
        div.card {
            width: 150px;
            height: 200px;
        }
        
        div.itemView {
            border: 1px solid;
            margin: 15% 10%;
        }
        
        div.view_wrap {
            border: 1px solid;
            background-color: yellow;
            width: 25%;
            height: 40%;
            float: left;
            margin: 0 3%;
        }
        
        
        
        
    
    </style>
</head>
<body>

<c:url value="/" var="url"/>

<%-- <img class="main_image container" src="${url}resources/images/pexels-bach-hanzo-3551355.jpg"/> --%>

<%-- <%@ include file="/WEB-INF/views/include/background.jsp" %> --%>
<%@ include file="/WEB-INF/views/include/aside.jsp" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


<h1> itemView 페이지</h1>

<br>
<br>

<div class="itemView">
      
        <div class="view_wrap photo" id="">
        	
        </div>
        <div class="view_wrap details">
        	<div id="itemDetails" style="float:left;"></div><br><br>
        	<div id="map" style="width:300px;height:300px; float:left;"></div> 
        </div>
        <div class="view_wrap comments">
        	<%@ include file="/WEB-INF/views/include/comments.jsp" %>
        </div>
        
        
</div>
<br>
<br>
<div id="itemDetails" style="float:left;"></div>
<br>

<div id="map" style="width:300px;height:300px; float:left;"></div> 
<br>

<%@ include file="/WEB-INF/views/include/comments.jsp" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c35fdaa3a50bc0c680e435eb402d8491"></script>

<script>
	var mainItemUrl ='http://localhost:8080/order/items';
	var mainOrderUrl ='http://localhost:8080/order/orders';
	var imgUrl = 'http://localhost:8080/order/upload/';
	var commentUrl='http://localhost:8080/comment/comments';
	
	var location_y=0.0;
	var location_x=0.0;
	
	var pageNum = 1;


	function showDetails(iidx){
	
		var html = '';
		
		$.ajax({
			
			url : mainItemUrl+'/'+iidx,
			type : 'GET',
			success : function(data){
				//alert('상세보기의 결과 데이터 : '+data);
				location_y=data.location_y;
				location_x=data.location_x;
				 html += '<br><h2> [ 공구 상세 ] </h2>';
				 html+='			<img src="'+imgUrl+data.photo+'" alt="" class="" style="float:left; width:50%; height:50%;"/>';
				 //html += '<br>공구글번호 : '+data.iidx;
				 html += '<br><span class="title">'+data.title+'</span>';
				 html += '<br><span class="price">￦'+data.price.toLocaleString()+'</span>';
				 html += '<br>모집인원 : '+data.count_m;
				 html += '<br>요청 남은 자리 : '+data.count_w;
				 html += '<br>등록일 : '+moment(data.regdate).format('YYYY-MM-DD');
				 html += '<br>수령날짜 : '+moment(data.receive).format('YYYY-MM-DD HH:mm')+' 까지';
				 html += '<br>판매처 : '+data.addr;
				 html += '<br>판매처좌표 : '+location_y+':'+location_x;
				 //html += '<br><div id="map" style="width:100%;height:350px;"></div>';
				 html += '<br>내용 : '+data.content;
				 html += '<br>사진 : '+data.photo;
				 html += '<br>공구상태값 : '+data.state;
				 html += '<br>조회수 : '+data.view_count;
				 html += '<br>상품분류 : '+data.category;
				 html += '<br>게시자idx : '+data.midx+'<br><br>';
				 
				 if(${loginInfo.midx}!=data.midx){
					 
					 html += '<button class="" onclick="itemRequest('+data.iidx+','+data.count_w +');">신청</button>';
				 }
				 html += '<button class="" onclick="closeInfo();">닫기</button>';
	
				 // 기간 만료 체크용
				 if(new Date(data.receive) < new Date()){
					 console.log('new Date(data.receive) : '+new Date(data.receive));
				 }
				 
				 html += '';
				 document.getElementById('itemDetails').style.display='block';
				 $('#itemDetails').html(html);
				 
				 console.log('data.receive는 '+data.receive);
				 
				 getMap(location_y, location_x);
				 
				 
			},
			error : function(data){
				alert(data);
				alert('상세보기실패');
			}
		});
			
	}
	
/*지도에 마커표시 */

	//지도를 표시할 div
	function getMap(location_y, location_x){
		var mapContainer = document.getElementById('map'),  
		 mapOption = { 
		     center: new kakao.maps.LatLng(location_y, location_x), // 지도의 중심좌표
		     level: 4 // 지도의 확대 레벨
		 };
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
		 imageSize = new kakao.maps.Size(54, 59), // 마커이미지의 크기입니다
		 imageOption = {offset: new kakao.maps.Point(17, 59)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		   
		//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage("${url}resources/images/marker.png", imageSize, imageOption),
		 markerPosition = new kakao.maps.LatLng(location_y, location_x); // 마커가 표시될 위치입니다
		
		//마커를 생성합니다
		var marker = new kakao.maps.Marker({
		 position: markerPosition, 
		 image: markerImage // 마커이미지 설정 
		});
		
		 marker.setImage(markerImage);
		//마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);  
		
	
	}
	
/*지도에 마커표시 - end*/	
	
	// 공구 요청 - 대기인원 우선체크
	function itemRequest(iidx, count_w){
		
		$.ajax({
			url: mainOrderUrl+'/'+iidx,
			type : 'GET',
			success : function(data){
				if(data<=0){
					alert('대기 요청이 마감되어 더이상 요청을 보낼 수 없습니다.');
				} else {
					if(confirm('요청을 진행하시겠습니까?')){
						sendRequest();
					}else {
						return false;
					}
				}
				
			},
			error : function(data){
				alert('대기인원 체크 실패!');
			}
		});
		
	}
	
	// 공구 요청 - 대기 열려있을 시, 요청 보내기
	function sendRequest(){
		$.ajax({
			url: mainOrderUrl,
			type:'POST',
			data : {
				'midx': ${loginInfo.midx},
				'iidx': ${iidx}
			},
			success: function(data){
				alert('성공적으로 요청을 완료하였습니다.')
			},
			error: function(data){
				alert('요청에 실패하였습니다.');
			}
			
		});
	}
	
	function regComment(){
			
			var regCommentData = new FormData();
			regCommentData.append('content', $('#content').val());
			regCommentData.append('midx', $('#midx').val());
			regCommentData.append('name', $('#name').val());
			regCommentData.append('iidx', $('#iidx').val());
			
			$.ajax({
				url: commentUrl,
				type: 'POST',
				dataType: 'JSON',
				contentType: false,
				processData: false,
				data: regCommentData,
				success : function(data){
					alert(data+" - 댓글 등록 완료!");
					pageNum=1;
					getCommentList(${iidx});
					
				}, error: function(data){
					alert("댓글 등록 실패");
				}
				
			});
	}

	function getCommentList(iidx){
		
		var html = '';
		 $('div.commentArea').html(html);
		
		$.ajax({
			url : commentUrl,
			data : {
				'iidx' : iidx,
				'page' : pageNum
			},
			type:'GET',
			success : function(data){
				
				console.log('댓글 리스트 success');
				console.log('댓글 data :'+data.commentList);
				
				
				
				for(var i=0;i<data.commentList.length;i++){
					
					if(data.commentList[i].state==0){
						html+='<div class="comment">';	
						html+='	<div class="comment-avatar"></div>';	
						html+='		<div class="comment-author">'+replaceAt(data.commentList[i].name, 1, '*')+'</div>';	
						html+='			<div class="comment-text">'+data.commentList[i].content;	
						html+='				<div class="comment-date">'+moment(data.commentList[i].updated).format('YY.MM.DD HH:mm');
						if(data.commentList[i].midx==${loginInfo.midx}){
							html+='					<img onClick="deleteComment('+data.commentList[i].cidx+');" src="${url}resources/images/bin_icon.png"/ style="cursor:pointer; width:20px; height:20px;">';
							html+='					<img onClick="editForm('+data.commentList[i].cidx+', \''+data.commentList[i].content+'\');" src="${url}resources/images/edit_icon.png"/ style="cursor:pointer; width:12px; height:12px;">';
						}
						html+='				</div>';	
						html+='			</div>';	
						html+='			<a href="#reply" title="Ответить" class="comment-reply"></a>';	
						html+='</div>';
						}
					}
					$('div.commentArea').append(html);
					pageNum++;
			}, 
			error : function(data){
				
				console.log('댓글 리스트 failed');
			}
			
			
		});
	}

	function deleteComment(cidx){
		
		$.ajax({
			url: commentUrl+'/'+cidx,
			type: 'DELETE',
			success: function(data){
				alert('삭제-상태값변경 성공');
				pageNum=1;
				getCommentList(${iidx});
				//getCommentList($('#iidx').val());
				
			},
			error: function(data){
				alert('삭제-상태값변경 실패');
				
			}
		});
		
	}
	
	function editForm(cidx, content){
		
		//$("#submit_button").removeAttr("onclick");
		//$("#submit_button").attr("onclick", "");
		
		$('#edit_submit_button').css('display', 'block');
		$('#submit_button').css('display', 'none');

		/* if(document.getElementById('edit_submit_button').style.display=='none'){
			document.getElementById('edit_submit_button').style.display='block';
			document.getElementById('submit_button').style.display='none';
		}else {
			document.getElementById('submit_button').style.display='none';
		} */
		
		if(document.getElementById('commentRegArea').style.display=='block'){
			document.getElementById('commentRegArea').style.display='none';
			document.getElementById('commentRegArea').style.display='block';
		}else {
			document.getElementById('commentRegArea').style.display='block';
		}
		
		document.getElementById('cidx').value=cidx;
		document.getElementById('content').value=content;

		
		//$('#edit_submit_button').removeAttr('onclick');
		//$('.__cl-c-btn___').attr('onclick', 'editComment();');
		
		
	}
	
	function editComment(){
		
		var editCommentData = new FormData();
		var cidx=$('#cidx').val();
		
		
		editCommentData.append('cidx', cidx);
		editCommentData.append('content', $('#content').val());
		
		console.log('editCommentData : '+editCommentData);
		console.log('cidx : '+$('#cidx').val());
		console.log('content : '+$('#content').val());
		
		$.ajax({
			
			url: commentUrl+'/'+cidx,
			type: 'POST',
			dataType: 'JSON',
			contentType: false,
			processData: false,
			data : editCommentData,
			success : function(data){
				alert('수정성공');
				pageNum=1;
				document.getElementById('content').value='';
				getCommentList(${iidx});
				
			},
			error: function(data){
				alert('수정실패애');
			}
			
		});
		
	}
	
	
	/* function clearComemntList(){
		 var html ='';
		 pageNum=1;
		 $('div.itemList').html(html);
	} */

	function openRegForm(){
		
		$('#edit_submit_button').css('display', 'none');
		$('#submit_button').css('display', 'block');
		
		document.getElementById('content').value='';
		
		if(document.getElementById('commentRegArea').style.display=='block'){
			document.getElementById('commentRegArea').style.display='none';
		}else {
			document.getElementById('commentRegArea').style.display='block';
		}
	}

	function replaceAt(input, index, character){
		
		return input.substr(0, index) + character + input.substr(index+character.length);
	}

	


	$(document).ready(function(){
		
	
		showDetails(${iidx});
		
		getCommentList(${iidx});
			
	});	
	

</script>

</body>
</html>