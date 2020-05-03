package phoneNumBook_ver_6_1;

import java.util.LinkedList;
import java.util.Scanner;

import phoneNumBook_ver_5_1_exception.StringEmptyException;

public class PhonebookManager {
	
	//싱글톤 패턴처리
	//공동으로 사용할 인스턴스를 (하나만)생성
	private static PhonebookManager main = new PhonebookManager(100);
	
	public static PhonebookManager getInstance() {
		return main;
	}
	
	private PhoneInfo info;							//PhoneInfo클래스 변수선언
	//제네릭클래스 LinkedList<> PhoneInfo타입 인스턴스 저장할 pBook변수 선언(private)
	private LinkedList<PhoneInfo> pBook;
	
	
	//생성자 초기화
	public PhonebookManager(int numOfFriend) {
		//인스턴스(제네릭클래스)를 PhoneInfo타입 데이터만 저장할 수 있도록 생성
		pBook=new LinkedList<PhoneInfo>();
		
	}
	
	//정보입력하고 객체 생성
	PhoneInfo createInst(int selectOpt2) {
		//info인스턴스 변수를  null값으로 초기화
		info =null;									//참조변수 info를  null값으로 초기화
		
		String name, phoneNum, address, email;
		
		while(true) {
		
			//1. 기본 정보 입력
			System.out.println("저장할 정보 입력단계입니다.");
			
			//공통 기본 정보 입력 - 이름, 전화번호, 주소, 이메일
			System.out.println("이름을 입력하세요 : ");
			name=AppStarter.sc.nextLine();
			
			System.out.println("전화번호를 입력하세요 : ");
			phoneNum=AppStarter.sc.nextLine();
			
			System.out.println("주소를 입력하세요 : ");
			address=AppStarter.sc.nextLine();
	
			System.out.println("이메일을 입력하세요 : ");
			email=AppStarter.sc.nextLine();
			
			//기본정보로 객체생성 - 현재 PhoneInfo클래스는 추상클래스이므로 객체 생성불가능
//			info=new PhoneInfo(name, phoneNum, address, email);
		
			//예외 처리 - if문 조건 : 문자열값의 공백을 제거해주는 trim,공백 여부 체크해주는 isEmpty메서드
			try {
				if(name.trim().isEmpty()
						|| phoneNum.trim().isEmpty()
						||address.trim().isEmpty()
						||email.trim().isEmpty()) {
					StringEmptyException e = new StringEmptyException("공백은 입력하실 수 없습니다.");
					throw e;
				}
			}catch(StringEmptyException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력해주세요.");
				continue;
			}

		
		//2.대학 친구 정보 입력
		if(selectOpt2==Menu.INSERT_UNIV) {							
			
			System.out.println("전공을 입력하세요 : ");	
			String major=AppStarter.sc.nextLine();
			System.out.println("학년을 숫자로 입력하세요 : ");
			String year=AppStarter.sc.nextLine();
			
			//대학 친구 정보로 객체생성
			info=new PhoneUnivInfor(name, phoneNum, address, email, major, year);
		}
		//3. 직장 동료 정보 입력
		else if(selectOpt2==Menu.INSERT_COMPANY) {					
			
			System.out.println("직장을 입력하세요 : ");
			String company=AppStarter.sc.nextLine();
			
			//직장 친구 정보로 객체생성
			info=new PhoneCompanyInfor(name, phoneNum, address, email, company);
		}
		//4. 동호회 친구 선택
		else if(selectOpt2==Menu.INSERT_SOCIETY) {					
			
			System.out.println("동호회 활동명을 입력하세요 : ");
			String nickname=AppStarter.sc.nextLine();
			
			//동호회 친구 정보로 객체생성
			info=new PhoneSocietyInfor(name, phoneNum, address, email, nickname);
			break;
		}
		break;
	}
		return info;
		
	}
	//정보 담긴 객체 참조변수 배열에 저장
	void storeInst(PhoneInfo info) {
		//인스턴스 담긴 변수 info를 add메서드 활용, LinkedList pBook에 저장
		pBook.add(info);
		
		System.out.println("♠♠♠성공적으로 저장되었습니다.♠♠♠");
	}

	//저장된 정보 모두 출력 기능
	void showAllInfo() {
		
		for(int i=0;i<pBook.size();i++) {
			//get메서드 활용, i번째에 담긴 참조변수로 정보보기메서드 호출
			pBook.get(i).showBasicInfo();
			pBook.get(i).showDetail();
			
			System.out.println("=================");
		}
	}
	
	//이름 검색하기
	void searchName() {
		System.out.println("검색하실 이름을 입력하세요 >> ");
		String name=AppStarter.sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("검색하신 이름이 없습니다.");
		}else {
			//get메서드 활용, searchIndex번째에 담긴 참조변수로 정보보기메서드 호출
			pBook.get(searchIndex).showBasicInfo();
			pBook.get(searchIndex).showDetail();
		}
	}
	
	//이름 검색으로 배열 인덱스 찾기
	int searchIndexNum(String name) {
		
		int searchIndex=-1;
		//size()메서드 호출해서 List의 크기(요소 담긴 개수)만큼 반복문 작성
		for(int i=0;i<pBook.size();i++) {
			//get메서드 활용, i번째에 담긴 참조변수로 네임체크메서드 호출
			if(pBook.get(i).checkName(name)) {
				searchIndex=i;
				
				break;	
			}
		 }
		return searchIndex;
		}

	//이름 삭제하기
	void deleteName() {
		
		System.out.println("삭제하실 이름을 입력하세요 >> ");
		String name=AppStarter.sc.nextLine();
		
		int searchIndex=searchIndexNum(name);
		
		
		if(searchIndex<0) {
			System.out.println("삭제하실 이름이 없습니다.");
		}else {
			//remove메서드 사용해서 검색된 searchIndex번째 요소 삭제
			pBook.remove(searchIndex);
			System.out.println("♠♠♠삭제되었습니다.♠♠♠");
			System.out.println("삭제 확인 후 정보 확인");
			for(int i=0;i<pBook.size();i++) {
				pBook.get(i).showBasicInfo();
				pBook.get(i).showDetail();
			}
			
		}
	}

	//6. 배열의 정보를 수정하기 : 이름 기준	→ 나머지 데이터 입력받기 
	void editInfo() {
		System.out.println("정보를 수정하고자 하는 이름을 입력하세요");
		String name=AppStarter.sc.nextLine();
		
		int searchIndex=searchIndexNum(name);

		if(searchIndex<0) {
			System.out.println("찾으시는 이름이 없습니다.");
		}else {
			//get메서드 활용, searchIndex번째에 담긴 참조변수로 getName메서드 호출해서 name받아오기
			String editName = pBook.get(searchIndex).getName();
			
			
			System.out.println("정보 수정을 시작합니다.");
			System.out.println("정보 수정 대상 : "+editName);
			System.out.println("새로운 전화번호를 입력하세요.");
			String phoneNum=AppStarter.sc.nextLine();
			System.out.println("새로운 주소를 입력하세요.");
			String address=AppStarter.sc.nextLine();
			System.out.println("새로운 이메일을 입력하세요.");
			String email=AppStarter.sc.nextLine();
			
			PhoneInfo info=null;
			//pBook에 담긴 인스턴스 타입이 PhoneUnivInfor타입으로 형변환 가능한지 true OR false
			if(pBook.get(searchIndex) instanceof PhoneUnivInfor) {
				System.out.println("수정할 전공을 입력하세요.");
				String major=AppStarter.sc.nextLine();
				System.out.println("수정할 학년을 입력하세요.");
				String year=AppStarter.sc.nextLine();
				
				info=new PhoneUnivInfor(editName, phoneNum, address, email, major, year);
			
			//pBook에 담긴 인스턴스 타입이 PhoneCompanyInfor타입으로 형변환 가능한지 true OR false
			}else if(pBook.get(searchIndex) instanceof PhoneCompanyInfor) {
				System.out.println("수정할 회사이름을 입력하세요.");
				String company=AppStarter.sc.nextLine();
				
				info=new PhoneCompanyInfor(editName, phoneNum, address, email, company);
			
			//pBook에 담긴 인스턴스 타입이 PhoneSocietyInfor타입으로 형변환 가능한지 true OR false
			}else if(pBook.get(searchIndex) instanceof PhoneSocietyInfor) {
				System.out.println("수정할 동호회 닉네임을 입력하세요.");
				String nickName=AppStarter.sc.nextLine();
			
				info=new PhoneSocietyInfor(editName, phoneNum, address, email, nickName);
			
			//pBook에 담긴 인스턴스 타입이 PhoneInfo타입으로 형변환 가능한지 true OR false
			}else if(pBook.get(searchIndex) instanceof PhoneInfo) {
				
//				info=new PhoneInfo(editName, phoneNum, address, email);
				System.out.println("현재 기본정보만 수정불가");
				
				
			}
			//기존에 수정하려던 searchIndex의 인스턴스 삭제
			pBook.remove(searchIndex);
			//searchIndex번째에 인스턴스 info저장
			pBook.add(searchIndex, info);
		}
	}
}





