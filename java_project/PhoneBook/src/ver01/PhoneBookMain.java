package ver01;

public class PhoneBookMain {
	public static void main(String[] args) {
		
		PhoneInfor info = new PhoneInfor("손흥민", "010-9999-9999", "2000.11.11"); //박지성 만들어지면 삭제 대상됨
		
		info.showInfo();
				
		System.out.println("---------------------------");
		
		info = new PhoneInfor("박지성", "010-1234-1234");
		info.showInfo();
		
		
	}
}

