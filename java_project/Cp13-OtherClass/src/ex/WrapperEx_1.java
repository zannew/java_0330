package ex;

public class WrapperEx_1 {

	public static void main(String[] args) {
		//import 따로 하지 않는다.
		Integer i1 = new Integer(100);
		Integer i2 = new Integer("100");
		
		System.out.println("i1 == i2 : "+(i1==i2));
		System.out.println("i1.equals(i2) : "+i1.equals(i2));
		
		System.out.println("i1.toString() : "+ i1.toString());
		System.out.println("i2.toString() : "+ i2.toString());
		
		//static final test
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(Integer.SIZE);
	}
	
	
}
