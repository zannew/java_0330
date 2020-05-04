package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<String>();

		//참조변수 선언시에만 타입 넣어도  ok
		//		HashSet<String> set = new HashSet<>();
		//상위클래스 import해주면 다형성으로 사용 ok 
		//		Set<String> set = new HashSet<String>();

		//equals로 문자열 비교
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");/*저장 안됨*/

		System.out.println("저장된 데이터의 개수 : "+set.size());

		//collection클래스의 하위클래스는 모두 가능 - 줄세우기 
		Iterator<String> itr = set.iterator();

		//출력은 순서 x
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}






	}

}
