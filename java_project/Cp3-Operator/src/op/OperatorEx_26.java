package op;

public class OperatorEx_26 {
	public static void main(String[] args) {
		
		// 절대값 구하기
		
		int x = 10;						//int타입 x에 10저장
		int y = -10;					//int타입 y에 -10저장
		int absX = (x >= 0) ? x : -x;	//x가 0보다 크거나 같다면 x의 값 저장, 아니면 x*-1 저장
		int absY = (y >= 0) ? y : -y;	//y가 0보다 크거나 같다면 y의 값 저장, 아니면 y*-1 저장
		
		
		System.out.println("x= 10일 때, x의 절대값은 "+absX);		//저장된 값 출력
		System.out.println("y=-10일 때, y의 절대값은 "+absY);		
		
		
	}
}
