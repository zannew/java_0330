package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		//PhoneInfor info = null;		//불필요한 변수 생성을 막기 위해 블럭 밖에서 선언
		
		Scanner sc = new Scanner(System.in);			//기존 생성된 객체 공유할지 고민?
		
		
		while(true) {
			
			Menu.showMenu(); 	//public 메서드이므로 바로 호출 가능
			
			int selectNum = sc.nextInt();
			
			sc.nextLine();				//시작부터 끝까지 버퍼를 refresh시켜주기 위함
			
			//분기(명확히 정해진 경우 switch is better)
			switch(selectNum) {
			case 1:
				//정보를 배열에 저장
				//PhoneInfor info = manager.createInstance();
				//manager.addInfo(info);
				manager.addInfo();
				break;
			case 2:
				//이름으로 검색
				manager.searchInfo();
				break;
			case 3:
				//이름으로 검색 후 삭제
				manager.deleteInfo();
				break;
			case 4:
				//전체 리스트를 출력
				manager.showAllData();
				break;
			case 5:
				return;			//메서드의 종료
				//System.exit(0); 	종료메서드
				//break;
			
			}
			
			
			
		
//		//사용자의 입력 데이터를 인스턴스 생성
//		info = manager.createInstance();	//객체를 받을 수 있는 메서드 저장
//		//정보를 배열에 저장
//		manager.addInfo(info);
//		//전체 리스트를 출력
//		manager.showAllDate();
//		//이름으로 검색
//		manager.searchInfo();
//		//이름으로 검색 후 삭제
//		manager.deleteInfo();
//		manager.showAllData();	//삭제완료 확인
		
		
		}

		
		
		
		
		
		
		}
		
	}
	

