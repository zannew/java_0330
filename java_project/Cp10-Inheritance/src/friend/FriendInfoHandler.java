package friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {
/*2020.04.28 싱글톤처리
 * 1.manager클래스의 싱글톤 패턴
		1.생성자 접근제어지시자 : private (목적 : 인스턴스 생성을 금지)
		2.공동으로 사용할 인스턴스를 생성 : static + private
		3.만들어놓은 참조변수를 반환하는 메서드 필요 : static + public(외부접근 허용)
		
2020.05.01 수정
배열에 데이터 저장하던 방식 → List이용
 * */
	//인스턴스를 하나만 가져야하는 상황
	private static FriendInfoHandler handler = new FriendInfoHandler(100);
	
	public static FriendInfoHandler getInstance() {
		return handler;
	}
	
	// Friend타입의 정보를 저장할 배열을 가진다.
	// 친구정보를 저장하는 기능
	// 친구정보의 기본 정보 출력
	// 친구정보의 상세 정보 출력
	
	
	//private Friend[] myFriends;			//Friend타입의 배열 선언
	
	//List 참조변수
	private ArrayList<Friend> myFriends;
	
	
	//private int numOfFriend;			//저장된 친구의 정보 개수
	
	Scanner sc;
	
	//생성자 초기화 : 저장공간(사이즈)크기를 받아서 배열 생성
	private FriendInfoHandler(int num) {
		//myFriends=new Friend[num];
		//numOfFriend=0;
		
		//ArrayList 인스턴스 생성
		myFriends=new ArrayList<Friend>();
		sc = new Scanner(System.in);
		
	}
	
	// 친구정보를 저장하는 기능
	//1.배열에 저장하는 기능
	//2.사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	
	//1.배열에 저장하는 기능(Friend타입 참조변수 받는다.)
	void addFriendInfo(Friend f) {
		//배열에 저장
		//myFriends[numOfFriend]=f;
		//numOfFriend++;
		
		myFriends.add(f);
		
	}
	//2.사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	// HighFriend / UnivFriend 각각 필요한 데이터가 다르다. → 분기처리
	void addFriend(int choice) {
		
		//이곳에서 스캐너 객체를 생성한다면 메서드가 반복될때마다 객체가 생성된다.
		
		//기본정보 받기
		System.out.println("친구의 이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("친구의 전화번호를 입력해주세요.");
		String phoneNum=sc.nextLine();
		System.out.println("친구의 주소를 입력해주세요.");
		String addr=sc.nextLine();
		
		Friend friend=null;
		
		if(choice==1) {
			//1일 때 정보 받기
			System.out.println("친구의 직업을 입력해주세요.");
			String work=sc.nextLine();
			
			//HighFriend인스턴스 생성
			friend=new HighFriend(name, phoneNum, addr, work); 
		}else {
			//2일 때 정보 받기
			System.out.println("친구의 전공을 입력해주세요.");
			String major=sc.nextLine();
			System.out.println("친구의 학년을 숫자로 입력해주세요.");
			String grade=sc.nextLine();		//int로 받지 않은 이유? buffer문제(공백passing)
			//Integer.parseInt(grade);
			
			//UnivFriend인스턴스 생성
			friend = new UnivFriend(name, phoneNum, addr, major, Integer.parseInt(grade));
			
		}
		
		//addFriendInfo호출
		addFriendInfo(friend);
		
	}
	
	
	// 친구정보의 기본 정보 출력
	void showAllSimpleData() {
		
		System.out.println("==============친구의 기본 정보를 출력합니다 ==============");
		for(int i=0;i<myFriends.size();i++) {
			//myFriends[i].showBasicInfo();
			myFriends.get(i).showBasicInfo();
			System.out.println("------------------------------");
		}
	}
	
	// 친구정보의 상세 정보 출력
	void showAllData() {
		
		System.out.println("================친구의 모든 정보를 출력합니다==============");
		for(int i=0;i<myFriends.size();i++) {
			//myFriends[i].showData();
			myFriends.get(i).showBasicInfo();
		}
		
	}
	
	
	
	
}
