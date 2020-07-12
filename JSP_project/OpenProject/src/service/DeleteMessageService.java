package service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.DAO.MessageDAO;
import guestbook.jdbc.ConnectionProvider;
import model.Message;

public class DeleteMessageService {

	private DeleteMessageService() {}
	
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	// dao로..
	MessageDAO dao;
	
	// 게시물 존재 여부 체크 - 데이터 처리
	public int deleteMessage(int mid, String pw) {
		
		int resultCnt=0;
		
		Connection conn = null;
		// 데이터 확인을 위한 변수
		Message message = null;
		
		// 1. mid의 메시지(게시물) 존재여부 확인
		// 2. 존재 시, 객체의 pw와 사용자 입력 pw를 비교
		// 3. 결과가 같다면, mid의 메시지(게시물)를 삭제
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDAO.getInstance();
			
			message = dao.selectMessage(conn, mid);
			
			if(message==null) {
				resultCnt = -1;
				throw new Exception("삭제할 메시지가 존재하지 않습니다.");
			}
			if(!message.getPw().equals(pw)) {
				resultCnt = -2;
				throw new Exception("비밀번호가 일치하지 않습니다.");
			}
			
			// 삭제 처리
			resultCnt = dao.deleteMessage(conn, mid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultCnt;
	}
	
}
