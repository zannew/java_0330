package api;

public class StringTest {

	public static void main(String[] args) {
		
		
		String str1 = "My String";		//str1과 str2는 같은 객체를 가리킨다
		String str2 = "My String";
		String str3 = "Your String";	//str3는 다른 객체
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		
		
		System.out.println("--------------------");
		

		java.lang.String str = "My name is JAVA";
		
		int strLength = str.length();
		System.out.println("문자열 str의 문자열 길이는 : "+ strLength);
		
		int strLength2 = "한글의 길이는?".length();
		System.out.println("길이 : "+ strLength2);
		
		
		
	}

}
