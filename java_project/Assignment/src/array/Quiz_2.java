package array;

public class Quiz_2 {

	public static void main(String[] args) {
	
		
		int[] ar=new int [5];
		int [][] ar2=new int[5][3];
		
		addOneDArr(ar2,5);
		
		for(int i=0;i<ar2.length;i++) {
			for(int j=0;j<ar2[i].length;j++) {
				System.out.print("ar2["+i+"]["+j+"]"+":"+ar2[i][j]+"\t");
			}System.out.println();
		}
		
	}	
		
	public static void addOneDArr(int[][] arr, int add) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]+=add;
			}
			
		}

	
	}	
	
}
