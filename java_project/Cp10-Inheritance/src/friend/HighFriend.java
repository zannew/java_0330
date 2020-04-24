package friend;

public class HighFriend extends Friend{

	String work;		//친구의 직업
	
	public HighFriend(String name, String phoneNum, String addr, String work) {
		super(name, phoneNum, addr);
		this.work=work;
	}

	@Override
	void showData() {
		showBasicInfo();
		System.out.println("직업: "+this.work);
	
	}

	
	
	
}
