package phoneBook_ver_7_3;

import java.sql.Date;

public class BasicDTO {

	private int pidx;
	private String name;
	private String phoneNum;
	private String addr;
	private String email;
	private String fr_type;
	private Date regdate;
//	private String major;
//	private int year;
//	private String comName;
//	private String deptName;
//	private String job;
	
	//디폴트 생성자
	BasicDTO(){}
	
	
	//생성자(전체)
	public BasicDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
	}

	//GETTER
	public int getPidx() {
		return pidx;
	}


	public String getName() {
		return name;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public String getAddr() {
		return addr;
	}


	public String getEmail() {
		return email;
	}


	public String getFr_type() {
		return fr_type;
	}


	public Date getRegdate() {
		return regdate;
	}

	



		
		
	
}
