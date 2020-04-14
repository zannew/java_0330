package ex;

public class Method_1 {
	public static void main(String[] args) {
		//메서드를사용하기 위해서는 인스턴스(객체)를 생성한 후 사용 가능
		//메서드 코드를 메모리에 로드
		
		//인스턴스 생성(객체 생성)
		MyMath math = new MyMath();
		
		long result = math.add(10, 100);	//리터럴 타입 자동형변환(int→long)
		
		System.out.println(result);
		System.out.println(math.add(10000000000L, 20000000000L));
		
	}
	int add() {
		
		return 10;
	}
	
}
