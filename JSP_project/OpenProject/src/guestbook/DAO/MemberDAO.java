package guestbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.MemberInfo;

public class MemberDAO {

	private MemberDAO() {}
	
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance () {
		return dao;
	}
	
	
	public int addMember(Connection conn, MemberInfo memberInfo) throws SQLException {

		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql ="insert into memberinfo values (?,?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getMid());
			pstmt.setString(2, memberInfo.getMpw());
			pstmt.setString(3, memberInfo.getMname());
			pstmt.setString(4, memberInfo.getMphoto());
			
			resultCnt = pstmt.executeUpdate();
		
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		
		return resultCnt;
	}
	
	
	
}
