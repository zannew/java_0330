package ex1;

public class StringTest {

	public static void main(String[] args) {

		double dd = 1D;
		String a = 7 + " ";		//문자열7과 " "이 출력
		String b = " "+ 7;		//문자열" "과 7이 출력
		String c = 7 + "";		//문자열 7 출력
		String d = ""+ 7;		//문자열 7 출력
		String e = ""+"";		//문자열이지만 출력없음
		String f = 7 + 7 +"";	//int형으로 7+7 더하기 연산 후 문자열 출력
		String g = ""+ 7 + 7;	//문자열로 변환 후 7과 7 문자열로 출력
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		
	}

}
