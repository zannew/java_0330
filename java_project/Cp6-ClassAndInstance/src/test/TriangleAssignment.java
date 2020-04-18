package test;

//밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 삼각형의 넓이를 계산해서 반환하는 메서드도 함께 정의하자.

public class TriangleAssignment {
	//클래스변수 선언 - 밑변(int), 높이(int), 계산결과(float)
	static int base_length;	
	static int height_length;
	static float result;
	
	//static메서드 - 밑변, 높이 입력메서드, 각각 매개변수로 받은 값을 클래스변수에 저장
	static void input_length(int num1, int num2){
		base_length=num1;
		height_length=num2;
		
	}
	//float타입으로 반환하는 static메서드 - 계산 결과를 리턴
	static float calc_area() {
		result=base_length*height_length/2f;
		
		return result;
	}
	//메인메서드
	public static void main(String[] args) {
		//밑변, 높이 입력메서드, 매개변수로 받음
		input_length(10,4);
		//밑변, 높이, 계산결과 출력
		System.out.println("삼각형의 밑변: "+base_length+", 삼각형의 높이: "+height_length);
		System.out.println("삼각형의 넓이는: "+calc_area());
	}
	
	
}
