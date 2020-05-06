package ex;

public class AdderThread extends Sum implements Runnable {

	int start, end;
	
	//int num;
	//addNum();, getNum();	→ 포함하고 있다
	
	public AdderThread(int start, int end) {
		this.start=start;
		this.end=end;
	}
	
	
	@Override
	public void run() {
		for(int i=this.start; i<=this.end; i++) {
			addNum(i);
		}
		
	}

	

}
