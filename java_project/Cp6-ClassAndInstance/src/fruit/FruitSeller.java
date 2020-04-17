package fruit;


/*작성자 : 장윤원
수정일 : 2020.04.17
수정내용 : 생성자를 통한 변수 초기화, 현재 데이터 출력메서드 생성(showResult())
*/
public class FruitSeller {

	//속성 → 변수
	//	사과의 개수
	//	수입
	//	사과의 가격
	//	멤버 변수 혹은 인스턴스 변수
//	int numOfApple = 20;		//사과의 개수
//	int myMoney = 0;			//수입
//	final int price = 1000;			//사과의 가격
	
	// 수정 : 변수의 명시적 초기화 변경
	int numOfApple;		//사과의 개수
	int myMoney;			//수입
	final int APPLE_PRICE;			//사과의 가격
	int restOfApple;
	
	//생성자(내용이 있는, default아님)
	FruitSeller(){
//		numOfApple=20;
//		myMoney=0;
//		APPLE_PRICE=1000;
		
		this(20, 0, 1000);
	}
	
	FruitSeller(int price){
		this(20,0,price);
	}
	
	
	//생성자
	public FruitSeller(
						int numOfApple, int myMoney, int APPLE_PRICE) {
		this.numOfApple = numOfApple;
		this.myMoney = myMoney;
		this.APPLE_PRICE = APPLE_PRICE;
	}

//	FruitSeller(int num){		//※ num과 price 둘다 정수형이라 식별이 어렵다.
//		this(num,0,1000);
//	}
	
	
	//생성자(매개변수 있는)
//	FruitSeller(int numOfApple, int myMoney, int price){
//		this.numOfApple = numOfApple;
//		this.myMoney = myMoney;
//		APPLE_PRICE = price;
//	}
	
	
	//판매 기능 → 메서드
	//	1. 돈을 받는다	→ 매개변수 int money
	//	2. 받은 돈의 사과의 개수를 구한다	
	// 	3. 나의 사과 개수에서 반환해야하는 사과의 개수를 빼준다
	//	4. 받은 금액은 나의 수입으로 더해준다
	//	5. 사과의 개수를 반환한다 
	//	→ 반환 데이터 int return 사과의 개수
	int saleApple(int money) {
		int num = money/APPLE_PRICE;
//		numOfApple = numOfApple = num;
		numOfApple -= num;
		myMoney+= money;
		//myMoney = myMoney+money
		return num;
		
		
	}
	// 생성 : 20200417
	void showResult() {
		System.out.println("현재 보유금액 : "+myMoney+"이고, 현재 보유한 사과 개수는 "+numOfApple+"개 입니다.");
	}
	
	
	
	
	
	
	
	
}
