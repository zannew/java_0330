package ex;

public class BaseEnSpeaker extends Speaker {

	private int baseRate;
	
	void setBaseRate(int base) {
		
		this.baseRate=base;
		
	}

	@Override
	void showCurrentState() {
		super.showCurrentState();
		System.out.println("베이스의 크기: "+baseRate);
	}

	@Override
	public String toString() {
			
		return "베이스 스피커";
	}
	
	
}
