package test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import lms.DAO.CourseDao;
import lms.DAO.StudentDao;
import lms.model.Course;
import lms.model.Student;

public class CourseListServiceImpl implements Service {

	
	//수강신청 페이지에서 +버튼으로 저장해주는
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
				CourseDao dao;
				int sIdx=0;
				int cIdx=0;
				List<Course> courseList = new ArrayList<Course>();
				
				
				String result = "";

				Connection conn = null;
				
				try {
					conn = ConnectionProvider.getConnection();
					dao = CourseDao.getInstance();
					int resultCnt = dao.insertMyCourse(conn);
					
					if(resultCnt==0) {
						result = "ok";
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				request.setAttribute("courseList", result);
		
		
		return "/WEB-INF/views/courseList/CourseList.jsp";
	}

}
