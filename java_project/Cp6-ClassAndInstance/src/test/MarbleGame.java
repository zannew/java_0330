package test;
//구슬치기와 딱지치기
//어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다.
//놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재한다.
//두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
//조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자. ( 하나의 클래스만 작성하자 )
//어린이 1의 보유자산  구슬 15개
//어린이 2의 보유자산  구슬 9개
//인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션 하자.
//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
//마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료.

public class MarbleGame {

	//구슬의 개수 - 인스턴스 변수 선언
	int numOfMarble;	
	
	//구슬의 개수 설정메서드 - 매개변수로 받는다.
	void setMarble(int num) {	
		numOfMarble=num;
	}
	
	//static메서드 - 구슬 주고받기 게임메서드(매개변수로 승자, 패자, 승자가 얻는 구슬 개수)
	//승자의 구슬개수는 증가, 패자의 구슬개수는 감소시켜서 저장
	static void playGame(MarbleGame winner, MarbleGame loser, int num) {
		winner.numOfMarble+=num;
		loser.numOfMarble-=num;
	}
	
	//static메서드 - 결과 보여주는 메서드(참여자를 매개변수로 받아 현재 구슬 개수를 보여줌)
	static void showResult(MarbleGame player) {
		System.out.println("현재 보유한 구슬 개수는? : "+player.numOfMarble);
	}
	
	//메인메서드
	public static void main(String[] args) {
		
		//참여자 1,2의 객체 생성
		MarbleGame player1 = new MarbleGame();
		MarbleGame player2 = new MarbleGame();
	
		//각 참여자의 구슬 개수 설정
		player1.setMarble(15);
		player2.setMarble(9);
		
		System.out.println("1차 게임에서 정원이는 겨울이의 구슬 2개를 획득한다");
		System.out.println("---------------------------------");
		//게임메서드 실행 (승자는 참여자1, 패자는 참여자2, 승자가 얻은 개수 2개)
		playGame(player1, player2,2);
		
		System.out.println("정원이");
		//참여자1의 현재 구슬 개수
		showResult(player1);
		System.out.println("겨울이");
		//참여자2의 현재 구슬 개수
		showResult(player2);
		System.out.println("정원이의 현재 구슬 개수: "+player1.numOfMarble+", 겨울이의 현재 구슬 개수: "+player2.numOfMarble);
		System.out.println("---------------------------------");
		
		System.out.println("2차 게임에서 겨울이는 정원이의 구슬 7개를 획득한다");
		System.out.println("---------------------------------");
		//게임메서드 실행 (승자는 참여자2, 패자는 참여자1, 승자가 얻은 개수 7개)
		playGame(player2, player1,7);
		
		System.out.println("정원이");
		//참여자1의 현재 구슬 개수
		showResult(player1);
		System.out.println("겨울이");
		//참여자2의 현재 구슬 개수
		showResult(player2);
		System.out.println("정원이의 현재 구슬 개수: "+player1.numOfMarble+", 겨울이의 현재 구슬 개수: "+player2.numOfMarble);
		
	}
	
	
}
