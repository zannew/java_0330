package test;

//밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 삼각형의 넓이를 계산해서 반환하는 메서드도 함께 정의하자.

public class TriangleAssignment2 {

	//인스턴스 변수 선언
	int base_length;
	int height_length;
	float result;
	
	//void타입(노리턴) 밑변, 높이 입력메서드
	void input_length(int num1, int num2){
		base_length=num1;
		height_length=num2;
		
	}
	//float타입 계산 반환메서드(float으로 리턴)
	float calc_area() {
		result=base_length*height_length/2f;
		
		return result;
	}
	//void타입 결과 출력메서드
	void showResult(){
		//TriangleAssignment2 객체생성
		TriangleAssignment2 t = new TriangleAssignment2();
		//참조변수로 입력메서드 호출, 매개변수 값 입력
		t.input_length(10,4);
		//출력
		System.out.println("삼각형의 밑변: "+t.base_length+", 삼각형의 높이: "+t.height_length);
		System.out.println("삼각형의 넓이는: "+t.calc_area());
	}
	
	
}
