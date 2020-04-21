package phoneBook;

public class PhoneInfo {
	public static void main(String[] args) {

		
		
		
		
	}
	
	String name;
	String phoneNum;
	String bDay;
	
	//생성자(생일없음)
	PhoneInfo(String name, String phoneNum){
		this.name=name;
		this.phoneNum=phoneNum;
	}
	//생성자
	PhoneInfo(String name, String phoneNum, String bDay){
		this.name=name;
		this.phoneNum=phoneNum;
		this.bDay=bDay;
	}
	
	void showInfo() {
		System.out.println("이름: "+this.name+", 전화번호: "+this.phoneNum+", 생일: "+this.bDay);
	}
	
	
}
