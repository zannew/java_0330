package ex;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
		
		//PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
		//다형성 적용
		PersonalNumber storage = new PersonalNumberStorageImpl(100);
		
		
		storage.addPersonalInfo("202020-1012321", "짱구");
		storage.addPersonalInfo("202020-2012321", "짱아");
		
		System.out.println(storage.searchName("202020-1012321"));
		System.out.println(storage.searchName("202020-2012321"));
		
	}
	
	
}
