package phoneNumBook;


public class PhoneInfor_Store {

	static String[] personInfo = new String[100];		//배열 선언과 생성
	PhoneInfor infor = new PhoneInfor(name, phoneNum, bDay);

	
			
			
			for(int i=0; i<personInfo.length;i++) {
				if(personInfo[i]==null) {
					personInfo[i]=infor.input_Info();
					
				}
			
			}
			return personInfo[i];
		}
	
	
	
	
	
	//정보 저장 메서드
//			void store_Info() {
//			
//			for(int i=0;i<personInfo.length;i++) {
//				personInfo[i] = ;
//			}
//			
//			}
//	
	
	
	
}
