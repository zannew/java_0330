package ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("news.txt");//해당파일의 텍스트를 읽어옴
		
		BufferedReader br = new BufferedReader(fr);
		
		String str = null;
		
		while(true) {
			
			str = br.readLine();	//readLine();	한 줄씩 읽어옴

			if(str==null) {
				break;
			}
			
			System.out.println(str);
		}
		
		br.close();
		
	}
}
