package ex;

public class Increment {

	int num=0;
	
	void increment() {
		
		synchronized(this) {
			num++;
		}
	}
	
	//getter
	int getNum() {
		return num;
	}
	
	
}
