<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WIFI 함께 (사는) 가치</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/default.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/aside.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/itemList.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  p.card-text { margin:5px 0px; }
  
</style>
</head>
<body>
		<c:if test="${empty loginInfo}">
			<script>
				alert("로그인이 필요하므로 메인으로 돌아갑니다.");
			</script>
			<c:redirect url="index"/>
		</c:if>


<%@ include file="/WEB-INF/views/include/background.jsp" %>
<%@ include file="/WEB-INF/views/include/aside.jsp" %>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

   <div class="container">
   
   	 <div class="row recommend_itemList"></div>
   
     <div class="row itemList">
     
		<br>
	
		<div id="itemList"></div>
		<br>
	
		
		<div id="searchList"></div>
		<br>
		
       
     </div>
     
   </div>
   
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>

	//ItemListView 객체 생성
	function ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow){
		this.itemTotalCount = itemTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.itemList = itemList;
		this.pageTotalCount = itemTotalCount/itemCountPerPage;
		this.itemCountPerPage = itemCountPerPage;
		this.startRow = startRow;
	}
	
	function ItemListView_recommend(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow){
		this.itemTotalCount = itemTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.itemList = itemList;
		this.pageTotalCount = itemTotalCount/itemCountPerPage;
		this.itemCountPerPage = itemCountPerPage;
		this.startRow = startRow;
	}
	
	//MyItem 객체 생성
	 function MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
			 regdate, receive, addr, location, content, photo,
				view_count, category, score_s, name, istate, ostate, pstate) {
				
				this.midx=midx;
				this.iidx=iidx;
				this.oidx=oidx;
				this.pidx=pidx;
				this.title=title;
				this.price=price;
				this.count_m=count_m;
				this.count_w=count_w;
				this.regdate=regdate;
				this.receive=receive;
				this.addr=addr;
				this.location=location;
				this.content=content;
				this.photo=photo;
				this.view_count=view_count;
				this.category=category;
				this.score_s=score_s;
				this.name=name;
				this.istate=istate;
				this.ostate=ostate;
				this.pstate=pstate;
	        
	    }
	
	//var mainUrl ='http://ec2-13-209-70-0.ap-northeast-2.compute.amazonaws.com:8080/wifiTESTserver/items';
	var mainUrl ='http://localhost:8080/order/items';
	//var mainUrl ='http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/items';
	var sellUrl = 'http://localhost:8080/order/sell';
	//var sellUrl = 'http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/sell';
	var imgUrl = 'http://localhost:8080/order/upload/';
	
   	var ItemViewList = [];//메인에서 일반공구
   	var ItemTotalList = [];//메인에서 일반공구
   	var MySellTotalList = [];// 판매현황에서 내 공구
   	var MySellListView = [];// 판매현황에서 내 공구
   	var ItemViewList_recommend = [];//메인에서 추천공구
   	var MyItemTotalList_recommend = [];//메인에서 추천공구
   	var MyItemTotalList = [];//메인에서 일반공구
	var pageNum=1;
	var recommendPageNum=1;
	var searchPageNum=1;
	var searchCheckNum=0;
	var loading=false;	
 	var searching=false;	
 	
 	
function getItemListView_recommend(){
		
		var rhtml='';
		var html='';
		
    	$.ajax({
    		
    		url: mainUrl,
    		type: 'GET',
    		data : {
    			'searchType' : $('#searchType').val(),
   	        	 'page':recommendPageNum,
   	        	 'count':10,
   	        	 'istate':1,
   	        	 'keyword': $('#keywordBox').val()
    		},
    		success: function(data){
    			alert('추천리스트뷰 불러오기 성공!!');
    			console.log(pageNum+'추천 page load');
    			console.log(data+'추천 data');
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			console.log(' data.itemList.length : '+data.itemList.length);
    			
				for(var i=0; i<data.itemList.length; i++){
					
					var midx = data.itemList[i].midx;
					var iidx = data.itemList[i].iidx;
					var oidx = data.itemList[i].oidx;
					var pidx = data.itemList[i].pidx;
					var title = data.itemList[i].title;
	 				var price = data.itemList[i].price;
	 				var count_m = data.itemList[i].count_m;
	 				var count_w = data.itemList[i].count_w;
	 				var regdate = moment(data.itemList[i].regdate).format('YYYY-MM-DD');
	 				var receive = moment(data.itemList[i].receive).format('YYYY-MM-DD HH:mm');
	 				var addr = data.itemList[i].addr;
	 				var location = data.itemList[i].location;
	 				var content = data.itemList[i].content;
	 				var photo = data.itemList[i].photo;
	 				var view_count = data.itemList[i].view_count;
	 				var category = data.itemList[i].category;
	 				var score_s = data.itemList[i].score_s;
	 				var name = data.itemList[i].name;
	 				var istate = data.itemList[i].istate;
	 				var ostate = data.itemList[i].ostate;
	 				var pstate = data.itemList[i].pstate;
					
	 				console.log('istate_recommend :'+ istate);
	 				console.log('photo :'+ photo);
	 				
	 				MyItemTotalList_recommend.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
	 						regdate, receive, addr, location, content, photo,
	 						view_count, category, score_s, name, istate, ostate, pstate));
	    			
	    			
	    				
		    			rhtml+='<div class="col-4">';
		    			rhtml+='	<p>Card</p>';
		    			rhtml+='		<div class="card recommend_card" style="cursor:pointer; border-radius: 10%;">';
		    			rhtml+='			<img src="'+imgUrl+photo+'" alt="" class="card-img-top" />';
		    			//rhtml+='				<div class="card-body gradient-border" id="box">';
		    			rhtml+='				<div class="card-body" >';
		    			rhtml+='					<h6 class="card-title"><span style="font-weight:bold; color:red;">글번호 : '+iidx+'</span> '+title+'</h6>';
		    			rhtml+='						<p class="card-text" id="midx">게시자 :'+name+'<span class="rvs" style="font-weight:bold; color:green;">평점 : '+score_s+'점</span></p>';
		    			rhtml+='						<p class="card-text" id="price">'+price+'</p>';
		    			rhtml+='						<p class="card-text" id="count_m">'+count_m+'</p>';
		    			rhtml+='						<p class="card-text" id="receive">'+receive+'</p>';
		    			rhtml+='						<p class="card-text" id="addr">'+addr+'</p>';
		    			rhtml+='						<p class="card-text" id="istate">'+istate+'</p>';
		    			rhtml+='						<a href="javascript:void(0);" onclick="showDetails('+iidx+');" class="btn btn-primary">상세보기</a>';
		    			
		    			if (${loginInfo.midx}==midx){
		    				rhtml+='						<a href="javascript:void(0);" onclick="deleteItem('+iidx+');" class="btn btn-primary">삭제하기</a>';
		    			}
		    			rhtml+='					</div>';
		    			rhtml+='			</div>';
		    			rhtml+='	</div>';
		    			
	    			
	    			}
		    			console.log(rhtml);
	    		
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
	    		
    	
				ItemViewList_recommend.push(new ItemListView_recommend(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
	    	$('div.recommend_itemList').append(rhtml);
	    	
	    	}, 
	    	error: function(data){
	    			alert(data);
	    			alert('추천리스트뷰 불러오기 실패');
	    	},
	    	complete : function(){
	    		
	    	}
	    	
	    	});
    	
    } 	
	
	
function getItemListView(){
		
		var html='';
		
    	$.ajax({
    		
    		url: mainUrl,
    		type: 'GET',
    		data : {
    			 /* 'searchType' :  $('#searchType').val(), */
    	         'page':pageNum,
    	         'count':10,
    	         'istate':0
    	         /* 'keyword': $('#keywordBox').val() */
    		},
    		success: function(data){
    			console.log(pageNum+'일반 page load');
    			//alert('리스트뷰 불러오기 성공!!');
    			
    			if(pageNum>data.pageTotalCount) {
    				$(window).off();
    	         } 
    			var itemTotalCount = data.itemTotalCount;
    			var currentPageNumber = data.currentPageNumber;
    			console.log('▶ 일반 data.itemList: '+data.itemList);
    			console.log('▶ 일반 data.itemList.length : '+data.itemList.length);

				for(var i=0; i<data.itemList.length; i++){
					
					var midx = data.itemList[i].midx;
					var iidx = data.itemList[i].iidx;
					var oidx = data.itemList[i].oidx;
					var pidx = data.itemList[i].pidx;
					var title = data.itemList[i].title;
	 				var price = data.itemList[i].price;
	 				var count_m = data.itemList[i].count_m;
	 				var count_w = data.itemList[i].count_w;
	 				var regdate = moment(data.itemList[i].regdate).format('YYYY-MM-DD');
	 				var receive = moment(data.itemList[i].receive).format('YYYY-MM-DD HH:mm');
	 				var addr = data.itemList[i].addr;
	 				var location = data.itemList[i].location;
	 				var content = data.itemList[i].content;
	 				var photo = data.itemList[i].photo;
	 				var view_count = data.itemList[i].view_count;
	 				var category = data.itemList[i].category;
	 				var score_s = data.itemList[i].score_s;
	 				var name = data.itemList[i].name;
	 				var istate = data.itemList[i].istate;
	 				var ostate = data.itemList[i].ostate;
	 				var pstate = data.itemList[i].pstate;
					
	 				console.log('regdate : '+regdate);
	 				console.log('receive : '+receive);
	 				console.log('iidx : '+iidx);
	 				console.log('photo : '+photo);
	 				
	 				MyItemTotalList.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
	 						regdate, receive, addr, location, content, photo,
	 						view_count, category, score_s,name, istate, ostate, pstate));
		    			
		    			html+='<div class="col-4">';
		    			html+='		<p>Card</p>';
		    			html+='			<div class="card">';
		    			html+='			<img src="'+imgUrl+photo+'" alt="" class="card-img-top" />';
						html+='					<div class="card-body">';
						html+='						<h6 class="card-title"><span style="font-weight:bold; color:red;">글번호 : '+iidx+'</span> '+title+'</h6>';
						html+='							<p class="card-text" id="midx">게시자 :'+name+'<span class="rvs" style="font-weight:bold; color:green;">평점 : '+score_s+'점</span></p>';
						html+='							<p class="card-text" id="price">'+price+'</p>';
						html+='							<p class="card-text" id="count_m">'+count_m+'</p>';
						html+='							<p class="card-text" id="receive">'+receive+'</p>';
						html+='							<p class="card-text" id="addr">'+addr+'</p>';
						html+='							<p class="card-text" id="istate">'+istate+'</p>';
						html+='							<a href="javascript:void(0);" onclick="showDetails('+iidx+');" class="btn btn-primary">상세보기</a>';
						if (${loginInfo.midx}==midx){
							html+='						<a href="javascript:void(0);" onclick="deleteItem('+iidx+');" class="btn btn-primary">삭제하기</a>';
		    			}						html+='					</div>';
						html+='			</div>';
						html+='	</div>';
	    			
						//getScore(midx);	
	    			}
				
	    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
				var itemCountPerPage = data.itemCountPerPage;
				var startRow = data.startRow;
    	
				ItemViewList.push(new ItemListView(itemTotalCount, currentPageNumber, data.itemList, pageTotalCount, itemCountPerPage, startRow));
				
			//cleanSearchList();
   		
			console.log("이 공구의 midx : "+midx);
					
			pageNum++;
	    	}, 
	    	error: function(data){
	    			alert(data);
	    			alert('리스트뷰 실패');
	    	},
	    	complete : function(){
	    		$('div.itemList').append(html);
				console.log(html);
	    		
	    		loading=false;
	    	}
	    	
    	});
    	
    	// 활성화시 
		$(window).scroll(function() {
	      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
	    	  if(!loading) {
	            loading=true;
	            getItemListView();
	         } 
	       } 
	    });
    	
    }
    
    function showDetails(iidx){
    	location.href='view/'+iidx;
    }
    
	// ok
	function deleteItem(iidx){
		
			//cleanItemList();
		
			if(confirm('정말 삭제하시겠습니까?')){
				
				$.ajax({
				url : mainUrl+'/'+iidx,
				type : 'delete',
				success : function(data){
					alert('성공시 : '+data);
					cleanItemList();
					getItemListView();
				},
				complete : function(){
					
				}
			});
			
			} else {
				return false;
			}
		
	}
    
	function cleanItemList(){
		 var html ='';
		 pageNum=1;
		 $('div.itemList').html(html);
	}
    
    
$(document).ready(function(){
 	
 	
 		
 	alert('appStart!\n공구게시판입니다.');
 	getItemListView_recommend();
 	getItemListView();
 	
 		$(window).scroll(function() {
 		      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
 		         if(searching) {
 		        	 searching=true;
 		        	 searchItem();
 		         } 
 		        } 
 		    });
    
    	$('#searchType').mouseleave(function(){
    		
    		if($('#searchType').val()=='category'){
 			$('div.keywordBox').css('display', 'none');
 			$('div.categoryBox').css('display', 'block');
    		} else {
 			$('div.categoryBox').css('display', 'none');
 			$('div.keywordBox').css('display', 'block');
    		}
 	});
    	
 
});

    


</script>
</body>
</html>



