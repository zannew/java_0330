package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EMPDao {

	///////////////INSERT
	public static void emp_insert() {
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
	
	///////////////UPDATE
	public static void emp_update() {

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

	
	///////////////DELETE
	public static void emp_delete() {
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

			System.out.println("삭제하실 사원의 번호을 입력하세요.");
			int empno = Integer.parseInt(sc.nextLine());

			String sql = "delete from emp where empno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empno);
		
			int resultCnt = pstmt.executeUpdate();
			
//			resultCnt로 예외처리(if)

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

	
	///////////////SHOW LIST
	public static void emp_showAll() {
		
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");

		System.out.println("Oracle 드라이버 로드 성공");

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "SCOTT";
		String pw = "tiger";

		// 2. 데이터베이스에 접속

		conn = DriverManager.getConnection(url, user, pw);
		System.out.println("데이터베이스에 접속했습니다.");

		stmt = conn.createStatement();

		String sql = "select empno, ename, lpad(job,10,'   '), mgr, hiredate, sal, comm, deptno from emp";

		rs = stmt.executeQuery(sql);

		System.out.println("============사원테이블============");

		while (rs.next()) {

			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3)+ "\t");
			System.out.print(rs.getInt(4) + "\t");
			System.out.print(rs.getDate(5) + "\t");
			System.out.print(rs.getInt(6) + "\t");
			System.out.print(rs.getInt(7) + "\t");
			System.out.print(rs.getInt(8) + "\n");

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
	
	
	///////////////SEARCH
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
