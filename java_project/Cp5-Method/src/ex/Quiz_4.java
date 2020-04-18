package ex;

//	전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 
//	소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 
//	이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.
public class Quiz_4 {
	//boolean반환 타입 메서드 - 입력받은 매개변수가 소수인지 판별
	boolean prime_number(int num){
	//반환하는 변수 초기값 true로 저장
	 
		//1은 소수가 아니므로 걸러내기
		if(num==1) {
			return false;
		//1을 제외한 수 중에 소수를 판별한다	
		}else {
			//num-1보다 같거나 작은 상태 동안 증가한 i값으로 나눈 나머지가 0이면 false리턴
			 for(int i=2; i<=num-1;i++)
				 if(num%i==0) {
					 return false;
				 }
			 }
			return true;
		}	
	//메인메서드
	public static void main(String[] args) {
		//클래스 객체 생성
		Quiz_4 prime = new Quiz_4();
		
		 //1부터 100까지 메서드 호출로 확인하고 값이 true로 반환된 경우만 출력
		for(int i=1; i<=100; i++) {
			if(prime.prime_number(i)==true) {
				System.out.println(i+"는 소수");
			}
		}
	}
}
