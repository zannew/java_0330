package ex;

public class CalcAddThread extends Thread {

	Calculator calc;
	
	public CalcAddThread(Calculator c){
		calc=c;		//생성자를 통해 참조변수 주입한다.
	}

	@Override
	public void run() {
		System.out.println(calc.add(1,2));
		System.out.println(calc.add(3,2));
	}
	
	
	
	
}
