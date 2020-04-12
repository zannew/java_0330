package op;

public class OperatorEx_2 {
	public static void main(String[] args) {
		
		int i=5;				//int형 변수 i를 선언하고 5로 초기화
		int j=0;				//int형 변수 j를 선언하고 0으로 초기화
		
		j = i++;				//j에 i에 현재 저장된 값을 저장
		
		 System.out.println("j=i++; 실행 후, i=" + i +", j="+ j); //현재 j에는 i의 기존 값(5)이 저장된 상태, i의 값은 1 증가한 상태(6)
		i=5; 					// 결과를 비교하기 위해, i와 j의 값을 다시 5와 0으로 변경
		j=0;
		j = ++i;				//i를 먼저 1 증가시키고 j에 증가한 i의 값을 저장
		 System.out.println("j=++i; 실행 후, i=" + i +", j="+ j);	//현재 j에는 증가한 i의 값(6)이 저장된 상태, i의 값은 1 증가한 상태(6)
	}
}
