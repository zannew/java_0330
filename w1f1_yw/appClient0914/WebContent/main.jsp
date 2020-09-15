<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Main Page</title>

  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300;500;700&display=swap" > <!-- 영문폰트 -->
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 한글폰트 -->

  <link rel="stylesheet" href="css/item.css" type="text/css">
  <link rel="stylesheet" href="css/search.css" type="text/css">
  <link rel="stylesheet" href="css/aside.css" type="text/css">
  <link rel="stylesheet" href="css/swiper.css" type="text/css">
  <link rel="stylesheet" href="css/swiper.min.css" type="text/css"> <!-- swiper관련 -->
  <link rel="stylesheet" href="package/swiper-bundle.min.css">  <!-- swiper관련 -->
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> <!-- 평점등록 시 별모양 나타내는  -->

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>  <!-- 평점등록 시 별 마우스오버 계속 반응  -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script> <!-- 날짜포멧 -->
  <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.11/lodash.min.js"></script>   <!-- 데이터를 정렬/필터/색인할 수 있게 도와주는 오픈소스 Javascript Utility Library -->
  
</head>
<body>

  <!-- aside 영역 : 프로필. 판매&구매현황 -->
  <%@include file="include/aside.jsp"%>


  <!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:450px;margin-right:40px">


    <!-- header영역 : 타이틀. 검색 -->
    <%@include file="include/header.jsp"%>



    <!-- content영역 : 공구등록폼 / 공구상세보기/ 공구리스트(추천글.일반글) -->
    
      <!-- content영역-1 : 공구등록 폼 -->
      <%@include file="include/regItemForm.jsp"%>

      <!-- content영역-2 : 공구상세보기  -->
      <div id="itemView_area" class="itemView_area"></div> 


      <!-- content영역-3 : 공구리스트(추천글.일반글) -->
      <div id="itemlist_area">

        <!-- 추천글 Recommended item area-->
        <div class="w3-container" id="Recommended" style="margin-top:65px;" >

          <!-- 추천글 - 타이틀 -->
          <h2 class="w3-xlarge text-purple"><b>Recommended item</b></h2>
          <hr style="width:50px;border:5px solid purple;"  class="w3-round">
        
          <!-- 추천글 리스트 Swiper  -->
          <section class="ag-slide-block">
            <div class="swiper-container"></div>
          </section>

        </div> <!-- Recommende end -->



        <!-- 일반글 Item area-->
        <div class="w3-container" id="item" style="margin-top:75px;" >

          <!-- 일반글 - 타이틀. 등록버튼. 정렬버튼 -->
          <h2 class="w3-xlarge text-purple"><b>item</b></h2>
            <button type="button" class="btn_sort sort_reg"  onclick="allItemlist()">Latest Sort</button>
            <button type="button" class="btn_sort sort_rvs" onclick="allItemlist_sortRvs()">Rating Sort</button>
            <button type="button" class="btn_regItem" onclick="regItemForm()">item +</button>
          <hr style="width:50px; border:5px solid purple; " class="w3-round">
          
          <!-- 일반글 리스트 -->
          <div id="itemlist_small_area"></div> 

        </div>  <!-- Item area end -->


      </div> <!-- itemlist_area end -->



  </div>  <!-- w3-main end -->




  <!-- footer -->
  <div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px">
    <p class="w3-right">Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">w3.css</a></p>
  </div>

  

  

</body>
  <script src="js/swiper.min.js"></script>
  <script src="js/swiper.js"></script> 
  <script text="text/javascript" src="js/item.js"></script>   <!-- 공구 검색 / 리스트 출력 / 정렬 / 등록 / 삭제 -->
  <script text="text/javascript" src="js/seller.js"></script> <!-- aside 판매자 -->
  <script text="text/javascript" src="js/buyer.js"></script>  <!-- aside 구매자 -->
    
    


</html>
