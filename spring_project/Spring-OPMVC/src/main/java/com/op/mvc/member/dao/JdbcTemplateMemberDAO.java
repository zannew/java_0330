package com.op.mvc.member.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.op.mvc.member.model.Member;


// why @Repository???  DAO의 메소드에서 발생할 수 있는 unchecked exception들을 스프링의 DataAccessException으로 처리할 수 있다.
@Repository
public class JdbcTemplateMemberDAO {


	@Inject
	JdbcTemplate jdbcTemplate ;

	public int selectTotalCount() throws SQLException {
		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
	}

	public List<Member> selectList(int startRow, int count) throws SQLException {
		
		
//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname limit ?, ?";
//		memberList = jdbcTemplate.query(sql,new Object[] {startRow, count}, new MemberRowMapper());
//		return memberList;
		
		return jdbcTemplate.query("select * from project.member order by uname limit ?, ?",new Object[] {startRow, count}, new MemberRowMapper());
		
	}		
	
}
