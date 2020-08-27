<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>w1-f1 : 같이 ( 사는 ) 가치</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>오더페이지</h1>
	<div><input type="number" name="midx" id="midx" value="${loginInfo.midx}"></div>
	
	<div class="searchBox">
		<form onsubmit="return false;">
			<select name="searchType" id="searchType">
				<option value="">전체보기</option>
				<option value="title">제목</option>
				<option value="category">카테고리</option>
			</select>
			
			
			<div class="keywordBox">
				<input type="text" name="keyword" id="keywordBox">
				<input type="submit" value="검색" onclick="searchItem();">
			</div>
			
			
			<div class="categoryBox">
				<select name="keyword" id="categoryBox">
					<option value="0">과일</option>
					<option value="1">육류</option>
					<option value="2">해산물</option>
					<option value="3">채소</option>
					<option value="4">생필품</option>
					<option value="5">음료</option>
					<option value="">전체보기</option>
				</select>
				<input type="submit" value="검색" onclick="searchItem();">
			</div>
		</form>
	</div>
	
	<button onclick="getMySellList();">aside</button>
	
	<br>
	
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	
	<input type="button" value="글쓰기" onclick="itemReg();">
	<div id="recommend_itemList"></div>
	<br>
	
	<div id="itemList"></div>
	<br>
	
	<div id="itemDetails"></div>
	
	
	
</body>
</html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
<script>

var midx = ${loginInfo.midx};
var domain = "http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/";



//item 객체 생성
function Item(iidx, title, price, count_m, count_w, regdate, receive, addr,
			location, content, photo, state, view_count,category, midx) {
			this.iidx = iidx;
			this.title = title;
			this.price = price;
			this.count_m = count_m;
			this.count_w = count_w;
			this.regdate = regdate;
			this.receive = receive;
			this.addr = addr;
			this.location = location;
			this.content = content;
			this.photo = photo;
			this.state = state;
			this.view_count = view_count;
			this.category = category;
			this.midx = midx;
   }

//MyItem 객체 생성
function MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
		 regdate, receive, addr, location, content, photo,
			view_count, category, istate, ostate, pstate) {
			
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
			this.istate=istate;
			this.ostate=ostate;
       
   }
// ItemListView 객체 생성
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

function MySell(midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive){
	this.midx=midx;
	this.iidx=iidx;
	this.oidx=oidx;
	this.pidx=pidx;
	this.title=title;
	this.category=category;
	this.istate=istate;
	this.ostate=ostate;
	this.pstate=pstate;
	this.ireceive=ireceive;
	
}

function SellListView(itemTotalCount, currentPageNumber, sellList, pageTotalCount, itemCountPerPage, startRow){
	this.itemTotalCount = itemTotalCount;
	this.currentPageNumber = currentPageNumber;
	this.sellList = sellList;
	this.pageTotalCount = itemTotalCount/itemCountPerPage;
	this.itemCountPerPage = itemCountPerPage;
	this.startRow = startRow;
}

//var mainUrl ='http://ec2-13-209-70-0.ap-northeast-2.compute.amazonaws.com:8080/wifiTESTserver/items';
var mainUrl ='http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/items';
var sellUrl = 'http://ec2-54-180-98-41.ap-northeast-2.compute.amazonaws.com:8080/order_v2/sell';
	var ItemViewList = [];//메인에서 일반공구
	var ItemTotalList = [];//메인에서 일반공구
	var MySellTotalList = [];// 판매현황에서 내 공구
	var MySellListView = [];// 판매현황에서 내 공구
	var ItemViewList_recommend = [];//메인에서 추천공구
	var MyItemTotalList_recommend = [];//메인에서 추천공구
	var MyItemTotalList = [];//메인에서 일반공구
var pageNum=1;
var recommendPageNum=1;


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
			/* alert('추천리스트뷰 불러오기 성공!!'); */
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
				var regdate = moment(data.itemList[i].regdate).format("YYYY-MM-DD");
				var receive = data.itemList[i].receive;
				var addr = data.itemList[i].addr;
				var location = data.itemList[i].location;
				var content = data.itemList[i].content;
				var photo = data.itemList[i].photo;
				var view_count = data.itemList[i].view_count;
				var category = data.itemList[i].category;
				var istate = data.itemList[i].istate;
				var ostate = data.itemList[i].ostate;
				var pstate = data.itemList[i].pstate;
				
				console.log('istate_recommend :'+ istate);
				
				MyItemTotalList_recommend.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
						regdate, receive, addr, location, content, photo,
						view_count, category, istate, ostate, pstate));
   			
   			
   				
	    			rhtml+='<div class="recommend_card" style="">';
	    			rhtml+='<button>';
	    			rhtml+='	<ul>';
	    			rhtml+='		<li>공구idx : '+iidx+'</li>';
	    			rhtml+='		<li>제목 : '+title+'</li>';
	    			rhtml+='		<li>가격 : '+price+'</li>';
	    			rhtml+='		<li>모집인원 : '+count_m+'</li>';
	    			rhtml+='		<li>등록일시 : '+regdate+'</li>';
	    			rhtml+='		<li>판매처주소 : '+addr+'</li>';
	    			rhtml+='		<li>사진 : '+photo+'</li>';
	    			rhtml+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
	    			rhtml+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
	    			rhtml+='	</ul>';
	    			rhtml+='</button>';
	    			rhtml+='</div>';
	    			
	    			
   			
   			}
	    			console.log(rhtml);
   		
   		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
			var itemCountPerPage = data.itemCountPerPage;
			var startRow = data.startRow;
   		
	
			ItemViewList_recommend.push(new ItemListView_recommend(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
   	console.log('RitemListView.itemTotalCount : '+itemTotalCount);
   	console.log('RitemListView.currentPageNumber : '+currentPageNumber);
   	console.log('RitemListView.pageTotalCount : '+pageTotalCount);
   	console.log('RitemListView.itemCountPerPage : '+itemCountPerPage);
   	console.log('RitemListView.startRow : '+startRow);
   	console.log('RItemViewList_recommend : '+ItemViewList_recommend);
   	
   	$('#recommend_itemList').append(rhtml);
   	
   	}, 
   	error: function(data){
   			alert(data);
   			alert('추천리스트뷰 실패');
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
			 'searchType' : $('#searchType').val(),
	         'page':pageNum,
	         'count':10,
	         'istate':0,
	         'keyword': $('#keywordBox').val()
		},
		success: function(data){
			console.log(pageNum+'일반 page load');
			/* alert('리스트뷰 불러오기 성공!!'); */
			if(pageNum>data.pageTotalCount) {
				$(window).off();
	         }
			var itemTotalCount = data.itemTotalCount;
			var currentPageNumber = data.currentPageNumber;
			console.log('일반 data.itemList.length : '+data.itemList.length);
			for(var i=0; i<data.itemList.length; i++){
				
				var midx = data.itemList[i].midx;
				var iidx = data.itemList[i].iidx;
				var oidx = data.itemList[i].oidx;
				var pidx = data.itemList[i].pidx;
				var title = data.itemList[i].title;
				var price = data.itemList[i].price;
				var count_m = data.itemList[i].count_m;
				var count_w = data.itemList[i].count_w;
				var regdate = data.itemList[i].regdate;
				var receive = data.itemList[i].receive;
				var addr = data.itemList[i].addr;
				var location = data.itemList[i].location;
				var content = data.itemList[i].content;
				var photo = data.itemList[i].photo;
				var view_count = data.itemList[i].view_count;
				var category = data.itemList[i].category;
				var istate = data.itemList[i].istate;
				var ostate = data.itemList[i].ostate;
				var pstate = data.itemList[i].pstate;
				
				console.log(istate+': istate');
				
				MyItemTotalList.push(new MyItem(midx, iidx, oidx, pidx, title, price, count_m, count_w,
						regdate, receive, addr, location, content, photo,
						view_count, category, istate, ostate, pstate));
	    			
	    			html+='<div class="card">';
	    			html+='<button>';
					html+='	<ul>';
					html+='		<li>공구idx : '+iidx+'</li>';
					html+='		<li>제목 : '+title+'</li>';
					html+='		<li>가격 : '+price+'</li>';
					html+='		<li>모집인원 : '+count_m+'</li>';
					html+='		<li>등록일시 : '+regdate+'</li>';
					html+='		<li>판매처주소 : '+addr+'</li>';
					html+='		<li>사진 : '+photo+'</li>';
					html+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
					html+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
					html+='	</ul>';
	    			html+='</button>';
					html+='</div>';
   			
   			}
   		
   		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
			var itemCountPerPage = data.itemCountPerPage;
			var startRow = data.startRow;
	
			ItemViewList.push(new ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
   	
		
			$('#itemList').append(html);
			pageNum++;
		loading=false;
   	
   	}, 
   	error: function(data){
   			alert(data);
   			alert('리스트뷰 실패');
   	},
   	complete : function(){
   		
   	}
   	
   	});
	
	
}


function cleanItemList(){
	 var html ='';
	 $('#itemList').html(html);
}
function cleanSellList(){
  	 var html ='';
	 $('#aside').html(html);
}

// ok
function showDetails(iIdx){
	var html = '';
	
	$.ajax({
		
		url : mainUrl+'/'+iIdx,
		type : 'GET',
		success : function(data){
			/* alert('상세보기의 결과 데이터 : '+data); */
			 html += '<br><h2> [ 공구 상세 ] </h2>';
			 html += '<br>공구글번호 : '+data.iidx;
			 html += '<br>글제목 : '+data.title;
			 html += '<br>가격 : '+data.price;
			 html += '<br>모집인원 : '+data.count_m;
			 html += '<br>대기가능인원 : '+data.count_w;
			 html += '<br>등록일시 : '+data.regdate;
			 html += '<br>수령일시 : '+data.receive;
			 html += '<br>판매처주소 : '+data.addr;
			 html += '<br>판매처위치 : '+data.location;
			 html += '<br>내용 : '+data.content;
			 html += '<br>사진 : '+data.photo;
			 html += '<br>공구상태값 : '+data.state;
			 html += '<br>조회수 : '+data.view_count;
			 html += '<br>상품분류 : '+data.category;
			 html += '<br>게시자idx : '+data.midx;
			 html += '<br><br><button class="" onclick="joinCheck('+data.iidx+','+data.count_w +');">신청</button>';
			 html += '<button class="" onclick="closeInfo();">닫기</button>';
			 if(new Date(data.receive) < new Date()){
				 console.log('new Date(data.receive) : '+new Date(data.receive));
			 }
			 
			 html += '';
			 document.getElementById('itemDetails').style.display='block';
			 $('#itemDetails').html(html);
		},
		error : function(data){
			alert(data);
			alert('상세보기실패');
		}
	});
		
}

function closeInfo(){
	 	document.getElementById('itemDetails').style.display='none';
	 }

function closeRegForm(){
	 document.getElementById('regForm').style.display='none';
}
function closeMySell(){
	 document.getElementById('aside').style.display='none';
}

function itemReg(){
	location.href="${pageContext.request.contextPath}/board/regItem";
	document.getElementById('regForm').style.display='block';
	
}

// ok
function deleteItem(iidx){
	
		//cleanItemList();
	
			$.ajax({
			url : mainUrl+'/'+iidx,
			type : 'delete',
			success : function(data){
				/* alert('성공시 : '+data); */
				alert('게시글 삭제 완료');
				
			},
			complete : function(){
				
				getItemListView();
			}
		});
	
}

// ok
function searchItem(){
	
	var html='';
	pageNum=1;
	var searchType=$('#searchType').val();
	var keyword='';
	loading=false;
	if (searchType=='title'){
		keyword=$('#keywordBox').val();
	}
	if (searchType=='category'){
		keyword=$('#categoryBox').val();
	}
	
	
	$.ajax({
		
		url : mainUrl,
		type : 'GET',
		data : {
			'searchType':searchType,
  	         'page':pageNum,
  	         'keyword':keyword
		},
		success : function(data){
			cleanItemList();
			console.log(pageNum+' page load');
			/* alert('검색된 리스트뷰 불러오기 성공!!'); */
			
			if(pageNum>data.pageTotalCount) {
				$(window).off();
	         }
			
			var itemTotalCount = data.itemTotalCount;
			var currentPageNumber = data.currentPageNumber;
			
			for(var i=0; i<data.itemList.length; i++){
				var iidx = data.itemList[i].iidx;
				var title = data.itemList[i].title;
				var price = data.itemList[i].price;
				var count_m = data.itemList[i].count_m;
				var count_w = data.itemList[i].count_w;
				var regdate = data.itemList[i].regdate;
				var receive = data.itemList[i].receive;
				var addr = data.itemList[i].addr;
				var location = data.itemList[i].location;
				var content = data.itemList[i].content;
				var photo = data.itemList[i].photo;
				var state = data.itemList[i].state;
				var view_count = data.itemList[i].view_count;
				var category = data.itemList[i].category;
				var midx = data.itemList[i].midx;
				
				ItemTotalList.push(new Item(iidx, title, price, count_m, count_w, regdate, receive, addr,
						location, content, photo, state, view_count,category, midx));
   			
   			
   			html+='<div class="card">';
   			html+='<button>';
				html+='	<ul>';
				html+='		<li>공구idx : '+iidx+'</li>';
				html+='		<li>제목 : '+title+'</li>';
				html+='		<li>가격 : '+price+'</li>';
				html+='		<li>모집인원 : '+count_m+'</li>';
				html+='		<li>등록일시 : '+regdate+'</li>';
				html+='		<li>판매처주소 : '+addr+'</li>';
				html+='		<li>사진 : '+photo+'</li>';
				html+='		<li><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
				if(state!=10){
					html+='		<input type="button" value="삭제하기" onclick="deleteItem('+iidx+');"></li>';
				}else {
					html+='		<span id="emphasis">삭제된 공구입니다.</span></li>';
				}
				html+='	</ul>';
   			html+='</button>';
				html+='</div>';
   			
   		}
   		
   		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
			var itemCountPerPage = data.itemCountPerPage;
			var startRow = data.startRow;
	
			ItemViewList.push(new ItemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow));
   	/* console.log('itemListView.itemTotalCount : '+itemTotalCount);
   	console.log('itemListView.currentPageNumber : '+currentPageNumber);
   	console.log('itemListView.pageTotalCount : '+pageTotalCount);
   	console.log('itemListView.itemCountPerPage : '+itemCountPerPage);
   	console.log('itemListView.startRow : '+startRow); */
   	
   	pageNum++;
   	searching=true;
			
		},
		error : function(data){
			console.log(data);
			alert('검색 실패');
			
		},
   	complete : function(){
   		
	    	$('#itemList').append(html);
	    	//$('#keywordBox').val('');
   	}
		
	});
	
	
	 $(window).scroll(function() {
	      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
	         if(!loading) {
	            loading=true;
	            searchItem();
	         } 
	        } 
	    });  
	
	
}



// 내가 올린 공구  : ing...
function getMySellList(){
	
	var html='';
	
	$.ajax({
		
		url: sellUrl,
		type:'GET',
		data : {
			'midx': midx,
			'count':20
		},
		success : function(data){
			/* alert('나의 공구 불러오기 성공'); */
			console.log(data);
			//console.log(data);
			
			/* if(pageNum>data.pageTotalCount) {
	            return;
	         } */
	         
			var itemTotalCount = data.itemTotalCount;
			var currentPageNumber = data.currentPageNumber;
			
			for(var i=0; i<data.sellList.length; i++){
				var midx = data.sellList[i].midx;
				var iidx = data.sellList[i].iidx;
				var oidx = data.sellList[i].oidx;
				var pidx = data.sellList[i].pidx;
				var title = data.sellList[i].title;
				var category = data.sellList[i].category;
				var istate = data.sellList[i].istate;
				var ostate = data.sellList[i].ostate;
				var pstate = data.sellList[i].pstate;
				var ireceive = data.sellList[i].ireceive;
				
				MySellTotalList.push(new MySell(midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive));
   			
   			html+='<div class="mysell">';
   			html+='	<button>';
				html+='		<span>내idx : '+midx+'</span> |';
				html+='		<span>공구idx : '+iidx+'</span> |';
				html+='		<span>제목 : '+title+'</span> |';
				html+='		<span>'+ireceive+'까지</span> |';
				html+='		<span>istate : '+istate+'</span>';
				html+='		<span><input type="button" value="상세보기" onclick="showDetails('+iidx+');">';
				html+='		<span><a href="javascript:void(0);" onclick="showDetails('+iidx+');" >상세보기test</a>';
   			html+='	</button>';
				html+='</div>';
   		}
				html+='		<input type="button" value="닫기" onclick="closeMySell();"></span>';
			
			console.log('판매현황  sellList : '+data.sellList);
   		
   		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
			var itemCountPerPage = data.itemCountPerPage;
			var startRow = data.startRow;
	
			MySellListView.push(new SellListView(itemTotalCount, currentPageNumber, data.sellList, pageTotalCount, itemCountPerPage, startRow));
   	/* console.log('itemListView.itemTotalCount : '+itemTotalCount);
   	console.log('itemListView.currentPageNumber : '+currentPageNumber);
   	console.log('itemListView.pageTotalCount : '+pageTotalCount);
   	console.log('itemListView.itemCountPerPage : '+itemCountPerPage);
   	console.log('itemListView.startRow : '+startRow); */
   	
   	pageNum++;
   	loading=true;
   	console.log('판매현황 : '+html);
   	cleanSellList();
   	document.getElementById('aside').style.display='block';
   	$('#aside').append(html);
   	
   	
		},
		error: function(){
			alert('나의 공구 불러오기 실패');
		}
		
	});
	
	
}


// item (장윤원) javascript end

// order (송가람, 박혜미) javascript start

$(document).ready(function(){
	
	var loading=false;	
	var searching=false;	
	

		
		
	/* alert('appStart!\n공구게시판입니다.'); */
	getItemListView_recommend();
	getItemListView();
	
	// 검색활성화시 ㅈ
		$(window).scroll(function() {
		      if($(window).scrollTop()+200>=$(document).height() - $(window).height()) {
		    	  if(!loading) {
		            loading=true;
		            getItemListView();
		         } 
		       } 
		    }); 
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



	
	
	console.log(midx);
	
	/* 참여신청: 잔여 대기인원 확인 */
	function joinCheck(iidx, count_w){
	
	   		  $.ajax({
		      url : domain+'order/'+midx+'/'+iidx+'/'+count_w,
		      type : 'GET',
		      success : function(data){
		         if(data == 1){
		            join(midx, iidx);
		            //join(midx, $('#iidx').text());
		         } else if(data == 2){
		            alert("본인의 판매글은 참여신청이 불가합니다.");
		         } else{
		            alert("정원이 마감되어 신청이 불가합니다.");
		         }
		      }
		   })
	};
	
	/* 참여신청: 대기신청 */
	function join(midx, iidx){
	   
	   $.ajax({
	      url : domain+'order/'+ midx+'/'+iidx,
	      type : 'POST',
	      success : function(data){
	         if(data == 1){
	            alert("참여신청 완료!!");
	            myorderList(midx);
	            //myorderList(midx);
	         } else{
	            alert("신청내역이 이미 존재합니다.");
	         }
	      },
	      error: function(err){
	         alert("참여신청 실패 : "+err);
	      }
	   })
	};
	
	function myorderList(midx) {
		   $.ajax({
		      url: domain+'order/'+midx,
		      type: 'get',
		      success: function(data){
		         
		         var html = '';
		         for(var i=0; i<data.length; i++){
		            var btn='';
		            var state= '';
		            var btnClass = '';
		            var action = '';
		            var btn = '';
		            var stateColor= '';
		            
		            switch(data[i].ostate){
		               case 1:
		                  state = '다음기회에...;'
		                  btnClass = 'aside_button order_del';
		                  btn='확인';
		                  action = 'order_del';
		                  stateColor = 'aside_mystate next';
		                  break;
		                  
		               case 0:
		                  state = '참여중';
		                  btnClass = 'aside_button order_del';
		                  btn='참여취소';
		                  action = 'order_del';
		                  stateColor = 'aside_mystate join';
		                  break;
		            }
	
		            switch(data[i].pstate){      
		               case 0:
		                  state = '구매자';
		                  btnClass = 'aside_button';
		                  btn='QR확인';
		                  action = 'qr';
		                  stateColor = 'aside_mystate buyer';
		                  break;
		                  
		               case 1:
		                  state = '구매 완료';
		                  btnClass = 'aside_button review';
		                  btn='평점 등록';
		                  action = 'toggle';
		                  stateColor = 'aside_mystate review';
		                  break;
		            }
		            html += '<div class="aside_mycard a'+data[i].iidx+'">';
		            html += '   <div class="aside_mystatewrap">';
		            html += '      <h4 class="'+stateColor+'">'+state+'</h4>';
		            html += '      <div id="a'+data[i].iidx+'" onclick="cancleAlarm('+data[i].midx+','+data[i].iidx+')">test</div>';
		            html += '   </div>';
		            html += '      <input type="button" class="'+btnClass+'" onclick="'+action+'('+data[i].midx+','+data[i].iidx+')" value="'+btn+'"> <br>';
		            html += '      <a href="#" onclick="showDetails('+data[i].iidx+');" class="aside_item_title" id="iidx">'+data[i].iidx+':'+data[i].title+'</a> <br>';
		            if(data[i].pstate == 1){
		               html += '<form onsubmit="return false;">';
		               html += '   <div class="panel">';
		               html += '      <input class="score_s" type="number">';
		               html += '      <input class="insert_rvs" type="submit" value="평점 등록" onclick="review()">';
		               html += '      <input type="submit" class="purchase_del" onclick="order_del('+data[i].midx+','+data[i].iidx+')" value="글 삭제">';
		               html += '      <input type="hidden" class="midx" value="'+data[i].midx+'">';
		               html += '      <input type="hidden" class="iidx" value="'+data[i].iidx+'">';
		               html += '   </div>';
		               html += '</form>';
		            }
		            html += '</div>';
		         }
		         
		         $('#aside_mylist').html(html);
		         
		      } 
		   })
		}; // myorder end
	
		/* 전체 알림 표시 */
		function readAllAlarm(midx){
		   $.ajax({
		      url: domain+'order/alarmall/'+midx,
		      type: 'GET',
		      success: function(data){
		         if(data > 0){
		            $("#alarm_b").text(data);
		         }
		      }
		   })
		}
	
		/* 개별 알림 표시 */
		function readAlarm(midx){
		   console.log("readAlarm");
		   $.ajax({
		      url: domain+'order/alarm/'+midx,
		      type: 'GET',
		      success: function(data){
		         for(var i=0; i<data.length; i++){
		            $("#a"+data[i]).addClass('alarm');
		         }
		      }
		   })
		};
	
		/* 알림 삭제 */
		function cancleAlarm(midx, iidx){
		   $.ajax({
		      url: domain+'order/alarm/'+midx+'/'+iidx,
		      type: 'POST',
		      success: function(data){
		         if(data == 1){
		            $("#a"+iidx).removeClass('alarm');
		         }
		      }
		   })
		};
	
	
	
		/* aside - 오더 취소 */
		function order_del(midx, iidx){
		   var button = 0;
		   var bClass = $(this).attr("class");
		   
		   if(bClass == "aside_button order_del"){
		      button = 0;
		   } else if(bClass == "aside_button purchase_del"){
		      button = 1;
		   }
		   if(confirm("정말로 삭제하시겠습니까?")){
		      $.ajax({
		         url: domain+'order/'+midx+'/'+iidx +'/'+button,
		         type: 'DELETE',
		         success: function(data){
		            if(data == 1){
		               alert("참여신청이 정상적으로 취소되었습니다.");
		            } else if(data==2){
		               alert("글이 정상적으로 삭제되었습니다.");
		            }
		            myorderList(midx);
		            //myorderList(midx);
		         }
		      })
		   }
		};
	
		function review(){
		   
		   var reviewForm = new FormData();
		   reviewForm.append('score_s', $('.score_s').val());
		   reviewForm.append('midx', $('.midx').val());
		   reviewForm.append('iidx', $('.iidx').val());
		   
		   if(confirm('평점등록은 한번으로 제한됩니다. 현재 평점으로 등록하시겠습니까?')){
		      $.ajax({
		         url : domain+'order',
		         type : 'POST',
		         data : reviewForm,
		         processData: false,
		         contentType: false,
		         success : function(data){
		            if(data == 1){
		               $(".score_s").attr('disabled', 'true');   // 평점 등록 후 수정 불가
		               $(".insert_rvs").attr('type', 'hidden');  // 평점 등록 후 등록버튼 사라짐
		               alert("평점등록 완료!!");
		            }
		         },
		         error: function(err){
		            alert("평점등록 실패"+err);
		         }
		      })
		   }
		};
	
		/* aside - 평점하기 버튼 클릭시 */
		function toggle(midx, iidx){
		   $(".panel").toggle();
		};
	
		$(document).ready(function(){
		   
		   myorderList(midx);
		   /* readAllAlarm(midx);
		   readAlarm(midx); */
		   
		     /* 5초마다 알람 체크 */
		   setInterval("readAllAlarm("+midx+")", 2000);
		   setInterval("readAlarm("+midx+")", 2000);
		   
		   
		}); // ready end
</script>
