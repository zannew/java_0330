package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import model.Report;

public class ReportDAO {

	private ReportDAO() {}
	
	private static ReportDAO dao = new ReportDAO();
	public static ReportDAO getInstance() {
		return dao;
	}  

	public int insertReport(Connection conn, Report report) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "insert into report values (report_seq.nextval,?,?,?)";
		
		try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, report.getSname());
			 pstmt.setString(2, report.getSno());
			 pstmt.setString(3, report.getReport());
			
			 resultCnt = pstmt.executeUpdate();
			 
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}
	
	
	
}
