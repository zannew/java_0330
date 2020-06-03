package phonebook_ver_7_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import phoneNumBook_ver_6_2_submit.PhonebookManager;
//DTO
public class PhoneInfo {

	
	
	
	private int pbidx;
	private String pbname;
	private String pbNumber;
	private String pbaddr;
	private String pbmail;
	private String pbmajor;
	private int pbgrade;
	private String pbcomName;
	private String pbComDept;
	private String pbComJob;
	private String pbcafeName;
	private String pbNickName;
	private String PBType;
	
	//default생성자
	PhoneInfo(){}
	
	
	
	//생성자(학교)
	PhoneInfo(int pbidx, String pbname, String pbNumber, String pbaddr, String pbmail, String pbtype, String pbmajor, int pbgrade){
		this.pbidx = pbidx;
		this.pbname = pbname;
		this.pbNumber = pbNumber;
		this.pbaddr = pbaddr;
		this.pbmail = pbmail;
		this.PBType = pbtype;
		this.pbmajor = pbmajor;
		this.pbgrade = pbgrade;
	}

	//생성자(회사)
	PhoneInfo(int pbidx, String pbname, String pbNumber, String pbaddr, String pbmail, String pbtype, String pbcomname,String pbcomdept, String pbcomjob){
		this.pbidx = pbidx;
		this.pbname = pbname;
		this.pbNumber = pbNumber;
		this.pbaddr = pbaddr;
		this.pbmail = pbmail;
		this.PBType = pbtype;
		this.pbcomName=pbcomname;
		this.pbComDept=pbcomdept;
		this.pbComJob=pbcomjob;
		
	}
	
	//생성자(동호회)
	PhoneInfo(int pbidx, String pbname, String pbNumber, String pbaddr, String pbmail, String pbtype, String pbcafename, String pbnickname){
		this.pbidx = pbidx;
		this.pbname = pbname;
		this.pbNumber = pbNumber;
		this.pbaddr = pbaddr;
		this.pbmail = pbmail;
		this.PBType = pbtype;
		this.pbcafeName=pbcafename;
		this.pbNickName=pbnickname;
	}
	
	
	//생성자(전체)
	PhoneInfo(int pbidx, String pbname, String pbNumber, String pbaddr, String pbmail, String PBType
					, String pbmajor, int pbgrade, String pbcomName, String pbcomdept, String pbcomjob
					, String pbcafename, String pbnickname) {
		this.pbidx = pbidx;
		this.pbname = pbname;
		this.pbNumber = pbNumber;
		this.pbaddr = pbaddr;
		this.pbmail = pbmail;
		this.PBType = PBType;
		this.pbmajor = pbmajor;		this.pbgrade = pbgrade;
		this.pbcomName = pbcomName;
		this.pbComDept = pbcomdept;
		this.pbComJob = pbcomjob;
		this.pbcafeName = pbcafename;
		this.pbNickName = pbnickname;
		
		
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
	
	public int getPbidx() {
		
//		pbidx=Dao_PhoneInfo.searchPbidx(searchName);
		
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
	
	public String getPBType() {
		return PBType;
	}
	
	
//	public String getPBType(int choice) {
//		
//		if(choice==1) {
//			PBType="com";
//		}else if(choice==2) {
//			PBType="univ";
//		}else if(choice==3) {
//			PBType="cafe";
//		}
//		
//		return PBType;
//	}
	
	public String getPbmajor() {
		return pbmajor;
	}
	
	
//	다른타입일때 디폴트값 1인거 처리해야됨..
	public int getPbgrade() {
		
		return pbgrade==0 ? 1:pbgrade;
	}
	
	
	
	public String getPbcomName() {
		return pbcomName;
	}
	
	
	
	
	public String getPbComDept() {
		return pbComDept;
	}

	public String getPbComJob() {
		return pbComJob;
	}

	public String getPbcafeName() {
		return pbcafeName;
	}

	public String getPbNickName() {
		return pbNickName;
	}

	
	
	


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


	
	public void setPBType(String pBType) {
		PBType = pBType;
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
	

	public void setPbComDept(String pbComDept) {
		this.pbComDept = pbComDept;
	}

	public void setPbComJob(String pbComJob) {
		this.pbComJob = pbComJob;
	}

	public void setPbcafeName(String pbcafeName) {
		this.pbcafeName = pbcafeName;
	}

	public void setPbNickName(String pbNickName) {
		this.pbNickName = pbNickName;
	}

	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.pbname.equals(name);
	}
}	
	
	
