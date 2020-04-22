package stringAssignment;
/*주석 : 문제풀이*/
public class Quiz_1 {
	public static void main(String[] args) {
		
		String str = "ABCDEFGHIJKLMN";
		
		StringBuffer str_rvs = new StringBuffer(str);
		
		System.out.println(str_rvs.reverse());
	}
	
//public static void main(String[] args) {
//	
//	  String str = "ABCDEFGHIJKLMN";
//	  int numOfStr = str.length();  //str 문자열길이를 numOfStr에 반환.
//	
//	/* 역순 String Class 사용 */
//	
//	  for (int i = numOfStr-1; i >= 0; i--) {
//	   char a = str.charAt(i);
//	   System.out.print(a+" ");
//	  }
//	  System.out.println("\n=========");
//	
//	  /* 역순 StringBuffer Class 사용 */
//	
//	  StringBuffer strB = new StringBuffer("ABCDEFGHIJKLMN");
//	  System.out.println(strB.reverse());
//	 }

	
	
	
	
}
