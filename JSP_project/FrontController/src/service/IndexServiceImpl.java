package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// view page
		String viewPage = "/WEB-INF/views/index.jsp";
		
		// 응답 데이터 처리 - 하지 않음
		//Date now = new Date();
		
		// request속성에 저장 - 하지 않음
		//request.setAttribute("result", now);
		
		
		return viewPage;
	}

}
