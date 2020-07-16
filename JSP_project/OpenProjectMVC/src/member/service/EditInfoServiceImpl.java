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

		
		return "/WEB-INF/views/member/editInfo.jsp";
	}

}
