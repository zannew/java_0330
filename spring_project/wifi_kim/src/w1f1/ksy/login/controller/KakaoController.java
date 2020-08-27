package w1f1.ksy.login.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class KakaoController {
	
	
	// 카카오 디벨로퍼스에서 발급받은 REST API 키
	private final static String K_CLIENT_ID = "b05c1b29d546be51b63bd8500a0d05d0";
	
	// 카카오 디벨로퍼스에서 설정한 리다이렉트 uri
	private final static String K_REDIRECT_URI_LOGIN = "http://ec2-3-34-197-135.ap-northeast-2.compute.amazonaws.com/wifi/kakaoCheck";
	
	// 로그아웃을 위한 리다이렉트 uri
	private final static String K_REDIRECT_URI_LOGOUT = "http://ec2-3-34-197-135.ap-northeast-2.compute.amazonaws.com/wifi/logout";
	
	public static String logoutRequestUrl (
			HttpSession session
			) {
		String logoutUrl = "https://kauth.kakao.com/oauth/logout?"
				+ "client_id="+K_CLIENT_ID
				+ "&logout_redirect_uri="+K_REDIRECT_URI_LOGOUT;
		
		return logoutUrl;
	}
	
	public static String getAuthorizationUrl (HttpSession session) {
		String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?"
				+ "client_id="+K_CLIENT_ID
				+"&redirect_uri="+K_REDIRECT_URI_LOGIN
				+"&response_type=code";
		
		return kakaoUrl;
	}
	
	
	public static JsonNode getAccessToken(String code) {
		
		final String REQUESTURL = "https://kauth.kakao.com/oauth/token";
		final List<NameValuePair> POSTPARAMS = new ArrayList<NameValuePair>();
		
		// "authorization_code"로 고정
		POSTPARAMS.add(new BasicNameValuePair("grant_type", "authorization_code"));
		
		// 앱 생성 시 발급받은 REST API key값
		POSTPARAMS.add(new BasicNameValuePair("client_id", "b05c1b29d546be51b63bd8500a0d05d0"));
		
		// 로그인 시 받은 인증코드를 리다이렉트 해주는 uri 
		// (localhost 포트번호 8080으로 변경해서 사용하면 됨, AWS 배포시엔 AWS 도메인주소로? )
		POSTPARAMS.add(new BasicNameValuePair("redirect_uri", "http://ec2-3-34-197-135.ap-northeast-2.compute.amazonaws.com/wifi/kakaoCheck"));
		
		// 토큰 발급 시, 보안 강화를 위해 추가로 확인하는 코드
		POSTPARAMS.add(new BasicNameValuePair("client_secret", "vVaEwYPDgLrw3XqYKqt9mRH8oDK9UNOl"));
		
		// 로그인 과정 중 인증코드 받기 요청으로 얻은 code값
		POSTPARAMS.add(new BasicNameValuePair("code", code));
		System.out.println(code);
		
		final HttpClient client = HttpClientBuilder.create().build();
		
		final HttpPost post = new HttpPost(REQUESTURL);
		
		JsonNode returnNodeCode = null;
		
		try {
			post.setEntity(new UrlEncodedFormEntity(POSTPARAMS));
			
			final HttpResponse response = client.execute(post);
			
			// 오류 페이지 번호확인
			final int responseCode = response.getStatusLine().getStatusCode();
			System.out.println(responseCode);
			
			ObjectMapper mapper = new ObjectMapper();
			
			returnNodeCode = mapper.readTree(response.getEntity().getContent());
			System.out.println("발급된 회원코드 JSON 변환 확인 : " + returnNodeCode);			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return returnNodeCode;
	}
	
	public static JsonNode getKakaoUserInfo (JsonNode accessToken) {
		
		
		final String RequestUrl = "https://kapi.kakao.com/v2/user/me";		
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);
		
		
		post.addHeader("Authorization", "Bearer "+ accessToken);
		JsonNode returnNodeInfo = null;
		
		try {
			final HttpResponse response = client.execute(post);
			// 오류 페이지 번호확인
			final int responseCode = response.getStatusLine().getStatusCode();
			
	        System.out.println("Sending 'POST' request to URL : " + RequestUrl);
	        System.out.println("Response Code : " + responseCode);
			
			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			returnNodeInfo = mapper.readTree(response.getEntity().getContent());
			System.out.println("회원정보 JSON 변환 확인 : " + returnNodeInfo);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return returnNodeInfo;
	}
	


}
