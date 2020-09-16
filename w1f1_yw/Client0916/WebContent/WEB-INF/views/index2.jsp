%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
       <title>kakaoLogin</title>
       <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
   </head>
   <body>

        


    <c:if test="${userId eq null}">
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=f5e0701c39876968f090e686afa45c4a&redirect_uri=http://localhost:8080/order/login&response_type=code">
        <img src="img/kakaoLogin.png">
    </a>
    </c:if>
    <c:if test="${userId ne null}">
        <h1>로그인 성공입니다</h1>
        <input type="button" value="로그아웃" onclick="location.href='/logout'">
    </c:if>


   </body>
   </html>