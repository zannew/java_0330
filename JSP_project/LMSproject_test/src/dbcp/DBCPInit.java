package dbcp;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loadJdbcDriver(); // 데이터베이스 드라이버 호드
		initConnectionPool(); // Pool 드라이버 로드 (설정)
	}
	
	private void loadJdbcDriver () {
		try {
			
			// 커넥션 풀이 내부에서 사용할 jdbc를 로드합니다.
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL 데이터베이스 드라이버 로드 성공");
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("JDBC 드라이버 로드에 실패함.");
		}
	}
	
	private void initConnectionPool () {
		
		try {
			String jdbcDriver = 
					"jdbc:mysql://localhost:3306/project"
					+ "?autoReconnect=true"
					+ "&useUnicode=true"
					+ "&characterEncoding=utf-8"
					+ "&servertimezone=UTC";
			
			// 후에 localhost를  AWS 인스턴스 연결로 변경해주면 됨.
			// String jdbcDriver = "jdbc:mysql://AWS인스턴스 DNS주소/project?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&servertimezone=UTC";
			
			String username = ""; // 설정한 mysql 유저 네임
			String pw = ""; // 설정한 mysql 유저 비밀번호
			
			// 커넥션 풀이 새로운 커넥셔ㅑㄴ을 생성할 때 사용할 커넥션팩토리 객체 생성
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcDriver, username, pw);
			
			// PoolableConnection 을 생성하는 팩토리 생성
			// DBCP 라이브러리는 커넥션을 보관할 때 PoolableConnection 객체를 사용합니다.
			// 이는 실제 커넥션을 담고 있고, 커넥션 풇을 관리할 때 필요한 기능들을 제공합니다.
			// 한번 커넥션을 연결했다면 close() 를 시켜도 완전히 커넥션을 종료하지 않고 
			// 컨넥션 풀로 반환해서 다시 커넥션을 해야하는 낭비를 없앱니다.
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			
			// 커넥션이 유효한지 여부를 검사할 때 사용하는 쿼리를 지정합니다.
			poolableConnFactory.setValidationQuery("select 1");
			
			// 커넥션 풀의 설정 정보를 생성하고
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			
			// 커넥션 유효기간의 검사 주기를 설정하여			
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 설정된 시간마다 풀에 보관중인 커넥션이 유효할지 검사를 합니다 (true 일 경우 검사함)
			poolConfig.setTestWhileIdle(true);
			
			// 커넥션의 최소 개수
			poolConfig.setMinIdle(4);
			// 풀에 유지할 최대 개수
			poolConfig.setMaxIdle(50);
			
			// 커넥션 풀을 생성, 생성자는 PoolableConnectionFactory/GenericObjectPoolConfig 객체 사용
			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<PoolableConnection>(poolableConnFactory, poolConfig);
			
			// PoolableConnecionFactory 에도 커넥션 풀을 연결해줍니다.
			poolableConnFactory.setPool(connectionPool);
			
			// 커넥션 풀을 제공하는 jdbc 드라이버 등록
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");

			// 위에서 커넥션 풀 드라이버에 생성한 커넥션 풀을 등록합니다.
			// 이름은 pool 로 설정합니다.
			driver.registerPool("pool", connectionPool);
			
			// pool 등록 확인
			System.out.println("커넥션 풀 등록 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
