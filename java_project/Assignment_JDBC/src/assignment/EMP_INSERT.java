package assignment;

/*
 * 1. 사원관리 프로그램
   #기능
      입력(전체컬럼), 
      수정(이름, 부서, 급역), 
      삭제(사원번호), 
      리스트, 
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EMP_INSERT {

	private static EMP_INSERT eInsert = new EMP_INSERT();
	public static EMP_INSERT getInstance() {
		return eInsert;
	}
	
		public static void emp_insert() {
		Scanner sc = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속

			sc = new Scanner(System.in);
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			System.out.println("새로운 사원의 정보를 입력합니다>>");
			System.out.println("사원 번호를 입력하세요.");
			int empno = Integer.parseInt(sc.nextLine());
			System.out.println("사원 이름을 입력하세요.");
			String ename = sc.nextLine();
			System.out.println("직급을 입력하세요.");
			String job = sc.nextLine();
			System.out.println("담당 관리자의 사번을 입력하세요.");
			int mgr = Integer.parseInt(sc.nextLine());
			System.out.println("입사일을 입력하세요.");
			String hiredate = sc.nextLine();
			System.out.println("급여를 입력하세요.");
			int sal = Integer.parseInt(sc.nextLine());
			System.out.println("상여금을 입력하세요.");
			int comm = Integer.parseInt(sc.nextLine());
			System.out.println("부서번호를 입력하세요.");
			int deptno = Integer.parseInt(sc.nextLine());

			String sql = "insert into emp " + "values( ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 ");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("다시 시도해주세요.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

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
