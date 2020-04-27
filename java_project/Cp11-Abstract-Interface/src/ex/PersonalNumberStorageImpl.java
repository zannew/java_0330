package ex;


//public class PersonalNumberStorageImpl extends PersonalNumberStorage {
public class PersonalNumberStorageImpl implements PersonalNumber {

	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	
	public PersonalNumberStorageImpl(int num) {
		perArr=new PersonalNumInfo[num];
		numOfPerInfo=0;
	}
	
	
	@Override
	public void addPersonalInfo(String perNum, String name) {
		perArr[numOfPerInfo]=new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}

	@Override
	public String searchName(String perNum) {
		for(int i=0;i<numOfPerInfo;i++) {
			if(perArr[i].getNumber().equals(perNum)) {
				return perArr[i].getName();
			}
		}
		return null;
	}

}
