package guestbook.service;

import guestbook.DAO.MessageDAO;

public class DeleteMessageService {

	private DeleteMessageService() {}
	
	private static DeleteMessageService deleteService = new DeleteMessageService();
	public static DeleteMessageService getInstance () {
		return deleteService;
	}
	
	//1. DAO
	MessageDAO dao = null;
	
	//2. deleteMassage 메서드
	public int deleteMessage() {
		
		
	}
	
}
