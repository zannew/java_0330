package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Course;

public class CourseListServiceImpl implements Service {

	CourseDao dao;
	
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// view 로 전달할 결과 데이터
		
		// courseList
		List<Course> courseList = null;

		
		// JSON 문자열
		String listJson = null;
		
		Connection conn = null;

		try {
			conn=ConnectionProvider.getConnection();
			dao=CourseDao.getInstance();
			
			courseList=dao.selectTotalCourse(conn);
			Gson gson = new Gson();
			
			// Java Object -> JSON
			listJson = gson.toJson(courseList);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("courselist", listJson);
		
		return null;
	}

}
