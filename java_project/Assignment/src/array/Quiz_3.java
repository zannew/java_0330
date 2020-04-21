package array;

public class Quiz_3 {

	//메인메서드
	public static void main(String[] args) {
		//2차원 배열 생성
		int[][] ar2 = new int[3][4];
		//메서드 호출 - 매개변수로 ar2 입력
		insertValue(ar2);
		changeRow(ar2);
	}//end of main
	
	//배열에 값을 담는 메서드 - 원본		
	static void insertValue(int[][] arr) {
		
		int k=1;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				
				arr[i][j]=k++;
				System.out.print("ar2["+(i)+"]["+j+"]="+arr[i][j]+"\t");
				
			}System.out.println();
		
		}System.out.println("-------------------------------------------");
	}
	//행을 바꾸는 메서드
	static void changeRow(int[][] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				//임시변수 선언 및 초기화
				int tmp=0;
				//첫번재 행을 임시변수에 담고 
				tmp=arr[i][j];
				//마지막 행을 첫번째 행으로 옮긴다.
				arr[i][j]=arr[arr.length-1][j];
				//임시변수에 담았던 첫번째행을 마지막행에 담아준다.
				arr[arr.length-1][j]=tmp;
				
				
				System.out.print("arr["+i+"]["+j+"]"+arr[i][j]+"\t");
			}System.out.println();
		}
		  
	}//end of changeRow

}//end of class
	
	
	
	

	
	
