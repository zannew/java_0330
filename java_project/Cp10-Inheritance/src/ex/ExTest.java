package ex;

public class ExTest {

	int x=10;
	
public static void main(String[] args) {

	
	child c = new child();
	c.print();
	
	
}
	
}


class child extends ExTest{
	
	int x=20;
	
	void print() {
		System.out.println("x="+ x);
		System.out.println("this.x="+ this.x);
		System.out.println("super.x="+ super.x);
		System.out.println("this.x+super.x="+ (this.x+super.x));
	}
	
}