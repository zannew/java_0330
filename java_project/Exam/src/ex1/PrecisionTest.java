package ex1;

public class PrecisionTest {

	public static void main(String[] args) {
		
		float f = 1.2345678901234567890f;	//접미사f를 붙여주지 않으면 컴파일 에러가 생긴다.
		double d = 1.2345678901234567890;	//실수는 기본형이 double이기 때문에 접미사d가 생략 가능
		float f2 = 0.100000001f;			//접미사f를 붙여주지 않으면 컴파일 에러가 생긴다.		
		double d2 = 0.100000001;			//실수는 기본형이 double이기 때문에 접미사d가 생략 가능
		double d3 = 0.1000000000000001;		//실수는 기본형이 double이기 때문에 접미사d가 생략 가능
		
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);
		
	}

}

