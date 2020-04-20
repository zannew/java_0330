package ex;

public class AccessArray {
	public static void main(String[] args) {
		
	//int타입의 정수 데이터 3개를 저장할 수 잇는 배열을 생성
	//배열의 이름 arr로 선언
	
	//배열의 선언 : arr은 지역변수
	int[] arr;			
	arr = new int[3];	//배열 인스턴스 생성 : 각 요소의 저장공간 생성
	
	//배열 요소에 참조
	arr[0]=1;
	arr[1]=2;
	arr[2]=3;

	int sum=0;
	
	for(int i=0; i<arr.length;i++)
		sum+=arr[i];
		
	System.out.println("각 숫자의 합은 : "+sum);
	
	}
		
}
