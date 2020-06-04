package phoneBook_ver_7_2;
// 2. 데이터베이스 연결
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;

//		String url="jdbc:oracle:thin:@주소:포트:데이터베이스이름(SID)";
//		 주소 : localhost 또는 127.0.0.1
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "SCOTT";
		String pw = "tiger";

		conn = DriverManager.getConnection(url, user, pw);

		return conn;
	}

}
