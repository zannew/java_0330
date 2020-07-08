package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.DAO.MessageDAO;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class WriteMessageService {

	private WriteMessageService() {	}
	
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance () {
		return service;
	}
	
	MessageDAO dao = null;
	
	public int writeMessage(Message msg) {
		
		int result = 0;
		
		dao = MessageDAO.getInstance();
		// DAO의 메서드에 전달할 Connection
		Connection conn = null;
		
		try {
			conn=ConnectionProvider.getConnection();
			result = dao.insertMessage(conn, msg);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
}
