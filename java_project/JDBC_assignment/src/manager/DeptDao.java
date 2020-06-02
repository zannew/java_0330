package manager;

//1 table = 1 DAO
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeptDao {

	/* conn전달받아서 CRUD 모두 하나의 transaction으로... */

	// DAO = Data Access Object
	// 데이터베이스 처리하는 클래스

	// MVC → Model, View, Controller
	// 데이터베이스 처리까지 포함해서 Model이라고 부름
	// Model → Service, DAO (only 기능)

	////////////// INSERT(받아서 저장만)
	public int dept_insert(Dept dept) {

		Scanner sc = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			// 2. 데이터베이스에 접속
			conn = ConnectionProvider.getConnection();

			String sql = "insert into dept " + "values(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			resultCnt = pstmt.executeUpdate();

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
		return resultCnt;
	}

	//////////////////// UPDATE(EDIT)
	public int dept_update(Dept newDept, Connection conn) {

		// Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			// 2. 데이터베이스에 접속
			// conn = ConnectionProvider.getConnection();

			String sql = "update dept set dname=?, loc=? where deptno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newDept.getDname());
			pstmt.setString(2, newDept.getLoc());
			pstmt.setInt(3, newDept.getDeptno());

			resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 수정 ");
				System.out.println(resultCnt + "행이 수정되었습니다.");
			} else {
				System.out.println("다시 시도해주세요.");
			}

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
		return resultCnt;
	}

	///////////////// DELETE

	public int dept_delete(int deptno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			conn = ConnectionProvider.getConnection();

			String sql = "delete from dept where deptno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			resultCnt = pstmt.executeUpdate();

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
		return resultCnt;
	}

	///////////////// SHOW LIST(데이터 처리 로직)
	public static List<Dept> dept_showAll() {

		// VO : Value Object (read only, 참조 온리) getter
		// DTO : Data Transfer Object getter/setter, toString, equals

		// DAO → 데이터전송 → Manager

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DAO 클래스 : 직접출력하지 않고 리스트에 저장까지만
		List<Dept> deptList = new ArrayList<>();
		try {

			conn = ConnectionProvider.getConnection();

			String sql = "select deptno, dname, loc from dept order by deptno";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			System.out.println("============부서테이블============");

			while (rs.next()) {

				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));

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

	/////////////////// SEARCH
	public static List<Dept> dept_search(String searchName) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Dept> list = new ArrayList<Dept>();

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스에 접속

			conn = ConnectionProvider.getConnection();
			System.out.println("데이터베이스에 접속했습니다.");

			String sql = "select * from dept where dname like '%?%'";// or loc like '%?%'";

			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "dname");
//			pstmt.setString(2, dname);
			rs = pstmt.executeQuery();

			System.out.println("입력하신 부서의 이름 또는 위치로 검색한 결과입니다>>");

			while (rs.next()) {

				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));

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
		return list;
	}

	// 서브메서드
	public int dept_searchCount(String searchName, Connection conn) {

//		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowCnt = 0;

		List<Dept> list = new ArrayList<Dept>();

		try {
			conn = ConnectionProvider.getConnection(); // 저쪽에서 예외던지고 있음

			String sql = "select count(*) from dept where dname=?";
부적합한 열 이름..
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "dname");
//			pstmt.setString(2, dname);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCnt;
	}

	public Dept deptSearchName(String searchName, Connection conn) {
		Dept dept = null;

//		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dept;
	}

//	private static List<Emp> deptList() {}

	// VO : Value Object
	// DTO : Data Transfer Object (전송목적)
}
