package ex;

public class PersonalNumInfo {

	private String name;
	private String number;
	
	PersonalNumInfo(String name, String number) {
		this.name=name;
		this.number=number;
	}
	//getter메서드 통해서만 변수의 값을 받을 수 있다
	String getName() {
		return name;
	}
	
	String getNumber() {
		return number;
	}
	
	
	
	
}
