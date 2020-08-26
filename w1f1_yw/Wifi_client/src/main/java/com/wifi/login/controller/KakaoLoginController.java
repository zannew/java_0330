package com.wifi.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.wifi.login.service.KakaoLoginService;

@Controller
public class KakaoLoginController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView kakaoLoginForm(HttpSession session) {
		
		ModelAndView mandv = new ModelAndView();
		
		String kakaoUrl = KakaoLoginService.getAuthorizationUrl(session);
		
		System.out.println("KakaoLoginController-KakaoLoginForm : "+kakaoUrl);
		
		mandv.addObject("kakaoUrl", kakaoUrl);
		
		return mandv;
	}
	
	@RequestMapping(value="/kakaoLogin", produces="application/json", method={RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code, 
							HttpServletRequest request, 
							HttpServletResponse response, 
							HttpSession session) {
		
		System.out.println("code값 : "+code);
		//"code"를 통해 발급받은 토큰값을 JSON타입으로 저장
		JsonNode node = KakaoLoginService.getAccessToken(code);
		System.out.println("node값 : "+node);
		
		// 발급 받은 토큰값을 JSON타입으로 저장
		JsonNode accessToken = node.get("access_token");
		System.out.println("access_token값 : "+accessToken);
		String accessTokenStr = accessToken.asText();

		session.setAttribute("token", accessTokenStr);
		System.out.println("accessTokenStr값 : "+accessTokenStr);
		
		// 액세스 토큰을 통해 로그인한 사용자 정보 JSON타입으로 저장
		JsonNode userInfo = KakaoLoginService.getKakaoUserInfo(accessToken);
		System.out.println("userInfo값 : "+userInfo);
		
		// JSON타입으로 사용자 정보 추출해서 저장
		String id=userInfo.path("id").asText();
		String nickname = null;
		String email = null;
		
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		
		if(properties.isMissingNode() && kakao_account.isMissingNode()) {
			System.out.println("properties랑 kakao_account 비었따..");
		} else {
			nickname = properties.path("nickname").asText();
			email = kakao_account.path("email").asText();
			System.out.println("nickname값 : "+nickname);
			System.out.println("email값 : "+email);
		}
		
		// 세션에 아이디, 닉네임, 이메일 저장
		session.setAttribute("id", id);
		session.setAttribute("name", nickname);
		session.setAttribute("email", email);
		
		return "member/kakaoInfo";
	}
	
	
	
}
