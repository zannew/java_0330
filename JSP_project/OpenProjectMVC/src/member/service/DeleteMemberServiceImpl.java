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

public class DeleteMemberServiceImpl implements Service {

	MemberDAO dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int resultCnt = 0;
		Member member = null;
		String chkPw = request.getParameter("chkPw");
		String resultMsg="빈메시지";
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			dao = MemberDAO.getInstance();
			
			
			member = dao.selectByIdx(conn, idx);
			
			System.out.println("upw : "+member.getUpw());
			System.out.println("chkpw : "+chkPw);
			
			//1. 입력했던 비밀번호가  맞는지 아닌지 분기 처리
			//2. 맞으면 삭제 진행 아니면 틀림 메시지주기
			if(member.getUpw().equals(chkPw)) {

				resultCnt = dao.deleteMember(conn, idx);
				
				if(resultCnt==1) {
					resultMsg="정상적으로 삭제되었습니다.";
				} else {
					resultMsg="삭제하실 회원정보가 없습니다.";
				}
			} else {
				resultMsg="비밀번호가 틀렸습니다.";
			}
			
			
			//System.out.println(resultMsg);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("resultMsg", resultMsg);
		
		
		return "/WEB-INF/views/member/deleteMember_view.jsp";
	}

}
