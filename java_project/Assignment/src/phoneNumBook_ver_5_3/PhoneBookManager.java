package phoneNumBook_ver_5_3;

import java.util.Scanner;

public class PhoneBookManager {

	public static Scanner sc=new Scanner(System.in);
//	PhoneBookMain main = new PhoneBookMain();
	PhoneInfo info;
	PhoneInfo[] phoneBook;
	int numOfInfo;
	int i;
	int searchIndex=-1;
	
	
	PhoneBookManager(){
		phoneBook=new PhoneInfo[100];
		info=null;
		numOfInfo=0;
	}
	
	PhoneInfo createInstance(int selectOpt2) {
		System.out.println("정보 입력을 시작합니다.");
		System.out.println("이름을 입력하세요.");
		String name=sc.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phoneNum=sc.nextLine();
		System.out.println("주소를 입력하세요.");
		String address=sc.nextLine();
		System.out.println("이메일을 입력하세요.");
		String email=sc.nextLine();

		//기본정보로 객체 생성
//		info=new PhoneInfo(name, phoneNum, address, email);
		
//2020-05-01		
//		if(bDay==null || bDay.trim().isEmpty()) {
//			info=new PhoneInfo(name, phoneNum);
//		}else {
//			info=new PhoneInfo(name, phoneNum, bDay);
//		}
		
		switch(selectOpt2) {
		
		case 1:
			System.out.println("전공을 입력하세요.");
			String major=sc.nextLine();
			System.out.println("학년을 입력하세요.");
			String year=sc.nextLine();
			
			info=new PhoneUnivInfo(name, phoneNum, address, email, major, year);
			break;
		case 2:
			System.out.println("회사명을 입력하세요.");
			String company=sc.nextLine();
			System.out.println("부서를 입력하세요.");
			String dept=sc.nextLine();
			System.out.println("직급을 입력하세요.");
			String position=sc.nextLine();
			
			info=new PhoneCompanyInfo(name, phoneNum, address, email, company, dept, position);
			break;
			
		
		case 3:
			System.out.println("동호회 이름을 입력하세요.");
			String nameOfSociety=sc.nextLine();
			System.out.println("동호회 닉네임을 입력하세요.");
			String nickName=sc.nextLine();
		
			info=new PhoneSocietyInfo(name, phoneNum, address, email, nameOfSociety, nickName);
		
		
		
		
		
		}
		
		return info;
	}
	
	void storeInstance(PhoneInfo info) {
		phoneBook[numOfInfo] = info;
		numOfInfo++;
	}
	//오버로딩
	void storeInstance() {
		phoneBook[numOfInfo]=createInstance(PhoneBookMain.selectOpt2);
		numOfInfo++;
	}
	
	

	boolean checkName(String name) {
		return phoneBook[i].equals(name);
	}
	
	
	int searchIndex(String name) {
		
		
		for(i=0;i<numOfInfo;i++) {
			if(checkName(name)) {
				this.searchIndex=i;
				break;
			}
	}return searchIndex;
	
	}
	
	
	void searchInfo() {
		System.out.println("검색하실 이름을 입력하세요.");
		String name=sc.nextLine();
		this.searchIndex=searchIndex(name);
		
		if(searchIndex<0) {
			System.out.println("▶MESSAGE : 찾으시는 정보가 없습니다");
		}else {
			phoneBook[searchIndex].showData();
		}
		
		
		
	}
	
	void deleteInfo() {
		System.out.println("삭제하실 이름을 입력하세요.");
		String name=sc.nextLine();
		this.searchIndex=searchIndex(name);
		
		if(searchIndex<0) {
			System.out.println("▶MESSAGE : 삭제하고자 하는 정보가 없습니다");
		}else {
			for(int i=searchIndex;i<numOfInfo-1;i++) {
				phoneBook[i]=phoneBook[i+1];
			}numOfInfo--;
			System.out.println("▶MESSAGE : 요청하신 정보가 삭제되었습니다.");
		}
		
		
		
	}	
	
	void showInfo() {
		for(int i=0;i<numOfInfo;i++) {
			phoneBook[i].showData();
		}
	}
	
	
}
