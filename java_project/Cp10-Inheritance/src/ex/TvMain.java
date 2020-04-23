package ex;

public class TvMain {
	public static void main(String[] args) {
		
//		System.out.println(tv3 instanceof IpTv);

		Tv tv1 = new Tv();
		
//		IpTv iTv = (IpTv)tv1;
		
		
		
		
		
		CaptionTv cTv1 = new CaptionTv();
		
		Tv t = /*(Tv)*/cTv1;	//자동형변환(하위클래스 → 상위클래스)
		
		
		
		
		
		
		Tv tv2 = new CaptionTv();
		
//		Iptv iTv3 = (IpTv)tv2;		
		
		
		
		
		CaptionTv cTv2 = (CaptionTv)tv2;	//형변환(Tv→CaptionTv)
		cTv2.caption();
//		((CaptionTv)tv2).caption();			//형변환(Tv→CaptionTv)
		
		
//		System.out.println(tv2.power);
//		tv2.power();
//		System.out.println(tv2.power);
//		
//		tv2.display();//오버라이딩을 통해 상위클래스에 없던 하위클래스 멤버(변수,메서드)를 사용 가능
		
		
		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
		
//		tv3.display();
//		tv4.display();
		
		Tv[] tvs = new Tv[4];
		
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();
		
		for(int i=0;i<tvs.length;i++) {
			tvs[i].display();
			
		}
		
		
	}
}
