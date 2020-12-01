package ex;


public class ThreadMain8 {

	public static void main(String[] args) {
		
	// TwoNum 객체를 한번만 생성해서 공유  2020/10/15
	TwoNum tn = new TwoNum();
	
	AccessThread at1 = new AccessThread(tn);
	AccessThread at2 = new AccessThread(tn);
	
	at1.start();
	at2.start();
	
	
	try {
		// at1의 실행이 끝날 때까지 기다린다.
		at1.join();
		// at2의 실행이 끝날 때까지 기다린다.
		at2.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	// 그리고 마지막으로 출력메서드 실행
	tn.showNums();
	
	}
}
