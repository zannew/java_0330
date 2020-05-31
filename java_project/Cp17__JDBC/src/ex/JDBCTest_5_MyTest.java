package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest_5_MyTest {

//	1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;


		// 1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1524:orcl2";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			Scanner sc = new Scanner(System.in);
			
			stmt=conn.createStatement();
			
			System.out.println("새로운 사원의 정보를 입력합니다.");
			System.out.println("사원 번호를 입력하세요.");
			int empno=Integer.parseInt(sc.nextLine());
			System.out.println("사원 이름을 입력하세요.");
			String ename=sc.nextLine();
			System.out.println("직급을 입력하세요.");
			String job=sc.nextLine();
			System.out.println("담당 관리자의 사번을 입력하세요.");
			int mgr=Integer.parseInt(sc.nextLine());
			System.out.println("입사일을 입력하세요.");
			String hiredate=sc.nextLine();
			System.out.println("급여를 입력하세요.");
			int sal=Integer.parseInt(sc.nextLine());
			System.out.println("상여금을 입력하세요.");
			int comm=Integer.parseInt(sc.nextLine());
			System.out.println("부서번호를 입력하세요.");
			int deptno=Integer.parseInt(sc.nextLine());
	
			
			
			String sql = "insert into emp "
					+ "values("+empno+", '"+ename+"', '"
					+job+"', "+mgr+", '"+hiredate+"', "+sal+", "+comm+", "+deptno+")";
			
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
