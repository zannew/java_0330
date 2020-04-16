package tv;

public class TvMain {

	public static void main(String[] args) {
		
		//Tv인스턴스 생성
		Tv tv = new Tv();
		
		//Tv클래스의 속성(변수) 사용
		System.out.println("-------------");
		System.out.println("TV의 속성값, 인스턴스 생성");
		System.out.println("Tv의 color : "+tv.color);
		System.out.println("Tv의 채널 :"+tv.channel);
	
		tv.channel = 11;	
		System.out.println("Tv의 채널"+tv.channel);

		//Tv클래스의 기능(메서드) 사용
		tv.channelUp();
		System.out.println("Tv의 채널"+tv.channel);
				
		tv.channelChange(100);
		System.out.println("Tv의 채널"+tv.channel);
		
		tv.channelDown();
		System.out.println("Tv의 채널"+tv.channel);

	
	
	}
	
}
