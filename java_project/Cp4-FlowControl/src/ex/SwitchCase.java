package ex;

public class SwitchCase {
	public static void main(String[] args) {
	
		// without break
		
		int menuNum = 2;
		
		switch(menuNum) {
		
		case 1:
			System.out.println("1.Simple Java");
		case 2:
			System.out.println("2.Funny Java");
		case 3:
			System.out.println("3.Fantastic Java");
		default:
			System.out.println("d.The best programming language");
		}
		
		System.out.println("Do you like coffee?");
	
	}
}
