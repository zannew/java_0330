package phoneNumBook_ver_5_3;

public class PhoneBookMain {

	static int selectOpt;
	static int selectOpt2;

	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		
		while(true) {
			
			System.out.println("★★★전화번호부★★★");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.친구 정보 저장");
			System.out.println("2.친구 정보 검색");
			System.out.println("3.친구 정보 삭제");
			System.out.println("4.친구 정보 전체보기");
			System.out.println("5.프로그램 종료");
			System.out.println("-----------------");
			selectOpt=manager.sc.nextInt();
			manager.sc.nextLine();
			
			
			switch(selectOpt) {
			
			case 1:
				System.out.println("어떤 친구의 정보를 저장하겠습니까?");
				System.out.println("1.대학교 친구");
				System.out.println("2.직장 동료");
				System.out.println("3.동호회 친구");
				int selectOpt2=manager.sc.nextInt();
				manager.storeInstance(manager.createInstance(selectOpt2));			
				break;

			case 2:
				manager.searchInfo();
				break;
			
			case 3:
				manager.deleteInfo();
				break;
			
			case 4:
				manager.showInfo();
				break;
			
			case 5:
				return;
			
			
			
			
			
			}
			
			
			
		}
		
		
	}

}
