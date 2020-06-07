package phoneBook_ver_7_3;

import java.sql.Date;

public class AllDTO {

	private int pidx;
	private String name;
	private String phoneNum;
	private String addr;
	private String email;
	private String fr_type;
	private Date regdate;
	
	
//	private int pidx;
	private String major;
	private int grade;
	private int univ_ref;
	
	
//	private int pidx;
	private String comName;
	private String dname;
	private String comJob;
	private int com_ref;
	
	
	
	//default constructor
	AllDTO(){}
	
	//constructor-basic
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
	}
	
	
	
	//constructor-univ
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate,
			String major, int grade, int univ_ref) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
		this.major = major;
		this.grade = grade;
		this.univ_ref=univ_ref;
	}
	
	//constructor-com
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate,
			String comName, String dname, String comJob, int com_ref) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
		this.comName = comName;
		this.dname = dname;
		this.comJob = comJob;
		this.com_ref = com_ref;
	}
	
	//constructor-entire(without fr_ref)
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate,
			String major, int grade, String comName, String dname, String comJob) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
		this.major = major;
		this.grade = grade;
		this.comName = comName;
		this.dname = dname;
		this.comJob = comJob;
	}
	//constructor-entire
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate,
			String major, int grade, int univ_ref, String comName, String dname, String comJob, int com_ref) {
		this.pidx = pidx;
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.fr_type = fr_type;
		this.regdate = regdate;
		this.major = major;
		this.grade = grade;
		this.univ_ref = univ_ref;
		this.comName = comName;
		this.dname = dname;
		this.comJob = comJob;
		this.com_ref = com_ref;
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

	public String getMajor() {
		return major;
	}

	public int getGrade() {
		return grade;
	}

	public int getUniv_ref() {
		return univ_ref;
	}
	
	public String getComName() {
		return comName;
	}

	public String getDname() {
		return dname;
	}

	public String getComJob() {
		return comJob;
	}


	public int getCom_ref() {
		return com_ref;
	}
	
	
	
	
	
	
	
}
