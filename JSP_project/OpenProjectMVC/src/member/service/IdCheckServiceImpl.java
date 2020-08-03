package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jdbc.ConnectionProvider;
import member.DAO.MemberDAO;
import service.Service;

public class IdCheckServiceImpl implements Service {

	MemberDAO dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// request에 결과갑 Y|N만 보내주면 ok
		//boolean check = false;
		String result = "N";
		
		String id = request.getParameter("uid");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDAO.getInstance();
			int resultCnt = dao.selectById(conn, id);
			
			if(resultCnt==0) {
				result = "Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("idcheck", result);
		
		
		return "/WEB-INF/views/member/idCheck.jsp";
	}

}
