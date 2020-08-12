package com.op.mvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.op.mvc.member.model.Member;


// why @Repository???  DAO의 메소드에서 발생할 수 있는 unchecked exception들을 스프링의 DataAccessException으로 처리할 수 있다.
@Repository
public class MemberDAO {
	
	private MemberDAO() {}
	
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto) VALUES (?,?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());
		
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		return resultCnt;
	}


	public int selectById(Connection conn, String id) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
			String sql = "select count(*) from project.member where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			rs = pstmt.executeQuery();

			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
				
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
			
		}
		
		
		
		return resultCnt;
	}
	
	//0805추가
	public Member selectByIdpw(Connection conn, String uid, String pw) throws SQLException {
			
			PreparedStatement pstmt = null;
			ResultSet rs;	
			Member member = null;
			
			try {
				String sql = "select * from project.member where uid=? and upw=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				pstmt.setString(2, pw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new Member();
					member.setIdx(rs.getInt("idx"));
					member.setUid(rs.getString("uid"));
					member.setUpw(rs.getString("upw"));
					member.setUname(rs.getString("uname"));
					member.setUphoto(rs.getString("uphoto"));
				}
				
			} finally {
				if(pstmt != null) {
					pstmt.close();
				}
			}
			
			return member;
		}
	

	//요기랑
	public int selectTotalCount(Connection conn) throws SQLException {
		
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
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
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		System.out.println("전체 멤버수 : "+resultCnt);
		
		return resultCnt;
	}


	//요기랑
	public List<Member> selectMemberList(Connection conn, int startRow, int endRow) throws SQLException {

		List<Member> memberList = new ArrayList<Member>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from project.member limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					Member member = new Member();
					member.setIdx(rs.getInt("idx"));
					member.setUid(rs.getString("uid"));
					member.setUpw(rs.getString("upw"));
					member.setUname(rs.getString("uname"));
					member.setUphoto(rs.getString("uphoto"));
					
					memberList.add(member);
			}
			
		} finally {
//			if(rs!=null) {
//				rs.close();
//			}
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		return memberList;
	}

	public Member selectByIdx(Connection conn, int idx) throws SQLException {
		

		Member member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs;	
		
		try {
			String sql = "select * from project.member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return member;
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

	public int editMember(Connection conn, int idx, String newPw, String newPhoto) throws SQLException {
		
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql="update project.member set upw=?, uphoto=? where idx=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, newPhoto);
			pstmt.setInt(3, idx);
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		return resultCnt;
	}




	

	
	
	
}
