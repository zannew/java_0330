package w1f1.ksy.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;

import w1f1.ksy.login.model.LoginRequest;
import w1f1.ksy.login.service.MemberLoginService;

// kakaoController 에서 생성된 코드와 토큰값을 통해 
// 카카오 로그인 정보를 JSON 형태로 리다이렉트 해주는 컨트롤러

@Controller
public class KakaoLoginController {
	
	@Autowired
	MemberLoginService loginService;
	
	
	// 카카오 디벨로퍼스에서 미리 설정한 REST API의 리다이렉트 경로를 리턴하는 메서드 
	@RequestMapping(value="/index", method= RequestMethod.GET)
	public ModelAndView KakaoLoginForm (HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		String logoutUrl = KakaoController.logoutRequestUrl(session);
		mav.addObject("kakao_url", kakaoUrl);
		mav.addObject("logout_url",logoutUrl);
		
		System.out.println("KakaoLoginController.kakaoLoginForm : " + kakaoUrl);
		System.out.println("KakaoLoginController.kakaoLogoutForm : " + logoutUrl);
		return mav;
	}
	
	
	// 리다이렉트로부터 토큰값을 받아 카카오 로그인정보를 세션에 저장하고 리턴하는 메서드
	@RequestMapping(value="/kakaoCheck", produces= "application/json", method= {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin (
			@RequestParam("code") String code,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
			) {
		
		// kakaoController로 부터 코드를 통해 발급받은 토큰값을 Json 형태로 저장
		JsonNode node = KakaoController.getAccessToken(code);
		// 발급 받은 토큰을 Json 형태로 저장
		JsonNode accessToken = node.get("access_token");
		System.out.println("액세스 토큰 확인 : >>>>>" + accessToken);
		String token = accessToken.toString();
		
		session.setAttribute("token", token);
		System.out.println("token 값 확인 : >>>>>" + token);
		
		// 엑세스 토큰을 통해 로그인 한 사용자의 정보를 Json형태로 저장
		JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
		System.out.println(userInfo);
		
		
		
		// json 형태로 저장된 사용자 정보를 추출하여 저장하는 과정
		String id = userInfo.path("id").asText();
		String nickname = null;
		String email = null;
		
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		
		if(properties.isMissingNode() && kakao_account.isMissingNode()) {
			
		} else {
			nickname = properties.path("nickname").asText();
			email = kakao_account.path("email").asText();
		}
		System.out.println("id : " + id);
		System.out.println("nickname : " + nickname);
		
		
		// 추출한 사용자 정보를 세션에 저장
		session.setAttribute("id", id);
		session.setAttribute("name", nickname);
		session.setAttribute("email", email);
		
		
		// 새로운 페이지로 리턴
		return "member/kakaoInfo";
	}
	
	@RequestMapping(value="/logout")
	public String kakaoLogout(HttpSession session) {
			
		System.out.println("카카오 세션 만료 매핑 실행");
		session.removeAttribute("loginInfo");
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("email");
		
		return "/member/kakaoLogout";
	}
	

}
