package op;

public class OperatorEx_7 {
	public static void main(String[] args) {
		
		boolean power = false;			//boolean타입 변수 power을 선언하고 false로 초기화
		System.out.println(power);		//power 출력 :false
		power = !power; 				//변수 power에 부정 값을 저장 : false → true
		 // power의 값이 false에서 true로 바뀐다.	
		System.out.println(power);		//power 출력 : true
		power = !power; 				//변수 power의 현재 값을 부정하는 값을 저장 : true → false
		 // power의 값이 true에서 false로 바뀐다.
		System.out.println(power);		//power 출력 : false

		
	}
}
