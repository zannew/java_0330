package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {
	public static void main(String[] args) {
		
		// Date : java.util.Date
		// 날짜와 시간 정보를 하나로 표현
		Date today = new Date();
		//toString은 Object클래스 내부의 메서드
		System.out.println(today);//today.toString()
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.a HH:mm;SS");
		
		System.out.println(dateFormat.format(today));
		
		
		
	}
}
