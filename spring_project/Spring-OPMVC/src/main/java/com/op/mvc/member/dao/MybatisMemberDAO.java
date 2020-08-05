package com.op.mvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.op.mvc.member.model.Member;

// why @Repository???  DAO의 메소드에서 발생할 수 있는 unchecked exception들을 스프링의 DataAccessException으로 처리할 수 있다.
@Repository
public class MybatisMemberDAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private String mapperPath = "com.op.mvc.mybatis.mapper.MemberMapper";

	public int insertMember(Member member) throws SQLException {

//		int result = 0;
//		result = sessionTemplate.update(mapperPath+".insertMember", member);
//		return result;

		return sessionTemplate.update(mapperPath + ".insertMember", member);

	}

	// 요기랑
	public int selectTotalCount(Connection conn) throws SQLException {
	  
	  int resultCnt = 0;
	  
	  Statement stmt = null; ResultSet rs = null;
	  
	  try { 
		  stmt = conn.createStatement();
		  String sql = "select count(*) from project.member"; 
		  rs = stmt.executeQuery(sql);
	  
	  //한 행만 가져와야할 때 
	  if(rs.next()) { 
		  resultCnt = rs.getInt(1); 
		  } 
	  } finally {
		  if(rs!=null) { 
			  rs.close(); 
		} if(stmt!=null) { 
			 stmt.close(); 
			 } 
		}
		  System.out.println("전체 멤버수 : "+resultCnt);
	  
		  return resultCnt; 
		  
		}

	// 요기랑 public 
	List<Member> selectMemberList(Connection conn, int startRow, int endRow)throws SQLException	{
	  
		  List<Member> memberList = new ArrayList<Member>();
		  
		  PreparedStatement pstmt = null; ResultSet rs = null;
		  
		  try { String sql = "select * from project.member limit ?,?"; pstmt =
		  conn.prepareStatement(sql); pstmt.setInt(1, startRow); pstmt.setInt(2,
		  endRow); rs = pstmt.executeQuery();
		  
		  while(rs.next()) { Member member = new Member(rs.getInt("idx"),
		  rs.getString("uid"), rs.getString("upw"), rs.getString("uname"),
		  rs.getString("uphoto"), rs.getDate("regdate"));
		  
		  memberList.add(member); 
	  }
	  
	  } finally { 
	  
	  }

	return memberList;
}
	
	public int selectById(String id) throws SQLException {
		
		int resultCnt=0;
			String sql = "select count(*) from project.member where uid=?";
		
		return resultCnt;
	}
	

}
