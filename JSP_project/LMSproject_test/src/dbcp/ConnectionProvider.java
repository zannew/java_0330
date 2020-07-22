package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	
	// Connection 객체를 항상 생성하기 귀찮으니 pool 라이브러리를 사용해서 메서드로 만들어버림
	public static Connection getConnection() throws SQLException {
		
		
		String jdbcUrl = "jdbc:apache:commons:dbcp:pool";
		
		
		return DriverManager.getConnection(jdbcUrl);
		
	}

}
