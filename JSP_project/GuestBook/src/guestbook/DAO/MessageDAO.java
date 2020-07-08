package guestbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import guestbook.model.Message;

public class MessageDAO {

	private MessageDAO (){ }
	
	private static MessageDAO dao = new MessageDAO();
	public static MessageDAO getInstance() {
		return dao;
	}
	public int insertMessage(Connection conn, Message msg) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql="insert into guestbook_message values (message_id_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getUname());
			pstmt.setString(2, msg.getPw());
			pstmt.setString(3, msg.getMessage());
			
			resultCnt = pstmt.executeUpdate();
			
		} finally{
			
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}
}
