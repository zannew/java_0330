package phonebook_ver_7_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import phoneNumBook_ver_6_2_submit.PhonebookManager;

public class PhoneInfo {

	
	private static int pbidx;
	private String pbname;
	private String pbNumber;
	private String pbaddr;
	private String pbmail;
	private String pbmajor;
	private int pbgrade;
	private String pbcomName;
	private String PBType;
//	private String dept;
//	private String cafeName;
//	private String nickName;
	
	
	

	
	//생성자
	PhoneInfo(int pbidx, String pbname, String pbNumber, String pbaddr, String pbmail
					, String pbmajor, int pbgrade, String pbcomName, String PBType) {
		this.pbidx = pbidx;
		this.pbname = pbname;
		this.pbNumber = pbNumber;
		this.pbaddr = pbaddr;
		this.pbmail = pbmail;
		this.pbmajor = pbmajor;
		this.pbgrade = pbgrade;		this.pbcomName = pbcomName;
		this.PBType = PBType;
		
		
	}

	
	
	void showBasicInfo() {
		System.out.println("-----친구 정보-----");
		System.out.println("등록번호 : "+this.pbidx);
		System.out.println("이름: "+this.pbname);
		System.out.println("전화번호: "+this.pbNumber);
		System.out.println("주소: "+this.pbaddr);
		System.out.println("이메일: "+this.pbmail);
		System.out.println("전공 : "+this.pbmajor);
		System.out.println("학년 : "+this.pbgrade);
		System.out.println("회사 : "+this.pbcomName);
		System.out.println("폰북타입 : "+this.PBType);
//		System.out.println("부서 : "+this.dept);
//		System.out.println("카페명 : "+this.cafeName);
//		System.out.println("닉네임 : "+this.nickName);
	
	}
	

	//Getter
	
	public static int getPbidx(String searchName) {
		
		pbidx=Dao_PhoneInfo.searchPbidx(searchName);
		
		return pbidx;
	}
	
	public String getPbname() {
		return pbname;
	}
	

	public String getPbNumber() {
		return pbNumber;
	}
	
	
	
	public String getPbaddr() {
		return pbaddr;
	}
	
	
	
	public String getPbmail() {
		return pbmail;
	}
	
	
	
	public String getPbmajor() {
		return pbmajor;
	}
	
	
	
	public int getPbgrade() {
		return pbgrade;
	}
	
	
	
	public String getPbcomName() {
		return pbcomName;
	}
	
	
	
	public String getPBType() {
		return PBType;
	}
	
//
//	public String getDept() {
//		return dept;
//	}
//
//	public String getCafeName() {
//		return cafeName;
//	}
//
//	public String getNickName() {
//		return nickName;
//	}


	//Setter


	public void setPbidx(int pbidx) {
		this.pbidx = pbidx;
	}


	
	
	
	public void setPbname(String pbname) {
		this.pbname = pbname;
	}



	public void setPbNumber(String pbNumber) {
		this.pbNumber = pbNumber;
	}



	public void setPbaddr(String pbaddr) {
		this.pbaddr = pbaddr;
	}



	public void setPbmail(String pbmail) {
		this.pbmail = pbmail;
	}



	public void setPbmajor(String pbmajor) {
		this.pbmajor = pbmajor;
	}



	public void setPbgrade(int pbgrade) {
		this.pbgrade = pbgrade;
	}



	public void setPbcomName(String pbcomName) {
		this.pbcomName = pbcomName;
	}
	
	
	public void setPBType(String pBType) {
		PBType = pBType;
	}

	
//
//
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//
//
//
//	public void setCafeName(String cafeName) {
//		this.cafeName = cafeName;
//	}
//
//
//
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}










	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.pbname.equals(name);
	}
}	
	
	
