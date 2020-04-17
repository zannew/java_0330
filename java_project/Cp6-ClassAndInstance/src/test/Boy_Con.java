package test;

public class Boy_Con {

	//구슬의 개수 
	int numOfMarble;
	
	Boy_Con(int num){
		numOfMarble=num;
	}
	
	
	//구슬의 개수 설정메서드
	void setMarble(int num) {			
		numOfMarble=num;
	}
	//(승자가 누구든)이긴 결과 메서드
	void gameWin(Boy_Con boy, int num) {	
		numOfMarble+=num;
		boy.numOfMarble-=num;
	}
	//현재 구슬 개수 보기 메서드
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 "+numOfMarble+"개 입니다.");
	}
	public static void main(String[] args) {
		
		//철수 객체생성
		Boy_Con boy1 = new Boy_Con(15);
		//영희 객체생성
		Boy_Con boy2 = new Boy_Con(9);
		
		//구슬의 개수 설정메서드 - 철수는 구슬 15개, 영희는 구슬 9개 보유
		boy1.setMarble(15);
		boy2.setMarble(9);

		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"개, 영희는 구슬을 "+boy2.numOfMarble+"개 보유");
		System.out.println("-------------------------------------------------------------------");
		
		//1차 게임에서 어린이1은 어린이2의 구슬 2개를 획득한다.
		System.out.println("1차 게임에서 철수는 영희의 구슬 2개를 획득한다");
		//boy1.gameWin(상대방, 가져올 구슬 개수);
		boy1.gameWin(boy2, 2);
		
		System.out.println("철수");
		boy1.showData();
		System.out.println("영희");
		boy2.showData();
		
		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"개, 영희는 구슬을 "+boy2.numOfMarble+"개 보유");
		System.out.println("-------------------------------------------------------------------");
		
		//2차 게임에서 어린이2는 어린이1의 구슬 7개를 획득한다.
		System.out.println("2차 게임에서 영희는 철수의 구슬 7개를 획득한다");
		boy2.gameWin(boy1, 7);
		
		System.out.println("철수");
		boy1.showData();
		System.out.println("영희");
		boy2.showData();
		
		
		
		
	}
	
	
}
