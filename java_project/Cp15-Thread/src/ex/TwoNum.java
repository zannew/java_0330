package ex;

public class TwoNum {

	//num1처리시 num2까지 block당하지 않게
	int num1=0;
	int num2=0;
	int num3=0;
	
	void addOneNum1() {
		synchronized(this) {
			num1 +=1;
		}
	}
	
	void addTwoNum1() {
		synchronized(this) {
			num1 +=2;
		}
	}
	
	void addOneNum2() {
		synchronized(key1) {
			num2 +=1;
		}
	}
	
	void addTwoNum2() {
		synchronized(key1) {
			num2 +=2;
		}
	}
	//다른 쓰레드가 들어와서 key1을 받아 개별적으로 메서드를 실행할 수 있다.
	Object key1 = new Object();
	String key2 = new String();	//ok : Object타입이기때문에 어떤 클래스가 와도 ok
	
	void showNums() {
		System.out.println("num1의 값은 : "+ num1);
		System.out.println("num2의 값은 : "+ num2);
	}
	
	
}
