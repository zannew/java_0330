package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_6 {

	public static void main(String[] args) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 0. 드라이버 라이브러리 추가★
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체 이름-패키지포함)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 예외처리 필수

			// 2. 데이터베이스 연결

//			String url="jdbc:oracle:thin:@주소:포트:데이터베이스이름(SID)";
//			 주소 : localhost 또는 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL처리
			// Statement(→ 변수처리 따로 없다면) 또는 PreparedStatement(→ 변수 처리 많은 경우)
			// pstmt=conn.prepareStatement(SQL문장);
			
			String sql = "insert into dept (deptno, dname, loc) "
					+ "values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			pstmt.setString(2, "MARKETING");
			pstmt.setString(3, "SEOUL");

			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("정상적으로 입력되었습니다.");
				System.out.println(resultCnt+"행이 입력되었습니다");
			}else {
				System.out.println("입력을 실패했습니다. 확인 후 재시도해주세요.");
			}
			
			
			
			// 4. 데이터베이스 연결 종료
			// 불필요한 connection을 없애기 위해
//			pstmt.close();		→ finally에서 처리
//			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
