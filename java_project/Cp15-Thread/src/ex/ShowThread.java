package ex;

public class ShowThread extends Thread {

	String threadName;
	
	public ShowThread(String threadName) {
		this.threadName=threadName;
		
	}

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세여 "+threadName+"입니다.");
			System.out.println("쓰레드의 우선순위는 "+getPriority());
		}
	}

	
	
}
