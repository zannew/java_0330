package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest_3 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;

		// 1. DB드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle 드라이버 로드 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "SCOTT";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			// 3. SQL로 데이터처리
			// Statement : Connection 객체의 ㅇ

			Statement stmt = conn.createStatement();
			
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.println("회원의 이름을 입력해주세요>>");
//			String searchName=sc.nextLine();
			

			String sql = "select * from emp e order by sal";
//			String sql1 =  "select o.orderid, c.name, b.bookname from orders o, customer c, book b "
//					+ "where o.custid=c.custid and b.bookid=o.bookid "
//					+ "and c.name='"+searchName+"'";
			
//			System.out.println("sql : "+sql1);
			System.out.println();
			System.out.println();
			System.out.println();

			// SELECT의 결과는 ResultSet이 받는다.
			// executeQuery(sql문-String) → ResultSet
			rs = stmt.executeQuery(sql);

//			System.out.println("------------------------------");
//			System.out.println("\t판매 리스트");
//			System.out.println("------------------------------");
//			System.out.println("판매아이디\t회원이름\t책이름");
//			System.out.println("------------------------------");
			
			// ResultSet : next(); → 행의 존재 유무 확인 (커서개념)
			while (rs.next()) {
//				System.out.print(rs.getInt("empno") + "\t");
//				System.out.print(rs.getString("ename") + "\t");
//				System.out.print(rs.getString("job") + "\t");
//				System.out.print(rs.getString("sal") + "\n");
				
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.print(rs.getInt(8) + "\n");
			}
			

			rs.close();
			stmt.close();

			// 4. DB close
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
