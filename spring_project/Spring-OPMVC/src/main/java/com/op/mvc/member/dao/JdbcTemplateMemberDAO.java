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
	JdbcTemplate jdbcTemplate;
	
	//요기랑
	public int selectTotalCount(Connection conn) throws SQLException {

//		int resultCnt=0;
//		String sql = "select count(*) from project.member";
//		resultCnt = jdbcTemplate.queryForObject(sql, Integer.class);
//		return resultCnt;
		
		//한줄로가능
		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
		
	}


	//요기랑
	public List<Member> selectMemberList(Connection conn, int startRow, int endRow) throws SQLException {

		//List<Member> memberList = new ArrayList<Member>();
		//String sql = "select * from project.member limit ?,?";
		//객체 생성할때 매개변수 순서 지키기
		//memberList = jdbcTemplate.query(sql, new Object[] {startRow, endRow}, new MemberRowMapper());
		//return memberList;
		
		return jdbcTemplate.query("select * from project.member limit ?,?", new Object[] {startRow, endRow}, new MemberRowMapper());
		
	}


	public int deleteMember(Connection conn, int idx) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql="delete from project.member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		
		System.out.println("result : "+resultCnt);

		return resultCnt;
	}





	

	
	
	
}
