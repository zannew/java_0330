package ex;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> tMap = new TreeMap<>();
		
		tMap.put(1, "Data1");
		tMap.put(3, "Data3");
		tMap.put(5, "Data5");
		tMap.put(4, "Data4");
		tMap.put(2, "Data2");
		
		//Map에서 Collection<E>로
		//Map을 Set으로
		NavigableSet<Integer> navi = tMap.navigableKeySet();
		
		Iterator<Integer> itr = navi.iterator();
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		itr=navi.descendingIterator();
		
		System.out.println("내림차순 정렬");
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		itr=navi.iterator();
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		
		
	}
}
