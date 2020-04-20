package ex;

public class ArrayLotto {
	public static void main(String[] args) {
		
		//정수 45개를 저장 할 수 있는 배열 생성
		int[] ball = new int[45];
		
		//각 배열의 요소에 1~45 숫자를 초기화
		for(int i=0; i<ball.length; i++) {
			ball[i]=i+1;
		}
		
//		for(int i=0; i<ball.length; i++) {
//			System.out.println(ball[i]);
//		}
		
		
		System.out.println("-------------------------");
		//배열의 요소 값의 변경을 위한 임시변수
		int tmp;
		//랜덤한 인덱스값 : 1~44
		int j=1;
		
		for(int i=0; i<10000;i++) {
			j=(int)(Math.random()*44)+1;

			tmp=ball[0];
			ball[0]=ball[j];
			ball[j]=tmp;
		
		}
		
		for(int i=0; i<6; i++) {
			System.out.println(ball[i]);
		}
		
		
	}
}
