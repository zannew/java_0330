package ex;

public class SwitchCaseBreak {
	public static void main(String[] args) {
	
		// with break
		
		int menuNum = 3;
		
		switch(menuNum) {
		
		case 1:
			System.out.println("1.Simple Java");
			break;
		case 2:
			System.out.println("2.Funny Java");
			break;
		case 3:
			System.out.println("3.Fantastic Java");
			break;
		default:
			System.out.println("d.The best programming language");
//			break;	//생략 가능
		}
		
		System.out.println("Do you like coffee?");
	
	}
}
