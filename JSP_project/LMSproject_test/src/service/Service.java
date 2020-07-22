package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	
	
	// view 를 연결해줄 Service 인터페이스입니다.
	String getViewPage(HttpServletRequest request, HttpServletResponse response);
	
	
	

}
