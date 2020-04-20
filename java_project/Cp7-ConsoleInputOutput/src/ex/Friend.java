package ex;

public class Friend {
	
	String myName;

	//생성자
	Friend(String name){
		myName=name;
	}
	
	
	@Override
	public String toString() {
		return "Friend [myName=" + myName + "]";
	}

	





	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
	}

}
