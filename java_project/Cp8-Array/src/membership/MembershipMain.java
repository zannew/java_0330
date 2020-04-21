package membership;

public class MembershipMain {
	public static void main(String[] args) {
		
		//회원 정보 5개를 저장 할 수 있는 배열을 생성
		//Member타입 인스턴스 참조값(주소)을 저장하는 메모리 공간
		//Member m1,m2,m3,m4,m5(참조변수 5개)과 같다.
		Member[] members = new Member[5];	
		
		members[0]=new Member("cool","시원한","cool@gmail.com");
		members[1]=new Member("hot","뜨거운","hot@gmail.com");
		members[2]=new Member("son","손흥민","son@gmail.com");
		members[3]=new Member("park","박지성","park@gmail.com");
		members[4]=new Member("woni","장윤원","woni@gmail.com");
		
//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
//		members[5].showInfo();
		
		for (int i=0;i<members.length;i++) {
			System.out.println(members[i]);
		}
		System.out.println("===========================");
		
		for (int i=0;i<members.length;i++) {
			members[i].showInfo();
			System.out.println("--------------------------");
		}
		
		
		
//		Member member = new Member("cool","시원한","cool@gmail.com");
//		
//		member.showInfo();
//		System.out.println("--------------------");
//		//member는 참조변수 , member.toString()호출→디버깅용
//		System.out.println(member);
		
		
	}
}
