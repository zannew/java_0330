package operator_2;

public class Quiz_10 {
	public static void main(String[] args) {
		
		char ch = 'A';

		char lowerCase = (boolean)((ch<97) || (ch<=65)) ? (char)(ch+32) : ch;

		System.out.println("ch:"+ch);

		System.out.println("ch to lowerCase:"+lowerCase);
	}
}
