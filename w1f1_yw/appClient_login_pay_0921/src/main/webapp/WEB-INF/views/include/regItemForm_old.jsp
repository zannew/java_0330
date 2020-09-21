<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- regArea (hidden by default) -->
<div id="regArea" class="w3-modal">
   <div class="regForm w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
      <div class="w3-center"><br>
         <span onclick="closeRegForm();" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
      </div>
      
      <form id="regForm" class="w3-container" onsubmit="return false;">
         <div class="w3-section">
            <label><b>제목</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" name="title" id="title" required>
            
            <label><b>가격</b></label>
            <input class="w3-halfInput w3-border w3-margin-bottom" type="text" pattern="[0-9]*" name="price" id="price" required>
            
            <label><b>공구인원</b></label>
            <input class="w3-halfInput w3-border w3-margin-bottom" type="number" name="count_m" id="count_m" min="1" required> <br>
            
            <label><b>수령날짜</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="datetime-local" name="receive" id="receive" required>
            
            <label><b>판매처 주소</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" name="addr" id="addr" required>
            
            <label><b>판매처 위치</b></label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" name="location" id="location">
            
            <label><b>분류</b></label>
            <select id="category" class="w3-padding-8 w3-border w3-margin-bottom">
              <option value="0">과일</option>
              <option value="1">육류</option>
              <option value="2">해산물</option>
              <option value="3">채소</option>
              <option value="4">생필품</option>
              <option value="5">음료</option>
              <option value="6">기타</option>
            </select>
            
            <label><b>사진</b></label>
            <input class="w3-halfInput w3-border w3-margin-bottom" type="file" name="photo" id="photo"><br>
            
            <label><b>내용</b></label>
            <textarea class="w3-itemContent w3-border w3-margin-bottom" name="content" id="content" required></textarea>
            
            <label><b>공구 상태</b></label><br>
            <input class="w3-radio w3-border" type="radio" name="state" id="recommend" value="1"><label for="recommend">추천공구로 등록하기</label><input class="w3-radio w3-border" type="radio" name="state" id="normal" value="0"><label for="normal">일반공구로 등록하기</label><br>
            <input type="text" id="setPayInfo" readonly/>
            
            <!-- 김승연 2020. 09. 18 -->
            <!-- 로그인한 멤버 idx 추출 -->
            <input type="number" name="midx" id="midx" value="${loginMidx}">
            
            <button class="w3-button .w3-halfBlock w3-green w3-section w3-padding" type="submit" id="regSubmit">공구등록</button>
            <button onclick="closeRegForm();" type="button" class="w3-button w3-red">취소</button>
         </div>
      </form>
   </div>
</div> <!-- regArea end -->