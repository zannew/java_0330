package com.wifi.login.service;

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
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoLoginService {

	private final static String CLIENT_ID = "99ffb3979d63e105be37c6521fa33a53";
	private final static String REDIRECT_URI_LOGIN = "http://localhost:8080/wifi/kakaoLogin";
	private final static String REDIRECT_URI_LOGOUT = "http://localhost:8080/wifi/kakaoLogout";

	public static String getAuthorizationUrl(HttpSession session) {
		String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?" 
						+ "client_id=" + CLIENT_ID 
						+ "&redirect_uri="+ REDIRECT_URI_LOGIN 
						+ "&response_type=code";
		return kakaoUrl;
	}
	
	public static String getLogoutUrl(HttpSession session) {
		String logoutUrl = "https://kauth.kakao.com/oauth/authorize?" 
				+ "client_id=" + CLIENT_ID 
				+ "&redirect_uri="+ REDIRECT_URI_LOGOUT 
				+ "&response_type=code";
		return logoutUrl;
		
	}

	public static JsonNode getAccessToken(String autorize_code) { 
		
		final String REQUESTURL = "https://kauth.kakao.com/oauth/token"; 
		
		final List<NameValuePair> POSTPARAMS = new ArrayList<NameValuePair>(); 
		
		POSTPARAMS.add(new BasicNameValuePair("grant_type", "authorization_code")); 
		POSTPARAMS.add(new BasicNameValuePair("client_id", "99ffb3979d63e105be37c6521fa33a53")); // REST API KEY 
		POSTPARAMS.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/wifi/kakaoLogin")); // 리다이렉트 URI 
		POSTPARAMS.add(new BasicNameValuePair("code", autorize_code)); // 로그인 과정중 얻은 code 값 
		POSTPARAMS.add(new BasicNameValuePair("client_secret", "fKBuMkBWgF1Q3FTUZPCA34PKrn2kwU7C"));
		
		/* 
		 * 보안 강화 : 추가적 코드???
		 * 
		 * */
		
		final HttpClient CLIENT = HttpClientBuilder.create().build(); 
		
		final HttpPost POST = new HttpPost(REQUESTURL); 
		
		JsonNode returnNode = null; 
		
		try { 
			
			POST.setEntity(new UrlEncodedFormEntity(POSTPARAMS)); 
			
			final HttpResponse RESPONSE = CLIENT.execute(POST); // JSON 형태 반환값 처리 
			
			ObjectMapper mapper = new ObjectMapper(); 
			
			returnNode = mapper.readTree(RESPONSE.getEntity().getContent()); 
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); 
		} catch (ClientProtocolException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} finally { // clear resources 
			
		} 
			return returnNode; 
		} 
	
	
	public static JsonNode getKakaoUserInfo(JsonNode accessToken) { 
		
		final String REQUESTURL = "https://kapi.kakao.com/v2/user/me"; 
		final HttpClient CLIENT = HttpClientBuilder.create().build(); 
		final HttpPost POST = new HttpPost(REQUESTURL); // add header 
		
		POST.addHeader("Authorization", "Bearer " + accessToken); 
		JsonNode returnNode = null; 
		
		try { 
		
			final HttpResponse response = CLIENT.execute(POST); // JSON 형태 반환값 처리 
			ObjectMapper mapper = new ObjectMapper(); 
			returnNode = mapper.readTree(response.getEntity().getContent()); 
			
		} catch (ClientProtocolException e) { 
			e.printStackTrace(); 
		
		} catch (IOException e) { 
			e.printStackTrace(); 
		
		} finally { // clear resources 
				
		} 
		
		return returnNode;
		
	}
}

	
