package friend;

public class FriendMain {
	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler(10);
		
		while(true) {
			
			System.out.println("===메뉴를 선택해 주세요===");
			System.out.println("1.고교 친구 저장");
			System.out.println("2.대학 친구 저장");
			System.out.println("3.친구 기본 정보 출력");
			System.out.println("4.전체 친구 정보 출력");
			System.out.println("5.종료하기");
			System.out.println("===================");
		
			int choice = handler.sc.nextInt();
			handler.sc.nextLine();		//앞의 버퍼를 클리어하는 목적
			
			switch(choice) {
			
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllSimpleData();
				break;
			case 4:
				handler.showAllData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;		//메인메서드를 종료시킨다.
			
			
			}
			
			
			
			
			
			
			
			
			
		}
		

		
		
	}
}
