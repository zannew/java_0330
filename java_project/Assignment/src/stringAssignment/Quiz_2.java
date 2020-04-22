package stringAssignment;
/*주석 : 문제풀이*/
public class Quiz_2 {

	public static void main(String[] args) {
		
		String str = "990929-1010123";
		
		StringBuffer str_delete = new StringBuffer(str);
		
		System.out.println(str_delete.deleteCharAt(6));
	}
	
//	 /* StringBuffer 사용 1- deleteCharAt / indexOf */
//	
//	  StringBuffer str = new StringBuffer("990929-1010123");
//	  System.out.println(str.deleteCharAt(str.indexOf("-")));
//
//	  /* String Class 사용 2- replace */
//	  
//	  String str2 = "990929-1010123";
//	  System.out.println(str2.replace("-", ""));
//
//	  /* String Class 사용 - unicode로 숫자 판별 */
//	  
//	  String assemble = "";
//	  
//	  // unicode 반환
//	  for (int i = 0; i < str2.length(); i++) {
//	   int uniNum = str2.codePointAt(i);
//
//	   if (uniNum >= '0' && uniNum <= '9') {
//	    assemble += str2.charAt(i);
//	   }
//	  }
//	  System.out.println(assemble);
//	 }
	
	
	
}
