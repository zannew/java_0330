package algorithm_1;

public class Quiz_5 {
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		int result;
		
		a = 17;
		b = 17;
		c = 3;
		result = a > b ? a : b;
		
		
		if (a == b) {
			System.out.println("숫자를 각각 다르게 입력하세요");
		}else if (result>c){
			System.out.println("가장 큰 수 : "+ result);
		}else {
		System.out.println("가장 큰 수 : "+ c);
		}
		
		}
	}

