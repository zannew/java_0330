package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
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
import member.model.MemberListView;
import service.Service;

public class MemberListServiceImpl implements Service {

	
	MemberDAO dao;
	
	// 한 페이지에 표현할 회원의 수
	private final int MEMBER_COUNT_PER_PAGE = 3;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		MemberListView memberListView = null;
		
		Connection conn = null;
		
		List<Member> memberList = null;
		
		
		try {
			
			conn=ConnectionProvider.getConnection();
			dao=MemberDAO.getInstance();
			
			
			
			// 전체 회원 수 
			int memberTotalCount = dao.selectTotalCount(conn);
			
			int startRow = 0;
			int endRow = 0;
			
			//현재 페이지 번호
			int currentPageNumber = 1;
			
			String pageNumber = request.getParameter("page");
			
			if(pageNumber!=null) {
				try {
					currentPageNumber = Integer.parseInt(pageNumber);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}
			
			
			if(memberTotalCount>0) {
				
				// 시작행,마지막행
				startRow = (currentPageNumber-1) * MEMBER_COUNT_PER_PAGE;
				endRow = startRow + MEMBER_COUNT_PER_PAGE -1;
				memberList = dao.selectMemberList(conn, startRow, endRow);
				
			} else {
				currentPageNumber=0;
				memberList = Collections.emptyList();
				
			}
			
				memberListView = new MemberListView(memberTotalCount, currentPageNumber, memberList, MEMBER_COUNT_PER_PAGE, startRow, endRow);
			
				
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
	
		request.setAttribute("listView", memberListView);
		
		return "/WEB-INF/views/member/memberList.jsp";
	}

	
	
}
