package op;

public class Test {
	public static void main(String[] args) {
		
		char ch = 'A';

		char lowerCase =  ((boolean)((ch<97) || (ch<=65)) ? (char)(ch+32) : ch);

		System.out.println("ch:"+ch);

		System.out.println("ch to lowerCase:"+lowerCase);
		
		}
	
	}

