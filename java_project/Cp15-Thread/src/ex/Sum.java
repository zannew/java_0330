package ex;

public class Sum {

	long num;
	
	Sum(){
		num=0;
		
	}
	
	void addNum(long n) {
		this.num+=n;	//num=num+n;
	}
	
	//getter메서드
	long getNum() {
		return this.num;
	}
	
}
