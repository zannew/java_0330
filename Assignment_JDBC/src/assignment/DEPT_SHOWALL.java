package assignment;

/*
 * 1. 사원관리 프로그램
   #기능
      입력(전체컬럼), 
      수정(이름, 부서번호, 급여), 
      삭제(사원번호), 
      리스트(전체), 
      검색(이름)
2. 부서관리 프로그램
   #기능
      입력, 
      수정(부서이름, 위치), 
      삭제(부서번호), 
      리스트, 
      검색(부서이름 or 지역)
 * */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DEPT_SHOWALL {

	private static DEPT_SHOWALL dShowAll = new DEPT_SHOWALL();
	public static DEPT_SHOWALL getInstance() {
		return dShowAll;
	}
	
//	public static void main(String[] args) {
	public static void dept_showAll() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();

			String sql = "select * from dept";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				System.out.println("============부서테이블============");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");

			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

			if (stmt != null) {
				try {
					stmt.close();
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
