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
import java.util.Scanner;

public class EMP_SEARCH {

	private static EMP_SEARCH eSearch = new EMP_SEARCH();

	public static EMP_SEARCH getInstance() {
		return eSearch;
	}

	public static void emp_search() {
		Scanner sc = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속

			sc = new Scanner(System.in);
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();

			System.out.println("검색하실 사원의 이름을 입력하세요.");
			String ename = sc.nextLine();

			// Mysql
			// "SELECT * FROM dept WHERE dname LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from dept where dname like '%'||?||'%'

			String sql = "select empno, ename, lpad(job,10,'   '), mgr, hiredate, sal, comm, deptno"
					+ " from emp where ename like'%" + ename + "%'";

			rs = stmt.executeQuery(sql);
			
//			cnt++ 사용해서 검색결과 없음 처리!
			int searchCnt=0;
			
			while (true) {

				if (rs.next()) {

					System.out.print(rs.getInt(1) + "\t");
					System.out.print(rs.getString(2) + "\t");
					System.out.print(rs.getString(3) + "\t\t");
					System.out.print(rs.getInt(4) + "\t");
					System.out.print(rs.getDate(5) + "\t");
					System.out.print(rs.getInt(6) + "\t");
					System.out.print(rs.getInt(7) + "\t");
					System.out.print(rs.getInt(8) + "\n");
					searchCnt++;
				}

				if (searchCnt<1) {
					System.out.println("검색 결과를 찾을 수 없습니다.");
				}

			}

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
