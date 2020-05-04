package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest2 {

	public static void main(String[] args) {

		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();

		//참조변수 선언시에만 타입 넣어도  ok
		//		HashSet<String> set = new HashSet<>();
		//상위클래스 import해주면 다형성으로 사용 ok 
		//		Set<String> set = new HashSet<String>();

		//equals로 문자열 비교
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		//	set.add("First");/*저장 안됨*/

		System.out.println("저장된 데이터의 개수 : "+set.size());

		//collection클래스의 하위클래스는 모두 가능 - 줄세우기 
		Iterator<SimpleNumber> itr = set.iterator();

		//출력은 순서 x
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}


	}
}

class SimpleNumber{

	int num;

	public SimpleNumber(int num) {
		this.num=num;

	}

	public String toString() {
		//int타입 값 → 문자열로 반환
		return String.valueOf(num);
	}
	
	//HashSet의 동등비교 과정 #14-30
	//1. hash코드를 비교 → 같은 (해시코드)값을 가진 객체를 기반으로 비교 
	//2. equals메서드로 비교
	@Override
	public int hashCode() {
		return num%3;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		//num의 값을 비교
		if(obj instanceof SimpleNumber) {
			//형변환이 핵심
			SimpleNumber sm = (SimpleNumber)obj;
			result = this.num==sm.num;
		}


		return result;
	}	
}

	
