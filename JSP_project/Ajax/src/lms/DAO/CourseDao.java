package lms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import lms.model.Course;
import lms.model.Student;

public class CourseDao {

	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private CourseDao() {

	}

	private static CourseDao dao = new CourseDao();

	public static CourseDao getInstance() {
		return dao;
	}

	// 강의 등록 : insert
	public int insertCourse(Connection conn, Course course) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.class (`name`,`teacher`,`content`, `day`,`startTime`,`endTime`,`totalPer`,`applyPer`,`tIdx`)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		// 마지막값 tIdx는 교수번호를 Model에서 가져와야..

		try {

			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, course.getcIdx()); 강의번호는 자동생성
			pstmt.setString(1, course.getName());
			pstmt.setString(2, course.getTeacher());
			pstmt.setString(3, course.getContent());
			pstmt.setString(4, course.getDay());
			pstmt.setTime(5, course.getStartTime());
			pstmt.setTime(6, course.getEndTime());
			pstmt.setInt(7, course.getTotalPer());
			pstmt.setInt(8, course.getApplyPer());
			pstmt.setInt(10, course.gettIdx()); 

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	// 개설강의 이름으로 조회 : select (복수일 경우를 대비하여 list)
	public List<Course> selectCourseByNameList (Connection conn, String name) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs;
		
		List<Course> selectCourseByNameList = new ArrayList<Course>();
		
		String sql = "SELECT * FROM project.course where name=?";
		
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
				
				selectCourseByNameList.add(course);
			}
			
		} finally {
			
			if (stmt != null) {
				stmt.close();
			}
			
		}
		
		return selectCourseByNameList;
	}
	
	// 개설 강의 삭제 : delete
	public int deleteCourse(Connection conn, Course course) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from project.course where cIdx=?";

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

	// 개설 강의 수정 : update
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

	// 수강신청한 강의 리스트 조회 : myCourse 조회 = select ?
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

		try {
			// 학번으로 내가 등록한 강의 리스트 출력
			String sql = "DELETE FROM project.myCourse where sIdx=? cIdx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getsIdx());
			pstmt.setInt(2, course.getcIdx());

			result = pstmt.executeUpdate();

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
			
			String sql = "SELECT * FROM project.course";
			
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
	
	//07.23 윤원추가 insert into myCourse
	public int insertMyCourse(Connection conn, Course course, Student student) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt =null;
		String sql="insert into project.myCourse (sIdx, cIdx) VALUES (?,?)";
		
		conn=ConnectionProvider.getConnection();
		
		try {
		
			pstmt=conn.prepareStatement(sql);
			resultCnt = pstmt.executeUpdate();
			pstmt.setInt(1, student.getsIdx());
			pstmt.setInt(2, course.getcIdx());
		
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			
			}
			
		}
		return resultCnt;
	}
	
	
	
	
	
	
}