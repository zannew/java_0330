package ver05;

public class Menu {

	public static void showMenu(){
		
		System.out.println("=======================");
		System.out.println("메뉴를 입력해주세요.");
		System.out.println(Menu_Interface.INSERT_INFO+". 친구 정보  입력");
		System.out.println(Menu_Interface.SEARCH_INFO+". 친구 정보  검색");
		System.out.println(Menu_Interface.DELETE_INFO+". 친구 정보  삭제");
		System.out.println(Menu_Interface.EDIT_INFO+". 친구 정보  수정");
		System.out.println(Menu_Interface.SHOW_ALL+". 친구 정보  전체보기");
		System.out.println(Menu_Interface.EXIT+". 프로그램 종료");
		System.out.println("=======================");
		
		
	}
	
	
}
