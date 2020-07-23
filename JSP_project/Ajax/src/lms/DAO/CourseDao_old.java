package lms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lms.model.Course;
import lms.model.Student;



public class CourseDao_old {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private CourseDao_old () {
		
	}
	
	private static CourseDao_old dao = new CourseDao_old();
	
	public static CourseDao_old getInstance() {
		return dao;
	}
	
	
	// 강의 등록 : insert
	
	public int insertCourse ( Connection conn, Course course) throws SQLException {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO `project`.`course` "
				+ "(`name`,`teacher`,`content`,`day`,`startTime`,`endTime`,`totalPer`,`applyPer`, 'tIdx') "
				+ "VALUES (?,?,?,?,?,?,?,?,?);";
		
		// 마지막값 tIdx는 교수번호를 Model에서 가져와야..
		
		try {
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, course.getcIdx());
			pstmt.setString(1, course.getName());
			pstmt.setString(2, course.getTeacher());
			pstmt.setString(3, course.getContent());
			pstmt.setString(4, course.getDay());
			pstmt.setTime(5, course.getStartTime());
			pstmt.setTime(6, course.getEndTime());
			pstmt.setInt(7, course.getTotalPer());
			pstmt.setInt(8, course.getApplyPer());
			pstmt.setInt(9, course.gettIdx()); // 외래키인 교수번호는 hidden으로 감춰져있는 값을 받아옴 (비식별값)
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	// 개설강의 이름으로 조회 : select
	
	public int selectCourseByName (Connection conn, Course course) throws SQLException {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs;
		
		try {
			
			String sql = "SELECT * FROM `project`.`course` where name=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getName());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		

		return result;
		
	}
	
	
	// 개설 강의 삭제 : delete ?
	
	public int deleteCourse(Connection conn, Course course) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from course where cIdx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, course.getcIdx());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}
	
	// 개설 강의 수정 : update ?
	
	public int editCourse(Connection conn, Course course) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "update course set name=?, teacher=? , content=?, day=?, startTime=?, endTime=?, totalPer=?, applyPer=?"
				+ "where cIdx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getName());
			pstmt.setString(2, course.getTeacher());
			pstmt.setString(3, course.getContent());
			pstmt.setString(4, course.getDay());
			// 시간만을 저장 : 형식 'hhmmss'
			pstmt.setTime(5, course.getStartTime());
			pstmt.setTime(6, course.getEndTime());
			pstmt.setInt(7, course.getTotalPer());
			pstmt.setInt(8, course.getApplyPer());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}
	
	// 수강신청한 강의 리스트 조회 : myCourse 조회 = select  ? 
	
	public int selectMyCourse(Connection conn, Course course, Student student) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			// 학번으로 내가 등록한 강의 리스트 출력
			String sql = "SELECT * FROM project.myCourse where sIdx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getsIdx());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}
	
	// 수강신청한 강의 취소 : myCourse 조회 => delete ? 
	
	public int deleteMyCourse(Connection conn, Course course, Student student) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;
		
		// delete에선 결과값을 가져올 필요가 없으니 rs가 필요 없지 않을까용?
		ResultSet rs;

		try {
			// 학번으로 내가 등록한 강의 리스트 출력
			String sql = "DELETE FROM project.myCourse where sIdx=? cIdx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getsIdx());
			pstmt.setInt(2, course.getcIdx());

			rs = pstmt.executeQuery();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}
	
	
	
	// 개설된 강의 정보전체 리스트 : ArrayList ?
	public List<Course> courseList (Connection conn ) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs;
		
		List<Course> courseList = new ArrayList<Course>();
		
		String sql = "SELECT * FROM project.course;";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Course course = new Course();
				course.setcIdx(rs.getInt("cIdx"));
				course.setName(rs.getString("name"));
				course.setTeacher(rs.getString("teacher"));
				course.setContent(rs.getString("content"));
				course.setDay(rs.getString("day"));
				course.setStartTime(rs.getTime("startTime"));
				course.setEndTime(rs.getTime("endTime"));
				course.setTotalPer(rs.getInt("totalPer"));
				course.setApplyPer(rs.getInt("applyPer"));
				course.settIdx(rs.getInt("tIdx"));
				
				courseList.add(course);
			}
			
		} finally {
			
			if (stmt != null) {
				stmt.close();
			}
			
		}
		
		
		
		return courseList;
	}
	
}
	
	// time 정보에서 초를 자르고 hhmm만 불러오는 메서드 추가해야 하나?
	