package phoneNumBook_ver_4_1;

import java.util.Scanner;

public class PhonebookMain {
	
	private PhoneInfo info;							//PhoneInfo클래스 변수선언
	private PhoneInfo[] pBook;						//PhoneInfo[] 변수 pBook 선언
	private int numOfFriend;						//친구 정보 개수 카운팅  변수 선언
	AppStarter app;
	
	
	//생성자 초기화
	public PhonebookMain(int numOfFriend) {
		pBook = new PhoneInfo[numOfFriend];			//PhoneInfo[]타입 객체 생성
		numOfFriend=0;								//numOfFriend변수 초기화
		app=new AppStarter();
	}
	
	//정보입력하고 객체 생성
	PhoneInfo createInst(int selectOpt2) {
		//info인스턴스 변수를  null값으로 초기화
		info =null;									//참조변수 info를  null값으로 초기화
		
		
			//1. 기본 정보 입력
			System.out.println("저장할 정보 입력단계입니다.");
			
			//공통 기본 정보 입력 - 이름, 전화번호, 주소, 이메일
			System.out.println("이름을 입력하세요 : ");
			String name=app.sc.nextLine();
			
			System.out.println("전화번호를 입력하세요 : ");
			String phoneNum=app.sc.nextLine();
			
			System.out.println("주소를 입력하세요 : ");
			String address=app.sc.nextLine();
	
			System.out.println("이메일을 입력하세요 : ");
			String email=app.sc.nextLine();
			
			//기본정보로 객체생성
			info=new PhoneInfo(name, phoneNum, address, email);

		
		//2.대학 친구 정보 입력
		if(selectOpt2==2) {							
			
			System.out.println("전공을 입력하세요 : ");	
			String major=app.sc.nextLine();
			System.out.println("학년을 숫자로 입력하세요 : ");
			String year=app.sc.nextLine();
			
			//대학 친구 정보로 객체생성
			info=new PhoneUnivInfor(name, phoneNum, address, email, major, year);
			
		}
		//3. 직장 동료 정보 입력
		else if(selectOpt2==3) {					
			
			System.out.println("직장을 입력하세요 : ");
			String company=app.sc.nextLine();
			
			//직장 친구 정보로 객체생성
			info=new PhoneCompanyInfor(name, phoneNum, address, email, company);
		
		}
		//4. 동호회 친구 선택
		else if(selectOpt2==4) {					
			
			System.out.println("동호회 활동명을 입력하세요 : ");
			String nickname=app.sc.nextLine();
			
			//동호회 친구 정보로 객체생성
			info=new PhoneSocietyInfor(name, phoneNum, address, email, nickname);
			
		}return info;
	}
	
	//정보 담긴 객체 참조변수 배열에 저장
	void storeInst(PhoneInfo info) {
		pBook[numOfFriend]=info;
		numOfFriend++;
		System.out.println("♠♠♠성공적으로 저장되었습니다.♠♠♠");
	}

	//저장된 정보 모두 출력 기능
	void showAllInfo() {
		
		for(int i=0;i<numOfFriend;i++) {
			
			pBook[i].showBasicInfo();
			pBook[i].showDetail();
			
			System.out.println("=================");
		}
	}
	
	//이름 검색하기
	void searchName() {
		System.out.println("검색하실 이름을 입력하세요 >> ");
		String name=app.sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("검색하신 이름이 없습니다.");
		}else {
			pBook[searchIndex].showBasicInfo();
			pBook[searchIndex].showDetail();
		}
	}
	
	//이름 검색으로 배열 인덱스 찾기
	int searchIndexNum(String name) {
		
		int searchIndex=-1;
		
		for(int i=0;i<numOfFriend;i++) {
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
		String name=app.sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("삭제하실 이름이 없습니다.");
		}else {
			for(int i=searchIndex;i<numOfFriend;i++) {
				pBook[i]=pBook[i+1];
				
			}numOfFriend--;
			
			System.out.println("♠♠♠삭제되었습니다.♠♠♠");
			
		}
		
	}
}
