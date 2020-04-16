package tv;

public class TvMain_2 {

	public static void main(String[] args) {

		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		
		System.out.println(tv1==tv2);		

		System.out.println("---------------------");
		System.out.println("tv1의 channel : "+tv1.channel);
		System.out.println("tv2의 channel : "+tv2.channel);

		System.out.println("---------------------");
		tv1.channel = 10;
		System.out.println("tv1의 channel을 10으로 변경");
		System.out.println("tv1의 channel : "+tv1.channel);
		System.out.println("tv2의 channel : "+tv2.channel);
		
		
	}

}
