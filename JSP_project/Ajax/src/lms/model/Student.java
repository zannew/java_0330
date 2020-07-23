package lms.model;


//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!


// 학생 DTO (Model) 담당 : 김승연
// 				    작업 일시 : 2020. 07. 21

public class Student {

	private int sIdx;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String major;
	private int grade;
	

	public Student(int sIdx, String pw, String name, String tel, String email, String major, int grade) {

		this.sIdx = sIdx;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.major = major;
		this.grade = grade;
	}
	
	public Student() {
		
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [sIdx=" + sIdx + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", major=" + major + ", grade=" + grade + "]";
	}
	
	
	
}