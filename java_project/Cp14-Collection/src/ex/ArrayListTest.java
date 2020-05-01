package ex;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//List<E> → ArrayList<E> (상속받고 있다)
		//List<E> : 저장 순서를 가진다. 데이터의 중복저장 가능
		//순서 존재 → 일괄처리 가능(반복적인 동일한 작업을 빠르게 처리)
		
		//ArrayList 인스턴스 생성 : Integer타입의 객체만 저장
		//<type> : 다른타입의 유입을 막아준다.
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//인스턴스 생성 시 자료형 생략 ok
		//ArrayList<Integer> list = new ArrayList</*타입생략*/>();//생략해서 사용가능
		//다형성
		//List<Integer> list = new ArrayList<>();
		
		//List<E>(인터페이스)에 정의된 추상메서드 →
		//add(E) :인스턴스의 저장
		//remove(index) :해당 index의 요소를 삭제
		//size():List요소의 개수를 반환
		//get(index):해당 index의 요소를 반환
		
		//데이터의 저장(입력순으로) : 저장의 순서를 가지고 있다.
		//list.add(30);	→ Auto Boxing(wrapper class) : 내부적 처리에서 객체로 저장
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		
		//데이터의 참조
		System.out.println("저장된 데이터를 확인합니다.");
		//반복문을 통해서 일괄 참조 가능
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-----------------------------");
		
		//데이터의 삭제
		list.remove(1);
		System.out.println("데이터 삭제 후 데이터를 확인합니다.");
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	
	
}
