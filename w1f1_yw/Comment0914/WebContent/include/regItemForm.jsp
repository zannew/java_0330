<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


   <!-- 공구등록 영역 -->
   <div class="w3-container" id="itemRegForm_area" style="margin-top:65px;" >

      <!-- 타이틀 -->
      <h2 class="w3-xlarge text-purple"><b>Item RegForm</b></h2>
      <hr style="width:50px;border:5px solid purple;"  class="w3-round">

      <!-- 공구 등록 폼 -->
      <div id="regItemForm_page">
         <form id="regItemForm" onsubmit="return false;" >
            <label for="title">제목</label>    
            <input type="text"  id="title" name=title required>
            
            <label for="price">가격</label> 
            <input type="number"  id="price" name="price" required>원
            
            <label for="count_m">모집인원</label>       
            <input type="number" id="count_m" name="count_m" required>명
            
            <label for="receive">물품수령일시</label>     
            <input type="datetime-local"  id="receive" name="receive" required>
               
            <label for="addr">판매처</label>      
            <input type="text" id="addr" name="addr">
            
            <label for="location">좌표</label>    
            <input type="text" id="location" name="location">
            
            <label for="content">본문</label>      
            <textarea id="content"  name="content" rows="10" cols="30">
            내용을 작성해주세요.
            </textarea>
         
            <label for="photo">첨부사진</label>
            <input type="file" id="photo" name="photo">
               
            <label for="category">카테고리</label> 
                  <select id="category" name="category">
                     <option value="0" selected>전체</option>
                     <option value="1">1.과일/채소</option>
                     <option value="2">2.육류/해산물</option>
                     <option value="3">3.생필품/기타</option>
                  </select>

            <input type="radio" name="state" class="state" value="0" checked>일반공구로 등록하기
            <input type="radio" name="state" class="state" value="1">추천공구로 등록하기
                  
            <label for="regItem_midx">작성자</label>
            <input type="text" value="2" id="midx" name="midx" disabled>
            <input type="submit" value="공구등록" onclick="regSubmit();">
         </form>

      </div>  <!-- regItemForm_page  end -->



   </div>  <!-- itemRegForm_area  end -->