<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#itemList {
		overflow: hidden;
	}

	div.card {
		width: 33%;
		float: left;
		
		border : 1px solid #DDD;
		
	}
	
	div.card>ul>li {
		list-style: none;
		font-size: 12px;
	}
	
	#regForm {
		display: none;
	} 
	
	#itemDetails {
		display: none;
	}

	#emphasis {
		color: red;
		font-weight: bold;
	}

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
</head>
<body>

	<h1>공구게시판</h1>
	
	<div id="regArea"><input type="button" value="글쓰기" onclick="itemReg();">
		<div class="regForm">
			<form id="regForm" onsubmit="return false;">

			공구글제목 : <input type="text" name="title" id="title" required><br>
			가격 : <input type="number" name="price" id="price" required><br>
			공구인원 : <input type="number" name="countM" id="countM" min="0" required><br>
			수령날짜 : <input type="datetime-local" id="receive" name="receive" required><br>
			<!-- 수령날시각 : <input type="time" id="receive_time" name="receive_time" required><br> -->
			판매처주소 : <input type="text" name="addr" id="addr" required><br>
			판매처위치 : <input type="text" name="location" id="location"><br>
			내용 : <input type="text" name="content" id="content"><br>
			사진 : <input type="file" name="photo" id="photo"><br>
			공구상태 : <input type="number" name="state" id="state" required><br>
			분류 : <select id="category">
						<option value="0">과일</option>
						<option value="1">육고기</option>
						<option value="2">채소</option>
						<option value="3">생필품</option>
						<option value="4">기타</option>
				</select><br>
			게시자idx : <input type="number" name="midx" id="midx"><br>
			<input type="submit" value="공구등록" onclick="regSubmit(); ">
			<input type="reset">
		
		
			</form>
		</div>
	</div>
	
	<div class="searchBox">
			<form>
				<select name="searchType">
					<option value="title">제목</option>
				</select>
				<input type="text" name="keyword" id="keywordBox">
				<input type="submit" value="검색">
			</form>
		</div>
	
	<div>
		현재 등록된 공구 총 개수 : ${listView.itemTotalCount} 개
	</div>
	<div id="itemList"></div>
	
	<div class="paging">
		<%-- <c:if test="${listView.pageTotalCount>0}">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
				<a href="items?page=${num}" ${listView.currentPageNumber eq num ? 'class="currentPage"':''}>[${num}]</a>
			</c:forEach>
		</c:if> --%>
	</div>
	
	<br>
	
	<div id="itemDetails"></div>


</body>
</html>

<script>
	
	
	$(document).ready(function(){
		
	alert('appStart!\n공구게시판입니다.');
	makeItemList();
		
	});

	//item 객체 생성
	 function item(iIdx, title, price, countM, countW, regDate, receive, addr,
				location, content, photo, state, viewCount,category, mIdx) {
         
				this.iIdx = iIdx;
				this.title = title;
				this.price = price;
				this.countM = countM;
				this.countW = countW;
				this.regDate = regDate;
				this.receive = receive;
				this.addr = addr;
				this.location = location;
				this.content = content;
				this.photo = photo;
				this.state = state;
				this.viewCount = viewCount;
				this.category = category;
				this.midx = midx;
	        
	    }
	
		function itemListView(itemTotalCount, currentPageNumber, itemList, pageTotalCount, itemCountPerPage, startRow){
			this.itemTotalCount = itemTotalCount;
			this.currentPageNumber = currentPageNumber;
			this.itemList = itemList;
			this.pageTotalCount = pageTotalCount;
			this.itemCountPerPage = itemCountPerPage;
			this.startRow = startRow;
		}	
	 
    	var itemListViewList = [];
    	var itemTotalList = [];
    
   	function makeItemList(){
   		
   		$.ajax({
   			
   			url : 'http://localhost:8080/wifi/items',
   			type : 'GET',
   			success : function(data){
   				
   				var html='';
   				
   				for(var i=0; i<data.length; i++){
					html+='<div class="card">';
					html+='	<ul>';
					html+='		<li>idx : '+data[i].iIdx+'</li>';
					html+='		<li>title : '+data[i].title+'</li>';
					html+='		<li>price : '+data[i].price+'</li>';
					html+='		<li>countM : '+data[i].countM+'</li>';
					html+='		<li>regDate : '+data[i].regDate+'</li>';
					html+='		<li>addr : '+data[i].addr+'</li>';
					html+='		<li>photo : '+data[i].photo+'</li>';
					html+='		<li><input type="button" value="상세보기" onclick="showDetails('+data[i].iIdx+');">';
					if(data[i].state!=10){
						html+='		<input type="button" value="삭제하기" onclick="deleteItem('+data[i].iIdx+');"></li>';
					}else {
						html+='		<span id="emphasis">삭제된 공구입니다.</span></li>';
					}
					html+='	</ul>';
					html+='</div>';
				}
   				
   				$('#itemList').html(html);
   				
   			}
   			
   		});
   		
   	}  	
    	
    	
    function make_ItemList(){

     	 $.getJSON('http://localhost:8080/wifi/items', function(data){
     		 
 			$.each(data, function(key, value){
 				
 				var itemTotalCount = value.itemTotalCount;
 				var currentPageNumber = value.currentPageNumber;
 				
 				var itemList = value.itemList;
 				
 				$.each(itemList, function(key, value){
 					
 					var iIdx = value.iIdx;
	 				var title = value.title;
	 				var price = value.price;
	 				var countM = value.countM;
	 				var countW = value.countW;
	 				var regDate = value.regDate;
	 				var receive = value.receive;
	 				var addr = value.addr;
	 				var location = value.location;
	 				var content = value.content;
	 				var photo = value.photo;
	 				var state = value.state;
	 				var viewCount = value.viewCount;
	 				var category = value.category;
	 				var midx = value.midx;
 				
 				itemTotalList.push(new item(iIdx, title, price, countM, countW, regDate, receive, addr,
 						location, content, photo, state, viewCount,category, midx));
 				
 				
 				});
	 				
 				var pageTotalCount = 55;
 				var itemCountPerPage = value.itemCountPerPage;
 				var startRow = value.startRow;
 				
/*  				console.log(value);
 				//alert(value.cIdx);
 				console.log("value.name : "+value.name);
 				var iIdx = value.iIdx;
 				var title = value.title;
 				var price = value.price;
 				var countM = value.countM;
 				var countW = value.countW;
 				var regDate = value.regDate;
 				var receive = value.receive;
 				var addr = value.addr;
 				var location = value.location;
 				var content = value.content;
 				var photo = value.photo;
 				var state = value.state;
 				var viewCount = value.viewCount;
 				var category = value.category;
 				var midx = value.midx;
 				
 				itemTotalList.push(new item(iIdx, title, price, countM, countW, regDate, receive, addr,
 						location, content, photo, state, viewCount,category, midx)); */
			
				itemListViewList.push(new itemListView(itemTotalCount, currentPageNumber, itemTotalList, itemCountPerPage, startRow));	
 			alert("itemTotalList : "+value.itemTotalList);
 						
 			});//end of each
 			alert("itemListViewList : "+itemListViewList);
 			makeItemTotalListHtml();
 			
     	 });//end of getJson
    }// end of function
    
    
    function makeItemListView(){
    	
    	 $.getJSON('http://localhost:8080/wifi/items', function(data){
     		 
  			$.each(data, function(key, value){
  				
  				
  			});//end of each
  			
      	 });//end of getJson
    	
    }
     	
    function makeItemTotalListHtml(){

    	 var html ='';
    	 
    	 for(var j=0; j < itemListViewList.length; j++){
	         for (var i = 0; i < itemTotalList.length; i++) {
	       	 	html+='<div class="card">';
				html+='	<ul>';
				html+='		<li>공구idx : '+itemListViewList[j].itemTotalList[i].iIdx+'</li>';
				html+='		<li>제목 : '+itemListViewList[j].itemTotalList[i].title+'</li>';
				html+='		<li>가격 : '+itemListViewList[j].itemTotalList[i].price+'</li>';
				html+='		<li>모집인원 : '+itemListViewList[j].itemTotalList[i].countM+'</li>';
				html+='		<li>등록일시 : '+itemListViewList[j].itemTotalList[i].regDate+'</li>';
				html+='		<li>판매처주소 : '+itemListViewList[j].itemTotalList[i].addr+'</li>';
				html+='		<li>사진 : '+itemListViewList[j].itemTotalList[i].photo+'</li>';
				html+='		<li><input type="button" value="상세보기" onclick="showDetails('+itemListViewList[j].itemTotalList[i].iIdx+');">';
				if(itemListViewList[j].itemTotalList[i].state!=10){
					html+='		<input type="button" value="삭제하기" onclick="deleteItem('+itemListViewList[j].itemTotalList[i].iIdx+');"></li>';
				}else {
					html+='		<span id="emphasis">삭제된 공구입니다.</span></li>';
				}
				html+='	</ul>';
				html+='</div>';
	         }
    	}
         	$('#itemList').html(html);
    }
	
    function cleanItemList(){
    	 var html ='';
    	 $('#itemList').html(html);
    }
    
	// ok
	function showDetails(iIdx){

		var html = '';
		
		$.ajax({
			
			url : 'http://localhost:8080/wifi/items/'+iIdx,
			type : 'GET',
			success : function(data){
				alert('상세보기의 결과 데이터 : '+data);
				 html += '<br><h2> [ 공구 상세 ] </h2>';
				 html += '<br>공구글번호 : '+data.iIdx;
				 html += '<br>글제목 : '+data.title;
				 html += '<br>가격 : '+data.price;
				 html += '<br>모집인원 : '+data.countM;
				 html += '<br>대기가능인원 : '+data.countW;
				 html += '<br>등록일시 : '+data.regDate;
				 html += '<br>수령일시 : '+data.receive;
				 html += '<br>판매처주소 : '+data.addr;
				 html += '<br>판매처위치 : '+data.location;
				 html += '<br>내용 : '+data.content;
				 html += '<br>사진 : '+data.photo;
				 html += '<br>공구상태값 : '+data.state;
				 html += '<br>조회수 : '+data.viewCount;
				 html += '<br>상품분류 : '+data.category;
				 html += '<br>게시자idx : '+data.midx;
				 html += '<br><br><button class="" onclick="closeInfo();">닫기</button>';
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
	
	function itemReg(){
		//location.href='itemRegForm';
		document.getElementById('regForm').style.display='block';
		
	}
	
	function regSubmit(){

		var regFormData = new FormData();
		regFormData.append('title', $('#title').val());
		regFormData.append('price', $('#price').val());
		regFormData.append('countM', $('#countM').val());
		regFormData.append('countW', $('#countM').val()*2);
		regFormData.append('receive', moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
		regFormData.append('addr', $('#addr').val());
		regFormData.append('location', $('#location').val());
		regFormData.append('content', $('#content').val());
		// 파일 첨부
		if($('#photo')[0].files[0] != null){
		regFormData.append('photo', $('#photo')[0].files[0]);
		}
		regFormData.append('state', $('#state').val());
		regFormData.append('viewCount', 123);
		regFormData.append('category', $('#category').val());
		regFormData.append('midx', $('#midx').val());
		
		alert('공구등록중1~');
		alert('receive : '+moment($('#receive').val()).format('YYYY-MM-DD HH:mm:ss'));
		
		$.ajax({
			
			url : 'http://localhost:8080/wifi/items',
			type : 'POST',
			processData : false,
			contentType : false,
			data : regFormData,
			success : function(data){
				alert('성공시 : '+data);
				//$('#regForm').reset();
				//location.href='index';
				alert('공구등록완료');
			},
			error : function(data){
				console.log(data);
				alert('실패');
			}
		});

	}
	
	// ok
	function deleteItem(iIdx){
		
		/* var delFormData = new FormData();
		delFormData.append('iIdx', iIdx);
		delFormData.append('state', 0);
		delFormData.append('iIdx', i);
		delFormData.append('iIdx', i); */
			cleanItemList();
		
			$.ajax({
			url : 'http://localhost:8080/wifi/items/'+iIdx,
			type : 'delete',
			success : function(data){
				alert('성공시 : '+data);
				alert('공구 삭제 상태값 변경 완료');
				makeItemList();
				}
			});
		
	}
	
	 
	 function searchItem(searchType, keyword){
		 
		 cleanItemList();
			
			$.ajax({
	   			
				url : 'http://localhost:8080/wifi/items/'+searchType+'/'+keyword,
	   			type : 'GET',
	   			success : function(data){
	   				
	   				var html='';
	   				
	   				for(var i=0; i<data.length; i++){
						html+='<div class="card">';
						html+='	<ul>';
						html+='		<li>idx : '+data[i].iIdx+'</li>';
						html+='		<li>title : '+data[i].title+'</li>';
						html+='		<li>price : '+data[i].price+'</li>';
						html+='		<li>countM : '+data[i].countM+'</li>';
						html+='		<li>regDate : '+data[i].regDate+'</li>';
						html+='		<li>addr : '+data[i].addr+'</li>';
						html+='		<li>photo : '+data[i].photo+'</li>';
						html+='		<li><input type="button" value="상세보기" onclick="showDetails('+data[i].iIdx+');">';
						if(data[i].state!=10){
							html+='		<input type="button" value="삭제하기" onclick="deleteItem('+data[i].iIdx+');"></li>';
						}else {
							html+='		<span id="emphasis">삭제된 공구입니다.</span></li>';
						}
						html+='	</ul>';
						html+='</div>';
					}
	   				
	   				$('#itemList').html(html);
	   				
	   			}
	   			
	   		});
		 
	 }
	
	
	
</script>