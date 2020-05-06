package ex;

public class AddThread extends Thread {
	//인스턴스 하나를 전달받아 변수와 메서드를 사용하는 클래스

	Sum sumInst;
	long start;
	long end;
	
	AddThread(Sum sum, long s, long e){
		this.sumInst=sum;
		this.start=s;
		this.end=e;
	}
	
	public void run() {
		for(long i=start; i<=end; i++) {
			sumInst.addNum(i);
		}
	}
}
