package scm;

public class Buyer {

	//변수 선언만
	int money;			//구매자의 보유금액
	int bonusPoint;		//구매자의 보유포인트
	
	Product[] item;		//구매시 담을 제품 배열
	int numOfProduct;	//구매 제품 개수
	
	
	//생성자 초기화
	Buyer(){
		this.money=1000;			//보유금액 초기화
		this.bonusPoint=0;			//보유포인트 초기화
		this.item= new Product[10];	//배열 초기화
		this.numOfProduct=0;		//구매 제품 개수 초기화
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
		
		item[numOfProduct++]=p;	//여기서 바로 증감연산
		//numOfProduct++;
		
		System.out.println(p+"를 구매하셨습니다.");
	}
	//현재 구매내역 모두 확인 - 배열참조
	void summary() {
		
		int sum=0;			//구매 제품의 총액, lv이므로 여기서 초기화
		int points=0;		//구매한 제품들의 포인트 총합
		
		String itemList="";	//구매 제품의 이름 목록
		
		//구매한 제품의 개수만큼 반복
		for(int i=0;i<numOfProduct;i++) {
//			itemList = itemList + (item[i]+",");
			itemList += item[i]+",";	//구매한 제품 문자열 연결(증감연산)
			
			sum+=item[i].price;			//구매한 제품 가격 총합
			points+=item[i].bonusPoint;	//구매한 제품 포인트 총합
			
		}
		System.out.println("구매 목록==============");
		System.out.println("구매하신 제품은 ");
		System.out.println(itemList+"입니다.");
		System.out.println("구매하신 제품들의 총 금액: "+sum+"원");
		System.out.println("구매하신 제품들의 총 적립포인트:"+points+"점");
	}
	
	
	
}
