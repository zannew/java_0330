package array;

public class Quiz_2 {
	//메인메서드
	public static void main(String[] args) {
	
		//2차원 배열 선언,생성
		int [][] ar2=new int[5][3];
		//메서드 호출
		addOneDArr(ar2,5);
		//출력해서 확인하기
		for(int i=0;i<ar2.length;i++) {
			for(int j=0;j<ar2[i].length;j++) {
				System.out.print("ar2["+i+"]["+j+"]"+":"+ar2[i][j]+"\t");
			}System.out.println();
		}
	}	
	//저장된 모든 값 증가시키는 메서드	
	public static void addOneDArr(int[][] arr, int add) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]+=add;
			}
		}
	
	}	
}
