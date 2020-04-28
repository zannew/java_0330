package ver05;

public class PhoneBookMain {

	public static void main(String[] args) {
		
//		PhoneBookManager manager = new PhoneBookManager(100);
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {
			
			Menu.showMenu();
			
			int select = manager.kb.nextInt();
			manager.kb.nextLine();
			
			switch(select) {
			
			case Menu_Interface.INSERT_INFO:
				manager.createInfo();
				break;
			case Menu_Interface.SEARCH_INFO:
				manager.showInfo();
				break;
			case Menu_Interface.DELETE_INFO:
				manager.deleteInfo();
				break;
			case Menu_Interface.EDIT_INFO:
				manager.editInfo();
				break;
			case Menu_Interface.SHOW_ALL:
				manager.showAllInfo();
				break;
			case Menu_Interface.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			
			
			
			
		}
		
		
	}
	
}
