package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		PhoneInfor info = null;		//불필요한 변수 생성을 막기 위해 블럭 밖에서 선언
		
		while(true) {
			
		info = manager.createInstance();	//객체를 받을 수 있는 메서드 저장
		info.showInfo();
		
		}
		
	}
	
}
