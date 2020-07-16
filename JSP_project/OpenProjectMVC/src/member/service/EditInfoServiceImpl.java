package member.service;


import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.DAO.MemberDAO;
import member.model.Member;
import service.Service;

public class EditInfoServiceImpl implements Service {

	MemberDAO dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		
		System.out.println("idx : "+request.getParameter("idx"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		Member member = null;
		String chkPw = request.getParameter("chkPw");
		String resultMsg="빈메시지";
		int resultStatus=0;
		
		System.out.println("editInfoService입니다.");
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			dao=MemberDAO.getInstance();
			
			member = dao.selectByIdx(conn, idx);
			
			if(member.getUpw().equals(chkPw)) {
				
				resultMsg="회원정보 수정을 진행합니다.";
				resultStatus=1;
				
			} else {		// 비번틀렸을 시(수정불가능)
				
				resultMsg="비밀번호가 틀렸습니다.";
				
			}

			System.out.println(resultMsg);
			System.out.println(resultStatus);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("resultMsg", resultMsg);
		request.setAttribute("resultStatus", resultStatus);
		
		
		
		return "/WEB-INF/views/member/editInfo.jsp";
	}

}
