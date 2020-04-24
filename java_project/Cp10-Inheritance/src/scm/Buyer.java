package scm;

public class Buyer {

	//변수 선언만
	int money;			//구매자의 보유금액
	int bonusPoint;		//구매자의 보유포인트
	
	//생성자 초기화
	Buyer(){
		this.money=1000;
		this.bonusPoint=0;
	}
	//buy메서드
	//매개변수 Product타입 p는 전달받을 참조변수
	void buy(Product p) {
		
		//구매 상품의 금액과 나의 보유금액
		if(money<p.price) {
			System.out.println("잔액이 부족해서 구매할 수 없습니다.");
			return;	//buy메서드 종료
		}
		
		//구매 처리
		this.money -= p.price;	//보유한 금액에서 제품의 금액을 차감
		this.bonusPoint += p.bonusPoint;	//보유한 포인트에 제품의 포인트를 추가
		System.out.println(p+"를 구매하셨습니다.");
	}
	
	
}
