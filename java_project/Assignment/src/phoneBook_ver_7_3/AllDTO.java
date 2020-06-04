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
//	private int fr_ref;
	
	
//	private int pidx;
	private String comName;
	private String dname;
	private String comJob;
//	private int fr_ref;
	
	
	
	//default constructor
	AllDTO(){}
	
	//constructor
	AllDTO(int pidx, String name, String phoneNum, String addr, String email, String fr_type, Date regdate,
			String major, int grade, String comName, String dname, String comJob) {
		super();
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

	public String getComName() {
		return comName;
	}

	public String getDname() {
		return dname;
	}

	public String getComJob() {
		return comJob;
	}
	
	
	
	
	
	
	
}
