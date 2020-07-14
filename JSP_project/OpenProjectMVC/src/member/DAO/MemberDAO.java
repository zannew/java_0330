package member.DAO;

import java.sql.Connection;

import member.model.Member;

public class MemberDAO {
	
	private MemberDAO() {}
	
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public int insertMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
