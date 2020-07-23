package lms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lms.model.Admin;

public class AdminDao {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private AdminDao () {
		
	}
	
	private static AdminDao dao = new AdminDao();
	
	public static AdminDao getInstance() {
		return dao;
	}
	
	public Admin selectByIdPw (Connection conn, String id, String pw) throws SQLException {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs;
		
		Admin admin = null;
		
		try {
			
			String sql = "select * from project.admin where id=? and pw=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				admin = new Admin();
				
				admin.setId(rs.getString("id"));
				admin.setPw(rs.getString("pw"));
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			
		}
		
		
		return admin;	
	}
	
}