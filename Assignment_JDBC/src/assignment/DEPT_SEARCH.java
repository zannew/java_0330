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

public class DEPT_SEARCH {

	private static DEPT_SEARCH dSearch = new DEPT_SEARCH();
	public static DEPT_SEARCH getInstance() {
		return dSearch;
	}
	
//	public static void main(String[] args) {

	public static void dept_search() {
		Scanner sc = null;

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

			sc = new Scanner(System.in);
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();

			System.out.println("검색하실 부서의 이름을 입력하세요.");
			String dname = sc.nextLine();
			System.out.println("검색하실 부서의 위치를 입력하세요.");
			String loc = sc.nextLine();
			
			String sql = "select * from dept where dname like '%"+dname+"%' or loc like '%"+loc+"%'";
			
			rs = stmt.executeQuery(sql);

			if(rs.next()==false) {
				System.out.println("검색 결과를 찾을 수 없습니다.");
				return;
			}
			
			System.out.println("입력하신 부서의 이름 또는 위치로 검색한 결과입니다>>");

			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");
			}

		}catch(

	ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(
	SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
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
