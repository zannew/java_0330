package test.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// view page
		String viewPage = "/WEB-INF/views/null.jsp";
		
		// 응답 데이터 처리 - 하지 않음
		//Date now = new Date();
		
		// request속성에 저장 - 하지 않음
		//request.setAttribute("result", now);
		
		
		return viewPage;
	}

}
