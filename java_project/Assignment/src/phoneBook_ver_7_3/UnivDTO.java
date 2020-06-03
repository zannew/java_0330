package phoneBook_ver_7_3;

public class UnivDTO {

	
	private int pidx;
	private String major;
	private int grade;
	private int fr_ref;
	
	
	UnivDTO(){}

	//생성자(학교)
	public UnivDTO(int pidx, String major, int grade, int fr_ref) {
		this.pidx = pidx;
		this.major = major;
		this.grade = grade;
		this.fr_ref = fr_ref;
	}

	
	//GETTER
	public int getPidx() {
		return pidx;
	}

	public String getMajor() {
		return major;
	}

	public int getGrade() {
		return grade;
	}

	public int getFr_ref() {
		return fr_ref;
	}
	



	
	


	
	
	
	
}
