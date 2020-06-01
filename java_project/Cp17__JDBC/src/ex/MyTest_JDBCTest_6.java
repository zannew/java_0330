package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
public class MyTest_JDBCTest_6 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;

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

			// 3. SQL로 데이터처리

			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from emp";
					
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.print(rs.getInt(8) + "\n");
				
			}

		

			// 4. DB close
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
