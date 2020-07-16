package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.DAO.MemberDAO;
import member.model.Member;
import service.Service;

public class EditMemberServiceImpl implements Service {

	MemberDAO dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		String newPw = request.getParameter("newPw");
		String newPhoto = request.getParameter("newPhoto");
		int resultCnt = 0;
		Member member = null;
		String chkPw = request.getParameter("chkPw");
		String resultMsg="빈메시지";
		String returnPath="";
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			dao=MemberDAO.getInstance();
			
			member = dao.selectByIdx(conn, idx);
			
			if(member.getUpw().equals(chkPw)) {
				
				resultCnt = dao.editMember(conn, idx, newPw, newPhoto);
				
				if(resultCnt==1) {
					resultMsg="정상적으로 수정되었습니다.";
				} else {
					resultMsg="수정하실 회원정보를 찾지 못했습니다.";
				}
				
			} else {		// 비번틀렸을 시(수정불가능)
				
				resultMsg="비밀번호가 틀렸습니다.";
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("resultMsg", resultMsg);
		
		return "/WEB-INF/views/member/editMember.jsp";
		
	}

}
