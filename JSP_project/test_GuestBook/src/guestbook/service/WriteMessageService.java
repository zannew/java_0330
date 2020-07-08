package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.DAO.MessageDAO;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class WriteMessageService {

	//싱글톤 처리
	private WriteMessageService () {}
	
	private static WriteMessageService writeService = new WriteMessageService();
	public static WriteMessageService getInstance () {
		return writeService;
	}
	
	//DAO에 넘겨주기 위한 세팅
	// 1. DAO 객체 생성
	MessageDAO dao = null;
	
	// 2. write메서드 생성
	// 어디에 쓰임...???
	public int writeMessage(Message msg) {
		
		int result=0;
		
		dao = MessageDAO.getInstance();
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.insertMessage(conn, msg);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}
	
}
