package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DateServiceImpl;
import service.GreetingServiceImpl;
import service.IndexServiceImpl;
import service.NullServiceImpl;
import service.Service;

public class FrontController extends HttpServlet{

	private Map<String, Service> commands = new HashMap<String, Service>(); 
	
	// 초기화 메서드 생성해서 type별로 객체
	@Override
	public void init() throws ServletException {
		// 다형성 사용 : serviceImpl 객체 저장
		commands.put("/", new IndexServiceImpl());
		commands.put("/index", new IndexServiceImpl());
		commands.put("/greeting", new GreetingServiceImpl());
		commands.put("/date", new DateServiceImpl());
		commands.put("null", new NullServiceImpl());
	}


	// 외부에서 실행하지 않으므로 private처리
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 사용자의 요청 파악 :  request 객체를 이용 ( url, uri, parameter...)
		// request.getParameter(name);
		// request.getRequestURL();
		// request.getRequestURI();	★★★★★
		//String type = request.getParameter("type");
		String type = null;
		String command = request.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(request.getContextPath()));
		
		
		// /fc/date라면 /date를 찾는다. → 잘라내서 type을 받는다.
		if(command.indexOf(request.getContextPath())==0) {
			type = command.substring(request.getContextPath().length());
		}
		
		System.out.println("요청 파악 : "+type);
		
		
		// 3. 핵심 처리 : 기능 수행
		Service service = commands.get(type);

		if(service==null) {
			service = commands.get("null");
		}
		
		// http://localhost:8080/fc/greeting
		// http://localhost:8080/fc/date
//		if(type == null || type.equals("/greeting") ) {
//			// 다형성 : interface 구현한 GreetingServiceImpl객체 생성
//			service = new GreetingServiceImpl();
//		} else if (type.equals("/date")) {
//			service = new DateServiceImpl();
//		} else if (type.equals("/") || type.equals("/index")){
//			service = new IndexServiceImpl();
//		} else {
//			service = new NullServiceImpl();
//		}
		
		//System.out.println("핵심 처리 결과 : "+resultObj);

		// 4. 결과 데이터를 속성에 저장 : view page에 공유(전달) → serviceImpl();로 각각 분리시킨 상태
		String page = service.getViewPage(request, response);
		
		// 5. forwarding - page 분기해서 동적으로 처리
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
	}
	
	
	// 1. Http의 요청을 받는다 : doGet, doPost();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
			
		}


		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		
		}
	
	
}
