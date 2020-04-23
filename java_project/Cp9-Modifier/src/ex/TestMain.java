package ex;

public class TestMain {

	public static void main(String[] args) {
		
//		Singleton.s =null;	값을 변경할 수 있는 상태
		
		Singleton s = Singleton.getInstance();		//객체를 불러온다
		s.print();
		//객체 생성
		Member member = new Member();
		//getName(getter)
		System.out.println(member.getName());
		
	}
	
}
