package ver05;

import java.util.InputMismatchException;

import ver05.exception.BadNumberException;

public class PhoneBookMain {

	public static void main(String[] args) {
		
//		PhoneBookManager manager = new PhoneBookManager(100);
		//PhoneBookManager의 참조값을 가진 변수를 불러올 수 있다.
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {
			
			Menu.showMenu();
			
			int select=0;
			
			try {
				select = manager.kb.nextInt();
				
				//정상 범위는 1~6	(상수값 표현으로는 Menu_Interface.INSERT_INFO ~ Menu_Interface.EXIT)
				if(!(select>=Menu_Interface.INSERT_INFO && select<=Menu_Interface.EXIT)) {
					BadNumberException e = new BadNumberException("잘못된 메뉴입력");
					//강제적인 예외발생(내가 만들어 낸)
					throw e;
				}
			}catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n확인하시고 다시 입력해주세요.");
//				manager.kb.nextLine();
				continue;				//아래 내용 실행하지 않고 블럭 마지막으로 이동하고 다시 올라간다.
			}catch(BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다.\n다시 확인 후 입력해주세요.");
				continue;
			}catch(Exception e){
				System.out.println("잘못된 메뉴 입력입니다.\n확인하시고 다시 입력해주세요.");
//				manager.kb.nextLine();
				continue;				//아래 내용 실행하지 않고 블럭 마지막으로 이동하고 다시 올라간다.
			}finally {
				manager.kb.nextLine();	//예외 발생하든 안하든 실행될 문장		
			}
//			manager.kb.nextLine();		//catch에 걸리지 않으면 실행되지 않을 위치기 때문에 작성 → finally로 처리 better
			
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
