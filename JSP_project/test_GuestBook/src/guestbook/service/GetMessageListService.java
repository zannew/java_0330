package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.DAO.MessageDAO;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;
import guestbook.model.MessageListView;

public class GetMessageListService {

	// 싱글톤 처리
	private GetMessageListService() {}
	
	private static GetMessageListService service = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return service;
	}
	
	MessageDAO dao = null;
	
	private final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageList(int pageNumber) {
		
		Connection conn = null;
		
		MessageListView messageListView = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDAO.getInstance();
		
		
		
		List<Message> messageList = null;
		
		int messageTotalCount = dao.selectTotalCount(conn);
		
		int startRow = 0;
		int endRow = 0;
		
		if(messageTotalCount > 0) {
			
			startRow = (pageNumber-1)*messageTotalCount/MESSAGE_COUNT_PER_PAGE + 1;
			endRow = startRow + MESSAGE_COUNT_PER_PAGE -1;
			
			messageList = dao.selectMessageList(conn, startRow, endRow);
			
		}else {
			
			pageNumber = 0;
			messageList = Collections.emptyList();
		} 
		
		messageListView = new MessageListView(messageTotalCount, pageNumber, messageList, MESSAGE_COUNT_PER_PAGE, startRow, endRow);
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		return messageListView;
		
	}
	
	
	
	
}
