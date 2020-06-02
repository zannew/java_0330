package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DEPTDao {
/*conn전달받아서 CRUD 모두 하나의 transaction으로... */
	// DAO = Data Access Object
	// 데이터베이스 처리하는 클래스

	// MVC → Model, View, Controller
	// 데이터베이스 처리까지 포함해서 Model이라고 부름
	// Model → Service, DAO (only 기능)

	////////////// INSERT
	public static void dept_insert() {

		Scanner sc = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속

			sc = new Scanner(System.in);
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			System.out.println("새로운 부서의 정보를 입력합니다>>");
			System.out.println("부서번호를 입력하세요.");
			int deptno = Integer.parseInt(sc.nextLine());
			System.out.println("부서 이름을 입력하세요.");
			String dname = sc.nextLine();
			System.out.println("위치를 입력하세요.");
			String loc = sc.nextLine();

			String sql = "insert into dept " + "values(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

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

	//////////////////// UPDATE

	public static void dept_update() {

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

			System.out.println("수정하실 부서의 정보를 입력합니다>>");
			System.out.println("수정하실 부서의 이름을 입력하세요.");
			String dname = sc.nextLine();
			System.out.println("수정하실 부서의 위치를 입력하세요.");
			String loc = sc.nextLine();

			String sql = "update dept set loc=? where dname=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loc);
			pstmt.setString(2, dname);

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

	///////////////// DELETE

	public static void dept_delete() {
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

			System.out.println("삭제하실 부서의 번호을 입력하세요.");
			int deptno = Integer.parseInt(sc.nextLine());

			String sql = "delete from dept where deptno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, deptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 삭제 ");
				System.out.println(resultCnt + "행이 삭제되었습니다.");
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

	///////////////// SHOW LIST

	public static List<Dept> dept_showAll() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		//DAO 클래스 추가
//		직접출력하지 않고 리스트에 저장까지만
		List<Dept> deptList = new ArrayList<>();
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();

			String sql = "select deptno, lpad(dname,10,'   '), loc from dept order by deptno";

			rs = stmt.executeQuery(sql);

			System.out.println("============부서테이블============");

			while (rs.next()) {
				
				Dept dept = new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc"));
				
				deptList.add(dept);
				
//				System.out.print(rs.getInt(1) + "\t");
//				System.out.print(rs.getString(2) + "\t");
//				System.out.print(rs.getString(3) + "\n");

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
		return deptList;
	}

	// SEARCH

	public static void dept_search() {
		Scanner sc = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

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

			stmt = conn.createStatement();

			System.out.println("검색하실 부서의 이름을 입력하세요.");
			String dname = sc.nextLine();
			System.out.println("검색하실 부서의 위치를 입력하세요.");
			String loc = sc.nextLine();

			String sql = "select * from dept where dname like '%" + dname + "%' or loc like '%" + loc + "%'";

			rs = stmt.executeQuery(sql);

			System.out.println("입력하신 부서의 이름 또는 위치로 검색한 결과입니다>>");

			while (rs.next()) {

				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\n");

				if (rs.next() == false) {
					System.out.println("검색 결과를 찾을 수 없습니다.");
					return;
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

//	private static List<Emp> deptList() {}

	// VO : Value Object
	// DTO : Data Transfer Object (전송목적)
}
