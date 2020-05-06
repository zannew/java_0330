package ex;

public class CountThread extends Thread{

	@Override
	public void run() {
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			
			try {
				sleep(1000);		//1000분의 1000초 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		System.out.println("10초동안 입력이 없어 프로그램이 종료됩니다.");
		System.exit(0);
	}

	
	
	
}
