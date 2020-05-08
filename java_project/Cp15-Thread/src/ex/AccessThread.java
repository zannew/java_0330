package ex;

public class AccessThread extends Thread {

	TwoNum twoNum;
	
	//지역변수 TwoNum타입으로 받아 초기화
	AccessThread(TwoNum twoNum){
		this.twoNum=twoNum;
	}

	@Override
	public void run() {
		
		twoNum.addOneNum1();
		twoNum.addTwoNum1();
		twoNum.addOneNum2();
		twoNum.addTwoNum2();
	}
	
	
	
}
