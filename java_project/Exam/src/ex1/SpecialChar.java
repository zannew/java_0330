package ex1;

public class SpecialChar {

	public static void main(String[] args) {
		char single = '\'';			// \'하면 홑따옴표 출력(single = ''';와 같이 할 수 없다)
		String dblQuote = "\"Hello\"";		// /"하면 겹따옴표 출력
		String root = "c:\\";			//	\\하면 역슬래시 출력
		System.out.println(single);		//문자타입으로 출력
		System.out.println(dblQuote);	//문자열타입으로 출력
		System.out.println(root);		//문자열타입으로 출력
		
	}

}
