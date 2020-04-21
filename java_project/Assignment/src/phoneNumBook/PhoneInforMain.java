package phoneNumBook;

public class PhoneInforMain {

	static String name;
	static String phoneNum;
	static String bDay;
	
	
	//메인메서드
		public static void main(String[] args) {
			//인스턴스 생성
			PhoneInfor infor = new PhoneInfor(name, phoneNum, bDay);
			PhoneInfor_Store store = new PhoneInfor_Store();
			PhoneInfor_Show show = new PhoneInfor_Show();
			
			//생성된 인스턴스로 메서드호출
			while(true) {
			infor.input_Info();
			show.show_Info();
			}
			
		}
	
	
}
