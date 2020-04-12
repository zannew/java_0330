package op;

public class OperatorEx_10 {
	public static void main(String[] args) {
		
		int a = 1000000; // 1,000,000 1백만 → long a = 1000000L;로 형변환
		int b = 2000000; // 2,000,000 2백만 →	long b = 2000000L;로 형변환
		long c = (a * b); // 2,000,000,000,000 
		System.out.println((long)c); //int타입 값의 표현 범위를 초과해서 값이 왜곡되어 출력
		
	}
}
