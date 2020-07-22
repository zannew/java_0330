package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lms.model.Course;



public class CourseDao {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private CourseDao () {
		
	}
	
	private static CourseDao dao = new CourseDao();
	
	public static CourseDao getInstance() {
		return dao;
	}
	
	
	// 강의 등록 : insert
	
	public int insertCourse ( Connection conn, Course course) throws SQLException {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO `project`.`class` (`cIdx`,`name`,`teacher`,`content`, `day`,`startTime`,`endTime`,`totalPer`,`applyPer`,`tIdx`)\r\n" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		// 마지막값 tIdx는 교수번호를 Model에서 가져와야..
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, course.getcIdx());
			pstmt.setString(2, course.getName());
			pstmt.setString(3, course.getTeacher());
			pstmt.setString(4, course.getContent());
			pstmt.setString(5, course.getDay());
			pstmt.setTimestamp(6, course.getStartTime());
			pstmt.setTimestamp(7, course.getEndTime());
			pstmt.setInt(8, course.getTotalPer());
			pstmt.setInt(9, course.getApplyPer());
			pstmt.setInt(10, course.gettIdx());
			
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

	//07.22 윤원추가 - 개설강의 전체 조회 : select
	public List<Course> selectTotalCourse(Connection conn) throws SQLException {
		
		
		List<Course> courseList = null;
		int result = 0;
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql = "select * from `project`.`course`";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Course course = new Course();
				course.setcIdx(rs.getInt("idx"));
				course.setName(rs.getString("name"));
				course.setTeacher(rs.getString("teacher"));
				course.setContent(rs.getString("content"));
				course.setDay(rs.getString("day"));
				course.setStartTime(rs.getTimestamp("startTime"));
				course.setEndTime(rs.getTimestamp("endTime"));
				course.setTotalPer(rs.getInt("totalPer"));
				course.setApplyPer(rs.getInt("applyPer"));
				course.settIdx(rs.getInt("tIdx"));
				
				
				courseList.add(course);
				
			}
			
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		
		return null;
	}
	
	
	// 개설 강의 삭제 : delete ?
	// 개설 강의 수정 : update ?
	// 수강신청한 강의 리스트 조회 : myCourse 조회 = select  ? 
	// 개설된 전체 강의 리스트 출력 : ArrayList ?
	// 수강신청한 강의 취소 : myCourse 조회 => delete ? 
	
	
}