package newPhoneBook;

import java.util.Scanner;

public class PhoneInfo_Control {

	Scanner sc = new Scanner(System.in);
	PhoneInfo[] pBooks; //배열 생성
	
	int cnt;		//입력된 개수 카운팅
	
	
	PhoneInfo_Control(){
		pBooks = new PhoneInfo[100];
		
	}
	
	//객체 생성 메서드 - 참조변수 반환
	PhoneInfo createInstance(){
		
		PhoneInfo info = null;
		
		System.out.println("친구 연락처 저장을 위해 정보를 입력합니다.");
		System.out.println("이름을 입력하세요 >> ");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력하세요 >> ");
		String phoneNum = sc.nextLine();
		
		System.out.println("생일을 입력하세요 >> ");
		String bDay = sc.nextLine();
		
		if(bDay==null || bDay.length()==0) {
			info=new PhoneInfo(name, phoneNum);
			info.showInfo();
			System.out.println("-------------------------------");
		}else { 
			info=new PhoneInfo(name, phoneNum, bDay);
			info.showInfo();
			System.out.println("-------------------------------");
		}
		
		return info;
	}
	//addInfo	
	void save_Info(PhoneInfo info) {
		
			pBooks[cnt]=info;
			cnt++;
		
	}
	
	void save_Info() {
		
		pBooks[cnt]=createInstance();
		cnt++;
	
}
	
	
	void show_AllInfo() {
		
		for(int i=0;i<cnt;i++) {
			pBooks[i].showInfo();
			System.out.println("---------------------------");
		}
		
	}
	
	int searchIndex(String searchName) {
		
		int searchIndex=-1;
		
		for(int i=0;i<cnt;i++) {
			if(pBooks[i].checkName(searchName)) {
				searchIndex=i;
				break;
			}
			
		}
		return searchIndex;
	}
	
	
	
	void searchInfo() {
		
		
		System.out.println("검색하실 이름을 입력하세요");
		String searchName=sc.nextLine();
		
		int searchIndex=searchIndex(searchName);
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름이 없습니다.");
		}else {
			pBooks[searchIndex].showInfo();
		}
		
		
	}
	
	void deleteInfo() {
		
		System.out.println("삭제하실 이름을 입력하세요");
		
		String searchName=sc.nextLine();
		
		int searchIndex=searchIndex(searchName);
		
		if(searchIndex<0) {
			System.out.println("삭제할 정보가 없습니다.");
		}else {
			for(int i=0;i<cnt-1;i++) {
				pBooks[i]=pBooks[i+1];
				
			}cnt--;
			System.out.println("삭제 완료");
		}
		
	}
	
	
}
