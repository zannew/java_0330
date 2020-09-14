<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="aside_test.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>
</head>
<body>

<div class="page-wrapper chiller-theme toggled">
  <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
    <i class="fas fa-bars"></i>
  </a>
  <nav id="sidebar" class="sidebar-wrapper">
    <div class="sidebar-content">
      <div class="sidebar-brand">
        <a href="<c:url value="/index"/>">W I F I</a>
        <div id="close-sidebar">
          <i class="fas fa-times"></i>
        </div>
      </div>
      <div class="sidebar-header">
        <div class="user-pic">
          <img class="img-responsive img-rounded" src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg" alt="User picture">
        </div>
        <div class="user-info">
          <span class="user-name">
            <strong>${loginInfo.name}</strong>
          </span>
          <span class="user-role">일반회원</span>
          <span class="user-status">
            <i class="fa fa-circle"></i>
            <span>Online</span>
          </span>
        </div>
      </div>
      <!-- sidebar-header  -->
      <div class="sidebar-search">
        <div>
          <div class="input-group">
            <input type="text" class="form-control search-menu" placeholder="Search...">
            <div class="input-group-append">
              <span class="input-group-text">
                <i class="fa fa-search" aria-hidden="true" style="margin-left: 10px"></i>
              </span>
            </div>
          </div>
        </div>
      </div>
      <!-- sidebar-search  -->
      <div class="sidebar-menu">
        <ul>
          <li class="header-menu">
            <span>List</span>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <!--<i class="fa fa-tachometer-alt"></i>-->
              <span>나의 판매현황</span>
              <!--<span class="badge badge-pill badge-warning">New</span>-->
            </a>
            <div class="sidebar-submenu">
              <!-- <ul>
                <li>
                  <a href="#">Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
                <li>
                  <a href="#">Dashboard 2</a>
                </li>
                <li>
                  <a href="#">Dashboard 3</a>
                </li>
                   <li>
                  <a href="#">Dashboard 1Dashboard 1Dashboard 1Dashboard 1Dashboard 1Dashboard 1Dashboard 1Dashboard 1Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
                   <li>
                  <a href="#">Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
                   <li>
                  <a href="#">Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
                   <li>
                  <a href="#">Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
                   <li>
                  <a href="#">Dashboard 1
                    <span class="badge badge-pill badge-success">Pro</span>
                  </a>
                </li>
              </ul> -->
            </div>
          </li>
          <li class="sidebar-dropdown">
            <a href="#">
              <i class="fa fa-shopping-cart"></i>
              <span>내게 들어온 요청</span>
              <!--<span class="badge badge-pill badge-danger">3</span>-->
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="#">Products

                  </a>
                </li>
                <li>
                  <a href="#">Orders</a>
                </li>
                <li>
                  <a href="#">Credit cart</a>
                </li>
              </ul>
            </div>
          </li>
             <li class="sidebar-dropdown">
            <a href="#">
              <!--<i class="fa fa-shopping-cart"></i>-->
              <span>나의 구매현황</span>
              <!--<span class="badge badge-pill badge-danger">3</span>-->
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li>
                  <a href="#">Products

                  </a>
                </li>
                <li>
                  <a href="#">Orders</a>
                </li>
                <li>
                  <a href="#">Credit cart</a>
                </li>
              </ul>
            </div>
          </li>
       

          <li class="header-menu">
            <span>Extra</span>
          </li>
          <li>
            <a href="#">
              <i class="fa fa-book"></i>
              <span>Documentation</span>
             <!-- <span class="badge badge-pill badge-primary">Beta</span>-->
            </a>
          </li>
          <li>
            <a href="#">
              <i class="fa fa-calendar"></i>
              <span>Calendar</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="fa fa-folder"></i>
              <span>Examples</span>
            </a>
          </li>
        </ul>
      </div>
      <!-- sidebar-menu  -->
    </div>
    <!-- sidebar-content  -->
    <div class="sidebar-footer">
      <a href="#">
        <i class="fa fa-bell"></i>
        <span class="badge badge-pill badge-warning notification">3</span>
      </a>
      <a href="#">
        <i class="fa fa-envelope"></i>
        <span class="badge badge-pill badge-success notification">7</span>
      </a>
      <a href="#">
        <i class="fa fa-cog"></i>
        <span class="badge-sonar"></span>
      </a>
      <a href="#">
        <i class="fa fa-power-off"></i>
      </a>
    </div>
  </nav>
  <!-- sidebar-wrapper  -->

</div>
<!-- page-wrapper -->


<script>
	var sellUrl ='http://localhost:8080/order/sell';
	
	$(".sidebar-dropdown > a").click(function() {
		
		  $(".sidebar-submenu").slideUp(200);
		  if (
		    $(this)
		      .parent()
		      .hasClass("active")
		  ) {
		    $(".sidebar-dropdown").removeClass("active");
		    $(this)
		      .parent()
		      .removeClass("active");
		  } else {
		    $(".sidebar-dropdown").removeClass("active");
		    $(this)
		      .next(".sidebar-submenu")
		      .slideDown(200);
		    $(this)
		      .parent()
		      .addClass("active");
		  }
		  
		  var newHtml='<ul>';
		  var html='';
		  console.log('loginInfo.midx : '+${loginInfo.midx});
		  
		  $.ajax({
			 
			  url: sellUrl,
				type:'GET',
				data : {
					'midx': ${loginInfo.midx},
					'count':20
				},
				success : function(data){
					alert('나의 공구 불러오기 성공');
					console.log(data);
	    	         
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
		 				var ireceive = moment(data.sellList[i].ireceive).format('YYYY-MM-DD HH:mm');
						
		 				//MySellTotalList.push(new MySell(midx, iidx, oidx, pidx, title, category, istate, ostate, pstate, ireceive));
		    			/*
		    			
		    			<li>
	                  		<a href="#">Dashboard 2</a>
	                	</li>
	                	
	                	*/
	                	
	                	newHtml+='<li>';
	                	newHtml+='	<a href="#">'+title;
	                	newHtml+='	</a>';
	                	newHtml+='</li>';
	
	                	html+='<div class="mysell">';
		    			html+='	<button onclick="showDetails('+iidx+')" style="border:0; outline:0; background-color:white; cursor:pointer;">';
						html+='		<span>내idx : '+midx+'</span> |';
						html+='		<span>공구번호 : '+iidx+'</span> |';
						html+='		<span>제목 : '+title+'</span> |';
						html+='		<span>'+ireceive+'까지</span> |';
						if(istate==1){
							html+='		<span style="background-color:violet; color:white; font-weight:bold;">추천공구 등록중</span>';
						} else {
							html+='		<span style="background-color:black; color:white; font-weight:bold;">일반공구</span>';
							
						}
						//html+='		<span>ostate : '+ostate+'</span>';
						//html+='		<span>pstate : '+pstate+'</span>';
						// 0823추가
						// 오늘이전 + ostate-null + pstate-null (null을 3으로 치환) → 판매실패
						if((new Date(ireceive) < new Date()) && ostate==3 && pstate==3){
							html+='		<span style="background-color:red; color:white; font-weight:bold">판매실패</span>';
						 }
						// 오늘이전 또는 이후 + ostate-0 + pstate-1 → 판매완료
						if(ostate==0 && pstate==1){
							html+='		<span style="background-color:green; color:white; font-weight:bold">판매완료</span>';
						 }
						// 오늘이후 + ostate-null + pstate-null → 모집중
						if((new Date(ireceive) > new Date()) && ostate==3 && pstate==3){
							html+='		<span style="background-color:yellow; font-weight:bold">모집중</span>';
						 }
						// 오늘이후 + ostate-0 + pstate-0 → 모집완료 (오늘 이전도 체크필요!!) 
						if((new Date(ireceive) < new Date()) && ostate==0 && pstate==0){
							html+='		<span style="background-color:blue; color:white; font-weight:bold">모집완료</span>';
						 }
						html+='		<span><input type="button" value="요청보기" onclick="showRequestList('+midx+');">';
		    			html+='	</button>';
						html+='</div>';
		    		}
						html+='		<input type="button" value="닫기" onclick="closeMySell();"></span>';
					
						newHtml+='</ul>';
					console.log('판매현황  sellList : '+data.sellList);
		    		
		    		var pageTotalCount = data.itemTotalCount/data.itemCountPerPage;
					var itemCountPerPage = data.itemCountPerPage;
					var startRow = data.startRow;
	    	
					//MySellListView.push(new SellListView(itemTotalCount, currentPageNumber, data.sellList, pageTotalCount, itemCountPerPage, startRow));
	
		    	pageNum++;
		    	loading=false;
		    	console.log('판매현황 : '+newHtml);
		    	//cleanSellList();
		    	//document.getElementById('aside').style.display='block';
		    	$('div.sidebar-submenu').append(newHtml);
		    	
		    	
				},
				error: function(){
					alert('나의 공구 불러오기 실패');
				}
			  
		  });
		  
		  
		  
		});
	
	$("#close-sidebar").click(function() {
	  $(".page-wrapper").removeClass("toggled");
	});
	$("#show-sidebar").click(function() {
	  $(".page-wrapper").addClass("toggled");
	});


</script>



</body>
</html>

