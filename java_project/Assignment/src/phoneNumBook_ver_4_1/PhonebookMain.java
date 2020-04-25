package phoneNumBook_ver_4_1;

import java.util.Scanner;

public class PhonebookMain {
	
	Scanner sc = new Scanner(System.in);	//입력받기위한 Scanner객체 생성
	private PhoneInfo info;							//PhoneInfo클래스 객체 생성위한 변수
	private PhoneInfo[] pBook;						//PhoneInfo[] 배열을 위한 변수 pBook
	private int numOfInfo;						//배열에 저장된 정보 개수 카운팅하는 변수
//	private int i;							//반복문, 배열index를 위한 변수 i
	
	//생성자
	public PhonebookMain() {
		pBook = new PhoneInfo[100];			//pBook배열의 객체생성
		cnt=0;								//cnt변수 초기화
	}
	
	//정보입력하고 객체 생성
	PhoneInfo createInst() {
		//info null값으로 초기화
		info =null;
		
		System.out.println("저장할 정보를 입력하는 페이지입니다.");
		
		System.out.println("이름을 입력하세요 : ");
		String name=sc.nextLine();
		
		System.out.println("전화번호를 입력하세요 : ");
		String phoneNum=sc.nextLine();
		
		System.out.println("주소를 입력하세요 : ");
		String address=sc.nextLine();

		System.out.println("이메일을 입력하세요 : ");
		String email=sc.nextLine();
		
		info= new PhoneInfo(name, phoneNum,address, email);
		
		//입력받은 데이터로 객체 생성 및 참조변수에 저장
//		if(bDay==null || bDay.isEmpty()) {
//			info = new PhoneInfo(name, phoneNum,address, email);
//		}else {
//			info = new PhoneInfo(name, phoneNum, address, email, major, year);
//		}
		
		return info;
	}

	
	//객체 저장 기능
	void storeInst(PhoneInfo info) {
		pBook[cnt]=info;
		cnt++;
	}
	//배열마다 주소값 저장하고 개수 카운팅(오버로딩)
	void storeInst() {
		pBook[cnt]=createInst();
		cnt++;
	}

	//저장된 정보 모두 출력 기능
	void showAllInfo() {
		
		for(int i=0;i<cnt;i++) {
			pBook[i].showBasicInfo();
			System.out.println("=================");
		}
	}
	//이름 검색하기
	void searchName() {
		System.out.println("검색하실 이름을 입력하세요 >> ");
		String name=sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("검색하신 이름이 없습니다.");
		}else {
			pBook[searchIndex].showBasicInfo();

		}
	}
	
	//이름 검색으로 배열 인덱스 찾기
	int searchIndexNum(String name) {
		
		int searchIndex=-1;
		
		for(int i=0;i<cnt;i++) {
			if(pBook[i].checkName(name)) {
				searchIndex=i;
				
				break;	
			}
		 }
		return searchIndex;
		}

	//이름 삭제하기
	void deleteName() {
		
		System.out.println("삭제하실 이름을 입력하세요 >> ");
		String name=sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("삭제하실 이름이 없습니다.");
		}else {
			for(int i=0;i<cnt;i++) {
				pBook[searchIndex]=pBook[i];
				
			}cnt--;
			
			System.out.println("삭제되었습니다.");
			
		}
		
		
	}
	
	
	


	
	
	

}
