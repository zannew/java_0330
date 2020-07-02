package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	
	//cookie 목록을 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//why public? → JSP에서 사용하기 위해
	public CookieBox(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		//쿠키 데이터를 Map에 모두 저장
		for(int i=0;i<cookies.length;i++) {
			//Map에 데이터 저장
			cookieMap.put(cookies[i].getName(), cookies[i]);
		}
	}
	
	//쿠키를 반환하는 메서드(request를 직접 사용하지 않고 반환한다.)
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	//value를 반환하는 메서드(request를 직접 사용하지 않고 반환한다.)
	public String getValue(String name) {

		String result = null;
		Cookie cookie = getCookie(name);
		
		if(cookie!=null) {
			result=cookie.getValue();
		}
		return result;
	}
	
	//존재 여부 체크메서드
	public boolean exist(String name) {
		return cookieMap.get(name)!=null;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//쿠키 객체 생성 메서드 - 기본 (오버로딩1)
	public static Cookie createCookie(String name, String value) {
		return new Cookie(name, value);
	}
	
	//쿠키 객체 생성 메서드 - 기본 + 경로, 유지 시간 (오버로딩2)
	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		
		//경로 설정
		cookie.setPath(path);
		
		//시간 설정
		cookie.setMaxAge(maxAge);
		
		return cookie;
	}
	
	//쿠키 객체 생성 메서드 - 기본 + 경로, 유지 시간, 도메인 (오버로딩3)
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		
		//도메인 설정
		cookie.setDomain(domain);
		
		//경로 설정
		cookie.setPath(path);
		
		//시간 설정
		cookie.setMaxAge(maxAge);
		
		return cookie;
	}
	
	
	
	
	
	
}
