package tv;

public class Tv {
// Tv의 속성(변수) → 멤버변수 혹은 인스턴스변수(위치중요!!)
	
	String color;	// Tv의 색상 값
	boolean power;	// Tv의 전원 상태 값
	int channel;	// Tv의 채널 값
	
	// Tv의 기능 → 메서드, 클래스의 멤버
	// Tv의 전원 온오프 기능
	void power() {
		power = !power;
				
	}
	//채널을 올리는 기능
	void channelUp() {
		channel = channel+1;
//		channel +=1;
//		channel++;
//		++channel;
	}
	//채널을 내리는 기능
	void channelDown() {
		--channel;
	}
	//채널값을 변경하는 : 채널값을 받아서 변경
	void channelChange(int ch) {
		channel = ch;
	}
	
}
