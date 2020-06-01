package ex;

//3.EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTest_JDBCTest_7 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs=null;

		// 1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			String url = "jdbc:oracle:thin:@localhost:1524:orcl2";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			Statement stmt = conn.createStatement();
			
			String sql = "update emp set sal=1000 where ename='SCOTT'";
//			update emp
//			set sal=1000 where ename='scott'
			
			// 3. SQL로 데이터처리
			stmt.executeUpdate(sql);
			System.out.println("행이 수정되었습니다.");
			
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
