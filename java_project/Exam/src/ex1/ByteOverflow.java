package ex1;

public class ByteOverflow {

	public static void main(String[] args) {
		
		byte b = 0;		//byte형 변수 b를 선언하고 0으로 초기화
		int i = 0;		//int형 변수 i를 선언하고 0으로 초기화
		
		for(int x=0; x<270; x++) {		//for문 - int형 변수 x를 선언하고 0으로 초기화,"x가 270보다 작을때"라는 조건, x는 1씩 증가
			System.out.print(b++);		//b는 0부터 출력. 실행 후에 b의 값은 1증가. byte는 127까지밖에 값을 담을 수 없어서 값이 초과하면 왜곡된다.
			System.out.print("\t");		//tab만큼 공간을 준다
			System.out.println(i++);	//i는 0부터 출력. 실행 후 i의 값은 1증가. 다시 10번 줄로 돌아가서 조건 참일때까지 반복실행.

		}
		
		
	}

}

