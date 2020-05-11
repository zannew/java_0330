package ex;

import java.io.Serializable;

public class Circle implements Serializable {
//구현할 내용 없음
	int xPos;
	int yPos;
	double rad;
	
	
	
	public Circle(int xPos, int yPos, double rad) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
	}
	
	void showCircleInfo() {
		System.out.println("xPos : "+xPos+", yPos : "+yPos);
		System.out.println("rad : "+rad);
	}

	
	
	
	
	
	
}
