package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_5 {

//	1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;


		// 1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			
			stmt=conn.createStatement();
			
			String sql = "insert into emp "
					+ "values(8000, 'BRAD', 'CEO', '', '1990/12/22', '6000', '1000', 10)";
			
			// 3. SQL로 데이터처리
			int resultCnt = stmt.executeUpdate(sql);
			System.out.println(resultCnt + "행이 입력됨");

			// 4. DB close
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

	}

}
