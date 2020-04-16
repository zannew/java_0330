package ex;

public class AccessWayMain {
	public static void main(String[] args) {
		
	System.out.println(AccessWay.num);	//static변수 num 사용
	AccessWay.num++;
	System.out.println(AccessWay.num);
	
	
	AccessWay ac = new AccessWay();		//인스턴스변수 num2 사용
	System.out.println(ac.num2);
	System.out.println(ac.num);			//static변수+인스턴스변수(ok)
	
	}
}
