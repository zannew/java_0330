package array;

import java.util.Scanner;

public class Quiz_1 {
	
	// 최소값 반환
	public static int miniValue(int[] arr) {
		//첫번째 자리 값을 최소값으로 임의지정
		int min=arr[0];
		
		for(int i=0; i<arr.length; i++) {
			//min의 값이 arr[i]보다 크면 min에 arr[i]저장
			if(min>arr[i]) {
				min=arr[i];
			}
			}return min;//min값 반환
		}
	
	// 최대값 반환
	public static int maxValue(int[] arr) {
		//첫번째 자리 값을 최대값으로 임의지정
		int max=arr[0];
		
		for(int i=0; i<arr.length; i++) {
			//max의 값이 arr[i]보다 작으면 max에 arr[i]저장
			if(max<arr[i]) {
				max=arr[i];
			}
			}return max;//max값 반환
	} 
	
	//메인메서드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//5개짜리 배열
		int[] ar = new int[5];
		
		//Scanner클래스로 입력받아서 값 채우기
		for(int i=0; i<ar.length;i++) {
			System.out.println("배열에 담을 수를 입력 : ");
			ar[i]=sc.nextInt();
		}
		
		//최소값,최대값 메서드에 매개변수 배열ar로 넣기
		System.out.println("최소값은: "+miniValue(ar));
		System.out.println("최대값은: "+maxValue(ar));
	
	
	
	
	
		
		
	
	}
	
}
