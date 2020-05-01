package ex;

public class LinkedTest {
public static void main(String[] args) {
	
	String str1 = "one";
	String str2 = "two";
	String str3 = "three";
	String str4 = "four";
	String str5 = "five";
	
	Data d1 = new Data(str1, str2);

	
	Data d2 = new Data(str2, str3);
	Data d3 = new Data(str3, str4);
	Data d4 = new Data(str4, null);

	//중간에 삽입
	
	Data d5 = new Data("five",str2);
	d1.setNextValue(str5);
	
	
	
	
}
}
class Data{
	
	Object value;
	Object nextAddrValue;
	
	Data(Object obj, Object nextValue){
		this.value=obj;
		this.nextAddrValue=nextValue;
	}
	
	Object getValue() {
		return value;
	}
	
	void setNextValue(Object nextValue) {
		this.nextAddrValue=nextValue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}