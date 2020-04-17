package fruit;

public class FruitMain_2 {
	public static void main(String[] args) {
		
		// seller1 객체 생성
		FruitSeller seller1 = new FruitSeller(30, 0, 1000);
		// seller2 객체 생성
		FruitSeller seller2 = new FruitSeller(20, 0, 1500);
		// seller2 객체 생성
		FruitSeller seller3 = new FruitSeller();	
		// boyer 객체 생성
		FruitBuyer buyer = new FruitBuyer(10000, 0);
		
		
		// seller1에게 구매
		buyer.buyApple(seller1, 3000);
		
		// seller2에게 구매
		buyer.buyApple(seller2, 3000);
		
		// seller3에게 구매
		buyer.buyApple(seller3, 4000);
		
		
		System.out.println("판매자1의 현재 현황");
		seller1.showResult();
		System.out.println("판매자2의 현재 현황");
		seller2.showResult();
		System.out.println("판매자3의 현재 현황");
		seller3.showResult();
		
	}
}
