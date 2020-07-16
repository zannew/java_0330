package member.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import member.DAO.MemberDAO;
import service.Service;

public class EditMemberConfirmServiceImpl implements Service {

	MemberDAO dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		return "/WEB-INF/views/member/editMemberConfirm.jsp";
	}

}
