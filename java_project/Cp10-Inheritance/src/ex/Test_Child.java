package ex;

public class Test_Child extends Test_Parent {

	int num2;
	
	Test_Child(int number, int number2) {
		//조상클래스의 생성자(매개변수)
		super(number);
		//인스턴스 변수 num2에 입력받은 매개변수 저장
		num2=number2;
		//
		add(num+num2);
	}
	
	
	
}
