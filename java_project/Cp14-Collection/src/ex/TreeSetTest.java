package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>(); 
		
		//(입력순서가 아닌)정렬 순
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);
		
		
		System.out.println("요소의 개수 : "+treeSet.size());
		
		
//		Iterator<Integer> itr = new Iterator<Integer>() ; 
//		itr = treeSet.iterator(){
			
		Iterator<Integer> itr = treeSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		}
	}
//}
