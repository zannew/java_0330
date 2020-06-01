package assignment;

/*
 * 1. 사원관리 프로그램
   #기능
      입력(전체컬럼), 
      수정(이름, 부서번호, 급여), 
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EMP_UPDATE {
	
	private static EMP_UPDATE eUpdate = new EMP_UPDATE();
	public static EMP_UPDATE getInstance() {
		return eUpdate;
	}
	
//	public static void main(String[] args) {
	
	public static void emp_update() {

		Scanner sc = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속

			sc = new Scanner(System.in);
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			System.out.println("수정하실 사원의 정보를 입력합니다>>");
			System.out.println("수정하실 사원의 이름을 입력하세요.");
			String ename = sc.nextLine();
			System.out.println("수정하실 급여를 입력하세요.");
			int sal = Integer.parseInt(sc.nextLine());
			System.out.println("수정하실 부서번호를 입력하세요.");
			int deptno = Integer.parseInt(sc.nextLine());

			String sql = "update emp set sal=?, deptno=? where ename=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, sal);
			pstmt.setInt(2, deptno);
			pstmt.setString(3, ename);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 수정 ");
				System.out.println(resultCnt + "행이 수정되었습니다.");
			} else {
				System.out.println("다시 시도해주세요.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
