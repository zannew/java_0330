package test;

public class Triangle {
//	밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//	끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 삼각형의 넓이를 계산해서 
//	반환하는 메서드도 함께 정의하자.
//	변수 : 밑변, 높이
//	메서드 : 밑변,높이 변경메서드 & 삼각형 넓이 반환메서드(밑변*높이/2)
	
	//변수 : 밑변, 높이
	int width;	//밑변의 데이터(변경메서드있어서 초기화 x)
	int height; //높이의 데이터(변경메서드있어서 초기화 x)
	
	//밑변과 높이 데이터 변경메서드
	void setData(int w, int h) {
		width=w;
		height=h;
	}//매개변수 w와 h는 메서드 끝나면 소멸, width와 height는 남아있다.
	
	//삼각형의 넓이를 구하는 반환메서드
	float area() {
		float result=width*height/2f;	//접미사 주의
		return result;
	}
	
	public static void main(String[] args) {
		
		//삼각형 객체생성
		Triangle t = new Triangle();
		
		//데이터 설정
		t.setData(10, 4);
		
		System.out.println("삼각형의 밑변: "+t.width+", 높이: "+t.height);
		
		
		
		//넓이 구하는 메서드
		System.out.println("삼각형의 넓이는: "+t.area()+"입니다.");
		
	}
	
	
}
