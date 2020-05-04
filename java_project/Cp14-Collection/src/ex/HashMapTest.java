package ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//HashMap<Integer, String> map = new HashMap<>();
		//Map<Integer, String> map = new HashMap<Integer, String>();
		
		//입력 방법
		map.put(1, "일번");
		map.put(2, "이번");
		map.put(3, "삼번");
		//key값은 정렬과 상관없다.
		map.put(8, "팔번");
		
		//참조 방법
		System.out.println("1번 학생의 이름은 : "+map.get(1));
		System.out.println("8번 학생의 이름은 : "+map.get(8));
		
		//삭제 방법
		map.remove(8);
		
		System.out.println("8번 학생 삭제 완료");
		System.out.println("8번 학생의 이름은 : "+map.get(8));
		
		System.out.println(map.get(2));
		System.out.println("key=2인 데이터 중복 입력시");
		
		//key값은 중복 불가능
		map.put(1, "One");
		map.put(2, "Two");
		System.out.println(map.get(2));
		System.out.println(map.get(1));
		
		
		
		
		
		
	}
}
