package ex;

public class Test_Parent {

	private int num;
	
	public Test_Parent(int number) {

		num=number;
		
	}
	void add(int number) {
		System.out.println("상위클래스입니다. :"+(number+number));
		
	}
	
}
