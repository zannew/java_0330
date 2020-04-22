package phoneNumBook;

import java.util.Scanner;

public class PhonebookMain {
	
	Scanner sc = new Scanner(System.in);
	PhoneInfo info;
	PhoneInfo[] pBook;
	int cnt;
	private int i;
	

	public PhonebookMain() {
		pBook = new PhoneInfo[100];
		cnt=0;
	}
	
	//정보입력하고 객체 생성
	PhoneInfo createInst() {
		
		info=null;
		
		System.out.println("저장할 정보를 입력하는 페이지입니다.");
		
		System.out.println("이름을 입력하세요 : ");
		String name=sc.nextLine();
		
		System.out.println("전화번호를 입력하세요 : ");
		String phoneNum=sc.nextLine();
		
		System.out.println("생일을 입력하세요 : ");
		String bDay=sc.nextLine();
		
		//입력받은 데이터로 객체 생성
		if(bDay==null || bDay.isEmpty()) {
			info = new PhoneInfo(name, phoneNum);
		}else {
			info = new PhoneInfo(name, phoneNum, bDay);
		}
		return info;
	}

	
	//객체 저장 기능
	void storeInst(PhoneInfo info) {
		pBook[cnt]=info;
		cnt++;
	}
	
	void storeInst() {
		pBook[cnt]=createInst();
		cnt++;
	}

	//저장된 정보 모두 출력 기능
	void showAllInfo() {
		
		for(int i=0;i<cnt;i++) {
			pBook[i].showInfo();
			System.out.println("=================");
		}
	}
	
	void searchName() {
		System.out.println("검색하실 이름을 입력하세요 >> ");
		String name=sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("검색하신 이름이 없습니다.");
		}else {
			pBook[searchIndex].showInfo();

		}
	}
	
	
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


	void deleteName() {
		
		System.out.println("삭제하실 이름을 입력하세요 >> ");
		String name=sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("삭제하실 이름이 없습니다.");
		}else {
			for(int i=0;i<cnt-1;i++) {
				pBook[i]=pBook[i+1];
				
			}cnt--;
			
			System.out.println("삭제되었습니다.");
			
		}
		
		
	}
	
	
	


	
	
	

}
