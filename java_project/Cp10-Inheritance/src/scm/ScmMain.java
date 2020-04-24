package scm;

public class ScmMain {
	public static void main(String[] args) {
		
		//상속관계에서 다형성
		//상위클래스 타입의 참조변수 = 하위클래스의 인스턴스
		Product p = new Tv(100);
//		System.out.println(p);

		Tv tv = new Tv(10);
		Computer com = new Computer(20);
		Audio aud = new Audio(30);
		
		
		//다형성(상위클래스 타입이기때문에 객체는 명시적형변환 생략됨)
		Product p1 = tv;
		Product p2 = com;
		Product p3 = aud;
		int sum = tv.price + com.price + aud.price;   //전체금액 구하기
		
		//상위클래스 타입의 배열 생성
		Product[] products = new Product[3];
		products[0]=new Tv(100);
		products[1]=new Computer(300);
		products[2]=new Audio(200);
		
		int sumOfPrice=0;
		int sumOfPoint=0;
		
		for(int i=0;i<products.length;i++) {
			System.out.println(products[i]);
			sumOfPrice += products[i].price;
			sumOfPoint += products[i].bonusPoint;
		}
		System.out.println("전체 제품의 가격의 합은 : " + sumOfPrice);
		System.out.println("전체 제품의 포인트 합은 : " + sumOfPoint);
		
		
		//구매자가 제품을 구매하는 시뮬레이션
		//구매자 생성
		Buyer buyer = new Buyer();
		
		//제품(객체) 생성
		Tv product1 = new Tv(300);
		Computer product2 = new Computer(500);
		Audio product3 = new Audio(300);
		
		//Tv구매
		buyer.buy(product1);
		//Computer구매
		buyer.buy(product2);
		//Audio구매
		buyer.buy(p3);
		
		System.out.println("현재 보유금액: "+buyer.money);
		System.out.println("현재 보유포인트: "+buyer.bonusPoint);
		
		
	}
}
