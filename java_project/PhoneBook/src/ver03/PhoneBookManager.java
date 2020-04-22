package ver03;

import java.util.Scanner;

/*Project : ver 0.30

배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
 * */

public class PhoneBookManager {
	
	final PhoneInfor[] pBooks;
	
	//cnt : 입력된 친구의 정보 개수 → 입력된 배열의 요소 개수
	//1. 참조할 때 반복의 횟수(검색, 삭제 시 활용)
	//2. 새로운 객체를 저장할 때 index로 활용 → 새롭게 입력할 인덱스 = (cnt-1)+1
	int cnt;
	
	Scanner sc;		//메서드 하나라면 안에 작성 ok

	public PhoneBookManager() {
		
		//배열 초기화
		pBooks = new PhoneInfor[100];
		//저장 개수 초기화(생성자통한 초기화-better)
		cnt=0;
		//Scanner 객체 초기화(생성자통한 초기화)
		 sc = new Scanner(System.in);
	}
	
	//저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	//배열에 PhoneInfor타입의 참조값을 저장(반환 필요없음)
	void addInfo(PhoneInfor info) {
		
		//배열의 요소 대입
		pBooks[cnt] = info;
		
		//등록된 정보의 개수를 증가
		cnt++;
	}
	//오버로딩
	void addInfo() {
			
			//배열의 요소 대입
			pBooks[cnt] = createInstance();
			
			//등록된 정보의 개수를 증가
			cnt++;	//52줄 cnt를 cnt++해도 ok
		}
	
	

	//사용자의 입력데이터로 PhoneInfor객체 생성
	PhoneInfor createInstance() {
	
		PhoneInfor info = null;
		
		
		System.out.println("친구의 정보를 저장하기 위한 데이터를 입력합니다.");
		
		System.out.println("이름을 입력해주세요.>>");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해주세요.>>");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생일을 입력해주세요.>>");
		String birthday=sc.nextLine();
		
		//사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
		if(birthday==null || birthday.trim().isEmpty()){	//trim : 양옆의 공백을 제거해주는 메서드(String반환), isEmpty : 문자열의 길이가 0일때 true반환
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name, phoneNumber, birthday); 
		}
		
		return info;
		//사용자로부터 데이터를 받아 인스턴스 생성
		
		
	}
	
	//전체 리스트 출력
	void showAllData() {
		
		//전체 데이터 → 입력된 데이터의 개수 : cnt만큼 출력 
		for(int i=0;i<cnt;i++) {
			pBooks[i].showInfo();
			System.out.println("---------------------------");
		}
		
		
	}
	
	//배열에서 이름을 기준으로 검색 후 index값을 반환
	int searchIndex(String name) {
		
		int searchIndex = -1;		//찾지 않을 경우, 검색결과가 없을 경우를 위한 변수 초기화
		
		//사용자가 입력한 이름으로 배열의 요소를 검색 → index를 찾는다(위치한 곳의 참조값이 필요)
				for(int i=0;i<cnt;i++) {
					if(pBooks[i].checkName(name)) {
						searchIndex = i;
						break;
					}
				}
				return searchIndex;
	}
	
	
	//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	//배열의 요소(PhoneInfor)의 name(속성)값으로 배열의 요소(해당하는 참조)를 찾는다.
	void searchInfo() {
		
		System.out.println("검색하고자 하는 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		
		int searchIndex=searchIndex(name);		
		
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		}else {
			pBooks[searchIndex].showInfo();
		}
		
	}
	
	
	
	//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
	void deleteInfo() {
		
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		
		int searchIndex=searchIndex(name);		
		
		
		//삭제
		//pBooks[2] : 삭제할 경우, pBooks[2]=null을 저장 ok but,shift
		//데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
		//재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		}else {
			
			//삭제 : 검색한 index부터 저장된 위치까지 왼쪽으로 shift처리
			for(int i=searchIndex;i<cnt-1;i++) {
				pBooks[i]=pBooks[i+1];
			}
			
			//★★★저장된 정보의 개수를  -1 해준다.
			cnt--;
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
