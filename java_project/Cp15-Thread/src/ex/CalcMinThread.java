package ex;

public class CalcMinThread extends Thread{

	Calculator calc;
	
	public CalcMinThread(Calculator c){
		calc=c;
	}
	
	@Override
	public void run() {
		System.out.println(calc.min(2, 1));
		System.out.println(calc.min(4, 2));
	
		
	}
	
	
}
