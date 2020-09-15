<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!-- aside 공구현황 -->
<div id="aside_area">

   <!-- Sidebar/menu -->
   <nav class="w3-sidebar base-purple w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:400px;font-weight:bold;" id="mySidebar"><br>
      

      <!-- 모바일상태일 때 aside x 버튼활성화 -->
      <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px"> 
         X 
      </a>
         


      <!-- 로그아웃 버튼 -->
      <button type="button" class="btn_logout" onclick="location.href='/logout'">Logout</button>

      <!-- 프로필 -->
      <div class="profile">
         <div class="aside_myimg">
            <img src="img/사과.jpg">
         </div>
         <div class="aside_myprofile">
            <h3><b>Park Hye Mi</b></h3>
            <h4 class="myrvs">Seller ★ 4 </h4> | <h4 class="myrvb"> Buyer ★ 4.2 </h4>
         </div>
      </div>
      
         


      <!-- 탭버튼 내용 영역 : My Sale . My Order-->
      <div class="aside_tabs">
         <div class="aside_tab"><button type="button" class="btn_myItemlist btn_tab">My Sale <h4 id="alarm_s"></h4></button></div>
         <div class="aside_tab"><button type="button" class="btn_myOderlist btn_tab">My Order<h4 id="alarm_b"></h4></button></div>
      </div> 
         

      <!- 내 아이템리스트 영역 -->
      <div class="aside_myitem">

            <!-- 내 구매현황 -->
            <div id="aside_myOrderlist" class="aside_myOrderlist"></div>  

            <!-- 내 판매현황 -->
            <div id="aside_myItemlist" class="aside_myItemlist"> </div>  
      
      </div> <!-- aside_mylist end -->




   </nav>



   <!-- 모바일 상태일때, 적용되는 템플릿 -->
   <!-- Top menu on small screens -->
   <header class="w3-container w3-top w3-hide-large base-purple w3-xlarge w3-padding">
      <a href="javascript:void(0)" class="w3-button base-purple w3-margin-right" onclick="w3_open()">☰</a>
      <span>Company Name</span>
   </header>

   <!-- Overlay effect when opening sidebar on small screens -->
   <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

    



</div>
<!-- aside_area end -->