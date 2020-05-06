package ex;

public class ThreadMain2 {
	public static void main(String[] args) {
		
		//인터페이스 Runnable을 구현하는 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		//쓰레드 인스턴스 생성 - Runnable을 구현 중이기 떄문에 상속받을 필요없다. 
		//인스턴스 생성했다고 실행 흐름이 만들어지지는 않는다.
		Thread thread1 = new Thread(at1);
		Thread thread2 = new Thread(at2);
		
		//실행의 흐름 생성
		thread1.start();		//run()호출 프로그램 실행
		thread2.start();
		
		try {
			thread1.join();		//()안의 시간동안 thread1만 실행시킨다. arguments가 없다면? thread1이 끝날 때까지 thread2, main을 정지시킨다.
			thread2.join();		//main이 정지된 상태
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100까지의 합 : "+(at1.getNum()+at2.getNum()));
		
	}
}
