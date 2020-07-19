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

public class IdCheck_testServiceImpl implements Service {

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
		
		
		return "/WEB-INF/views/member/idCheck_test.jsp";
	}

}
