package op;

public class OperatorEx_23 {
	public static void main(String[] args) {
		
	float f = 0.1f;			//float타입 변수f 선언하고 0.1f 값을 저장
	double d = 0.1;			//double타입 변수d 선언하고 0.1 값 저장
	double d2 = (double)f;	//double타입 변수d2 변수f의 값을 double로 형 변환
	
	System.out.println("10.0==10.0f ? "+(10.0==10.0f));	//int타입으로 취급 10==10 이므로 true
	System.out.println("0.1==0.1f ? "+(0.1==0.1f));		//double타입 0.1과 float타입 0.1의 값은 다르다
	System.out.println("f="+f);							//float타입 변수 f의 값
	System.out.println("d="+d);							//double타입 변수 d의 값
	System.out.println("d2="+d2);						
	//float타입 변수 f의 값을 double로 형 변환하여 d2에 저장된 값 출력
	System.out.println("d==f ? "+(d==f));				//double타입 d와 float타입 f의 값은 다르다.(false)
	System.out.println("d==d2 ? "+(d==d2));				
	//double타입 d와 float타입 f의 값이 double타입으로 변환되어 저장된 d2의 값은 다르다.(false) 
	System.out.println("d2==f ? "+(d2==f));				//f의 값과 d2의 값은 같다.
		
		
		
	}
}
