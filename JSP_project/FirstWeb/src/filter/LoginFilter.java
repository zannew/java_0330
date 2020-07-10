package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// 사용하지 않으면 그냥 둔다.

	}
	
	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response, 
						FilterChain chain) 
						throws IOException, ServletException {
										
		// 1. 현재 세션 객체를 확인
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		// 현재 세션의 객체 → 로그인 여부 체크
		// 기본형태 : 있으면 가져오고, 없으면 생성
		// true : 무조건 새로운 객체 생성
		// false : 있으면 가져오고, 없다면 null을 반환한다
		HttpSession session = httpRequest.getSession(false); 
		
		// 로그인 유무를 확인하는 변수
		boolean login = false;
		
		if(session!=null && session.getAttribute("memberInfo")!=null) {
				login = true;
		}
		
		if(login) {
			
			chain.doFilter(request, response);
			
		} else {
			// forward할 페이지 경로
//			String path = "/member/sessionLoginForm.jsp";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
			
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			
			String location = httpRequest.getContextPath()+"/member/sessionLoginForm.jsp";
			httpResponse.sendRedirect(location);
			
			
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 사용하지 않으면 그냥 둔다.

	}

}
