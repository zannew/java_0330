package scm;

public class Tv extends Product {

	Tv(int price) {
		super(price);
	}
	//오버라이딩(상위클래스가 Object클래스를 상속중이기 때문에 가능)
	//오버라이딩된 메서드는 만들어진 최근순으로 보여진다.
	public String toString() {
		return "Tv";
	}
	
}
