package com.op.mvc.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit으로 테스트
@RunWith(SpringJUnit4ClassRunner.class)
//설정파일을 가져오는 config
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml")
public class JdbcTest {

	//데이터 소스가 필요
	@Autowired
	private DataSource dataSource;
	
	@Inject
	private JdbcTemplate template;
	
	@Test
	public void jdbcTemplateTestI() {
		
		System.out.println("jdbcTemplate 확인 : "+template);
		
	}
	
	
	@Test
	public void connectionTest() throws SQLException {
		
		System.out.println("dataSource DI 확인 : "+dataSource);
		
		Connection conn=null;
		
		conn = dataSource.getConnection();
		
		System.out.println("Connection 확인 : "+conn);
		
	}
	
}
